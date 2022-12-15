package io.zipcoder.crudapp.model;

import javax.persistence.Entity;

import org.junit.Assert;
import org.junit.Test;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class PersonTest {
    @Test
    public void testClassSignatureAnnotations() {
        Assert.assertTrue(Person.class.isAnnotationPresent(Entity.class));
    }
    @Test
    public void testCreateJson() throws JsonProcessingException {
        ObjectMapper jsonWriter = new ObjectMapper();
        Person person = new Person();
        String json = jsonWriter.writeValueAsString(person);
    }
}
