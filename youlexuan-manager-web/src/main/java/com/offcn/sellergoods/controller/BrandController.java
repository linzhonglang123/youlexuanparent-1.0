package com.offcn.sellergoods.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.offcn.entity.PageResult;
import com.offcn.entity.Result;
import com.offcn.pojo.TbBrand;
import com.offcn.sellergoods.service.BrandService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/brand")
public class BrandController {

    @Reference(timeout = 200000)
    BrandService brandService;


    /**
     * 查询所有
     * @return
     */
    @RequestMapping("findAll")
    @ResponseBody
    public List<TbBrand> findAll(){


        List<TbBrand> all = brandService.findAll();
        return all;

    }

    /**
     * 分页
     * @param page
     * @param rows
     * @return
     */
    @RequestMapping("findPage")
    @ResponseBody
    public PageResult findPage(int page,int rows){

        PageResult page1 = brandService.findPage(page, rows);

        return page1;

    }

    /**
     * 添加
     * @param brand
     * @return
     */
    @RequestMapping("add")
    @ResponseBody
    public Result addBrand(@RequestBody TbBrand brand){


        boolean flag = brandService.addBrand(brand);
        if (flag){

            return new Result(true,"新增成功！");
        }else {
            return new Result(false,"新增失败！");
        }
    }

    /**
     * 根据id查询TbBrand
     * @param id
     * @return
     */
    @RequestMapping("selectOne")
    @ResponseBody
    public TbBrand selectOne(Long id){

        TbBrand tbBrand = brandService.selectOne(id);

        return tbBrand;
    }

    @RequestMapping("update")
    @ResponseBody
    public Result update(@RequestBody TbBrand tbBrand){

        boolean flag = brandService.update(tbBrand);

        if (flag){
            return new Result(true,"修改成功！");
        }else{
            return new Result(false,"修改失败！");
        }
    }

    /**
     * 删除
     * @param ids
     * @return
     */
    @RequestMapping("delete")
    @ResponseBody
    public Result delete(Long[] ids){

        try {
            brandService.deleteBrandById(ids);
            return new Result(true,"删除成功！");
        } catch (Exception e) {
            e.printStackTrace();
            return new Result(false,"删除失败！");
        }
    }

    @RequestMapping("search")
    @ResponseBody
    public PageResult search(@RequestBody TbBrand brand,Integer page,Integer rows){

        PageResult pageResult = brandService.searchBrand(brand, page, rows);

        return  pageResult;
    }

    @RequestMapping("/selectOptionList")
    @ResponseBody
    public List<Map> selectOptionList(){

        return brandService.selectOptionList();
    }
}
