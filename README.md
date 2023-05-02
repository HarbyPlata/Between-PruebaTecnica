# ProductPriceInfoInquiry

Este servicio recibe como dato de entrada el ID de la cadena de tiendas, el ID del producto y una fecha específica. A partir de estos datos, el servicio realiza una consulta en la base de datos para obtener el precio del producto correspondiente en esa fecha y para esa cadena en particular. La respuesta es un objeto JSON que contiene la información del precio, ID del producto, ID de la cadena, tarifa a aplicar, fecha de aplicación junto con un código y descripción de estado que indica si la transacción fue exitosa o si se produjo un error.

## Requerimientos

- Java 17 o superior
- Maven 3.6.6

## Instalación

1. Clonar el repositorio
2. Ejecutar el comando `mvn clean install` en la carpeta del proyecto
4. Ejecutar el comando `mvn spring-boot:run` en la carpeta del proyecto
3. Acceder a la API en `http://localhost:8080`

## Endpoints

### `/v1/ProductPriceInfoInquiry`

- `GET /getProductPrice`: Consulta precios de productos

## Autor

Harby Arturo Plata Serrano
