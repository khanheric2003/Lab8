package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }
    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus
     one
     */

    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    public void testHasCity() {
        list = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city); // added city

        boolean check = list.hasCity(city);
        assertTrue(check);
    }
    @Test
    public void countCityTest(){
        list = MockCityList();

        // add first city
        list.addCity(new City("Estevan", "SK"));
        // add second city
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city); // added city

        int listSize = list.getCount();

        assertEquals( list.countCities() ,listSize);
    }

    @Test
    void testDeleteCity() {
        list  = MockCityList();
        City city = new City("Charlottetown", "Prince Edward Island");
        list.addCity(city);
        list.deleteCity(city);
        assertEquals(0,list.getCount());
    }

}
