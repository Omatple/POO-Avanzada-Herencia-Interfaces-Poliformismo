package POOAvanzada.Herencia.Figura.Coordenadas;

import java.util.Objects;

public class Punto {
    private int x;
    private int y;

    public Punto(int x, int y) {
        setX(x);
        setY(y);
    }

    public Punto(Punto punto) {
        Objects.requireNonNull(punto, "No se puede hacer una copia de un punto nulo.");
        x = punto.getX();
        y = punto.getY();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    private void setX(int x) {
        this.x = x;
    }

    private void setY(int y) {
        this.y = y;
    }

    public void desplazar(int incrementoX, int incrementoY) {
        x += incrementoX;
        y += incrementoY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return x == punto.x && y == punto.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return String.format("(%s, %s)", x, y);
    }
}
