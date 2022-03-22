package com.example.gorestv1.models;

public class StocksModel {

    public int getID(){return id;}
    public String getName(){return name;}
    public String getEmail(){return email;}
    public String getGender(){return gender}
    public String getStatus(){return status;}

    public String generateReport (){return name + "is currently" + status + " you can contact them at "+ email;}

    @Override
    public String toString(){
        return
    }






}
