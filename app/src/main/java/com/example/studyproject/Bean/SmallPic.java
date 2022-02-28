package com.example.studyproject.Bean;

public class SmallPic {
    private String name;
    private int url;

    public String getName() {
        return name;
    }

    public SmallPic setName(String name) {
        this.name = name;
        return this;
    }

    public int getUrl() {
        return url;
    }

    public SmallPic setUrl(int url) {
        this.url = url;
        return this;
    }
    private int type;

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}
