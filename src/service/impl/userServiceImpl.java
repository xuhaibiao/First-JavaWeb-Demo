package service.impl;

import dao.ICardDao;
import dao.IPlInfoDao;
import dao.IUserDao;
import dao.impl.cardDaoImpl;
import dao.impl.plInfoDaoImpl;
import dao.impl.userDaoImpl;
import doMain.User;
import doMain.plInfo;
import service.IUserService;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 22:11 2019/9/12
 */
public class userServiceImpl implements IUserService {
    private IUserDao dao = new userDaoImpl();
    private ICardDao dao2 = new cardDaoImpl();
    private IPlInfoDao dao3 = new plInfoDaoImpl();
    //�շѱ�׼
    private final int CHARGES = 20;

    @Override
    public User login(User loginUser) {
       return dao.login(loginUser);
    }

    @Override
    public void register(User registerUser) {
        //����dao��ע��
        dao.register(registerUser);
        dao2.create(registerUser);
    }

    @Override
    public int getTime(User user) {
        //����dao���ȡͣ��ʱ��
        plInfo one = dao3.findOne(user);
        if (one == null) {
            return 0;
        }

        Timestamp old = one.getTime();
        Date date = new Date();
        Timestamp now = new Timestamp(date.getTime());

        long t1 = now.getTime();
        long t2 = old.getTime();
        int hours=(int) ((t1 - t2)/(1000*60*60));
        int minutes=(int) (((t1 - t2)/1000-hours*(60*60))/60);
        int seconds=(int) ((t1 - t2)/1000-hours*(60*60)-minutes*60);

        return seconds;
    }


    @Override
    public int getMoney(User user) {
        return dao2.getMoney(user);
    }
    @Override
    public void addMoney(User user, int money) {
        dao2.addMoney(user, money);
    }
    @Override
    public void pay(User user){
        int time = this.getTime(user);
        dao2.pay(user, time);
    }

    /*
    plInfo(ͣ��λ���� ���ƺ� ͣ��ʱ��)  ͣ��ʱ�� Ӧ�����
     */
    @Override
    public List<Object> getInfo(User user) {
        List list = new ArrayList();
        list.add(dao3.findOne(user));
        if (this.getTime(user) == 0) {
            list.add(null);
            list.add(null);
            return list;
        }
        list.add(this.getTime(user));
        list.add(this.getTime(user)*CHARGES);
        return list;
    }

    /**
     * ��������
     * @param user �û�
     * @param newPassword ������
     */
    @Override
    public void changePassword(User user, String newPassword) {
        dao.changePassword(user,newPassword);
    }
    @Override
    public List<plInfo> getNullId() {
        return dao3.getNull();
    }
}
