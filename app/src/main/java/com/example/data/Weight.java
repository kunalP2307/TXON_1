package com.example.data;

import java.util.ArrayList;
import java.util.List;

public class Weight extends UnitConvertor{

    public Weight(String unit, double value) {
        super(unit, value);
    }
    public final static String[] WEIGHTUNITS = {
            "mg","g","kg","lb","q","tonne"
    };

    public final static double CONVERSION_FACTORS[][] = {
            {1, 0.001, 1e-6, 2.2046e-6, 9.99989739e-9, 1.102300000108e-9},
            {1000, 1, 0.001, 0.00220462, 1e-5,1e-6},
            {1e+6, 1000, 1, 2.20462, 0.01, 0.001},
            {453592, 453.59199986863, 0.453592, 1, 0.00453592, 0.000499999592144799985},
            {1e+8, 100000, 100, 220.462, 1, 0.110231},
            {9.072e+8, 907185, 907.185, 2000.000574, 9.0718500036202, 1}
    };


    public final static int LENGTH = WEIGHTUNITS.length;

    public static List<UnitConvertor> init(){
        List<UnitConvertor> list = new ArrayList<>();
        for(int i=0; i<LENGTH; i++){
            UnitConvertor obj = new Weight(WEIGHTUNITS[i],CONVERSION_FACTORS[2][i]);
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
