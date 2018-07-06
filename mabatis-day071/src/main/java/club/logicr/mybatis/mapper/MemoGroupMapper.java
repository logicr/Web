package club.logicr.mybatis.mapper;

import club.logicr.mybatis.entity.MemoGroup;

import java.util.List;


/**
 * @author Jan
 * 接口,对数据库的操作
 */
public interface  MemoGroupMapper {
    /**
     * @param memoGroup
     * @return 修改的数据的行数
     */
    int insertMemoGroup(MemoGroup memoGroup);

    /**
     * @param memoGroup
     * @return 返回的是一个list，里面装的是memogroup memogroup里面装的是查询结果
     */
    List <MemoGroup> selectMemoGroup(MemoGroup memoGroup);
}

