/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entidades;

/**
 *
 * @author Alumno
 */
public class Mascota {
    private String numero;
    private String nombre;
    private String tipodeanimal;
    private String raza;
    private String fechadenacimiento;
    private String dnicliente;

    public Mascota(String numero, String nombre, String tipodeanimal, String raza, String fechadenacimiento, String dnicliente) {
        this.numero = numero;
        this.nombre = nombre;
        this.tipodeanimal = tipodeanimal;
        this.raza = raza;
        this.fechadenacimiento = fechadenacimiento;
        this.dnicliente = dnicliente;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombremascota) {
        this.nombre = nombremascota;
    }

    public String getTipodeanimal() {
        return tipodeanimal;
    }

    public void setTipodeanimal(String tipodeanimal) {
        this.tipodeanimal = tipodeanimal;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getFechadenacimiento() {
        return fechadenacimiento;
    }

    public void setFechadenacimiento(String fechadenacimiento) {
        this.fechadenacimiento = fechadenacimiento;
    }

    public String getDnicliente() {
        return dnicliente;
    }

    public void setDnicliente(String dnicliente) {
        this.dnicliente = dnicliente;
    }

    @Override
    public String toString() {
        return "Mascota{" + "numero=" + numero + ", nombremascota=" + nombre + ", tipodeanimal=" + tipodeanimal + ", raza=" + raza + ", fechadenacimiento=" + fechadenacimiento + ", dnicliente=" + dnicliente + '}';
    }
    
    
}
