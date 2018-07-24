package club.logicr.springcore.service.impl;

import club.logicr.springcore.dao.MemoGroupDao;
import club.logicr.springcore.entity.MemoGroup;
import club.logicr.springcore.service.MemoGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 * 在服务层对数据进行严格的校验，让DAO的操作更加纯粹
 * StringUtils spring的工具类
 */
@Service
@Transactional
public class MemoGroupServiceImpl implements MemoGroupService {
    @Autowired
    private MemoGroupDao memoGroupDao;

    /**
     * 查询便签
     * @param id
     * @return
     */
    public MemoGroup queryMemoGroupDetil(int id) {
        if (0 > id){
            return null;
        }
        List<MemoGroup> memoGroupList = memoGroupDao.queryMemoGroup(id);
        if(memoGroupList.isEmpty()){
            throw new IllegalArgumentException();
        }
        if(memoGroupList.size()>1){
            throw new RuntimeException();
        }
        return memoGroupList.get(0);
    }
    /**
     *添加便签组
     *
     */
    public boolean addMemoGroup(MemoGroup memoGroup){
        if (null == memoGroup){
            throw new IllegalArgumentException("MemoGroup rarguments error");
        }
        if (StringUtils.isEmpty(memoGroup.getName()) || StringUtils.isEmpty(memoGroup.getCreatedTime())){
            throw new IllegalArgumentException("MemoGroup argument error");
        }
        int count = memoGroupDao.queryMemoGroupByNameCount(memoGroup.getName());
        if (count > 0){
            throw new RuntimeException("MemoGroup name already exits");
        }else {
            int effect = memoGroupDao.insetMemoGroup(memoGroup);
            /**
             * 测试事务的
             */
//            int effect1 = memoGroupDao.insetMemoGroup(memoGroup);
            return effect == 1;
        }
    }

    /**
     * 修改便签组
     * 要求：名字是否存在
     * @param id
     * @param name
     * @return
     */
    public boolean updateMemoGroup(int id, String name) {
        int count = memoGroupDao.queryMemoGroupByNameCount(name);
        if (count == 0) {
            throw new RuntimeException("MemoGroup "+name+" not exits");
        } else {
            int effect = memoGroupDao.updateMemoGroup(id, name);
            if (0 == effect){
                throw new RuntimeException("update defeated");
            }
            return true;
        }
    }

    /**
     * 删除便签组
     * 要求：便签组是否存在，如果有，把便签移动到默认组
     * 禁止删除默认组
     * @param id
     * @return
     */
    public boolean deleteMemoGroup(int id) {
        if(1 == id){
            throw new RuntimeException("Can't delete default MemoGroup!");
        }
        List<MemoGroup> memoGroupList = memoGroupDao.queryMemoGroup(id);
        if(memoGroupList.isEmpty()){
            throw new IllegalArgumentException("id not exist");
        }
        int effect = memoGroupDao.updateMemoGroupDefault(id);
        if (0 != effect){
            return false;
        }
        return true;
    }
}
