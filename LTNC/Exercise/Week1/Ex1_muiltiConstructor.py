class Car:
    def __init__(self, brand: str = "Unknown", model: str = "Unknow", year: int = 0):
        self.brand = brand
        self.model = model
        self.year = year
    
    # Setter method
    def Set_brand(self, brand: str) -> None:
        self.brand = brand
    def Set_model(self, model: str) -> None:
        self.model = model
    def Set_year(self, year: int) -> None:
        self.year = year
    
    # Getter method
    def Get_brand(self) -> str:
        return self.brand
    def Get_model(self) -> str:
        return self.model
    def Get_year(self) -> int:
        return self.year
    
    # display method
    def display_info(self) -> None:
        print(f"Car Brand: {self.brand}, Model: {self.model}, Year: {self.year}")

def main():
    # creating car objects by using different constructors
    print("Default Constructor: ")
    car1: Car = Car() # default constructor
    car1.display_info() # display car info
    print("\nParameter Constructors: ")
    
    car2: Car = Car("Ford", "Mustang", 2020) # parameter constructor with brand, model, and year
    car2.display_info()

if __name__ == "__main__":
    main()