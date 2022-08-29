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

```java
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