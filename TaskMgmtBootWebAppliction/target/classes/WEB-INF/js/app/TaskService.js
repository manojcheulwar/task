/**
 * 
 */
'use strict'
angular.module('taskmgmt.services',[]).factory('TaskService',["$http","CONSTANTS", functions($http,CONSTANTS)
	{
	    var service={};
	    
	    service.displayAllTask=function(userId){
	    	var url=CONSTANTS.displayAllTask;
	    	
	    	return $http.get(url);
	    }
	    
	    service.addTask=function(taskDto){
	    	return $http.post(CONSTANTS.addTask,taskDto);
	    	
	    }
	    
	    service.deleteTask=function(taskId){
	    	var url=CONSTANTS.deleteTask;
	    	
	    	return $http.get(url,taskId);
	    }
	    
	    service.markTask=function(taskId){
	    	var url=CONSTANTS.markTask;
	    	
	    	return $http.get(url,taskId);
	    }
	}])
