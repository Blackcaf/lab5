package models;

/**
 * Класс, представляющий координаты.
 */
public class Coordinates {
    private float x; // Значение должно быть больше -89
    private int y; // Значение должно быть больше -862

    public Coordinates(float x, int y) {
        if (x <= -89) {
            throw new IllegalArgumentException("Координата x должна быть больше -89.");
        }
        if (y <= -862) {
            throw new IllegalArgumentException("Координата y должна быть больше -862.");
        }
        this.x = x;
        this.y = y;
    }

    public float getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return "Coordinates{x=" + x + ", y=" + y + "}";
    }
}

