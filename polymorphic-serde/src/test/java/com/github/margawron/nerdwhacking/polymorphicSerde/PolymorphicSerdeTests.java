package com.github.margawron.nerdwhacking.polymorphicSerde;

import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PolymorphicSerdeTests {

    private static final String DERIVED_CLASS_STRING = "<DerivedClass><string>asdf</string><integer>123</integer></DerivedClass>";


    private final XmlMapper xmlMapper = new XmlMapper();

    @Test
    void shouldCorrectlyParseBeanToXml(){
        BaseClass baseClass = new BaseClass("asdf", 123);
        String parsedBaseClass = Assertions.assertDoesNotThrow(() -> xmlMapper.writeValueAsString(baseClass));
        Assertions.assertEquals("<BaseClass><string>asdf</string><integer>123</integer></BaseClass>", parsedBaseClass);
    }

    @Test
    void shouldCorrectlySerializeToDerivedClass() {
        BaseClass baseClass = Assertions.assertDoesNotThrow(() -> xmlMapper.readValue(DERIVED_CLASS_STRING, BaseClass.class));
        BaseClass derivedClass = Assertions.assertDoesNotThrow(() -> xmlMapper.readValue(DERIVED_CLASS_STRING, DerivedClass.class));
        Assertions.assertEquals("asdf", baseClass.string);
        Assertions.assertEquals("asdf", derivedClass.string);
    }
}
