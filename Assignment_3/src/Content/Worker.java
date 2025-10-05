/*
 * Michael Martino
 * Student# 991-799-901
 * 2025-03-17
 */
package Content;

public class Worker {
    private final int id;
    private String name;
    private String city;
    private int hours;
    private int rate;
    private double pay;
    
    public Worker(int id, String name, String city, int hours, int rate){
        this.id = id;
        this.name = name;
        this.city = city;
        this.hours = hours;
        this.rate = rate;
        calculatePay();
    }
    
    public int getId(){
        return this.id;
    }
    
    public void setName(String name){
        this.name = name;
    } 
    
    public String getName(){
        return this.name;
    }
    
    public void setCity(String city){
        this.city = city;
    }
    
    public String getCity(){
        return this.city;
    }
    
    public void setHours(int hours){
        this.hours = hours;
    }
    
    public int getHours(){
        return this.hours;
    }
    
    public void setRate(int rate){
        this.rate = rate;
    }
    
    public int getRate(){
        return this.rate;
    }
    
    public double getPay(){
        calculatePay();
        return this.pay;
    }
    
    private void calculatePay(){
        this.pay = this.hours * this.rate;
    }
}
