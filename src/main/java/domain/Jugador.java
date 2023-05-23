package domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "jugadores")
public class Jugador {
    @Id
    @Column(name = "id_jugadores")
    private int idJugador;

    @Column(name = "nombre_completo")
    private String nombreCompleto;

    @Column(name = "edad")
    private int edad;

    @Column(name = "equipo")
    private String equipo;

    @Column(name = "posicion")
    private String posicion;

    @Column(name = "numero_camiseta")
    private int numeroCamiseta;

    public Jugador() {
    }

    public Jugador(String nombreCompleto, int edad, String equipo, String posicion, int numeroCamiseta) {
        this.nombreCompleto = nombreCompleto;
        this.edad = edad;
        this.equipo = equipo;
        this.posicion = posicion;
        this.numeroCamiseta = numeroCamiseta;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getEquipo() {
        return equipo;
    }

    public void setEquipo(String equipo) {
        this.equipo = equipo;
    }

    public String getPosicion() {
        return posicion;
    }

    public void setPosicion(String posicion) {
        this.posicion = posicion;
    }

    public int getNumeroCamiseta() {
        return numeroCamiseta;
    }

    public void setNumeroCamiseta(int numeroCamiseta) {
        this.numeroCamiseta = numeroCamiseta;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("+--------------+-----------------+------+---------+---------+-----------------+\n");
        sb.append("|  ID Jugador  |  Nombre Completo | Edad | Equipo  | Posicion| Numero Camiseta |\n");
        sb.append("+--------------+-----------------+------+---------+---------+-----------------+\n");
        sb.append(String.format("|  %-12s|  %-15s|  %-4d |  %-7s|  %-7s|  %-15s|\n",
                idJugador, nombreCompleto, edad, equipo, posicion, numeroCamiseta));
        sb.append("+--------------+-----------------+------+---------+---------+-----------------+\n");
        return sb.toString();
    }


}
