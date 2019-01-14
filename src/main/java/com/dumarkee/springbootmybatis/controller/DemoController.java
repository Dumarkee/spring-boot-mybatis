package com.dumarkee.springbootmybatis.controller;

import com.dumarkee.springbootmybatis.Student;
import com.dumarkee.springbootmybatis.entity.UserVO;
import com.dumarkee.springbootmybatis.service.DemoService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * Description:
 * Copyright: winshare
 * Author: 杜威
 * Date: 2018-09-19
 * Time: 19:33
 */
@RestController
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/likeName")
    public List<Student> likeName(String name) {
        PageHelper.startPage(1, 2);
        return demoService.likeName(name);
    }

    @RequestMapping("/listPage")
    public List<Student> listPage(Integer pageNum) {
        PageHelper.startPage(pageNum, 2);
        return demoService.listStudent();
    }

    @RequestMapping("/save")
    public Student save() {
        Student s = new Student();
        s.setAge(11);
        s.setBirthday(new Date());
        s.setName("Duwei");
        s.setSex("man");
        demoService.save(s);
        return s;
    }

    @RequestMapping("/get")
    public UserVO get(String id) {
        return demoService.get(Long.valueOf(id));
    }

    @RequestMapping("/update")
    public UserVO update(UserVO userVO) {
        return demoService.update(userVO);
    }

    @RequestMapping("/delete")
    public String delete(String id) {
        demoService.delete(Long.valueOf(id));
        return "success";
    }
}
