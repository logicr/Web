package club.logicr.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;


public class MybatisApp {
    public static void main(String[] args) {
        try {
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(
                            Resources.getResourceAsStream("mybatis-config.xml")
                    );
            System.out.println(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
