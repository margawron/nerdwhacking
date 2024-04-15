package com.github.margawron.nerdwhacking.polymorphicSerde;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class DerivedClass extends BaseClass {
    @JsonCreator
    public DerivedClass(@JsonProperty("string") String string,
                        @JsonProperty("integer") Integer integer) {
        super(string, integer);
    }
}
