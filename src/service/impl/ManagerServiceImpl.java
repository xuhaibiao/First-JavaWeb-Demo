package service.impl;

import dao.IPlInfoDao;
import dao.impl.PlInfoDaoImpl;
import doMain.PlInfo;
import doMain.User;
import service.IManagerService;

import service.IUserService;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 20:21 2019/10/7
 * @modified By
 */
public class ManagerServiceImpl implements IManagerService {
    IPlInfoDao dao = new PlInfoDaoImpl();

    @Override
    public List<PlInfo> findAll(){
        return dao.findAll();
    }

    @Override
    public void driveIn(PlInfo car){
        dao.driveIn(car);
    }

    @Override
    public void driveOut(PlInfo car){
        dao.driveOut(car);
    }

    @Override
    public void driveOut(User user) {
        IUserService service = new UserServiceImpl();
        List<Object> info = service.getInfo(user);
        Object o = info.get(0);
        this.driveOut((PlInfo) o);
    }



}
