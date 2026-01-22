class point2D{
    private float x;
    private float y;

    public point2D(){
        this.x = 0;
        this.y = 0;
    }
    public point2D(float x, float y){
        this.x = x;
        this.y = y;
    }
    // setters
    public void setX(float x){
        this.x = x;
    }
    public void setY(float y){
        this.y = y;
    }
    public void setXY(float x, float y){
        this.x = x;
        this.y = y;
    }
    // getters
    public float getX(){
        return this.x;
    }
    public float getY(){
        return this.y;
    }
    public float[] getXY(){
        return new float[]{this.x, this.y};
    }
    public String toString(){
        return "(" + this.x + "; " + this.y + ")";
    }
}

class point3D extends point2D{
    private float z;
    public point3D(){
        super();
        this.z = 0;
    }
    public point3D(float x, float y, float z){
        super(x, y);
        this.z = z;
    }
    // setter
    public void setZ(float z){
        this.z = z;
    }
    public void setXYZ(float x, float y, float z){
        super.setXY(x, y);
        this.z = z;
    }
    // getter
    public float getZ(){
        return this.z;
    }
    public float[] getXYZ(){
        return new float[] {super.getX(), super.getX(), this.z};
    }
    public String toString(){
        return "(" + super.getX() + "; " + super.getY() + "; " + this.z + ")";
    }
}

public class exercise_3 {
    public static void main(String[] args) {
        point2D point2d_1 = new point2D(3, 4);
        point2D point2d_2 = new point2D();
        System.out.println("2D Point Para: " + point2d_1.toString());
        System.out.println("2D Point Default: " + point2d_2.toString());

        point3D point3d_1 = new point3D(5, 6, 7);
        point3D point3d_2 = new point3D();
        System.out.println("3D Point Para: " + point3d_1.toString());
        System.out.println("3D Point Default: " + point3d_2.toString());

    }
}