package dao;

import oracle.jdbc.OracleTypes;
import org.springframework.jdbc.core.*;
import org.springframework.jdbc.object.StoredProcedure;

import java.sql.Types;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by LZP on 2017/7/28.
 * for student
 */
public class StoredProcedureTemplate extends StoredProcedure {
    HashMap<String, Object> map = new HashMap<String, Object>();

    public StoredProcedureTemplate() {
        super();
       // super.setFunction(false);
    }

    public HashMap getMap() {
        return this.map;
    }

    public void setValue(String key, Object object) {
        map.put(key, object);
    }


        public void setVarcharParam(String param){
            this.declareParameter(new SqlParameter(param, Types.VARCHAR));
        }
        public void setVarcharParam(String param,Object value){
            this.declareParameter(new SqlParameter(param,Types.VARCHAR));
            this.setValue(param,value);
        }

        public void setDoubleParam(String param){
            this.declareParameter(new SqlParameter(param,Types.DOUBLE));
        }
        public void setDouleParam(String param,Object value){
            this.declareParameter(new SqlParameter(param,Types.DOUBLE));
            this.setValue(param,value);
        }
        public void setIntegerParam(String param){
            this.declareParameter(new SqlParameter(param,Types.INTEGER));
        }
        public void setIntegerParam(String param,Object value){
            this.declareParameter(new SqlParameter(param,Types.INTEGER));
            this.setValue(param,value);
        }


        public void setOutParamCursor(String param){this.declareParameter(new SqlOutParameter(param, OracleTypes.CURSOR));}
        public void setOutParamCursor(String param,Class clazz){
            this.declareParameter(  new SqlOutParameter(param,OracleTypes.CURSOR,new BeanPropertyRowMapper<Object>(clazz)));
        }


        public void setVarcharOutParam(String param){
            this.declareParameter(new SqlOutParameter(param,Types.VARCHAR));
        }
        public void setVarcharOutParm(String param,Object value){
            this.declareParameter(new SqlOutParameter(param,Types.VARCHAR));
            this.setValue(param,value);
        }
        public void setDoubleOutParam(String param){
            this.declareParameter(new SqlOutParameter(param,Types.DOUBLE));
        }
        public void setIntegerOutParam(String param){
            this.declareParameter(new SqlOutParameter(param,Types.INTEGER));
        }
        public void setInParam(String param,int valueType){
            this.declareParameter(new SqlParameter(param,valueType));
        }
        public void setOutParam(String param,int valueType){
            this.declareParameter(new SqlOutParameter(param,valueType));
        }


    public Map execute() {
        if (this.getSql() == null || this.getSql().equals("")) {
            return null;
        }
        this.compile();
        return execute(this.map);
    }
}
