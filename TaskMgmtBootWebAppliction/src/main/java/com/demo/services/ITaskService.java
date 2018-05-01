package com.demo.services;

import java.util.List;

import com.demo.dto.TaskDTO;

public interface ITaskService {
	
	List<TaskDTO> getAllTask() ;
	
	public void addTask(TaskDTO taskDto);
	
	public void deleteTask(Integer taskDto);
	
	public void markTask(TaskDTO taskDto);
	
}
