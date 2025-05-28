# Módulo de Gestión de Usuarios - Proyecto Jobify

Este módulo forma parte de las pruebas del sistema **Jobify**, una plataforma que conecta clientes con proveedores de servicios. La presente evidencia corresponde a la implementación del módulo de gestión de usuarios utilizando **Java**, **JDBC** y **MySQL**.

## Tecnologías utilizadas

- Lenguaje: Java 17+
- Base de datos: MySQL
- Conexión: JDBC
- IDE: VSCode
- Control de versiones: Git + GitHub
- Gestor de dependencias: Maven

## Seguridad

- Las credenciales se almacenan en un archivo `.env` (excluido del repositorio).
- Se utilizó la librería `dotenv` para proteger la conexión con la base de datos.
- La contraseña de usuario se almacena en formato encriptado (`SHA-256`).

## Funcionalidades implementadas

- Inserción de usuarios (CREATE)
- Listado de usuarios (READ)
- Actualización de datos (UPDATE)
- Eliminación de usuarios (DELETE)
- Búsqueda por ID
- Manejo de excepciones y validaciones básicas

## Cómo ejecutar el proyecto

### 1. Crear la base de datos

Ejecuta el archivo `database.sql` desde MySQL Workbench o terminal para crear la base `jobify_db` y la tabla `usuarios`.

### 2. Configura el archivo `.env`

Crea un archivo `.env` en la raíz con el siguiente contenido:
DB_URL=jdbc:mysql://localhost:3306/jobify_db
DB_USER=root
DB_PASSWORD=tu_contraseña

> Asegúrate de que `.env` esté excluido en el `.gitignore`

### 3. Compilar y ejecutar

En terminal:

```bash
mvn clean compile
mvn exec:java

```
