package com.demo.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.task.TaskRejectedException;
import org.springframework.stereotype.Repository;

import com.demo.dto.TaskDTO;
import com.demo.repository.ITaskRepository;

@Repository
public class TaskMgmtDaoImpl implements ITaskDao {

	@Autowired
	ITaskRepository taksRepository;

	public List<TaskDTO> getAllTask() {

		System.out.println("in TaskMgmtDaoImpl.getAllTask ");
		List<TaskDTO> dtoList = taksRepository.findAll();
		return dtoList;
	}

	public void addTask(TaskDTO taskDto) {

		
		taksRepository.save(taskDto);

	}

	public void deleteTask(Integer taskId) {

		if (taskId != null) {
			taksRepository.delete(taskId);
		}

	}

	public void markTask(TaskDTO taskDto)
	{
		System.out.println("taskDto.getTask_id()"+taskDto.getTask_id());
		TaskDTO taskDtoTemp=taksRepository.findOne(taskDto.getTask_id());
		taskDtoTemp.setTask_completed("Y");
		TaskDTO taskDtoTemp12= taksRepository.save(taskDtoTemp);
		System.out.println(taskDtoTemp12.toString());
	}
	
	
}
