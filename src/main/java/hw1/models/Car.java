package hw1.models;

import enums.Type;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String model;
    @Enumerated(EnumType.STRING)
    private Type body;
    private int power;
    private double price;
    private int year;
}