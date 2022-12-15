package io.zipcoder.crudapp.service;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.BDDMockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import io.zipcoder.crudapp.CRUDApplication;
import io.zipcoder.crudapp.controller.PersonController;
import io.zipcoder.crudapp.model.Person;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = CRUDApplication.class)
public class PersonServiceTest {
    @MockBean
    private PersonService service;

    private PersonController controller;

    @Before
    public void setup(){
        this.controller = new PersonController(service);
    }


    @Test
    public void testCreate() {
        // Given
        HttpStatus expected = HttpStatus.CREATED;
        Person expectedPerson = new Person(null, null, null);
        BDDMockito
                .given(service.create(expectedPerson))
                .willReturn(expectedPerson);

        // When
        ResponseEntity<Person> response = controller.create(expectedPerson);
        HttpStatus actual = response.getStatusCode();
        Person actualPerson = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedPerson, actualPerson);
    }


    @Test
    public void testShow() {
        // Given
        Long personId = 1L;
        HttpStatus expected = HttpStatus.OK;
        Person expectedPerson = new Person(personId, null, null);
        BDDMockito.
                given(service.show(1L))
                .willReturn(expectedPerson);

        // When
        ResponseEntity<Person> response = controller.show(personId);
        HttpStatus actual = response.getStatusCode();
        Person actualPerson = response.getBody();

        // Then
        Assert.assertEquals(expected, actual);
        Assert.assertEquals(expectedPerson, actualPerson);
    }
}
