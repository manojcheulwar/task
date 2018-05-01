<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Task Management</title>
<script
	src="//ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script type="text/javascript">
  var app = angular.module('myapp', []);

  app.controller('taskcontroller', function($scope, $http) {
  $scope.tasks = []
  $scope.task = {
		  	 task_id : null,
			 task_name : null,
			 task_description : null,
			 task_start_time : null,
			 task_end_time : null,
			 task_duration: null,
			 task_priority : null,
			 task_completed : null
   };

  getTaskDetails();

  function getTaskDetails() {
  $http({
    method : 'GET',
    url : '/TaskMgmt/displaytask'
   }).then(function successCallback(response) {
   $scope.tasks = response.data;
   }, function errorCallback(response) {
    console.log(response.statusText);
   });
  }

  $scope.processTask = function() 
  {
	alert("processtask"+$scope.taskForm);
    
	$http({
    method : 'POST',
    url : '/TaskMgmt/addTask',
    data : angular.toJson($scope.taskForm),
    headers : {
    'Content-Type' : 'application/json'
    
    }
    }).then(clearForm())
      .success(function(data){
       // $scope.tasks= data;
      });
	$scope.getTaskDetails();
  }
  $scope.marktask = function(task) 
  {

	  $http({
		    method : 'POST',
		    url : '/TaskMgmt/markTask',
		    data : angular.toJson(task),
		    headers : {
		    'Content-Type' : 'application/json'
		    }
		    }).then(getTaskDetails());
	  $scope.getTaskDetails();
  }
  $scope.deletetask = function(task) {
   $http({
     method : 'DELETE',
     url : '/TaskMgmt/deleteTask',
     data : angular.toJson(task),
     headers : {
     'Content-Type' : 'application/json'
   }
   }).then(getTaskDetails());
   $scope.getTaskDetails();
  }
 
  function clearForm() {
	  $scope.taskForm.task_name=	"";
	  $scope.taskForm.task_description=	"";
	  $scope.taskForm.task_start_time=	"";
	  $scope.taskForm.task_end_time=	"";
	  $scope.taskForm.task_duration	=	"";
	  $scope.taskForm.task_priority=	"";
	  $scope.taskForm.task_completed	=	"";
   
  };
 
 });
</script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
</head>
<body ng-app="myapp" ng-controller="taskcontroller">

	<center><h3>Task Management</h3>	</center>
	</center>
	<form ng-submit="processTask()">
		<div class="table-responsive" align="center">
			<table class="table table-bordered" style="width: 600px">
				<tr>
					<td><label>Task Name</label></td>
					<td><input type="text" ng-model="taskForm.task_name"
						class="input-sm spacing" /></td>
				</tr>

				<tr>
					<td><label>Task Description</label>
					<td><input type="text" ng-model="taskForm.task_description"
						class="input-sm spacing" /></td>
				</tr>

				<tr>
					<td><label>Task Start Time</label></td>
					<td><input type="text" ng-model="taskForm.task_start_time"
						class="input-sm spacing" /></td>
				</tr>

				<tr>
					<td><label>Task End Time</label></td>
					<td><input type="text" ng-model="taskForm.task_end_time"
						class="input-sm spacing" /></td>
				</tr>
				<tr>
					<td><label>Task Duration</label></td>
					<td><input type="text" ng-model="taskForm.task_duration"
						class="input-sm spacing" /></td>
				</tr>

				<tr>
					<td><label>Task Priority</label></td>
					<td><input type="text" ng-model="taskForm.task_priority"
						class="input-sm spacing" /></td>
				</tr>

				<tr>
					<td><label>Task Completed</label></td>
					<td><input type="text" ng-model="taskForm.task_completed"
						class="input-sm spacing" /></td>
				</tr>
				<tr>
					<td>
						<button type="submit" class="btn btn-sm btn-info">Add Task</button>
					</td>
					<td>
						<button type="reset" class="btn btn-sm btn-info">Clear Form</button>
					</td>
				</tr>
			</table>
		</div>
	</form>
	<center>
		<h3>Registered tasks</h3>
	</center>
	<div class="table-responsive" align="center">
		<table class="table table-bordered" style="width: 600px">
			<tr>
				<th>Task Id</th>
				<th>Task Name</th>
				<th>Task Description</th>
				<th>Task Start Time</th>
				<th>Task End Time</th>
				<th>Task Duration</th>
				<th>Task Priority</th>
				<th>Task Completed</th>
				<th></th>
				<th></th>
			</tr>
			<tr ng-repeat="task in tasks">
				<td>{{task.task_id}}</td>
				<td>{{task.task_name}}</td>
				<td>{{task.task_description}}</td>
				<td>{{task.task_start_time}}</td>
				<td>{{task.task_end_time}}</td>
				<td>{{task.task_duration}}</td>
				<td>{{task.task_priority}}</td>
				<td>{{task.task_completed}}</td>

				<td><a ng-click="marktask(task)" class="btn btn-primary btn-sm">Mark
						Completed</a></td>
				<td><a ng-click="deletetask(task)"
					class="btn btn-danger btn-sm">Delete</a></td>
			</tr>
		</table>
	</div>
</body>
</html>