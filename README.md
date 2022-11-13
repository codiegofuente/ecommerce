# Ecommerce Application

Ecommerce Application para un proceso de selección.

### Deployment
Ha sido desarrollado usando Java 8 y Springboot 2.7.5.
Para desplegarlo es necesario situarse en el directorio raíz del proyecto y ejecutar los siguientes comandos:
~~~ bash
mvn clean install
mvn spring-boot:run

~~~

### Test
Para ejecutar los test realziados es necesario situarse en el directorio raíz del proyecto y ejecutar los siguientes comandos:
~~~ bash
mvn test
~~~

### Run
Si desea realizarse una petición al servicio, basta con hacer una petición HTTP al siguiente endpoint ... Esta petición
puede realizarse con diversas herramientas como POSTMAN, CURL o mismamente desde un navegador WEB
~~~ bash
Navergador WEB
http://localhost:8081/ecommerce/product/info?date=2020-06-14T10:00:00-00:00&productId=35455&brandId=1
CURL
curl -ik -X GET "http://localhost:8081/ecommerce/product/info?date=2020-06-14T10:00:00-00:00&productId=35455&brandId=1"
~~~

## Output
~~~ bash
HTTP/1.1 200
Content-Type: text/plain;charset=UTF-8
Content-Length: 211
Date: Sun, 13 Nov 2022 17:24:02 GMT

Id de producto: 35455, id de cadena: 1, tarifa a aplicar: 1, fecha de inicio de tarifa: 2020-06-14T00:00+02:00[Europe/Paris], fecha de fin de tarifa: 2020-12-31T23:59:59+01:00[Europe/Paris] precio final: 35.5EUR
~~~
