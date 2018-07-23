package club.logicr.springcore.service;

import club.logicr.springcore.entity.MemoGroup;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 */
public interface MemoGroupService {
    /**
     * 根据id查询
     * @param id
     * @return MemoGroup
     */
    MemoGroup queryMemoGroupDetil(int id);
}
