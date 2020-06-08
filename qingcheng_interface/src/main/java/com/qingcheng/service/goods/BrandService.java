package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

public interface BrandService {

    List<Brand> findAll();

    PageResult<Brand> findPage(Integer page, Integer size);

    List<Brand> searchMap(Map<String,Object> searchMap);

    PageResult<Brand> findPage(Integer page, Integer size, Map<String,Object> searchMap);
}
