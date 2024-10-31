# Day 03 (2024.10.31.)

## 목차

* [로또 구입 금액 입력받기](.//day_03.md#로또-구입-금액-입력받기)
* [To do List](./day_03.md#to-do-list)

## [로또 구입 금액 입력받기](./day_03.md#목차)

### Production Code

```java
// Application.java
private static List<Lotto> setLottos() {
    System.out.println("구입금액을 입력해 주세요.");
    String inputValue = Console.readLine();

    try {
        int cost = Integer.parseInt(inputValue);
        return lottoService.issueLotto(cost);
    } catch (IllegalArgumentException exception) {
        if (exception.getClass() == NumberFormatException.class) {
            throw new IllegalArgumentException("[Error] 구입금액의 입력이 올바르지 않습니다. 입력 값: " + inputValue);
        }
        throw exception;
    }
}
```

## [To do List](./day_03.md#목차)

- [x] 로또 발행하기
    - [x] 로또 발급 개수 확인하기
    - [x] 중복되지 않는 6개의 숫자 뽑기
- [ ] 사용자 입력 받기
    - [x] 로또 구입 금액 입력받기
    - [ ] 로또 당첨 번호 입력받기
    - [ ] 로또 보너스 번호 입력받기
- [ ] 로또 당첨 기준 적용하기
- [ ] 로또 당첨 여부 체크하기
- [ ] ~~커스텀 Exception 생성하기~~
- [ ] Enum 정의하기
    - [ ] 로또 당첨 기준 Enum 정의하기
    - [ ] 에러 메시지 Enum 정의하기
- [ ] 수익률 계산하기