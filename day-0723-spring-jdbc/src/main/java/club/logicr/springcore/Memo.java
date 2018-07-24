package club.logicr.springcore;

import club.logicr.springcore.impl.MemoGroups;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;
/**
 * @author Jan on 2018/7/23.
 * @version 1.0
 *
 * 事务：非常重要
 * 什么叫事务：要么都成功，要么都失败：一荣俱荣，一损俱损。
 */
@Component
public class Memo implements MemoGroups {
    @Autowired
    private  JdbcTemplate jdbcTemplate;
//    private final JdbcTemplate jdbcTemplate;
//    public Memo( JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
    public void queryGroup(){
        List resultSet =  jdbcTemplate.queryForList("select * from memo_group");
        System.out.println(resultSet);
    }

    public void addMemoGroup() {
        Integer effect = this.jdbcTemplate.update(
                "insert into memo_group(name,created_time) VALUE (?,?)","Spring","2018-07-23"
        );
        System.out.println("addMemoGroup:"+effect);
    }

    public void deleteMemoGroup() {
        int effect = this.jdbcTemplate.update("delete from memo_group where name = ?", "Spring");
        System.out.println("deleteMemoGroup:"+effect);

    }

    public void updateMemoGroup() {
        int effect = this.jdbcTemplate.update("update memo_group set name = 'Spring' where name=?","SP");
        System.out.println("updateMemoGroup:"+effect);
    }

    public void queryMemoGroup() {
        List resultSet =  jdbcTemplate.queryForList("select * from memo_group");
        System.out.println(resultSet);
    }
}
