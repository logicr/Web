package com.bittech.jdbc.service;

import com.bittech.jdbc.dao.MemoGroupDao;
import com.bittech.jdbc.entity.MemoGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Jan on 2018/7/16.
 * @version 1.0
 */
@Service
public class MemoGroupService {
    @Autowired
    private MemoGroupDao memoGroupDao;
    public List<MemoGroup> queryMemoGroup(int id){
        return memoGroupDao.queryMemoGroupById(id);
    }
}
