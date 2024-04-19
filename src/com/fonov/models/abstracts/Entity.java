package com.fonov.models.abstracts;

public  class Entity {
    protected   Double weight;
    protected Integer maxCountOnField;
    protected Integer speed;
    protected Double kgToFullEating;

    public Entity(Double weight, Integer maxCountOnField, Integer speed, Double kgToFullEating) {
        this.weight = weight;
        this.maxCountOnField = maxCountOnField;
        this.speed = speed;
        this.kgToFullEating = kgToFullEating;
    }

    public Double getWeight() {
        return weight;
    }

    public Integer getMaxCountOnField() {
        return maxCountOnField;
    }

    public Integer getSpeed() {
        return speed;
    }

    public Double getKgToFullEating() {
        return kgToFullEating;
    }
}
