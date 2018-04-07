package com.example.ataher.studygroups.Classes;

/**
 * Created by A.taher on 3/11/2018.
 */

public class College_Class {

    int ID , University_ID;
    String University_Name , Name ;

    public College_Class(int ID, int university_ID, String university_Name, String name) {
        this.ID = ID;
        University_ID = university_ID;
        University_Name = university_Name;
        Name = name;
    }


    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public int getUniversity_ID() {
        return University_ID;
    }

    public void setUniversity_ID(int university_ID) {
        University_ID = university_ID;
    }

    public String getUniversity_Name() {
        return University_Name;
    }

    public void setUniversity_Name(String university_Name) {
        University_Name = university_Name;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
