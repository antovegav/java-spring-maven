package com.forza.apirest.apirest.Controllers;

import java.util.List;
import java.util.Optional;

import com.forza.apirest.apirest.Services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.forza.apirest.apirest.Entities.Producto;
import com.forza.apirest.apirest.Repositories.ProductoRepository;


@RestController
@RequestMapping("/productos")
public class ProductoController {

    //rutea facilmente desde el repositorio
    @Autowired
    private ProductoService productoService;

    // Muestra una lista con todos los productos
    @GetMapping
    public  List<Producto> obtenerTodosLosProductos(){
        return productoService.obtenerTodosLosProductos();
    }

    // Trae un producto por id
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProductoPorId(@PathVariable Long id){
        Optional<Producto> producto = productoService.obtenerProductoPorId(id);
        return producto.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Hace un POST de la informacion requerida de la entidad producto
    @PostMapping
    public Producto agregarProducto(@RequestBody Producto producto){
        return productoService.agregarProducto(producto);
    }

    // Actualiza los datos del producto
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable Long id, Producto productoActualizado){
        return ResponseEntity.ok(productoService.actualizarProducto(id, productoActualizado));
    }

    // Eliminar un producto por id
    @DeleteMapping ResponseEntity<Void> eliminarProducto(@PathVariable Long id){
        productoService.eliminarProducto(id);
        return ResponseEntity.noContent().build();
    }
//
//    @Autowired
//    private ProductoRepository productoRepository;
//
//
//    @GetMapping
//    public List<Producto> getAllProducto(){
//        return productoRepository.findAll();
//    }
//
//
//    @GetMapping("/{id}")
//    public Producto getProductoById(@PathVariable Long id){
//        return productoRepository.findById(id)
//        .orElseThrow(() -> new RuntimeException("No se encontro el ID del producto" + id));
//    }
//
//
//
//    @PostMapping
//    public Producto createProducto(@RequestBody Producto producto){
//        return productoRepository.save(producto);
//    }
//
//
//    @PutMapping("/{id}")
//    public Producto updateProducto(@PathVariable Long id, @RequestBody Producto detailsProducto){
//        Producto producto = productoRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("No se encontro el ID del producto" + id));
//
//        producto.setNombre(detailsProducto.getNombre());
//        producto.setPrecio(detailsProducto.getPrecio());
//        // Actualiza la bd
//        return productoRepository.save(producto);
//    }
//
//
//    @DeleteMapping("/{id}")
//    public String deleteProducto(@PathVariable Long id){
//        Producto producto = productoRepository.findById(id)
//            .orElseThrow(() -> new RuntimeException("No se encontro el ID del producto" + id));
//
//        productoRepository.delete(producto);
//        return "El producto con ID: " + id + " fue eliminado correctamente";
//    }
}

