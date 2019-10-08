package dao;

import doMain.User;


/**
 * @author HaibiaoXu
 * @date Create in 20:38 2019/10/7
 * @modified By
 */
public interface ICardDao {
    int getMoney(User user);

    /**
     * 充值
     * @param user 用户
     * @param money 充值金额
     */
    void addMoney(User user, int money) ;

    /**
     * 驶出缴费
     *
     * @param user 用户
     * @param time 停车时间
     */
    void pay(User user, int time) ;

    /**
     * 创建卡
     * @param user 用户
     */
    void create(User user) ;

}
