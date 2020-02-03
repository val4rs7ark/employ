//config : 모듈 로드 에서 수행 해야 할 작업 을 등록 하기 위해 이 방법을 사용합니다. 
angularApp.config(['$httpProvider', function($httpProvider) {
	$httpProvider.interceptors.push(function ($q) {
		let csrfHeader = $('meta[name="_csrf_header"]').attr('content');
		let csrfToken = $('meta[name="_csrf"]').attr('content');
		return {
			'request' : function(config) { // 요청할때마다 인증토큰을 헤더에 포함한다. 
				config.headers[csrfHeader] = csrfToken;
				cache: true
				return config || $q.when(config); 
				}
		}
	});
}
]);

angularApp.config(function($routeProvider) {
    $routeProvider
    .when("/**?:param", {
        controller : "angularCtrl"
    });
});    

angularApp.run(function($rootScope){
	 $rootScope.$on('$routeChangeStart', function(e, curr, prev){
	   $rootScope.IsLoading = true;
	 });
	 $rootScope.$on('$routeChangeSuccess', function(e, curr, prev){
	   $rootScope.IsLoading = false;
	 });
});
