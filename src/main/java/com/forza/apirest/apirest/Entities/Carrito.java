package com.forza.apirest.apirest.Entities;


import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Carrito {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Usuario usuario;

    @ManyToOne
    private Producto producto;

    private int cantidad;
}
