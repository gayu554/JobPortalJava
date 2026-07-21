package main;

import dao.ApplicationDAO;
import dao.CompanyDAO;
import dao.JobDAO;
import dao.StudentDAO;
import java.util.Scanner;
import model.Application;
import model.Company;
import model.Job;
import model.Student;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StudentDAO studentDAO = new StudentDAO();
        CompanyDAO companyDAO = new CompanyDAO();
        JobDAO jobDAO = new JobDAO();
        ApplicationDAO applicationDAO = new ApplicationDAO();

        while (true) {

            System.out.println("\n====================================");
            System.out.println("        JOB PORTAL SYSTEM");
            System.out.println("====================================");
            System.out.println("1. Student Registration");
            System.out.println("2. Student Login");
            System.out.println("3. Company Registration");
            System.out.println("4. Company Login");
            System.out.println("5. Post Job");
            System.out.println("6. View Jobs");
            System.out.println("7. Apply Job");
            System.out.println("8. View Applications");
            System.out.println("9. Search Job");
            System.out.println("10. Update Job");
            System.out.println("11. Delete Job");
            System.out.println("12. Exit");
            System.out.print("Enter Your Choice : ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    Student student = new Student();

                    System.out.print("Enter Name : ");
                    student.setName(sc.nextLine());

                    System.out.print("Enter Email : ");
                    student.setEmail(sc.nextLine());

                    System.out.print("Enter Password : ");
                    student.setPassword(sc.nextLine());

                    System.out.print("Enter Phone : ");
                    student.setPhone(sc.nextLine());

                    System.out.print("Enter College : ");
                    student.setCollege(sc.nextLine());

                    System.out.print("Enter Skills : ");
                    student.setSkills(sc.nextLine());

                    System.out.print("Enter Resume File Name : ");
                    student.setResume(sc.nextLine());

                    if (studentDAO.registerStudent(student)) {
                        System.out.println("\nStudent Registered Successfully!");
                    } else {
                        System.out.println("\nRegistration Failed!");
                    }

                    break;

                case 2:

                    System.out.print("Enter Email : ");
                    String email = sc.nextLine();

                    System.out.print("Enter Password : ");
                    String password = sc.nextLine();
                    
                    if (studentDAO.loginStudent(email, password)) {

                        System.out.println("\nStudent Login Successful!");

                        ui.StudentMenu.showMenu(sc);

                    } else {

                        System.out.println("\nInvalid Email or Password!");

                    }
                    

                    break;
                case 3:

                    Company company = new Company();

                    System.out.print("Enter Company Name : ");
                    company.setCompanyName(sc.nextLine());

                    System.out.print("Enter Email : ");
                    company.setEmail(sc.nextLine());

                    System.out.print("Enter Password : ");
                    company.setPassword(sc.nextLine());

                    System.out.print("Enter Location : ");
                    company.setLocation(sc.nextLine());

                    if (companyDAO.registerCompany(company)) {
                        System.out.println("\nCompany Registered Successfully!");
                    } else {
                        System.out.println("\nCompany Registration Failed!");
                    }

                    break;
               
                case 4:

                    System.out.print("Enter Company Email : ");
                    String companyEmail = sc.nextLine();

                    System.out.print("Enter Password : ");
                    String companyPassword = sc.nextLine();
                    if (companyDAO.loginCompany(companyEmail, companyPassword)) {

                        System.out.println("\nCompany Login Successful!");

                        ui.CompanyMenu.showMenu(sc);

                    } else {

                        System.out.println("\nInvalid Email or Password!");

                    }
                  
                    break;

                case 5:

                    Job job = new Job();

                    System.out.print("Enter Job Title : ");
                    job.setTitle(sc.nextLine());

                    System.out.print("Enter Company Name : ");
                    job.setCompanyName(sc.nextLine());

                    System.out.print("Enter Location : ");
                    job.setLocation(sc.nextLine());

                    System.out.print("Enter Salary : ");
                    job.setSalary(sc.nextLine());

                    System.out.print("Enter Skills : ");
                    job.setSkills(sc.nextLine());

                    System.out.print("Enter Description : ");
                    job.setDescription(sc.nextLine());

                    if (jobDAO.postJob(job)) {
                        System.out.println("\nJob Posted Successfully!");
                    } else {
                        System.out.println("\nJob Posting Failed!");
                    }

                    break;

                case 6:

                   jobDAO.viewJobs();
                   break;

                
                case 7:

                        Application application = new Application();

                        System.out.print("Enter Student ID : ");
                        application.setStudentId(Integer.parseInt(sc.nextLine()));

                        System.out.print("Enter Job ID : ");
                        application.setJobId(Integer.parseInt(sc.nextLine()));

                        application.setApplyDate(java.time.LocalDate.now().toString());
                        application.setStatus("Pending");

                        if (applicationDAO.applyJob(application)) {
                            System.out.println("\nApplication Submitted Successfully!");
                        } else {
                            System.out.println("\nApplication Failed!");
                        }

                        break;
                
                case 8:

                        applicationDAO.viewApplications();

                        break;

               case 9:

                        System.out.print("Enter Skill to Search : ");
                        String skill = sc.nextLine();

                        jobDAO.searchJob(skill);

                        break;

                case 10:

                        System.out.print("Enter Job ID : ");
                        int jobId = Integer.parseInt(sc.nextLine());

                        System.out.print("Enter New Salary : ");
                        String salary = sc.nextLine();

                        if(jobDAO.updateJob(jobId, salary)) {
                            System.out.println("\nJob Updated Successfully!");
                        } else {
                            System.out.println("\nJob Update Failed!");
                          }

                        break;

                    case 11:

                        System.out.print("Enter Job ID to Delete : ");
                        int deleteId = Integer.parseInt(sc.nextLine());

                        if (jobDAO.deleteJob(deleteId)) {
                            System.out.println("\nJob Deleted Successfully!");
                        } else {
                            System.out.println("\nJob Delete Failed!");
                        }

                        break;

                case 12:

                        System.out.println("\nThank You for Using Job Portal!");
                        sc.close();
                        System.exit(0);
                        break;
                            
                    }
        }

    }

}