package tpresto;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.facebook.presto.jdbc.PrestoResultSet;
import org.junit.jupiter.api.Test;

import java.sql.*;
import java.util.ArrayList;

public class prestoTest {


    public static void main(String[] args) throws ClassNotFoundException {
        /*
        try {
            t1("select * from bdp_dw.dw_g_course_info_s  limit 20");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        */

//        try {
//            t1("select\n" +
//                            "course_id\n" +
//                            ",course_type\n" +
//                            ",course_name\n" +
//                            ",alias_name\n" +
//                            ",modified_time\n" +
//                            ",data_dt\n" +
//                            "from qa_bdp_dw.dw_g_course_info_s limit 5" +
//                            ""
//                    );
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }



/**
 try {
 t1("select\tjson_extract('{\"name\":\"王二\",\"sex\":\"男\",\"age\":\"25\"}', '$.age') ss");
 } catch (SQLException e) {
 e.printStackTrace();
 }

 */



    }

    @Test
    public void      t1(   ) throws SQLException, ClassNotFoundException {


        Class.forName("com.facebook.presto.jdbc.PrestoDriver");
        Connection connection = DriverManager.getConnection("jdbc:presto://10.91.1.8:8285/hive","bip",null);  ;
        Statement stmt = connection.createStatement();
      //  connection.close();
      //  stmt.setQueryTimeout(100);
String sql ="select user_id  ,ctime ,event_cate,unique_id  from    qa_bdp_dm_p.dm_ser_ai_user_login_h where data_dt='2020-09-23' limit 3";
        PrestoResultSet rs = (PrestoResultSet)stmt.executeQuery(sql);
    rs.getQueryId();


    //    rs.close(); // 关闭查询
        JSONArray jsonArray = new JSONArray();
      //  rs.client

        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        ArrayList<String> name = new ArrayList<String>();
        for(int i=0;i<columnCount;i++) {

            name.add( metaData.getColumnName(i+1));
        }

        StringBuilder S= new StringBuilder();

        JSONObject js = new JSONObject();
        while (rs.next()) {

            for(int i=1;i<columnCount;i++) {

                rs.getString(i);
       //         System.out.println( rs.getString(i) );
                S.append( rs.getString(i)+'\001'); // 字段用 \001 分隔 转成 unicode \u0001
            }
            S.append('\002');

            // js.put(""+(a++),rs.getString(1)  )     ;


        }

        js.put("data", S.toString());
        js.put("field", name.toString());

        jsonArray.add(js );
        System.out.println( js.toString() );
        System.out.println( jsonArray.toJSONString());
    //    return null;
    }

    @Test
    public  void t2() throws SQLException, ClassNotFoundException {


        Class.forName("com.facebook.presto.jdbc.PrestoDriver");
        Connection connection = DriverManager.getConnection("jdbc:presto://10.91.1.8:8285/hive","bip",null);  ;
        Statement stmt = connection.createStatement();

        String sql ="select user_id  ,ctime ,event_cate,unique_id  from    qa_bdp_dm_p.dm_ser_ai_user_login_h where data_dt='2020-09-23' limit 3";

        ResultSet rs = stmt.executeQuery(sql);

        JSONObject js = new JSONObject(); // 返回的对象
        JSONArray dataArray = new JSONArray(); // 返回的数据存储的
        ResultSetMetaData metaData = rs.getMetaData();
        int columnCount = metaData.getColumnCount();
        ArrayList<String> name = new ArrayList<String>();
        // 迭代字段
        for(int i=1;i<=columnCount;i++) {
            name.add( metaData.getColumnName(i));
        }
        int num=0;

        while (rs.next()) {
            ArrayList<String> strings = new ArrayList<String>(); // 中间缓存每行数据的
            strings.add(num+++"");
            for (int i = 1; i <= columnCount; i++) {  // 看好一下起始位置
                strings.add(rs.getString(i)); // list 添加进去每个字段
            }
             //    dataArray.add(strings.toString());
            dataArray.add(strings); // 这个只是增加了一个 指针之类的 就需要生成海量的 list对象, 这个是一个问题点
               //   dataArray.add(JSONObject.toJSONString(strings ));
           // strings.clear();
        }
     /*
       StringBuilder builder= new StringBuilder();
        while (rs.next()) {
            for(int i=1;i<columnCount;i++) {
                builder.append( rs.getString(i)+'\001'); // 字段用 \001 分隔 转成 unicode \u0001
            }
            builder.append('\002'); // 换行 解析的时候由于最后一个字段加了 \001 可以用 \001\002 换行
        }
      */
    //    System.out.println( rs.getRow() +"  " );
        js.put("data", dataArray  );
        js.put("meta", name );
        System.out.println( js.toJSONString() );

    }



    @Test
    public  void t3() {


    }


}
