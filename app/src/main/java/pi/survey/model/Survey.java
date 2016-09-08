package pi.survey.model;

import com.google.gson.Gson;

public class Survey {
    private String Name;
    private String Surname;
    private String Middle_Name;
    private int members;

    public Survey() {

    }

    public Survey(String Name, String Surname, String Middle_Name, int members) {
        this.Name = Name;
        this.Surname = Surname;
        this.Middle_Name = Middle_Name;
        this.members = members;
    }


    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public String getMiddle_Name() {
        return Middle_Name;
    }

    public void setMiddle_Name(String middle_Name) {
        Middle_Name = middle_Name;
    }

    public int getMembers() {
        return members;
    }

    public void setMembers(int members) {
        this.members = members;
    }

    public String returnJSON() {
        Gson gson = new Gson();
        return gson.toJson(new Survey(getName(), getSurname(), getMiddle_Name(), getMembers()));
    }
}
