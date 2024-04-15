package com.github.margawron.nerdwhacking.polymorphicSerde;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(use = JsonTypeInfo.Id.NONE, include = JsonTypeInfo.As.WRAPPER_OBJECT)
//@JsonSubTypes({
//        @JsonSubTypes.Type(name = "BaseClass", value = BaseClass.class),
//        @JsonSubTypes.Type(name = "DerivedClass", value = DerivedClass.class)
//})
public class BaseClass {
    public final String string;
    public final Integer integer;

    @JsonCreator
    public BaseClass(@JsonProperty("string") String string,
                     @JsonProperty("integer") Integer integer) {
        this.string = string;
        this.integer = integer;
    }
}
