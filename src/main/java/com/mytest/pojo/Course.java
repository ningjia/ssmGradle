package com.mytest.pojo;

import java.util.List;

/**
 * Created by jn on 2017/5/22.
 */
public class Course {


    private Integer id;

    private String name;

    private String remark;

    private Integer t_id;

    private Teacher teacher;

    private List<Student> students;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getT_id() {
        return t_id;
    }

    public void setT_id(Integer t_id) {
        this.t_id = t_id;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id==null?"":id +
                ", name='" + name==null?"":name + '\'' +
                ", remark='" + remark==null?"":remark + '\'' +
                ", t_id=" + t_id==null?"":t_id +
                ", teacher=" + teacher.toString() +
                ", students=" + students.toString() +
                "}";
    }
}
