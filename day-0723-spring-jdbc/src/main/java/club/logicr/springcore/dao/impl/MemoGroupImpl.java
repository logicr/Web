package club.logicr.springcore.dao.impl;

import club.logicr.springcore.dao.MemoGroupDao;
import club.logicr.springcore.entity.MemoGroup;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger logger = LoggerFactory.getLogger(MemoGroupDao.class);
    public int insetMemoGroup(MemoGroup memoGroup) {
        String sql = "insert  into memo_group (name, created_time) VALUES (?,?)";
        int effect = this.jdbcTemplate.update(sql, memoGroup.getName(), memoGroup.getCreatedTime());
        logger.debug("Insert into successful {}",effect);
        return effect;
    }
    public int queryMemoGroupByNameCount(final String name) {
        String sql = "select count(id) from memo_group where name = ?";
        int count = jdbcTemplate.queryForObject(sql, new Object[]{name}, Integer.class);
        logger.debug("queryMemoGroupByNameCount success {}",count);
        return count;
    }

    public int updateMemoGroup(int id, String name) {
        String sql = "update memo_group set id = ? where name = ?";
        int effect = jdbcTemplate.update(sql,id,name);
        return effect;
    }
    public int updateMemoGroupDefault(int id) {
        String sql = "update memo_group set id = 1 where id = ?";
        int effect = jdbcTemplate.update(sql,id);
        return effect;
    }

    public List<MemoGroup> queryMemoGroup(int id) {
        String sql = "select id, name, created_time, modify_time from memo_group where id = ?";
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
        logger.debug("query MemoGroupById id = {} restult = {}",id,memoGroups);
        return memoGroups;
    }

    public List<MemoGroup> queryMemoGroupByCreatedTime(Date startTime, Date endTime) {
        String sql = "select id,name,created_time,modify_time from memo_group where created_time between ? and ?";
        List<MemoGroup> memoGroups = jdbcTemplate.queryForObject(sql, new Object[]{startTime, endTime}, List.class);
        return memoGroups;
    }

    public int deleteMemoGroup(int id) {
        String sql = "delete from memo_group where id = ?";
        int effect = jdbcTemplate.update(sql, id);
        return effect;
    }
}
