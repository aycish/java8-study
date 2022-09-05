package me.aycish.junit5;

import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.api.extension.RegisterExtension;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

// Annotation으로 확장팩을 선언하는 방법, Extension 클래스의 필드들을 원하는 값으로 초기화해줄 수 없다.
// @ExtendWith(FindSlowTestExtension.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class JunitAdvancedUsageTest {

    // 필드에 정의하여, Extension 클래스를 원하는 값으로 초기화 가능
    @RegisterExtension
    static FindSlowTestExtension findSlowTestExtension = new FindSlowTestExtension(10L);
    int valueOfClass = 1;
    @Order(1)
    @DisplayName("반복 테스트... ")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void testRepeat(RepetitionInfo repetitionInfo) throws InterruptedException {
        Thread.sleep(105L);
        System.out.println("Repeat.." + repetitionInfo.getCurrentRepetition() + "/"
                + repetitionInfo.getTotalRepetitions());
    }
    @Order(2)
    @DisplayName("파라미터 테스트")
    @ParameterizedTest(name = "{index}th {displayName}.. count = {0}")
    @ValueSource(strings = {"1", "2", "3"})
    void testParameters(String count) {
        System.out.println(count + "번째 횟수");
    }

    @Order(3)
    @DisplayName("파라미터 테스트 심화")
    @ParameterizedTest(name = "{index}th {displayName}.. count = {0}")
    @ValueSource(strings = {"1", "2", "3"})
    /* @EmptySource
    @NullSource */
    @NullAndEmptySource
    void testAdvancedParameters(String count) {
        System.out.println(count + "번째 횟수");
    }

    @Order(4)
    @DisplayName("파라미터 테스트 심화2")
    @ParameterizedTest(name = "{index}th {displayName}.. count = {0}")
    @ValueSource(ints = {1,2,3,4,5,})
    void testAdvancedParameters2(int value) {
        System.out.println(value);
    }

    @Order(5)
    @DisplayName("명시적 변환 테스트")
    @ParameterizedTest
    @ValueSource(ints = {10, 20, 30, 40, 50})
    void testConvert(@ConvertWith(StudentConverter.class) Student student) {
        System.out.println(" 이름 : " + student.getName() + " 나이 : " + student.getAge());
    }

    @DisplayName("Csv 테스트")
    @ParameterizedTest
    @CsvSource({"unhee,10", "unheejo,20", "unheeJo,30"})
    void testCsvSource(ArgumentsAccessor argumentsAccessor){
        Student student = new Student(argumentsAccessor.getString(0), argumentsAccessor.getInteger(1));
        System.out.println(" 이름 : " + student.getName() + " 나이 : " + student.getAge());
    }

    @Order(6)
    @DisplayName("Csv 테스트2")
    @ParameterizedTest
    @CsvSource({"unhee,10", "unheejo,20", "unheeJo,30"})
    void testCsvSource2(@AggregateWith(StudentAggregator.class) Student student){
        System.out.println(" 이름 : " + student.getName() + " 나이 : " + student.getAge());
    }

    /* instance간 status가 유지되고 있음을 확인할 수 있다. */
    @Order(7)
    @DisplayName("인스턴스 테스트")
    @Test
    void testClassValue() {
        System.out.println("value = " + this.valueOfClass ++);
    }

    @Order(7)
    @DisplayName("인스턴스 테스트2")
    @Test
    @Disabled
    void testClassValue2() {
        System.out.println("value = " + this.valueOfClass ++);
    }

    static class StudentConverter extends SimpleArgumentConverter {
        @Override
        protected Object convert(Object source, Class<?> targetType) throws ArgumentConversionException {
            assertEquals(Student.class, targetType, "Can only integer be age");
            return new Student("UNHEE", Integer.parseInt(source.toString()));
        }
    }

    static class StudentAggregator implements ArgumentsAggregator {
        @Override
        public Object aggregateArguments(ArgumentsAccessor accessor, ParameterContext context) throws ArgumentsAggregationException {
            return new Student(accessor.getString(0), accessor.getInteger(1));
        }
    }
}
