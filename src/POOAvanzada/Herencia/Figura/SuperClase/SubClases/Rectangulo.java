package POOAvanzada.Herencia.Figura.SuperClase.SubClases;

import POOAvanzada.Herencia.Figura.Enumerados.Color;
import POOAvanzada.Herencia.Figura.Coordenadas.Punto;
import POOAvanzada.Herencia.Figura.SuperClase.Figura;

import java.util.Objects;

public class Rectangulo extends Figura {
    private Punto verticeII;
    private int ladoX;
    private int ladoY;

    /*
    public Rectangulo(Punto centro, Color color, Punto verticeII, int ladoX, int ladoY) {
        super(new Punto(centro), color);
        setVerticeII(verticeII);
        setLadoX(ladoX);
        setLadoY(ladoY);
    }
    ESTE CONSTRUCTOR LO VEO INSERVIBLE YA QUE LA MAYORIA DE VECES DESCONOCEREMOS EL CENTRO, Y QUE
    ESTE SEGUN HA SIDO CONSTRUIDO Y PLANTEADO EL DIAGRAMA DE CLASES NO TIENE NINGUN USO NI SENTIDO EN ESTA CLASE.
    */

    public Rectangulo(Color color, Punto verticeII, int ladoX, int ladoY) {
        super(color);
        setVerticeII(verticeII);
        setLadoX(ladoX);
        setLadoY(ladoY);
    }

    public Rectangulo(Rectangulo rectangulo) {
        super(rectangulo.getColor());
        Objects.requireNonNull(rectangulo, "No se puede hacer una copia de un rectangulo nulo.");
        verticeII = new Punto(rectangulo.getVerticeII());
        ladoX = rectangulo.getLadoX();
        ladoY = rectangulo.getLadoY();
    }

    public int getLadoX() {
        return ladoX;
    }

    private void setLadoX(int ladoX) {
        if (ladoX <= 0) {
            throw new IllegalArgumentException("La longitud del lado X debe ser expresada mediante un numero positivo.");
        }
        this.ladoX = ladoX;
    }

    public int getLadoY() {
        return ladoY;
    }

    private void setLadoY(int ladoY) {
        if (ladoY <= 0) {
            throw new IllegalArgumentException("La longitud del lado Y debe ser expresada mediante un numero positivo.");
        }
        if (ladoY == getLadoX()) {
            throw new IllegalArgumentException("Los lados de un rectangulo no pueden ser iguales, pues sino sera un cuadrado.");
        }
        this.ladoY = ladoY;
    }

    public Punto getVerticeII() {
        return new Punto(verticeII);
    }

    public Punto getVerticeID() {
        return new Punto(verticeII.getX() + getLadoX(), verticeII.getY());
    }

    public Punto getVerticeSI() {
        return new Punto(verticeII.getX(), verticeII.getY() + getLadoY());
    }

    public Punto getVerticeSD() {
        return new Punto(verticeII.getX() + getLadoX(), verticeII.getY() + getLadoY());
    }

    private void setVerticeII(Punto verticeII) {
        Objects.requireNonNull(verticeII, "El vertice inferior izquierdo del rectangulo no puede ser nulo.");
        this.verticeII = new Punto(verticeII);
    }

    @Override
    public double getPerimetro() {
        return ((getLadoX() + getLadoY()) * 2);
    }

    @Override
    public double getArea() {
        return (getLadoX() * getLadoY());
    }

    @Override
    public void desplazar(int incrementoX, int incrementoY) {
        verticeII.desplazar(incrementoX, incrementoY);
    }

    private int tamanioLadoXLimitadoString() {
        int tamanioLado = getLadoX();
        if (tamanioLado > 40) {
            tamanioLado = 40;
        }
        return tamanioLado;
    }

    private int tamanioLadoYLimitadoString() {
        int tamanioLado = getLadoY();
        if (getLadoX() > 40) {
            tamanioLado = (int) ((40.0 / getLadoX()) * tamanioLado);
        }
        if (tamanioLado > 90) {
            tamanioLado = 90;
        }
        return tamanioLado;
    }

    @Override
    public String toString() {
        String ladoX = "███";
        String ladoY = "█";
        String vacio = " ";
        StringBuilder cadena = new StringBuilder();
        cadena.append(String.format("VerticeSI%s ", getVerticeSI()));
        cadena.append(ladoX.repeat(tamanioLadoXLimitadoString()));
        cadena.append(String.format(" VerticeSD%s", getVerticeSD()));
        String representacionLadoY = (String.format("%n%s%s%s%s", vacio.repeat(10 + (getVerticeSI().toString().length())), ladoY, vacio.repeat((tamanioLadoXLimitadoString() * ladoX.length()) - (ladoY.length() * 2)), ladoY));
        cadena.append(representacionLadoY.repeat(tamanioLadoYLimitadoString()));
        cadena.append(String.format("%nVerticeII%s %s", getVerticeII(), vacio.repeat(getVerticeSI().toString().length() - getVerticeII().toString().length())));
        cadena.append(ladoX.repeat(tamanioLadoXLimitadoString()));
        cadena.append(String.format(" VerticeID%s", getVerticeID()));
        return String.format("RECTANGULO%n[%nColor: %s%nLado X: %su%nLado Y: %su%n%s%n]", getColor(), this.ladoX, this.ladoY, cadena);
    }
}
