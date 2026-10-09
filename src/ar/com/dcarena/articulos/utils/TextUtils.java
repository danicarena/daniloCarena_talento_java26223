package ar.com.dcarena.articulos.utils;

import java.util.Scanner;

public class TextUtils {
  private TextUtils() {
  };

  public static String leerTextoNoVacio(Scanner sc, String msg) {
    while (true) {
      System.out.println(msg);
      String txt = sc.nextLine();
      if (!txt.trim().equals("")) {
        return txt.trim();
      }
      System.out.println("Error: El texto no puede estar vacío");
    }
  }
}
