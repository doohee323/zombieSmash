'use strict';

angular.module('fBFriends').controller('MainCtrl', function($scope, ngDialog) {

	var MaxCnt = 6;
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

	$scope.openTemplate = function() {
		$scope.value = true;
		var queryFirst = document.getElementById('queryFirst').value;
		var queryLast = document.getElementById('queryLast').value;
		if(!queryFirst) {
			return;
		}

		$scope.queryFirst = queryFirst;
		$scope.lastName = queryLast;
		$scope.queryImg = document.getElementById('queryImg').src;
		$scope.answerName = '';
		$scope.answerResult = '';

		ngDialog.open({
			template : 'views/externalTemplate.html',
			className : 'ngdialog-theme-plain',
			scope : $scope
		});
	}

	$scope.guessName = function() {
		var eachResult = {};
		if(	MaxCnt == turnCnt) {
			alert('All chances finished!');
			return;
		};
		turnCnt++;
		eachResult.sn = turnCnt;
		if($scope.lastName == $scope.answerName) {
			$scope.answerResult = '100%';
			eachResult.perc = $scope.answerResult;
			rightCnt++;
			document.getElementById('answerResult').style.color = 'green';
		} else {
			var answerName = ($scope.answerName + '').toUpperCase();
			var lastName = ($scope.lastName + '').toUpperCase();
			var cntChar = 0;
			for(var i=0;i<answerName.length;i++) {
				if(lastName.indexOf(answerName.charAt(i)) > -1) {
					cntChar++;
				}
			}
			var answerResult = Math.round(cntChar/lastName.length * 100);
			$scope.answerResult = answerResult + '%';
			eachResult.perc = $scope.answerResult;
			document.getElementById('answerResult').style.color = 'red';
		}
		eachResult.rightCnt = rightCnt;
		eachResult.winning = rightCnt  + '/' + turnCnt;
		result.push(eachResult);
	}

	$scope.showResult = function() {
		$scope.resultView = result;
	}

});
