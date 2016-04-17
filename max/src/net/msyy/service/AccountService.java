package net.msyy.service;

import java.util.List;

import net.msyy.model.Account;
import net.msyy.model.Operator;
import net.msyy.model.Role;


public interface AccountService {

	public Object queryAccountByNickOrCelphone(String param);
	
	public void updateAccount(Account account);
	
	public void saveOperator(Operator operator);
	
	public void saveAccount(Account account);
	
	public void addRole(Role role);
	
	public List getAccountByCelphone(String celphone);
	
	public Object getAccountByParam(String param);
	
	public Account getAccountById(int id);
}
