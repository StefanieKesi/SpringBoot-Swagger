package com.stefanie.sun.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;

@ApiModel(value = "用户组",description = "描述一组用户")
@Data
public class SwaggerModel {

    @ApiModelProperty(value = "用户组名",name = "userGroup",example = "group1",required = true)
    private String userGroup;
    @ApiModelProperty(value = "用户组",name = "userList" ,required = true)
    private List<User> userList;
}
