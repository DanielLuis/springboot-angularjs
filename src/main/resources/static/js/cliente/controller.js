 
angular.module('myApp.controllers',['myApp.modals','ngAnimate','angularModalService'])

.controller('ClienteListController', ['$scope','$location', 'ClienteService','ModalService', function($scope,$location, ClienteService,ModalService) {
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
	 
	
	 $scope.success = function () {
	        var message = '<strong>Well done!</strong> You successfully read this important alert message.';
	        Flash.create('success', message);
	    };
	    $scope.info = function () {
	        var message = '<strong>Heads up!</strong> This alert needs your attention, but it\'s not super important.';
	        Flash.create('info', message);
	    };
	    $scope.warning = function () {
	        var message = '<strong>Warning!</strong> Better check yourself, you\'re not looking too good.';
	        Flash.create('warning', message);
	    };
	    $scope.danger = function () {
	        var message = '<strong>Oh snap!</strong> Change a few things up and try submitting again.';
	        Flash.create('danger', message);
	    };
	    $scope.myCallback = function(flash) {
	        console.log('Received flash: ' + JSON.stringify(flash));
	    };
	
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