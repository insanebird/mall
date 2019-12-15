package com.entity;

import java.util.ArrayList;
import java.util.List;

public class ProductTend {
    private List<String> name = new ArrayList<>();
    private List<Integer> value = new ArrayList<>();

    public List<String> getName() {
        return name;
    }

    public void setName(List<String> name) {
        this.name = name;
    }

    public List<Integer> getValue() {
        return value;
    }

    public void setValue(List<Integer> value) {
        this.value = value;
    }
}
