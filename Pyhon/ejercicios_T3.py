###
# 01 - Functions
# Permiten la reutilización del código
###

import os
import subprocess
import math

# Comprobamos el tipo de sistema operativo
if os.name == "nt":
    # Si el sistema es Windows, usamos el comando 'cls'
    comando = "cls"
else:
    # Si es cualquier otro sistema (Mac o Linux), usamos 'clear'
    comando = "clear"

# Ejecuta el comando seleccionado en la terminal
subprocess.run(comando, shell=True)

#Escribir una función que muestre por pantalla el 
#saludo ¡Hola profe! cada vez que se la invoque.

def saludo():
    print("Hola profe")



#Escribir una función a la que se le pase una cadena <nombre> 
#y muestre por pantalla el saludo ¡hola <nombre>!.
def saludo_nombre(nombre):
    print(f"Hola {nombre}")




#Escribir una función que reciba un número entero positivo y devuelva su factorial.
def num_factorial(num: int):
    return math.factorial(num)

print(num_factorial(10))




#Escribir una función que calcule el total de una factura tras aplicarle el IVA. 
#La función debe recibir la cantidad sin IVA y el porcentaje de IVA a aplicar, 
#y devolver el total de la factura. Si se invoca la función sin pasarle 
# el porcentaje de IVA, deberá aplicar un 21%.
def calcular_iva(cantidad, iva=0.21):
    aplicado = cantidad + (cantidad * iva)
    return aplicado

print(calcular_iva(25))




#Escribir una función que calcule el área de un círculo 
#y otra que calcule el volumen de un cilindro usando la primera función.
def area_circulo(diametro, altura=0):
    radio = diametro / 2
    area = 3.14 * (radio ** 2)
    return area

print("Area de circulo: ", area_circulo(10))




#Escribir una función que reciba una muestra de números en una lista y 
#devuelva otra lista con sus cuadrados.
def fun_lista(lista):
    for cuadrados in lista:
        print(cuadrados ** 2)

print("-- Lista --")
lista = [4, 6, 7, 8, 9, 10]
fun_lista(lista)


diccionario = {
    3: "sheyla",
    "dani": 10
}

print("------------- PRUEBA DICCIONARIO -----------------")
print(f"Hola me llamo {diccionario[3]}")


