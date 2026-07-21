package model;

public class Student {

    private String name;
    private String email;
    private String password;
    private String phone;
    private String college;
    private String skills;
    private String resume;

    public Student() {
    }

    public Student(String name, String email, String password,
                   String phone, String college,
                   String skills, String resume) {

        this.name = name;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.college = college;
        this.skills = skills;
        this.resume = resume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }
}