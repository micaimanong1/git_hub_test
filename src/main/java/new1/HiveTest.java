package new1;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

/**
 * @Author liubo
 * @Date 2020/9/28 21:33
 */
public class HiveTest {


    public static void main(String[] args) {


        hive("select *\n" +
                "    from  bdp_dm_p.dm_t04_asse_first_learning_process_coef_h\n" +
                "    where\n" +
                " m = date_format('2020-09-27','yyyy-MM') limit 20 ");
    }


    public static int hive(String sql ){
        try {
         //   ResourceBundle rb = ResourceBundle.getBundle("config.properties");

            Config conf = ConfigFactory.load("hive.properties");

            String hiveurl = conf.getString("hiveurl");



            Class.forName("org.apache.hive.jdbc.HiveDriver").newInstance();

            Connection conn = DriverManager.getConnection( "jdbc:hive2://10.91.1.3:10000","root",null);
            java.sql.PreparedStatement pstsm = conn.prepareStatement(sql);

            ResultSet resultSet = pstsm.executeQuery();
            int rowNum = 0;
            if(resultSet.next()){
                rowNum = resultSet.getInt(1);
            }
            return rowNum;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
    }

    public  static void t1(String sql ){




    }

// 别人的
/*
    public static int  hiveJDBC_RowCount(String sql, Map<Integer,String> params){
        try {
            ResourceBundle rb = ResourceBundle.getBundle("config");
            Class.forName(rb.getString("hivedriverClassName")).newInstance();

            Connection conn = DriverManager.getConnection(rb.getString("hiveurl"),rb.getString("hiveusername"),rb.getString("hivepassword"));
            PreparedStatement pstsm = conn.prepareStatement(sql);
            for(Integer key : params.keySet()){
                pstsm.setString(key, params.get(key));
            }
            ResultSet resultSet = pstsm.executeQuery();
            int rowNum = 0;
            if(resultSet.next()){
                rowNum = resultSet.getInt(1);
            }
            return rowNum;
        } catch (Exception e) {
            System.out.println(e);
            return 0;
        }
   }
 */


}
