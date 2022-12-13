package ru.sber.internship.sidecar.models;

import lombok.Data;

@Data
public class fileClass {
    private String name;
    private String path;
    private String content;



    public fileClass(String name,String path,String content)
    {
        this.name = name;
        this.path = path;
        this.content = content;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPath() {
        return path;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContent() {
        return content;
    }
}
