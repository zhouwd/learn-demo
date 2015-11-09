package com.joe.learn.mybatis.plugin;


import java.sql.Connection;
import java.util.Properties;

import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.factory.DefaultObjectFactory;
import org.apache.ibatis.reflection.factory.ObjectFactory;
import org.apache.ibatis.reflection.wrapper.DefaultObjectWrapperFactory;
import org.apache.ibatis.reflection.wrapper.ObjectWrapperFactory;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Intercepts(@Signature(type = StatementHandler.class,method = "prepare",args = {Connection.class}))
public class ExamplePlugin implements Interceptor {

	private final Logger logger = LoggerFactory.getLogger(ExamplePlugin.class);

	private static final ObjectFactory OBJECT_FACTORY = new DefaultObjectFactory();

	private static final ObjectWrapperFactory OBJECT_WRAPPER_FACTORY = new DefaultObjectWrapperFactory();

	private Properties properties;

	@Override
	public Object intercept(Invocation invocation) throws Throwable {
		StatementHandler statementHandler= (StatementHandler) invocation.getTarget();
		MetaObject metaObject = MetaObject.forObject(statementHandler, OBJECT_FACTORY, OBJECT_WRAPPER_FACTORY);
		while(metaObject.hasGetter("h")) {
			Object object = metaObject.getValue("h");
			metaObject = MetaObject.forObject(object, OBJECT_FACTORY, OBJECT_WRAPPER_FACTORY);

		}

		while (metaObject.hasGetter("target")) {
			Object object = metaObject.getValue("target");
			metaObject = MetaObject.forObject(object, OBJECT_FACTORY, OBJECT_WRAPPER_FACTORY);

		}

		Configuration configuration = (Configuration) metaObject.getValue("delegate.configuration");
		MappedStatement mappedStatement = (MappedStatement) metaObject.getValue("delegate.mappedStatement");

		BoundSql boundSql = (BoundSql) metaObject.getValue("deltegate.boundSql");

		RowBounds rowBounds = (RowBounds) metaObject.getValue("delegate.rowBounds");

		preIntercept(metaObject, configuration, mappedStatement, boundSql, rowBounds);
		return invocation.proceed();
	}

	private void preIntercept(MetaObject metaObject, Configuration configuration, MappedStatement mappedStatement, BoundSql boundSql, RowBounds rowBounds) {
		//todo your want;
	}

	@Override
	public Object plugin(Object target) {
		if (target instanceof StatementHandler) {
			return Plugin.wrap(target, this);
		}else{
			return target;
		}
	}

	@Override
	public void setProperties(Properties properties) {
		this.properties=properties;
	}

	public Properties getProperties() {
		return properties;
	}
}
