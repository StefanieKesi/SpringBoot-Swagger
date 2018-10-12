package com.stefanie.sun.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "user对象",description = "描述user对象")
@Data
public class User {

    @ApiModelProperty(value = "用户名",name = "name",example = "kesi",required = true)
    private String name;
    @ApiModelProperty(value = "用户年龄",name = "age",example = "19" ,required = true)
    private int age;
}
