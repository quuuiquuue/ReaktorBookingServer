# Reaktor Booking Server

Reaktor Booking Server es una aplicación desarrollada en Spring Boot que gestiona la reserva y cancelación de recursos y horarios para una institución educativa. Este proyecto incluye funcionalidades como la obtención de tramos horarios, la cancelación de recursos y el manejo de errores mediante excepciones personalizadas.

## Tecnologías utilizadas

- **Java 21**
- **Spring Boot** (Web, Data JPA, Validation)
- **Lombok** (para reducir código boilerplate)
- **Maven** (gestor de dependencias)
- **SLF4J** (para logging)
- **Git** y **GitHub** (control de versiones)

## Características principales

### Manejo de errores

El proyecto utiliza una clase personalizada llamada `BookingServerException` para gestionar errores. Cada excepción incluye un código de error, un mensaje descriptivo y detalles adicionales opcionales.

### Logs

El sistema registra eventos clave mediante `SLF4J` y `log.info`, incluyendo:
- Inicio de las operaciones.
- Resultados exitosos o fallos en la ejecución.
- Advertencias si no se encuentran recursos o tramos horarios.

## Instalación y configuración

1. **Clonar el repositorio**:
   ```bash
   git clone https://github.com/quuuiquuue/reaktor_booking_server.git
   ```

2. **Importar el proyecto**:
   - Usa tu IDE favorito (IntelliJ IDEA, Eclipse, etc.) y asegúrate de que está configurado con Java 17.

3. **Instalar dependencias**:
   - Ejecuta el siguiente comando en la terminal del proyecto:
     ```bash
     mvn clean install
     ```

4. **Ejecutar la aplicación**:
   - Usa el comando:
     ```bash
     mvn spring-boot:run
     ```
   - La aplicación estará disponible en: `http://localhost:8080`

## Estructura del proyecto

```
reaktor_booking_server
├── src
│   ├── main
│   │   ├── java
│   │   │   ├── es.iesjandula.reaktor_booking_server
│   │   │   │   ├── models       # Entidades JPA
│   │   │   │   ├── repositories # Repositorios JPA
│   │   │   │   ├── rest         # Controladores REST
│   │   │   │   └── utils        # Excepciones y clases auxiliares
│   │   └── resources
│   │       ├── application.properties # Configuración de la aplicación
│   │       └── data.sql               # Datos iniciales
├── pom.xml # Archivo Maven
└── README.md # Documentación del proyecto
```

## Contribuir

Si deseas contribuir a este proyecto:

1. Haz un fork del repositorio.
2. Crea una rama para tu funcionalidad o corrección:
   ```bash
   git checkout -b feature/nueva-funcionalidad
   ```
3. Realiza tus cambios y haz un commit:
   ```bash
   git commit -m "Agregada nueva funcionalidad"
   ```
4. Envía tus cambios:
   ```bash
   git push origin feature/nueva-funcionalidad
   ```
5. Abre un Pull Request.

## Autores

Este proyecto fue desarrollado por **[Miguel Rios, Enrique Contreras, Enrique Perez]** bajo la supervision de nuestro profesor **[Paco Benitez]**. 


