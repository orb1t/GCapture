package com.gdit.capture.entity;
// Generated 13/10/2010 04:34:04 � by Hibernate Tools 3.2.0.beta7

import java.util.List;
import org.hibernate.LockMode;
import org.hibernate.criterion.Example;

/**
 * Home object for domain model class Category.
 * @see com.gdit.capture.entity.Category
 * @author Hibernate Tools
 */
import org.hibernate.Session;
import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.hibernate.cfg.Configuration;
import org.hibernate.Query;

public class ServerHome {

    public ServerHome() {
    }

    public static Session getSession() {
        Session session = (Session) ServerHome.session.get();
        if (session == null) {
            session = sessionFactory.openSession();
            ServerHome.session.set(session);
        }
        return session;
    }

    public void persist(Server transientInstance) {
        log.log(Level.WARNING, "persisting Category instance");
        try {
            begin();
            getSession().persist(transientInstance);
            log.log(Level.WARNING, "persist successful");
        } catch (RuntimeException re) {
            log.log(Level.WARNING, "persist failed", re);
            throw re;
        }
    }

    public List<Server> getAllServer() {
        Query q = getSession().createQuery("from Server");
        List<Server> list = (List<Server>) q.list();
        return list;
    }

    public void attachDirty(Server instance) {
        log.log(Level.WARNING, "attaching dirty Category instance");
        try {
            begin();
            getSession().saveOrUpdate(instance);
            log.log(Level.WARNING, "attach successful");
        } catch (RuntimeException re) {
            log.log(Level.WARNING, "attach failed", re);
            throw re;
        }
    }

    public void attachClean(Server instance) {
        log.log(Level.WARNING, "attaching clean Category instance");
        try {
            begin();
            getSession().lock(instance, LockMode.NONE);
            log.log(Level.WARNING, "attach successful");
        } catch (RuntimeException re) {
            log.log(Level.WARNING, "attach failed", re);
            throw re;
        }
    }

    public void delete(Server persistentInstance) {
        log.log(Level.WARNING, "deleting Category instance");
        try {
            begin();
            getSession().delete(persistentInstance);
            log.log(Level.WARNING, "delete successful");
        } catch (RuntimeException re) {
            log.log(Level.WARNING, "delete failed", re);
            throw re;
        }
    }

    public void begin() {
        getSession().beginTransaction();
    }

    public void commit() {
        getSession().getTransaction().commit();
    }

    public void rollback() {
        try {
            getSession().getTransaction().rollback();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot rollback", e);
        }

        try {
            getSession().close();
        } catch (HibernateException e) {
            log.log(Level.WARNING, "Cannot close", e);
        }
        ServerHome.session.set(null);
    }

    public static void close() {
        getSession().close();
        ServerHome.session.set(null);
    }
    private static final Logger log = Logger.getAnonymousLogger();
    private static final ThreadLocal<Session> session = new ThreadLocal<Session>();
    private static final SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

    public Server merge(Category detachedInstance) {
        log.log(Level.WARNING, "merging Category instance");
        try {
            Server result = (Server) sessionFactory.getCurrentSession().merge(detachedInstance);
            log.log(Level.WARNING, "merge successful");
            return result;
        } catch (RuntimeException re) {
            log.log(Level.WARNING, "merge failed", re);
            throw re;
        }
    }

    public Server findById(long id) {
        log.log(Level.WARNING, "getting Server instance with id: " + id);
        try {
            begin();
            Server instance = (Server) getSession().get("com.gdit.capture.entity.Server", id);
            if (instance == null) {
                log.log(Level.WARNING, "get successful, no instance found");
            } else {
                log.log(Level.WARNING, "get successful, instance found");
            }
            return instance;
        } catch (RuntimeException re) {
            log.log(Level.WARNING, "get failed", re);
            throw re;
        }
    }

    public List findByExample(Server instance) {
        log.log(Level.WARNING, "finding Server instance by example");
        try {
            List results = sessionFactory.getCurrentSession().createCriteria("com.gdit.capture.entity.Server").add(Example.create(instance)).list();
            log.log(Level.WARNING, "find by example successful, result size: " + results.size());
            return results;
        } catch (RuntimeException re) {
            log.log(Level.WARNING, "find by example failed", re);
            throw re;
        }
    }
}
