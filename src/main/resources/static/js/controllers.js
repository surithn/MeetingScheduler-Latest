/**
 * Created by Surith.
 */
angular.module('meetingApp.controllers',[]).controller('MeetingsListController',function($scope,$state,popupService,$window,Meeting){

    $scope.meetings=Meeting.query();

    $scope.deleteMeeting=function(meeting){
        if(popupService.showPopup('Really delete this?')){
        	meeting.$delete(function(){
        		popupService.showPopup('Meeting Deleted');
            });
        }
    }

}).controller('MeetingViewController',function($scope,$stateParams,Meeting){

    $scope.meeting=Meeting.get({mId:$stateParams.mId});

}).controller('MeetingCreateController',function($scope,$state,$stateParams,Meeting){

    $scope.meeting=new Meeting();

    $scope.addMeeting=function(){
        $scope.meeting.$save(function(){
            $state.go('meetings');
        });
    }

}).controller('MeetingEditController',function($scope,$state,$stateParams,Meeting,$http,popupService){
	var urlBase="";
    $scope.updateMeeting=function(){
    	 $http.put(urlBase + '/MeetingSchduler/meeting', {
			 startTime: $scope.meeting.startTime,
			 endTime: $scope.meeting.endTime,
			 mName: $scope.meeting.mName,
			 mId: $scope.meeting.mId
         }).
		  success(function(data, status, headers) {
			  popupService.showPopup('Meeting updated successfully!');
			  $state.go('meetings');
		    });
    };

    $scope.loadMeeting=function(){
        $scope.meeting=Meeting.get({mId:$stateParams.mId});
    };

    $scope.loadMeeting();
});