package ar.com.dcarena.articulos.model;

public class ArticuloAlimenticio extends Articulo {

  private int diasParaVencimiento = 0;

  public ArticuloAlimenticio(int codigo, String nombre, double precio, Categoria categoria, int diasParaVencimiento) {
    super(codigo, nombre, precio, categoria);

    this.diasParaVencimiento = diasParaVencimiento;
  }

  public void setDiasParaVencimiento(int diasParaVencimiento) {
    this.diasParaVencimiento = diasParaVencimiento;
  }

  public int getDiasParaVencimiento() {
    return diasParaVencimiento;
  }

  @Override
  public String getTipoArticulo() {
    return "Alimenticio";
  }

  @Override
  public String getDetalleEspecifico() {
    StringBuilder s = new StringBuilder();
    s.append("Días restantes para el vencimiento: ")
        .append(getDiasParaVencimiento());
    return s.toString();
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(super.toString()).append("\n[subtipo alimenticio]");

    return s.toString();

  }

}
