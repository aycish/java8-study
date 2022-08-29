package me.aycish.junit5;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class JunitIntroductionTest {

    @Test
    void introduce() {
        String string = "Test String";
        assertNotNull(string);
        System.out.println("introduce");
    }

    @Test
    @Disabled
    void introduce2() {
        String string2 = "Test String 2";
        System.out.println(string2);
    }

    @BeforeAll
    static void doBeforeAll() {
        System.out.println("Before all");
    }

    @AfterAll
    static void doAfterAll() {
        System.out.println("After all");
    }

    @BeforeEach
    void doBeforeEach() {
        System.out.println("Before each");
    }

    @AfterEach
    void doAfterEach() {
        System.out.println("After each");
    }
}
