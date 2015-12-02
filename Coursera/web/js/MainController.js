app.controller('CursosController', ['$scope', 'cursos', function($scope, cursos) {
  cursos.success(function(data) {
      $scope.cursos = data;
  });
}]);

app.controller('HomeController', ['$scope', 'dadoshome', function($scope, dadoshome) {
    dadoshome.success(function(data) {
        $scope.dadoshome = data;
    });
}]);

app.controller('ProgressController', ['$scope', function($scope, ngProgressFactory) {
    $scope.progressbar = ngProgressFactory.createInstance();
    $scope.progressbar.start();
}]);