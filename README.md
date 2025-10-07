# Sistema de Gestión de Ventas de Sombreros

Sistema de gestión para una tienda de sombreros que permite administrar clientes, inventario y ventas.

## Estructura del Proyecto

```
EC_EDD/
├── src/
│   ├── main/java/
│   │   ├── Main.java           # Clase principal con menús interactivos
│   │   └── models/
│   │       ├── Cliente.java    # Modelo de cliente
│   │       ├── Sombrero.java   # Modelo de sombrero
│   │       └── Venta.java      # Modelo de venta
│   └── test/java/models/
│       ├── ClienteTest.java    # Tests para Cliente
│       ├── SombreroTest.java   # Tests para Sombrero
│       └── VentaTest.java      # Tests para Venta
├── pom.xml                     # Configuración Maven
└── README.md
```

## Funcionalidades

- **Gestión de clientes**: Añadir, eliminar, modificar y listar clientes
- **Gestión de sombreros**: Administrar inventario de sombreros con tipos, colores y precios
- **Gestión de ventas**: Realizar ventas asociando clientes con sombreros
- **Reportes**: Visualizar historial de ventas con totales

## Tecnologías

- **Java 11**: Lenguaje de programación
- **Maven**: Gestión de dependencias y build
- **JUnit 5**: Framework de testing

## Autor

MacarenaSG - 2025

