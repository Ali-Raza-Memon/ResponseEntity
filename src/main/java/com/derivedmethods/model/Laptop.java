package com.derivedmethods.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Laptop")
@ToString
public class Laptop {
    @Id
    @GeneratedValue
    private int id;
    private String color;
    private String size;
    private String quality;
    private int quantity;

}
