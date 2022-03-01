package com.example.studyproject.Bean;

public class SmallPic {
    private String name;
    private int url;
    private int type;

    public int getType() {
        return type;
    }

    public SmallPic setType(int type) {
        this.type = type;
        return this;
    }

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
}
