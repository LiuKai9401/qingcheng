package com.qingcheng.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.omg.PortableInterceptor.INACTIVE;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 查询所有商品列表
     * @return
     */
    @RequestMapping("/findAll")
    public List<Brand> findAll(){
        return brandService.findAll();
    }

    /**
     * 分页查询商品列表
     * @param page
     * @param size
     * @return
     */
    @GetMapping("/findPage")
    public PageResult<Brand> findPage(Integer page,Integer size){
        return brandService.findPage(page,size);
    }

    /**
     * 条件查询
     * @param searchMap
     * @return
     */
    @PostMapping("findList")
    public List<Brand> searchMap(@RequestBody Map<String,Object> searchMap){
        return brandService.searchMap(searchMap);
    }

    /**
     * 条件查询+分页查询
     * @param page
     * @param size
     * @param searchMap
     * @return
     */
    @PostMapping("/findPage")
    public PageResult<Brand> findPage(Integer page,Integer size,@RequestBody Map<String,Object> searchMap){
        return brandService.findPage(page,size,searchMap);
    }
}
