package POOAvanzada.Herencia.Figura.SuperClase;

import POOAvanzada.Herencia.Figura.Enumerados.Color;
import POOAvanzada.Herencia.Figura.Enumerados.Direccion;
import java.util.Objects;

public abstract class Figura {
    private Color color;

    protected Figura(Color color) {
        setColor(color);
    }

    public Color getColor() {
        return color;
    }

    private void setColor(Color color) {
        Objects.requireNonNull(color, "El color de la figura no puede ser nulo.");
        this.color = color;
    }

    public abstract double getPerimetro();

    public abstract double getArea();

    public void desplazar(int cantidad, Direccion direccion) {
        if (cantidad < 1) {
            throw new IllegalArgumentException("La cantidad de unidades a moverse debe ser expresada mediante un numero positivo.");
        }
        int incX = 0;
        int incY = 0;
        switch (direccion) {
            case ARRIBA -> incY = cantidad;
            case ABAJO -> incY = -cantidad;
            case IZQUIERDA -> incX = -cantidad;
            case DERECHA -> incX = cantidad;
        }
        desplazar(incX, incY);
    }

    public abstract void desplazar(int incrementoX, int incrementoY);

    @Override
    public String toString() {
        return String.format("Figura%n[%nColor: %s%n]", color);
    }
}