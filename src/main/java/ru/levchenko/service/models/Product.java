package ru.levchenko.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;//уникальный id товара
    @Column(name = "price")
    private Integer price;//цена товара
    @Column(name = "name")
    private String name;//название товара
    @Column(name = "description")
    private String description;//описание товара
    //Добавить класс дата для отображенния времени добавления товара
    private String fileName;//путь к фото товара(добавить отдельную табличку под файлы)
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
