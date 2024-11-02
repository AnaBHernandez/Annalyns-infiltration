# Annalyn's Infiltration 🏰🐶

## Descripción 📜
Este proyecto implementa la lógica para un juego de rol en el que la protagonista, Annalyn, intenta rescatar a su amiga secuestrada por un caballero y un arquero. Con la ayuda de su perro, Annalyn puede tomar varias acciones según el estado de los secuestradores y su amiga. Este ejercicio forma parte del bootcamp backend de Factoria F5.

## Acciones disponibles ⚔️
- **Ataque rápido**: Puede realizarse si el caballero está dormido. 😴
- **Espiar**: Es posible si al menos uno de los secuestradores está despierto. 👀
- **Señalizar al prisionero**: Puede hacerse si el prisionero está despierto y el arquero está dormido. 📣
- **Liberar al prisionero**: Esto puede suceder de dos maneras:
  - Si Annalyn tiene a su perro, puede liberar al prisionero si el arquero está dormido. 🐕💤
  - Si no tiene a su perro, el prisionero debe estar despierto y ambos, el caballero y el arquero, deben estar dormidos. 😬

## Funcionalidades 💻
Las siguientes funcionalidades están implementadas en la clase `AnnalynsInfiltration`:

- `canFastAttack(boolean knightIsAwake)`: Verifica si se puede realizar un ataque rápido.
- `canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake)`: Verifica si se puede espiar al grupo.
- `canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake)`: Verifica si se puede señalizar al prisionero.
- `canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent)`: Verifica si se puede liberar al prisionero.

## Contribuciones 🤝
¡Las contribuciones son bienvenidas! Si tienes ideas para mejorar este proyecto, siéntete libre de:

- Sugerir mejoras o nuevas funcionalidades.
- Reportar errores o problemas que encuentres.

Si te animas a realizar cambios en el código, puedes hacerlo de la siguiente manera:

1. **Haz un fork** de este repositorio (copia tu propia versión).
2. **Realiza tus cambios** en tu versión.
3. **Envía un pull request** para que podamos revisar tus cambios.

¡Apreciamos cualquier ayuda que puedas ofrecer! Gracias por tu interés.

## Licencia 📄
Este proyecto está licenciado bajo la [Licencia MIT](https://opensource.org/licenses/MIT).
