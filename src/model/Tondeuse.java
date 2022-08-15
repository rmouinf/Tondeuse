package model;

public class Tondeuse implements IMobileElement {
    private final Position position;

    private char orientation;

    public Tondeuse(Position position, char orientation) {
        this.position = position;
        this.orientation = orientation;
    }

    public Position getPosition() {
        return position;
    }


    public char getOrientation() {
        return orientation;
    }


    @Override
    public void move() {
        switch (this.orientation) {
            case 'N' -> this.moveUp();
            case 'E' -> this.moveRight();
            case 'S' -> this.moveDown();
            case 'W' -> this.moveLeft();
        }

    }

    @Override
    public void turnRight() {
        switch (this.orientation) {
            case 'N' -> this.orientation = 'E';
            case 'E' -> this.orientation = 'S';
            case 'S' -> this.orientation = 'W';
            case 'W' -> this.orientation = 'N';
        }
    }

    @Override
    public void turnLeft() {
        switch (this.orientation) {
            case 'N' -> this.orientation = 'W';
            case 'E' -> this.orientation = 'N';
            case 'S' -> this.orientation = 'E';
            case 'W' -> this.orientation = 'S';
        }
    }

    public void moveUp() {
        this.position.setY(this.position.getY() + 1);
    }


    public void moveDown() {
        this.position.setY(this.position.getY() - 1);
    }


    public void moveLeft() {
        this.position.setX(this.position.getX() - 1);
    }


    public void moveRight() {
        this.position.setX(this.position.getX() + 1);
    }

    @Override
    public String toString() {
        return "Tonduse en position & orientation " + this.position.getX() + " " + this.position.getY() + " " + this.orientation;
    }
}
