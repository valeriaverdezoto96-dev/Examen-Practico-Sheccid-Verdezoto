# Examen-Practico-Sheccid-Verdezoto
Implementación en consola del juego Buscaminas, desarrollado en Java siguiendo los principios de Programación Orientada a Objetos, el enfoque de código limpio KISS y el patrón Modelo-Vista-Controlador (MVC).
---
# Proyecto: Buscaminas en Consola

## 1. Descripción General
Este proyecto implementa una versión en consola del juego Buscaminas, desarrollado en el lenguaje de programación Java.  
El propósito del proyecto es aplicar los principios de Programación Orientada a Objetos, el patrón de diseño Modelo-Vista-Controlador (MVC), el uso de excepciones personalizadas,
persistencia de datos, pruebas unitarias (JUnit 5) y la técnica de código limpio KISS (Keep It Simple, Stupid).

El juego permite al usuario descubrir casillas en un tablero de 10x10, evitando las minas ocultas.  
El sistema guarda automáticamente el estado de la partida y permite continuarla más tarde, además de iniciar nuevas partidas al finalizar una.

---

## 2. Estructura del Proyecto

```
Buscaminas_SV/
│
├─ src/
│  ├─ buscaminas.controlador/
│  │   └─ JuegoBuscaminas.java
│  │
│  ├─ buscaminas.modelo/
│  │   ├─ Casilla.java
│  │   └─ Tablero.java
│  │
│  ├─ buscaminas.util/
│  │   └─ ArchivoUtil.java
│  │
│  ├─ buscaminas.excepciones/
│  │   └─ CasillaYaDescubiertaException.java
│  │
│  └─ buscaminas.test/
│      ├─ CasillaTest.java
│      └─ TableroTest.java

```
---

- **Modelo:** `Casilla`, `Tablero`  
- **Controlador/Vista:** `JuegoBuscaminas`  
- **Utilidades:** `ArchivoUtil`  
- **Excepciones:** `CasillaYaDescubiertaException`  
- **Pruebas:** `CasillaTest`, `TableroTest`

---

## 3. Requisitos del Sistema

- **Java Development Kit (JDK)** versión 8 o superior  
- **Eclipse IDE** (o cualquier IDE compatible con Java)  
- **JUnit 5** para ejecutar pruebas unitarias  
- **Git** instalado para el control de versiones

---

## 4. Instrucciones de Instalación

1. Clonar el repositorio desde GitHub:  
```bash
   git clone https://github.com/tu-usuario/BuscaminasKISS.git
````

2. Abrir el proyecto en Eclipse:

   * Abrir Eclipse → File → Import → Existing Projects into Workspace.
   * Seleccionar la carpeta del proyecto `Buscaminas_SV`.

3. Configurar JUnit:

   * Clic derecho en el proyecto → Build Path → Add Libraries → JUnit → JUnit 5 → Finish.

4. Compilar el proyecto:

   * Ejecutar `JuegoBuscaminas.java` como **Java Application**.

---

## 5. Instrucciones de Uso

1. Ejecutar la clase `JuegoBuscaminas` desde Eclipse.
2. En la consola se mostrará un tablero de 10x10 con casillas ocultas.
3. Ingresar coordenadas para descubrir una casilla.

   * Ejemplo: `A5` descubre la casilla A5.
4. Para marcar una mina, usar el prefijo **M**:

   * Ejemplo: `MA5` marca la casilla A5 como posible mina.
5. El juego termina cuando:

   * El jugador descubre una mina (derrota).
   * El jugador descubre todas las casillas seguras (victoria).
6. Después de perder o ganar, se puede iniciar una nueva partida.
7. El progreso se guarda automáticamente en el archivo `guardado.dat`.

---

## 6. Ejemplo de Ejecución

```
=== Bienvenido al Buscaminas ===
Nuevo juego iniciado.
   1 2 3 4 5 6 7 8 9 10
A  - - - - - - - - - -
B  - - - - - - - - - -
C  - - - - - - - - - -
...

Ingrese coordenadas (ej: A5) o M para marcar:
A5
   1 2 3 4 5 6 7 8 9 10
A  1 - - - - - - - - -
B  - - - - - - - - - -
...
Ingrese coordenadas (ej: A5) o M para marcar:
```

* Si se descubre una mina:

  ```
  ¡Has perdido! Encontraste una mina.
  El juego se reiniciará en la próxima ejecución.
  ```

* Si se descubren todas las casillas seguras:

  ```
  ¡Felicidades! Has descubierto todas las casillas seguras.
  ```

---

## 7. Pruebas Unitarias

El proyecto incluye pruebas automáticas para validar la funcionalidad de las clases `Casilla` y `Tablero`.

Ejecución de pruebas:

1. En Eclipse, clic derecho sobre el paquete `buscaminas.test`.
2. Seleccionar **Run As → JUnit Test**.
3. Verificar que todas las pruebas se ejecuten correctamente.

---

## 8. Control de Versiones y Buenas Prácticas en GitHub

Se recomienda utilizar **commits significativos** que reflejen claramente los cambios realizados.
Ejemplos de mensajes de commit adecuados:

* `Implementación de clase Tablero y métodos de inicialización`
* `Añadida persistencia de datos en ArchivoUtil`
* `Integración de pruebas unitarias con JUnit 5`
* `Corrección de errores en lógica de marcación de casillas`

Cada commit debe realizarse después de implementar y verificar una funcionalidad específica.

---

## 9. Créditos

* **Autor:** Sheccid Verdezoto
* **Carrera:** Ingeniería en Software
* **Universidad:** Politécnica Salesiana 
---
