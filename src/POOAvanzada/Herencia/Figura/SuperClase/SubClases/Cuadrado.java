package POOAvanzada.Herencia.Figura.SuperClase.SubClases;

import POOAvanzada.Herencia.Figura.Enumerados.Color;
import POOAvanzada.Herencia.Figura.Enumerados.Direccion;
import POOAvanzada.Herencia.Figura.Coordenadas.Punto;
import POOAvanzada.Herencia.Figura.SuperClase.Figura;

import java.util.Objects;

public class Cuadrado extends Figura {
    private Punto verticeII;
    private int lado;

    public Cuadrado(Color color, Punto verticeII, int lado) {
        super(color);
        setVerticeII(verticeII);
        setLado(lado);
    }

    public Cuadrado(Cuadrado cuadrado) {
        super(cuadrado.getColor());
        Objects.requireNonNull(cuadrado, "No se puede hacer una copia de un cuadrado nulo.");
        verticeII = new Punto(cuadrado.getVerticeII());
        lado = cuadrado.getLado();
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        if (lado < 1) {
            throw new IllegalArgumentException("La longitud del lado de un cuadrado debe ser expresada con un numero positivo.");
        }
        this.lado = lado;
    }

    public Punto getVerticeII() {
        return new Punto(verticeII);
    }

    public Punto getVerticeID() {
        return new Punto(verticeII.getX() + getLado(), verticeII.getY());
    }

    public Punto getVerticeSI() {
        return new Punto(verticeII.getX(), verticeII.getY() + getLado());
    }

    public Punto getVerticeSD() {
        return new Punto(verticeII.getX() + getLado(), verticeII.getY() + getLado());
    }

    public void setVerticeII(Punto verticeII) {
        Objects.requireNonNull(verticeII, "El vertice inferior izquierdo del cuadrado no puede ser nulo.");
        this.verticeII = new Punto(verticeII);
    }

    @Override
    public double getPerimetro() {
        return (getLado() * 4);
    }

    @Override
    public double getArea() {
        return (getLado() * getLado());
    }

    @Override
    public void desplazar(int incrementoX, int incrementoY) {
        verticeII.desplazar(incrementoX, incrementoY);
    }

    private int tamanioLadoLimitadoString(){
        int tamanioLado= getLado();
        if(tamanioLado > 40){
            tamanioLado = 40;
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
        cadena.append(ladoX.repeat(tamanioLadoLimitadoString()));
        cadena.append(String.format(" VerticeSD%s", getVerticeSD()));
        String representacionLadoY = (String.format("%n%s%s%s%s", vacio.repeat(10 + (getVerticeSI().toString().length())), ladoY, vacio.repeat((tamanioLadoLimitadoString() * ladoX.length()) - (ladoY.length() * 2)), ladoY));
        cadena.append(representacionLadoY.repeat(tamanioLadoLimitadoString()));
        cadena.append(String.format("%nVerticeII%s %s", getVerticeII(), vacio.repeat(getVerticeSI().toString().length() - getVerticeII().toString().length())));
        cadena.append(ladoX.repeat(tamanioLadoLimitadoString()));
        cadena.append(String.format(" VerticeID%s", getVerticeID()));
        return String.format("CUADRADO%n[%nColor: %s%nLado : %su%n%s%n]", getColor(), lado, cadena);
    }
}