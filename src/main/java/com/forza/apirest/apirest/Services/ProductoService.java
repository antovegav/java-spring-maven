package com.forza.apirest.apirest.Services;

import com.forza.apirest.apirest.Entities.Producto;
import com.forza.apirest.apirest.Repositories.ProductoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    public List<Producto> obtenerTodosLosProductos(){
        return productoRepository.findAll();
    }

    public Optional<Producto> obtenerProductoPorId(Long id){
        return productoRepository.findById(id);
    }

    public Producto agregarProducto(Producto producto){
        return productoRepository.save(producto);
    }

    public Producto actualizarProducto(Long id, Producto productoActualizado) {
        Producto producto = productoRepository.findById(id).orElseThrow(() -> new RuntimeException("Producto no encontrado"));
        producto.setNombre(productoActualizado.getNombre());
        producto.setPrecio(productoActualizado.getPrecio());
        producto.setDescripcion(productoActualizado.getDescripcion());
        producto.setStock(productoActualizado.getStock());
        return productoRepository.save(producto);
    }

    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }
}
