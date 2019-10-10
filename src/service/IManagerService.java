package service;

import doMain.User;
import doMain.PlInfo;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:17 2019/10/7
 * @modified By
 */
public interface IManagerService {
    /**
     * 查询停车场停车信息
     * @return 停车场信息列表
     */
    List<PlInfo> findAll();

    /**
     * 驶入车辆
     * @param car 车辆信息
     */
    void driveIn(PlInfo car);

    /**
     * 驶出车辆
     * @param car 车辆信息
     */
    void driveOut(PlInfo car);

    /**
     * 根据用户缴费驶出车辆
     * @param user 缴费用户
     */
    void driveOut(User user);
}
