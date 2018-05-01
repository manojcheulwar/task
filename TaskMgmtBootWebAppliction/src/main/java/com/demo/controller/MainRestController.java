package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dto.TaskDTO;
import com.demo.services.ITaskService;

@RestController
public class MainRestController {

	
	@Autowired
	ITaskService iTaskService;
	/**
	 * display list of tasks
	 * 
	 * @return
	 */
	@RequestMapping(value="/TaskMgmt/displaytask" , method=RequestMethod.GET)
	public List<TaskDTO> displayTask() {
		System.out.println("in MainRestController.displayTask ");
		return iTaskService.getAllTask();
	}

	/**
	 * add the task in the table
	 * 
	 * @return
	 */
	@RequestMapping(value="/TaskMgmt/addTask",method=RequestMethod.POST)
	public void addTask(@RequestBody TaskDTO taskDto) {
		
	
		System.out.println("Task Dto details"+taskDto.toString());
		iTaskService.addTask(taskDto);
	}

	/**
	 * delete the task from the table
	 * 
	 * @return
	 */
	@RequestMapping(value="/TaskMgmt/deleteTask",method=RequestMethod.DELETE)
	public void deleteTask(@RequestBody TaskDTO taskDto ) {
		iTaskService.deleteTask(taskDto.getTask_id());
	}

	
	/**
	 * mark the task completed in the table
	 * 
	 * @return
	 */
	@RequestMapping(value="/TaskMgmt/markTask", method=RequestMethod.POST)
	public void markTask(@RequestBody TaskDTO taskDto) {
		
		iTaskService.markTask(taskDto);
	}
}
