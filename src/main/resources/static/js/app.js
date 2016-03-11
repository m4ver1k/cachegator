"use strict";

var gatorApp = angular.module('app', ['ngRoute','gatorControllers','ui.grid', 'ui.grid.edit']);
 

gatorApp.config(['$routeProvider',
	function($routeProvider) {
	  $routeProvider.
	    when('/home', {
	      templateUrl: '../home.html',
	      controller: 'home'
	    }).
	    when('/connection',{ //add connection
	    	templateUrl:'../connections.tpl',
	    	controller:'connection'
	    }).
	    when('/connectionList',{
	    	templateUrl:'../connectionList.tpl',
	    	controller:'connection'
	    }).
	    when('/connectionEdit',{
	    	templateUrl:'../connectionEdit.tpl',
	    	controller:'EditConnection'
	    }).
	    when('/cacheList',{
	    	templateUrl:'../cacheList.tpl',
	    	controller:'cache'
	    }).
	    when('/cacheDetails/:cacheId',{
	    	templateUrl:'../cacheDetails.tpl',
	    	controller:'cacheDetail'
	    }).
	    when('/cacheAdd',{
	    		templateUrl:'../cacheAdd.tpl',
	    		controller:'cache'
	    }).
	    when('/cacheEdit',{
    		templateUrl:'../cacheEdit.tpl',
    		controller:'cacheEdit'
	    }).
	    otherwise({
	      redirectTo: '/home'
	    });
	}]);