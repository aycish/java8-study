package me.aycish.junit5;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.RepetitionInfo;
import org.junit.jupiter.api.extension.ParameterContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.aggregator.AggregateWith;
import org.junit.jupiter.params.aggregator.ArgumentsAccessor;
import org.junit.jupiter.params.aggregator.ArgumentsAggregationException;
import org.junit.jupiter.params.aggregator.ArgumentsAggregator;
import org.junit.jupiter.params.converter.ArgumentConversionException;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.converter.SimpleArgumentConverter;
import org.junit.jupiter.params.provider.*;
import org.springframework.beans.factory.annotation.Value;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class JunitAdvancedUsageTest {
    @DisplayName("반복 테스트... ")
    @RepeatedTest(value = 10, name = "{displayName}, {currentRepetition}/{totalRepetitions}")
    void testRepeat(RepetitionInfo repetitionInfo) {
        System.out.println("Repeat.." + repetitionInfo.getCurrentRepetition() + "/"
                + repetitionInfo.getTotalRepetitions());
    }

    @DisplayName("파라미터 테스트")
    @ParameterizedTest(name = "{index}th {displayName}.. count = {0}")
    @ValueSource(strings = {"1", "2", "3"})
    void testParameters(String count) {
        System.out.println(count + "번째 횟수");
    }

    @DisplayName("파라미터 테스트 심화")
    @ParameterizedTest(name = "{index}th {displayName}.. count = {0}")
    @ValueSource(strings = {"1", "2", "3"})
    /* @EmptySource
    @NullSource */
    @NullAndEmptySource
    void testAdvancedParameters(String count) {
        System.out.println(count + "번째 횟수");
    }

    @DisplayName("파라미터 테스트 심화2")
    @ParameterizedTest(name = "{index}th {displayName}.. count = {0}")
    @ValueSource(ints = {1,2,3,4,5,})
    void testAdvancedParameters2(int value) {
        System.out.println(value);
    }

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

    @DisplayName("Csv 테스트")
    @ParameterizedTest
    @CsvSource({"unhee,10", "unheejo,20", "unheeJo,30"})
    void testCsvSource2(@AggregateWith(StudentAggregator.class) Student student){
        System.out.println(" 이름 : " + student.getName() + " 나이 : " + student.getAge());
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
