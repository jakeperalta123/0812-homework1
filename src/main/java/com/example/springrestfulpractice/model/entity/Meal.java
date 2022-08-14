package com.example.springrestfulpractice.model.entity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

// 使用 Lombok 加入 Getter, Setter, Constructor
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "meals")
public class Meal {
    @Id
    @Column
    private int id;
    @Column
    private String name;
    @Column
    private int price;
    @Column
    private String description;

    @JsonIgnore
    @ManyToMany(mappedBy = "mealList")
    private List<Order> orderList;
}
