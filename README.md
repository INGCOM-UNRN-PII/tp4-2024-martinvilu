[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/7XLu0QRz)

# TP4-2024

Archivos con arreglos

# Ejercicios

## Funciones comunes y excepciones
Vamos a aplicar un pequeño cambio en la forma de estructurar el práctico.

1. En la clase `ar.unrn.Archivos`, enviar todas las funciones que interactuen con archivos.
2. En la clase `ar.unrn.Arreglos`, todo lo referido a arreglos (pueden usar lo implementado en el TP anterior como base.)
3. {_opcional_} En la clase `ar.unrn.Pide`, funciones para pedirle datos al usuario, como el ejercicio del TP anterior.

El objetivo de esta separación es mantener los respectivos `main` lo más simples posibles.

En la medida de lo posible, funciones implementadas deberán emitir `Exception` con tipo.
O justifiquen la razón para que sea de otra forma.

### Programas a desarrollar
Para evitar problemas y accidentes, usen solo rutas relativas a la ubicación del proyecto.
Para ello, **todas las llamadas** que involucren rutas deben comenzar con `"."`.

Las entradas y salidas de los programas a desarrollar deben ser simples, los tests son más importantes.

### ¿Cómo son los archivos?
La idea es trabajar con archivos de texto que contengan números enteros de tipo long, uno por línea.


#### [1] Listado de contenido
El programa debe mostrar el contenido de una ruta pedida al usuario.

#### [2] Mostrar el contenido
Desarrollar un programa que muestre el contenido por pantalla de un archivo de texto.

Pueden usar `Files.probeContentType` para saber de qué tipo de archivo se trata y evitar aquellos que no
sean de texto.

#### [3] ¿Es Correcto?
Desarrollar un programa que dado un archivo de texto, indique si el mismo es procesable por los programas a
desarrollar, mostrando cuantos números se encuentran en el archivo en cuestión.

#### [4] Generación lineal
Desarrollar un programa que permita crear un archivo con un determinado rango de números, indicando el nombre del
archivo, el valor inicial, el incremento y la cantidad.

#### [5] Generación aleatoria
Desarrollar un programa que permita crear un archivo con una cantidad arbitraria de números, incluyendo opción
para fijar el rango de valores mínimo y máximo.

#### [6] Ordenamiento de un archivo
El programa debe pedir el nombre de un archivo 'origen', la dirección en la que se ordenará y guardar su contenido
en uno que sea llamado de la misma forma pero agregando `_ordenado`.

#### [7] ¿Está ordenado?
Desarrollar un programa que pida el nombre de un archivo e indique si el mismo esta ordenado y en que dirección.
