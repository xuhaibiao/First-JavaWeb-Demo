package dao.impl;

import dao.IPlInfoDao;
import doMain.User;
import doMain.plInfo;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import util.JdbcUtils;

import java.util.List;

/**
 * @author HaibiaoXu
 * @date Create in 0:18 2019/9/10
 */
public class plInfoDaoImpl implements IPlInfoDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());

    /**
     * 驶入车辆信息录入
     */
    @Override
    public void driveIn(plInfo car) {
        try {

            String sql = "update pl_info set carNumber=?,time =? where id=?";

            jdbcTemplate.update(sql,new Object[]{car.getCarNumber(),car.getTime(),car.getId()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * 驶出车辆信息录入
     */
    @Override
    public void driveOut(plInfo car) {
        try {
            String sql = "update pl_info set carNumber=null,time = null where carNumber=?";

            jdbcTemplate.update(sql,new Object[]{car.getCarNumber()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

    /**
     * 获取所有信息
     * @return plInfo对象
     */
    @Override
    public List<plInfo> findAll() {
        try {
            String sql = "select * from pl_info";

            RowMapper<plInfo> rowMapper=new BeanPropertyRowMapper<>(plInfo.class);
            List<plInfo> plInfos = jdbcTemplate.query(sql, rowMapper);
            return plInfos;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 获取特定用户车辆信息
     * @param user
     * @return
     */
    @Override
    public plInfo findOne(User user) {
        plInfo pl;
        try {
            String sql = "select * from pl_info where carNumber = ?";

            RowMapper<plInfo> rowMapper=new BeanPropertyRowMapper<>(plInfo.class);
            pl = jdbcTemplate.queryForObject(sql, rowMapper,user.getUsername());
            return pl;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * 获取空车位
     * @return 所有空车位
     */
    @Override
    public List<plInfo> getNull() {
        try {
            String sql = "select * from pl_info where carNumber is null";
            RowMapper<plInfo> rowMapper=new BeanPropertyRowMapper<>(plInfo.class);
            List<plInfo> plInfos = jdbcTemplate.query(sql,rowMapper);
            return plInfos;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
