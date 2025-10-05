/*
 * Michael Martino
 * Student# 991-799-901
 * 2025-03-17
 */
package Content;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;



public class WorkerFile {
    //Name of file to be written to and read from
    private static final String FILENAME = "Worker.dat";
    
    //setWorkers method
    public static void setWorkers(ArrayList<Worker> workerList) throws IOException{
        
        try ( //open io stream
                FileWriter fw = new FileWriter(FILENAME); BufferedWriter bw = new BufferedWriter(fw)) {
            
            //loop through workerlist parameter and write the data of each worker to the file
            for (Worker worker : workerList){
                bw.write(worker.getId() + "," + worker.getName() + "," + worker.getCity() + ","
                        + worker.getHours() + "," + worker.getRate() + "," + worker.getPay());
                bw.newLine();
            }
            //close io stream

        }
    }
    
    //getWorkers method
    public static ArrayList<Worker> getWorkers()throws FileNotFoundException, IOException{
        
        File file = new File(FILENAME);
        if (!file.exists()) {
            file.createNewFile();
            System.out.println("Worker.dat file has been created.");
            System.out.println();
        }
        
        ArrayList<Worker> workerList;
        try ( //open io stream
                FileReader fr = new FileReader(FILENAME); BufferedReader br = new BufferedReader(fr)) {
            //create an empty arrayList for Worker objects
            workerList = new ArrayList<>();
            //reads line from Worker.dat
            String workerLine = br.readLine();
            //loop while workerLine is not null
            while(workerLine != null){
                
                //split workerLine at the comma
                String[] fields = workerLine.split(",");
                
                //create variables for the first 5 fields
                int id = Integer.parseInt(fields[0]);
                String name = fields[1];
                String city = fields[2];
                int hours = Integer.parseInt(fields[3]);
                int rate = Integer.parseInt(fields[4]);
                
                //pass the variables as parameters to create a new Worker object
                Worker worker = new Worker(id, name, city, hours, rate);
                
                //add object to workerList
                workerList.add(worker);
                
                //read next line
                workerLine = br.readLine();
            }          }
        
        return workerList;
    }
}
