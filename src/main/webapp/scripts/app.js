'use strict';

var config = {
//	url : 'http://localhost\\:3000',
//	url: 'http://sheeprails.herokuapp.com',
	url : 'http://localhost\\:9000/rest',
	// url : '/pattern/pt42/masterdetail',
	server: 'spring' // spring, rails
};

var app = angular.module('fBFriends',
		[ 'ngCookies',
          'ngResource',
          'ngSanitize',
          'ui.router',
          'ngDialog',
          'ui.bootstrap'])

app.constant('config', config)
	.config(function($stateProvider, $urlRouterProvider, $locationProvider) {
		// default route
		$urlRouterProvider.otherwise("/");
		
		// default route
		$stateProvider.state('default', {
			templateUrl : 'views/layout/default.html',
			controller : 'DefaultCtrl',
			abstract : true
		}).state('default.centers', {
			templateUrl : 'views/main.html',
			controller : 'MainCtrl'
		});

		$locationProvider.html5Mode(true).hashPrefix('!');
});
     