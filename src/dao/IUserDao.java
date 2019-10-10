package dao;

import doMain.User;


/**
 * @author HaibiaoXu
 * @date Create in 20:38 2019/10/7
 * @modified By
 */
public interface IUserDao {
    /**
     * 登录方法
     * @param loginUser 登录用户信息
     * @return 用户信息
     */
    User login(User loginUser) ;

    /**
     * 注册方法
     * @param registerUser 注册用户信息
     */
    void register(User registerUser);

    /**
     * 更改密码
     * @param user 用户
     * @param newPassword 新密码
     */
    void changePassword(User user, String newPassword) ;

}
