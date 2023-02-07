package com.example.data;

import java.util.ArrayList;
import java.util.List;

public class Time extends UnitConvertor{
    public Time(String unit, double value) {
        super(unit, value);
    }

    public final static String[] LENGTH_UNITS =  {
            "ms","sec","min","hour","day"
    };

    public final static double CONVERSION_FACTORS[][] = {
            {1, 0.001, 1.6667e-5, 2.77783333e-7, 1.1574305541667e-8},
            {1000, 1, 0.0166667, 0.00027777833333, 1.157409722208333465e-5},
            {60000, 60, 1, 0.0166667, 0.00069444583333},
            {3.6e+6, 3600, 60, 1, 0.0416667},
            {8.64e+7, 86400, 1440, 24, 1}
    };


    public final static int LENGTH = LENGTH_UNITS.length;

    public static List<UnitConvertor> init(){
        List<UnitConvertor> list = new ArrayList<>();
        for(int i=0; i<LENGTH; i++){
            UnitConvertor obj = new Time(LENGTH_UNITS[i],CONVERSION_FACTORS[4][i]);
            list.add(obj);
        }
        return list;
    }

    public static List<UnitConvertor> convertAll(int unit, double value, List<UnitConvertor> list){
        for(int i=0; i<LENGTH; i++){
            list.get(i).setValue(value * CONVERSION_FACTORS[unit][i]);
        }
        return list;
    }

}
