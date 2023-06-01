package org.max.demo;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.List;

public class HibernateTest {

    private static SessionFactory ourSessionFactory;

    @BeforeAll
    static void init() {
        try {
            Configuration configuration = new Configuration();
            configuration.configure();

            ourSessionFactory = configuration.buildSessionFactory();
        } catch (Throwable ex) {
            throw new ExceptionInInitializerError(ex);
        }
    }

    public static Session getSession() throws HibernateException {
        return ourSessionFactory.openSession();
    }

    @Test
    void test() {
        final Query query = getSession().createQuery("from " + "EmployeeEntity");
        System.out.println("executing: " + query.getQueryString());

        List<EmployeeEntity> employeeEntities = query.list();
        for (EmployeeEntity entity : employeeEntities) {
            System.out.println("  " + entity);
            System.out.println("  " + entity.getName());
        }
    }

    @Test
    void test2() {
        final Query query = getSession().createSQLQuery("select * from employee").addEntity(EmployeeEntity.class);
        System.out.println("executing: " + query.getQueryString());
        List<EmployeeEntity> employeeEntities = query.list();
        for (EmployeeEntity entity : employeeEntities) {
            System.out.println("  " + entity);
            System.out.println("  " + entity.getName());
        }
    }

    @Test
    void test3() {
        String sql = "select name, capacity from employee";
        Query query = getSession().createSQLQuery(sql);

        List<Object[]> rows = query.list();

        for(Object[] row : rows) {
            System.out.println(row[0].toString());
            System.out.println(row[1].toString());
        }
    }

    @AfterAll
    static void close() {
        getSession().close();
    }

}
