package com.llchen.validation;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class PersonForm {

    @NotNull
    // set limit to name character number
    @Size(min = 2, max = 30)
    private String name;

    @NotNull
    @Min(18)
    private Integer age;

    public String toString() {
        return "Person (Name: " + this.name + " , Age: " + this.age + ")";
    }

}
