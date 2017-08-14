import oracle.jdbc.OracleTypes;
import oracle.jdbc.oracore.OracleType;
import org.junit.Test;
import org.omg.CORBA.DATA_CONVERSION;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.CallableStatementCallback;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.StatementCallback;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by LZP on 2017/7/27.
 */
public class test4 {
    JdbcTemplate jdbcTemplate;
    @Test
    public void test(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        String as=(String) jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                        String storedProc = "{call GREETING_OUT(?,?)}";
                        CallableStatement callableStatement = connection.prepareCall(storedProc);
                        callableStatement.setString(1, "htinglp");
                        callableStatement.registerOutParameter(2, OracleTypes.VARCHAR);
                        return callableStatement;
                    }
                }, new CallableStatementCallback() {
                    public Object doInCallableStatement(CallableStatement callableStatement)throws SQLException,DataAccessException{
callableStatement.execute();
return callableStatement.getString(2);
                    }
                }
        );
        System.out.println(as);
    }
    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        jdbcTemplate=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        String as=(String) jdbcTemplate.execute(
                new CallableStatementCreator() {
                    public CallableStatement createCallableStatement(Connection connection) throws SQLException {
                        String storedProc = "{call GREETING_OUT1(?,?,?)}";
                        CallableStatement callableStatement = connection.prepareCall(storedProc);
                        callableStatement.setString(1, "hutinglp");
                        callableStatement.setString(2,"lzplg");
                        callableStatement.registerOutParameter(3, OracleTypes.VARCHAR);
                        return callableStatement;
                    }
                }, new CallableStatementCallback() {
                    public Object doInCallableStatement(CallableStatement callableStatement)throws SQLException,DataAccessException{
                        callableStatement.execute();
                        return callableStatement.getString(3);
                    }
                }
        );
        System.out.println(as);
    }

}
