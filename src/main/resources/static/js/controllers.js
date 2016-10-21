/**
 * Created by Surith.
 */
angular.module('meetingApp.controllers',[]).controller('MeetingsListController',function($scope,$state,popupService,$window,Meeting){

    $scope.meetings=Meeting.query();

    $scope.deleteMeeting=function(meeting){
        if(popupService.showPopup('Really delete this?')){
        	meeting.$delete(function(){
        		popupService.showPopup('Meeting Deleted');
        		$state.go('meetings');
            });
        }
    }

}).controller('MeetingViewController',function($scope,$stateParams,Meeting){

    $scope.meeting=Meeting.get({mId:$stateParams.mId});

}).controller('MeetingCreateController',function($scope,$state,$stateParams,$http,Meeting){
	$scope.edit = false;
    $scope.meeting=new Meeting();
	   $scope.locations=[];
	   $scope.attendants=[];
    $scope.employees = Meeting.getEmployees(function(){});
    $scope.rooms =Meeting.getRooms(function(){});
       $scope.addMeeting=function(){
    	   
    	   angular.forEach($scope.meeting.attendants, function(value, key){
    		    var value = value;
    	        var parts = {};
    	        parts[key] = value;
    	        $scope.attendants.push(parts);
    	    });
    	   $scope.meeting.locations=[];
    	   $scope.meeting.attendants=[];
    	   //$scope.meeting.attendants = $scope.attendants;
    	   alert(JSON.stringify($scope.meeting));
    	   $scope.meeting.$save(function(){
            $state.go('meetings');
        });
    }

}).controller('MeetingEditController',function($scope,$state,$stateParams,Meeting,popupService){
	$scope.updateMeeting=function(){
 	   $scope.meeting.locations=[];
	   $scope.meeting.attendants=[];
		$scope.meeting.$update(function(){
    		popupService.showPopup('Meeting Details Updated!');
    		$state.go('meetings');
        });
    };

    $scope.loadMeeting=function(){
    	$scope.create = false;
    	$scope.meeting=Meeting.get({mId:$stateParams.mId});
    };
        $scope.loadMeeting();
});
