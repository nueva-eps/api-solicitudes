# Configuración del Microservicio

Este proyecto es un microservicio desarrollado en **Java**. Se encarga de interactuar con la base de datos centralizada del sistema.

---

## 🚀 Paso 1: Restauración de la Base de Datos

El sistema requiere una base de datos PostgreSQL activa. El nombre preconfigurado para este proyecto es **`nuevaeps`**.

### Crear la Base de Datos (psql)
Conéctate a tu servidor de PostgreSQL y ejecuta:
```sql
CREATE DATABASE nuevaeps;
```

> ⚠️ **Nota Importante:**
> Si decides utilizar un nombre diferente a `nuevaeps`, debes editar el archivo de configuración de este repositorio (usualmente `src/main/resources/application.yml` o `application.properties`) y actualizar la URL de conexión de la base de datos (`datasource.url`).

### Importar la Estructura
Abre tu terminal en la carpeta donde guardaste tu script de base de datos (`estructura_bd.sql`) y ejecuta:

```bash
psql -U postgres -h localhost -p 5432 -d nuevaeps -f estructura_bd.sql
```

---

## 💻 Paso 2: Instalación y Ejecución Local

### Prerrequisitos
* **Java JDK** (versión compatible con el proyecto).
* **Maven** o **Gradle** instalado (o usar el wrapper incluido `./mvnw` / `./gradlew`).

### Ejecución del Servicio
Abre una terminal en la raíz de este repositorio y ejecuta el comando de arranque:

```bash
# Si utilizas Maven Wrapper:
./mvnw spring-boot:run

# Si utilizas Gradle Wrapper:
./gradlew bootRun
```

### 2. Servicio: api-solicitudes

Este microservicio se encarga del ciclo de vida de las peticiones de los usuarios, gestionando tanto el catálogo de medicamentos disponibles como la creación y paginación de órdenes de entrega.

#### ⚙️ Variables de Envorno y Configuración
* Dirígete a `api-solicitudes/src/main/resources/`.
* Abre el archivo `application.yml` (o `application.properties`).
* Al igual que en el servicio de autenticación, verifica que los parámetros de conexión coincidan con tu instancia local de PostgreSQL. Si estás utilizando un nombre de base de datos personalizado, no olvides actualizar la propiedad `url`:

```yaml
spring:
  datasource:
    url: jdbc:postgresql://localhost:5432/nuevaeps # <-- Cambiar si no usas 'nuevaeps'
    username: tu_usuario_postgres
    password: tu_contraseña_postgres
```

#### 🛠️ Endpoints Disponibles (API Reference)
Por defecto, este servicio corre en su propio puerto asignado (por ejemplo, `8082`). Expone dos controladores principales organizados de la siguiente manera:

##### Módulo de Medicamentos (`/medicamentos`)
* **`GET /medicamentos/list`**: Recupera el listado completo de medicamentos parametrizados en el sistema (tanto los que pertenecen al plan POS como los que no).
  * **Respuesta**: `200 OK` con un arreglo JSON de objetos `Medicamento`.

##### Módulo de Solicitudes (`/solicitudes`)
* **`POST /solicitudes/create`**: Registra una nueva orden o solicitud de medicamentos en la base de datos vinculando al usuario solicitante.
  * **Body (JSON)**: Recibe un objeto basado en `CreateSolicitudRequest` (incluye `idUsuario`, `idMedicamento`, `cantidad`, datos de contacto, etc.).
  * **Respuesta**: `201 Created` con el detalle de la `Solicitud` generada.
* **`GET /solicitudes/list`**: Obtiene el historial de solicitudes realizadas mediante un esquema de paginación integrado.
  * **Query Params (Opcionales)**: 
    * `page`: Número de página a consultar (por defecto `0`).
    * `size`: Cantidad de elementos por página (por defecto `5`).
  * **Respuesta**: `200 OK` retornando un objeto `PaginacionResponse<Solicitud>` ideal para el consumo del Frontend.

#### 🏃 Ejecución Local
Abre una terminal independiente en la raíz de la carpeta `api-solicitudes` y compila/ejecuta la aplicación utilizando el comando:

```bash
cd api-solicitudes
./mvnw spring-boot:run
```
