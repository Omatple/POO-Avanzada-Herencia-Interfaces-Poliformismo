package POOAvanzada.Herencia.Figura.SuperClase.SubClases;

import POOAvanzada.Herencia.Figura.Enumerados.Color;
import POOAvanzada.Herencia.Figura.Coordenadas.Punto;
import POOAvanzada.Herencia.Figura.SuperClase.Figura;

import java.util.Objects;

public class TrianguloEquilatero extends Figura {
    private Punto verticeII;
    int lado;

    public TrianguloEquilatero(Color color, Punto verticeII, int lado) {
        super(color);
        setVerticeII(verticeII);
        setLado(lado);
    }

    public TrianguloEquilatero(TrianguloEquilatero trianguloEquilatero) {
        super(trianguloEquilatero.getColor());
        Objects.requireNonNull(trianguloEquilatero, "No se puede hacer una copia de un cuadrado nulo.");
        verticeII = new Punto(trianguloEquilatero.getVerticeII());
        lado = trianguloEquilatero.getLado();
    }

    public Punto getVerticeII() {
        return new Punto(verticeII);
    }

    public Punto getVerticeID() {
        return new Punto(verticeII.getX() + getLado(), verticeII.getY());
    }

    public Punto getVerticeSuperior() {
        // EL VERTICE.S SERA UN RESULTADO APROXIMADO, YA QUE LA CLASE PUNTO ESTA DECLARA CON ATRIBUTOS INT
        // NO PUEDO EXPRESAR COORDENADAS CON DECIMALES, COMO ALGUNOS CASOS DE ESTE VERTICE, ESTO SE DEBE TENER EN CUENTA.
        return new Punto(verticeII.getX() + (getLado() / 2), (int) ((Math.sqrt(3) / 2) * getLado()));
    }

    public void setVerticeII(Punto verticeII) {
        Objects.requireNonNull(verticeII, "El vertice inferior izquierdo del triangulo equilatero no puede ser nulo.");
        this.verticeII = new Punto(verticeII);
    }

    public int getLado() {
        return lado;
    }

    public void setLado(int lado) {
        if (lado < 1) {
            throw new IllegalArgumentException("La longitud del lado de un triangulo equilatero debe ser expresada con un numero positivo.");
        }
        this.lado = lado;
    }

    @Override
    public double getPerimetro() {
        return (getLado() * 3);
    }

    @Override
    public double getArea() {
        return ((Math.sqrt(3) / 4) * (getLado() * getLado()));
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
        int vecesVacioFueraT = 15 + (getVerticeSuperior().toString().length() + (getVerticeII().toString().length() + (getVerticeSuperior().toString().length() - getVerticeII().toString().length()) + (ladoX.length() * ((tamanioLadoLimitadoString() / 2))) - (getVerticeSuperior().toString().length())));
        int vecesVacioDentroT = 1;
        StringBuilder cadena = new StringBuilder();
        cadena.append(String.format("%sVerticeSuperior%s", vacio.repeat((-6) + getVerticeII().toString().length() + (getVerticeSuperior().toString().length() - getVerticeII().toString().length()) + (ladoX.length() * ((tamanioLadoLimitadoString() / 2))) - (getVerticeSuperior().toString().length())), getVerticeSuperior()));
        cadena.append(vacio + ladoY);
        while (String.format("%s%s%s", ladoY, vacio.repeat(vecesVacioDentroT), ladoY).length() <= ladoX.repeat(tamanioLadoLimitadoString()).length()) {
            cadena.append((String.format("%n%s%s%s%s", vacio.repeat((-6) + vecesVacioFueraT), ladoY, vacio.repeat(vecesVacioDentroT), ladoY)));
            vecesVacioFueraT--;
            vecesVacioDentroT += 2;
        }
        cadena.append(String.format("%nVerticeII%s %s", getVerticeII(), vacio.repeat(getVerticeSuperior().toString().length() - getVerticeII().toString().length())));
        cadena.append(ladoX.repeat(tamanioLadoLimitadoString()));
        cadena.append(String.format(" VerticeID%s", getVerticeID()));
        return String.format("TRIANGULO EQUILÁTERO%n[%nColor: %s%nLado : %su%n%s%n]", getColor(), lado, cadena);
    }
}
