package com.example.ataher.studygroups.Classes;

/**
 * Created by A.taher on 3/11/2018.
 */

public class University_Calss {
    int ID ;
    String Name ;

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public University_Calss(int ID, String name) {
        this.ID = ID;
        Name = name;
    }
}
