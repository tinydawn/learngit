package pres.yang.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import pres.yang.dao.AccountDao;
import pres.yang.dao.impl.AccountDaoImpl;
import pres.yang.service.AccountService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.annotation.Resource;

/**
 * @author tinydawn
 * @version 2020/5/24 9:50 V1.0
 **/


/**
 * 注解的分类：
 * 1.用于创建对象的：
 *    他们的作用就和在xml中的bean标签实现功能是一样的
 *    (1) @Compoent:用于把当前类存入Spring容器中。
 *        属性：value 用于指定bean的id.当我们不写时，它的默认值是当前类名，且首字母小写。
 *    (2) @Controller:一般用在表现层
 *        @Service:一般用在业务层
 *        @Repository:一般用在持久层
 *        以上三个注解他们的作用和@Compoent是一模一样的，它们是Spring为我们提供的明确的三层使用注解，使我们的
 *        三层更加清晰。
 *        注意：它们的功能都是一样的，都是将当前类放到Spring容器中。所以实际上你使用哪一个都是一样的。之所以设计三个，仅仅
 *        是为了明确，该类属于哪一层。
 *
 * 2.用于注入数据的
 *    它们的作用就和在xml中<bean></bean>的property标签作用是一样的
 * 3.用于改变作用范围的
 *   scope
 * 4.和生命周期相关的
 *   init-method,destory-method
 *
 */
@Repository("accountserice")
public class AccountServiceImpl implements AccountService {
//    @Autowired
//    @Qualifier("accountdao2")  //必须和Autowired一起使用，否则不能注入成功。这是给类成员注入
    @Resource(name = "accountdao2")
    private AccountDao accountdao ;
    @Override
    public void saveAccount() {
        accountdao .saveAccount();
    }


    //Spring 创建的时候会
    public AccountServiceImpl() {
        System.out.println("Service 实现类创建了");
    }

    @PostConstruct
    public void init() {
        System.out.println("Service初始化了");
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Service销毁了");
    }
}
