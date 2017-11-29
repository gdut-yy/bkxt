package db;

import java.sql.Connection;
import java.sql.SQLException;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class ConnectionFactory {
	private ConnectionFactory() {
	}

	/**
	 * ͨ��web.xml��JNDIname�������ô�������
	 * 
	 * @return
	 */
	public static Connection getConnection() {
		try {
			String JNDIname = (String) new javax.naming.InitialContext().lookup("java:comp/env/JNDIname");
			return ConnectionFactory.getConnection(JNDIname);
		} catch (NamingException e) {
			System.out.print("���ݿ�δ���������ӳ�δ���ã�");
		}
		return null;
	}

	/**
	 * ͨ��ָ����JNDI���ƻ�ȡ���ݿ�����,��JDBC/SURVEY
	 * 
	 * @param JNDIname
	 * @return Connection
	 */
	public static Connection getConnection(String JNDIname) {
		try {
			Context initCtx = new InitialContext();
			Context envCtx = (Context) initCtx.lookup("java:comp/env");
			DataSource ds = (DataSource) envCtx.lookup(JNDIname);
			return ds.getConnection();
		} catch (NamingException e1) {
			System.out.print("���ݿ�δ���������ӳ�δ���ã�");
			return null;
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
}
