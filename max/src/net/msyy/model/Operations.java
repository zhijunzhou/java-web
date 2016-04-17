package net.msyy.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 *	业务操作记录: operations
 *	注：操作对象是老师或机构的id
 * @author Joe
 *
 */
@Entity(name = "operations")
public class Operations implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name = "operations_id")
	private int id;

	@JoinColumn(name="instructions_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=ManagementInstructions.class)
	private ManagementInstructions managementInstructions;// 操作码 和操作表对应

	@JoinColumn(name="operator_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Operator.class)
	private Operator operator; // 操作的运营人员id

	@JoinColumn(name="teacher_id")
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER,targetEntity=Teacher.class)
	private Teacher teacher;// 操作的对象 老师的id

	@Column(name = "op_time")
	@Temporal(TemporalType.DATE)
	private Date op_time;// 操作时间

	@Column(name = "op_detail")
	private String op_detail; // 操作细节描述

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ManagementInstructions getManagementInstructions() {
		return managementInstructions;
	}

	public void setManagementInstructions(
			ManagementInstructions managementInstructions) {
		this.managementInstructions = managementInstructions;
	}

	public Operator getOperator() {
		return operator;
	}

	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	public Teacher getTeacher() {
		return teacher;
	}

	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}

	public Date getOp_time() {
		return op_time;
	}

	public void setOp_time(Date op_time) {
		this.op_time = op_time;
	}

	public String getOp_detail() {
		return op_detail;
	}

	public void setOp_detail(String op_detail) {
		this.op_detail = op_detail;
	}
	
	
}
