import dao.StoredProcedureTemplate;
import oracle.jdbc.OracleTypes;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import pojo.TempTeacher;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created by LZP on 2017/7/28.
 * storedprocedure方式对存储过程的调用
 */
public class test5 {
    //storedprocudure调用无参数过程
    @Test
    public void test() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = (JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        StoredProcedureTemplate storedProcedureTemplate = new StoredProcedureTemplate();
        storedProcedureTemplate.setJdbcTemplate(jdbcTemplate);
        storedProcedureTemplate.setSql("GREETINGS");
        Map result = storedProcedureTemplate.execute();
        for (Iterator iterator = result.entrySet().iterator(); iterator.hasNext(); ) {
            System.out.println(iterator.next());
        }
    }


    @Test
    public void test1(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        StoredProcedureTemplate storedProcedureTemplate=new StoredProcedureTemplate();
        storedProcedureTemplate.setJdbcTemplate(jdbcTemplate);
        storedProcedureTemplate.setSql("cur_test6");
        storedProcedureTemplate.setVarcharParam("studentid","baoyi");
        storedProcedureTemplate.setVarcharOutParm("studentl", OracleTypes.VARCHAR);
        //storedProcedureTemplate.setOutParamCursor("my_cursor", Student.class);

      /*storedProcedureTemplate.setReturnParam("rows",new StudentMapper());
        storedProcedureTemplate.setIntegerParam("@parama");
        storedProcedureTemplate.setValue("@parama",1);*/
        Map map=storedProcedureTemplate.execute();
        System.out.println(map);
       // Object o=map.get("rows");
    }
    @Test
    public void test3(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        StoredProcedureTemplate storedProcedureTemplate=new StoredProcedureTemplate();
        storedProcedureTemplate.setJdbcTemplate(jdbcTemplate);
        storedProcedureTemplate.setSql("cur_test7");
        storedProcedureTemplate.setVarcharParam("teachername","lzp");
        //storedProcedureTemplate.setOutParamCursor("my_cursor",pojo.TempTeacher.class);
        Map map=storedProcedureTemplate.execute();
      //  System.out.println(map);
    }

    @Test
    public void test4(){
        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate=(JdbcTemplate) applicationContext.getBean("jdbcTemplate");
        StoredProcedureTemplate storedProcedureTemplate=new StoredProcedureTemplate();
        storedProcedureTemplate.setJdbcTemplate(jdbcTemplate);
        storedProcedureTemplate.setSql("cur_test8");
        storedProcedureTemplate.setVarcharParam("teachername","lzp");
        storedProcedureTemplate.setOutParamCursor("my_cursor", TempTeacher.class);
        Map map=storedProcedureTemplate.execute();
        Object o=map.get("my_cursor");
        List<TempTeacher> list= (List<TempTeacher>)o;
        System.out.println(list);
        Iterator<TempTeacher>iterator=list.iterator();
        while (iterator.hasNext()){
            TempTeacher tempTeacher=iterator.next();
            System.out.print(tempTeacher.getTeacher_id());
            System.out.println("   "+tempTeacher.getTeacher_name());
        }
        System.out.println(map);
    }
}
