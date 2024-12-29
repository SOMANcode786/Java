package Prblem;

import java.util.Scanner;

class Circle {
    public int radius;

    Circle(int radius) {
        this.radius = radius;
    }

    public double area() {
        return Math.PI * this.radius * this.radius;
    }
}

class Cylinder extends Circle {
    public int height;

    Cylinder(int radius, int height) {
        super(radius);
        this.height = height;
    }

    public double volume() {
        return Math.PI * this.radius * this.radius * this.height;
    }
}

public class Problem1 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        System.out.print("Enter radius of the circle: ");
        int r = s.nextInt();

        System.out.print("Enter height of the cylinder: ");
        int h = s.nextInt();

        Cylinder c = new Cylinder(r, h);

        System.out.println("Area of the circle: " + c.area());
        System.out.println("Volume of the cylinder: " + c.volume());
    }
}
