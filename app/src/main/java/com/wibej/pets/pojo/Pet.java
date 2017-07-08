package com.wibej.pets.pojo;

/**
 * Created by tufrac on 6/22/17.
 */

public class Pet {
    private int id;
    private String name;
    private int ranking;
    private int photo;

    public Pet() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRanking() {
        return ranking;
    }

    public String getRankingString(){
        return String.valueOf(ranking);
    }
    public void setRanking(int ranking) {
        this.ranking = ranking;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public Pet(String name, int ranking, int photo) {
        this.name = name;
        this.ranking = ranking;
        this.photo = photo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
