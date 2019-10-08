package service;

import doMain.User;
import doMain.plInfo;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:17 2019/10/7
 * @modified By
 */
public interface IPlInfoService {
    /**
     * 查询停车场停车信息
     * @return
     */
    List<plInfo> findAll();

    /**
     * 驶入车辆
     * @param car 车辆信息
     */
    void driveIn(plInfo car);

    /**
     * 驶出车辆
     * @param car 车辆信息
     */
    void driveOut(plInfo car);

    /**
     * 根据用户缴费驶出车辆
     * @param user 缴费用户
     */
    void driveOut(User user);


}
