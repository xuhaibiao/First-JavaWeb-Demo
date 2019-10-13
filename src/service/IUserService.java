package service;

import doMain.User;
import doMain.PlInfo;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:17 2019/10/7
 * @modified By
 */
public interface IUserService {

    /**
     * 登录
     * @param loginUser 用户信息
     * @return 用户信息
     */
    User login(User loginUser);


    /**
     * 注册
     * @param registerUser 用户信息
     */
    void register(User registerUser);

    /**
     * 获取停车时长
     * @param user 用户信息
     * @return 停车时长
     */
    int getTime(User user);


    /**
     * 获取钱包金额
     * @param user 用户信息
     * @return 金额
     */
    int getMoney(User user) ;

    /**
     * 充值
     * @param user 用户信息
     * @param money 充值金额
     */
    void addMoney(User user, int money) ;

    /**
     * 缴费
     * @param user 用户信息
     */
    boolean pay(User user);


    /**
     * 获取本人停车信息
     * @param user 用户信息
     * @return 停车信息列表 PlInfo(停车位号码 车牌号 停车时间)  停车时长 应付金额
     */
    List<Object> getInfo(User user);


    /**
     * 更改密码
     * @param user 用户
     * @param newPassword 新密码
     */
    void changePassword(User user, String newPassword);

    /**
     * 获取空停车位
     * @return 空停车位编号列表
     */
    List<PlInfo> getNullId();


}
