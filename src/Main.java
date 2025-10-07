package src;

import src.models.Cliente;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    // Solo clientes
    static ArrayList<Cliente> clientes = new ArrayList<>();

    // MENÚ PRINCIPAL (solo clientes)
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Salir");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Por favor, escribe un número válido: ");
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestionarClientes(sc);
                case 2 -> System.out.println("Gracias por su visita... ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 2);
    }

    // GESTIÓN DE CLIENTES
    static void gestionarClientes(Scanner sc) {

        int opc;

        do {
            System.out.println("\n-- GESTIÓN DE CLIENTES --");
            System.out.println("1. Añadir cliente");
            System.out.println("2. Eliminar cliente");
            System.out.println("3. Modificar datos de un cliente");
            System.out.println("4. Mostrar listado de clientes");
            System.out.println("5. Volver al menú principal");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Por favor, introduce un número válido: ");
            }
            opc = sc.nextInt();
            sc.nextLine();

            switch (opc) {
                case 1 -> {
                    System.out.print("Nombre: ");
                    String nombre = sc.nextLine();
                    System.out.print("DNI: ");
                    String dni = sc.nextLine();
                    System.out.print("Teléfono: ");
                    String telefono = sc.nextLine();
                    System.out.print("Email: ");
                    String email = sc.nextLine();

                    clientes.add(new Cliente(nombre, dni, telefono, email));
                    System.out.println("Cliente añadido correctamente.");
                }

                case 2 -> {
                    listarClientes();
                    if (clientes.isEmpty()) break;

                    System.out.print("Número del cliente que quieres eliminar: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Por favor, introduce un número válido: ");
                    }
                    int posBorrar = sc.nextInt();
                    sc.nextLine();

                    posBorrar = posBorrar - 1;
                    if (posBorrar >= 0 && posBorrar < clientes.size()) {
                        clientes.remove(posBorrar);
                        System.out.println("Cliente eliminado correctamente.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }

                case 3 -> {
                    listarClientes();
                    if (clientes.isEmpty()) break;

                    System.out.print("Número del cliente que quieres modificar: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Por favor, introduce un número válido: ");
                    }
                    int posModificar = sc.nextInt();
                    sc.nextLine();

                    posModificar = posModificar - 1;
                    if (posModificar >= 0 && posModificar < clientes.size()) {
                        Cliente c = clientes.get(posModificar);

                        System.out.println("\nCliente seleccionado: " + c.getNombre());
                        System.out.println("¿Qué deseas modificar?");
                        System.out.println("1. Nombre");
                        System.out.println("2. DNI");
                        System.out.println("3. Teléfono");
                        System.out.println("4. Email");
                        System.out.print("Elige una opción: ");

                        while (!sc.hasNextInt()) {
                            sc.nextLine();
                            System.out.print("Por favor, introduce un número válido: ");
                        }
                        int opc2 = sc.nextInt();
                        sc.nextLine();

                        switch (opc2) {
                            case 1 -> {
                                System.out.print("Nuevo nombre: ");
                                c.setNombre(sc.nextLine());
                                System.out.println("Nombre actualizado correctamente.");
                            }
                            case 2 -> {
                                System.out.print("Nuevo DNI: ");
                                c.setDni(sc.nextLine());
                                System.out.println("DNI actualizado correctamente.");
                            }
                            case 3 -> {
                                System.out.print("Nuevo teléfono: ");
                                c.setTelefono(sc.nextLine());
                                System.out.println("Teléfono actualizado correctamente.");
                            }
                            case 4 -> {
                                System.out.print("Nuevo email: ");
                                c.setEmail(sc.nextLine());
                                System.out.println("Email actualizado correctamente.");
                            }
                            default -> System.out.println("Opción no válida.");
                        }
                    } else {
                        System.out.println("Número inválido.");
                    }
                }

                case 4 -> listarClientes();

                case 5 -> System.out.println("Volviendo al menú principal...");

                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opc != 5);
    }

    // LISTADO DE CLIENTES
    static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        System.out.println("\n--- LISTADO DE CLIENTES ---");
        for (int i = 0; i < clientes.size(); i++) {
            Cliente c = clientes.get(i);
            System.out.println((i + 1) + ". Nombre: " + c.getNombre());
            System.out.println("   DNI: " + c.getDni());
            System.out.println("   Teléfono: " + c.getTelefono());
            System.out.println("   Email: " + c.getEmail());
            System.out.println("-------------------------------");
        }
    }
}
