package controllers;

import domain.Jugador;
import jakarta.persistence.criteria.CriteriaQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class JugadorController {
    private SessionFactory sessionFactory;

    public JugadorController() {
        sessionFactory = new Configuration().configure().addAnnotatedClass(Jugador.class).buildSessionFactory();
    }

    private Session openSession() {
        return sessionFactory.openSession();
    }

    public String create(String nombreCompleto, int edad, String equipo, String posicion, int numeroCamiseta) {
        Session session = openSession();
        try {
            Jugador jugador = new Jugador(nombreCompleto, edad, equipo, posicion, numeroCamiseta);
            session.beginTransaction();
            session.save(jugador);
            session.getTransaction().commit();
            return "El jugador se ha registrado";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "Error al registrar jugador";
    }

    public String delete(int id) {
        Session session = openSession();
        try {
            session.beginTransaction();
            Jugador jugador = session.get(Jugador.class, id);
            session.delete(jugador);
            session.getTransaction().commit();
            return "El jugador se ha eliminado";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "Error al eliminar jugador";
    }

    public String update(int id) {

        Scanner scanner = new Scanner(System.in);
        boolean esValido = false;
        Session session = openSession();
        try {
            session.beginTransaction();
            Jugador jugador = session.get(Jugador.class, id);
            int opcion = -1;
            while (opcion != 0) {
                System.out.println(" -- MENÚ -- ");
                System.out.println("[1] Editar nombre");
                System.out.println("[2] Editar edad");
                System.out.println("[3] Editar equipo");
                System.out.println("[4] Editar posicion");
                System.out.println("[5] Editar dorsal");
                System.out.println("[0] Actualizar jugador");
                System.out.println("------------");
                System.out.print("Elija una opción: ");

                try {
                    opcion = Integer.parseInt(scanner.nextLine());
                } catch (NumberFormatException e) {
                    System.out.println("Por favor, ingrese un numero entero válido.");
                    continue;
                }
                switch (opcion) {
                    case 1:
                        String nombreCompleto = null;
                        do {
                            System.out.print("Ingrese el nombre completo: ");
                            nombreCompleto = scanner.nextLine();
                            if (!nombreCompleto.matches("^[a-zA-Z ]*$"))
                                System.out.println("Debe ingresar un apellido válido");
                        } while (!nombreCompleto.matches("^[a-zA-Z ]*$"));

                        jugador.setNombreCompleto(nombreCompleto);
                        session.update(jugador);
                        break;
                    case 2:
                        int edad = 0;
                        esValido = false;
                        do {
                            try {
                                System.out.print("Ingrese la edad: ");
                                edad = Integer.parseInt(scanner.nextLine());
                                esValido = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Error!. Por favor, ingrese nuevamente la edad.");
                            }
                        } while (!esValido);

                        jugador.setEdad(edad);
                        session.update(jugador);
                        break;
                    case 3:
                        String equipo;
                        do {
                            System.out.print("Ingrese el equipo: ");
                            equipo = scanner.nextLine();
                            if (!equipo.matches("^[a-zA-Z ]*$"))
                                System.out.println("Debe ingresar un apellido válido");
                        } while (!equipo.matches("^[a-zA-Z ]*$"));

                        jugador.setEquipo(equipo);
                        session.update(jugador);
                        break;
                    case 4:
                        String posicion;
                        do {
                            System.out.print("Ingrese la posicion: ");
                            posicion = scanner.nextLine();
                            if (!posicion.matches("^[a-zA-Z ]*$"))
                                System.out.println("Debe ingresar un apellido válido");
                        } while (!posicion.matches("^[a-zA-Z ]*$"));
                        jugador.setPosicion(posicion);
                        session.update(jugador);
                        break;
                    case 5:
                        int numCamiseta = 0;
                        esValido = false;
                        do {
                            try {
                                System.out.print("Ingrese el numero de camiseta: ");
                                numCamiseta = Integer.parseInt(scanner.nextLine());
                                esValido = true;
                            } catch (NumberFormatException e) {
                                System.out.println("Error!. Por favor, ingrese un número de camiseta válido.");
                            }
                        } while (!esValido);

                        jugador.setNumeroCamiseta(numCamiseta);
                        session.update(jugador);
                        break;
                    case 0:
                        break;
                    default:
                        System.out.println("Ingrese un número entre 0-5");
                        break;
                }
            }
            session.getTransaction().commit();

            return "El jugador se ha actualizado";
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
        return "Error al actualizar jugador";
    }

    public List<Jugador> readAll() {
        Session session = null;
        List<Jugador> jugadores = new ArrayList<>();

        try {
            session = openSession();
            session.beginTransaction();

            // Consulta para leer todos los jugadores
            CriteriaQuery<Jugador> query = session.getCriteriaBuilder().createQuery(Jugador.class);
            query.from(Jugador.class);
            List<Jugador> resultados = session.createQuery(query).getResultList();

            session.getTransaction().commit();

            // Agregar los jugadores a la lista
            jugadores.addAll(resultados);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null) {
                session.close();
            }
        }

        return jugadores;
    }

}
