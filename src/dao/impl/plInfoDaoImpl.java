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
     * ʻ�복����Ϣ¼��
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
     * ʻ��������Ϣ¼��
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
     * ��ȡ������Ϣ
     * @return plInfo����
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
     * ��ȡ�ض��û�������Ϣ
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
     * ��ȡ�ճ�λ
     * @return ���пճ�λ
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
