package cn.qianfg.client;

import cn.qianfg.factory.BeanFactory;
import cn.qianfg.service.AccountService;

public class Client {
    public static void main(String[] args) {
//        AccountService accountService = new AccountServiceImpl();
        AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
        accountService.saveAccount();
    }
}
