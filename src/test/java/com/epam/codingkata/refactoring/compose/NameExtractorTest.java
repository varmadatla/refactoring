package com.epam.codingkata.refactoring.compose;

import org.testng.annotations.Test;

import java.util.Arrays;

import static org.testng.Assert.*;

public class NameExtractorTest {
    NameExtractor nameExtractor = new NameExtractor();

    @Test
    public void null_name_should_return_empty(){
        assertTrue(nameExtractor.getAllNames(null).isEmpty());
    }

    @Test
    public void empty_name_should_return_empty(){
        assertTrue(nameExtractor.getAllNames("    ").isEmpty());
    }

    @Test
    public void first_name_only_should_return_same_name(){
        assertEquals(nameExtractor.getAllNames("Martin"), Arrays.asList("Martin"));
    }

    @Test
    public void first_and_last_name_should_return_first_and_last_name(){
        assertEquals(nameExtractor.getAllNames("Martin Fowler"), Arrays.asList("Martin", "Fowler"));
    }

    @Test
    public void first_middle_and_last_name_should_return_first_middle_and_last_name(){
        assertEquals(nameExtractor.getAllNames("Mary Elizabeth Smith"), Arrays.asList("Mary", "Elizabeth", "Smith"));
    }
}