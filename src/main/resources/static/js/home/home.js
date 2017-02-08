(function () {

'use strict';
    var homeModule = angular.module('home', ['home.services']);

    homeModule.controller('homeController',['$http','homeService',
    function($http, homeService) {
        var self = this;

        self.homeService = homeService;

        $http.get('/user/').then(function(response) {
            self.user = response.data.name;
        });

          self.homeService.getUsers().then(function (response) {
            self.userList = response.data;
          });

    }]);

})();