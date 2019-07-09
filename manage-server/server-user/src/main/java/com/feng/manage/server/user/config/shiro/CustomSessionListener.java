package com.feng.manage.server.user.config.shiro;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 14:04
 * @Description:
 */
public class CustomSessionListener implements SessionListener {


    //活跃用户数量
    private AtomicInteger activeSessionCount = new AtomicInteger(0);

    /**
     * 会话开始触发
     *
     * @param session
     */
    @Override
    public void onStart(Session session) {
        activeSessionCount.incrementAndGet();
    }

    /**
     * 会话结束触发
     *
     * @param session
     */
    @Override
    public void onStop(Session session) {
        activeSessionCount.decrementAndGet();
    }

    /**
     * 会话过期出发
     *
     * @param session
     */
    @Override
    public void onExpiration(Session session) {
        activeSessionCount.decrementAndGet();
    }

    /**
     * 获取活跃用户数量
     *
     * @return
     */
    public Integer getActiveSessionCount() {
        return activeSessionCount.intValue();
    }
}
