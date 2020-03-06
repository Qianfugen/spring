package cn.qianfg.client;

import cn.qianfg.factory.BeanFactory;
import cn.qianfg.service.AccountService;

public class Client {
    public static void main(String[] args) {
//        AccountService accountService = new AccountServiceImpl();
        for (int i = 0; i < 5; i++) {
            AccountService accountService = (AccountService) BeanFactory.getBean("accountService");
            System.out.println(accountService);
            accountService.saveAccount();
        }
    }
}
