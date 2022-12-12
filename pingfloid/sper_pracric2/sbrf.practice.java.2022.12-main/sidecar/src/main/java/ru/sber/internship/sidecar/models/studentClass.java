package ru.sber.internship.sidecar.models;

import lombok.Data;

@Data
public class studentClass {

    private String name;
    private String groupe;
    private String avarageScore;

    public String getName() {
        return name;
    }

    public String getAvarageScore() {
        return avarageScore;
    }

    public String getGroupe() {
        return groupe;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAvarageScore(String avarageScore) {
        this.avarageScore = avarageScore;
    }

    public void setGroupe(String groupe) {
        this.groupe = groupe;
    }
}
