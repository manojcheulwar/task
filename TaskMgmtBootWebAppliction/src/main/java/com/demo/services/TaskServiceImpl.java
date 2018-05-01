package com.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.dao.ITaskDao;
import com.demo.dto.TaskDTO;

@Service
public class TaskServiceImpl implements ITaskService {

	/** return all the task
	 * @return
	 */
	@Autowired
	ITaskDao taskMgmtDao;
	
	public List<TaskDTO> getAllTask() {
		
		System.out.println("in TaskServiceImpl.getAllTask ");
		return taskMgmtDao.getAllTask();
	}

	/** it will add the task
	 * @param taskDto
	 */
	public void addTask(TaskDTO taskDto) {
		taskMgmtDao.addTask(taskDto);
	}

	/** delete the task
	 * @param taskDto
	 * @return
	 */
	public void deleteTask(Integer taskId) {
		
		taskMgmtDao.deleteTask(taskId);
		
	}
	
	public void markTask(TaskDTO taskDto)
	{
		
		taskMgmtDao.markTask(taskDto);
	}

}
