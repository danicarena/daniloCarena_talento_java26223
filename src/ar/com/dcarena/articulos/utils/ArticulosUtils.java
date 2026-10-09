package ar.com.dcarena.articulos.utils;

import java.util.ArrayList;
import java.util.Scanner;

import ar.com.dcarena.articulos.model.Articulo;
import ar.com.dcarena.articulos.model.ArticuloAlimenticio;
import ar.com.dcarena.articulos.model.ArticuloElectronico;
import ar.com.dcarena.articulos.model.Categoria;
import static ar.com.dcarena.articulos.utils.CategoriasUtils.listarCategorias;
import static ar.com.dcarena.articulos.utils.CategoriasUtils.pedirCategoriaExistente;
import static ar.com.dcarena.articulos.utils.NumbersUtils.leerDoubleNoNegativo;
import static ar.com.dcarena.articulos.utils.NumbersUtils.leerEntero;
import static ar.com.dcarena.articulos.utils.NumbersUtils.leerEnteroNoNegativo;
import static ar.com.dcarena.articulos.utils.TextUtils.leerTextoNoVacio;

public class ArticulosUtils {
  public static void consultarArticulo(Scanner sc, ArrayList<Articulo> articulos) {
    System.out.println("---------Consultando Articulo----------------");

    if (articulos.isEmpty()) {
      System.out.println("No hay artículos cargados.");
      return;
    }

    int codigo = leerEntero(sc, "Ingrese el código del artículo a consultar: ");

    Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

    if (articulo == null) {
      System.out.println("El artículo no existe.");
      return;
    }

    System.out.println("Artículo encontrado:");
    System.out.println(articulo);
    System.out.println("Detalle específico: " + articulo.getDetalleEspecifico());

  }

  public static void editarArticulo(Scanner sc, ArrayList<Articulo> articulos, ArrayList<Categoria> categorias) {
    System.out.println("\n--- MODIFICAR ARTÍCULO ---");

    if (articulos.isEmpty()) {
      System.out.println("No hay artículos cargados.");
      return;
    }

    int codigo = leerEntero(sc, "Ingrese el código del artículo a modificar: ");

    Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

    if (articulo == null) {
      System.out.println("El artículo no existe.");
      return;
    }

    String nuevoNombre = leerTextoNoVacio(sc, "Ingrese el nuevo nombre del artículo: ");
    double nuevoPrecio;
    nuevoPrecio = leerDoubleNoNegativo(sc, "Ingrese el nuevo precio del artículo: ");

    listarCategorias(categorias);
    Categoria nuevaCategoria = pedirCategoriaExistente(sc, categorias);

    articulo.setNombre(nuevoNombre);
    articulo.setPrecio(nuevoPrecio);
    articulo.setCategoria(nuevaCategoria);

    // Si el artículo real es electrónico, permitimos modificar la garantía.
    if (articulo instanceof ArticuloElectronico electronico) {
      int nuevaGarantia = leerEnteroNoNegativo(sc, "Ingrese la nueva garantía en meses: ");
      electronico.setGarantiaMeses(nuevaGarantia);
    }

    if (articulo instanceof ArticuloAlimenticio alimenticio) {
      int nuevosDias = leerEnteroNoNegativo(sc, "Ingrese los nuevos días para vencimiento: ");
      alimenticio.setDiasParaVencimiento(nuevosDias);
    }

    System.out.println("Artículo modificado correctamente.");
  }

  public static void eliminarArticulo(Scanner sc, ArrayList<Articulo> articulos) {
    System.out.println("\n--- ELIMINAR ARTÍCULO ---");
    if (articulos.isEmpty()) {
      System.out.println("No hay artículos cargados.");
      return;
    }
    int codigo = leerEntero(sc, "Ingrese el código del artículo a eliminar: ");

    Articulo articulo = buscarArticuloPorCodigo(articulos, codigo);

    if (articulo == null) {
      System.out.println("El artículo no existe.");
      return;
    }
    articulos.remove(articulo);
    System.out.println("Artículo eliminado correctamente.");
  }

  public static void ingresarArticulo(
      Scanner sc,
      ArrayList<Articulo> articulos,
      ArrayList<Categoria> categorias) {

    String menu = new StringBuilder()
        .append("=====================================================").append("\n")
        .append("Ingresar articulo").append("\n")
        .append("=====================================================").append("\n")
        .append("1 - Artículo electrónico").append("\n")
        .append("2 - Artículo alimenticio").append("\n")
        .append("=====================================================").append("\n")
        .toString();

    System.out.println(menu);
    int tipo;
    do {
      tipo = leerEntero(sc, "Seleccione el tipo de articulo");
      if (tipo != 1 && tipo != 2) {
        System.out.println("Error: debe elegir 1 o 2.");
      }

    } while (tipo != 1 && tipo != 2);
    int codigo = leerEntero(sc, "ingrese el código del artículo");

    if (buscarArticuloPorCodigo(articulos, codigo) != null) {
      System.out.println("Error: Ya existe un artículo con ese código.");
      return;
    }

    String nombre = leerTextoNoVacio(sc, "Ingrese el nombre del artículo: ");
    double precio = leerDoubleNoNegativo(sc, "Ingrese el precio del artículo: ");

    listarCategorias(categorias);
    Categoria categoria = pedirCategoriaExistente(sc, categorias);

    Articulo articulo;

    if (tipo == 1) {
      int garantiaMeses = leerEnteroNoNegativo(sc, "Ingrese la garantía en meses: ");

      articulo = new ArticuloElectronico(codigo, nombre, precio, categoria, garantiaMeses);
    } else {
      int diasParaVencimiento = leerEnteroNoNegativo(sc, "Ingrese los días para vencimiento: ");

      articulo = new ArticuloAlimenticio(codigo, nombre, precio, categoria, diasParaVencimiento);
    }

    articulos.add(articulo);

    System.out.println("Artículo ingresado correctamente.");
    System.out.println("Resumen del objeto creado:");
    System.out.println(articulo);

  }

  public static void listarArticulos(ArrayList<Articulo> articulos) {
    System.out.println("----------------LISTANDO ARTICULOS--------------------------");
    if (articulos.isEmpty()) {
      System.out.println("Lista de artículos Vacía.");
      return;
    }

    for (Articulo articulo : articulos) {
      System.out.println(articulo);
      if (articulo instanceof ArticuloElectronico articuloElectronico) {
        articuloElectronico.nroTelMesaDeAyudaParaReclamos();
      }
    }
  }

  public static Articulo buscarArticuloPorCodigo(ArrayList<Articulo> articulos, int codigo) {
    for (Articulo articulo : articulos) {
      if (articulo.getCodigo() == codigo) {
        return articulo;
      }
    }
    return null;
  }

}
