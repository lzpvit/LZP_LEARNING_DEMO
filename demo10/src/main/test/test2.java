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
 * Created by LZP on 2017/7/25.
 * 这里是spring接管sessionfactory后的部分测试
 */
public class test2 {
    ApplicationContext applicationContext;
    SessionFactory sessionFactory;
    Session session;
    Transaction transaction;
    @Before
    public void init(){
    }
    @After
    public void destroy(){
        transaction.commit();
        session.close();
        sessionFactory.close();
    }
    @Test
    public void test(){
        applicationContext=new ClassPathXmlApplicationContext("applicationContext.xml");
        sessionFactory=(SessionFactory) applicationContext.getBean("sessionFactory");
        session=sessionFactory.openSession();
        transaction=session.beginTransaction();
        CompanyInfo companyInfo=new CompanyInfo(1292,"lk","ll","hg","hy","ht","hub");
        session.save(companyInfo);
    }


}
