package dao;

import doMain.PlInfo;
import doMain.User;


import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:38 2019/10/7
 * @modified By
 */
public interface IPlInfoDao {
    void driveIn(PlInfo car) ;

    /**
     * 驶出车辆信息录入
     */
    void driveOut(PlInfo car) ;

    /**
     * 获取所有信息
     * @return plInfo对象
     */
    List<PlInfo> findAll() ;

    /**
     * 获取特定用户车辆信息
     * @param user
     * @return 车辆信息
     */
    PlInfo findOne(User user) ;

    /**
     * 获取空车位
     * @return 所有空车位
     */
    List<PlInfo> getNull();

}
