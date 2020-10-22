package new1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class tlist {


    public static void main(String[] args) {


ab();
    }

    public static void a() {

        List<String> list = new ArrayList<String>();
        list.add("1");
        list.add("2");
        list.add("3");
        System.out.println(list);
        System.out.println(list.toString());

        String json = JSONArray.toJSONString(list);//把list转换成json格式的String类型
        System.out.println("json格式的String类型 " + json);

        //  System.out.println(StringUtils.strip(list.toString(),"[]"));
    }


    public static void ab() {
        String sourceAsString ="[{\"title\":\"第1页\",\"code\":\"B1-P2-S4-E1\",\"result\":\"0\",\"stamp\":\"1599997900030\"},{\"title\":\"第1页\",\"code\":\"B1-P2-S4-E1\",\"result\":\"1\",\"stamp\":\"1599997907480\"},{\"title\":\"第2页\",\"code\":\"B1-P2-S4-E2\",\"result\":\"1\",\"stamp\":\"1599997929989\"},{\"title\":\"第1页\",\"code\":\"B1-P3-S3-E1\",\"result\":\"0\",\"stamp\":\"1599999046861\"},{\"title\":\"第1页\",\"code\":\"B1-P3-S3-E1\",\"result\":\"1\",\"stamp\":\"1599999063365\"},{\"title\":\"第2页\",\"code\":\"B1-P3-S3-E2\",\"result\":\"1\",\"stamp\":\"1599999126731\"}]";
        JSONArray s =  JSON.parseArray(sourceAsString);
        for ( Object j : s
             ) {
            JSONObject  parse = JSON.parseObject(j.toString());

            System.out.println("json格式的String类型 " + parse.getString("stamp") +"  "+parse.getString("code")  +parse.getString("title")  );
        }


     //   System.out.println("json格式的String类型 " +  );

        //  System.out.println(StringUtils.strip(list.toString(),"[]"));
    }
}
