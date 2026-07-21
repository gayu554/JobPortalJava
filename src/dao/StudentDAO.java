package dao;

import database.DBConnection;
import model.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class StudentDAO {

    // Student Registration
    public boolean registerStudent(Student student) {

        String sql = "INSERT INTO student(name,email,password,phone,college,skills,resume) VALUES(?,?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, student.getName());
            ps.setString(2, student.getEmail());
            ps.setString(3, student.getPassword());
            ps.setString(4, student.getPhone());
            ps.setString(5, student.getCollege());
            ps.setString(6, student.getSkills());
            ps.setString(7, student.getResume());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }
    }

    // Student Login
    public boolean loginStudent(String email, String password) {

        String sql = "SELECT * FROM student WHERE email=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }

        } catch (Exception e) {

            System.out.println(e);

        }

        return false;
    }

}