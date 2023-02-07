package com.example.data;

import java.util.ArrayList;
import java.util.List;


public class Length extends UnitConvertor {

    public Length(String unit, double value) {
        super(unit, value);
    }

    public final static String[] LENGTHUNITS = {
            "mm","cm","m","inch","ft","yd","km","mile"
    };

    public final static double CONVERSION_FACTORS[][] = {
            {1, 0.1, 0.001, 0.0393701, 0.003280841666667, 0.0010936138888889999563, 1.00000054000010144e-6, 6.213715277778408823e-7},
            {10, 1, 0.01, 0.393701, 0.0328084, 0.0109361, 9.99996984e-6, 6.213693181818e-6},
            {1000, 100, 1, 39.369959999998847877, 3.28084, 1.09361, 0.0001, 0.0006213709999975145},
            {25.4, 2.54, 0.0254, 1, 0.0833333, 0.0277778, 2.540002032e-5, 1.5782840909e-5},
            {304.8, 30.48, 0.3048, 12.00000648, 1, 0.3333335133333, 0.00030480016459196953866, 0.00018939404166664770813},
            {914.40049377590844415, 91.440049377590852941, 0.91440049377590870705,36,3, 1,0.0009144,0.000568182},
            {1e+6, 100000, 1000, 39370.1,3280.841666667, 1093.6138888890002363, 1, 0.62137152777784099289},
            {1.609e+6, 160934, 1609.3400007802, 63360, 5280, 1760, 1.60934, 1}
    };


    public final static int LENGTH = LENGTHUNITS.length;

    public static List<UnitConvertor> init(){
        List<UnitConvertor> list = new ArrayList<>();
        for(int i=0; i<LENGTH; i++){
            UnitConvertor obj = new Length(LENGTHUNITS[i],CONVERSION_FACTORS[4][i]);
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
