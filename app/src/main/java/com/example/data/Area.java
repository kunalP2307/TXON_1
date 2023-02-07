package com.example.data;

import java.util.ArrayList;
import java.util.List;

public class Area extends UnitConvertor {

    public Area(String unit, double value) {
        super(unit, value);
    }

    public final static String[] LENGTH_UNITS = {
            "mm sq.", "cm sq.", "m sq.", "in sq.", "ft sq", "acre", "ha"
    };

    public final static double CONVERSION_FACTORS[][] = {
            {1, 0.01, 1e-6, 0.00155, 1.076388889e-5, 2.47104887281911052e-10, 9.999980001032298591e-11},
            {100, 1, 1e-4, 0.155, 0.0010763888889, 2.471048872589531542e-8, 2.471048872589531542e-8},
            {1e+6, 10000, 1, 1550, 10.763888889, 0.00024710488725895326341, 9.999980000103230035e-5},
            {645.16, 6.4516, 0.00064516, 1, 0.00694444, 1.59422405877e-7, 6.451595870977968876e-8},
            {92903, 929.0300005169, 0.09290300005169001285, 143.99993807999567252, 1, 2.295683126721693803e-5, 9.290300005169001423e-6},
            {4.047e+9, 4.047e+7, 4046.86, 6272645.5450138, 43560.038507040269906, 1, 10.404686},
            {1e+10, 1e+8, 10000, 1.55e+7, 107638.88889, 2.47105, 1}
    };


    public final static int LENGTH = LENGTH_UNITS.length;

    public static List<UnitConvertor> init(){
        List<UnitConvertor> list = new ArrayList<>();
        for(int i=0; i<LENGTH; i++){
            UnitConvertor obj = new Area(LENGTH_UNITS[i],CONVERSION_FACTORS[4][i]);
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
