package test;

import controllers.JugadorController;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int edad = 0, numCamiseta = 0, id = 0;
        String nombreCompleto, equipo, posicion;

        JugadorController jugador = new JugadorController();

        int opcion = -1;
        while (opcion != 0) {
            System.out.println(" -- MENÚ -- ");
            System.out.println("[1] Ingresar Jugador");
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
                    try {
                        System.out.print("Ingrese el nombre completo: ");
                        nombreCompleto = scanner.nextLine();
                    } catch (InputMismatchException m) {
                        System.out.println("Por favor, ingrese un nombre válido.");
                        continue;
                    }
                    try {
                        System.out.print("Ingrese la edad: ");
                        edad = scanner.nextInt();
                        scanner.nextLine();
                    } catch (NumberFormatException e) {
                        System.out.println("Error!. Por favor, ingrese nuevamente la edad.");
                        continue;
                    }
                    try {
                        System.out.print("Ingrese el equipo: ");
                        equipo = scanner.nextLine();
                    } catch (InputMismatchException m) {
                        System.out.println("Por favor, ingrese nuevamente el equipo.");
                        continue;
                    }
                    try {
                        System.out.print("Ingrese la posicion: ");
                        posicion = scanner.nextLine();
                    } catch (InputMismatchException m) {
                        System.out.println("Por favor, ingrese una posición válida.");
                        continue;
                    }

                    try {
                        System.out.print("Ingrese el numero de camiseta: ");
                        numCamiseta = scanner.nextInt();
                        scanner.nextLine();
                    } catch (NumberFormatException e) {
                        System.out.println("Error!. Por favor, ingrese un número de camiseta válido.");
                        continue;
                    }
                    jugador = new JugadorController();
                    System.out.println(jugador.create(nombreCompleto, edad, equipo, posicion, numCamiseta));
                    break;
                case 2:
                    System.out.println(jugador.readAll());
                    try {
                        System.out.print("Ingrese el id del jugador a eliminar: ");
                        id = scanner.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un numero entero válido.");
                        continue;
                    }
                    scanner.nextLine();
                    System.out.println(jugador.delete(id));
                    break;
                case 3:
                    System.out.println(jugador.readAll());
                    try {
                        System.out.print("Ingrese el id del jugador a editar: ");
                        id = scanner.nextInt();
                    } catch (NumberFormatException e) {
                        System.out.println("Por favor, ingrese un numero entero válido.");
                        continue;
                    }
                    scanner.nextLine();
                    System.out.println(jugador.update(id));
                    break;
                case 4:
                    System.out.println(jugador.readAll());
                    break;
                case 0:
                    System.out.println("¡Hasta Pronto!");
                    break;
                default:
                    System.out.println("Ingrese un número entre 0-3");
                    break;
            }
        }
    }
}