package model;

public class Company {

    private String companyName;
    private String email;
    private String password;
    private String location;

    public Company() {
    }

    public Company(String companyName, String email, String password, String location) {
        this.companyName = companyName;
        this.email = email;
        this.password = password;
        this.location = location;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}