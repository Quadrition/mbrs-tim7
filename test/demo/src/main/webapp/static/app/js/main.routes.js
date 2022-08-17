var demoApp = angular.module('demoApp.routes', ['ngRoute']);

demoApp.config(['$routeProvider', function($routeProvider) {
    $routeProvider
        .when('/', {
            templateUrl : '/static/app/html/partial/home.html'
        })
                .when('/libraryList', {
            templateUrl : '/static/app/html/partial/libraryList.html',
            controller : 'LibraryController'
        })
        .when('/libraryList/add', {
            templateUrl : '/static/app/html/partial/addEditLibrary.html',
            controller : 'LibraryController'
        })
        .when('/libraryList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditLibrary.html',
            controller : 'LibraryController'
        })
        .when('/libraryList/:id', {
            templateUrl : '/static/app/html/partial/viewLibrary.html',
            controller : 'LibraryController'
        })
        .when('/bookList', {
            templateUrl : '/static/app/html/partial/bookList.html',
            controller : 'BookController'
        })
        .when('/bookList/add', {
            templateUrl : '/static/app/html/partial/addEditBook.html',
            controller : 'BookController'
        })
        .when('/bookList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditBook.html',
            controller : 'BookController'
        })
        .when('/bookList/:id', {
            templateUrl : '/static/app/html/partial/viewBook.html',
            controller : 'BookController'
        })
        .when('/categoryList', {
            templateUrl : '/static/app/html/partial/categoryList.html',
            controller : 'CategoryController'
        })
        .when('/categoryList/add', {
            templateUrl : '/static/app/html/partial/addEditCategory.html',
            controller : 'CategoryController'
        })
        .when('/categoryList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditCategory.html',
            controller : 'CategoryController'
        })
        .when('/categoryList/:id', {
            templateUrl : '/static/app/html/partial/viewCategory.html',
            controller : 'CategoryController'
        })
        .when('/userList', {
            templateUrl : '/static/app/html/partial/userList.html',
            controller : 'UserController'
        })
        .when('/userList/add', {
            templateUrl : '/static/app/html/partial/addEditUser.html',
            controller : 'UserController'
        })
        .when('/userList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditUser.html',
            controller : 'UserController'
        })
        .when('/userList/:id', {
            templateUrl : '/static/app/html/partial/viewUser.html',
            controller : 'UserController'
        })
        .when('/reviewList', {
            templateUrl : '/static/app/html/partial/reviewList.html',
            controller : 'ReviewController'
        })
        .when('/reviewList/add', {
            templateUrl : '/static/app/html/partial/addEditReview.html',
            controller : 'ReviewController'
        })
        .when('/reviewList/edit/:id', {
            templateUrl : '/static/app/html/partial/addEditReview.html',
            controller : 'ReviewController'
        })
        .when('/reviewList/:id', {
            templateUrl : '/static/app/html/partial/viewReview.html',
            controller : 'ReviewController'
        })
        .otherwise({
            redirectTo: '/'
        });
}]);
