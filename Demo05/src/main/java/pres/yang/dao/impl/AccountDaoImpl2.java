package pres.yang.dao.impl;

import org.springframework.stereotype.Repository;
import pres.yang.dao.AccountDao;

/**
 * @author tinydawn
 * @version 2020/5/24 9:51 V1.0
 **/
@Repository("accountdao2")
public class AccountDaoImpl2 implements AccountDao{
    @Override
    public void saveAccount() {
        System.out.println("保存了账户2222");
    }
}
