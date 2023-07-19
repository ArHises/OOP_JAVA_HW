package HW6.work1;

// Прямоугольник

import lombok.Data;

@Data
public class Rectangle {

    int height;
    int width;

    public Rectangle(int height, int width) {
        this.height = height;
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWidth(int width) {
        this.width = width;
    }
}
