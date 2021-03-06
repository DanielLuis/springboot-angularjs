'use strict';
 
angular.module('myApp.services',['chieffancypants.loadingBar','ngFlash'])
.config(function(cfpLoadingBarProvider) {
    cfpLoadingBarProvider.includeSpinner = false;
})
.factory('ClienteService', ['$http', '$q','cfpLoadingBar','Flash', function($http, $q,cfpLoadingBar,Flash){
 
    var REST_CLIENTE_SERVICE_URI = 'clientes/';
 
    var factory = {
        fetchClientes: fetchClientes,
        createCliente: createCliente,
        deleteCliente:deleteCliente
    };
 
    return factory;
 
    function fetchClientes(id) {

        if (id == undefined){
        	id = "";
        }

    	var deferred = $q.defer();
        
        
        
        cfpLoadingBar.start();
        
        $http.get(REST_CLIENTE_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Cliente');
                deferred.reject(errResponse);
            }
        );
        
        cfpLoadingBar.complete();
        
        return deferred.promise;
    }
 
    function createCliente(cliente) {
        var deferred = $q.defer();
        
        cfpLoadingBar.start();
        
        $http.post(REST_CLIENTE_SERVICE_URI+"add", cliente)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
            	var message = '<strong>Oh snap!</strong> Change a few things up and try submitting again.';
    	        Flash.create('danger', errResponse.data.mensagem);

//                console.error('Error while creating Cliente');
                deferred.reject(errResponse);
            }
        );
        
        cfpLoadingBar.complete();
        
        return deferred.promise;
    }
 
 
    function deleteCliente(id) {
        var deferred = $q.defer();
        
        cfpLoadingBar.start();
        
        $http.delete(REST_CLIENTE_SERVICE_URI+"delete/"+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Cliente');
                deferred.reject(errResponse);
            }
        );
        
        cfpLoadingBar.complete();
        return deferred.promise;
    };
 
}]);