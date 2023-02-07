package com.example.data;

import java.util.ArrayList;
import java.util.List;

public class Temperature extends UnitConvertor{
    public Temperature(String unit, double value) {
        super(unit, value);
    }

    public final static String[] LENGTH_UNITS = {
            "C","F","K"
    };

    public final static int LENGTH = LENGTH_UNITS.length;

    public static List<UnitConvertor> init(){
        List<UnitConvertor> list = new ArrayList<>();
        list.add(new Temperature("C",1));
        list.add(new Temperature("F",33.8));
        list.add(new Temperature("K",274.15));
        return list;
    }

    public static List<UnitConvertor> convertAll(int unit, double value, List<UnitConvertor> list){
        switch(unit){
            case 0:
                list.get(0).setValue(value);
                list.get(1).setValue((value * 1.8) + 32);
                list.get(2).setValue(value + 273.15);
                break;
            case 1:
                list.get(0).setValue((list.get(0).getValue() - 32) * 5/9);
                list.get(1).setValue(value);
                list.get(2).setValue((value - 32) * (5/9) + 273.15);
                break;
            case 2:
                list.get(0).setValue(value - 273.15);
                list.get(1).setValue((value - 273.15) * (9/5) + 32);
                list.get(2).setValue(value);
                break;
        }
        return list;
    }

}
