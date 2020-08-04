package com.zyh.code.visitor;

import java.util.List;

import com.google.common.collect.Lists;

/**
 * @author aaa on 2017/10/23
 */
public class CommonVisitor {
    interface Visitor<T> {
        T visit(Square element);
        T visit(Circle element);
    }
    interface Element {
        <T> T accept(Visitor<T> visitor);
    }

    public static class Square implements Element {
        private double side;

        public Square(double side) {
            this.side = side;
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static class Circle implements Element {
        private double radius;

        public Circle(double radius) {
            this.radius = radius;
        }

        public <T> T accept(Visitor<T> visitor) {
            return visitor.visit(this);
        }
    }

    public static class AreaVisitor implements Visitor<Double> {

        public Double visit(Square element) {
            return element.side * element.side;
        }

        public Double visit(Circle element) {
            return Math.PI * element.radius * element.radius;
        }
    }

    public static void main(String[] args) {
        List<Element> all = Lists.newArrayList(new Circle(4), new Square(2));
        Visitor<Double> visitor = new AreaVisitor();
        double total = 0.0;
        for (Element element : all) {
            total += element.accept(visitor);
        }
        System.out.println(total);
    }
}
