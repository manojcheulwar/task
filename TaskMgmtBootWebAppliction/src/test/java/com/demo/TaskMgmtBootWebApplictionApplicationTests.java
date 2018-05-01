package com.demo;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.demo.dto.TaskDTO;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TaskMgmtBootWebApplictionApplicationTests {

	//@Autowired
	//RestTemplate restTemplate;
     
	
	@Test
	public void contextLoads() {
	}
	
	
	
	@Test
	public void testDisplayTasks() {
		System.out.println("in testDisplayTasks size=");  
		
		List<TaskDTO> list = getRestTemplate().getForObject("http://localhost:8080/displaytask", List.class);
        System.out.println("in testDisplayTasks size="+list.size());  
		
		for (TaskDTO dto : list) {
			
			System.out.println("dto"+dto.getTask_name());

		}
	}

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}

}
