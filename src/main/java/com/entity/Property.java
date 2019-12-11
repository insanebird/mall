package com.entity;

import java.util.List;

public class Property {
    private int propertyId;
    private String propertyName;
    private int propertyCategoryId;
    private List<PropertyItem> values;

    public List<PropertyItem> getValues() {
        return values;
    }

    public void setValues(List<PropertyItem> values) {
        this.values = values;
    }

    public int getPropertyId() {
        return propertyId;
    }

    public void setPropertyId(int propertyId) {
        this.propertyId = propertyId;
    }

    public String getPropertyName() {
        return propertyName;
    }

    public void setPropertyName(String propertyName) {
        this.propertyName = propertyName;
    }

    public int getPropertyCategoryId() {
        return propertyCategoryId;
    }

    public void setPropertyCategoryId(int propertyCategoryId) {
        this.propertyCategoryId = propertyCategoryId;
    }
}
