var app = angular.module('myApp', ['ngRoute','ngResource','ngMessages','myApp.controllers','myApp.services','angularSpinners']);
app.config(function($routeProvider){
    $routeProvider
    .when('/clientes',{
        templateUrl: 'views/cliente/clientes.html',
        controller: 'ClienteListController'
    	})
    .when('/addCliente',{
        templateUrl: 'views/cliente/cliente-add.html',
        controller: 'ClienteCreateController'
    })
    .when('/editCliente/:id',{
        templateUrl: 'views/cliente/cliente-edit.html',
        controller: 'ClienteUpdateController'
    })
    .otherwise(
        { redirectTo: '/'}
    );
});

