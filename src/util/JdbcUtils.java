package util;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import javax.xml.crypto.Data;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author HaibiaoXu
 * @date Create in 15:31 2019/9/8
 */
public class JdbcUtils {

    private static DataSource ds;

    static{
        try {
            //���������ļ�
            Properties pro = new Properties();

            InputStream is = JdbcUtils.class.getClassLoader().getResourceAsStream("druid.properties");

            pro.load(is);

            //��ʼ�����ӳض���
            ds = DruidDataSourceFactory.createDataSource(pro);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * ��ȡ���ӳض���
     */
    public static DataSource getDataSource(){
        return ds;
    }

    /**
     * ��ȡ���Ӷ���
     */
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
