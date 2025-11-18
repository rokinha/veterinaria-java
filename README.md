# veterinaria-java
Sistema de gestión veterinaria con Java Swing y MySQL

Autor: Matias Posada Verreni
Sistema de escritorio desarrollado en Java Swing, conectado a MySQL, para la gestión de:
Dueños
Mascotas
Historial Clínico
Búsqueda Global

Incluye ventanas independientes para cada módulo y un menú principal.

El objetivo es permitir a una veterinaria registrar y consultar fácilmente la información de sus pacientes.

La base contiene 3 tablas:
dueno
mascota
historial

Relacionadas así:
1 dueño → muchas mascotas
1 mascota → muchos historiales

Requisitos:
Java JDK 21 o superior
NetBeans 17+
MySQL 8.0
Conector JDBC (mysql-connector-j-9.x.x.jar)


Instalación
1. Importar Base de Datos
En phpMyAdmin:
Crear base veterinaria_db
Importar archivo veterinaria_db.sql

3. Abrir Proyecto en NetBeans
File → Open Project → seleccionar carpeta veterinaria-java

4. Configurar conexión
En clase bd.Conexion:
connection = DriverManager.getConnection(
    "jdbc:mysql://localhost:3306/veterinaria_db",
    "root",
    ""
);

Ejecución
Ejecutar la clase:
vista.Form_Menu
Desde esa ventana podrás abrir:
Gestión de Dueños
Gestión de Mascotas
Gestión de Historiales
Búsqueda Global

Instalacion usuarios.
Manual de Uso — Sistema Veterinaria
Ejecutar el veterinaria.jar
1. Abrir el programa
Ejecuta el archivo:
dist/veterinaria.jar
Asegúrate de tener el servidor MySQL activo.

2. Menú principal
Al abrir el programa verás una ventana con estas opciones:
Dueños
Mascotas
Historial Clínico
Búsqueda Global
Haz clic en cualquiera para abrir su ventana correspondiente.

3. Módulo de Dueños
Permite administrar los datos del dueño.
Agregar:
Ingresa rut, nombre, teléfono y dirección → clic en Agregar.
Buscar:
Escribe el ID del dueño → clic Buscar.
Actualizar:
Modifica los textos → clic Actualizar.
Eliminar:
Escribe el ID → clic Eliminar.
Listar:
Muestra todos los dueños en la tabla inferior.

4. Módulo de Mascotas
Permite administrar las mascotas de la veterinaria.
Agregar mascota
Buscar por ID
Actualizar datos
Eliminar mascota
Listar todas las mascotas
Cada mascota está asociada a un dueño mediante su id_dueno.

5. Módulo Historial Clínico

Aquí se registran las atenciones:
Ingresar fecha, motivo, diagnóstico, tratamiento.
Asociar la atención al ID de la mascota.
Puedes:
Agregar historial
Buscar historial por ID
Actualizar
Eliminar
Listar todos

6. Búsqueda Global

Permite buscar en una sola ventana:
Combobox donde eliges:
Dueño
Mascota
Historial
Luego ingresas un ID → clic Buscar.
La tabla inferior muestra los resultados.

7. Salir del programa
Desde el menú principal.

<img width="730" height="661" alt="image" src="https://github.com/user-attachments/assets/ca9cf5f2-ec00-47d0-9d25-ed42f356183f" />

<img width="1145" height="745" alt="image" src="https://github.com/user-attachments/assets/59c8d733-dada-425c-8772-7d0d4eed62a0" />

<img width="1104" height="853" alt="image" src="https://github.com/user-attachments/assets/ac44d79f-04e4-4f54-a32e-b07d4a95c4bf" />

<img width="1112" height="836" alt="image" src="https://github.com/user-attachments/assets/01bf9d44-0e61-479e-a0a6-de6f1560e77f" />

<img width="1130" height="779" alt="image" src="https://github.com/user-attachments/assets/2171b192-66d1-4885-901a-32f1e48fdbb8" />





