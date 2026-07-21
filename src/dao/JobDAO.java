package dao;

import database.DBConnection;
import java.sql.*;
import model.Job;

public class JobDAO {

    // Post Job
    public boolean postJob(Job job) {

        String sql = "INSERT INTO jobs(title,company_name,location,salary,skills,description) VALUES(?,?,?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, job.getTitle());
            ps.setString(2, job.getCompanyName());
            ps.setString(3, job.getLocation());
            ps.setString(4, job.getSalary());
            ps.setString(5, job.getSkills());
            ps.setString(6, job.getDescription());

            return ps.executeUpdate() > 0;

        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    // View Jobs
    public void viewJobs() {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement("SELECT * FROM jobs");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== AVAILABLE JOBS ==========\n");

            while (rs.next()) {

                System.out.println("Job ID : " + rs.getInt("job_id"));
                System.out.println("Title : " + rs.getString("title"));
                System.out.println("Company : " + rs.getString("company_name"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Salary : " + rs.getString("salary"));
                System.out.println("Skills : " + rs.getString("skills"));
                System.out.println("Description : " + rs.getString("description"));
                System.out.println("------------------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Search Job
    public void searchJob(String skill) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM jobs WHERE skills LIKE ?");

            ps.setString(1, "%" + skill + "%");

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== SEARCH RESULT ==========\n");

            while (rs.next()) {

                System.out.println("Job ID : " + rs.getInt("job_id"));
                System.out.println("Title : " + rs.getString("title"));
                System.out.println("Company : " + rs.getString("company_name"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Salary : " + rs.getString("salary"));
                System.out.println("Skills : " + rs.getString("skills"));
                System.out.println("Description : " + rs.getString("description"));
                System.out.println("------------------------------------");
            }

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Update Job
    public boolean updateJob(int jobId, String salary) {

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps =
                    con.prepareStatement("UPDATE jobs SET salary=? WHERE job_id=?");

            ps.setString(1, salary);
            ps.setInt(2, jobId);

            return ps.executeUpdate() > 0;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }
    }

    // Delete Job
    public boolean deleteJob(int jobId) {

        String sql = "DELETE FROM jobs WHERE job_id=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setInt(1, jobId);

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(e);
            return false;

        }
    }

    public void viewMyJobs(String companyName) {

        String sql = "SELECT * FROM jobs WHERE company_name=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, companyName);

            ResultSet rs = ps.executeQuery();

            System.out.println("\n========== MY JOBS ==========\n");

            boolean found = false;

            while (rs.next()) {

                found = true;

                System.out.println("Job ID : " + rs.getInt("job_id"));
                System.out.println("Title : " + rs.getString("title"));
                System.out.println("Location : " + rs.getString("location"));
                System.out.println("Salary : " + rs.getString("salary"));
                System.out.println("Skills : " + rs.getString("skills"));
                System.out.println("Description : " + rs.getString("description"));
                System.out.println("------------------------------------");

            }

            if (!found) {
                System.out.println("No Jobs Found!");
            }

        } catch (Exception e) {

            System.out.println(e);

        }

    }
}