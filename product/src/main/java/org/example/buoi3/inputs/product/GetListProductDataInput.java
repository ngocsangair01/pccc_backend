package org.example.buoi3.inputs.product;

public class GetListProductDataInput {
    private String code;
    private String name;
    private String manufacture;
    private String condition;
    private Double priceMin;
    private Double priceMax;
    private Integer page;
    private Integer size;

    public GetListProductDataInput() {
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public Double getPriceMin() {
        return priceMin;
    }

    public void setPriceMin(Double priceMin) {
        this.priceMin = priceMin;
    }

    public Double getPriceMax() {
        return priceMax;
    }

    public void setPriceMax(Double priceMax) {
        this.priceMax = priceMax;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public GetListProductDataInput(String code, String name, String manufacture, String condition, Double priceMin, Double priceMax, Integer page, Integer size) {
        this.code = code;
        this.name = name;
        this.manufacture = manufacture;
        this.condition = condition;
        this.priceMin = priceMin;
        this.priceMax = priceMax;
        this.page = page;
        this.size = size;
    }
}
