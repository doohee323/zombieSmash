'use strict';

angular.module('fBFriends').controller('MainCtrl', function($scope, ngDialog) {

	var turnCnt = 0;
	var rightCnt = 0;
	var winningScore = [];

	var eachPoint;
	var losingScore = [];

	// 1 = 100%, 1
	// 2 = 20%, 1 
	// 3 = 100%, 2
	// 4 = 50%, 2
	// sn, %, rightCnt

	var result = [];
	var eachResult = {};

	$scope.openTemplate = function() {
		$scope.value = true;
		var queryFirst = document.getElementById('queryFirst').value;
		var queryLast = document.getElementById('queryLast').value;
		$scope.queryFirst = queryFirst;
		$scope.lastName = queryLast;
		$scope.queryImg = document.getElementById('queryImg').src;

		ngDialog.open({
			template : 'views/externalTemplate.html',
			className : 'ngdialog-theme-plain',
			scope : $scope
		});
	}

	$scope.guessName = function() {
		debugger;
		turnCnt++;
		result.sn = turnCnt;
		if($scope.lastName == $scope.answerName) {
			$scope.answerResult = '100%';
			result.perc = $scope.answerResult;
			result.rightCnt++;
			document.getElementById('answerResult').style.color = 'green';
		} else {
			var answerName = $scope.answerName;
			var cntChar = 0;
			for(var i=0;answerName.length;i++) {
				if($scope.lastName.indexOf(answerName.getAt(i)) > -1) {
					cntChar++;
				}
			}
			var answerResult = cntChar/turnCnt * 100;
			$scope.answerResult = answerResult;
			result.perc = $scope.answerResult;
			document.getElementById('answerResult').style.color = 'red';
		}
	}

});
