
import models.Cliente;
import models.Sombrero;
import models.Venta;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Clase principal del sistema de gestión de ventas de sombreros.
 * Proporciona una interfaz de consola para gestionar clientes, sombreros y ventas.
 *
 * @author MacarenaSG
 * @version 1.0
 * @since 2025
 */
public class Main {

    /** Lista que almacena todos los clientes registrados en el sistema */
    static ArrayList<Cliente> clientes = new ArrayList<>();

    /** Lista que almacena todos los sombreros disponibles en el inventario */
    static ArrayList<Sombrero> sombreros = new ArrayList<>();

    /** Lista que almacena todas las ventas realizadas */
    static ArrayList<Venta> ventas = new ArrayList<>();

    /**
     * Método principal que inicia la aplicación y muestra el menú principal.
     * Permite al usuario navegar entre las diferentes opciones de gestión:
     * clientes, sombreros, ventas y visualización de ventas.
     *
     * @param args Argumentos de línea de comandos (no utilizados)
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de clientes");
            System.out.println("2. Gestión de sombreros");
            System.out.println("3. Realizar venta");
            System.out.println("4. Mostrar ventas");
            System.out.println("5. Mostrar importe total de ventas por clientes");
            System.out.println("6. Comentarios para los profes");
            System.out.println("7. Salir");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Por favor, escribe un número válido: ");
            }

            opcion = sc.nextInt();
            sc.nextLine();

            switch (opcion) {
                case 1 -> gestionarClientes(sc);
                case 2 -> gestionarSombreros(sc);
                case 3 -> realizarVenta(sc);
                case 4 -> mostrarVentas();
                case 5 -> mostrarTotalPorCliente(sc);
                case 6 -> mostrarComentarios(sc);
                case 7 -> System.out.println("Gracias por su visita... ¡Hasta pronto!");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 7);
    }

    /**
     * Gestiona todas las operaciones relacionadas con clientes.
     * Proporciona un submenú con opciones para añadir, eliminar, modificar
     * y listar clientes.
     *
     * @param sc Scanner para leer la entrada del usuario
     */
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

    /**
     * Muestra un listado completo de todos los clientes registrados.
     * Si no hay clientes registrados, muestra un mensaje informativo.
     * Cada cliente se muestra con un número de orden y todos sus datos.
     */
    static void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        // Ordenar por nombre
        clientes.sort(Comparator.comparing(Cliente::getNombre));

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

    /**
     * Gestiona todas las operaciones relacionadas con sombreros.
     * Proporciona un submenú con opciones para añadir, eliminar, modificar
     * y listar sombreros del inventario.
     *
     * @param sc Scanner para leer la entrada del usuario
     */
    static void gestionarSombreros(Scanner sc) {

        int opc;

        do {
            System.out.println("\n-- GESTIÓN DE SOMBREROS --");
            System.out.println("1. Añadir sombrero");
            System.out.println("2. Eliminar sombrero");
            System.out.println("3. Modificar datos de un sombrero");
            System.out.println("4. Mostrar listado de sombreros");
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
                    System.out.print("Tipo de sombrero: ");
                    String tipo = sc.nextLine();
                    System.out.print("Color: ");
                    String color = sc.nextLine();

                    System.out.print("Precio: ");
                    while (!sc.hasNextDouble()) {
                        sc.nextLine();
                        System.out.print("Por favor, introduce un precio válido (número): ");
                    }
                    double precio = sc.nextDouble();
                    sc.nextLine();

                    System.out.print("Stock (cantidad disponible): ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Por favor, introduce un número entero válido: ");
                    }
                    int stock = sc.nextInt();
                    sc.nextLine();

                    sombreros.add(new Sombrero(tipo, color, precio, stock));
                    System.out.println("Sombrero añadido correctamente.");
                }

                case 2 -> {
                    listarSombreros();
                    if (sombreros.isEmpty()) break;

                    System.out.print("Número del sombrero que se desea dar de baja: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Por favor, introduce un número válido: ");
                    }
                    int posBorrar = sc.nextInt();
                    sc.nextLine();

                    posBorrar = posBorrar - 1;
                    if (posBorrar >= 0 && posBorrar < sombreros.size()) {
                        sombreros.remove(posBorrar);
                        System.out.println("Sombrero eliminado correctamente.");
                    } else {
                        System.out.println("Número inválido.");
                    }
                }

                case 3 -> {
                    listarSombreros();
                    if (sombreros.isEmpty()) break;

                    System.out.print("Número del sombrero que quieres modificar: ");
                    while (!sc.hasNextInt()) {
                        sc.nextLine();
                        System.out.print("Por favor, introduce un número válido: ");
                    }
                    int posModificar = sc.nextInt();
                    sc.nextLine();

                    posModificar = posModificar - 1;
                    if (posModificar >= 0 && posModificar < sombreros.size()) {
                        Sombrero s = sombreros.get(posModificar);

                        System.out.println("\nSombrero seleccionado: " + s.getTipo());
                        System.out.println("¿Qué deseas modificar?");
                        System.out.println("1. Tipo");
                        System.out.println("2. Color");
                        System.out.println("3. Precio");
                        System.out.print("Elige una opción: ");

                        while (!sc.hasNextInt()) {
                            sc.nextLine();
                            System.out.print("Por favor, introduce un número válido: ");
                        }
                        int opc2 = sc.nextInt();
                        sc.nextLine();

                        switch (opc2) {
                            case 1 -> {
                                System.out.print("Nuevo tipo: ");
                                s.setTipo(sc.nextLine());
                                System.out.println("Tipo actualizado correctamente.");
                            }
                            case 2 -> {
                                System.out.print("Nuevo color: ");
                                s.setColor(sc.nextLine());
                                System.out.println("Color actualizado correctamente.");
                            }
                            case 3 -> {
                                System.out.print("Nuevo precio: ");
                                while (!sc.hasNextDouble()) {
                                    sc.nextLine();
                                    System.out.print("Por favor, introduce un precio válido (número): ");
                                }
                                double nuevoPrecio = sc.nextDouble();
                                sc.nextLine();
                                s.setPrecio(nuevoPrecio);
                                System.out.println("Precio actualizado correctamente.");
                            }
                            default -> System.out.println("Opción no válida.");
                        }
                    } else {
                        System.out.println("Número inválido.");
                    }
                }

                case 4 -> listarSombreros();

                case 5 -> System.out.println("Volviendo al menú principal...");

                default -> System.out.println("Opción no válida. Inténtalo de nuevo.");
            }

        } while (opc != 5);
    }

    /**
     * Muestra un listado completo de todos los sombreros en el inventario.
     * Si no hay sombreros registrados, muestra un mensaje informativo.
     * Cada sombrero se muestra con un número de orden y todos sus atributos.
     */
    static void listarSombreros() {
        if (sombreros.isEmpty()) {
            System.out.println("No hay sombreros registrados.");
            return;
        }

        System.out.println("\n--- LISTADO DE SOMBREROS ---");
        for (int i = 0; i < sombreros.size(); i++) {
            Sombrero s = sombreros.get(i);
            System.out.println((i + 1) + ". Tipo: " + s.getTipo());
            System.out.println("   Color: " + s.getColor());
            System.out.println("   Precio: " + s.getPrecio());
            System.out.println("   Stock disponible: " + s.getStock());
            System.out.println("-------------------------------");
        }
    }

    /**
     * Procesa una nueva venta en el sistema.
     * Permite seleccionar un cliente existente y añadir uno o más sombreros
     * a la venta. Valida que existan clientes y sombreros antes de proceder.
     * La venta se registra con la fecha actual y se añade a la lista de ventas.
     *
     * @param sc Scanner para leer la entrada del usuario
     */
    static void realizarVenta(Scanner sc) {
        // Comprobaciones previas
        if (clientes.isEmpty()) {
            System.out.println("Primero debes registrar clientes antes de realizar una venta.");
            return;
        }
        if (sombreros.isEmpty()) {
            System.out.println("Primero debes registrar sombreros antes de realizar una venta.");
            return;
        }

        // Seleccionar cliente
        System.out.println("\n=== SELECCIONAR CLIENTE ===");
        listarClientes();
        System.out.print("Introduce el número del cliente: ");
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Por favor, introduce un número válido: ");
        }
        int numeroCliente = sc.nextInt();
        sc.nextLine();

        if (numeroCliente <= 0 || numeroCliente > clientes.size()) {
            System.out.println("Número de cliente inválido.");
            return;
        }
        Cliente clienteSeleccionado = clientes.get(numeroCliente - 1);

        // Crear venta
        Venta nuevaVenta = new Venta(clienteSeleccionado);

        // Añadir sombreros a la venta
        boolean seguirAnadiendo = true;
        while (seguirAnadiendo) {
            System.out.println("\n=== SELECCIONAR SOMBRERO PARA AÑADIR ===");
            listarSombreros();
            System.out.print("Introduce el número del sombrero que deseas añadir: ");
            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Por favor, introduce un número válido: ");
            }
            int numeroSombrero = sc.nextInt();
            sc.nextLine();

            if (numeroSombrero > 0 && numeroSombrero <= sombreros.size()) {
                Sombrero sombreroSeleccionado = sombreros.get(numeroSombrero - 1);

                if (sombreroSeleccionado.getStock() > 0) {
                    nuevaVenta.addSombrero(sombreroSeleccionado);
                    sombreroSeleccionado.setStock(sombreroSeleccionado.getStock() - 1); // Disminuir stock
                    System.out.println("Sombrero añadido correctamente a la venta.");
                } else {
                    System.out.println("Este sombrero está agotado. No se puede añadir.");
                }

            } else {
                System.out.println("Número de sombrero inválido.");
            }


            System.out.print("¿Deseas añadir otro sombrero? (s/n): ");
            String respuesta = sc.nextLine();
            seguirAnadiendo = respuesta.equalsIgnoreCase("s");
        }

        // Guardar venta
        ventas.add(nuevaVenta);
        System.out.println("Venta registrada correctamente.");
    }

    /**
     * Muestra un informe detallado de todas las ventas realizadas.
     * Para cada venta muestra: número de venta, cliente, fecha,
     * listado de sombreros comprados y el importe total.
     * Si no hay ventas registradas, muestra un mensaje informativo.
     */
    static void mostrarVentas() {
        System.out.println("\n=== LISTADO DE VENTAS REGISTRADAS ===");

        if (ventas.isEmpty()) {
            System.out.println("No hay ventas registradas actualmente.");
            return;
        }

        for (int i = 0; i < ventas.size(); i++) {
            Venta v = ventas.get(i);

            System.out.println("\nVenta Nº " + (i + 1));
            System.out.println("Cliente: " + v.getCliente().getNombre());
            System.out.println("Fecha: " + v.getFecha());
            System.out.println("Sombreros comprados:");
            for (Sombrero s : v.getLineasDeVenta()) {
                System.out.println("  - " + s.getTipo() + " (" + s.getColor() + "), " + s.getPrecio() + "€");
            }
            System.out.println("Importe total: " + v.calcularTotal() + "€");
            System.out.println("-------------------------------");
        }
    }

    /**
     * Muestra cuánto dinero ha gastado un cliente en total.
     * El usuario elige un cliente y el sistema suma todas las ventas que ha hecho ese cliente.
     *
     */
    static void mostrarTotalPorCliente(Scanner sc) {
        // Comprobamos si hay clientes registrados
        if (clientes.isEmpty()) {
            System.out.println("No hay clientes registrados.");
            return;
        }

        // Mostramos la lista de clientes
        System.out.println("\n=== TOTAL DE VENTAS POR CLIENTE ===");
        listarClientes();  // Usamos el método creado para mostrar los clientes

        // Pedimos al usuario que elija un cliente por número
        System.out.print("Introduce el número del cliente: ");
        while (!sc.hasNextInt()) {
            sc.nextLine();
            System.out.print("Por favor, introduce un número válido: ");
        }
        int numeroCliente = sc.nextInt();
        sc.nextLine();

        // Comprobamos si el número introducido es válido
        if (numeroCliente <= 0 || numeroCliente > clientes.size()) {
            System.out.println("Número de cliente inválido.");
            return;
        }

        // Obtenemos el cliente elegido
        Cliente cliente = clientes.get(numeroCliente - 1);
        double total = 0;

        // Recorremos todas las ventas y sumamos las que pertenecen a ese cliente
        for (Venta venta : ventas) {
            if (venta.getCliente().equals(cliente)) {
                total += venta.calcularTotal();
            }
        }

        // Mostramos el resultado final
        System.out.println("Cliente: " + cliente.getNombre());
        System.out.println("Total gastado en compras: " + total + "€");
    }


    /**
     * Muestra un submenú de comentarios para los profesores.
     *
     * @param sc Scanner para leer la entrada del usuario
     */
    static void mostrarComentarios(Scanner sc) {
        int opcion;

        do {
            System.out.println("\n--- COMENTARIOS PARA LOS PROFES ---");
            System.out.println("1. José");
            System.out.println("2. Jordi");
            System.out.println("3. Volver al menú principal");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Por favor, introduce un número válido: ");
            }

            opcion = sc.nextInt();
            sc.nextLine();  // limpiar entrada

            switch (opcion) {
                case 1 ->comentariosJose(sc);
                case 2 ->comentariosJordi(sc);
                case 3 -> System.out.println("Volviendo al menú principal...");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 3);
    }

    /**
     * Submenú de comentarios para el profesor José.
     * Permite elegir entre comentario sobre realizar ventas o mostrar el total por cliente.
     *
     * @param sc Scanner para leer la entrada del usuario
     */
    static void comentariosJose(Scanner sc) {
        int opcion;

        do {
            System.out.println("\n--- COMENTARIOS PARA JOSÉ ---");
            System.out.println("1. Funcionalidad de realizar venta");
            System.out.println("2. Funcionalidad de mostrar importe total de ventas por cliente");
            System.out.println("3. Volver al menú anterior");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Por favor, introduce un número válido: ");
            }

            opcion = sc.nextInt();
            sc.nextLine();  // limpiar entrada

            switch (opcion) {
                case 1 -> {
                    System.out.println("\nComentario sobre la funcionalidad de realizar una venta:\n");
                    System.out.println("Esta parte ha sido una de las más complicadas de todo el proyecto.\n" +
                            "La funcionalidad de realizar una venta incluye muchas condiciones y pasos encadenados: seleccionar cliente, mostrar productos disponibles, comprobar stock, añadir productos uno a uno...\n" +
                            "Ha sido muy difícil conseguir que todo funcionara correctamente sin errores, sobre todo por los bucles, las validaciones y las entradas del usuario.\n" +
                            "Pero al final, después de muchos intentos y pruebas, lo conseguí hacer funcionar y ha sido una de las funcionalidades más completas que he aprendido.");
                }

                case 2 -> {
                    System.out.println("\nComentario sobre mostrar el importe total de ventas por cliente:\n");
                    System.out.println("Esta parte ha sido también importante porque me obligó a entender cómo recorrer listas, filtrar por cliente y sumar los totales.\n" +
                            "Aunque parece sencilla, tuve que prestar mucha atención para comparar correctamente objetos y evitar errores de lógica.\n" +
                            "Me ha ayudado a mejorar en el uso de estructuras como bucles y condiciones, y a comprender mejor cómo sacar información útil del sistema.");
                }

                case 3 -> System.out.println("Volviendo al menú de comentarios...");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 3);
    }


    /**
     * Submenú de comentarios para el profesor Jordi.
     * Permite elegir entre comentario sobre .gitignore o README.md
     *
     * @param sc Scanner para leer la entrada del usuario
     */
    static void comentariosJordi(Scanner sc) {
        int opcion;

        do {
            System.out.println("\n--- COMENTARIOS PARA JORDI ---");
            System.out.println("1. Aprendizaje con .gitignore");
            System.out.println("2. Aprendizaje con README.md");
            System.out.println("3. Volver al menú anterior");
            System.out.print("Elige una opción: ");

            while (!sc.hasNextInt()) {
                sc.nextLine();
                System.out.print("Por favor, introduce un número válido: ");
            }

            opcion = sc.nextInt();
            sc.nextLine();  // limpiar entrada

            switch (opcion) {
                case 1 -> {
                    System.out.println("\nComentario sobre .gitignore:\n");
                    System.out.println("Me ha costado bastante trabajo configurar correctamente el archivo .gitignore en este proyecto.\n" +
                            "Al principio no sabía exactamente qué archivos debía excluir del control de versiones, y tuve que investigar bastante para entender cómo funcionaba.\n" +
                            "Finalmente conseguí reconocer qué archivos no eran necesarios subir a Git.\n" +
                            "Archivos como los .class, carpetas como /out/ y archivos generados por el IDE.\n" +
                            "Esto ha sido lo que más tiempo me ha llevado entender y realizar, habiendo sido un aprendizaje importante y ahora entiendo mejor por qué es tan útil tener un .gitignore bien hecho desde el principio.\n");
                }

                case 2 -> {
                    System.out.println("\nComentario sobre README.md:\n");
                    System.out.println("Me ha llevado bastante tiempo y dedicación crear un README.md claro, ordenado y útil para el proyecto.\n" +
                            "Al principio no sabía muy bien qué información debía incluir ni cómo estructurarla correctamente.\n" +
                            "Tuve que revisar ejemplos y buenas prácticas para entender qué es lo más importante que debe ver alguien que abre el repositorio por primera vez.\n" +
                            "Finalmente conseguí hacer la estructura del proyecto guiándome de otros proyecto de GitHub.\n" +
                            "Esta ha sido una parte importante del proyecto, ya que permite a otras personas comprender de forma clara y estructurada qué van a encontrar dentro del código.\n");
                }

                case 3 -> System.out.println("Volviendo al menú de comentarios...");
                default -> System.out.println("Opción no válida. Intenta de nuevo.");
            }

        } while (opcion != 3);
    }

}