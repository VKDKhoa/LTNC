from typing import override #Python 3.12+ for @override decorator

class Vehicle:
    def __init__(self, brd: str = "Unknown", yrs: int = 0):
        self.__brand: str = brd # Private attribute
        self.__year: int = yrs

    def getBrand(self) -> str:
        return self.__brand
    def getYear(self) -> int:
        return self.__year

    def setBrand(self, brd: str)-> None:
        self.__brand = brd
    def setYear(self, yrs: int)-> None:
        self.__year = yrs

    def displayInfo(self) -> None:
        print("Vehicle's Information:")
        print(f"-Brand: {self.__brand}; Year: {self.__year}")

class Car(Vehicle):
    def __init__(self, brd:str = "Unknown", yrs:int = 0, mod:str = "Unknown"):
        super().__init__(brd, yrs)
        self.__model: str = mod
    
    def getModel(self) -> str:
        return self.__model
    def setModel(self, mod: str)-> None:
        self.__model = mod
    
    @override
    def displayInfo(self) -> None:
        print("Car's Information:")
        print(f"-Brand: {super().getBrand()}; Year: {super().getYear()}; Model: {self.__model}")

class Bike(Vehicle):
    def __init__(self, brd:str = "Unknown", yrs:int = 0, engineCapacity:int = 0):
        super().__init__(brd, yrs)
        self.__engineCapacity: int = engineCapacity
    
    def getEngineCapacity(self) -> int:
        return self.__engineCapacity
    def setEngineCapacity(self, engineCapacity: int)-> None:
        self.__engineCapacity = engineCapacity
    
    @override
    def displayInfo(self) -> None:
        print("Bike's Information:")
        print(f"-Brand: {super().getBrand()}; Year: {super().getYear()}; Engine Capacity: {self.__engineCapacity}")

def main():
    print("parameters constructor of Car:")
    car1: Vehicle = Car("Honda", 2021, "Civic")
    car1.displayInfo()

    print("\ndefault constructor of Car:")
    car2: Vehicle = Car()
    car2.displayInfo()
    
    print("\nparameters constructor of Bike:")
    bike1: Vehicle = Bike("Yamaha", 2019, 150)
    bike1.displayInfo()

    print("\ndefault constructor of Bike:")
    bike2: Vehicle = Bike()
    bike2.displayInfo()
    
if __name__ == "__main__":
    main()