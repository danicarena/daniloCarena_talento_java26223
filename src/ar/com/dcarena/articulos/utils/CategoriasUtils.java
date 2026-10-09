package ar.com.dcarena.articulos.utils;

import java.util.ArrayList;
import java.util.Scanner;

import ar.com.dcarena.articulos.model.Categoria;
import static ar.com.dcarena.articulos.utils.NumbersUtils.leerEntero;

public class CategoriasUtils {
  public static void listarCategorias(ArrayList<Categoria> categorias) {
    System.out.println("\n--- CATEGORÍAS DISPONIBLES ---");
    for (Categoria categoria : categorias) {
      System.out.println(categoria);
    }
  }

  public static Categoria buscarCategoriaPorCodigo(ArrayList<Categoria> categorias, int codigo) {
    for (Categoria categoria : categorias) {
      if (categoria.getCodigo() == codigo)
        return categoria;
    }
    return null;
  }

  public static Categoria pedirCategoriaExistente(Scanner sc, ArrayList<Categoria> categorias) {
    while (true) {
      var codigoCategoria = leerEntero(sc, "Ingrese el código de la categoría: ");
      Categoria categoria = buscarCategoriaPorCodigo(categorias, codigoCategoria);
      if (categoria != null) {
        return categoria;
      }
      System.out.println("Error: la categoría no existe.");
    }
  }

  public static void precargarCategorias(ArrayList<Categoria> categorias) {
    categorias.add(new Categoria(1, "Electrónica", "Productos tecnológicos y electrónicos"));
    categorias.add(new Categoria(2, "Periféricos", "Accesorios para computadora"));
    categorias.add(new Categoria(3, "Alimentos", "Productos alimenticios"));
    categorias.add(new Categoria(4, "Limpieza", "Artículos de limpieza del hogar"));
  }
}
