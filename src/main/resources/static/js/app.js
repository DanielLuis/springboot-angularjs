var app = angular.module('myApp', ['myApp.controllers','myApp.services','ngRoute','ngMessages']);
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

