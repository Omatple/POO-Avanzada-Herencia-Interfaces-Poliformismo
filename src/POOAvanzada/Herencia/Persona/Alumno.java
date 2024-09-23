package POOAvanzada.Herencia.Persona;

import java.time.LocalDate;

public class Alumno extends Persona {
    private String grupo;
    private double notaMedia;

    public Alumno(String nombre, String apellidos, LocalDate fechaNacimiento, String grupo, double nota) {
        super(nombre, apellidos, fechaNacimiento);
        setGrupo(grupo);
        setNotaMedia(nota);
    }

    @Override
    public String getNombre(){
        return String.format("Alumno -> %s", super.getNombre());
    }

    public String getGrupo() {
        return grupo;
    }

    private void setGrupo(String grupo) {
        this.grupo = grupo;
    }

    public double getNotaMedia() {
        return notaMedia;
    }

    private void setNotaMedia(double notaMedia) {
        this.notaMedia = notaMedia;
    }

    @Override
    public String saludar(){
        return String.format("Hola, soy el alumno %s %s y estoy en el grupo '%s'.", super.getNombre(), getApellidos(), getGrupo());
    }

    @Override
    public String toString() {
        return String.format("ALUMNO%n[%n%s%nGrupo: %s%nNota: %2.2f%n]", super.toString(), grupo, notaMedia);
    }
}
