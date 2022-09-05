# Junit

## 1. Junit 5소개

---

### [Introduction]

- 자바 개발가자 많이 사용하는 테스팅 프레임워크
- 자바 8이상을 필요로함
- [Junit Guide](https://junit.org/junit5/docs/current/user-guide/)

### [구성]

- Playform : 테스트를 실행해주는 런처 제공. TestEngineAPI 제공
- **Jupiter : TestEngine API 구현체로, JUnit 5를 제공**
- Vintage : JUnit 4와 3을 지원하는 TestEngine 구현체

## 2. JUnit 5 시작하기

---

### [Getting Start]

- 스프링 부트 프로젝트 만들기
- 2.2 + 버전 이상의 스프링 부트 프로젝트는 기본적으로 JUnit5 의존성이 추가됨

```
## Gradle

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter:5.9.0")
}
```

### [기본 어노테이션]

- @Test
- @BeforeAll / @AtferAll
    - 반드시 static void로 선언해야함
- @BeforeEach / @AfterEach
    - static이거나 void일 필요는 없으나, 보통 void 형으로 선언해서 사용
- @Disabled

### [테스트 이름 표기하기]

- @DisplayNameGeneration
    - Method와 Class 레퍼런스를 사용해서 테스트 이름을 표기하는 방법 설정
    - 기본 구현체로 ReplaceUnderScores 제공
- @Display
    - 어떤 테스트인지 테스트 이름을 보다 쉽게 표현할 수 있는 방법을 제공하는 어노테이션
    - @DIsplayNameGeneration보다 우선순위가 높다

### [특징]

- Junit5에서는 리플렉션을 사용하기 때문에, Public 메서드를 명시하지 않아도 사용할 수 있음

## 3. Assertion

---

### [종류]

- assertEqulas(expected, actual) : 실제 값이 기대한 값과 같은지 확인
- assertNotNull(actual) : 값이 null이 아닌지 확인
- assertTrue(boolean) : 다음 조건이 참(true)인지 확인
- assertAll(executables...) : 모든 확인 구문 확인
- assertThrows(expectedType, executable) : 예외 발생 확인
- assertTimeout(duration, executable) : 특정 시간 안에 실행이 완료되는지 확인

### [특징]
- 마지막 매겨변수로 Supplier<String> 타입의 인스턴스를 람다 형태로 제공할 수 있다.
- 만약 복잡한 메세지를 생성해야하는 경우, String 연산이 부담된다면 람다식을 통해 최대한 연산을 줄일 수 있다.
- assertTimeoutPremtively의 경우, Thread Local을 공유하지 않기때문에, Spring transaction등을 사용하는 기능을 테스트할때에는 부적합할 수 있다. (TODO : threadlocal 알아보기)

### [도움을 주는 라이브러리]

- AssertJ
- Hemcrest
- Truth

## 4. 조건 테스트

---

특정한 조건을 만족하는 경우에 테스트를 실행하는 방법

### [사용 법]

import org.junit.jupiter.api.Assumptions.*

- assumeTrue(조건)
    - 특정 조건을 만족하지 않으면, 테스트가 무시된다.
- assumingThat(조건, 테스트)
    - 특정 조건을 만족했을 때, 지정한 동작을 수행하도록 할 수 있다.

### [Enabled와 Disabled]

어노테이션에 기재하여 특정 조건에 맞을 때, 테스트가 실행되도록 제어할 수 있다.

- OnOs
- OnJre
- IfSystemProperty
- IfEnvironmentVariable
- If

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

## 5. 테스트 반복하기

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

## 6. 테스트 인스턴스

---

### [JUnit의 인스턴스]

- JUnit은 테스트 메서드마다 테스트 인스턴스를 새로 만든다.
- 기본적으로 채택한 전략
- 테스트 메서드를 독립적으로 실행하여 예상치 못한 부작용을 방지하기 위함
- 이 전략을 JUnit5에서 변경할 수 있다.

### [변경 방법]

- @TestInstance(Lifecycle.PER_CLASS)
- 테스트 클래스당 인스턴스를 하나만 만들어서 사용한다.
- 경우에 따라, 테스트 간에 공유하는 모든 상태를 @BeforeEach 또는 @AfterEach에서 초기화할 필요가 있다.
- @BeforeAll과 @AfterAll을 인스턴스 메서드 또는 인터페이스에 정의한 default 메서드로 정의할 수도 있다.
- @Before… @After… 시리즈들이 굳이 static일 필요가 없다.
    - 인스턴스를 공유하기 때문!


### [Test의 순서]

- 단위테스트들은 서로간에 독립적이어야 하며, 순서가 바뀌어도 동작할 수 있어야함을 명심하자
- 실행할 테스트 메서드들은 특정한 순서 (ex 선언된 순서)에 따라 실행되지만, 내부 구현 로직에 따라 순서가 변경될 수 있다.

### [Test의 순서 변경]

- @TestInstance(Lifecycle.PER_CLASS)와 함께 @TestMethodOrder를 사용
    - 순서가 중요하다 → 특정 status가 유지되어야 한다. → 테스트 클래스의 인스턴스가 유지되어야 한다.
- MethodOrder 구현체를 설정
    - Alphanumeric
        - deprecated
    - OrderAnnotation
        - @Order (JUnit이 제공) 어노테이션을 사용해 순서를 지정할 수 있다.
        - @Order를 명시하지 않은 테스트 메서드는 최후순위 이다.
        - String.compareTo를 기준으로 순서를 정한다.
    - Random

## 7. JUnit 설정

---

### [junit-paltform.properties]

- JUnit 설정 파일로, 클래스 패스 루트 (src/test/resources)에 위치시키면 적용된다.

### [설정할 수 있는 값]

- 테스트 인스턴스 라이프 사이클 설정
    - junit.jupiter.testinstance.lifecycle.default = per_class
- 확장팩 자동 감지 기능
    - junit.jupiter.extensions.autodetection.enabled = true
- @Disabled 무시하기
    - junit.jupiter.conditions.deactivate = org.junit.*DisabledCondition
- 테스트 이름 표기 전략 설정
- junit.jupiter.displayname.generator.default = \

  org.junit.jupiter.api.DisplayNameGenerator$ReplaceUnderscores

    - @DIsplayName 보다는 우선순위가 낮다


## 8. 확장 모델

---

### [확장 모델]

- JUnit4 : @RunWith(Runner), TestRule, MethodRule.
- JUnit5 : Extension

### [확장팩 등록 방법]

- @ExtendWith
  - Test 클래스 상단에 어노테이션으로 지정
  - 기본 생성자로 생성하기 때문에, Extension 클래스의 필드의 값을 커스터마이징할 수 없다.
- @RegisterExtension
  - 특정 생성자를 정의해두고, static으로 Test 클래스에 선언해 둔 뒤, 생성자를 호출하며 원하는 값으로 필드들을 초기화할 수 있다.
- [ServiceLoader](https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/ServiceLoader.html)
  - JUnit 설정 파일을 통해 설정 가능

### [확장팩 만드는 방법] : [Ref](https://junit.org/junit5/docs/current/user-guide/#extensions) 참고

- 테스트 실행 조건
- 테스트 인스턴스 팩토리
- 테스트 인스턴스 후-처리기
- 테스트 매개변수 resolver
- 테스트 라이프사이클 콜백
- 예외처리
- …


## 9. JUnit5 마이그레이션

---

### [마이그레이션]

- JUnit-vintage-engine을 의존성으로 추가하면, JUnit5의 Junit-platform으로 JUnit 3과 4로 작성된 테스트를 실행할 수 있다.
- @Rule은 기본적으로 지원하지 않지만, junit-jupiter-migrationsupport 모듈이 제공하는 @EnableRuleMigrationSupport를 사용하면 여러 Rule 타입을 지원한다.
  - ExternalResource
  - Verifier
  - ExpectedException
- Spring boot를 사용한다면 기본적으로 vintage-engine이 포함되어 있지 않기 때문에, 추가해줘서 사용해야한다.

### [JUnit5 vs JUnit4]

| JUnit5 | JUnit4 |
| --- | --- |
| @Tag(String) | @Category(Class) |
| @ExtendWith, @RegisterExtension | @RunWith, @Rule, @ClassRule |
| @Disabled | @Ignore |
| @BeforeEach, @AfterEach, @BeforeAll, @AfterAll | @Before, @After, @BeforeClass, @AfterClass |