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
## 🛠️ 4. Documentación de la API (Endpoints según Postman)

### Clientes
| Petición | Método | Endpoint | Body (JSON) |
| :--- | :--- | :--- | :--- |
| Crear Cliente | `POST` | `/api/clientes` | `{"nombre": "Pablo Arnau", "dni": "12332165X", "email": "pablo@gmail.com"}` |
| Listar Clientes | `GET` | `/api/clientes` | N/A |
| Modificar Cliente | `PUT` | `/api/clientes/{id}` | `{"nombre":"PabloArnau","dni":"12332165X","email":"pablo_nuevo_email@gmail.com"}` |
| Eliminar Cliente | `DELETE` | `/api/clientes/{id}` | N/A |

### Inspectores
| Petición | Método | Endpoint | Body (JSON) |
| :--- | :--- | :--- | :--- |
| Crear Inspector | `POST` | `/api/inspectores` | `{"nombre": "Julio Perito", "especialidad": "Estructuras", "numeroColegiado": 12}` |
| Listar Inspectores | `GET` | `/api/inspectores` | N/A |
| Modificar Inspector | `PUT` | `/api/inspectores/{id}` | `{"nombre": "Julio Perito2", "especialidad": "Estructuras2", "numeroColegiado": 12}` |
| Eliminar Inspector | `DELETE` | `/api/inspectores/{id}` | N/A |

### Inmuebles
| Petición | Método | Endpoint | Body (JSON) |
| :--- | :--- | :--- | :--- |
| Crear Inmueble | `POST` | `/api/inmuebles/cliente/{id_cliente}` | `{"direccion": "Av. Principal 10", "ciudad": "Madrid"}` |

### Desperfectos
| Petición | Método | Endpoint | Body (JSON) |
| :--- | :--- | :--- | :--- |
| Crear Desperfecto | `POST` | `/api/desperfectos/inmueble/{id_inmueble}` | `{"descripcion": "Grieta fachada", "gravedad": "Alta"}` |
| Modificar Desperfecto | `PUT` | `/api/desperfectos/{id}` | `{"descripcion": "Grieta fachada desminuye", "gravedad": "baja", "inmueble": { "id": 2}}` |
| Listar Desperfectos | `GET` | `/api/desperfectos` | N/A |

### Inspecciones
| Petición | Método | Endpoint | Body (JSON) |
| :--- | :--- | :--- | :--- |
| Crear Inspección | `POST` | `/api/inspecciones` | `{"fecha": "2026-03-15T11:30:00", "estado": "PENDIENTE", "inmueble": {"id": 4}}` |
| Asignar Inspector | `PUT` | `/api/inspecciones/{id_inspeccion}/asignar-inspector/{id_inspector}` | N/A |

### Reportes
| Petición | Método | Endpoint | Body (JSON) |
| :--- | :--- | :--- | :--- |
| Crear Reporte | `POST` | `/api/reportes` | `{"observacionesGenerales": "La inspección revela daños...", "fechaCreacion": "2026-02-22", "inspeccion": {"id": 2}}` |
| Modificar Reporte | `PUT` | `/api/reportes/{id}` | `{"observacionesGenerales": "ACTUALIZACIÓN...", "fechaCreacion": "2026-02-22", "inspeccion": {"id": 2}}` |
| Eliminar Reporte | `DELETE` | `/api/reportes/{id}` | N/A |
| Asignar Desperfecto | `PUT` | `/api/reportes/{id_reporte}/desperfecto/{id_desper}` | N/A |
| Ver Reporte Detallado | `GET` | `/api/reportes/{id}` | N/A |
