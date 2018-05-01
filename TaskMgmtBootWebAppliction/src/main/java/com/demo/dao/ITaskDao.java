package com.demo.dao;

import java.util.List;

import com.demo.dto.TaskDTO;

public interface ITaskDao {

	public List<TaskDTO> getAllTask();

	public void addTask(TaskDTO taskDto);

	public void deleteTask(Integer taskId);
	
	public void markTask(TaskDTO taskDto);

}
