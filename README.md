# Convertidor de Tasa de Cambio de Moneda

Este programa en Java utiliza la API de "Exchange Rate API" para obtener y mostrar la tasa de cambio entre dos monedas especificadas por el usuario. Utiliza la biblioteca Jackson para manejar las respuestas en formato JSON y `HttpURLConnection` para realizar solicitudes HTTP al endpoint de la API.

## Características

- **Entrada de Usuario**: Permite al usuario ingresar la moneda base y la moneda objetivo para la conversión.
- **Salida Dinámica**: Muestra la tasa de cambio actualizada de la moneda base a la moneda objetivo basada en los datos más recientes obtenidos de la API.
- **Manejo de Errores**: Gestiona posibles errores como problemas de conexión HTTP y errores devueltos por la API.

## Uso

1. **Configuración**
   - Asegúrate de tener Java instalado en tu sistema.
   - Agrega la dependencia de la biblioteca Jackson (`jackson-databind`) al archivo `pom.xml` de tu proyecto si aún no está incluida:

     ```xml
     <dependency>
         <groupId>com.fasterxml.jackson.core</groupId>
         <artifactId>jackson-databind</artifactId>
         <version>2.13.1</version>
     </dependency>
     ```

2. **Ejecución**
   - Ejecuta el archivo `Main.java`.
   - Sigue las indicaciones para ingresar la moneda base (`DE:`) y la moneda objetivo (`A:`).
   - El programa obtendrá las tasas de cambio más recientes de la API y mostrará la tasa de conversión de la moneda base a la moneda objetivo.

## Ejemplo
Ingrese la moneda base
DE: USD
Ingrese la moneda objetivo
A: EUR
Tasa de cambio de USD a EUR:
1 USD = 0.85 EUR

## Notas

- Asegúrate de tener una conexión a internet estable para obtener datos de la API.
- Reemplaza `67af2377ae42c78a06ce9b20` con tu clave API obtenida de "Exchange Rate API" para el correcto funcionamiento.
- Monitorea la consola en busca de mensajes de error en caso de problemas durante el manejo de la solicitud a la API.

## Dependencias

- Java 8 o superior
- Biblioteca Jackson JSON (`jackson-databind`)

## Licencia

Este proyecto está bajo la Licencia MIT - consulta el archivo LICENSE para más detalles.
