package test;

import dao.ICardDao;
import dao.IPlInfoDao;
import dao.impl.cardDaoImpl;
import dao.impl.plInfoDaoImpl;
import doMain.User;
import doMain.plInfo;
import org.junit.Test;
import service.IUserService;
import service.impl.userServiceImpl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 15:51 2019/9/14
 */
public class userServiceTest {
    private final int CHARGES = 20;
    private IUserService service = new userServiceImpl();

    @Test
    public void getInfo() {
        User user = new User();
        user.setPassword("333");
        user.setUsername("333333");
        List list = new ArrayList();
        IPlInfoDao dao3 = new plInfoDaoImpl();

        list.add(dao3.findOne(user));
        list.add(service.getTime(user));
        list.add(service.getTime(user)*CHARGES);

        System.out.println(list);
        plInfo info =(plInfo) list.get(0);
        System.out.println(info.getId());
        System.out.println(list.get(1));
        System.out.println(list.get(2));

    }

    @Test
    public void pay(){
        User user = new User();
        user.setPassword("111");
        user.setUsername("888888");
        ICardDao dao2 = new cardDaoImpl();

        int time =service.getTime(user);

        dao2.pay(user, time);
    }
}
