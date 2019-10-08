package test;

import dao.IPlInfoDao;
import dao.impl.plInfoDaoImpl;
import doMain.User;
import doMain.plInfo;
import org.junit.Test;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 15:58 2019/9/14
 */
public class plInfoDaoTest {

    @Test
    public void findOne() {
        User user = new User();
        user.setPassword("111");
        user.setUsername("111111");

        IPlInfoDao dao = new plInfoDaoImpl();
        plInfo one = dao.findOne(user);
        System.out.println(one);

    }

    @Test
    public void getNull() {
        IPlInfoDao dao = new plInfoDaoImpl();
        List<plInfo> ids = dao.getNull();
        System.out.println(ids);


//        Map map =(Map) ids.get(0);
//        System.out.println(map.get("id"));

    }
}
