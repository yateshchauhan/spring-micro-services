package com.price.model;

import org.springframework.stereotype.Component;

@Component
public class Price {

    private int max;
    private int min;

    public Price(int max, int min) {
        this.max = max;
        this.min = min;
    }

    @Override
    public String toString() {
        return "Price{" +
                "max=" + max +
                ", min=" + min +
                '}';
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
