package club.logicr.myweb.dao;

import club.logicr.myweb.entity.User;

/**
 * @author Jan on 2018/8/4.
 * @version 1.0
 */
public interface UserDao {
    /**
     * 用户注册
     * @param user
     * @return
     */
    boolean userLogin(User user);

    /**
     * 注销用户
     * @param user
     * @return
     */
    boolean logout(User user);
}
