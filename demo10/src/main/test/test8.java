import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import pojo.CompanyInfo;

/**
 * Created by LZP on 2017/8/9.
 */
public class test8{
    ApplicationContext applicationContext;
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    @Before
    public void init(){
       applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
       sessionFactory =(SessionFactory) applicationContext.getBean("sessionFactory");
       session = sessionFactory.openSession();
       transaction = session.beginTransaction();
    }
    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void test1(){
        CompanyInfo companyInfo=new CompanyInfo(1299,"lk","ll","hg","hy","ht","hub");
        session.save(companyInfo);
    }
}

