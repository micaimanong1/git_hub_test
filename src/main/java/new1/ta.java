package new1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ta {




    public  static void t1(){
     //    String s="{\"la_id\":[1267,1234] , }";


        String s="{\n" +
                "  \"uid\":[1,2,3],\n" +
                "  \"startTime\":\"2020-08-23 18:30:00\",\n" +
                "  \"endTime\":\"2020-08-23 19:30:00\"\n" +
                " }";


        JSONObject jsonObject = JSONObject.parseObject(s);
/**
        String la_ida = jsonObject.getString("laid");
        if ( jsonObject.getString("laid") == null )
        {

            System.out.println( "null"+null);
        }
        System.out.println( la_ida +"=======");

 */
        String la_id = jsonObject.getString("uid");
        System.out.println( la_id);
        JSONArray laidArray = JSON.parseArray(la_id);
        System.out.println( laidArray.size());
        for (Object ss : laidArray) {

            System.out.println( ss.toString());
        }
        //    System.out.println( laidArray.getJSONObject(0).toString());
        //  System.out.println( la_id);

        System.out.println(   JSON.parseArray(la_id).toString());

    }



    public static void main(String[] args) {
  // ta.t1();

//t1        try {
//            ta.t2("2020-08?24 22:18:28");
//       //     ta.t2("2020-02-23 22:18:28");
//
//     //   ta.t2("2020-02-22 22:18:28".substring(0, 10)+" 00:00:00");
//
//        } catch (ParseException e) {
//            e.printStackTrace();
//        }
//
//
//        System.out.println( "2020-02-33 22:18:28".substring(0, 10)+" 00:00:00" );

      t7();

        //  System.out.println(1==1||1==1);
// ta.t4();
    }
 public static void     t7( ){

        String s="select\n" +
                "mon\n" +
                ",student_max \"班容\"\n" +
                ",count(distinct classes_code)  \"班量\"\n" +
                ",sum(student_count)  \"班级学员数量\"\n" +
                ",sum(student_max) \"最大座位数\"\n" +
                ",sum(student_count)*1.0000/count(distinct classes_code)  \"班均学员量\"\n" +
                ",sum(student_count)*1.0000/sum(student_max) \"满座率\"\n" +
                "from\n" +
                "(\n" +
                "select * from\n" +
                "(\n" +
                "select * from\n" +
                "(\n" +
                "select *\n" +
                ",row_number()over(partition by classes_code,mon order by x.data_dt desc ) rn\n" +
                "from\n" +
                "(\n" +
                "select\n" +
                "classes_code\n" +
                ",cr.course_name\n" +
                ",cr.course_year\n" +
                ",c.student_count\n" +
                ",student_max\n" +
                ",c.is_closed\n" +
                ",c.data_dt\n" +
                ",c.next_open_time\n" +
                ",date_format(c.start_date,'%Y-%m-%d') start_date\n" +
                ",date_format(c.end_date,'%Y-%m-%d') end_date\n" +
                ",c.classes_type\n" +
                ",date_format(cast(c.data_dt as date),'%Y-%m') mon\n" +
                "\n" +
                "\n" +
                "from bdp_dw.dw_t_classes_info_h c\n" +
                "left join bdp_dw.dw_g_course_info_s cr on c.course_id = cr.course_id\n" +
                "\n" +
                "where 1=1\n" +
                "\tand c.status <> 0\n" +
                "\tand cr.course_type in (1,5)   -- 系统课\n" +
                "\tand cr.teaching_method = 1  -- 直播课\n" +
                ") x\n" +
                ") y\n" +
                "where rn = 1\n" +
                "order by data_dt desc\n" +
                ") aa\n" +
                "left join\n" +
                "(-- 每个月最后一天\n" +
                "select mon_m,datedate from\n" +
                "(\n" +
                "select\n" +
                "datedate\n" +
                ",mon mon_m\n" +
                ",row_number()over(partition by mon order by cast(datedate as date) desc) rn\n" +
                "from\n" +
                "(\n" +
                "select *,date_format(cast(datedate as date),'%Y-%m') mon\n" +
                "from bdp_dim.dim_calendar_s\n" +
                ") x\n" +
                "order by 1,3\n" +
                ") y\n" +
                "where rn = 1\n" +
                "order by 1\n" +
                ") bb on aa.mon = bb.mon_m\n" +
                "where 1=1\n" +
                "and aa.data_dt = bb.datedate\n" +
                "and aa.data_dt >= start_date\n" +
                "and aa.data_dt < end_date\n" +
                "and student_max > 0\n" +
                "and student_count >0\n" +
                "and is_closed = 0\n" +
                "order by data_dt desc\n" +
                ") z\n" +
                "group by 1,2\n" +
                "order by 1,2\n";
        JSONObject j=new JSONObject();
        j.put("sql", s);
        System.out.println( j.toJSONString());

    }

    private static void t4() {
        JSONObject jsonBody =   JSONObject.parseObject("   {   \"uid\":[ 9,13,14,82,267,961,1392\n" +
                "   ],    \"startTime\":\"2020-08-23 10:01:00\",   \"endTime\":\"2020-08-23 10:30:00\"  } ");

        Object uid = jsonBody.get("uid");
        System.out.println( jsonBody.get("uid" ) );
        System.out.println(((JSONArray)jsonBody.get("uid" ) ).toString() );

        List<Integer> jsonArray = (List<Integer>)JSONArray.parseArray( ((JSONArray)jsonBody.get("uid" ) ).toString() , Integer.class);


        for (Integer integer : jsonArray) {
            System.out.println(integer.toString()+1);
        }

        System.out.println( jsonBody.toString());


    }

    public static void t2( String date) throws ParseException {

        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sf.setLenient(false);
        System.out.println(  sf.parse(date).getTime() );

    }

    public static void t2( )     {




        JSONObject errMsg = new JSONObject();
        errMsg.put("code", 404);
        errMsg.put("message", "时间传入错误");
        System.out.println( errMsg.toString());
        errMsg.put("message", "时间传入错误222");
        System.out.println( errMsg.toString());
        System.out.println( errMsg.toJSONString());

    }


    public static void t3( )     {

        Map<Integer, int[]> userMap = new HashMap<Integer, int[]>();

        userMap.put(   1 ,new int[]{0,0});

        userMap.put(   2 ,new int[]{0,0});


        int[] ints = userMap.get(2);
        ints[1] = 1;
        userMap.put(   2 ,ints);

        System.out.println(userMap.get(2)[1] +"   ====== "+ userMap.get(2)[0] );



    }



}
