package org.iesvalleinclan.storeproduct.controller.impl;

import org.iesvalleinclan.storeproduct.controller.ProductAPI;
import org.iesvalleinclan.storeproduct.controller.constant.EndPointUris;
import org.iesvalleinclan.storeproduct.model.ProductVO;
import org.iesvalleinclan.storeproduct.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/api/v1/products")
public class ProductController implements ProductAPI {

    @Autowired
    private ProductService productService;

    @Override
    @GetMapping
    public List<ProductVO> findAll() {
        return productService.findAll();
    }

    @Override
    @PostMapping
    public ProductVO create(@RequestBody ProductVO city) {
        return productService.create(city);
    }

    /*@PutMapping("/saludo")
    public ResponseEntity<String> holaMundo() {
        return new ResponseEntity<>("Hola Mundo -  prueba 1!", HttpStatus.OK);
    }*/

    /*@PutMapping("/saludo")
    public ResponseEntity<String> holaMundo() {
        return ResponseEntity.ok("Hola Mundo -  prueba 2!");
    }*/

    @PutMapping(EndPointUris.SALUDO)
    public ResponseEntity<String> holaMundo() {
        return new ResponseEntity<>("Hola Mundo -  prueba 1 con URIS!", HttpStatus.OK);
    }

    /*@PutMapping("/{nombre}")
    public ResponseEntity<String> holaMundo(@PathVariable String nombre) {
        return ResponseEntity.ok("Hola " + nombre  + "  prueba 3");
    }*/

    /*@PutMapping("/{nombre}")
    public ResponseEntity<String> holaMundo(@PathVariable String nombre) {
        return new ResponseEntity("Hola " + nombre  + "  prueba 4", HttpStatus.OK);
    }*/

    @PutMapping(EndPointUris.NOMBRE)
    public ResponseEntity<String> holaMundo(@PathVariable String nombre) {
        return new ResponseEntity("Hola " + nombre  + "  prueba 4 con URIS", HttpStatus.OK);
    }

    /*@PutMapping("/{nombre}&{apellidos}")
    public ResponseEntity<String> holaMundo(@PathVariable String nombre, @PathVariable String apellidos) {
        return new ResponseEntity("Hola " + nombre  +  " " + apellidos +  "  prueba 5", HttpStatus.OK);
    }*/

    /*@PutMapping("/{nombre}")
    public ResponseEntity<String> holaMundo(@PathVariable String nombre) {
        String[] nombrearray = nombre.split(",");

        return new ResponseEntity("Hola " + nombrearray[0]  +  " " + nombrearray[1] +  "  prueba 6", HttpStatus.OK);
    }*/

    /*@PutMapping("/{cliente}")
    public ResponseEntity<String> cabeceraPersonalizada(@PathVariable String cliente) {
        HttpHeaders cabecera = new HttpHeaders();
        cabecera.add("Estado Cliente", "Cliente " + cliente + ": habilitado");
        return new ResponseEntity<>("Bienvenido " + cliente, cabecera, HttpStatus.OK);
    }*/

    /*@PutMapping("/{cliente}")
    public ResponseEntity<String> cabeceraPersonalizada(@PathVariable String cliente) {
        return ResponseEntity.ok()
                .header("Estado Cliente", "Cliente " + cliente + ": habilitado")
                .body("Bienvenido cliente: " + cliente);
    }*/

    /*@PutMapping("/{cliente}")
    public ResponseEntity<String> cabeceraPersonalizada(@PathVariable String cliente) {
        return ResponseEntity.status(200)
                .header("Estado Cliente", "Cliente " + cliente + ": habilitado")
                .body("Bienvenido cliente: " + cliente);
    }*/
}