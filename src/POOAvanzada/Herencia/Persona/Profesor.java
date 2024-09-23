package POOAvanzada.Herencia.Persona;

import java.time.LocalDate;

public class Profesor extends Persona {
    private String especialidad;
    private double salario;

    public Profesor(String nombre, String apellidos, LocalDate fechaNacimiento, String especialidad, double salario) {
        super(nombre, apellidos, fechaNacimiento);
        setEspecialidad(especialidad);
        setSalario(salario);
    }

    @Override
    public String getNombre() {
        return String.format("Profesor -> %s", super.getNombre());
    }

    public String getEspecialidad() {
        return especialidad;
    }

    private void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public double getSalario() {
        return salario;
    }

    private void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String saludar(){
        return String.format("Hola, soy profesor, mi nombre es %s %s y soy de la especialidad '%s'.", super.getNombre(), getApellidos(), getEspecialidad());
    }

    @Override
    public String toString() {
        return String.format("PROFESOR%n[%n%s%nEspecialidad: %s %nSalario: %2.2f%n]", super.toString(), especialidad, salario);
    }
}
