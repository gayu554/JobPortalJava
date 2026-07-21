package dao;

import database.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import model.Company;

public class CompanyDAO {

    // Company Registration
    public boolean registerCompany(Company company) {

        String sql = "INSERT INTO company(company_name,email,password,location) VALUES(?,?,?,?)";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, company.getCompanyName());
            ps.setString(2, company.getEmail());
            ps.setString(3, company.getPassword());
            ps.setString(4, company.getLocation());

            int rows = ps.executeUpdate();

            return rows > 0;

        } catch (Exception e) {

            System.out.println(e);
            return false;
        }
    }

    // Company Login
    public boolean loginCompany(String email, String password) {

        String sql = "SELECT * FROM company WHERE email=? AND password=?";

        try {

            Connection con = DBConnection.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, email);
            ps.setString(2, password);
                System.out.println("Email = " + email);
                System.out.println("Password = " + password);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                System.out.println("FOUND");
                return true;
            }

            System.out.println("NOT FOUND");
            return false;
           

        } catch (Exception e) {

            System.out.println(e);
        }

        return false;
    }
}