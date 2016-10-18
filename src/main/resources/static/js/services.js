/**
 * Created by Surith.
 */

angular.module('meetingApp.services',[]).factory('Meeting',function($resource){
    return $resource('http://localhost:8080/MeetingSchduler/meeting/:mId',{mId:'@mId'},{
        update: {
            method: 'PUT'
        }
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});