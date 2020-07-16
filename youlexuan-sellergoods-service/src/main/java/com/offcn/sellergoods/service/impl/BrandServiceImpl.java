package com.offcn.sellergoods.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import com.offcn.mapper.TbBrandMapper;
import com.offcn.entity.PageResult;
import com.offcn.pojo.TbBrand;
import com.offcn.pojo.TbBrandExample;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    TbBrandMapper tbBrandMapper;

    @Override
    public List<TbBrand> findAll() {

        System.out.println(2222);
        return tbBrandMapper.selectByExample(null);
    }

    @Override
    public PageResult findPage(int pageNum, int pageSize) {

        PageHelper.startPage(pageNum, pageSize);

        Page<TbBrand> pages = (Page<TbBrand>) tbBrandMapper.selectByExample(null);

        List<TbBrand> result = pages.getResult();

        long total = pages.getTotal();

        PageResult pageResult = new PageResult(total,result);

        return pageResult;
    }

    @Override
    public boolean addBrand(TbBrand brand) {

        int insert = tbBrandMapper.insert(brand);

        return insert>0?true:false;
    }

    @Override
    public TbBrand selectOne(Long id) {

        TbBrand tbBrand = tbBrandMapper.selectByPrimaryKey(id);

        return tbBrand;
    }

    @Override
    public boolean update(TbBrand tbBrand) {

        int i = tbBrandMapper.updateByPrimaryKey(tbBrand);

        return i>0?true:false;
    }

    @Override
    public void deleteBrandById(Long[] ids) {

        for (Long id : ids) {
            tbBrandMapper.deleteByPrimaryKey(id);
        }
    }

    @Override
    public PageResult searchBrand(TbBrand brand, Integer pageNum, Integer pageSize) {

        PageHelper.startPage(pageNum,pageSize);

        TbBrandExample brandE = null;
        if (brand != null){
            brandE = new TbBrandExample();
            TbBrandExample.Criteria criteria = brandE.createCriteria();
            if (brand.getName()!=null&&brand.getName().length()>0){
                criteria.andNameLike("%"+brand.getName()+"%");
            }
            if (brand.getFirstChar()!=null&&brand.getFirstChar().length()>0){
                criteria.andFirstCharLike("%"+brand.getFirstChar()+"%");
            }
        }
        Page<TbBrand> brandPage = (Page)tbBrandMapper.selectByExample(brandE);

        return new PageResult(brandPage.getTotal(),brandPage.getResult());
    }

    /**
     * 列表数据
     */
    public List<Map> selectOptionList() {
        return tbBrandMapper.selectOptionList();
    }
}
