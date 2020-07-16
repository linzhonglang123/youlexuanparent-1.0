package com.offcn.sellergoods.service;

import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.pojo.TbBrand;

import java.util.List;
import java.util.Map;

public interface BrandService {
    /**
     * 查询所有品牌数据
     * @return
     */
    public List<TbBrand> findAll();

    /**
     * 分页
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult findPage(int pageNum,int pageSize);

    /**
     * 添加
     * @param brand
     * @return
     */
    public boolean addBrand(TbBrand brand);

    /**
     * 根据id查询数据
     * @param id
     * @return
     */
    public TbBrand selectOne(Long id);

    /**
     * 修改
     * @param tbBrand
     * @return
     */
    public boolean update(TbBrand tbBrand);

    /**
     * 根据id删除
     * @param id
     * @return
     */
    public void deleteBrandById(Long[] id);

    /**
     * 模糊搜索 + 分页
     * @param brand
     * @param pageNum
     * @param pageSize
     * @return
     */
    public PageResult searchBrand(TbBrand brand,Integer pageNum,Integer pageSize);

    /**
     * 品牌下拉框数据
     */
    List<Map> selectOptionList();
}

