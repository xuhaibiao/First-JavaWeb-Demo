package test;

import dao.ICardDao;
import dao.impl.CardDaoImpl;
import doMain.User;
import org.junit.Test;

/**
 * @author HaibiaoXu
 * @date Create in 12:27 2019/9/14
 */
public class CardDaoTest {
    @Test
    public void testGetMoney() {
        ICardDao dao = new CardDaoImpl();
        User user = new User();
        user.setPassword("111");
        user.setUsername("888888");
        int money = dao.getMoney(user);
        System.out.println(money);
    }

    @Test
    public void testAddMoney() {
        ICardDao dao = new CardDaoImpl();
        User user = new User();
        user.setPassword("111");
        user.setUsername("888888");
        int money = 20;
        dao.addMoney(user, money);

    }
}
