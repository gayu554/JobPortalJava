package ui;

import java.util.Scanner;

import dao.ApplicationDAO;
import dao.JobDAO;
import model.Job;

public class CompanyMenu {

    public static void showMenu(Scanner sc) {

        JobDAO jobDAO = new JobDAO();
        ApplicationDAO applicationDAO = new ApplicationDAO();

        while (true) {

            System.out.println("\n=================================");
            System.out.println("      COMPANY DASHBOARD");
            System.out.println("=================================");
            System.out.println("1. Post Job");
            System.out.println("2. View My Jobs");
            System.out.println("3. Update Job");
            System.out.println("4. Delete Job");
            System.out.println("5. View Applications");
            System.out.println("6. Logout");
            System.out.print("Enter Choice : ");

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {

                case 1:

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

                case 2:

                        System.out.print("Enter Company Name : ");
                        String companyName = sc.nextLine();

                        jobDAO.viewMyJobs(companyName);

                    break;

                case 3:

                    System.out.print("Enter Job ID : ");
                    int jobId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter New Salary : ");
                    String salary = sc.nextLine();

                    if (jobDAO.updateJob(jobId, salary)) {
                        System.out.println("\nJob Updated Successfully!");
                    } else {
                        System.out.println("\nJob Update Failed!");
                    }

                    break;

                case 4:

                    System.out.print("Enter Job ID : ");
                    int deleteId = Integer.parseInt(sc.nextLine());

                    if (jobDAO.deleteJob(deleteId)) {
                        System.out.println("\nJob Deleted Successfully!");
                    } else {
                        System.out.println("\nJob Delete Failed!");
                    }

                    break;

                case 5:

                    applicationDAO.viewApplications();

                    System.out.print("\nEnter Application ID : ");
                    int applicationId = Integer.parseInt(sc.nextLine());

                    System.out.print("Enter Status (Accepted/Rejected) : ");
                    String status = sc.nextLine();

                    if (applicationDAO.updateApplicationStatus(applicationId, status)) {

                        System.out.println("\nApplication Status Updated Successfully!");

                    } else {

                        System.out.println("\nUpdate Failed!");

                    }

                    break;              
                case 6:

                    return;

                default:

                    System.out.println("Invalid Choice!");

            }

        }

    }

}