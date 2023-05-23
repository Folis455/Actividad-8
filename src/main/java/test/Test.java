package test;

import controllers.JugadorController;

import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int edad = 0, numCamiseta = 0, id = 0;
        String nombreCompleto, equipo, posicion;
        boolean esValido = false;

        JugadorController jugador = new JugadorController();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println(" -- MENÚ -- ");
            System.out.println("[1] Agregar Jugador");
            System.out.println("[2] Eliminar Jugador");
            System.out.println("[3] Editar Jugador");
            System.out.println("[4] Mostrar Jugadores");
            System.out.println("[0] Salir");
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
                    do {
                        System.out.print("Ingrese el nombre completo: ");
                        nombreCompleto = scanner.nextLine();
                        if (!nombreCompleto.matches("^[a-zA-Z ]*$"))
                            System.out.println("Debe ingresar un apellido válido");
                    } while (!nombreCompleto.matches("^[a-zA-Z ]*$"));

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

                    do {
                        System.out.print("Ingrese el equipo: ");
                        equipo = scanner.nextLine();
                        if (!equipo.matches("^[a-zA-Z ]*$"))
                            System.out.println("Debe ingresar un apellido válido");
                    } while (!equipo.matches("^[a-zA-Z ]*$"));

                    do {
                        System.out.print("Ingrese la posicion: ");
                        posicion = scanner.nextLine();
                        if (!posicion.matches("^[a-zA-Z ]*$"))
                            System.out.println("Debe ingresar un apellido válido");
                    } while (!posicion.matches("^[a-zA-Z ]*$"));

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

                    jugador = new JugadorController();
                    System.out.println(jugador.create(nombreCompleto, edad, equipo, posicion, numCamiseta));
                    break;
                case 2:
                    System.out.println(jugador.readAll());
                    try {
                        System.out.print("Ingrese el id del jugador a eliminar: ");
                        id = Integer.parseInt(scanner.nextLine());
                        ;
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un numero entero válido.");
                        continue;
                    }
                    System.out.println(jugador.delete(id));
                    break;
                case 3:
                    System.out.println(jugador.readAll());
                    try {
                        System.out.print("Ingrese el id del jugador a editar: ");
                        id = Integer.parseInt(scanner.nextLine());
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un numero entero válido.");
                        continue;
                    }
                    System.out.println(jugador.update(id));
                    break;
                case 4:
                    System.out.println(jugador.readAll());
                    break;
                case 0:
                    System.out.println("¡Hasta Pronto!");
                    break;
                default:
                    System.out.println("Ingrese un número entre 0-4");
                    break;
            }
        }
    }
}
