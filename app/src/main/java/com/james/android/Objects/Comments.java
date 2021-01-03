package com.james.android.Objects;

public class Comments {
    private String Title;
    private String Description;
    public String GetTitle(){
        return Title;
    }
    public String GetDescription(){
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public void setTitle(String title) {
        Title = title;
    }

}
