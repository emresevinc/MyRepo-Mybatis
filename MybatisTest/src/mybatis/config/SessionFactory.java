package mybatis.config;

import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.type.JdbcType;
import org.apache.log4j.Logger;

public class SessionFactory {
	private static Logger logger = Logger.getLogger(SessionFactory.class);
	
	private static SqlSession session = null;
	
	static{
		String mapperXML = "mybatis/config/MapperConfig.xml";
		try {
			logger.info("Configuring SessionFactory with: "+mapperXML);
			
			Reader reader = Resources.getResourceAsReader(mapperXML);
			
			SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
			sqlSessionFactory.getConfiguration().setJdbcTypeForNull(JdbcType.NULL);
			reader.close();
			
			session = sqlSessionFactory.openSession();
			session.getConnection().setAutoCommit(true);
			
		} catch (Exception e) {
			throw new RuntimeException("MapperConfig.xml configuration error, IO Exception." + e, e);
		}
	}
	
	public static Object getSession(Class<?> clazz){
		return SessionFactory.getSqlSession().getMapper(clazz);
	}
	
	public static SqlSession getSqlSession() {
		if (session == null) {
			try {
				throw new Exception("SqlSession is null");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return session;
	}
}
