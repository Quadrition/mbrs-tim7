var demoApp = angular.module('demoApp.services', []);

demoApp.service('libraryService', function($http) {
	
	this.url = 'api/library';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		const promise =  $http.get(this.url, { params: {'name': name}});
		return promise;
	};
	
	
	this.save = function(library) {
		if (library.id) {
			return $http.put(this.url + '/' + library.id, library);
		} else {
			return $http.post(this.url, library);
		}
	};
});
demoApp.service('bookService', function($http) {
	
	this.url = 'api/book';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		const promise =  $http.get(this.url, { params: {'name': name}});
		return promise;
	};
	
	
	this.save = function(book) {
		if (book.id) {
			return $http.put(this.url + '/' + book.id, book);
		} else {
			return $http.post(this.url, book);
		}
	};
});
demoApp.service('categoryService', function($http) {
	
	this.url = 'api/category';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		const promise =  $http.get(this.url, { params: {'name': name}});
		return promise;
	};
	
	
	this.save = function(category) {
		if (category.id) {
			return $http.put(this.url + '/' + category.id, category);
		} else {
			return $http.post(this.url, category);
		}
	};
});
demoApp.service('userService', function($http) {
	
	this.url = 'api/user';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		const promise =  $http.get(this.url, { params: {'name': name}});
		return promise;
	};
	
	
	this.save = function(user) {
		if (user.id) {
			return $http.put(this.url + '/' + user.id, user);
		} else {
			return $http.post(this.url, user);
		}
	};
});
demoApp.service('reviewService', function($http) {
	
	this.url = 'api/review';
	
	this.getOne = function(id) {
		return $http.get(this.url + '/' + id);
	};
	
	this.remove = function(id) {
		return $http.delete(this.url + '/' + id);
	};
	
	this.getAll = function(name, page) {
		const promise =  $http.get(this.url, { params: {'name': name}});
		return promise;
	};
	
	
	this.save = function(review) {
		if (review.id) {
			return $http.put(this.url + '/' + review.id, review);
		} else {
			return $http.post(this.url, review);
		}
	};
});
