/*
 * Michael Martino
 * Student# 991-799-901
 * 2025-03-17
 */
package assignment_3;

import Content.Worker;
import Content.WorkerFile;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assignment_3 {


    public static void main(String[] args) {
        
        Scanner k = new Scanner(System.in);
        ArrayList<Worker> workerList = new ArrayList<>();
        ArrayList<Integer> usedIds = new ArrayList<>();
        
        
        try{
            workerList.addAll(WorkerFile.getWorkers());
            
            for(Worker worker : workerList){
                int id = worker.getId();
                usedIds.add(id);
            }
        
            int isRunning = 1;
        
            while(isRunning == 1){
            
                System.out.println("1. Display Workers");
                System.out.println("2. Add Worker");
                System.out.println("3. Delete Worker");
                System.out.println("4. End Program");
                System.out.print("Choose an option: ");
                int choice = -1;
                while (choice == -1) {
                    try {
                        choice = k.nextInt();  // Get the choice
                        k.nextLine();  // Consume the newline character

                        if (choice < 1 || choice > 4) {
                            System.out.println("Invalid choice. Please enter a number between 1 and 4: ");
                            choice = -1;  // Set to -1 so the loop continues
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Invalid input. Please enter an integer between 1 and 4: ");
                        k.nextLine();  // Clear the invalid input
                    }
                }
            
                switch (choice) {
                    case 1 -> {
                        System.out.println("=".repeat(88));
                        System.out.println("ID\t\tName\t\tCity\t\tHours\t\tRate\t\tPay");
                        System.out.println();
                        for(Worker worker : workerList){
                            System.out.println(worker.getId() + "\t\t" + worker.getName() + "\t\t" + worker.getCity() +
                                    "\t\t" + worker.getHours() + "\t\t" + worker.getRate() + "\t\t$" + worker.getPay());
                        }       System.out.println("=".repeat(88));
                    }
                    case 2 -> {
                        int id = -1;
                        while(id == -1){
                            try{
                                System.out.println("Enter Worker ID number: ");
                                id = k.nextInt();
                                k.nextLine();
                                
                                if(id <= 0){
                                    System.out.println("Invalid ID. Please enter a positive integer.");
                                    id = -1;
                                }else if(usedIds.contains(id)){
                                    System.out.println("ID already in use - Try again.");
                                    id = -1;
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Invalid ID - Please enter an integer. ");
                                k.nextLine();
                            }
                            usedIds.add(id);
                        }       System.out.println("Enter Worker Name: ");
                        String name = k.nextLine();
                        System.out.println("Enter Worker City: ");
                        String city = k.nextLine();
                        int hours = 0;
                        while(hours <= 0){
                            try{
                                System.out.println("Enter hours worked by Worker: ");
                                hours = k.nextInt();
                                k.nextLine();
                                while(hours <= 0){
                                    System.out.println("Hours must be greater than 0.");
                                    hours = k.nextInt();
                                    k.nextLine();
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Invalid input for hours worked - Must be a positive integer.");
                                k.nextLine();
                            }
                        }       int rate = 0;
                        while(rate <= 0){
                            try{
                                System.out.println("Enter Worker's hourly rate: ");
                                rate = k.nextInt();
                                k.nextLine();
                                if(rate <= 0){
                                    System.out.println("Rate must be greater than 0.");
                                }
                            }catch(InputMismatchException e){
                                System.out.println("Invalid input for hourly rate - Must be a positive integer.");
                                k.nextLine();
                            }
                        }       Worker worker = new Worker(id, name, city, hours, rate);
                        workerList.add(worker);
                        System.out.println("Worker added.");
                    }
                    case 3 -> {
                        try{
                            System.out.println("Enter Worker ID to delete: ");
                            int deleteId = k.nextInt();
                            k.nextLine();
                            
                            ArrayList<Worker> workerListCopy = new ArrayList<>();
                            workerListCopy.addAll(workerList);
                            
                            if(usedIds.contains(deleteId)){
                                for(Worker worker : workerListCopy){
                                    if(worker.getId() == deleteId){
                                        workerList.remove(worker);
                                        usedIds.remove(Integer.valueOf(deleteId));
                                        System.out.println("Worker with ID " + deleteId + " has been deleted.");
                                    }
                                }
                            }
                            else{
                                System.out.println("Worker with ID " + deleteId + " not found.");
                            }}catch(InputMismatchException e){
                                System.out.println("Invalid input - ID must be an integer.");
                                k.nextLine();
                            }
                    }
                    case 4 -> {
                        WorkerFile.setWorkers(workerList);
                        System.out.println("Worker list has been saved");
                        System.out.println();
                        isRunning = 0;
                        System.out.println("Michael Martino Student 991-799-901");
                    }
                    default -> System.out.println("Invalid choice");
                }
        }
        
        
        }catch(FileNotFoundException e){
            System.err.println(e);
        }catch(IOException e){
            System.err.println(e);
        }catch(InputMismatchException e){
            
        }
        
        
        
        
        
    }
    
}
