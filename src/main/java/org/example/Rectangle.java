package org.example;

 public class Rectangle implements Figure {
     private double width;
     private double height;
     private String fillColor;
     private String borderColor;
     public Rectangle(double width, double height) {
         this.width = width;
         this.height = height;
     }
     public double calculationPerimeter() {
         return 2 * (width + height);
     }
     public double calculationArea() {
         return width * height;
     }
     public String getFillColor() {
         return fillColor;
     }
     public void setFillColor(String color) {
         this.fillColor = color;
     }
     public String getBorderColor() {
         return borderColor;
     }
     public void setBorderColor(String color) {
         this.borderColor = color;
     }


}
