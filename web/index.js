var myapp=angular.module('myapp',[]);

myapp.controller('mycontroller',['$scope','$http',function ($scope,$http)
{
    $http({
        method: 'GET',
        url: 'api/getUsers'
    }).then(function successCallback(response) {
        console.log(response.data)
        $scope.da=response.data;
        console.log($scope.da);
    }, function errorCallback(response) {
        $scope.error=response;
    });



}]);

  