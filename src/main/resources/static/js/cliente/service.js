'use strict';
 
angular.module('myApp.services',[]).factory('ClienteService', ['$http', '$q', function($http, $q){
 
    var REST_SERVICE_URI = 'http://localhost:8080/myApp/clientes/';
 
    var factory = {
        fetchAllClientes: fetchAllClientes,
        fetchCliente: fetchCliente,
        createCliente: createCliente,
        deleteCliente:deleteCliente
    };
 
    return factory;
 
    function fetchAllClientes() {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Clientes');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }

    function fetchCliente(id) {
        var deferred = $q.defer();
        $http.get(REST_SERVICE_URI+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while fetching Cliente');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
    function createCliente(cliente) {
        var deferred = $q.defer();
        $http.post(REST_SERVICE_URI+"add", cliente)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while creating Cliente');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    }
 
 
    function deleteCliente(id) {
        var deferred = $q.defer();
        $http.delete(REST_SERVICE_URI+"delete/"+id)
            .then(
            function (response) {
                deferred.resolve(response.data);
            },
            function(errResponse){
                console.error('Error while deleting Cliente');
                deferred.reject(errResponse);
            }
        );
        return deferred.promise;
    };
 
}]);