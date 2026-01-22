#include <iostream>
#include <string>
#include <vector>

class point2D{
    private:
        float x;
        float y;
    public:
        point2D(float x_val = 0.0, float y_val = 0.0) : x(x_val), y(y_val) {}

        float getX() const {
            return this->x;
        }

        float getY() const {
            return this->y;
        }

        void setX(float x_val) {
            this->x = x_val;
        }

        void setY(float y_val) {
            this->y = y_val;
        }

        std::vector<float> getXY() const {
            return {this->x, this->y};
        }

        std::string toString() const {
            return "(" + std::to_string(x) + ", " + std::to_string(y) + ")";
        }
};

class point3D : public point2D{
    private:
        float z;
    public:
        
        point3D(float x_val = 0.0, float y_val = 0.0, float z_val = 0.0) 
            : point2D(x_val, y_val), z(z_val) {};
        
        float getZ() const {
            return this->z;
        }
        std::vector<float> getXYZ() const{
            return {getX(), getY(), this->z};
        }
        void setZ(float z_val) {
            this->z = z_val;
        }
        void setXYZ(float x_val, float y_val, float z_val) {
            setX(x_val);
            setY(y_val);
            this->z = z_val;
        }
        std::string toString() const {
            return "(" + std::to_string(getX()) + ", " + std::to_string(getY()) + ", " + std::to_string(z) + ")";
        }
};

int main() {
    point2D p2d1(3.5, 4.5);
    point2D p2d2;
    std::cout << "2D Point para: " << p2d1.toString() << std::endl;
    std::cout << "2D Point default: " << p2d2.toString() << std::endl;

    point3D p3d1(1.0, 2.0, 3.0);
    point3D p3d2;
    std::cout << "3D Point para: " << p3d1.toString() << std::endl;
    std::cout << "3D Point default: " << p3d2.toString() << std::endl;
    return 0;
}