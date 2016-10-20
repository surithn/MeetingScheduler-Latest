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

}).controller('MeetingCreateController',function($scope,$state,$stateParams,Meeting){

    $scope.meeting=new Meeting();
    $scope.employees = Meeting.getEmployees(function(){});
    $scope.rooms =Meeting.getRooms(function(){});
       $scope.addMeeting=function(){
    	$scope.meeting.attendants = $scope.attendants;
    	$scope.meeting.mRoom = $scope.rom;
    	$scope.meeting.$save(function(){
            $state.go('meetings');
        });
    }

}).controller('MeetingEditController',function($scope,$state,$stateParams,Meeting,popupService){
	var urlBase="";
    $scope.updateMeeting=function(meeting){
    	meeting.$update(function(){
    		popupService.showPopup('Meeting Details Updated!');
    		$state.go('meetings');
        });
    };

    $scope.loadMeeting=function(){
        $scope.meeting=Meeting.get({mId:$stateParams.mId});
        $scope.employees = $scope.meeting.attendants;
        $scope.rooms = Meeting.getRooms(function(){});
    };

    $scope.loadMeeting();
});
