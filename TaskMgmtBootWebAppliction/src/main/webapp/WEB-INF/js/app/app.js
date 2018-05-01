/**
 * 
 */

'use strict'
var TaskApp=angular.module("TaskMgmt",['ui.bootstrap','taskmgmt.controller','taskmgmt.services']);

TaskApp.constant("CONSTANTS",{
	
	 displayAllTask:"/TaskMgmt/displayTask",
	 addTask: "/TaskMgmt/addTask",
	 deleteTask:"/TaskMgmt/deleteTask",
	 markTask:"/TaskMgmt/markTask"
})
