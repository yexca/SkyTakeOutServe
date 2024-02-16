package com.sky.mapper;

import com.sky.entity.Setmeal;
import com.sky.vo.DishItemVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    @Select("select count(id) from setmeal where category_id = #{id}")
    Integer countByCategoryId(Long id);

    List<Long> getSetmealIdsByDishIds(List<Long> ids);

    List<Setmeal> list(Setmeal setmeal);

    @Select("select sd.name, sd.copies, d.image, d.description" +
            "from setmeal_dish sd left join dish d on sd.dish_id = d.id " +
            "where sd.setmeal_id = #{setmealId}")
    List<DishItemVO> getDishItemById(Long id);
}
