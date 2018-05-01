/**
 * Angular JS controller 
 */
'use strict'
var taskmodule = angular.module('taskmgmt.controller',[]);
taskmodule.controller("TaskController",['$scope',"TaskService",
  function($scope,TaskService)
  {
	 $scope.taskDto={
			 task_id : null,
			 task_name : null,
			 task_description : null,
			 task_start_time : null,
			 task_end_time : null,
			 task_duration: null,
			 task_priority : null,
			 task_completed : null
	 };
	 
	 TaskService.addTask($scope.taskDto).then(function() {
         console.log("taskDto");
         TaskService.displayAllTask().then(function(value) {
             $scope.taskDtoList = value.data;
         }, function(reason) {
             console.log("error in addTask");
         }, function(value) {
             console.log("no callback");
         });
         
	 });
	 
	 TaskService.markTask($scope.taskDto).then(function() {
         console.log("taskDto");
         TaskService.displayAllTask($scope.taskDto.taskId).then(function(value) {
             $scope.taskDtoList = value.data;
         }, function(reason) {
             console.log("error in addTask");
         }, function(value) {
             console.log("no callback");
         });
         
	 });
	 
	 
	 , function(reason) {
         console.log("error occured");
     }, function(value) {
         console.log("no callback");
     });
 }
}
]);