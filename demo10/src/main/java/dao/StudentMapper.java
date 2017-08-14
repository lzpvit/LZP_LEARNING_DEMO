package dao;

import org.springframework.jdbc.core.RowMapper;
import pojo.Student;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by LZP on 2017/7/28.
 */
public class StudentMapper implements RowMapper<Student>{
    public Student mapRow(ResultSet resultSet,int rowNum)throws SQLException{
        Student student=new Student();
        student.setStudent_id(resultSet.getInt("student_id"));
        student.setStudent_name(resultSet.getString("student_name"));
        return student;
    }
}
