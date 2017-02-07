kpnCmsApp.controller('documentationController', function($http) {
	var self = this;

	self.pageHeader = "Documentation";

	$http.get('/resource/').then(function(response) {
		self.greeting = response.data;
	});
});
