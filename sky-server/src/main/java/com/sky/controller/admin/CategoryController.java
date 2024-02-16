package com.sky.controller.admin;

import com.sky.dto.CategoryDTO;
import com.sky.dto.CategoryPageQueryDTO;
import com.sky.entity.Category;
import com.sky.result.PageResult;
import com.sky.result.Result;
import com.sky.service.CategoryService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@Api(tags = "分类相关接口")
@RestController("adminCategoryController")
@RequestMapping("/admin/category")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    /**
     * 分类分页查询
     * @param categoryPageQueryDTO
     * @return
     */
    @GetMapping("/page")
    @ApiOperation("分类分页查询")
    public Result<PageResult> pageQuery(CategoryPageQueryDTO categoryPageQueryDTO){
        PageResult pageResult = categoryService.pageQuery(categoryPageQueryDTO);
        return Result.success(pageResult);
    }

    /**
     * 修改分类
     * @param categoryDTO
     * @return
     */
    @PutMapping
    @ApiOperation("修改分类")
    public Result update(@RequestBody CategoryDTO categoryDTO){
        categoryService.update(categoryDTO);
        return Result.success();
    }

    /**
     * 启用禁用分类
     * @param status
     * @param id
     * @return
     */
    @PostMapping("/status/{status}")
    @ApiOperation("启用禁用分类")
    public Result startOrStop(@PathVariable Integer status, Long id){
        categoryService.startOrStop(status,id);
        return Result.success();
    }

    /**
     * 新建分类
     * @param categoryDTO
     * @return
     */
    @PostMapping
    @ApiOperation("新建分类")
    public Result insert(@RequestBody CategoryDTO categoryDTO){
        categoryService.insert(categoryDTO);
        return Result.success();
    }

    /**
     * 删除分类
     * @return
     */
    @DeleteMapping
    @ApiOperation("删除分类")
    public Result delete(Long id){
        categoryService.delete(id);
        return Result.success();
    }

    /**
     * 根据类型查询
     * @param type
     * @return
     */
    @GetMapping("/list")
    @ApiOperation("根据类型查询")
    public Result<List<Category>> List(Integer type){
        List<Category> list = categoryService.list(type);
        return Result.success(list);
    }
}
