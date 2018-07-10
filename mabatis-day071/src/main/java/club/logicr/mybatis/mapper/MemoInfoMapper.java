package club.logicr.mybatis.mapper;

import club.logicr.mybatis.entity.MemoInfo;
import org.apache.ibatis.annotations.Param;

import java.lang.reflect.Array;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public interface MemoInfoMapper  {
    /**
     * @param memoInfo
     * @return
     */
    int insertMemoInfo(MemoInfo memoInfo);

    /**
     * @return
     */
    List<MemoInfo> queryMemoInfoAll();

    /**
     * @param title
     * @param privacy
     * @return
     */
    List<MemoInfo> queryTitleAndPrivacy(
            @Param("title") String title,
            @Param("privacy") String privacy
    );
    List<MemoInfo> queryCreateTime(
            @Param("startTime")LocalDateTime startTime,
            @Param("endTime")LocalDateTime endTime
            );
    List<MemoInfo> queryTitleOrContent(
            @Param("title") String title,
            @Param("content") String content
    );

    List<MemoInfo> queryIdInList(List list
//            @Param("List") List<Integer> list
    );
}
