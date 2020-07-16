package com.offcn.sellergoods.service;
import java.util.List;
import java.util.Map;

import com.offcn.pojo.TbBrand;

import com.offcn.entity.PageResult;
/**
 * 服务层接口
 * @author Administrator
 *
 */
public interface BrandService {


    boolean addBrand(TbBrand brand);

    List<TbBrand> findAll();

    PageResult findPage(int page, int rows);

    TbBrand selectOne(Long id);

    boolean update(TbBrand tbBrand);

    void deleteBrandById(Long[] ids);

    PageResult searchBrand(TbBrand brand, Integer page, Integer rows);

    List<Map> selectOptionList();
}
