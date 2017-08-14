import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import pojo.CompanyInfo;
import pojo.Student;
import pojo.Teacher;

/**
 * Created by LZP on 2017/7/25.
 * 这里的代码需要将数据库配置放在hibernate.cfg.xml
 */
public class test1 {
    Configuration configuration;
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    @Before
    public void init(){
      configuration=new Configuration().configure();
      sessionFactory=configuration.buildSessionFactory();
      session=sessionFactory.getCurrentSession();
      transaction=session.beginTransaction();
    }
    @After
    public  void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void test(){
        /*
        CompanyInfo companyInfo=new CompanyInfo();
        companyInfo.setId(1291);
        companyInfo.setCode("1245");
        session.save(companyInfo);*/
      // Teacher teacher=new Teacher(5,"huxiaoting");
        Teacher teacher =session.get(Teacher.class,1);
      Student student=new Student(10,"zhitao",teacher);

      //  Student student=session.get(Student.class,5);
        // session.delete(student);

      // session.save(teacher);
       session.save(student);


    }
}
