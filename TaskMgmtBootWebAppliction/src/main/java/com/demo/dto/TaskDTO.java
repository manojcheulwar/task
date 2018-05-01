package com.demo.dto;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TASK_MGMT")
public class TaskDTO implements Serializable {

	@Id
	@Column(name = "task_Id")
	public int task_id;

	@Column(name = "TASK_NAME")
	public String task_name;

	@Column(name = "TASK_DESCRIPTION")
	public String task_description;

	@Column(name = "TASK_START_TIME")
	public String task_start_time;

	@Column(name = "TASK_END_TIME")
	public String task_end_time;

	@Column(name = "TASK_DURATION")
	public String task_duration;

	@Column(name = "TASK_COMPLETED")
	public String task_completed;

	
   @Column(name = "TASK_PRIORITY") 
   public String task_priority;
  
   
	

	public int getTask_id() {
	return task_id;
}

public void setTask_id(int task_id) {
	this.task_id = task_id;
}

	public String getTask_name() {
		return task_name;
	}

	public void setTask_name(String task_name) {
		this.task_name = task_name;
	}

	public String getTask_description() {
		return task_description;
	}

	public void setTask_description(String task_description) {
		this.task_description = task_description;
	}

	public String getTask_start_time() {
		return task_start_time;
	}

	public void setTask_start_time(String task_start_time) {
		this.task_start_time = task_start_time;
	}

	public String getTask_end_time() {
		return task_end_time;
	}

	public void setTask_end_time(String task_end_time) {
		this.task_end_time = task_end_time;
	}

	public String getTask_duration() {
		return task_duration;
	}

	public void setTask_duration(String task_duration) {
		this.task_duration = task_duration;
	}

	public String getTask_completed() {
		return task_completed;
	}

	public void setTask_completed(String task_completed) {
		this.task_completed = task_completed;
	}
	
	

	public String getTask_priority() {
		return task_priority;
	}

	public void setTask_priority(String task_priority) {
		this.task_priority = task_priority;
	}

	@Override
	public String toString() {
		return "TaskDTO [taskId=" + task_id + ", task_name=" + task_name + ", task_description=" + task_description
				+ ", task_start_time=" + task_start_time + ", task_end_time=" + task_end_time + ", task_duration="
				+ task_duration + ", task_completed=" + task_completed + "]";
	}

}
