package com.xuecheng.base.model;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @author Mr.M
 * @version 1.0
 * @description 分页查询分页参数
 * @date 2023/2/11 15:33
 */
@Data
@ToString
// @todo分页查询的参数
public class PageParams {
    @ApiModelProperty("页码")
    // 为什么是Long呢，因为mybatis里面就是Long
    private Long pageNo = 1L;

    @ApiModelProperty("每页记录数")
    private Long pageSize = 30L;

    public PageParams() {}

    public PageParams(Long pageNo, Long pageSize) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
    }
}
//@Data
//@ToString
//public class PageParams {
//
//    //当前页码
//    @ApiModelProperty("页码")
//    private Long pageNo = 1L;
//    //每页显示记录数
//    @ApiModelProperty("每页记录数")
//    private Long pageSize = 30L;
//
//    public PageParams() {
//    }
//
//    public PageParams(Long pageNo, Long pageSize) {
//        this.pageNo = pageNo;
//        this.pageSize = pageSize;
//    }
//}
