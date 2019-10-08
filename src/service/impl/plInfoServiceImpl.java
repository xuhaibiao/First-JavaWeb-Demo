package service.impl;

import dao.IPlInfoDao;
import dao.impl.plInfoDaoImpl;
import doMain.User;
import doMain.plInfo;
import service.IPlInfoService;
import service.IUserService;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:21 2019/10/7
 * @modified By
 */
public class plInfoServiceImpl implements IPlInfoService {
    IPlInfoDao dao = new plInfoDaoImpl();

    @Override
    public List<plInfo> findAll(){
        return dao.findAll();
    }

    @Override
    public void driveIn(plInfo car){
        dao.driveIn(car);
    }

    @Override
    public void driveOut(plInfo car){
        dao.driveOut(car);
    }

    @Override
    public void driveOut(User user) {
        IUserService service = new userServiceImpl();
        List<Object> info = service.getInfo(user);
        Object o = info.get(0);
        this.driveOut((plInfo) o);
    }



}
