###
# 06 - Cadenas
# Las cadenas en Python o strings son un tipo inmutable que permite almacenar secuencias de caracteres.
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

s = "Esto es una cadena"
print(s) #Esto es una cadena
print(type(s)) #<class 'str'>

s = 'Esto es otra cadena'
print(s) #Esto es otra cadena

s = '' # Cadena vacía


#\" - Comillas dobles
#Permite incrustar comillas dentro de una cadena
s = "Comilla \" ejemplo"
print(s) #Comilla " ejemplo


#\n - Salto de línea
#Imprime el texto en una nueva línea
s = "Primera\nSegunda"
print(s)
#Primera
#Segunda

#\número - Carácter ASCII
#Imprime el carácter asociado al número
print("\110\110") #HH


""" - Triple comilla
Define cadenas multilínea
Útil para textos largos
"""

#Concatenación con +
#La forma más básica usando el operador + y str() para convertir valores
x = 5
s = "El número: " + str(x)
print(s) #El número: 5


#Operador %
#Método clásico con caracteres de tipo: %s (cadena), %d (entero), %f (flotante), %e (exponencial), 
#%o (octal), %x (hexadecimal)
x = 5
s = "El número: %d" % x
s = "Números %d y %d" % (5, 10) 
print(s) #Números 5 y 10

#Método format()
#Forma moderna y flexible introducida en versiones recientes
s = "Números {} y {}".format(5, 10) #Números 5 y 10
print(s) #Números 5 y 10
s = "Números {a} y {b}".format(a=5, b=10) #Números 5 y 10
print(s) #Números 5 y 10


#F-strings (Python 3.6+)
#La forma más moderna y recomendada: cadenas literales que permiten incrustar expresiones
a = 5
b = 10
print(f"Números {a} y {b}")
#Números 5 y 10


#Operaciones Básicas

#Suma (+): Concatena dos strings
s1 = "Parte 1"
s2 = "Parte 2"
print(s1 + " " + s2) #Parte 1 Parte 2

#Asignación de suma (+=): Añade cadenas al final
s1 = "Parte 1 "
s2 = "Parte 2"
s1 += s2
print(s1) #Parte 1 Parte 2

#Multiplicación (*): Replica el string n veces
s = "Hola "
print(s*3) #Hola Hola Hola

#Operador in: Verifica si una cadena está contenida en otra
print("mola" in "Python mola") #True

#len(): Devuelve la longitud de la cadena
print(len("Mi cadena")) #9

#chr() y ord(): Convierten entre carácter y valor numérico
print(chr(8364)) #€
print(ord("€")) #8364


#Indexación y Slicing
x = "abcde"
print(x[0]) #a
print(x[-1]) #e

# Slicing básico
print(x[0:2]) #ab
print(x[2:]) #cde

# Slicing con saltos
print(x[0:5:2]) #ace
print(x[0::2]) #ace


#casting
x = str(10.4)
print(x)      
 #10.4
print(type(x)) #<class 'str'>


#capitalize()
#Devuelve la cadena con su primera letra en mayúscula
s = "mi cadena"
print(s.capitalize()) #Mi cadena


#lower()
#Convierte todos los caracteres alfabéticos en minúscula
s = "MI CADENA"
print(s.lower()) #mi cadena


#swapcase()
#Convierte mayúsculas en minúsculas y viceversa
s = "mI cAdEnA"
print(s.swapcase()) #Mi CaDeNa


#upper()
#Convierte todos los caracteres alfabéticos en mayúsculas
s = "mi cadena"
print(s.upper()) #MI CADENA


#count(sub [, start [, end]])
#Permite contar las veces que otra cadena se encuentra dentro de la primera. Acepta parámetros opcionales que indican dónde empezar y acabar de buscar.
s = "el bello cuello"
print(s.count("llo")) #2


#find(sub [, inicio [, límite]])
#Devuelve la posición de la primera ocurrencia de la subcadena. En caso de no encontrarla, devuelve -1. Los argumentos opcionales permiten limitar la búsqueda a una porción de la cadena.
frase = "Érase una vez una princesa"
print(frase.find("una")) #6
print(frase.find("una", 8)) #14
print(frase.find("Aladdin")) #-1


#find() vs index()
#El método index() realiza la misma función que find(), pero genera un error ValueError si no encuentra la subcadena.
frase = "Érase una vez una princesa llamada Jasmine."
frase.index("genio") 
"""
Traceback (most recent call last):
    File "<ipython-input-6-ea78a2857067>", line 1, in <module> 
      frase.index("genio")
ValueError: substring not found
"""


#rfind(sub [, inicio [, límite]])
#Devuelve la posición de la última ocurrencia de la subcadena. Realiza la búsqueda desde el final de la cadena.
print(frase.rfind("una")) #14
print(frase.rfind("lámpara")) #-1


#isalnum()
#Devuelve True si la cadena está formada únicamente por caracteres alfanuméricos, False de lo contrario. Caracteres como @ o & no son alfanuméricos.
s = "correo@dominio.com"
print(s.isalnum()) #False


#isalpha()
#Devuelve True si todos los caracteres son alfabéticos, False de lo contrario.
s = "abcdefg"
print(s.isalpha()) #True


#strip([chars])
#Elimina a la izquierda y derecha el carácter especificado. Sin parámetros elimina espacios en blanco. Muy útil para limpiar cadenas.
s = "  abc  "
print(s.strip()) #abc


#lstrip([chars])
#Realiza la misma función que strip(), pero eliminando solamente los caracteres iniciales que se corresponden con los especificados.
s = "  abc  "
print(s.lstrip()) #abc  (los espacios de la derecha se conservan)


#rstrip([chars])
#Igual que lstrip(), pero eliminando solamente los caracteres finales, en lugar de los iniciales.
s = "  abc  "
print(s.rstrip()) #  abc  (los espacios de la izquierda se conservan)


#zfill(width)
#Rellena la cadena con ceros a la izquierda hasta llegar a la longitud pasada como parámetro.
s = "123"
print(s.zfill(5)) #00123


#join(iterable)
#Devuelve la primera cadena unida a cada uno de los elementos de la lista que se le pasa como parámetro. Es el método inverso a split().
s = " y ".join(["1", "2", "3"])
print(s) #1 y 2 y 3

personajes = ["Daenerys", "John", "Arya"]
personajes_principales = ""
for nombre in personajes:
    personajes_principales += nombre + ", "
print(personajes_principales) #'Daenerys, John, Arya, '


#split(sep=None, maxsplit=-1)
#Divide una cadena en subcadenas y las devuelve almacenadas en una lista. La división se realiza según el separador especificado.

# Sin parámetros, separa por espacios
s = "Python Java C PHP"
print(s.split()) #['Python', 'Java', 'C', 'PHP']

# Separar por comas
s = "Python,Java,C,PHP"
print(s.split(",")) #['Python', 'Java', 'C', 'PHP']

# Con maxsplit en 2
s = "Python,Java,C,PHP"
print(s.split(",", 2)) #['Python', 'Java', 'C,PHP']


#replace(sub_antigua, sub_nueva [, num])
#Devuelve una copia de la cadena tras reemplazar las ocurrencias de la subcadena antigua por la nueva. Si se proporciona el argumento num_ocurrencias, 
#solo se reemplazarán las primeras ocurrencias indicadas.
s = "En un lugar de la Mancha"
print(s.replace("la Mancha","Madrid")) #En un lugar de la Madrid


###
# EJERCICIOS
# Cadenas
###

#Ejercicio 1
#Escribir un programa que pregunte el nombre del usuario en la consola y un número entero 
#e imprima por pantalla en líneas distintas el nombre del usuario tantas veces como el número introducido.




#Ejercicio 2
#Escribir un programa que pregunte el nombre completo del usuario en la consola y después 
#muestre por pantalla el nombre completo del usuario tres veces, una con todas las letras minúsculas, 
#otra con todas las letras mayúsculas y otra solo con la primera letra del nombre y de los apellidos en mayúscula. 
#El usuario puede introducir su nombre combinando mayúsculas y minúsculas como quiera.




#Ejercicio 3
#Escribir un programa que pregunte el nombre del usuario en la consola y después de que el usuario 
#lo introduzca muestre por pantalla <NOMBRE> tiene <n> letras, donde <NOMBRE> es el nombre de usuario 
#en mayúsculas y <n> es el número de letras que tienen el nombre.




#Ejercicio 4
#Escribir un programa que pida al usuario que introduzca una frase en la consola y 
#muestre por pantalla la frase invertida.




#Ejercicio 5
#Escribir un programa que pida al usuario que introduzca una frase en la consola y una vocal, 
#y después muestre por pantalla la misma frase pero con la vocal introducida en mayúscula.




#Ejercicio 6
#Escribir un programa que pregunte el correo electrónico del usuario en la consola y muestre por pantalla 
#otro correo electrónico con el mismo nombre (la parte delante de la arroba @) pero con dominio avellaneda.es.




#Ejercicio 7
#Escribir un programa que pregunte por consola el precio de un producto en euros con dos decimales y 
#muestre por pantalla el número de euros y el número de céntimos del precio introducido.




#Ejercicio 8
#Escribe un programa que lea una cadena escrita por teclado y compruebe si el primer y el último carácter son iguales. 
#Si son iguales, mostrará un mensaje con el número total de caracteres de la cadena distintos a dicho carácter. 
#En caso contrario, mostrará un mensaje con el número total de caracteres de la cadena iguales al carácter inicial 
#y al carácter final (sin incluirlos).




#Ejercicio 9
#Utiliza los métodos split() y join() para sustituir el nombre de la cadena "Mi nombre es minombre" (pon tu nombre)




