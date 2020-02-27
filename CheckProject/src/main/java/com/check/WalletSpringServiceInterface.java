package com.check;

import java.util.List;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("serviceinterface")
public interface WalletSpringServiceInterface {
	boolean serveInsert(BeanVariable b);
	boolean serveUpdateName(BeanVariable b);
	boolean serveUpdateNumber(BeanVariable b);
	int serveGetBalance(BeanVariable b);
	boolean serveDepositInAccount(BeanVariable b);
	boolean serveWithdrawFromAccount(BeanVariable b);
	List<BeanVariable> serveGetTransaction(BeanVariable b);
	List<BeanVariable> serveGetAllData(BeanVariable b);
}
