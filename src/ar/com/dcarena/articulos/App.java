package ar.com.dcarena.articulos;

import java.util.ArrayList;
import java.util.Scanner;

import ar.com.dcarena.articulos.model.Articulo;
import ar.com.dcarena.articulos.model.Categoria;
import static ar.com.dcarena.articulos.utils.ArticulosUtils.consultarArticulo;
import static ar.com.dcarena.articulos.utils.ArticulosUtils.editarArticulo;
import static ar.com.dcarena.articulos.utils.ArticulosUtils.eliminarArticulo;
import static ar.com.dcarena.articulos.utils.ArticulosUtils.ingresarArticulo;
import static ar.com.dcarena.articulos.utils.ArticulosUtils.listarArticulos;
import static ar.com.dcarena.articulos.utils.CategoriasUtils.listarCategorias;
import static ar.com.dcarena.articulos.utils.CategoriasUtils.precargarCategorias;
import static ar.com.dcarena.articulos.utils.NumbersUtils.leerEntero;

public class App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<Articulo> articulos = new ArrayList<>();
    ArrayList<Categoria> categorias = new ArrayList<>();

    precargarCategorias(categorias);

    int opcion = 0;
    String menu = new StringBuilder()
        .append("=====================================================").append("\n")
        .append("SISTEMA DE ARTÍCULOS - CLASE 4 (HERENCIA Y TO_STRING)").append("\n")
        .append("=====================================================").append("\n")
        .append("1 - Ingresar artículo").append("\n")
        .append("2 - Listar artículo").append("\n")
        .append("3 - Consultar un artículo").append("\n")
        .append("4 - Modificar un artículo").append("\n")
        .append("5 - Eliminar un artículo").append("\n")
        .append("6 - Listar un artículo").append("\n")
        .append("0 - Salir").append("\n")
        .append("=====================================================").append("\n")
        .toString();

    do {
      System.out.println(menu);
      opcion = leerEntero(sc, "Ingrese una opción");

      switch (opcion) {
        case 1:
          ingresarArticulo(sc, articulos, categorias);
          break;
        case 2:
          listarArticulos(articulos);
          break;
        case 3:
          consultarArticulo(sc, articulos);
          break;
        case 4:
          editarArticulo(sc, articulos, categorias);
          break;
        case 5:
          eliminarArticulo(sc, articulos);
          break;
        case 6:
          listarCategorias(categorias);
          break;
        case 0:
          System.out.println("Saliendo.");
          System.exit(0);
          break;
        default:
          System.out.println("Opción invalida");
      }

    } while (true);
  }

}
