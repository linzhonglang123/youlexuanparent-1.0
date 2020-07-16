//定义service层
app.service('brandService',function ($http) {

    //查询所有数据
    this.findAll=function () {
        return $http.post('../brand/findAll.do');
    };

    //分页
    this.findPage=function (page,rows) {

        return $http.get('../brand/findPage.do?page='+page+'&rows='+rows);
    };

    //保存
    this.saveBrand=function (id,entity) {
        var methodName ="add";
        if(id != null)
        //如果id不为空，执行修改方法
            methodName ="update";{
        }
        return $http.post('../brand/'+methodName+'.do',entity);
    };

    //获取指定id品牌信息
    this.selectOne=function (id) {
        return $http.get("../brand/selectOne.do?id="+id);
    };

    //删除
    this.deleteBrand=function (selectIds) {
        return $http.get('../brand/delete.do?ids='+selectIds)
    };

    //模糊搜索+ 分页
    this.search=function (page,rows,searchEntity) {
        return $http.post('../brand/search.do?page=' + page + '&rows=' + rows,searchEntity)
    };

    //下拉数据列表
    this.selectOptionList=function(){
        return $http.get('../brand/selectOptionList.do');
    };

});