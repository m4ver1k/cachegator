/**
 * 
 */
"use strict";
var gatorControllers = angular.module('gatorControllers', []);



gatorControllers.controller('home', function($scope, $http) {
  $http.get('/api/home').success(function(data) {
    $scope.greeting = data;
  })
 
});

gatorControllers.controller('EditConnection',function($scope, $http,$window){

	$http.get("/api/config/connection").success(function (response){
		$scope.conDetails=response;
	});
	
	$("#conList").change(function(){
		$http.get("/api/config/connection/"+$("#conList :selected").val()).success(function (data){
			$scope.id=data.id;
			$scope.conHost=data.host;
			$scope.conName=data.name;
			$scope.conPort=data.port;
		});
		 
	});
	
	$scope.editConnection = function(){
		  var data ={};
		  data.id= $scope.id;
		  data.host= $scope.conHost;
		  data.name= $scope.conName;
		  data.port= $scope.conPort;
	    	$http.put("/api/config/connection",data).then(function successCB(response){
	    		$("#conSave").modal();
	    		$('#conSave').on('hidden.bs.modal', function (e) {
	    			$window.location.href = '#/connectionList';
	    		})
	    		
	    	}, function errorCB(){
	    		
	    	});
		  
	  }
	
});

gatorControllers.controller('connection',function($scope, $http,$window){

	$http.get("/api/config/connection").success(function (response){
		console.log(JSON.stringify(response));
		$scope.conDetails=response;
	});
	
	
	
	
	$scope.saveConnection = function(){
		  var data ={};
		  data.host= $scope.conHost;
		  data.name= $scope.conName;
		  data.port= $scope.conPort;
	    	$http.post("/api/config/connection",data).then(function successCB(response){
	    		$("#conSave").modal();
	    		$('#conSave').on('hidden.bs.modal', function (e) {
	    			$window.location.href = '#/connectionList';
	    		})
	    		
	    		
	    	}, function errorCB(){
	    		
	    	});
		  
	  }
});

gatorControllers.controller('cache',function($scope,$http,$window){
	$http.get("/api/config/connection").success(function (response){
		$scope.conDetails=response;
	});
	
	$http.get("/api/cache").success(function (response){
		$scope.cacheDetails=response;
	});
	
	
	
	$scope.saveCache=function(){
		var data={};
		data.name=$scope.cacheName;
		data.description=$scope.cacheDescription;
		data.dbname=$scope.cacheDB;
		data.con_id=$("#conList :selected").val();
		$http.post('/api/cache',data).success(function(){
			$window.location.href = '#/cacheList';
		});
	}
});

gatorControllers.controller('cacheEdit',function($scope,$http,$window){
	$http.get("/api/config/connection").success(function (response){
		$scope.conDetails=response;
	});
	
	$http.get("/api/cache").success(function (response){
		$scope.cacheDetails=response;
	});
	
	$("#cacheList").change(function(){
		
		$http.get('/api/cache/'+$("#cacheList :selected").val()).success(function(data){
			$scope.id=data.id;
			$scope.cacheName=data.name;
			$scope.cacheDescription =data.description;
			$scope.cacheDB =data.dbname;
			$("#conList").val(data.con_id);
			
		});
	});
	
	
	$scope.editCache=function(){
		var data={};
		data.id=$scope.id;
		data.name=$scope.cacheName;
		data.description=$scope.cacheDescription;
		data.dbname=$scope.cacheDB;
		data.con_id=$("#conList :selected").val();
		$http.put('/api/cache',data).success(function(){
			$window.location.href = '#/cacheList';
		});
	}
});

gatorControllers.controller('cacheDetail',function($scope,$routeParams,$http){
	 $scope.gridOptions = {  };
	 
	 $scope.msg = {};
	 
	 
	 $scope.addData=function(){
		var data={};
		data.key=$scope.ceKey;
		data.value=$scope.ceValue;
		
		$http.post('/api/cache/'+$routeParams.cacheId+'/value/',data).success(function(){
			$("#addNew").modal('hide');
			$scope.ceKey='';
			$scope.ceValue='';
			location.reload();
		});
	
	 };
	 $scope.gridOptions.onRegisterApi = function(gridApi){
	         
	          $scope.gridApi = gridApi;
	          gridApi.edit.on.afterCellEdit($scope,function(rowEntity, colDef, newValue, oldValue){
	         /*   $scope.msg.lastCellEdited = 'edited row id:' + rowEntity.id + ' Column:' + colDef.name + ' newValue:' + newValue + ' oldValue:' + oldValue ;
	            $scope.$apply();*/
	        	  console.log( 'edited row id:' +  JSON.stringify(rowEntity) + ' Column:' + colDef.name + ' newValue:' + newValue + ' oldValue:' + oldValue);
	        	  var cData = {};
	        	  cData.key=rowEntity.key;
	        	  cData.value=rowEntity.value;
	        	  cData.group=rowEntity.group;
	        	  $http.put('/api/cache/'+$routeParams.cacheId+'/value/'+rowEntity.key,cData).success(function(d){
	        		alert('Value updated'); 
	        	  });
	        	  
	          });
	        };
		console.log($routeParams.cacheId);
		 $scope.deleteRow = function(row) {
			 $http.delete('/api/cache/'+$routeParams.cacheId+'/value/'+row.entity.key).success(function(){
				 var index = $scope.gridOptions.data.indexOf(row.entity);
				 $scope.gridOptions.data.splice(index, 1); 
			 });
		 };
		$http.get('/api/cache/'+$routeParams.cacheId+"/value").success(function(data){
			console.log(JSON.stringify(data));
			$scope.cacheData=data;
			
			 $scope.gridOptions.columnDefs = [
			                                  { name: 'key', enableCellEdit: false, width: '30%' },
			                                  { name: 'value', enableCellEdit: true, width: '50%' },
			                                  {
			                                	    name: 'Delete',
			                                	    cellTemplate: '<button class="btn-xs btn-danger" ng-click="grid.appScope.deleteRow(row)">Delete</button>',
			                                	    width: '20%'
			                                	  }
			                                  ];
			 $scope.gridOptions.data = data;
		});	
		
});