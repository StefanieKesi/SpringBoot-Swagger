package com.stefanie.sun.controller;


import com.alibaba.fastjson.JSON;
import com.stefanie.sun.model.SwaggerModel;
import io.swagger.annotations.*;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/swagger")
@Api(value = "SwaggerController 用来测试swagger的控制器类")
public class SwaggerController {

    // http://localhost:8080/swagger-ui.html
    @ResponseBody
    @RequestMapping(value = "/getUserName", method = RequestMethod.GET)
    @ApiOperation(value = "根据用户编号获取用户姓名", notes = "test: 仅1和2有正确返回")
    @ApiImplicitParam(paramType = "query", name = "userNumber", value = "用户编号", required = true, dataType = "Integer")
    public String getUserName(@RequestParam Integer userNumber) {
        if (userNumber == 1) {
            return "张三丰";
        } else if (userNumber == 2) {
            return "慕容复";
        } else {
            return "未知";
        }
    }

    @ResponseBody
    @RequestMapping(value = "/updatePassword", method = RequestMethod.POST)
    @ApiOperation(value = "修改用户密码", notes = "根据用户id修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户ID", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "旧密码", required = true, dataType = "String"),
            @ApiImplicitParam(paramType = "query", name = "newPassword", value = "新密码", required = true, dataType = "String")
    })
    public String updatePassword(@RequestParam(value = "userId") Integer userId, @RequestParam(value = "password") String password,
                                 @RequestParam(value = "newPassword") String newPassword) {
        if (userId <= 0 || userId > 2) {
            return "未知的用户";
        }
        if (StringUtils.isEmpty(password) || StringUtils.isEmpty(newPassword)) {
            return "密码不能为空";
        }
        if (password.equals(newPassword)) {
            return "新旧密码不能相同";
        }
        return "密码修改成功!";
    }

    @ResponseBody
    @RequestMapping(value = "/printUserInfo", method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ApiOperation(value = "输出用户信息", notes = "输出用户信息")
    public String printUserInfo(@RequestBody @ApiParam(name = "用户组",value = "传入json格式") SwaggerModel swaggerModel){
        String s = JSON.toJSONString(swaggerModel);
        return s;
    }

}
