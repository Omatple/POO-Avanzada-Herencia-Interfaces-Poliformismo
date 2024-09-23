package POOAvanzada.Herencia.Figura.SuperClase.SubClases;

import POOAvanzada.Herencia.Figura.Enumerados.Color;
import POOAvanzada.Herencia.Figura.Coordenadas.Punto;
import POOAvanzada.Herencia.Figura.SuperClase.Figura;

import java.util.Objects;

public class Circulo extends Figura {
    private int radio;

    private Punto centro;

    public Circulo(Punto centro, Color color, int radio) {
        super(color);
        setCentro(centro);
        setRadio(radio);
    }

    public Circulo(Circulo circulo) {
        super(circulo.getColor());
        Objects.requireNonNull(circulo, "No puede hacer una copia de un circulo nulo.");
        centro = new Punto(circulo.getCentro());
        radio = circulo.getRadio();
    }

    private void setCentro(Punto centro) {
        Objects.requireNonNull(centro, "El centro de la figura no puede ser nulo.");
        this.centro = new Punto(centro);
    }

    public Punto getCentro() {
        return new Punto(centro);
    }

    public int getRadio() {
        return radio;
    }

    private void setRadio(int radio) {
        if (radio < 1) {
            throw new IllegalArgumentException("La longitud del radio debe ser expresada con un numero positivo.");
        }
        this.radio = radio;
    }

    @Override
    public void desplazar(int incrementoX, int incrementoY) {
        centro.desplazar(incrementoX, incrementoY);
    }

    @Override
    public double getPerimetro() {
        return (2 * Math.PI * getRadio());
    }

    @Override
    public double getArea() {
        return (Math.PI * (getRadio() * getRadio()));
    }

    @Override
    public String toString() {
        return String.format("Circulo%n[%nCentro%s%nRadio: %su%nColor: %s%n]", centro, radio, super.getColor());
    }
}
