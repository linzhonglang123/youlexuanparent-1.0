//controller层
app.controller("brandController",function ($scope,$controller,brandService) {


    /*前端angularjs继承：
    * 1.$controller（'继承的js',{被继承js的域:继承js的域}）
    *{$scope:$scope}意思是共享baseController的域
    * */
    $controller('baseController',{$scope:$scope});

    //查询所有数据
    brandService.findAll().success(function (data) {
        $scope.list=data;
    });

    //搜索+分页
    $scope.searchEntity={};//初始化搜索对象
    $scope.search=function(page,rows) {
        brandService.search(page,rows,$scope.searchEntity).success(
            function (response) {
                $scope.list = response.rows;
                $scope.paginationConf.totalItems = response.total;//更新总记录数
            });
    };


    //删除
    $scope.deleteBrand=function(){
        brandService.deleteBrand($scope.selectIds).success(function (data) {
            if (data.success) {
                $scope.reloadList();
            }else {
                alert(data.messge)
            }
        });
    };

    //修改
    $scope.selectOne=function(id){
        brandService.selectOne(id).success(function (date) {
            $scope.entity=date;
        });
    };

    //保存
    $scope.saveBrand=function(){
        brandService.saveBrand($scope.entity.id,$scope.entity).success(function (data) {
            if(data.success){
                $scope.reloadList();
            }else {
                alert(data.messge);
            }
        });
    };
    //分页
    $scope.findPage=function(page,rows){
        brandService.findPage(page,rows).success(
            function(response){
                $scope.list=response.rows;
                $scope.paginationConf.totalItems=response.total;//更新总记录数
            }
        );
    }

});