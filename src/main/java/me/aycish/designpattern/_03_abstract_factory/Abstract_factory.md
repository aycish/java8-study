## 추상 팩토리 패턴

---

### [정의]

- 인터페이스를 이용하여, 서로 의존하는 객체를 Concrete class를 지정하지 않고도 생성할 수 있게 해주는 패턴
- 다양한 구성 요소 별로 객체의 집합을 생성해야 할 때 유용하다.

### [팩토리 메서드 패턴과 차이점]

- 둘 다 구체적인 객체 생성 과정을 추상화한 인터페이스를 제공한다.
- 관점이 다르다.
    - **팩토리 메소드 패턴**은 “팩토리를 구현하는 방법 (inheritance)”에 초점을 둔다.
    - **추상 팩토리 패턴**은 “팩토리를 사용하는 방법 (composition)”에 초점을 둔다. → 클라이언트 입장
- 목적이 조금 다르다.
    - **팩토리 메소드 패턴**은 구체적인 객체 생성 과정을 하위 또는 구체적인 클래스로 옮기는 것이 목적. 어떤 구체적인 클래스를 필요로 하게 될 지 미리 알 수 없는 경우에 사용한다.
    - **추상 팩토리 패턴**은 관련있는 여러 객체를 구체적인 클래스에 의존하지 않고 만들 수 있게 해주는 것이 목적
- 결합도를 낮추는 대상이 다르다
    - **팩토리 메서드 패턴**은 클라이언트 코드와 인스턴스를 만들어야할 Concrete 클래스를 분리시켜야할 때 사용한다.**(ConcreteProduct ↔ Client)**
    - **추상 팩토리 패턴**은 클라이언트에서 서로 연관된 일련의 제품을 만들어야할 때 사용한다. **(ConcreteFactory ↔ Client)**
- Factory 클래스에서 객체 생성 지원 범위
    - **팩토리 메서드 패턴**은 한 팩토리당 한 종류를 지원한다. (create()메서드가 Factory 클래스에 1개 존재)
    - **추상 팩토리 패턴**은 한 팩토리에서 서로 연관된 여러 종류를 모두 지원한다. (create()메서드가 팩토리 클래스에 여러개)

### [실제 사용 사례]

- 자바 라이브러리
    - javax.xml.xpath.XPathFactory#newInstance()
    - javax.xml.transform.TransformerFactory#newInstance()
    - javax.xml.parsers.DocumentBuilderFactory#newInstance()
- 스프링
    - Factorybean과 그 구현체들