package com.qingcheng.service.goods.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    /**
     * 查询所有的商品信息
     * @return
     */
    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    /**
     * 分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<Brand> findPage(Integer page, Integer size) {
        PageHelper.startPage(page,size);
        List<Brand> list = brandMapper.selectAll();
        PageInfo<Brand> pageInfo = new PageInfo<Brand>(list);
        return new PageResult<Brand>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 添加查询
     * @param searchMap
     * @return
     */
    @Override
    public List<Brand> searchMap(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return brandMapper.selectByExample(example);
    }

    /**
     * 分页查询+条件查询
     * @param page
     * @param size
     * @param searchMap
     * @return
     */
    @Override
    public PageResult<Brand> findPage(Integer page, Integer size, Map<String, Object> searchMap) {
        PageHelper.startPage(page,size);
        Example example = createExample(searchMap);
        List<Brand> brandList = brandMapper.selectByExample(example);
        PageInfo<Brand> pageInfo = new PageInfo<>(brandList);
        return new PageResult<Brand>(pageInfo.getTotal(),pageInfo.getList());
    }

    /**
     * 根据id查询商品
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 保存商品
     * @param brand
     */
    @Override
    public void addBrand(Brand brand) {
        brandMapper.insertSelective(brand);
    }

    /**
     * 更新商品
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 删除商品
     * @param id
     */
    @Override
    public void deleteById(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 抽取构造条件
     * @param searchMap
     * @return
     */
    private Example createExample(Map<String, Object> searchMap) {
        //1.创建Example查询模板
        Example example = new  Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        //2.判断条件是否存在
        if (searchMap.get("id")!=null && !"".equals(searchMap.get("id"))){
            Integer id = (Integer) searchMap.get("id");
            criteria.andEqualTo("id",id);
        }
        if(searchMap.get("name")!=null && !"".equals(searchMap.get("name")))
        {
            String name = (String) searchMap.get("name");
            criteria.andEqualTo("name",name);
        }
        if (searchMap.get("letter")!=null && !"".equals(searchMap.get("letter"))){
            String letter = (String) searchMap.get("letter");
            criteria.andLike("letter",letter);
        }
        return example;
    }


}
