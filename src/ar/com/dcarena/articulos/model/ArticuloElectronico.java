package ar.com.dcarena.articulos.model;

public class ArticuloElectronico extends Articulo {
  private int garantiaMeses = 0;

  public ArticuloElectronico(int codigo, String nombre, double precio, Categoria categoria, int garantiaMeses) {
    super(codigo, nombre, precio, categoria);
    this.garantiaMeses = garantiaMeses;
  }

  public void setGarantiaMeses(int garantiaMeses) {
    this.garantiaMeses = garantiaMeses;
  }

  public int getGarantiaMeses() {
    return this.garantiaMeses;
  }

  @Override
  public String getTipoArticulo() {
    return "Electrónico";
  }

  @Override
  public String getDetalleEspecifico() {
    StringBuilder s = new StringBuilder();
    s.append("Garantia: ").append(this.getGarantiaMeses()).append(" meses");
    return s.toString();
  }

  public String nroTelMesaDeAyudaParaReclamos() {
    return "0800-123-4567";
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append(super.toString()).append("\n[subtipo electrónico]");
    return s.toString();
  }

}
