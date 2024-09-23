package POOAvanzada.Herencia.Figura.Enumerados;

public enum Color {
    ROJO("Rojo"),
    AZUL("Azul"),
    VERDE("Verde"),
    AMARILLO("Amarillo"),
    NEGRO("Negro"),
    NARANJA("Naranja"),
    MORADO("Marrón");

    private final String color;

    Color(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color;
    }
}
