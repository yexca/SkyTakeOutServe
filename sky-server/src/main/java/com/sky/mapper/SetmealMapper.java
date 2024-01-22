package com.sky.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    @Select("select count(id) from setmeal where category_id = #{id}")
    Integer countByCategoryId(Long id);

    List<Long> getSetmealIdsByDishIds(List<Long> ids);
}
