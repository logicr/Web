package club.logicr.mybatis;

import club.logicr.mybatis.entity.MemoGroup;
import club.logicr.mybatis.mapper.MemoGroupMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.Log;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
//import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.logging.LogManager;


/**
 * @author Jan
 */
public class MybatisApp {


    private static SqlSessionFactory sqlSessionFactory;

    public static void buildSqlSessionFactoryWithXml() {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder()
                    .build(
                            Resources.getResourceAsStream("mybatis-config.xml")
                    );

            System.out.println(sqlSessionFactory);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
//        try {
//            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder()
//                    .build(
//                            Resources.getResourceAsStream("mybatis-config.xml")
//                    );
//            System.out.println(sqlSessionFactory);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        buildSqlSessionFactoryWithXml();
//        配置环境等
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
//        插入信息
//        MemoGroup memoGroup = new MemoGroup();
//        memoGroup.setName("Mybatis2");
//        memoGroup.setCreatedTime(new Date());
//        int effect= sqlSession.insert("club.logicr.mybatis.mapper.MemoGroupMapper.insertMemoGroup", memoGroup);
        MemoGroupMapper memoGroupMapper = sqlSession.getMapper(MemoGroupMapper.class);
//        int effect = memoGroupMapper.insertMemoGroup(memoGroup);
//        System.out.println(effect);
        MemoGroup memoGroup = new MemoGroup();
//        memoGroup.getId();
//        memoGroup.getCreatedTime();
//        memoGroup.getModifyTime();
//        memoGroup.getName();
        List <MemoGroup> list = memoGroupMapper.selectMemoGroup(memoGroup);
        System.out.println(list.toString());
        sqlSession.close();

    }
}
