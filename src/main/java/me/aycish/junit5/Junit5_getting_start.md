### [태깅과 필터링]

- 테스트 그룹을 만들고, 원하는 테스트 그룹만 테스트를 실행할 수 있는 기능
- @Tag 어노테이션으로 그룹 지정
- run configuration에서 Tag를 지정하여, 특정 태그가 달린 테스트만 실행할 수 있다.
- build tool 설정

```
// gradle

tasks.named('test') {
	useJUnitPlatform {
		excludeTags 'slow'
	}
}

// slow 태그가 붙은 테스트만 실행 -> gradle task에 존재하게된다.
task slowTest(type: Test) {
	useJUnitPlatform {
		includeTags 'fast'
	}
}
```

### [커스텀 태그]

- JUnit5 어노테이션을 조합하여 커스텀 태그를 만들 수 있다.

## 테스트 반복하기

---

### [@RepeatedTest]

- 반복 횟수와 반복할 테스트 이름을 설정할 수 있다.
    - {displayName} : @DisplayName으로 지정한 테스트 이름 참조 가능
    - {currentRepetition} : 현재 반복횟수를 얻어올 수 있음
    - {totalRepetitions} : 총 반복할 횟수를 얻어올 수 있음
- RepetitionInfo 타입의 인자를 받을 수 있다.
    - 현재 반복 횟수, 총 반복할 횟수등을 얻어서 사용 가능


### [@ParameterizedTest]

- 테스트에 여러 다른 매개변수를 대입해가며 반복 실행한다.
    - {displayName} : @DisplayName으로 지정한 테스트 이름 참조 가능
    - {index} : 몇번째 반복했는지를 얻어올 수 있음
    - {arguments} : 몰?루!
    - {0}, {1}, … : @ValueSource에 명시한, 현 테스트에 전달될 Value의 {n} index에 해당하는 value를 참조할 수 있음

### [인자 값들의 소스]

- @ValueSource
- @NullSource, @EmptySource, @NullAndEmptySource
- @EnumSource
- @MethodSource
- @CsvSource
- @CsvFileSource
- @ArgumentSource

### [인자 값 타입 변환]

- 암묵적인 타입 변환
    - [레퍼런스](https://junit.org/junit5/docs/current/user-guide/#writing-tests-parameterized-tests-argument-conversion-implicit) 참고
    - 일반적으로 문자열 타입으로 입력한 자료형을 레퍼런스에 적혀있는 대로 변환은 해준다.
    - 만약, 내가 작성한 클래스로의 형변환을 원한다면 명시적으로 변환해줘야한다.
- 명시적인 타입 변환
    - SimpleArgumentConverter 상속 받은 구현체 제공
    - @ConvertWith 어노테이션으로 구현한 Converter 지정
    - Converter로 구현할 class는 static inner class이거나 public이어야함

### [인자 값 조합]

- ArgumentsAccessor
    - 전달하고자하는 Value들의 index로 어떠한 타입으로 접근할 것인지를 지정하여 테스트 코드에 전달할 수 있음
- 커스텀 Accessor
    - ArgumentsAggregator 인터페이스 구현
    - @argregateWith
    - Converter와 마찬가지로, static inner class이거나 public이어야함