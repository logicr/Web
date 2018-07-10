package culb.logicr.mybatisTest;

import club.logicr.mybatis.common.BackGround;
import club.logicr.mybatis.entity.MemoInfo;
import club.logicr.mybatis.mapper.MemoInfoMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MemoInfoTest {
    /* 每个基于MyBatis的应用都是以一个SqlSessionFactory的实例为中心的。SqlSessionFactory 的实例可以通过
SqlSessionFactoryBuilder 获得。而 SqlSessionFactoryBuilder 则可以从XML配置文件或一个预先定制的
Configuration的实例构建出 SqlSessionFactory 的实例。 */
    private static SqlSessionFactory sqlSessionFactory;
   private  final org.slf4j.Logger logger = LoggerFactory.getLogger(MemoInfoTest.class);
    static {
        try {
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(
                    Resources.getResourceAsStream(
                            "mybatis-config.xml"
                    )
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test_insertMemoIfo(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        MemoInfo memoInfo = new MemoInfo();
        memoInfo.setGroupId(2);
        memoInfo.setTitle("CSS");
        memoInfo.setContent("CSS In Action");
        memoInfo.setPrivacy('0');
        memoInfo.setBackGround(BackGround.WHITE);
        memoInfo.setRemind('1');
        memoInfo.setRemindTime(new Date());
        memoInfo.setCreatedTime(new Date());
        int effect = memoInfoMapper.insertMemoInfo(memoInfo);
        System.out.println(effect);
        sqlSession.close();
    }
    @Test
    public  void test_selectMemoinfoAll(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> list2 =  memoInfoMapper.queryMemoInfoAll();
        logger.debug("{}",memoInfoMapper);
        sqlSession.close();

        /*线程等待*/
//        try {
//            Thread.sleep(2);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        SqlSession sqlSession1 = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper1 = sqlSession1.getMapper(MemoInfoMapper.class);
        memoInfoMapper1.queryMemoInfoAll();
        logger.debug("{}",memoInfoMapper1);

        SqlSession sqlSession3 = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper3 = sqlSession1.getMapper(MemoInfoMapper.class);
        memoInfoMapper1.queryMemoInfoAll();
        logger.debug("{}",memoInfoMapper3);

        SqlSession sqlSession4 = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper4 = sqlSession1.getMapper(MemoInfoMapper.class);
        memoInfoMapper1.queryMemoInfoAll();
        logger.debug("{}",memoInfoMapper4);


    }

    @Test
    public void queryTitleAndPrivacy(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> list = memoInfoMapper.queryTitleAndPrivacy(

                "CSS",
                "0"
        );
        logger.info("current result{}",list);
    }
    @Test
    public void queryCreateTime(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
//        LocalDateTime localDateTime = LocalDateTime.of(2018,)
        List<MemoInfo> list = memoInfoMapper.queryCreateTime(
                LocalDateTime.of(2018,01,01,01,01,01,01),
                LocalDateTime.of(2018,8,8,01,01,01,01)
        );
        logger.info("current result{}",list);
        sqlSession.close();
    }

    @Test
    public void queryTitleOrContent(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<MemoInfo> list = memoInfoMapper.queryTitleOrContent(
                "Mysql",
                "Java Best"
        );
        logger.info("current title or content is {}",list);
        sqlSession.close();
    }

    @Test
    public void queryIdInList(){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        MemoInfoMapper memoInfoMapper = sqlSession.getMapper(MemoInfoMapper.class);
        List<Integer> info = new ArrayList<>();
        info.add(2);
        info.add(3);
        List<MemoInfo> list = memoInfoMapper.queryIdInList(
                info
        );
        logger.info("In id {}",list);
        sqlSession.close();
    }
}
