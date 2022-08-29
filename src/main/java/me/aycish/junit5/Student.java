package me.aycish.junit5;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student {
    private String name;
    int age;

    public Student(String name, int age) {
        this.name = name;

        if (age < 8) {
            throw new IllegalArgumentException("나이가 너무 어립니다.");
        }
        this.age = age;
    }


}
