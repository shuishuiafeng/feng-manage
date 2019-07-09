package com.feng.manage.server.user.config.shiro;

import com.feng.manage.common.result.Result;
import com.feng.manage.common.result.enums.ResultCode;
import com.feng.manage.common.result.helper.ResultHelper;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 13:55
 * @Description: 自定义过滤器
 */
public class CustomerAuthFilter extends FormAuthenticationFilter {

    @Autowired
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                return executeLogin(request, response);
            } else {
                return true;
            }
        } else {
            Result result = ResultHelper.autoBuild(ResultCode.REFUSE_SERVICE);
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json");
            response.getWriter().write(result.toString());
            return false;
        }
    }

}
