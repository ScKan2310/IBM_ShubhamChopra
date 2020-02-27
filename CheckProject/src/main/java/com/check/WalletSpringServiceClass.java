package com.check;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@Component("serviceclass")
public class WalletSpringServiceClass implements WalletSpringServiceInterface {
	@Autowired
	WalletSpringDaoClass d;


	public WalletSpringDaoClass WalletSpringServiceClass() {
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("contextFile.xml");
		d = context.getBean("daoclass",WalletSpringDaoClass.class);
		return d;
	}
	@Override
	public boolean serveInsert(BeanVariable b) {
		return d.insertData(b);
	}
	
	@Override
	public boolean serveUpdateName(BeanVariable b) {
	 return d.updateName(b);	
	}
	
	@Override
	public boolean serveUpdateNumber(BeanVariable b) {
	 return d.updateNumber(b);	
	}
	
	@Override
	public int serveGetBalance(BeanVariable b) {
		return d.getBalance(b);
	}
	
	@Override
	public boolean serveDepositInAccount(BeanVariable b) {
		return d.depositInAccount(b);
	}
	
	@Override
	public boolean serveWithdrawFromAccount(BeanVariable b) {
		return d.withdrawFromAccount(b);
	}

	public List<BeanVariable> serveGetTransaction(BeanVariable b) {
		return d.getTransaction(b);
	}
	
	@Override
	public List<BeanVariable> serveGetAllData(BeanVariable b) {
		return d.getAllData(b);
	}

}
