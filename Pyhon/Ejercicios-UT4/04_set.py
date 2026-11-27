###
# 04 - Conjuntos
# Los sets en Python son una estructura de datos usada para almacenar elementos de una manera 
# similar a las listas, pero con ciertas diferencias.
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

#Crear set Python
"""
Los set en Python son un tipo que permite almacenar varios elementos y acceder a ellos 
de una forma muy similar a las listas pero con ciertas diferencias:

- Los elementos de un set son único, lo que significa que no puede haber elementos duplicados.
- Los set son desordenados, lo que significa que no mantienen el orden de cuando son declarados.
- Sus elementos deben ser inmutables.
- Para entender mejor los sets, es necesario entender ciertos conceptos matemáticos 
  como la teoría de conjuntos.

Para crear un set en Python se puede hacer con set() y pasando como entrada cualquier tipo iterable, 
como puede ser una lista. Se puede ver como a pesar de pasar elementos duplicados como dos 8 y 
en un orden determinado, al imprimir el set no conserva ese orden y los duplicados se han eliminado.
"""

s = set([5, 4, 6, 8, 8, 1])
print(s)       #{1, 4, 5, 6, 8}
print(type(s)) #<class 'set'>

#Se puede hacer lo mismo haciendo uso de {} y sin usar la palabra set() como se muestra a continuación.

s = {5, 4, 6, 8, 8, 1}
print(s)       #{1, 4, 5, 6, 8}
print(type(s)) #<class 'set'>


#Operaciones con sets
#A diferencia de las listas, en los set no podemos modificar un elemento a través de su índice. 
# Si lo intentamos, tendremos un TypeError.
s = set([5, 6, 7, 8])
#s[0] = 3 #Error! TypeError


#Los elementos de un set deben ser inmutables, por lo que un elemento de un set no puede ser 
#ni un diccionario ni una lista. Si lo intentamos tendremos un TypeError
lista = ["Perú", "Argentina"]
#s = set(["México", "España", lista]) #Error! TypeError


#Los sets se pueden iterar de la misma forma que las listas.
s = set([5, 6, 7, 8])
for ss in s:
    print(ss) #8, 5, 6, 7


#Con la función len() podemos saber la longitud total del set. Como ya hemos indicado, 
#los duplicados son eliminados.
s = set([1, 2, 2, 3, 4])
print(len(s)) #4


#También podemos saber si un elemento está presente en un set con el operador in. 
#Se el valor existe en el set, se devolverá True.
s = set(["Guitarra", "Bajo"])
print("Guitarra" in s) #True


#Los sets tienen además diferentes funcionalidades, que se pueden aplicar en 
#forma de operador o de método. Por ejemplo, el operador | nos permite realizar 
# la unión de dos sets, lo que equivale a juntarlos. 
# El equivalente es el método union() que vemos a continuación.
s1 = set([1, 2, 3])
s2 = set([3, 4, 5])
print(s1 | s2) #{1, 2, 3, 4, 5}


#Métodos sets
#s.add(<elem>)
#El método add() permite añadir un elemento al set.
l = set([1, 2])
l.add(3)
print(l) #{1, 2, 3}


#s.remove(<elem>)
#El método remove() elimina el elemento que se pasa como parámetro. Si no se encuentra, 
#se lanza la excepción KeyError.
s = set([1, 2])
s.remove(2)
print(s) #{1}


#s.discard(<elem>)
#El método discard() es muy parecido al remove(), borra el elemento que se pasa como parámetro, 
#y si no se encuentra no hace nada.
s = set([1, 2])
s.discard(3)
print(s) #{1, 2}


#s.pop()
#El método pop() elimina un elemento aleatorio del set.
s = set([1, 2])
s.pop()
print(s) #{2}


#s.clear()
#El método clear() elimina todos los elementos de set.
s = set([1, 2])
s.clear()
print(s) #set()


#Podemos calcular la unión entre dos sets usando el método union(). 
#Esta operación representa la “mezcla” de ambos sets. 
#Nótese que el método puede ser llamado con más parámetros de entrada, y su resultado 
#será la unión de todos los sets.

s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
s3 = {6, 7, 8}
resultado = s1.union(s2)
print(resultado)   # {1, 2, 3, 4, 5, 6}

# Puedes unir más de dos conjuntos
resultado = s1.union(s2, s3)
print(resultado)   # {1, 2, 3, 4, 5, 6, 7, 8}


#También podemos calcular la intersección entre dos o más set. 
#Su resultado serán aquellos elementos que pertenecen a ambos sets.
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
s3 = {6, 7, 8}
resultado = s1.intersection(s2)
print(resultado)   # {3, 4}

# Con más de dos conjuntos
resultado = s1.intersection(s2, s3)
print(resultado)   # {6} (porque 6 está en todos)



#diferencia: Elementos que están en s1 pero no en los otros.
#s1.difference(s2[, s3 ...])
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
s3 = {6, 7, 8}
resultado = s1.difference(s2)
print(resultado)   # {1, 2}

# Con más conjuntos
resultado = s1.difference(s2, s3)
print(resultado)   # {1, 2}


#symmetric_difference(): Elementos que están en uno u otro, pero no en ambos.
#s1.symmetric_difference(s2)
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
resultado = s1.symmetric_difference(s2)
print(resultado)   # {1, 2, 5, 6}


#isdisjoint(): Devuelve True si no tienen ningún elemento en común.
#s1.isdisjoint(s2)
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
print(s1.isdisjoint(s2))   # False
print({1, 2}.isdisjoint({3, 4}))  # True


#issubset(): Devuelve True si s1 es subconjunto de s2.
#s1.issubset(s2)
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
print({1, 2}.issubset(s1))  # True
print(s1.issubset(s2))      # False


#issuperset(): Devuelve True si s1 es superconjunto de s2
#s1.issuperset(s2)
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
print(s1.issuperset({1, 2}))  # True
print(s1.issuperset(s2))      # False


#update(): Agrega a s1 los elementos de otros conjuntos (modifica el original).
#s1.update(s2[, s3 ...])
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
s1.update(s2)
print(s1)  # {1, 2, 3, 4, 5, 6}


#intersection_update(): Deja en s1 solo los elementos comunes con los otros conjuntos (modifica el original).
#s1.intersection_update(s2[, s3 ...])
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
s1.intersection_update(s2)
print(s1)  # {3, 4}


#difference_update(): Elimina de s1 los elementos que estén en los otros conjuntos (modifica el original).
#s1.difference_update(s2[, s3 ...])
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
s1.difference_update(s2)
print(s1)  # {1, 2}


#symmetric_difference_update(): Reemplaza s1 por la diferencia simétrica con otro 
#conjunto (modifica el original).
#s1.symmetric_difference_update(s2)
s1 = {1, 2, 3, 4}
s2 = {3, 4, 5, 6}
s1.symmetric_difference_update(s2)
print(s1)  # {1, 2, 5, 6}


###
# EJERCICIOS
# Usa los métodos que has aprendido
###

#Ejercicio 1 – Unión e intersección de conjuntos
#Dadas las asignaturas que cursan dos alumnos, muestra:
#Las asignaturas que cursan entre los dos (unión).
#Las asignaturas que tienen en común (intersección).
alumno1 = {"Matemáticas", "Lengua", "Historia"}
alumno2 = {"Inglés", "Lengua", "Ciencias"}
union = alumno1 | alumno2
interseccion  = alumno1 & alumno2



#Ejercicio 2 – Diferencia de conjuntos
#Un grupo de amigos fue al cine. Algunos compraron palomitas y otros no.
#Muestra qué amigos no compraron palomitas.
todos = {"Ana", "Luis", "Carlos", "Marta", "Sofía"}
palomitas = {"Luis", "Sofía"}




#Ejercicio 3 – Comprobar subconjuntos y superconjuntos
#Determina si todos los empleados del turno de tarde también trabajan en el turno general.
turno_general = {"Juan", "Lucía", "Pedro", "María", "Andrés"}
turno_tarde = {"Pedro", "Lucía"}
if turno_tarde.issulset(turno_general):
    print("están")



#0Ejercicio 4 – Diferencia simétrica
#Tienes dos listas de películas vistas por dos personas.
#Muestra las películas que solo ha visto una de ellas (pero no ambas).
juan = {"Avatar", "Titanic", "Matrix"}
maria = {"Matrix", "Inception", "Avatar 2"}




#Ejercicio 5 – Actualización de conjuntos
#Un conjunto pendientes contiene las tareas que faltan por hacer.
#Cuando se completan algunas, actualiza el conjunto eliminándolas.
pendientes = {"comprar pan", "hacer la cama", "leer", "pagar factura"}
hechas = {"hacer la cama", "leer"}


