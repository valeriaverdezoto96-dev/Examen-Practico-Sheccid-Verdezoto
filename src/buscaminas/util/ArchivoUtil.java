package buscaminas.util;

import java.io.*;
import buscaminas.modelo.Tablero;

public class ArchivoUtil {

    private static final String RUTA_ARCHIVO = "guardado.dat";

    public static void guardar(Tablero tablero) {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(RUTA_ARCHIVO))) {
            out.writeObject(tablero);
            System.out.println("Juego guardado correctamente.");
        } catch (IOException e) {
            System.out.println("Error al guardar el juego: " + e.getMessage());
        }
    }

    public static Tablero cargar() {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(RUTA_ARCHIVO))) {
            Tablero tablero = (Tablero) in.readObject();
            System.out.println("Juego cargado desde archivo.");
            return tablero;
        } catch (FileNotFoundException e) {
            System.out.println("No existe un juego guardado. Se creará uno nuevo.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("Error al cargar el juego: " + e.getMessage());
        }
        return null;
    }

    public static void eliminarGuardado() {
        File archivo = new File(RUTA_ARCHIVO);
        if (archivo.exists()) {
            archivo.delete();
            System.out.println("Se eliminó el guardado anterior.");
        }
    }
}
