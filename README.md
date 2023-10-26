# subastaRMI

# Instrucciones para Compilar y Ejecutar el Proyecto

A continuación, se detallan los pasos para compilar y ejecutar este proyecto de subasta en Java.

Para compilar todos los archivos .java, ejecuta el siguiente comando en la terminal en el directorio raíz del proyecto:

```sh
javac *.java
```
Levantar registro de nombres
```sh
rmiregistry
```
Compilar servidor
```sh
java -Djava.security.policy=srmi.policy SubastaServidor
```

Compilar cliente
```sh
java -Djava.security.policy=srmi.policy SubastaCliente
```

