package com.feng.manage.server.user.config.shiro;

import com.alibaba.druid.support.json.JSONUtils;
import com.feng.manage.common.result.enums.BaseBusinessExceptionCode;
import com.feng.manage.common.result.enums.BusinessCode;
import com.feng.manage.common.result.enums.ResultCode;
import com.feng.manage.common.result.helper.ResultHelper;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.AccessControlFilter;
import org.apache.shiro.web.util.WebUtils;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletResponse;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/11 14:38
 * @Description: 权限过滤器
 */
@Slf4j
public class PermissionAuthorizationFilter extends AccessControlFilter {

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
        log.info("PermissionAuthorizationFilter执行");
        Subject subject = getSubject(request, response);
        if(null != mappedValue){
            String[] value = (String[])mappedValue;
            for (String permission : value) {
                if(permission==null || "".equals(permission.trim())){
                    continue;
                }
                if(subject.isPermitted(permission)){
                    return true;
                }
            }
        }
        return false;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        Subject subject = getSubject(request, response);
        saveRequest(request);
        HttpServletResponse res = WebUtils.toHttp(response);
        res.setHeader("Content-Type", "application/json;charset=utf-8");
        if (null == subject.getPrincipal()) {//表示没有登录，返回登录提示
            res.getWriter().write("没有登录，请登录");
//            res.getWriter().write(JSONUtils.toJSONString(ResultHelper.buildFail("没有登录，请登录")));
        }else{
            res.getWriter().write("无权限访问");
//            res.getWriter().write(JSONUtils.toJSONString(ResultHelper.buildFail(ResultCode.REFUSE_SERVICE, BusinessCode.USER_AUTHENTICATION_FAIL,"无权限访问")));
        }
        return false;
    }

}
