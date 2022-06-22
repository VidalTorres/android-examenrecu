package com.example.examenrecu;

import java.io.Serializable;

public class EntradaProducto implements Serializable {

    private int idProducto;
    private String descripcion;
    private String unidadMedida;
    private float precioCompra;
    private float precioVenta;
    private float cantidadProducto;

    //Constructores

    public EntradaProducto() {
    }

    public EntradaProducto(int idProducto, String descripcion, String unidadMedida, float precioCompra, float precioVenta, float cantidadProducto) {
        this.idProducto = idProducto;
        this.descripcion = descripcion;
        this.unidadMedida = unidadMedida;
        this.precioCompra = precioCompra;
        this.precioVenta = precioVenta;
        this.cantidadProducto = cantidadProducto;
    }

    //Encapsulamiento

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidadMedida() {
        return unidadMedida;
    }

    public void setUnidadMedida(String unidadMedida) {
        this.unidadMedida = unidadMedida;
    }

    public float getPrecioCompra() {
        return precioCompra;
    }

    public void setPrecioCompra(float precioCompra) {
        this.precioCompra = precioCompra;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public float getCantidadProducto() {
        return cantidadProducto;
    }

    public void setCantidadProducto(float cantidadProducto) {
        this.cantidadProducto = cantidadProducto;
    }

    //Funciones
    public float calularPrecioVenta(){
        float venta;
        venta = precioVenta * cantidadProducto;

        return venta;
    }

    public float calcularPrecioCompra(){
        float compra;
        compra = precioCompra * cantidadProducto;

        return compra;
    }

    public float calcularGanancia(){
        float ganancia;
        ganancia = calularPrecioVenta() - calcularPrecioCompra();
        return ganancia;
    }
}
