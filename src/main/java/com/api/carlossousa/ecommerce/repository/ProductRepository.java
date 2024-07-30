package com.api.carlossousa.ecommerce.repository;


import com.api.carlossousa.ecommerce.model.product.Product;
import com.api.carlossousa.ecommerce.model.product.ProductMinDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT new com.api.carlossousa.ecommerce.model.product.ProductMinDTO(p.id, p.title, p.shortDescription, " +
            "p.price, p.quantity, p.photoUrl, d) " +
            "FROM Product p LEFT JOIN p.deal d")
    List<ProductMinDTO> findAllProductMinDTOs();

    // Todos os produtos com promoção
    @Query("SELECT new com.api.carlossousa.ecommerce.model.product.ProductMinDTO(p.id, p.title, p.shortDescription, " +
            "p.price, p.quantity, p.photoUrl, d) " +
            "FROM Product p INNER JOIN p.deal d")
    Page<ProductMinDTO> findAllDealOfTheDay(Pageable pageable);

    // Consulta otimizado com todos os dados do produto
    @Query("SELECT p FROM Product p LEFT JOIN FETCH p.deal LEFT JOIN FETCH p.categories LEFT JOIN FETCH p.tags LEFT JOIN FETCH p.attributes ap LEFT JOIN FETCH ap.attribute WHERE p.id = :id")
    Optional<Product> findByIdWithDetails(@Param("id") Long id);

    // Busca páginada pelo nome e pela categoria, casa o parametro de categoria não seja passado a query vai ignorar
    @Query("SELECT new com.api.carlossousa.ecommerce.model.product.ProductMinDTO(p.id, p.title, p.shortDescription, " +
            "p.price, p.quantity, p.photoUrl, d) " +
            "FROM Product p " +
            "LEFT JOIN p.deal d " +
            "INNER JOIN p.categories c " +
            "WHERE UPPER(p.title) LIKE UPPER(CONCAT('%', :name, '%')) " +
            "AND (:category = '' OR c.category = :category)")
    Page<ProductMinDTO> searchByNameProduct(@Param("name") String name, @Param("category") String category, Pageable pageable);

}
