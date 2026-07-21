package ui;

import java.util.Scanner;

import dao.ApplicationDAO;
import dao.JobDAO;
import model.Application;

public class StudentMenu {

    public static void showMenu(Scanner sc) {

        JobDAO jobDAO = new JobDAO();
        ApplicationDAO applicationDAO = new ApplicationDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      STUDENT DASHBOARD");
            System.out.println("=================================");
            System.out.println("1. View Jobs");
            System.out.println("2. Search Job");
            System.out.println("3. Apply Job");
            System.out.println("4. View Applications");
            System.out.println("5. Logout");
            System.out.print("Enter Choice : ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

                    jobDAO.viewJobs();
                    break;

                case 2:

                    System.out.print("Enter Skill : ");
                    String skill = sc.nextLine();

                    jobDAO.searchJob(skill);

                    break;

                case 3:

                    Application application = new Application();

                    System.out.print("Enter Student ID : ");
                    application.setStudentId(Integer.parseInt(sc.nextLine()));

                    System.out.print("Enter Job ID : ");
                    application.setJobId(Integer.parseInt(sc.nextLine()));

                    application.setApplyDate(java.time.LocalDate.now().toString());

                    application.setStatus("Pending");

                    if(applicationDAO.applyJob(application)) {

                        System.out.println("\nApplication Submitted Successfully!");

                    } else {

                        System.out.println("\nApplication Failed!");

                    }

                    break;

                case 4:

                    System.out.print("Enter Your Student ID : ");
                    int studentId = Integer.parseInt(sc.nextLine());

                    applicationDAO.viewMyApplications(studentId);
                    break;

                case 5:

                    return;

                default:

                    System.out.println("Invalid Choice");

            }

        }

    }

}