# 🏗️ Sistema de Gestión de Inspecciones Técnicas de Inmuebles

Este proyecto es una API REST desarrollada con **Spring Boot** diseñada para digitalizar y gestionar el proceso de inspección de edificios, desde el registro de propietarios hasta la generación de informes técnicos de desperfectos.

## 📝 1. Descripción del Proyecto
La aplicación permite a una empresa de arquitectura o inspección técnica llevar un control exhaustivo de su flujo de trabajo. El sistema centraliza la información de los clientes, sus propiedades, el personal técnico (inspectores) y los resultados legales de cada visita (reportes).

## 🏢 2. Problema de Negocio
Las empresas de gestión de inmuebles suelen enfrentarse a la desorganización de datos cuando las inspecciones se gestionan en papel o archivos aislados. Los problemas principales que resuelve esta API son:
* **Trazabilidad:** Saber exactamente qué inspector revisó qué inmueble y en qué fecha.
* **Integridad:** Asegurar que los desperfectos detectados queden vinculados legalmente a un informe oficial.
* **Consistencia:** Evitar duplicidad de datos (como DNI de clientes o números de colegiado) y asegurar que no existan inspecciones sin inmuebles asignados.

---

## 🚀 3. Instrucciones de Ejecución

### Requisitos Previos
* **Java 17** o superior.
* **MySQL** (vía XAMPP o Docker).
* **Maven** (incluido en el wrapper del proyecto).

### Configuración
1. Clona el proyecto o descarga el código.
2. Abre XAMPP y asegúrate de que MySQL esté corriendo en el puerto `3306` (o `3307` según tu configuración).
3. Crea una base de datos llamada: `gestion_inmuebles`.
4. En el proyecto hay un archivo .sql por si necesitas empezar con datos, puedes importar el archivo en MYSQL y se te rellenará la bbdd
5. Configura tu `application.properties`:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/gestion_inmuebles
   spring.datasource.username=root
   spring.datasource.password=
   spring.jpa.hibernate.ddl-auto=update
