package com.example.unitconvertor;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import com.example.data.Area;
import com.example.data.Length;
import com.example.data.Temperature;
import com.example.data.Time;
import com.example.data.UnitConvertor;
import com.example.data.Weight;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {

    final String conversionUnits[][] = {
            {"mm","cm","m","inch","ft","yd","km","mile"},
            {"mm sq.","cm sq.","m sq.", "in sq.", "ft sq","acre","ha"},
            {"mg","g","kg","lb","q","tonne"},
            {"C","F","K"},
            {"ms","sec","min","hour","day"}
    };

    final int standardUnit[] = {4,4,1,0,1};
    final String unitTypes[] = {
            "Length","Area","Weight","Temperature","Time"
    };

    final int[] imageIds = {
            R.drawable.ic_length,
            R.drawable.ic_area,
            R.drawable.ic_weight,
            R.drawable.ic_tempreture,
            R.drawable.ic_time,
    };

    UnitAdapter unitAdapter;
    ListView listView;
    List<UnitConvertor> list;
    Spinner spinnerUnits, spinnerUnitType;
    EditText editTextValue;
    ImageView imageViewUnitType;

    int conversionType  = 0;
    int conversionUnit = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bindComponents();
        initListView();
        initBottomNavigation();
        initSpinner();
        changeConversionType(0);

    }

    protected void bindComponents(){
        listView = findViewById(R.id.list_lengths);
        spinnerUnits = findViewById(R.id.spinner_length);
        editTextValue = findViewById(R.id.edit_text_length_value);
        spinnerUnitType = findViewById(R.id.spinner_unit_type);
        imageViewUnitType = findViewById(R.id.imageView);
        spinnerUnits.setOnItemSelectedListener(this);

        editTextValue.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editTextValue.getText().toString().length() != 0){
                    reloadList(conversionUnits[conversionType][conversionUnit],Double.parseDouble(editTextValue.getText().toString()));
                }
            }
        });
    }

    protected void reloadList(String convertFrom, double value){
        int indexOfUnit = Arrays.asList(conversionUnits[conversionType]).indexOf(convertFrom);
        switch (conversionType){
            case 0:
                list = Length.convertAll(indexOfUnit,Double.parseDouble(editTextValue.getText().toString()),list);
                break;
            case 1:
                list = Area.convertAll(indexOfUnit,Double.parseDouble(editTextValue.getText().toString()),list);
                break;
            case 2:
                list = Weight.convertAll(indexOfUnit,Double.parseDouble(editTextValue.getText().toString()),list);
                break;
            case 3:
                list = Temperature.convertAll(indexOfUnit,Double.parseDouble(editTextValue.getText().toString()),list);
                break;
            case 4:
                list = Time.convertAll(indexOfUnit,Double.parseDouble(editTextValue.getText().toString()),list);
                break;
        }
        unitAdapter = new UnitAdapter(this, (ArrayList<UnitConvertor>) list);
        listView.setAdapter(unitAdapter);
    }

    protected void initListView(){
        list = Length.init();
        unitAdapter = new UnitAdapter(this, (ArrayList<UnitConvertor>) list);
        listView.setAdapter(unitAdapter);
    }

    protected void initSpinner(){

        ArrayAdapter adTypes = new ArrayAdapter(
                this,android.R.layout.simple_spinner_item,
                unitTypes
        );
        adTypes.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinnerUnitType.setAdapter(adTypes);
        spinnerUnitType.setSelection(conversionType);

        spinnerUnitType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                changeConversionType(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }

    protected void changeConversionType(int i){
        ArrayAdapter ad = new ArrayAdapter(
                this,android.R.layout.simple_spinner_item,
                conversionUnits[i]
        );

        changeListView(i);
        ad.setDropDownViewResource( android.R.layout.simple_spinner_dropdown_item);
        spinnerUnits.setAdapter(ad);
        spinnerUnits.setSelection(standardUnit[i]);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(unitTypes[i]);
        imageViewUnitType.setImageResource(imageIds[i]);
        conversionType = i;

    }

    protected void changeListView(int i){
        switch(i){
            case 0:
                list = Length.init();
                break;
            case 1:
                list = Area.init();
                break;
            case 2:
                list = Weight.init();
                break;
            case 3:
                list = Temperature.init();
                break;
            case 4:
                list = Time.init();
                break;
        }

        unitAdapter = new UnitAdapter(this, (ArrayList<UnitConvertor>) list);
        listView.setAdapter(unitAdapter);

    }

    protected void initBottomNavigation(){
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Length ");
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        conversionUnit = i;
        Log.d("", "onItemSelected: "+conversionUnits[conversionType][i]);
        reloadList(conversionUnits[conversionType][i], Double.parseDouble(editTextValue.getText().toString()));
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}