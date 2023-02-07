package com.example.data;

import java.util.List;

public abstract class UnitConvertor {
    public String unit;
    public double value;

    public UnitConvertor(String unit, double value) {
        this.unit = unit;
        this.value = value;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    //public abstract List<UnitConvertor> convertAll(String unit, double value, List<UnitConvertor> list);

}
