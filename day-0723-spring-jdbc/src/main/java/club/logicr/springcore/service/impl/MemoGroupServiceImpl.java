package club.logicr.springcore.service.impl;

import club.logicr.springcore.dao.MemoGroupDao;
import club.logicr.springcore.entity.MemoGroup;
import club.logicr.springcore.service.MemoGroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 */
@Service
public class MemoGroupServiceImpl implements MemoGroupService {
    @Autowired
    private MemoGroupDao memoGroupDao;
    public MemoGroup queryMemoGroupDetil(int id) {
        if (1 >= id){
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
}
