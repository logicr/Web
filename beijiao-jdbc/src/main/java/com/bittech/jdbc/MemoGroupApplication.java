package com.bittech.jdbc;

import com.bittech.jdbc.dao.JdbcComponent;
import com.bittech.jdbc.dao.MemoGroupDao;
import com.bittech.jdbc.dao.impl.MemoGroupDaoImpl;
import com.bittech.jdbc.entity.MemoGroup;
import com.bittech.jdbc.service.MemoGroupService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Date;
import java.util.List;

/**
 * @author Jan
 */
public class MemoGroupApplication {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
        MemoGroupService memoGroupService = (MemoGroupService) context.getBean("memoGroupService");


        List<MemoGroup> memoGroupList = memoGroupService.queryMemoGroup(1);
        System.out.println(memoGroupList);
    }
    
//    private final MemoGroupDao memoGroupDao;
//
//
//    public MemoGroupApplication(MemoGroupDao memoGroupDao) {
//        this.memoGroupDao = memoGroupDao;
//    }
//
//
//    public void testInsertMemoGroup() {
//        MemoGroup memoGroup = new MemoGroup();
//        memoGroup.setName("JDBC");
//        memoGroup.setCreatedTime(new Date());
//        int effect = this.memoGroupDao.insertMemoGroup(memoGroup);
//        System.out.println("Test-Result : " + (effect == 1));
//    }
//
//    public void testUpdateMemoGroup() {
//        int effect = this.memoGroupDao.updateMemoGroup(4, "JDBC-P");
//        System.out.println("Test-Result : " + (effect == 1));
//    }
//
//    public void testQueryMemoGroupByCreatedTime() {
//        Date startTime = new Date();
//        Date endTime = new Date();
//        List<MemoGroup> memoGroups = this.memoGroupDao.queryMemoGroupByCreatedTime(startTime, endTime);
//        System.out.println(memoGroups);
//        System.out.println("Test-Result : " + !memoGroups.isEmpty());
//    }
//
//    public void testQueryMemoGroupById() {
//        List<MemoGroup> memoGroups = this.memoGroupDao.queryMemoGroupById(4);
//        System.out.println(memoGroups);
//        System.out.println("Test-Result : " + (memoGroups.size() == 1));
//    }
//
//    public void testDeleteMemoGroupById() {
//        int effect = this.memoGroupDao.deleteMemoGroupById(5);
//        System.out.println("Test-Result : " + (effect == 1));
//    }
//
//    public static void main(String[] args) {
//
//        JdbcComponent jdbcComponent = new JdbcComponent(
//                "com.mysql.jdbc.Driver",
//                "jdbc:mysql://localhost:3306/memo?user=root&password=root"
//        );
//        MemoGroupDao memoGroupDao = new MemoGroupDaoImpl(jdbcComponent);
//        MemoGroupApplication memoGroupApplication = new MemoGroupApplication(memoGroupDao);
//
////        memoGroupJdbcTest.testInsertMemoGroup();
//
////        memoGroupJdbcTest.testUpdateMemoGroup();
//
////        memoGroupJdbcTest.testQueryMemoGroupByCreatedTime();
//
////        memoGroupJdbcTest.testQueryMemoGroupById();
//
//        memoGroupApplication.testDeleteMemoGroupById();
//    }
}


