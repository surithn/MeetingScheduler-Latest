/**
 * Created by Surith.
 */

angular.module('meetingApp.services',[]).factory('Meeting',function($resource){
    return $resource('/MeetingSchduler/meeting/:mId',{mId:'@mId'},{
        getEmployees: {
        	url: '/MeetingSchduler/others/emp',
            method: 'GET',
            isArray:true
        },
        getRooms: {
        	url: '/MeetingSchduler/others/room',
            method: 'GET',
            isArray:true
        },
        update: {
        	url: '/MeetingSchduler/meeting',
            method: 'PUT'
        }
        
    });
}).service('popupService',function($window){
    this.showPopup=function(message){
        return $window.confirm(message);
    }
});
