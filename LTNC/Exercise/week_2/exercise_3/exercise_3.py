class point2D:
    def __init__(self, x:float = 0, y:float = 0):
        self.__x = x #__x and __y are private attributes
        self.__y = y
    
    # getters
    def getX(self) -> float:
        return self.__x
    def getY(self) -> float:
        return self.__y
    def getXY(self) -> tuple:
        return (self.__x, self.__y)
    
    # setters
    def setX(self, x:float) -> None:
        self.__x = x
    def setY(self, y:float) -> None:
        self.__y = y
    def setXY(self, x:float, y:float) -> None:
        self.__x = x
        self.__y = y
    def __str__(self):
        return f"({self.__x}; {self.__y})"

class point3D(point2D):
    def __init__(self, x:float = 0, y:float = 0, z:float = 0):
        super().__init__(x, y)
        self.__z = z
    # getter
    def getZ(self) -> float:
        return self.__z   
    def getXYZ(self) -> tuple:
        return (super().getXY()[0], super().getXY()[1], self.__z)

    # setter
    def setZ(self, z:float) -> None:
        self.__z = z
    def setXYZ(self, x:float, y:float, z:float) -> None:
        super().setXY(x, y)
        self.__z = z
    
    def __str__(self):
        return f"({super().__str__().strip('()')}; {self.__z})"  #strips to remove parentheses

def main():
    point2d_1 = point2D(3, 4)
    point2d_2 = point2D()
    print("2D Point Para: " + str(point2d_1))
    print("2D Point Default: " + str(point2d_2))

    point3d_1 = point3D(5, 6, 7)
    point3d_2 = point3D()
    print("3D Point Para: " + str(point3d_1))
    print("3D Point Default: " + str(point3d_2))

if __name__ == "__main__":
    main()