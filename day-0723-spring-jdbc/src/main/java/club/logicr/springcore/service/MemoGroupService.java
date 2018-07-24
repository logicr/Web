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

    /**
     * 创建便签组
     * @param memoGroup
     * @return
     */
    boolean addMemoGroup(MemoGroup memoGroup);

    /**
     * 更新便签组
     * @param id
     * @param name
     * @return
     */
    boolean updateMemoGroup(int id,String name);

    /**
     * 删除便签组
     * @param id
     * @return
     */
    boolean deleteMemoGroup(int id);

}
