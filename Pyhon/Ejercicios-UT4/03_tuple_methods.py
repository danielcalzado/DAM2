###
# 03 - Tuplas
# Las tuplas en Python son un tipo o estructura de datos que permite almacenar datos 
# de una manera muy parecida a las listas, con la salvedad de que son inmutables.
###

import os
import subprocess

# Comprobamos el tipo de sistema operativo
if os.name == "nt":
    # Si el sistema es Windows, usamos el comando 'cls'
    comando = "cls"
else:
    # Si es cualquier otro sistema (Mac o Linux), usamos 'clear'
    comando = "clear"

# Ejecuta el comando seleccionado en la terminal
subprocess.run(comando, shell=True)

#Crear tuplas en Python
# Son inmutables, lo que significa que no pueden ser modificadas una vez declaradas

#con paréntesis
tupla = (1, 2, 3)
print(tupla) #(1, 2, 3)

# sin (), separando con comas todos sus elementos.
tupla = 1, 2, 3
print(type(tupla)) #<class 'tuple'>
print(tupla)       #(1, 2, 3)

#Como hemos comentado, las tuplas son tipos inmutables, lo que significa que una vez asignado su valor, 
#no puede ser modificado. Si se intenta, tendremos un TypeError.
tupla = (1, 2, 3)
#tupla[0] = 5 # Error! TypeError

#Al igual que las listas, las tuplas también pueden ser anidadas.
tupla = 1, 2, ('a', 'b'), 3
print(tupla)       #(1, 2, ('a', 'b'), 3)
print(tupla[2][0]) #a

#Y también es posible convertir una lista en tupla haciendo uso de al función tuple().
lista = [1, 2, 3]
tupla = tuple(lista)
print(type(tupla)) #<class 'tuple'>
print(tupla)       #(1, 2, 3)

#Se puede iterar una tupla de la misma forma que se hacía con las listas.
tupla = (1, 2, 3)
for t in tupla:
    print(t) #1, 2, 3

#Se puede también asignar el valor de una tupla con n elementos a n variables.
l = (1, 2, 3)
x, y, z = l
print(x, y, z) #1 2 3

###############
#Métodos tuplas
###############

#count(<obj>)
#El método count() cuenta el número de veces que el objeto pasado como parámetro 
# se ha encontrado en la lista.
l = [1, 1, 1, 3, 5]
print(l.count(1)) #3

#index(<obj>[,index])
#El método index() busca el objeto que se le pasa como parámetro y 
# devuelve el índice en el que se ha encontrado.
l = [7, 7, 7, 3, 5]
print(l.index(5)) #4

#En el caso de no encontrarse, se devuelve un ValueError.
l = [7, 7, 7, 3, 5]
#print(l.index(35)) #Error! ValueError

#El método index() también acepta un segundo parámetro opcional, 
# que indica a partir de que índice empezar a buscar el objeto.
l = [7, 7, 7, 3, 5]
print(l.index(7, 2)) #2


###
# EJERCICIOS
# Prueba a realizar con tuplas los ejercicios realizados anteriormente con listas
###

# Ejercicio 1: Añadir y modificar elementos
# Crea una tupla con los números del 1 al 5.
# Añade el número 6 al final usando append().
# Inserta el número 10 en la posición 2 usando insert().
# Modifica el primer elemento de la tupla para que sea 0.
print("\nEjercicio 1:")
tupla = (1, 2, 3, 4, 5)
tupla.append(6)
tupla.insert(2, 10) 
tupla[0] = 0 
print(tupla) 

# Ejercicio 2: Combinar y limpiar tuplas
# Crea dos tuplas:
# tupla_a = [1, 2, 3]
# tupla_b = [4, 5, 6, 1, 2]
# Extiende tupla_a con tupla_b usando extend().
# Elimina la primera aparición del número 1 en tupla_a usando remove().
# Elimina el elemento en el índice 3 de tupla_a usando pop(). Imprime el elemento eliminado.
# Limpia completamente tupla_b usando clear().
print("\nEjercicio 2:")
tupla_a = (1, 2, 3)
tupla_b = (4, 5, 6, 1, 2)
tupla_a.extend(tupla_b) 
tupla_a.remove(1) 
elemento_eliminado = tupla_a.pop(3) 
tupla_b.clear() 
print("tupla a:", tupla_a) 
print("tupla b:", tupla_b) 

# Ejercicio 3: Slicing y eliminación con del
# Crea una tupla con los números del 1 al 10.
# Utiliza slicing y del para eliminar los elementos desde el índice 2 hasta el 5 (sin incluir el 5).
# Imprime la tupla resultante.
print("\nEjercicio 3:")
tupla = (1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
del tupla[2:5] 

# Ejercicio 4: Ordenar y contar
# Crea una tupla con los siguientes números: [5, 2, 8, 1, 9, 4, 2].
# Ordena la tupla de forma ascendente usando sort().
# Cuenta cuántas veces aparece el número 2 en la tupla usando count().
# Comprueba si el número 7 está en la tupla usando in.
print("\nEjercicio 4:")
tupla = (5, 2, 8, 1, 9, 4, 2)
tupla.sort() 
cantidad_dos = tupla.count(2)
esta_el_siete = 7 in tupla
print(f"Cantidad de 2: {cantidad_dos}") 
print(f"¿Está el 7?: {esta_el_siete}") 

# Ejercicio 5: Copia vs. Referencia
# Crea una tupla llamada original con los números [1, 2, 3].
# Crea una copia de la tupla original llamada copia_1 usando slicing.
# Crea otra copia llamada copia_2 usando copy().
# Crea una referencia a la tupla original llamada referencia.
# Modifica el primer elemento de la tupla referencia a 10.
# Imprime las cuatro tuplas (original, copia_1, copia_2, referencia) y observa los cambios.
print("\nEjercicio 5:")
original = (1, 2, 3)
copia_1 = original[:]
copia_2 = original.copy() 
referencia = original
referencia[0] = 10 
print(f"Original: {original}")      
print(f"Copia 1 (slicing): {copia_1}") 
print(f"Referencia: {referencia}")     

# Ejercicio 6: Ordenar strings sin diferenciar mayúsculas y minúsculas.
# Crea una tupla con las siguientes cadenas: ["Manzana", "pera", "BANANA", "naranja"].
# Ordena la tupla sin diferenciar entre mayúsculas y minúsculas.
print("\nEjercicio 6:")
strings = ("Manzana", "pera", "BANANA", "naranja")
strings.sort(key=str.lower)
print(strings) 