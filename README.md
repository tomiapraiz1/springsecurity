## JWT

https://jwt.io/introduction

Es un estandar abierto que permite transmitir informacion entre 2 partes.

## Funcionamiento

1. Cliente envia una peticion a un servidor (/api/login)
2. Servidor valida username y password:
   - si no son validos devuelve 401 unauthorized
   - sino genera un token JWT (usando una secret key)
3. Servidor devuelve el token JWT generado
4. Cliente envia peticiones a los endpoints REST del servidor utilizando el token JWT en las cabeceras
5. Servidor valida el token JWT en cada peticion, si es correcto permite acceso a los datos

Ventajas:
* El token se almacena en el cliente (consume menos recursos del servidor)
* 