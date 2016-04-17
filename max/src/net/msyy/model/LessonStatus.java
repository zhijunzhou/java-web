package net.msyy.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * 课程安排监控属性:lesson_status
 * @author Joe
 *
 */
@Entity(name="lesson_status")
public class LessonStatus {

	@Id
	@Column(name = "lesson_status_id")
	@GeneratedValue
	private int id;
	
	private String status;
	
	private int presents_num;
	
	private int req_num;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPresents_num() {
		return presents_num;
	}

	public void setPresents_num(int presents_num) {
		this.presents_num = presents_num;
	}

	public int getReq_num() {
		return req_num;
	}

	public void setReq_num(int req_num) {
		this.req_num = req_num;
	}
	
	
}
