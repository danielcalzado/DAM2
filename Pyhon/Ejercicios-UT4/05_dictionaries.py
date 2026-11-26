###
# 04 - Dictionarios
# Los diccionarios son colecciones de pares clave-valor.
# Sirven para almacenar datos relacionados.
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

# ejemplo tipico de diccionario
persona = {
  "nombre": "marciano",
  "edad": 25,
  "es_estudiante": True,
  "calificaciones": [7, 8, 9],
  "socials": {
    "twitter": "@marciano",
    "instagram": "@marciano",
    "facebook": "marciano"
  }
}

#Otra forma equivalente de crear un diccionario en Python es usando dict() e introduciendo los pares key: value entre paréntesis.
d2 = dict([
      ('Nombre', 'Sara'),
      ('Edad', 27),
      ('Documento', 1003882),
])
print(d2) #{'Nombre': 'Sara', 'Edad': '27', 'Documento': '1003882'}


#También es posible usar el constructor dict() para crear un diccionario.
d3 = dict(Nombre='Sara',
          Edad=27,
          Documento=1003882)
print(d3) #{'Nombre': 'Sara', 'Edad': 27, 'Documento': 1003882}


# para acceder a los valores
print(persona["nombre"])
print(persona["calificaciones"][2])
print(persona["socials"]["twitter"])

# cambiar valores al acceder
persona["nombre"] = "madeval"
persona["calificaciones"][2] = 10

# eliminar completamente una propiedad
del persona["edad"]
# print(persona)

es_estudiante = persona.pop("es_estudiante") 
print(f"es_estudiante: {es_estudiante}")
print(persona)

# sobreescribir un diccionario con otro diccionario
a = { "name": "miduev", "age": 25 }
b = { "name": "madeval", "es_estudiante": True }

a.update(b)
print(a)

# comprobar si existe una propiedad
print("name" in persona) # False
print("nombre" in persona) # True

# obtener todas las claves
print("\nkeys:")
print(persona.keys())

# obtener todas los valores
print("\nvalues:")
print(persona.values())

# obtener tanto clave como valor
print("\nitems:")
print(persona.items())

for key, value in persona.items():
  print(f"{key}: {value}")


###
# EJERCICIOS
# Diccionarios
###

#Ejercicio 1
#Escribir un programa que guarde en una variable el diccionario {'Euro':'€', 'Dollar':'$', 'Yen':'¥'}, 
#pregunte al usuario por una divisa y muestre su símbolo o un mensaje de aviso si la divisa no está 
#en el diccionario.




#Ejercicio 2
#Escribir un programa que pregunte al usuario su nombre, edad, dirección y teléfono y 
#lo guarde en un diccionario. 
#Después debe mostrar por pantalla el mensaje <nombre> tiene <edad> años, vive en <dirección> 
#y su número de teléfono es <teléfono>.




#Ejercicio 3
#Escribir un programa que guarde en un diccionario los precios de las frutas de la tabla, 
#pregunte al usuario por una fruta, un número de kilos y muestre por pantalla el precio 
#de ese número de kilos de fruta. Si la fruta no está en el diccionario debe mostrar un 
#mensaje informando de ello.




#Ejercicio 4
#Escribir un programa que almacene el diccionario con los créditos de las asignaturas 
#de un curso {'Matemáticas': 6, 'Física': 4, 'Química': 5} y después muestre por pantalla 
#los créditos de cada asignatura en el formato <asignatura> tiene <créditos> créditos, 
#donde <asignatura> es cada una de las asignaturas del curso, y <créditos> son sus créditos. 
#Al final debe mostrar también el número total de créditos del curso.



#Ejercicio 5
#Escribir un programa que cree un diccionario simulando una cesta de la compra. 
#El programa debe preguntar el artículo y su precio y añadir el par al diccionario, 
#hasta que el usuario decida terminar. Después se debe mostrar por pantalla la lista 
#de la compra y el coste total
