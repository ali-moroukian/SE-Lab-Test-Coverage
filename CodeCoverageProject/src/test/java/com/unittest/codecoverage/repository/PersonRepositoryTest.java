package com.unittest.codecoverage.repository;

import com.unittest.codecoverage.models.Person;
import com.unittest.codecoverage.repositories.PersonRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PersonRepositoryTest {
    private PersonRepository personRepository;

    @BeforeEach
    public void setUp() {
        personRepository = new PersonRepository();
    }

    @Test
    public void testInsert() {
        Person person = new Person();
        Person result = personRepository.insert(person);
        assertEquals(person, result);
    }

    @Test
    public void testInsert_NullPerson() {
        assertThrows(NullPointerException.class, () -> personRepository.insert(null));
    }

    @Test
    public void testUpdate() {
        Person person = new Person();
        assertDoesNotThrow(() -> personRepository.update(person));
    }

    @Test
    public void testUpdate_NullPerson() {
        assertThrows(NullPointerException.class, () -> personRepository.update(null));
    }

    @Test
    public void testDelete() {
        assertDoesNotThrow(() -> personRepository.delete("name"));
    }

    @Test
    public void testDelete_NullName() {
        assertThrows(NullPointerException.class, () -> personRepository.delete(null));
    }

    @Test
    public void testGet() {
        assertNull(personRepository.get("name"));
    }

    @Test
    public void testGet_NullName() {
        assertThrows(NullPointerException.class, () -> personRepository.get(null));
    }
}