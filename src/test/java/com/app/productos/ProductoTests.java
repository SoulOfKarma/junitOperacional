package com.app.productos;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
public class ProductoTests {

    @Autowired
    private ProductoRepositorio repositorio;

    @Test
    @Rollback(false)
    public void testGuardarProducto(){
        Producto producto = new Producto("Televisor Samsung HD", 3000);
        Producto productoGuardado = repositorio.save(producto);

        assertNotNull(productoGuardado);
    }

    @Test
    @Rollback(false)
    public void testBuscarProductoPorNombre(){
        String nombre = "Televisor Samsung HD";
        Producto producto = repositorio.findByNombre(nombre);

        MatcherAssert.assertThat(producto.getNombre(), CoreMatchers.containsString(nombre));


    }

}
