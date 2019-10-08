package dao;

import doMain.User;
import doMain.plInfo;


import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:38 2019/10/7
 * @modified By
 */
public interface IPlInfoDao {
    void driveIn(plInfo car) ;

    /**
     * 驶出车辆信息录入
     */
    void driveOut(plInfo car) ;

    /**
     * 获取所有信息
     * @return plInfo对象
     */
    List<plInfo> findAll() ;

    /**
     * 获取特定用户车辆信息
     * @param user
     * @return
     */
    plInfo findOne(User user) ;

    /**
     * 获取空车位
     * @return 所有空车位
     */
    List<plInfo> getNull();

}
