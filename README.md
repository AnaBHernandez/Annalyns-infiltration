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

### Clase Principal: `AnnalynsInfiltration`
Las siguientes funcionalidades están implementadas:

- `canFastAttack(boolean knightIsAwake)`: Verifica si se puede realizar un ataque rápido.
- `canSpy(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake)`: Verifica si se puede espiar al grupo.
- `canSignalPrisoner(boolean archerIsAwake, boolean prisonerIsAwake)`: Verifica si se puede señalizar al prisionero.
- `canFreePrisoner(boolean knightIsAwake, boolean archerIsAwake, boolean prisonerIsAwake, boolean petDogIsPresent)`: Verifica si se puede liberar al prisionero.

### Nuevas Clases de Soporte 🆕

#### `GameState`
- Encapsula el estado completo del juego
- Proporciona métodos para consultar el estado de los personajes
- Incluye análisis estratégico automático
- Soporte para crear copias con cambios específicos

#### `GameConstants`
- Constantes del juego para mejor mantenibilidad
- Métodos de utilidad para formateo de salida
- Emojis y strings predefinidos
- Validación de parámetros

### Métodos Sobrecargados
- Versiones que aceptan `GameState` para mayor flexibilidad
- `getActionAnalysis(GameState)`: Análisis completo de todas las acciones disponibles

## Mejoras Implementadas ✨

### 🧪 Testing Avanzado
- **20 tests** organizados en clases anidadas con `@Nested`
- Cobertura completa de casos límite y escenarios complejos
- Tests descriptivos con `@DisplayName`
- Casos de prueba para escenarios óptimos y desafiantes

### 📚 Documentación
- **JavaDoc completo** en todas las clases y métodos
- Documentación de parámetros, valores de retorno y excepciones
- Ejemplos de uso en la documentación

### 🏗️ Arquitectura Mejorada
- **Separación de responsabilidades**: Lógica de negocio, estado del juego y constantes
- **Inmutabilidad**: `GameState` es inmutable para mayor seguridad
- **Extensibilidad**: Fácil agregar nuevas funcionalidades
- **Mantenibilidad**: Código organizado y bien documentado

### 🎨 Interfaz de Usuario
- **Salida visual mejorada** con emojis y formato
- **Análisis estratégico** automático del estado del juego
- **Mensajes informativos** sobre las condiciones del rescate

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
