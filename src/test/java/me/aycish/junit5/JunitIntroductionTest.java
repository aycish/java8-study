package me.aycish.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.condition.*;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assumptions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class JunitIntroductionTest {

    @Test
    @DisplayName("Junit5 도입 테스트")
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

    @Test
    void display_name_test() {
        System.out.println("do nothing");
    }

    @Test
    void assertTest() {
        String string = "Test String";
        int testNumber = 5;
        assertNotNull(string, () -> "문자열이 Null이다.");
        assertEquals(testNumber, 5);
        assertTrue(testNumber > 3);
    }

    @Test
    void assertTest2() {
        String string = "Test String";
        int testNumber = 5;

        // assertAll을 통해 assert들중 어떤것들이 위반되었는지 확인 가능
        assertAll(
                () -> assertNotNull(string, () -> "문자열이 Null이다."),
                () -> assertEquals(testNumber, 4),
                () -> assertTrue(testNumber > 5)
        );
    }

    @Test
    void createStudentTest() {
        String name = "Hana";
        int age = 7;

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> new Student(name, age));
        String message = exception.getMessage();
        assertEquals("나이가 너무 어립니다.", message);

        // 100 milsec을 모두 기다린다.
        assertAll(
                () -> assertTimeout(Duration.ofMillis(100), () -> {
                    new Student(name, age + 5);
                    Thread.sleep(300);
                }),

                // ThreadLocal을 사용하는 경우, 예상치 못한 경우가 발생할 수 있다.
                // Spring transaction을 사용하는 경우, Thread local을 공유하지 않으므로 적용이 안될 수 있다.
                () -> assertTimeoutPreemptively(Duration.ofMillis(100), () -> {
                    new Student(name, age + 3);
                    Thread.sleep(400);
                })
        );
    }

    @Test
    @DisplayName("Assume test")
    void assume_test() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumeTrue("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")));

        // 상기 assume의 조건이 맞지 않기 때문에, 아랫 코드가 무시된다.
        Student student = new Student("unhee", 30);
        assertEquals(student.getAge(),30);
    }

    @Test
    @DisplayName("Assume test2")
    void assume_test2() {
        String test_env = System.getenv("TEST_ENV");
        System.out.println(test_env);
        assumingThat("LOCAL".equalsIgnoreCase(System.getenv("TEST_ENV")), () -> {
            System.out.println("Hwanhee");
            Student student = new Student("hwanhee", 26);
            assertEquals(student.getAge(),26);
        });

        assumingThat(System.getenv("TEST_ENV") == null, () -> {
            System.out.println("Unhee");
            Student student = new Student("unhee", 30);
            assertEquals(student.getAge(),30);
        });
    }

    @Test
    @DisplayName("Check OS test")
    @EnabledOnOs(OS.WINDOWS)
    //@DisabledOnOs(OS.WINDOWS)
    void testOs() {
        System.out.println("Window");
    }

    @Test
    @DisplayName("Check OS test")
    @EnabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    //@DisabledOnJre({JRE.JAVA_8, JRE.JAVA_9, JRE.JAVA_10, JRE.JAVA_11})
    void testJava() {
        System.out.println("Java 8,9,10,11");
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
