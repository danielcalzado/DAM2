# Regla de oro: las funciones siempre se programan arriba, porque python lee de arriba a abajo
def procesar_notas(estudiantes):
    for nombre, notas in estudiantes.items():
        try:
            media = sum(notas) / len(notas)
            if media >= 5:
                print(f"{nombre}: Aprobado con media {round(media, 2)}")
            else:
                print(f"{nombre}: Suspenso con media {round(media, 2)}")
        except ZeroDivisionError:
            print(f"{nombre}: sin notas registradas")
            
estudiantes = {
    "Ana": [1, 4, 9],
    "Carlos": [9, 5, 5],
    "Elena": []
}

print("Procesando notas...")
procesar_notas(estudiantes)

print("\n- - - BÚSQUEDA DE ESTUDIANTES - - -")
buscando = True
while buscando:
    nombre = input("Introduce un nombre: ")
    if nombre == "salir":
        buscando = False    
    elif nombre in estudiantes:
        print(f"Las notas de {nombre} son: {estudiantes[nombre]}")
    else:
        print("El estudiante no existe.")
else:
    print("Búsqueda realizada con éxito.")




