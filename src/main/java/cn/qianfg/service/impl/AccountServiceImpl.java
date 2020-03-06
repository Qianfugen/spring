package cn.qianfg.service.impl;

import cn.qianfg.dao.AccountDao;
import cn.qianfg.factory.BeanFactory;
import cn.qianfg.service.AccountService;

public class AccountServiceImpl implements AccountService {
//    private AccountDao accountDao=new AccountDaoImpl();
    private AccountDao accountDao= (AccountDao) BeanFactory.getBean("accountDao");

//    private int i=1;

    @Override
    public void saveAccount() {
        int i=1;
        accountDao.saveAccount();
        System.out.println(i);
        i++;
    }
}
