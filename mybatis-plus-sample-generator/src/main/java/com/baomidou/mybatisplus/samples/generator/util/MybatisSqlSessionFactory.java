
package com.baomidou.mybatisplus.samples.generator.util;



import java.io.IOException;

import java.io.Reader;



import org.apache.ibatis.io.Resources;

import org.apache.ibatis.session.SqlSession;

import org.apache.ibatis.session.SqlSessionFactory;

import org.apache.ibatis.session.SqlSessionFactoryBuilder;



public class MybatisSqlSessionFactory {

    // 配置文件

    private static final String RESOURCE = "config.xml";

    private static Reader reader = null;

    private static SqlSessionFactoryBuilder builder = null;

    private static SqlSessionFactory factory = null;

    // 可以在同一个线程范围内，共享一个对象

    private static ThreadLocal<SqlSession> threadLocal = new ThreadLocal<SqlSession>();



    // 静态代码块（类加载的时候执行一次）

    static {

        try {

            reader = Resources.getResourceAsReader(RESOURCE);

            builder = new SqlSessionFactoryBuilder();

            factory = builder.build(reader);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    public static SqlSession getMySqlSession() {

        // 从本地线程中获取session连接

        SqlSession sqlSession = threadLocal.get();

        // 连接为空则创建连接，并将该连接添加到本地线程中去

        if (sqlSession == null) {

            if (factory == null) {

                rebuildFactory();

            }

            sqlSession = factory.openSession();

        }

        threadLocal.set(sqlSession);

        return sqlSession;

    }



    // 创建工厂

    public static void rebuildFactory() {

        try {

            reader = Resources.getResourceAsReader(RESOURCE);

            builder = new SqlSessionFactoryBuilder();

            factory = builder.build(reader);

        } catch (IOException e) {

            e.printStackTrace();

        }

    }



    // 关闭连接

    public static void closeSqlSession() {

        SqlSession sqlSession = threadLocal.get();

        if (sqlSession != null) {

            // 关闭session

            sqlSession.close();

        }

        // 同时将本地线程中置为null（防止用户再次调用时出现空的session）

        threadLocal.set(null);

    }



}
