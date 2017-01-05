 
angular.module('myApp.controllers',['ngAnimate','myApp.modals','angularModalService'])

.controller('ClienteListController', ['$scope','$location', 'ClienteService','ModalService', function($scope,$location, ClienteService,ModalService,cfpLoadingBar) {
    $scope.clientes=[];
    
    $scope.searchName="";
    
    function deleteCliente(codigo){
        ClienteService.deleteCliente(codigo)
            .then(
            $scope.fetchAllClientes,
            function(errResponse){
                console.error('Error while deleting Cliente');
            }
        );
    }

    $scope.confirmDelete = function(id) {
      ModalService.showModal({
        templateUrl: "js/components/modal/simpleModal.html",
        controller:"SimpleController"
      }).then(function(modal) {
        modal.element.modal();
        modal.close.then(function(result) {
        	if (result){
        		deleteCliente(id);
        	}
        });
      });

    };

    
    $scope.fetchAllClientes = function(){
    	ClienteService.fetchClientes("")
            .then(
            function(clientes) {
                $scope.clientes = clientes;
            },
            function(errResponse){
                console.error('Error while fetching Clientes');
            }
        );
    };
 
    $scope.fetchAllClientes();
 
}]).controller('ClienteCreateController', ['$scope','$location', 'ClienteService', function($scope,$location, ClienteService) { 
	$scope.cliente={};
	   
	$scope.createCliente = function (form){
		$scope.submitted = true;
		if(form.$valid) {
	        ClienteService.createCliente($scope.cliente)
            .then(
    		function(cliente) {
    			$location.path('/clientes');
            },
            function(errResponse){
                console.error('Error while creating Cliente');
            });
		}
    };
	
	$scope.hasErrorForm = function (form){
		return form.$submitted &&  form.name.$invalid;
	};
	
    
}]).controller('ClienteUpdateController', ['$scope','$location','$routeParams', 'ClienteService', function($scope,$location,$routeParams, ClienteService) { 

	
    $scope.fetchCliente = function(codigo){
    	ClienteService.fetchClientes(codigo)
            .then(
            function(cliente) {
            	$scope.cliente=  cliente;
            },
            function(errResponse){
                console.error('Error while fetching Clientes');
            }
        );
    };

	   
	$scope.editCliente = function (form){
		$scope.submitted = true;
		if(form.$valid) {
	        ClienteService.createCliente($scope.cliente)
            .then(
    		function(cliente) {
    			$location.path('/clientes');
            },
            function(errResponse){
                console.error('Error while creating Cliente');
            });
		}
    };
	
	$scope.hasErrorForm = function (form){
		return form.$submitted &&  form.name.$invalid;
	};

	$scope.fetchCliente($routeParams.id);

	
	
}]);