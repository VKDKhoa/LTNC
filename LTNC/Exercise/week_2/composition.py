from typing import override #Python 3.12+ for @override decorator

# Example of Inheritance and Composition
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

class Engine: # Composition - Engine is part of Car, demo car must have an engine
    def __init__(self, horsepower: int = 0):
        self.__horsepower: int = horsepower
    def engineStart(self) -> None:
        print("Engine started:")
        print(f"-Horsepower: {self.__horsepower}")

class driver: # Aggregation - driver uses Car, demo car might have a driver
    def __init__(self, name: str = "VKDK"):
        self.__name: str = name
    def drive(self) -> None:
        print("Driver's Information:")
        print(f"{self.__name} is driving the car.")

class Car(Vehicle): # Inheritance - Car is a Vehicle, has-a Engine, might have-a driver
    def __init__(self, brd:str = "Unknown", yrs:int = 0, mod:str = "Unknown", 
                 engine: Engine = Engine(), driver: driver = None):
        super().__init__(brd, yrs)
        self.__model: str = mod
        self.__engine: Engine = engine # Composition - has-a Engine, obligatory
        self.__driver = driver # Composition - might have-a driver, optional

    def getModel(self) -> str:
        return self.__model
    def setModel(self, mod: str)-> None:
        self.__model = mod
    
    @override
    def displayInfo(self) -> None:
        print("Car's Information:")
        print(f"-Brand: {super().getBrand()}; Year: {super().getYear()}; Model: {self.__model}")
        if self.__engine:
            self.__engine.engineStart()
        
        if self.__driver:
            print(f"-Driver: {self.__driver._driver__name}")
        else:
            print("-No driver assigned.")


def main():
    print("Car with Engine and Driver:")
    engine1 = Engine(150)
    driver1 = driver("Alice")
    car1: Vehicle = Car("Honda", 2021, "Civic", engine1, driver1)
    car1.displayInfo()
    # Output:
    # Car with Engine and Driver:
    # Car's Information:
    # -Brand: Honda; Year: 2021; Model: Civic
    # Engine started:
    # -Horsepower: 150
    # -Driver: Alice


    print("\nCar with Engine only:")
    engine2 = Engine(100)
    car2: Vehicle = Car(engine=engine2)
    car2.displayInfo()
    # Output:
    # Car with Engine only:
    # Car's Information:
    # -Brand: Unknown; Year: 0; Model: Unknown
    # Engine started:
    # -Horsepower: 100
    # -No driver assigned.

if __name__ == "__main__":
    main()