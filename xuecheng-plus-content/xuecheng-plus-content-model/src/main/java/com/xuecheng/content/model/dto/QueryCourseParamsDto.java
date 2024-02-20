package com.xuecheng.content.model.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author Mr.M
 * @version 1.0
 * @description 课程查询条件模型类
 * @date 2023/2/11 15:37
 */
//放公用的类
@Data
@ToString
@ApiModel(value = "查询课程参数")
public class QueryCourseParamsDto {

    @ApiModelProperty(value = "审核状态")
    //审核状态
    private String auditStatus;
    //课程名称
    private String courseName;
    //发布状态
    private String publishStatus;

}