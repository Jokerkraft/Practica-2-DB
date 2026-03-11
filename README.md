# TAP: Practica 2 - Conexion a BD

## 1. Objetivo del proyecto

Crear una aplicacion en Java que conecte, consulte, actualice y elimine registros de una base de datos en MySQL.

## 2. Division del trabajo (2 integrantes por equipo)

### Integrante 1

- Implementacion de las clases en Java.
- Optimizacion del codigo.
- Uso de programacion orientada a objetos.

### Integrante 2

- Configuracion y conexion con MySQL (JDBC).
- Creacion de la base de datos y tablas.
- Implementacion de un CRUD para almacenar y recuperar informacion.

### Integrantes del equipo

- c23030789 Cabrera Chavero Oskar Luis
- c23030448 Abonce García Rafael

## 3. Estructura del proyecto

- src/ -> Codigo fuente
- Main.java -> Punto de entrada
- Algoritmos/ -> Implementaciones POO (Models, Controllers, Views)
- Database/ -> Conexion y gestion de MySQL (DAO, utilidades y JDBC)
- README.md -> Instrucciones del proyecto

## 4. Integracion del codigo y debugging

- Integrar el codigo de ambos participantes en una sola version funcional.
- Realizar pruebas de conexion a MySQL y de operaciones CRUD.
- Ejecutar debugging de errores de compilacion, importaciones y conexion.

Comando de compilacion:

```bash
mvn -q -DskipTests compile
```

## 5. Entregables

- Crear una carpeta en el repositorio TAP dentro del numero de control de uno de los integrantes del equipo.
- Realizar un reporte de practica que muestre:
- Evidencia del funcionamiento (capturas o resultados de ejecucion).
- Investigacion realizada.
- Instalacion y configuracion del entorno.

## Requisitos tecnicos

- Java 17
- Maven 3.8
- MySQL 8

## Configuracion de entorno

Configurar variables por entorno o archivo .env en la raiz:

- DB_URL (ejemplo: jdbc:mysql://localhost:3306/tap)
- DB_USER
- DB_PASSWORD

Base de datos:

```sql
CREATE DATABASE IF NOT EXISTS practica2_db;
```

Las tablas de usuarios y estudiantes se crean desde el codigo al iniciar la aplicacion.
