package ar.com.dcarena.articulos.utils;

import java.util.Scanner;

public class NumbersUtils {
  public static int leerEntero(Scanner s, String msg) {
    while (true) {
      try {
        System.out.println(msg);
        return Integer.parseInt(s.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Error: debe ingresar un número entero válido.");
      }
    }
  }

  public static int leerEnteroNoNegativo(Scanner sc, String msg) {
    while (true) {
      int valor = leerEntero(sc, msg);
      if (valor < 0) {
        System.out.println("Error: el valor no puede ser negativo.");
        continue;
      }
      return valor;
    }
  }

  public static double leerDouble(Scanner sc, String msg) {
    while (true) {
      try {
        System.out.println(msg);
        return Double.parseDouble(sc.nextLine());
      } catch (NumberFormatException e) {
        System.out.println("Error: debe ingresar un número entero válido.");
      }
    }
  }

  public static double leerDoubleNoNegativo(Scanner sc, String msg) {
    while (true) {
      double valor = leerDouble(sc, msg);
      if (valor < 0) {
        System.out.println("Error: el valor no puede ser negativo.");
        continue;
      }
      return valor;
    }
  }

}
