package com.example.studyproject.Bean;

/**
 * @auther 孙培翔
 * @description:
 * @data :2022/3/1 11:23
 */
public class FLS {
    private String name;
    private boolean checked;
    private int id;

    public String getName() {
        return name;
    }

    public FLS setName(String name) {
        this.name = name;
        return this;
    }

    public boolean isChecked() {
        return checked;
    }

    public FLS setChecked(boolean checked) {
        this.checked = checked;
        return this;
    }

    public int getId() {
        return id;
    }

    public FLS setId(int id) {
        this.id = id;
        return this;
    }
}
