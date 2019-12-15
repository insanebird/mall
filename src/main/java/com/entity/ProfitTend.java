package com.entity;

import java.util.ArrayList;
import java.util.List;

public class ProfitTend {
    private List<Integer> day=new ArrayList<>();
    private List<Double> profit=new ArrayList<>();

    public List<Integer> getDay() {
        return day;
    }

    public void setDay(List<Integer> day) {
        this.day = day;
    }

    public List<Double> getProfit() {
        return profit;
    }

    public void setProfit(List<Double> profit) {
        this.profit = profit;
    }
}
