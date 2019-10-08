package dao;

import doMain.User;


/**
 * @author HaibiaoXu
 * @date Create in 20:38 2019/10/7
 * @modified By
 */
public interface ICardDao {
    int getMoney(User user);

    /**
     * ��ֵ
     * @param user �û�
     * @param money ��ֵ���
     */
    void addMoney(User user, int money) ;

    /**
     * ʻ���ɷ�
     *
     * @param user �û�
     * @param time ͣ��ʱ��
     */
    void pay(User user, int time) ;

    /**
     * ������
     * @param user �û�
     */
    void create(User user) ;

}
