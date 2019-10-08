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
     * ʻ��������Ϣ¼��
     */
    void driveOut(plInfo car) ;

    /**
     * ��ȡ������Ϣ
     * @return plInfo����
     */
    List<plInfo> findAll() ;

    /**
     * ��ȡ�ض��û�������Ϣ
     * @param user
     * @return
     */
    plInfo findOne(User user) ;

    /**
     * ��ȡ�ճ�λ
     * @return ���пճ�λ
     */
    List<plInfo> getNull();

}
