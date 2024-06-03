package com.example.starwarsapi.persistence.entity;

public class Character {
    private Integer id;
    private int height;
    private int mass;
    private int age;
    private Planet planet;
    private Specie specie;
    private String name;

    public Character(Integer id, int height, int mass, int age, Planet planet, Specie specie, String name) {
        this.id = id;
        this.height = height;
        this.mass = mass;
        this.planet = planet;
        this.specie = specie;
        this.name = name;
        this.age = age;
    }

    public Character() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getMass() {
        return mass;
    }

    public void setMass(int mass) {
        this.mass = mass;
    }

    public Planet getPlanet() {
        return planet;
    }

    public void setPlanet(Planet homeworld) {
        this.planet = homeworld;
    }

    public Specie getSpecie() {
        return specie;
    }

    public void setSpecie(Specie specie) {
        this.specie = specie;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

