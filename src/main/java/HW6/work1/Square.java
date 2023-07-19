package HW6.work1;

// Квадрат
public class Square extends Rectangle {

    public Square(int height) {
        super(height ,height);
    }

    public void setHeight(int height) {
        this.height = height;
        this.width = height;
    }

    @Override
    public void setWidth(int width) {
        setHeight(width);
    }
}
