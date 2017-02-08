(function () {

 'use strict';

 var homeModuleServices = angular.module('home.services',[]);

     homeModuleServices.factory('homeService',['$http', function($http){
        return {
                  getUsers: function() {
                          return  $http.get('/customers');
                        }
         }
     }]);
})();