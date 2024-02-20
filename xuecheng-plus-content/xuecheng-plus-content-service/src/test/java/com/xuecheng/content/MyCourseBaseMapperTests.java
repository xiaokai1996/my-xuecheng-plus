package com.xuecheng.content;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xuecheng.base.model.PageParams;
import com.xuecheng.base.model.PageResult;
import com.xuecheng.content.mapper.CourseBaseMapper;
import com.xuecheng.content.model.dto.QueryCourseParamsDto;
import com.xuecheng.content.model.po.CourseBase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MyCourseBaseMapperTests {

    @Autowired
    private CourseBaseMapper courseBaseMapper;

    @Test
    public void testQueryById() {
        CourseBase courseBase = courseBaseMapper.selectById(18L);
        Assertions.assertNotNull(courseBase);
        System.out.println(courseBase);
    }

    @Test
    public void testConditionalQuery() {
        // 1. 生成查询对象
        PageParams pageParams = new PageParams(1L, 10L);
        QueryCourseParamsDto queryParams = new QueryCourseParamsDto();
        queryParams.setCourseName("java");

        // 2. 创造查询条件
        LambdaQueryWrapper<CourseBase> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(!queryParams.getCourseName().isEmpty(), CourseBase::getName, queryParams.getCourseName());

        // 3. 创建分页参数对象
        Page<CourseBase> page = new Page<>(pageParams.getPageNo(), pageParams.getPageSize());
        Page<CourseBase> courseBasePage = courseBaseMapper.selectPage(page, queryWrapper);

        // 4. 创建标准返回
        PageResult pageResult = new PageResult(
                courseBasePage.getRecords(),
                courseBasePage.getTotal(),
                pageParams.getPageNo(),
                pageParams.getPageSize()
        );

        System.out.println(pageResult);

    }

}