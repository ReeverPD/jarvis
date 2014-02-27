package com.eventhorizon.jarvis.test;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.naming.spi.InitialContextFactory;

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

public class JarvisBaseTest {

	protected void setUpJNDI() {
		try {
			// Create initial context
            System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
			System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
			
//			System.setProperty(Context.INITIAL_CONTEXT_FACTORY, InitialContextFactory.class.getName());
            InitialContext ic = new InitialContext();

            ic.createSubcontext("java:");
            ic.createSubcontext("java:/comp");
            ic.createSubcontext("java:/comp/env");
            ic.createSubcontext("java:/comp/env/jdbc");

            MysqlDataSource ds = new MysqlDataSource();
            ds.setServerName("localhost");
            ds.setPort(3306);
            ds.setDatabaseName("jarvis_dev");
            ds.setUser("glassfish");
            ds.setPassword("133159Iuri");
            
            
//            JdbcConnectionPool ds = JdbcConnectionPool.create(
//                    "jdbc:h2:file:src/main/resources/test.db;FILE_LOCK=NO;MVCC=TRUE;DB_CLOSE_ON_EXIT=TRUE", "sa", "sasasa");
            // Construct DataSource
            // OracleConnectionPoolDataSource ds = new
            // OracleConnectionPoolDataSource();
            // ds.setURL("jdbc:oracle:thin:@host:port:db");
            // ds.setUser("MY_USER_NAME");
            // ds.setPassword("MY_USER_PASSWORD");

            ic.bind("java:Jarvis-ds", ds);
            ic.lookup("Jarvis-ds");
		}catch(NamingException ex) {
			System.out.println("Erro ao iniciar JNDI para testes"+ex.getMessage());
		}
	}
	
}
