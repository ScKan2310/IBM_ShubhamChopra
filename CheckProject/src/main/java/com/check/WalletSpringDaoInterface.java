package com.check;

import java.util.List;

import org.springframework.stereotype.Repository;

@Repository("daointerface")
public interface WalletSpringDaoInterface {
	
	boolean insertData(BeanVariable b);
	boolean updateName(BeanVariable b);
	boolean updateNumber(BeanVariable b);
	int getBalance(BeanVariable b);
	boolean checkBalance(BeanVariable b);
	boolean depositInAccount(BeanVariable b);
	boolean withdrawFromAccount(BeanVariable b);
	List<BeanVariable> getTransaction(BeanVariable b);
	List<BeanVariable> getAllData(BeanVariable b);
}
