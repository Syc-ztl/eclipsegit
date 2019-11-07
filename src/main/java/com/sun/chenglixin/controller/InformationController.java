package com.sun.chenglixin.controller;

import com.sun.chenglixin.entity.Information;
import com.sun.chenglixin.service.IInformationService;
import com.sun.chenglixin.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;

/**
 * @Description 题库控制层
 * @Date 2019/11/5 9:43
 * @Author wlb
 */
@RestController
@RequestMapping(value = "Information")
public class InformationController extends BaseController {

    @Autowired
    IInformationService iInformationService;

    /**
     * 保存试题
     * @Description
     * @Date 2019/11/7 9:53
     * @Author wlb
     * @Param [information, title, session, answer, rAnswer]
     * @return com.sun.chenglixin.util.JsonResult<java.lang.Void>
     */
    @RequestMapping(value = "saveInformation")
    public JsonResult<Void> saveInformation(Information information, String title, HttpSession session, String answer, String[] rAnswer){
        String username = (String) session.getAttribute("username");
        iInformationService.saveInformation(information, title, username, answer, rAnswer);
        JsonResult<Void> json=new JsonResult<Void>();
        json.setState(20);
        return json;
    }

}
