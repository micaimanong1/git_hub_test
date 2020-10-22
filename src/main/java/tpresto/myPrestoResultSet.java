package tpresto;

import com.facebook.presto.jdbc.PrestoResultSet;

import java.io.Serializable;

/**
 * @Author liubo
 * @Date 2020/10/9 11:28
 */
public class myPrestoResultSet implements Serializable {


    private final  PrestoResultSet prestoResultSet;
    private final  PrestoResultSet hiveResultSet;




    public myPrestoResultSet(PrestoResultSet prestoResultSet, PrestoResultSet hiveResultSet) {
        this.prestoResultSet = prestoResultSet;
        this.hiveResultSet = hiveResultSet;
    }




}
