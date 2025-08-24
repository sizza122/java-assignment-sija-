public class ShapeDrawer {
    static class InvalidShapeException extends Exception {
        public InvalidShapeException(String message) { super(message); }
    }

    static abstract class DrawableShape {
        public abstract void draw();
    }

    static class Circle extends DrawableShape {
        private double radius;
        public Circle(double radius) throws InvalidShapeException {
            if (radius <= 0) throw new InvalidShapeException("Radius must be positive");
            this.radius = radius;
        }
        @Override public void draw() {
            System.out.println("Drawing Circle (radius " + radius + ")");
        }
    }

    static class Square extends DrawableShape {
        private double side;
        public Square(double side) throws InvalidShapeException {
            if (side <= 0) throw new InvalidShapeException("Side must be positive");
            this.side = side;
        }
        @Override public void draw() {
            System.out.println("Drawing Square (side " + side + ")");
        }
    }

    static class Triangle extends DrawableShape {
        private double base, height;
        public Triangle(double base, double height) throws InvalidShapeException {
            if (base <= 0 || height <= 0)
                throw new InvalidShapeException("Base and height must be positive");
            this.base = base;
            this.height = height;
        }
        @Override public void draw() {
            System.out.println("Drawing Triangle (base " + base + ", height " + height + ")");
        }
    }

    public static void main(String[] args) {
        try {
            DrawableShape[] shapes = {
                    new Circle(5),
                    new Square(4),
                    new Triangle(3, 6)
            };
            for (DrawableShape s : shapes) s.draw();
        } catch (InvalidShapeException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}
