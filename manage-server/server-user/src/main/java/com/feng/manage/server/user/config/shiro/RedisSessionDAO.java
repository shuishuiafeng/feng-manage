package com.feng.manage.server.user.config.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.UnknownSessionException;
import org.apache.shiro.session.mgt.SimpleSession;
import org.apache.shiro.session.mgt.eis.AbstractSessionDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.concurrent.TimeUnit;

/**
 * @Author: Xiaofeng
 * @Date: 2019/7/9 14:09
 * @Description:
 */
@Slf4j
public class RedisSessionDAO extends AbstractSessionDAO {

    private static String SESSION_PREFIX = "FF_SESSION:";

    @Autowired
    private RedisTemplate redisTemplate;

    @Override
    protected Serializable doCreate(Session session) {
        Serializable sessionId = super.generateSessionId(session);
        //将sessionId分配给session
        assignSessionId(session, sessionId);
        try {
            saveSession(sessionId, session, session.getTimeout());
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }
        return sessionId;
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        try {
            return getSession(sessionId);
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }
        return null;
    }

    @Override
    public void update(Session session) throws UnknownSessionException {
        try {
            saveSession(session.getId(), session, session.getTimeout());
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }
    }

    @Override
    public void delete(Session session) {
        try {
            redisTemplate.delete(getSessionRedisKey(session.getId()));
        } catch (Exception e) {
            log.info(e.getMessage(), e);
        }
    }

    @Override
    public Collection<Session> getActiveSessions() {
        log.info("获取存活的session");
        return Collections.emptySet();
    }

    private void saveSession(Serializable sessionId, Session session, Long timeout) {
        if (timeout != null) {
            redisTemplate.opsForValue().set(getSessionRedisKey(sessionId), session, timeout, TimeUnit.MILLISECONDS);
        } else {
            redisTemplate.opsForValue().set(getSessionRedisKey(sessionId), session);
        }
    }

    private String getSessionRedisKey(Serializable sessionId) {
        return SESSION_PREFIX + sessionId.toString();
    }

    private Session getSession(Serializable sessionId) {
        String key = getSessionRedisKey(sessionId);
        return (SimpleSession) redisTemplate.opsForValue().get(key);
    }
}
