package dao.impl;

import dao.ICardDao;
import doMain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import util.JdbcUtils;

/**
 * @author HaibiaoXu
 * @date Create in 20:41 2019/10/7
 * @modified By
 */
public class cardDaoImpl implements ICardDao {
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    //�շѱ�׼
    private final int CHARGES = 20;

    /**
     * ��ȡǮ�����
     * @param user �û�
     * @return ���
     */

    @Override
    public int getMoney(User user) {
        try {
            String sql = "select money from card_info where username = ?";
            int money = jdbcTemplate.queryForObject(sql,new Object[]{user.getUsername()},Integer.class);
            return money;

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * ��ֵ
     * @param user �û�
     * @param money ��ֵ���
     */
    @Override
    public void addMoney(User user, int money) {
        try {
            String sql = "select money from card_info where username = ?";
            int balance = jdbcTemplate.queryForObject(sql,new Object[]{user.getUsername()},Integer.class);

            String sql2 = "update card_info set money = ? where username=?";

            jdbcTemplate.update(sql2,new Object[]{balance+money,user.getUsername()});

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * ʻ���ɷ�
     *
     * @param user �û�
     * @param time ͣ��ʱ��
     */
    @Override
    public void pay(User user, int time) {
        try {
            String sql = "select money from card_info where username = ?";
            int balance = jdbcTemplate.queryForObject(sql,new Object[]{user.getUsername()},Integer.class);

            String sql2 = "update card_info set money = ? where username=?";

            int money = time*CHARGES;

            jdbcTemplate.update(sql2,new Object[]{balance-money,user.getUsername()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void create(User user) {
        try {
            String sql = "insert into card_info values(?,?)";

            jdbcTemplate.update(sql,new Object[]{user.getUsername(), 0});

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

}

