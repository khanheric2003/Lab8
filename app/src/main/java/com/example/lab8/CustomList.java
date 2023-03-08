package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
    /**
     * This return a sorted list of cities
     * @return
     *    return the sorted list
     */
    public List getCities(){
        List list = cities;
        Collections.sort(list);
        return list;
    }


    public int getCount(){
        return cities.size();
    }

    public void addCity(City city){
        cities.add(city);
    }
    /**
     *  This function count all the cities inside the list
     * @return
     *      return city list size
     */
    public int countCities() {
        return 0;
//        return cities.size();
    }


    /**s
     *  This function check whether city belong in the List
     * @param city
     * @return
     *      return boolean whether the city inside cityList
     */
    public boolean hasCity(City city) {
        if(cities.contains(city)) {return true;}
        else {return false;}
    }


}
