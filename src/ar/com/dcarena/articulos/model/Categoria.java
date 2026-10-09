package ar.com.dcarena.articulos.model;

public class Categoria {
  int _codigo;
  String _nombre;
  String _descripcion;

  public Categoria(int codigo, String nombre, String descripcion) {
    setCodigo(codigo);
    setNombre(nombre);
    setDescripcion(descripcion);
  }

  public void setCodigo(int c) {
    this._codigo = c;
  }

  public int getCodigo() {
    return this._codigo;
  }

  public void setDescripcion(String _descripcion) {
    this._descripcion = _descripcion;
  }

  public String getDescripcion() {
    return _descripcion;
  }

  public void setNombre(String _nombre) {
    this._nombre = _nombre;
  }

  public String getNombre() {
    return _nombre;
  }

  @Override
  public String toString() {
    StringBuilder s = new StringBuilder();
    s.append("Categoria {\n")
        .append("codigo=").append(this._codigo).append(",\n")
        .append("nombre=").append(this._nombre).append(",\n")
        .append("descripcion=").append(this._descripcion).append(",\n")
        .append("}");
    return s.toString();
  }

}
