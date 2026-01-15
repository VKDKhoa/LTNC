class Laptop{
    private
        String brand;
        String model;
        double price;
    public
        Laptop(){ // Default constructor
            System.out.println("Default Constructor has been called");
            this.brand = "DefaultBrand";
            this.model = "DefaultModel";
            this.price = 1000.0;
        }
        Laptop(String brd, String mod, double prc){ // Parameter constructor
            System.out.println("Parameter Constructor has been called");
            this.brand = brd;
            this.model = mod;
            this.price = prc;
        }
        Laptop(String brd){ // Constructor chaining
            this(); // calling default constructor
            System.out.println("Constructor Chaining has been called");
        }

        void display(){
            System.out.println("brand: " + this.brand + "; model: " + this.model + "; price: " + this.price);
        }
}

public class Ex2_Contructor_Chaining {
    public static void main(String[] args) {
        System.out.println("== Default Constructor ==");
        Laptop laptop1 = new Laptop(); // default constructor
        laptop1.display();

        System.out.println("\n==Parameter Constructor ==");
        Laptop laptop2 = new Laptop("Dell", "XPS 13", 1500.0); // parameterized constructor
        laptop2.display();

        System.out.println("\n== Constructor Chaining ==");
        Laptop laptop3 = new Laptop("Apple"); // parameter with chaininng
        laptop3.display();
    }
}