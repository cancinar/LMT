var app = angular.module("app", ['ngRoute']);
app.config(function($routeProvider) {
    $routeProvider
        .when("/", {
            templateUrl : "resources/views/home.htm",
            controller : "getLabsController"
        })
        . when('/labServers/:labId?', {
            templateUrl: 'resources/views/labDetails.htm',
            controller: 'getServerController'
        });
});

app.config( [
    '$compileProvider',
    function( $compileProvider )
    {
        $compileProvider.aHrefSanitizationWhitelist(/^\s*(https?|ftp|mailto|chrome-extension|url|http):/);
        // Angular before v1.2 uses $compileProvider.urlSanitizationWhitelist(...)
    }
]);

app.controller("getLabsController", function ($http, $scope) {


    $scope.getLabs = function () {
        $http.get('services/labs' ).then(function (response) {
            $scope.labs = response.data;
        });
    };

    $scope.getServers = function (id) {
        $http.get('services/servers' + $scope.servers[id].id).then(function (response) {
            $scope.servers = response.data;
        });
    };

    $scope.selectDomain = function (idx) {
        $scope.selectedLab = $scope.labs[idx];
            $scope.getAllServersForLab(idx);
        $scope.selected = true;
    };

    $scope.getAllServersForLab = function (idx) {
        $http.get('services/servers' , $scope.labs[idx].id).then(function (response) {
            $scope.labs.servers = response.data;

        });
    };

    $scope.getLabRelease = function () {
        $http.get('services/labRelease').then(function (labReleases) {
            $scope.labReleases = labReleases.data;
        });
    };


    $scope.getLabOwner = function () {
        $http.get('services/labOwner').then(function (labOwners) {
            $scope.labOwners = labOwners.data;
        });
    };

    $scope.addLab = function () {
        $http.post('services/createLab', $scope.lab)
            .then(function (response) {
                $scope.lab = {};
                $scope.getLabs();
                $scope.addLabForm.$setPristine();
                $('#addLabModal').modal('hide');
            })
            .catch(function (data){;
                $scope.lab = {};
                $scope.getLabs();
                $scope.addLabForm.$setPristine();
                $('#addLabModal').modal('hide');
            });
    };

    $scope.addServer = function () {
        $http.post('services/addServer', $scope.server)
            .then(function (response) {
                $scope.server = {};
                $scope.getLabs();
                $scope.addServerForm.$setPristine();
                $('#addServerModal').modal('hide');
            })
            .catch(function (data){;
                $scope.server = {};
                $scope.getLabs();
                $scope.addServerForm.$setPristine();
                $('#addServerModal').modal('hide');
            });
    };


    $scope.removeLab = function (idx) {
        $http.delete('services/lab/' + $scope.labs[idx].id)
            .then(function (response) {
                $scope.labs.splice(idx, 1);
            });
    };

    $scope.getLink = function(id){
        $scope.url = 'http://' +id + ':12120';
    };

    $scope.getProvLink = function(id){
        $scope.url = 'http://' +id + ':8443/prov';
    };

    $scope.removeLab = function (idx) {
        $http.delete('services/lab/' + $scope.labs[idx].id)
            .then(function (response) {
                $scope.labs.splice(idx, 1);
            });
    };


    $scope.getLabOwner();
    $scope.getLabRelease();
    $scope.getLabs();


});


app.directive('addLabModal', function () {
    return {
        restrict: 'E',
        templateUrl: 'resources/views/addLabModal.html',
    }
});

app.directive('addServerModal', function () {
    return {
        restrict: 'E',
        templateUrl: 'resources/views/addServerModal.html',
    }
});

app.controller("getServerController", function ($http, $scope,$routeParams) {

    $scope.getServers = function () {

        $http.get('services/servers/' +  $routeParams.labId).then(function (response) {
            $scope.servers = response.data;
        });
    };

    $scope.removeServer = function (idx) {
        $http.delete('services/servers/' + $scope.servers[idx].id)
            .then(function (response) {
                $scope.servers.splice(idx, 1);
            });
    };

    $scope.getServers();
});
