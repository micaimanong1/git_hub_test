package new1;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class time_get {


    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        System.out.println( l );
       new time_get().t3();
    }



    public void  t1(){
        Calendar calendar = Calendar.getInstance();   //Calendar.HOUR_OF_DAY 改一下就是分钟 、天 、月
        System.out.println(  ( calendar.get(Calendar.HOUR_OF_DAY) - 2 ));
                calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 3);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        System.out.println(  df.format(calendar.getTime())   );
    }

    public void t2(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        // SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");//设置日期格式
        Date date = new Date();
        long time = date.getTime();
        System.out.println(time-7200000 );

        // System.out.println(df.format(new Date()));// new Date()为获取当前系统时间

    }

    public void t3() {
        Calendar calendar = Calendar.getInstance();
             calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) - 3);
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM");
       String yearMonth= df.format(calendar.getTime());
        System.out.println(  yearMonth  );
    }
}
