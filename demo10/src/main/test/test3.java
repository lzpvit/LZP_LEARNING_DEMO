import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.CompanyInfo;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by LZP on 2017/7/27.
 */
public class test3 {
    private JdbcTemplate jdbcTemplate;
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate=jdbcTemplate;
    }
    @Test
    public  void test() {

        ApplicationContext applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
    jdbcTemplate=(JdbcTemplate)applicationContext.getBean("jdbcTemplate");
        setJdbcTemplate(jdbcTemplate);
        int n=0;
        this.jdbcTemplate.execute("call GREETINGS()");
        System.out.println(n);
    }
}
