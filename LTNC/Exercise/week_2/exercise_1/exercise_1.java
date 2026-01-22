class Vehicle {
    private String brand;
    private int years;
    
    public Vehicle(){
        this.brand = "Unknow";
        this.years = 0;
    }
    
    public Vehicle(String brd, int yrs){
        this.brand = brd;
        this.years = yrs;
    }
    
    public void setBrand(String brd){
        this.brand = brd;
    }
    
    public void setYears(int y){
        this.years = y;
    }
    
    public String getBrand(){
        return this.brand;
    }
    public int getYears(){
        return this.years;
    }
    
    public void displayInfo(){
        System.out.println("Vehicle's information:");
        System.out.println("- Brand:  " + this.brand + "; Years: " + this.years);
    }
}

class Car extends Vehicle{
    private String model;
    public Car()
    {
        super();
        this.model = "unknow model";
    }
    public Car(String brd, int y, String mod){
        super(brd,y);
        this.model = mod;
    }
    
    @Override
    public void displayInfo(){
        System.out.println("Car's information:");
        System.out.println("- Brand:  " + getBrand() + "; Years: " + getYears() + "; Model: " + this.model);
    }
}

class Bike extends Vehicle{
    private int engineCapacity;
    public Bike()
    {
        super();
        this.engineCapacity = 0;
    }
    public Bike(String brd, int y, int ec){
        super(brd,y);
        this.engineCapacity = ec;
    }
    
    @Override
    public void displayInfo(){
        System.out.println("Bike's information:");
        System.out.println("- Brand:  " + getBrand() + "; Years: " + getYears() + "; Engine Capacity: " + this.engineCapacity);
    }
}

public class exercise_1 {
    public static void main(String[] args) {
        Vehicle c1 = new Car("Honda", 3, "Civic");
        c1.displayInfo();
        Vehicle b1 = new Bike("Yamaha", 2, 150);
        b1.displayInfo();
    }
}