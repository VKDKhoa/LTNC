#include <iostream>
#include <string>
class Vehicle {
    private:
        std::string brand;
        int year;
    public:
        Vehicle(std::string b = "Unknown", int y = 0) : brand(b), year(y) {}
        std::string getBrand() const 
        {
            return brand;
        }
        int getYear() const 
        {
            return year;
        }
        void setBrand(const std::string& b) 
        {
            brand = b;
        }
        void setYear(int y) 
        {
            year = y;
        }
        virtual void displayInfo() 
        {
            std::cout << "Vehicle's Information:" << std::endl;
            std::cout << "- Brand: " << brand << ", Year: " << year << std::endl;
        }
        virtual ~Vehicle() {} // Virtual destructor, make sure derived class destructors are called
};

class Car : public Vehicle{
    private:
        std::string model;
    public:
        Car(std::string brd = "Unknown", int yrs = 0, std::string mod = "Unknown") 
            : Vehicle(brd, yrs), model(mod) {}
        std::string getModel() const 
        {
            return model;
        }
        void setModel(const std::string& mod) 
        {
            model = mod;
        }

        void displayInfo() override 
        {
            std::cout << "- Brand: " << getBrand() << ", Year: " << getYear() << "; Model: " << model << std::endl;
        }
};

class Bike : public Vehicle{
    private:
        int engineCapacity;
    public:
        Bike(std::string brd = "Unknown", int yrs = 0, int engineCapacity = 0) 
            : Vehicle(brd, yrs), engineCapacity(engineCapacity) {}
        
        int getEngineCapacity() const 
        {
            return engineCapacity;
        }
        void setEngineCapacity(int engCap) 
        {
            engineCapacity = engCap;
        }

        void displayInfo() override 
        {
            std::cout << "- Brand: " << getBrand() << ", Year: " << getYear() << ", Engine Capacity: " << engineCapacity << std::endl;
        }
};


int main() {
    
    std::cout << "parameters constructor of Car:" << std::endl;
    Vehicle* c1 = new Car("Toyota", 2020, "Corolla");
    c1->displayInfo();

    std::cout << "default constructor of Car:" << std::endl;
    Vehicle* c2 = new Car();
    c2->displayInfo();

    std::cout << "parameters constructor of Bike:" << std::endl;
    Vehicle* b1 = new Bike("Yamaha", 2019, 150);
    b1->displayInfo();
    
    std::cout << "default constructor of Bike:" << std::endl;
    Vehicle* b2 = new Bike();
    b2->displayInfo();

    delete c1;
    delete c2;
    delete b1;
    delete b2;
    return 0;
}