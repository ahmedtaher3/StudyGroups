package com.example.ataher.studygroups.Classes;

/**
 * Created by A.taher on 4/3/2018.
 */

public class DataIemClass {
    String ID , Name , Desc , Type , ImageUrl , UserName , UserID , SubjectName , SubjectID , Time , DownloadUrl ;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDesc() {
        return Desc;
    }

    public void setDesc(String desc) {
        Desc = desc;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getSubjectName() {
        return SubjectName;
    }

    public void setSubjectName(String subjectName) {
        SubjectName = subjectName;
    }

    public String getSubjectID() {
        return SubjectID;
    }

    public void setSubjectID(String subjectID) {
        SubjectID = subjectID;
    }

    public String getTime() {
        return Time;
    }

    public void setTime(String time) {
        Time = time;
    }

    public String getDownloadUrl() {
        return DownloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        DownloadUrl = downloadUrl;
    }

    public DataIemClass() {

    }

    public DataIemClass(String ID, String name, String desc, String type, String imageUrl, String userName, String userID, String subjectName, String subjectID, String time, String downloadUrl) {
        this.ID = ID;
        Name = name;
        Desc = desc;
        Type = type;
        ImageUrl = imageUrl;
        UserName = userName;
        UserID = userID;
        SubjectName = subjectName;
        SubjectID = subjectID;
        Time = time;
        DownloadUrl = downloadUrl;
    }
}
