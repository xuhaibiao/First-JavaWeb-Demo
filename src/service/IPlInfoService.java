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
     * ��ѯͣ����ͣ����Ϣ
     * @return
     */
    List<plInfo> findAll();

    /**
     * ʻ�복��
     * @param car ������Ϣ
     */
    void driveIn(plInfo car);

    /**
     * ʻ������
     * @param car ������Ϣ
     */
    void driveOut(plInfo car);

    /**
     * �����û��ɷ�ʻ������
     * @param user �ɷ��û�
     */
    void driveOut(User user);


}
