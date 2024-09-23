package POOAvanzada.Herencia.Figura.Enumerados;

public enum Direccion {
    ARRIBA("Arriba"),
    ABAJO("Abajo"),
    IZQUIERDA("Izquierda"),
    DERECHA("Derecha");

    private final String direccion;

    Direccion(String direccion) {
        this.direccion = direccion;
    }

    @Override
    public String toString() {
        return direccion;
    }
}
