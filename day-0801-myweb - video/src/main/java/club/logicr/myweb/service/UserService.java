package club.logicr.myweb.service;

import club.logicr.myweb.entity.User;

/**
 * @author Jan on 2018/8/4.
 * @version 1.0
 */
public interface UserService {
    /**
     * 登录，服务层
     * @param user
     * @return
     */
    boolean login(User user);

    /**
     * 退出登录
     * @param user
     * @return
     */
    boolean logout(User user);

}
