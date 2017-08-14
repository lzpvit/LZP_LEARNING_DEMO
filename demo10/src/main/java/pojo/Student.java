package pojo;

import javax.persistence.*;

/**
 * Created by LZP on 2017/7/25.
 */
@Entity
@Table(name = "Student")
public class Student {
    private int student_id;
    private String student_name;
@Id
@Column(name = "student_id")
    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    @Basic
@Column(name = "student_name")
    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    private Teacher teacher;
    @ManyToOne
    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Student(){

    }
    public Student(int id,String name,Teacher teacher){
        this.student_id=id;
        this.student_name=name;
        this.teacher=teacher;
    }


}
