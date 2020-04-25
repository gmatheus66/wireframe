package com.example.alunoifpe.wireframe;

public class CardInfo {
    private int resource;
    private String name;
    private  int id;

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CardInfo(int resource, String name) {
        this.resource = resource;
        //this.id = i;
        this.name = name;
    }

    public int getResource() {
        return resource;
    }

    public void setResource(int resource) {
        this.resource = resource;
    }
/**
 *
 * @param resource
 * @param type
 */


}
