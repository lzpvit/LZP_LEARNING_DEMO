package pojo;

import javax.persistence.*;

/**
 * Created by LZP on 2017/7/25.
 */
@Entity
@Table(name = "Teacher")
public class Teacher {
    private int teacher_id;
    private String teacher_name;
@Id
@Column(name = "teacher_id")
    public int getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(int teacher_id) {
        this.teacher_id = teacher_id;
    }

    @Basic
@Column(name = "teacher_name")
    public String getTeacher_name() {
        return teacher_name;
    }

    public void setTeacher_name(String teacher_name) {
        this.teacher_name = teacher_name;
    }

    //  private Student student;
 /*   @OneToMany
    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }
                   */
    public Teacher(){
    }
    public Teacher(int id,String name){
        this.teacher_id=id;
        this.teacher_name=name;
    }


}
