
## 1. 함수형 인터페이스와 람다 표현식

### 함수형 인터페이스

#### 정의
- 추상 메서드를 딱 하나만 가지고 있는 인터페이스
- Single Abstract Method 인터페이스
  
#### 특징
- @FunctionalInterface 어노테이션을 붙여, 함수형 인터페이스임을 표시한다.
  - @FunctionalInterface 어노테이션은 해당 인터페이스가 함수형 인터페이스 조건에 맞는지 검사해 준다.
  - 이 어노테이션이 필수는 아니지만, 인터페이스 검증과 유지보수를 위해 붙여주는것이 좋다.
- default method, static method가 여러개 존재해도 된다.

### 람다 표현식

#### 특징
- 함수형 인터페이스의 인스턴스를 만드는 방법으로 사용될 수 있다.
- 코드를 줄여, 가독성을 높일 수 있다.
- 메서드 매개변수, 리턴 타입, 변수로 만들어 사용할 수도 있다.
- (중요) 동작(메서드)를 파라미터로 넘겨줄 수 있어, 가독성 및 코드 생산성을 높일 수 있다.

#### 자바에서 함수형 프로그래밍

- 함수를 First class object로 사용할 수 있다.
- 순수 함수이다.
  - 함수 밖에 있는 값을 변경시키지 않아 사이드 이펙트가 없다.
  - 함수 밖에 있는 값을 사용하지 않으므로, 상태가 존재하지 않는다. 
- 고차 함수이다.
  - 함수가 함수를 매개변수로 받을 수 있고, 함수를 리턴할 수도 있다.
- 불변성을 지닌다.

### 자바에서 제공하는 함수형 인터페이스

#### 종류

- Function <T,R>
- BiFunction <T,U,R>
- Consumer <T>
- Supplier <T>
- Predicate <T>
- UnaryOperator <T>
- BinaryOperator <T>

#### Function <T,R>

- T 타입을 input으로, R 타입의 output을 리턴하는 함수 인터페이스
- R apply(T t) 제공
- 조합용 메서드로 andThen, compose 사용 가능

#### BiFunction <T, U, R>

- 두 개의 값(T,U)를 받아서 R타입을 리턴하는 함수 인터페이스
- R apply(T t, U u) 제공

#### Consumer <T>

- T타입을 받아서 아무 값도 리턴하지 않는 함수 인터페이스
- void Accept(T t) 제공
- 조합용 메서드로 andThen 사용 가능

#### Supplier <T>

- T 타입의 값을 제공하는 함수 인터페이스
- T get() 제공

#### Predicate<T>

- T 타입을 받아서 boolean을 반환하는 함수 인터페이스
- boolean test(T t) 제공
- 조합용 메서드로 And, Or, Negate 사용 가능

#### UnaryOperator <T>

- Function <T, R>의 특수한 형태로, 입력값 하나를 받아서 동일한 타입을 반환하는 인터페이스

#### BinaryOperator <T>

- BiFunction <T, U, R>의 특수한 형태로, 동일한 타입의 입력값 두개를 받아 리턴하는 함수 인터페이스

