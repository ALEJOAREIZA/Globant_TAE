package com.shopping.APIautomation.pojos;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.sun.istack.internal.NotNull;


import java.io.Serializable;

//@JsonInclude(JsonInclude.Include.NON_NULL)
public class apiPojo implements Serializable{

    private int id;

    public apiPojo() {
        super();
    }

    @NotNull
    public void setId(int id)
    {
        this.id = id;
    }
    public int getId()
    {
        return id;
    }



}
