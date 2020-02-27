package com.check;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;




@Repository("daoclass")
public class WalletSpringDaoClass implements WalletSpringDaoInterface {
	
	DataSource dataSource;
	NamedParameterJdbcTemplate template;
	
	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
		template = new NamedParameterJdbcTemplate(dataSource);
	}
	
	@Override
	public boolean insertData(BeanVariable b) {
		
		String insertQuery = "insert into accountDetails values(:accountNumber,:holderName,:holderContactNumber,:accountBalance)";
		
		if(template.update(insertQuery, new MapSqlParameterSource("accountNumber",b.getAccountNumber())
																.addValue("holderName", b.getHolderName())
																.addValue("holderContactNumber", b.getHolderContactNumber())
																.addValue("accountBalance", b.getAccountBalance()))>0)
			return true;
		else
			return false;
		
	}
	
	
	@Override
	public boolean updateName(BeanVariable b) {
		String queryNameUpdate = "update accountDetails set holderName = :holderName where accountNumber =:accountNumber";
		
		if(template.update(queryNameUpdate, new MapSqlParameterSource("holderName", b.getHolderName())
																	.addValue("accountNumber", b.getAccountNumber()))>0)
			return true;
		else
			return false;
	
	}
	
	@Override
	public boolean updateNumber(BeanVariable b) {
		String queryNumberUpdate = "update accountDetails set holderContactNumber = :holderContactNumber where accountNumber =accountNumber";
		
		if(template.update(queryNumberUpdate, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber())
																	.addValue("accountNumer", b.getAccountNumber()))>0)
			return true;
		else
			return false;
		
	}
	
	@Override
	public int getBalance(BeanVariable b) {
		String queryGetBalance = " select accountBalance from accountDetails where holderContactNumber = :holderContactNumber";
		
		return template.queryForObject(queryGetBalance, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class); 
	
	}
	
	public boolean checkBalance(BeanVariable b) {
		String checkBalance = "select accountBalance from accountDetails where accountNumber = :accountNumber";
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber = :holderContactNumber";
		
		b.setAccountNumber(template.queryForObject(queryGetAccountNumber, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class));
		
		int balance = template.queryForObject(checkBalance, new MapSqlParameterSource("accountNumber",b.getAccountNumber()), Integer.class);
		if(balance>b.getTransctionAmount())
			return true;
		else
			return false;
	}
	
	@Override
	public boolean depositInAccount(BeanVariable b) {
		int flag=0;
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) value (:accountNumber,:transactionAmount,:transactionTime)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber = :holderContactNumber";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance + :transactionAmount  WHERE accountNumber = :accountNumber";
	
		b.setAccountNumber(template.queryForObject(queryGetAccountNumber, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class));
		
		if(template.update(queryUpdateAccountBalance, new MapSqlParameterSource("transactionAmount",b.getTransctionAmount())
																			.addValue("accountNumber", b.getAccountNumber()))>0)
			flag=flag+1;
		
		if(template.update(queryDeposit, new MapSqlParameterSource("accountNumber",b.getAccountNumber())
																.addValue("transactionAmount", b.getTransctionAmount())
																.addValue("transactionTime", b.getTransactionTime()))>0)
			flag=flag+1;
		
		if(flag==2)
			return true;
		else
			return false;
	}
	
	
	
	
	public boolean withdrawFromAccount(BeanVariable b) {
		int flag=0;
		String queryDeposit = "insert into transactionDetails(accountNumber,transactionAmount,transactionTime) value (:accountNumber,:transactionAmount,:transactionTime)";
		
		String queryGetAccountNumber = "select accountNumber from accountDetails where holderContactNumber = :holderContactNumber";
		
		String queryUpdateAccountBalance = "UPDATE accountDetails SET accountBalance = accountBalance - :transactionAmount  WHERE accountNumber = :accountNumber";
		if(checkBalance(b)) {	
			b.setAccountNumber(template.queryForObject(queryGetAccountNumber, new MapSqlParameterSource("holderContactNumber",b.getHolderContactNumber()), Integer.class));
			if(template.update(queryUpdateAccountBalance, new MapSqlParameterSource("transactionAmount",b.getTransctionAmount())
					.addValue("accountNumber", b.getAccountNumber()))>0)
				flag=flag+1;

			if(template.update(queryDeposit, new MapSqlParameterSource("accountNumber",b.getAccountNumber())
																		.addValue("transactionAmount", b.getTransctionAmount())
																		.addValue("transactionTime", b.getTransactionTime()))>0)
				flag=flag+1;

		}
		else
			System.out.println("low balance");
		
		if(flag==2)
			return true;
		else
			return false;
	}		
	
	public List<BeanVariable> getTransaction(BeanVariable b) {
		String queryGet = "select * from transactionDetails";
		return template.query(queryGet, new TransactionMapper());
	
	}
	
	public List<BeanVariable> getAllData(BeanVariable b) {
		String queryGet = "select * from accountDetails";
		return template.query(queryGet, new AccountMapper());
	}
	
	class TransactionMapper implements RowMapper<BeanVariable>{
		
		@Override
		public BeanVariable mapRow(ResultSet rs, int rowNum) throws SQLException {
			BeanVariable b = new BeanVariable();
			b.setTransactionNumber(rs.getInt("transcationNumber"));
			b.setTransctionAmount(rs.getInt("transactionAmount"));
			b.setTransactionTime(rs.getDate("transactionTime"));
			b.setAccountNumber(rs.getInt("accountNumber"));
			return b;
		}
	}
	
	class AccountMapper implements RowMapper<BeanVariable>{
		
		@Override
		public BeanVariable mapRow(ResultSet rs, int rowNum) throws SQLException {
			BeanVariable b = new BeanVariable();
			b.setAccountNumber(rs.getInt("accountNumber"));
			b.setHolderName(rs.getString("holderName"));
			b.setHolderContactNumber(rs.getDouble("holderContactNumber"));
			b.setAccountBalance(rs.getInt("accountBalance"));
			return b;
		}
	}
}
