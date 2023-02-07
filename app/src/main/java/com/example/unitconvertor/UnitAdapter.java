package com.example.unitconvertor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.data.UnitConvertor;

import java.util.ArrayList;
import java.util.List;

public class UnitAdapter extends BaseAdapter {
    Context context;
    ArrayList<UnitConvertor> unitList;

    public UnitAdapter(Context context, ArrayList<UnitConvertor> unitList){
        this.context = context;
        this.unitList = unitList;
    }

    @Override
    public int getCount() {
        return unitList.size();
    }

    @Override
    public Object getItem(int i) {
        return unitList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.list_item, viewGroup, false);
        }

        UnitConvertor unitConvertor = (UnitConvertor) getItem(i);
        TextView textUnit = view.findViewById(R.id.text_unit);
        TextView textValue = view.findViewById(R.id.text_unit_value);

        textUnit.setText(unitConvertor.getUnit());
        textValue.setText(Double.toString(unitConvertor.getValue()));
        return view;
    }
}
