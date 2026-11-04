import random

secreto = random.randint(1, 10)
entrada = 0
acertado = True
contador = 1

try: 
    while acertado:
        try:
            entrada = int(input("Introduce un número: "))
            if entrada < secreto:
                print("MÁS")
            else:
                print("MENOS")
            contador = contador + 1
            if entrada == secreto:
                print(f"Has acertado, número de intentos: {contador}")
                acertado = False
        except ValueError:
            print("Introduce un valor válido")
            continue
except KeyboardInterrupt:
    print("\nGracias por jugar")
