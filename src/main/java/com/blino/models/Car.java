package com.blino.models;

import javax.persistence.*;

/**
 * 03.02.2020
 * Car
 *
 * @author rombyguide 
 * @version v1.0
 */
@Entity
@Table(name = "fix_car")
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String model;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public Car() {
    }

    public Car(Integer id, String model, User owner) {
        this.id = id;
        this.model = model;
        this.owner = owner;
    }
}
