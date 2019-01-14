package com.dumarkee.springbootmybatis.mapper;

import com.dumarkee.springbootmybatis.Student;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * Description:
 * Copyright: winshare
 * Author: 杜威
 * Date: 2018-09-19
 * Time: 19:29
 */
public interface DemoMapper {
    //#{name}:参数占位符
    @Select("select * from student where name=#{name}")
    public List<Student> likeName(String name);


    @Select("select * from student where id = #{id}")
    public Student getById(long id);

    @Select("select name from student where id = #{id}")
    public String getNameById(long id);

    @Select("select * from student")
    List<Student> getAll();


    /**
     * 保存数据.
     */
    @Insert("insert into student(name,age,sex,birthday) values(#{name},#{age},#{sex},#{birthday})")
    @Options(useGeneratedKeys=true,keyProperty="id",keyColumn="id")
    public void save(Student demo);

}
