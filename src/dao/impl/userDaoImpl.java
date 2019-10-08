package dao.impl;

import dao.IUserDao;
import doMain.User;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import service.IUserService;
import util.JdbcUtils;

/**
 * @author HaibiaoXu
 * @date Create in 15:23 2019/9/8
 */
public class userDaoImpl implements IUserDao {

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JdbcUtils.getDataSource());
    /**
     * ��¼����
     * @param loginUser ��¼�û���Ϣ
     * @return User ���������û���Ϣ
     */
    @Override
    public User login(User loginUser) {
        try {
            String sql = "select * from user_info where username = ? and password = ? and role = ?";

            User user = jdbcTemplate.queryForObject(sql,
                    new BeanPropertyRowMapper<>(User.class),
                    loginUser.getUsername(), loginUser.getPassword(),loginUser.getRole());

            return user;
        } catch (DataAccessException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * ע�᷽��
     * @param registerUser ע���û���Ϣ
     */
    @Override
    public void register(User registerUser) {
        try {
            String sql = "insert into user_info values(?,?,?)";

            jdbcTemplate.update(sql,new Object[]{registerUser.getUsername(), registerUser.getPassword(),registerUser.getRole()});

        } catch (DataAccessException e) {
            e.printStackTrace();
        }
    }

    /**
     * ��������
     * @param user �û�
     * @param newPassword ������
     */
    @Override
    public void changePassword(User user, String newPassword) {
        try {
            String sql = "update user_info set password=? where username = ?";

            jdbcTemplate.update(sql,new Object[]{newPassword,user.getUsername()});
        } catch (DataAccessException e) {
            e.printStackTrace();
        }

    }

}
