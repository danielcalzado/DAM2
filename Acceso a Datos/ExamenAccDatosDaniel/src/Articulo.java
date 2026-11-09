import java.io.Serializable;

public class Articulo implements Serializable{
	private String articulo;
	private int cantidad;
    private double precio;
    private boolean disponible;

    public Articulo(String articulo, int cantidad, double precio, boolean disponible) {
        this.articulo = articulo;
        this.cantidad = cantidad;
        this.precio = precio;
        this.disponible = disponible;
    }

    public String getArticulo() {
        return articulo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setArticulo(String articulo) {
        this.articulo = articulo;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return "Articulo{" + "articulo=" + articulo + ", cantidad=" + cantidad + ", precio=" + precio + ", disponible=" + disponible + '}';
    }
	
}//fin Articulo
