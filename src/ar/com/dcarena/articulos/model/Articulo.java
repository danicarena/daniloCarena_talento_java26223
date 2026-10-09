package ar.com.dcarena.articulos.model;

public abstract class Articulo {
  private int _codigo;
  private String _nombre;
  private double _precio;
  private Categoria _categoria;

  public Articulo(
      final int codigo,
      final String nombre,
      final double precio,
      final Categoria categoria

  ) {
    this._codigo = codigo;
    this._nombre = nombre;
    this._precio = precio;
    this._categoria = categoria;
  }

  public int getCodigo() {
    return _codigo;
  }

  public void setCodigo(int _codigo) {
    this._codigo = _codigo;
  }

  public Categoria getCategoria() {
    return _categoria;
  }

  public void setCategoria(Categoria _categoria) {
    this._categoria = _categoria;
  }

  public String getNombre() {
    return _nombre;
  }

  public void setNombre(String _nombre) {
    this._nombre = _nombre;
  }

  public double getPrecio() {
    return _precio;
  }

  public void setPrecio(double _precio) {
    this._precio = _precio;
  }

  public abstract String getTipoArticulo();

  public abstract String getDetalleEspecifico();

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("* Código: ").append(getCodigo()).append("\n")
        .append("* Nombre: ").append(getNombre()).append("\n")
        .append("* Precio: ").append(getPrecio()).append("\n")
        .append("* Nombre de la Categoria").append(getCategoria()).append("\n")
        .append("* Tipo de articulo: ").append(getTipoArticulo()).append("\n")
        .append("* Detalle específico: ").append(getDetalleEspecifico()).append("\n");

    return s.toString();
  }

}
