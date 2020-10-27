package com.shopping.APIautomation.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.sun.istack.internal.NotNull;


import java.io.Serializable;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class apiPojo implements Serializable{

//    private int id;
    private String name;
    private String type;
    private String regular_price;
    private String description;
    private String short_description;
    public apiPojo() {
        super();
    }

//    @NotNull
//    public void setId(int id)
//    {
//        this.id = id;
//    }
//    public int getId()
//    {
//        return id;
//    }
    @NotNull
    public void setname(String name)
    {
        this.name = name;
    }
    public String getname()
    {
        return name;
    }
    @NotNull
    public void settype(String type)
    {
        this.type = type;
    }
    public String gettype()
    {
        return type;
    }
    @NotNull
    public void setregular_price(String regular_price)
    {
        this.regular_price = regular_price;
    }
    public String getregular_price()
    {
        return regular_price;
    }
    @NotNull
    public void setdescription(String description)
    {
        this.description = description;
    }
    public String getdescription()
    {
        return description;
    }
    @NotNull
    public void setshort_description(String short_description)
    {
        this.short_description = short_description;
    }
    public String getshort_description()
    {
        return short_description;
    }


}
