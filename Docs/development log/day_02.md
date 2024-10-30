# Day 02 (2024.10.30.)

## 목차

* [로또 발행 기능 구현하기](./day_02.md#로또-발행-기능-구현하기)
* [기능 목표 수정](./day_02.md#기능-목표-수정)
* [To do List](./day_02.md#to-do-list)


<br>

## [로또 발행 기능 구현하기](./day_02.md#목차)

### Production Code

```java
private static final int START_INCLUSIVE = 1;
private static final int END_INCLUSIVE = 45;
private static final int LOTTO_NUMBER_COUNT = 6;

public List<Lotto> issueLotto(int cost) {
    int lottoCount = issueLottoCount(cost);
    List<Lotto> issueLottos = new ArrayList<>();

    for (int i = 0; i < lottoCount; i++) {
        issueLottos.add(generateLotto());
    }

    return issueLottos;
}

private Lotto generateLotto() {
    return new Lotto(Randoms.pickUniqueNumbersInRange(START_INCLUSIVE, END_INCLUSIVE, LOTTO_NUMBER_COUNT));
}
```

<br>

### Test Code

```java
@Test
void 로또_발행_테스트() {
    int cost = 8000;
    assertEquals(cost / lottoService.getLottoCost(), lottoService.issueLotto(cost).size());
}
```

<br>

## [기능 목표 수정](./day_02.md#목차)

현재 프로젝트의 요구사항 중 하나로,<br>
```IllegalArgumentException```, ```IllegalStateException``` 등과 같은 명확한 유형을 처리하는 것이 있었다.
<br>
Custom한 Exception을 반환할 경우, 요구사항을 체크하는 데에 어려움이 있을 것이라 판단하여 **에러 메시지 Enum을 생성**하는 것으로 수정한 후 다시 고려하기로 했다.


## [To do List](./day_02.md#목차)

- [x] 로또 발행하기
    - [x] 로또 발급 개수 확인하기
    - [x] 중복되지 않는 6개의 숫자 뽑기
- [ ] 사용자 입력 받기
    - [ ] 로또 구입 금액 입력받기
    - [ ] 로또 당첨 번호 입력받기
    - [ ] 로또 보너스 번호 입력받기
- [ ] 로또 당첨 기준 적용하기
- [ ] 로또 당첨 여부 체크하기
- [ ] ~~커스텀 Exception 생성하기~~
- [ ] 에러 메시지 출력하기
- [ ] Enum 정의하기
    - [ ] 로또 당첨 기준 Enum 정의하기
    - [ ] 에러 메시지 Enum 정의하기
- [ ] 수익률 계산하기