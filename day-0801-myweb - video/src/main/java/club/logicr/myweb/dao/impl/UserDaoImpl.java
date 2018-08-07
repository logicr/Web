package club.logicr.myweb.dao.impl;

import club.logicr.myweb.dao.UserDao;
import club.logicr.myweb.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author Jan on 2018/8/4.
 * @version 1.0
 */
@Repository
public class UserDaoImpl implements UserDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    @Override
    public boolean userLogin(User user) {
        String sql = "select username,password from user where username = ? and password = ?";
        List<User> userList = jdbcTemplate.query(sql,
                new Object[]{user.getUsername(), user.getPassword()}, new RowMapper<User>() {
                    @Override
                    public User mapRow(ResultSet resultSet, int i) throws SQLException {
                        User user1 = new User();
                        user1.setUsername(resultSet.getString("username"));
                        user1.setPassword((resultSet.getString("password")));
                        return user1;
                    }
                }
        );
        if (userList.isEmpty() || userList.size() < 1) {
            return false;
        } else {
            return true;
        }

    }

    @Override
    public boolean logout(User user) {

        return false;
    }
}
