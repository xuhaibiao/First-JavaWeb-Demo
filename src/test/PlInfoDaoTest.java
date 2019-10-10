package test;

import dao.IPlInfoDao;
import dao.impl.PlInfoDaoImpl;
import doMain.User;
import doMain.PlInfo;
import org.junit.Test;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 15:58 2019/9/14
 */
public class PlInfoDaoTest {

    @Test
    public void findOne() {
        User user = new User();
        user.setPassword("111");
        user.setUsername("111111");

        IPlInfoDao dao = new PlInfoDaoImpl();
        PlInfo one = dao.findOne(user);
        System.out.println(one);

    }

    @Test
    public void getNull() {
        IPlInfoDao dao = new PlInfoDaoImpl();
        List<PlInfo> ids = dao.getNull();
        System.out.println(ids);


//        Map map =(Map) ids.get(0);
//        System.out.println(map.get("id"));

    }
}
