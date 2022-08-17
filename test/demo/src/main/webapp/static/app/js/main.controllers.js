var demoApp = angular.module('demoApp.controllers', ['ui.bootstrap']);

demoApp.controller('LibraryController', function($scope, $location, $routeParams, $uibModal,
	
	 
	libraryService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.libraryList = $scope.libraryList.slice().reverse();
	}
	
	$scope.maxSize = 5;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditLibraryConfirmationController',
		      size : 'sm',
		      resolve: {
		          library: function () {
		            return $scope.library;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/libraryList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		libraryService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.libraryList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		libraryService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'Library with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting Library with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.library = {};
		if ($routeParams.id) {  // edit stranica
			libraryService.getOne($routeParams.id)
					.success(function(data) {
						$scope.library = data;
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'Library with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditLibraryConfirmationController', function($scope, $uibModalInstance, libraryService, library) {
	
	$scope.library = library;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		libraryService.save($scope.library)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
demoApp.controller('BookController', function($scope, $location, $routeParams, $uibModal,
	
	categoryService,  
	bookService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.bookList = $scope.bookList.slice().reverse();
	}
	
	$scope.maxSize = 5;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		$scope.book.category = JSON.parse($scope.book.category);
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditBookConfirmationController',
		      size : 'sm',
		      resolve: {
		          book: function () {
		            return $scope.book;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/bookList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		bookService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.bookList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		bookService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'Book with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting Book with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.book = {};
			categoryService.getAll()
				.success(function(data) {
						$scope.categoryList = data;
					});
		if ($routeParams.id) {  // edit stranica
			bookService.getOne($routeParams.id)
					.success(function(data) {
						$scope.book = data;
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'Book with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditBookConfirmationController', function($scope, $uibModalInstance, bookService, book) {
	
	$scope.book = book;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		bookService.save($scope.book)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
demoApp.controller('CategoryController', function($scope, $location, $routeParams, $uibModal,
	
	 
	categoryService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.categoryList = $scope.categoryList.slice().reverse();
	}
	
	$scope.maxSize = 5;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditCategoryConfirmationController',
		      size : 'sm',
		      resolve: {
		          category: function () {
		            return $scope.category;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/categoryList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		categoryService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.categoryList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		categoryService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'Category with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting Category with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.category = {};
		if ($routeParams.id) {  // edit stranica
			categoryService.getOne($routeParams.id)
					.success(function(data) {
						$scope.category = data;
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'Category with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditCategoryConfirmationController', function($scope, $uibModalInstance, categoryService, category) {
	
	$scope.category = category;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		categoryService.save($scope.category)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
demoApp.controller('UserController', function($scope, $location, $routeParams, $uibModal,
	
	libraryService,  
	userService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.userList = $scope.userList.slice().reverse();
	}
	
	$scope.maxSize = 5;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		$scope.user.library = JSON.parse($scope.user.library);
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditUserConfirmationController',
		      size : 'sm',
		      resolve: {
		          user: function () {
		            return $scope.user;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/userList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		userService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.userList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		userService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'User with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting User with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.user = {};
			libraryService.getAll()
				.success(function(data) {
						$scope.libraryList = data;
					});
		if ($routeParams.id) {  // edit stranica
			userService.getOne($routeParams.id)
					.success(function(data) {
						$scope.user = data;
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'User with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditUserConfirmationController', function($scope, $uibModalInstance, userService, user) {
	
	$scope.user = user;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		userService.save($scope.user)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
demoApp.controller('ReviewController', function($scope, $location, $routeParams, $uibModal,
	
	 
	reviewService) {
	
	$scope.reverse = true;
	
	$scope.changeReverse = function() {
		$scope.reviewList = $scope.reviewList.slice().reverse();
	}
	
	$scope.maxSize = 5;
	
	$scope.open = function () {
		if(!$routeParams.if) {
		}
		var modalInstance = $uibModal.open({
			  animation: true,
		      templateUrl: 'myModalContent.html',
		      controller: 'addEditReviewConfirmationController',
		      size : 'sm',
		      resolve: {
		          review: function () {
		            return $scope.review;
		          }
		      }
		});	
		
		modalInstance.result.then(function () {
				$location.path('/reviewList');
		    }, function () {
		});
		
	}
	
	$scope.alerts = [];
	
	$scope.closeAlert = function(index) {
		$scope.alerts.splice(index, 1);
	};
	
	$scope.getAll = function() {
		reviewService.getAll($scope.search, $scope.page-1)
				.success(function(data, status, headers) {
					$scope.reviewList = data;
					$scope.hideSpinner = true;
					$scope.totalItems = headers('total-items');
				})
				.error(function() {
					$scope.showError = true;
					$scope.hideSpinner = true;
				});
	};
	
	$scope.remove = function(id) {
		reviewService.remove(id)
				.success(function(data) {
					$scope.getAll();
					$scope.alerts.push({msg: 'Review with ID ' + id + ' successufully deleted', type: 'success'});
				})
				.error(function() {
					$scope.alerts.push({msg: 'Error while deleting Review with ID ' + id + '!', type: 'danger'});
				});
	};
	
	$scope.addEditHeading;
	
	$scope.initAddEditPage = function () {
		if ($routeParams.id) {
			$scope.addEditHeading = 'Edit';
		}
		else {
			$scope.addEditHeading = 'Add';
		}
	}
	
	$scope.getOne = function() {
		$scope.review = {};
		if ($routeParams.id) {  // edit stranica
			reviewService.getOne($routeParams.id)
					.success(function(data) {
						$scope.review = data;
						
						
					})
					.error(function() {
						$scope.alerts.push({msg: 'Review with ID ' + $routeParams.id + ' does not exist!', type: 'danger'});
					});
		}
	};
	
});


demoApp.controller('addEditReviewConfirmationController', function($scope, $uibModalInstance, reviewService, review) {
	
	$scope.review = review;
	
	$scope.confirm = function () {
		$scope.save();
	};

	$scope.revert = function () {
	    $uibModalInstance.dismiss();
	};
	
	$scope.save = function() {
		reviewService.save($scope.review)
				.success(function() {
					$uibModalInstance.close();
				})
				.error(function() {
					$uibModalInstance.dismiss();
				});
	};
	
});
