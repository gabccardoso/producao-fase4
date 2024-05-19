package com.fiap.producao.infrastructure.controllers;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class ProductControllerTest {

//    @Mock
//    private ProductInteractor productInteractor;
//
//    @Mock
//    private ProductDTOMapper productDTOMapper;
//
//    @InjectMocks
//    private ProductController productController;
//
//    @BeforeEach
//    public void setUp() {
//        MockitoAnnotations.initMocks(this);
//    }
//
//    @Test
//    public void testFindByCategory_Success() {
//        // Arrange
//        String categoriaBuscada = "LANCHE";
//        Category category = Category.LANCHE;
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Hamburguer", category, "bem bom", "image.png", 25.00));
//        when(productInteractor.findByCategory(category)).thenReturn(products);
//        when(productDTOMapper.toProductDTO(any())).thenReturn(new ProductDTO());
//
//        // Act
//        ResponseEntity<List<ProductDTO>> responseEntity = productController.findByCategory(categoriaBuscada);
//
//        // Assert
//        assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals(1, responseEntity.getBody().size());
//        verify(productInteractor, times(1)).findByCategory(category);
//    }
//
//    @Test
//    public void testFindByCategory_InvalidCategory() {
//        // Arrange
//        String categoriaBuscada = "INVALIDA";
//
//        // Assert
//        assertThrows(IllegalArgumentException.class, () -> {
//            productController.findByCategory(categoriaBuscada);
//        });
//    }
//
//    @Test
//    public void testBuscarProdutos_Success() {
//        // Arrange
//        List<Product> products = new ArrayList<>();
//        products.add(new Product("Hamburguer", Category.LANCHE, "bem bom", "image.png", 25.00));
//        when(productInteractor.findProducts()).thenReturn(products);
//        when(productDTOMapper.toProductDTO(any())).thenReturn(new ProductDTO());
//
//        // Act
//        ResponseEntity<List<ProductDTO>> responseEntity = productController.buscarProdutos();
//
//        // Assert
//        assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals(1, responseEntity.getBody().size());
//        verify(productInteractor, times(1)).findProducts();
//    }
//
//    @Test
//    public void testEditarProduto_Success() {
//        // Arrange
//        Long id = 1L;
//        ProductDTO productDTO = new ProductDTO();
//        Product product = new Product("Hamburguer", Category.LANCHE, "bem bom", "image.png", 25.00);
//        when(productInteractor.editProduct(id, product)).thenReturn(product);
//        when(productDTOMapper.toProduct(any())).thenReturn(product);
//        when(productDTOMapper.toProductDTO(any())).thenReturn(productDTO);
//
//        // Act
//        ResponseEntity<ProductDTO> responseEntity = productController.editarProduto(productDTO, id);
//
//        // Assert
//        assertEquals(200, responseEntity.getStatusCodeValue());
//        assertEquals(productDTO, responseEntity.getBody());
//        verify(productInteractor, times(1)).editProduct(id, product);
//    }
//
//    @Test
//    public void testCriarProduto_Success() {
//        // Arrange
//        ProductDTO productDTO = new ProductDTO();
//        Long id = 1L;
//        when(productInteractor.createProduct(any())).thenReturn(id);
//
//        // Act
//        ResponseEntity<Long> responseEntity = productController.criarProduto(productDTO);
//
//        // Assert
//        assertEquals(201, responseEntity.getStatusCode().value());
//        assertEquals(id, responseEntity.getBody());
//        verify(productInteractor, times(1)).createProduct(any());
//    }
//
//    @Test
//    public void testDeletarProduto_Success() {
//        // Arrange
//        Long id = 1L;
//
//        // Act
//        ResponseEntity<Void> responseEntity = productController.deletarProduto(id);
//
//        // Assert
//        assertEquals(204, responseEntity.getStatusCodeValue());
//        assertNull(responseEntity.getBody());
//        verify(productInteractor, times(1)).deleteProduct(id);
//    }
}
