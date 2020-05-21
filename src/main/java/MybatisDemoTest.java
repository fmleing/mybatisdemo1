import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MybatisDemoTest {
    public static void main(String[] args) {
        // 1, get the sqlSessionFactory object
        SqlSessionFactory sqlSessionFactory = getSqlSessionFactory();
        // 2, get the sqlSession object
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3, get the implementation class object of the interface
            // Will automatically create a proxy object for the interface, the proxy object to perform the addition, deletion and change method
            EmployeeMapper mapper = openSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.getEmpById(1);
            System.out.println(mapper);
            System.out.println(employee);
        } finally {
            openSession.close();
        }

    }

    public static SqlSessionFactory getSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        return new SqlSessionFactoryBuilder().build(inputStream);
    }

}
