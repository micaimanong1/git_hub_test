package new1;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.*;


public class t1 {


 @Test
    public   void t11(){

        JSONArray jsonArray = new JSONArray();
        JSONObject json  = new JSONObject();
        ArrayList<String> strings = new ArrayList<String>();
        strings.add(null);
        strings.add("null");
        strings.add("aa;");
        strings.add("a1, b,c");
        strings.add(", a2, a,b,c");
  //   jsonArray.add(strings.toString());

     ArrayList<String> string2 = new ArrayList<String>();
     string2.add(null);
     string2.add("null");

     jsonArray.add( string2);
     jsonArray.add( strings);
    // jsonArray.add( strings);
     json.put("data", jsonArray);
     json.put("d1", strings);
     //   System.out.println(strings.toString() +" " + strings);
        System.out.println( json.toString());


        JSONObject parse =  JSONObject.parseObject(json.toJSONString());
        System.out.println("getdata: "+ parse.get("data") );
  //   ArrayList<String> ListArray1 = new ArrayList<String>();

      List<List> ListArray1 = new ArrayList<List>();
     System.out.println(JSON.toJSONString( parse.get("data")));
     ListArray1= JSONArray.parseArray(JSON.toJSONString(parse.get("data")),List.class); // 数组里面的内容是什么类就用对应的 class
        int a=0;

     for (List stringArrayList : ListArray1) {
         for (int i = 0; i < stringArrayList.size(); i++) {
             System.out.println(i + (String)stringArrayList.get(i));
         }

     }

        }









  @Test
    public   void t22( ) {

        StringBuilder S= new StringBuilder();
        String sn=null;
        S.append( sn);
        S.append(",");
        S.append("null");
      S.append('\001');
        S.append("a,b;c\\001");
      S.append(",");
        System.out.println(S.toString());
      String[] split = S.toString().split(",");
      for (String s : split) {
          System.out.println( s);
      }
  }

  @Test
  public  void  t3() {

      Map<String,String> map1 = new HashMap<String,String>();
      Map<String,String> map2 = new HashMap<String,String>();
      Map<String,String> map3 = new HashMap<String,String>();
      List<Map<String,String>> list = new ArrayList<Map<String,String>>();
      map1.put("name","小明");
      map1.put("age","23");
      map1.put("sex","男");
      list.add(map1);

      map2.put("name","小王");
      map2.put("age","24");
      map2.put("sex","女");
      list.add(map2);
      map3.put("name","小张");
      map3.put("age","22");
      map3.put("sex","男");
      list.add(map3);

      String jsonStr = JSON.toJSONString(list); // 转成 string样式
      System.out.println(jsonStr);
          List<HashMap> listMap = new ArrayList<HashMap>();
          // 解析的重点:
      listMap = JSON.parseArray(jsonStr, HashMap.class);

      for (HashMap<String, String> stringStringHashMap : listMap) {

          Set<Map.Entry<String, String>> entries = stringStringHashMap.entrySet();
          for (Map.Entry<String, String> entry : entries) {
              System.out.println( entry.getKey() +"  "+ entry.getValue());
          }


      }
      System.out.println(JSON.toJSONString(listMap));

  }

    @Test
  public  void t4(){

      ArrayList<String> strings = new ArrayList<String>();
  //    strings.add(null);
      strings.add("null");
      strings.add("aa;");
      strings.add("a1, b,c");
      strings.add(", a2, a,b,c");

      String s= JSON.toJSONString(strings);
      System.out.println(s );
        System.out.println( strings.toString());


        List<String> strings1 = JSON.parseArray(s, String.class);

      System.out.println( strings1.get(1));

        ArrayList arrayList = new ArrayList(strings);

        for (Object o : arrayList) {
            System.out.println( o.toString());
        }
  }
}
