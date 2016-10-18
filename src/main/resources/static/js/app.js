/**
 * Created by Surith.
 */

angular.module('meetingApp',['ui.router','ngResource','meetingApp.controllers','meetingApp.services','angularjs-datetime-picker']);

angular.module('meetingApp').config(function($stateProvider,$httpProvider){
    $stateProvider.state('meetings',{
        url:'/meetings',
        templateUrl:'meetings_html',
        controller:'MeetingsListController'
    }).state('viewMeeting',{
       url:'/meeting/:mId/view',
       templateUrl:'meeting-view_html',
       controller:'MeetingViewController'
    }).state('newMeeting',{
        url:'/meeting/new',
        templateUrl:'meetings-add_html',
        controller:'MeetingCreateController'
    }).state('editMeeting',{
        url:'/meeting/:mId/edit',
        templateUrl:'meetings-edit_html',
        controller:'MeetingEditController'
    });
}).run(function($state){
   $state.go('meetings');
});