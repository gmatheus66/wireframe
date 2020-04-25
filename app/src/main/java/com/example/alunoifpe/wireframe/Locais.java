package com.example.alunoifpe.wireframe;

public class Locais {

   private String name;
   private String resource;
   private String description;


    public Locais(String name, String resource, String description) {
        this.name = name;
        this.resource = resource;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResource() {
        return resource;
    }

    public void setResource(String resource) {
        this.resource = resource;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
