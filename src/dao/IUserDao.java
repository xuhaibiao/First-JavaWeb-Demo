package dao;

import doMain.User;


/**
 * @author HaibiaoXu
 * @date Create in 20:38 2019/10/7
 * @modified By
 */
public interface IUserDao {
    /**
     * ��¼����
     * @param loginUser ��¼�û���Ϣ
     * @return �û���Ϣ
     */
    User login(User loginUser) ;

    /**
     * ע�᷽��
     * @param registerUser ע���û���Ϣ
     */
    void register(User registerUser);

    /**
     * ��������
     * @param user �û�
     * @param newPassword ������
     */
    void changePassword(User user, String newPassword) ;

}
