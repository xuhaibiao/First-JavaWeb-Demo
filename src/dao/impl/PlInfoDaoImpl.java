package dao.impl;

import dao.IPlInfoDao;
import doMain.PlInfo;
import doMain.User;
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
public class PlInfoDaoImpl implements IPlInfoDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());


    @Override
    public void driveIn(PlInfo car) {
        try {

            String sql = "update pl_info set carNumber=?,time =? where id=?";

            jdbcTemplate.update(sql,new Object[]{car.getCarNumber(),car.getTime(),car.getId()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }


    @Override
    public void driveOut(PlInfo car) {
        try {
            String sql = "update pl_info set carNumber=null,time = null where carNumber=?";

            jdbcTemplate.update(sql,new Object[]{car.getCarNumber()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }


    @Override
    public List<PlInfo> findAll() {
        try {
            String sql = "select * from pl_info";

            RowMapper<PlInfo> rowMapper=new BeanPropertyRowMapper<>(PlInfo.class);
            List<PlInfo> plInfos = jdbcTemplate.query(sql, rowMapper);
            return plInfos;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public PlInfo findOne(User user) {
        PlInfo pl;
        try {
            String sql = "select * from pl_info where carNumber = ?";

            RowMapper<PlInfo> rowMapper=new BeanPropertyRowMapper<>(PlInfo.class);
            pl = jdbcTemplate.queryForObject(sql, rowMapper,user.getUsername());
            return pl;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<PlInfo> getNull() {
        try {
            String sql = "select * from pl_info where carNumber is null";
            RowMapper<PlInfo> rowMapper=new BeanPropertyRowMapper<>(PlInfo.class);
            List<PlInfo> plInfos = jdbcTemplate.query(sql,rowMapper);
            return plInfos;
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}
