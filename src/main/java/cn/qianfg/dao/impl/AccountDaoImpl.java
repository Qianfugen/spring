package cn.qianfg.dao.impl;

import cn.qianfg.dao.AccountDao;

public class AccountDaoImpl implements AccountDao {
    @Override
    public void saveAccount() {
        System.out.println("保存账户成功！");
    }
}
