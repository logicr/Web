package club.logicr.springcore.dao.impl;

import club.logicr.springcore.dao.MemoGroupDao;
import club.logicr.springcore.entity.MemoGroup;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 */
@Repository
public class MemoGroupImpl implements MemoGroupDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;
    public int insetMemoGroup(MemoGroup memoGroup) {
        return 0;
    }

    public int queryMemoGroupByNameCount(String name) {
        return 0;
    }

    public int updateMemoGroup(int id, String name) {
        return 0;
    }

    public List<MemoGroup> queryMemoGroup(int id) {
        String sql = "select id, name, created_time, modify_time from memo_group where ?";
        List<MemoGroup> memoGroups = jdbcTemplate.query(sql, new Object[]{id}, new RowMapper<MemoGroup>() {
            public MemoGroup mapRow(ResultSet resultSet, int i) throws SQLException {
                MemoGroup memoGroup = new MemoGroup();
                memoGroup.setId(resultSet.getInt("id"));
                memoGroup.setName(resultSet.getString("name"));
                memoGroup.setCreatedTime(resultSet.getDate("created_time"));
                memoGroup.setModifyTime(resultSet.getDate("modify_time"));
                return memoGroup;
            }
        });
        return memoGroups;
    }

    public List<MemoGroup> queryMemoGroupByCreatedTime(Date startTime, Date endTime) {
        return null;
    }

    public int deleteMemoGroup(int id) {
        return 0;
    }
}
