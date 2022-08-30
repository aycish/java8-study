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