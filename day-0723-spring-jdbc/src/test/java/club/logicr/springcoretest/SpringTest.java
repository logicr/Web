package club.logicr.springcoretest;

import club.logicr.springcore.entity.MemoGroup;
import club.logicr.springcore.service.MemoGroupService;
import club.logicr.springcore.service.impl.MemoGroupServiceImpl;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 */
public class SpringTest {
    private static  ApplicationContext context2;

    private static MemoGroupService memoGroupService;

    private static Logger logger = LoggerFactory.getLogger(SpringTest.class);

    @BeforeClass
    public  static  void  beforeClass(){
        context2 = new ClassPathXmlApplicationContext("application-context2.xml");
        memoGroupService = context2.getBean(MemoGroupService.class);
    }

    @Test
    public void test_creatMemoGroup(){
        MemoGroup memoGroup = new MemoGroup();
        memoGroup.setName("Boot1");
        memoGroup.setCreatedTime(new Date());
        boolean ret = memoGroupService.addMemoGroup(memoGroup);
        Assert.assertTrue(ret);
    }

    @Test
    public void test_queryMemoGroupDetail(){
        MemoGroup memoGroup = memoGroupService.queryMemoGroupDetil(1);
        Assert.assertNotNull(memoGroup);
        logger.debug("query memGroup detail id = {} value = {}",1,memoGroup);
    }
    @Test
    public void test_updateMemoGroup(){
        boolean ret = memoGroupService.updateMemoGroup(100,"Boot22");
        logger.debug("updateMemoGroup success = {}",ret);
    }

    @Test
    public void test_deleteMemoGroup(){
        boolean ret = memoGroupService.deleteMemoGroup(100);
        logger.debug("updateMemoGroup success = {}",ret);
    }

    @Test
    public void test(){
//
        ApplicationContext context = new ClassPathXmlApplicationContext(
                "application-context2.xml"
        );
//        用接口和实例类都可以的
//        MemoGroupServiceImpl memoGroupService = (MemoGroupServiceImpl) context.getBean(MemoGroupServiceImpl.class);
        MemoGroupService memoGroupService = (MemoGroupService) context.getBean(MemoGroupService.class);
        MemoGroup memoGroup = memoGroupService.queryMemoGroupDetil(1);
        System.out.println(memoGroup);
    }



//    @BeforeClass
//    创建容器
}
