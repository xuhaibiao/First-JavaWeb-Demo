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
     * ��ѯͣ����ͣ����Ϣ
     * @return ͣ������Ϣ�б�
     */
    List<PlInfo> findAll();

    /**
     * ʻ�복��
     * @param car ������Ϣ
     */
    void driveIn(PlInfo car);

    /**
     * ʻ������
     * @param car ������Ϣ
     */
    void driveOut(PlInfo car);

    /**
     * �����û��ɷ�ʻ������
     * @param user �ɷ��û�
     */
    void driveOut(User user);
}
