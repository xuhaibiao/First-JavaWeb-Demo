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
     * ʻ��������Ϣ¼��
     */
    void driveOut(PlInfo car) ;

    /**
     * ��ȡ������Ϣ
     * @return plInfo����
     */
    List<PlInfo> findAll() ;

    /**
     * ��ȡ�ض��û�������Ϣ
     * @param user
     * @return ������Ϣ
     */
    PlInfo findOne(User user) ;

    /**
     * ��ȡ�ճ�λ
     * @return ���пճ�λ
     */
    List<PlInfo> getNull();

}
