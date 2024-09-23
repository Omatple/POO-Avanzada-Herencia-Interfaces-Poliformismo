package POOAvanzada.Herencia.Persona;

import java.time.LocalDate;

public abstract class Persona {
    private String nombre;
    private String apellidos;
    private LocalDate fechaNacimiento;

    public Persona() {
    }

    public Persona(String nombre, String apellidos, LocalDate fechaNacimiento) {
        setNombre(nombre);
        setApellidos(apellidos);
        setFechaNacimiento(fechaNacimiento);
    }

    public String getNombre() {
        return nombre;
    }

    private void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    private void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    private void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public abstract String saludar();

    @Override
    public String toString() {
        return String.format("Nombre: %s%nApellidos: %s%nFecha Nacimiento: %s", nombre, apellidos, fechaNacimiento);
    }
}
