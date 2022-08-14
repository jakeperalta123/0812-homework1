package com.example.springrestfulpractice.model.entity;
import com.example.springrestfulpractice.model.entity.Meal;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
// 使用 Lombok 加入 Getter, Setter, Constructor
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="orders")
public class Order {
    @Id
    @Column
    private int seq;

    @Column
    private int totalPrice;

    @Column
    private String waiter;

    @Cascade({
            org.hibernate.annotations.CascadeType.SAVE_UPDATE,
            org.hibernate.annotations.CascadeType.MERGE,
            org.hibernate.annotations.CascadeType.PERSIST,
    })
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "order_meal",
            joinColumns = @JoinColumn(name = "order_seq"),
            inverseJoinColumns = @JoinColumn(name = "meal_id")
    )
    private List<Meal> mealList;
}
