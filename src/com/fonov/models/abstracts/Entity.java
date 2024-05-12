package com.fonov.models.abstracts;

public  class Entity {
    protected Double weight;
    protected Integer maxCountOnField;
    protected Integer speed;
    protected Double kgToFullEating;
    protected int healthPercent;



    public Entity(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        this.weight = weight;
        this.maxCountOnField = maxCountOnField;
        this.speed = speed;
        this.kgToFullEating = kgToFullEating;
        this.healthPercent = 100;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getMaxCountOnField() {
        return maxCountOnField;
    }

    public Integer getSpeed() {return speed;}

    public Double getKgToFullEating() {
        return kgToFullEating;
    }
    public int getHealthPercent() {
        return healthPercent;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public void setMaxCountOnField(Integer maxCountOnField) {
        this.maxCountOnField = maxCountOnField;
    }

    public void setSpeed(Integer speed) {
        this.speed = speed;
    }

    public void setKgToFullEating(Double kgToFullEating) {
        this.kgToFullEating = kgToFullEating;
    }
    public void setHealthPercent(int healthPercent) {this.healthPercent = healthPercent;}


}
