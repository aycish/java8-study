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