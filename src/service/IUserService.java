package service;

import doMain.User;
import doMain.PlInfo;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:17 2019/10/7
 * @modified By
 */
public interface IUserService {

    /**
     * ��¼
     * @param loginUser �û���Ϣ
     * @return �û���Ϣ
     */
    User login(User loginUser);


    /**
     * ע��
     * @param registerUser �û���Ϣ
     */
    void register(User registerUser);

    /**
     * ��ȡͣ��ʱ��
     * @param user �û���Ϣ
     * @return ͣ��ʱ��
     */
    int getTime(User user);


    /**
     * ��ȡǮ�����
     * @param user �û���Ϣ
     * @return ���
     */
    int getMoney(User user) ;

    /**
     * ��ֵ
     * @param user �û���Ϣ
     * @param money ��ֵ���
     */
    void addMoney(User user, int money) ;

    /**
     * �ɷ�
     * @param user �û���Ϣ
     */
    boolean pay(User user);


    /**
     * ��ȡ����ͣ����Ϣ
     * @param user �û���Ϣ
     * @return ͣ����Ϣ�б� PlInfo(ͣ��λ���� ���ƺ� ͣ��ʱ��)  ͣ��ʱ�� Ӧ�����
     */
    List<Object> getInfo(User user);


    /**
     * ��������
     * @param user �û�
     * @param newPassword ������
     */
    void changePassword(User user, String newPassword);

    /**
     * ��ȡ��ͣ��λ
     * @return ��ͣ��λ����б�
     */
    List<PlInfo> getNullId();


}
