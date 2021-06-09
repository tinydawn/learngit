package pres.yang.ui;

import org.junit.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import pres.yang.dao.AccountDao;
import pres.yang.service.AccountService;
import pres.yang.service.impl.AccountServiceImpl;

/**
 * @author tinydawn
 * @version 2020/5/24 9:54 V1.0
 **/
public class Client {
    public static void main(String[] args) throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        AccountService service = new AccountServiceImpl();
        service.saveAccount();
//        service.saveAccount();
    }


    /**
     * 获取Spring核心容器。
     */
    @Test
    public void fun1() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService service = (AccountService)context.getBean("AccountService");
        AccountDao accountDao = (AccountDao) context.getBean("AccountDao");
        System.out.println("service = " + service);
        System.out.println("accountDao = " + accountDao);
    }

    @Test
    public void fun2() {
        Resource resource = new ClassPathResource("bean.xml");
        BeanFactory beanFactory = new XmlBeanFactory(resource);
        AccountService accountService =(AccountService) beanFactory.getBean("AccountService");
        System.out.println(accountService);
    }

    /**
     *
     */

    @Test
    public void fun3() {
        ApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        System.out.println(context.getBean("accountserice"));

        AccountDao accountDao =(AccountDao) context.getBean("accountDaoImpl");
        accountDao.saveAccount();
    }

    @Test
    public void fun4() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("bean.xml");
        AccountService accountserice = (AccountService) context.getBean("accountserice");
        //因为它是单例的，所以不会再执行初始化方法和构造方法了。如果是单例的，那么初始化方法和构造方法只会执行一次。
        AccountService accountserice1 = (AccountService) context.getBean("accountserice");
        System.out.println(accountserice == accountserice1);
        context.close();
    }

}
