package ru.levchenko.service.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.sql.Date;

/**
 * Product pojo mapping via Hibernate
 */
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
    @NotNull(message = "Укажите цену")
    private Integer price;//цена товара
    @Column(name = "name")
    @NotBlank(message = "Укажите название товара")
    private String name;//название товара
    @Column(name = "description")
    @Length(max = 2048, message = "Максимум 2048 символов")
    @NotBlank(message = "Добавьте описание для товара")
    private String description;//описание товара
    //Добавить класс дата для отображенния времени добавления товара
    @Column(name = "file_name")
    private String fileName;//путь к фото товара(добавить отдельную табличку под файлы)
    @Basic
    private Date date;

    @Enumerated(value = EnumType.STRING)
    private State status;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;


}
