package dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Application;

public class ApplicationDAO {

    // Apply Job
    public boolean applyJob(Application application) {

        String sql = "INSERT INTO applications(student_id,job_id,apply_date,status) VALUES(?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, application.getStudentId());
            ps.setInt(2, application.getJobId());
            ps.setString(3, application.getApplyDate());
            ps.setString(4, application.getStatus());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }
    }

    // View Applications
    public void viewApplications() {

        String sql = "SELECT * FROM applications";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== APPLICATIONS ==========\n");

            while (rs.next()) {

                System.out.println("Application ID : " + rs.getInt("id"));
                System.out.println("Student ID : " + rs.getInt("student_id"));
                System.out.println("Job ID : " + rs.getInt("job_id"));
                System.out.println("Apply Date : " + rs.getString("apply_date"));
                System.out.println("Status : " + rs.getString("status"));
                System.out.println("------------------------------------");

            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }

    public void viewMyApplications(int studentId) {

        String sql = "SELECT * FROM applications WHERE student_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, studentId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== MY APPLICATIONS ==========\n");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("Application ID : " + rs.getInt("id"));
                System.out.println("Job ID : " + rs.getInt("job_id"));
                System.out.println("Apply Date : " + rs.getString("apply_date"));
                System.out.println("Status : " + rs.getString("status"));
                System.out.println("------------------------------------");

            }

            if (!found) {
                System.out.println("No Applications Found!");
            }

        } catch (Exception e) {

            System.out.println(e);

        }
    }
    public boolean updateApplicationStatus(int applicationId, String status) {

        String sql = "UPDATE applications SET status=? WHERE id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, status);
            ps.setInt(2, applicationId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;
    }

}