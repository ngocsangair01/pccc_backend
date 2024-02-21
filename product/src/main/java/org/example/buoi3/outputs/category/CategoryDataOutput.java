package org.example.buoi3.outputs.category;


public class CategoryDataOutput {
    private Long id;
    private String name;

    public CategoryDataOutput() {
    }

    public CategoryDataOutput(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
