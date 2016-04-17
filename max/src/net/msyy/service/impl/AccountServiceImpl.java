package net.msyy.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import net.msyy.dao.AcountDao;
import net.msyy.dao.OperatorDao;
import net.msyy.dao.RoleDao;
import net.msyy.model.Account;
import net.msyy.model.Operator;
import net.msyy.model.Role;
import net.msyy.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

	private AcountDao acountDaoImpl;
	
	private OperatorDao operatorDaoImpl;
	
	private RoleDao roleDaoImpl;
	
	@Resource
	public void setOperatorDaoImpl(OperatorDao operatorDaoImpl) {
		this.operatorDaoImpl = operatorDaoImpl;
	}

	@Resource
	public void setRoleDaoImpl(RoleDao roleDaoImpl) {
		this.roleDaoImpl = roleDaoImpl;
	}

	@Resource
	public void setAcountDaoImpl(AcountDao acountDaoImpl) {
		this.acountDaoImpl = acountDaoImpl;
	}

	@Override
	public Object queryAccountByNickOrCelphone(String param) {
		String sql = 
			"select password,act.account_id,opr.operator_id from account as act " +
			"inner join account_property_contact as apc on " +
				"apc.account_id = act.account_id " +
			"inner join account_property_identity as api on " +
				"api.account_id = act.account_id " +
			"inner join operator as opr on " +
				"opr.account_id = act.account_id " +
				"	where  " +
				"		api.nick = '" + param + "' " +
				" 	or apc.celphone = '"+ param + "'";
		List list = acountDaoImpl.findAllBySql(sql);
		if (list == null)
			return null;
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

	@Override
	public void saveOperator(Operator operator) {
		operatorDaoImpl.save(operator);
	}
	
	@Override
	public void updateAccount(Account account) {
		acountDaoImpl.update(account);
	}

	@Override
	public List getAccountByCelphone(String celphone) {
		String sql = "select * from account_property_contact as apc where apc.celphone = '"+celphone+"'";
		return acountDaoImpl.findAllBySql(sql);
	}

	@Override
	public void saveAccount(Account account) {
		acountDaoImpl.save(account);
	}

	@Override
	public void addRole(Role role) {
		roleDaoImpl.save(role);
	}

	@Override
	public Account getAccountById(int id) {
		return (Account) acountDaoImpl.findById(Account.class, id);
	}

	@Override
	public Object getAccountByParam(String param) {
		String sql = 
			"select password,act.account_id,stu.student_id from account as act " +
			"inner join account_property_contact as apc on " +
				"apc.account_id = act.account_id " +
			"inner join account_property_identity as api on " +
				"api.account_id = act.account_id " +
			"inner join student as stu on " +
				"stu.account_id = act.account_id " +
				"	where  " +
				"		api.nick = '" + param + "' " +
				" 	or apc.celphone = '"+ param + "'";
		List list = acountDaoImpl.findAllBySql(sql);
		if (list == null)
			return null;
		if (list.size() > 0) {
			return list.get(0);
		}
		return null;
	}

}
