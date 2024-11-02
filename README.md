# 2주차 미션 - 자동차 경주

## 🤔 1주차 회고

- 2주차의 목표는 readMe 깔끔하게 작성하기, 주석 적게 사용하기, 일급 컬렉션 사용하기, MVC 패턴 적용하기였다.
- 악취가 났던 1주차와는 달리, 만족할만한 퀄리티가 나왔다. 새 집으로 이사한 느낌도 들었다.
- 3주차의 3번째 프로그래밍 요구 사항인 **15라인 넘어가지 않기**와 **else 예약어를 쓰지 않기**도 벌써 달성해냈다!
  > controller의 `run()` 메서드는 15라인을 넘어버렸는데, 어떻게 해결해야 할지 고민해봐야겠다.🤔

  ![이븐하게 익었어요](even.png)
- 이번엔 이븐하게 익었어요

<br>

- 아쉬운 점으로는 테스트를 적극적으로 활용하지 않았다는 점이었다.

## 😠 3주차 목표

- 테스트 도구를 적극 활용하기(다양한 테스트 메서드 활용)
- 단위 테스트만으로 모든 메서드에 대해 **커버리지 100% 달성**하기
    - 단위 테스트 후 통합 테스트 작성하기
- `ReadMe`에 주요 메서드의 기능을 정리하기

## 🤓 2주차 공통 피드백 - 내가 지키지 못한 것

- 변수 이름에 자료형은 사용하지 않는다
  > 변수명에 대한 고민을 조금 더 해보기..
- 테스트를 작성하는 이유에 대해 본인의 경험을 토대로 정리해본다
    - [학습테스트를 통해 JUnit 학습하기.pdf](https://techcourse-storage.s3.ap-northeast-2.amazonaws.com/9b82d8a360c548fcadd14c551dbcbe06)
  > 가장 난이도가 높은 문제라고 생각한다. '아! 이거 때문이지!' 하면서도 다시 테스트에 회의감이 들어버리는 상황이 발생한다..

## 🔍 프로그래밍 요구사항

- 메서드의 길이가 15라인을 넘어가지 않도록, 한 가지 일만 하도록 구현한다.
- `else`, `switch/case` 를 사용하지 않는다.
- `Enum`을 사용한다.
- UI 로직을 제외한 구현 기능에 대해 단위 테스트를 작성한다.

## ✔️ 기능 요구사항

- 랜덤으로 로또를 뽑고 당첨 내역 및 수익률을 확인할 수 있는 로또 발매기
    - 사용자는 로또 구입 금액을 입력 받는다.
        - 구입 금액은 **1000원 단위** 이다.
    - 금액만큼 로또를 발행한다.
        - 1장 당 **1000원**이다.
        - 랜덤값을 뽑을 때는 `pickUniqueNumbersInRange()` 를 활용한다.
          ```text
          // 1에서 45 사이의 중복되지 않은 정수 6개 반환
          Randoms.pickUniqueNumbersInRange(1, 45, 6);
          ```
        - 로또 번호는 오름차순 정렬한다.
    - 당첨 번호 6개와 보너스 번호 1개를 뽑는다.
        - 번호는 중복되지 않는다.
        - 당첨 번호는 쉼표(,)를 기준으로 구분한다.
    - 로또 번호와 당첨 번호를 비교한다.
        - 당첨 내역 및 수익률을 출력한다.
        - 수익률은 소수점 둘째 자리에서 반올림한다.
      ```text
      당첨 기준과 금액
      1등: 6개 번호 일치 / 2,000,000,000원
      2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
      3등: 5개 번호 일치 / 1,500,000원
      4등: 4개 번호 일치 / 50,000원
      5등: 3개 번호 일치 / 5,000원
      ```
    - 예외 상황 시 에러 문구를 출력해야 한다.
        - 에러 문구는 `[ERROR]` 로 시작해야 한다.
        - 잘못된 값을 입력한 경우 `IllegalArgumentException` 을 발생시킨다.
        - 명확한 에러 유형을 처리한다.

## 📜 기능명세서

### 로또 구입 금액 입력

- [x] 로또 구입 금액을 입력 받는다.
- [x] 1000원으로 나누어 떨어지지 않는지 검증한다.
- [x] 처리 가능 범위를 넘어서는 금액인 경우인지 검증한다.
- [x] 잘못된 값을 입력한 경우 에러 메시지를 출력하고 재입력 받는다.
- [x] 입력받은 로또 구입 금액을 저장한다.

### 당첨 번호, 보너스 번호 입력

- [x] 당첨 번호를 입력 받는다.
- [x] 쉼표, 숫자 외의 문자가 있는지 검증한다.
- [x] 쉼표가 잘못 위치한 경우를 검증한다.
- [x] 보너스 번호를 입력 받는다.
- [x] 숫자가 1~45에 속하는지 검증한다.
- [x] 입력받은 당첨 번호를 저장한다.
- [x] 입력받은 보너스 번호를 저장한다.

> 사용자 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 로또 발행

- [ ] 로또 구입 금액으로부터 구입 가능한 로또 개수를 구한다.
- [ ] 로또를 발행한다.
  > 랜덤값을 뽑을 때는 `pickUniqueNumbersInRange()` 를 활용한다.
- [ ] 발행한 로또 정보를 출력한다.

### 당첨 확인

- [ ] 발행한 로또들의 당첨 여부를 확인한다.
- [ ] 당첨 통계를 출력한다.
- [ ] 총 수익률을 출력한다.

### 예외 처리

- [ ] 명확한 유형을 지정하여 각 예외를 처리한다.

## 🎫 주요 메서드 기능

### PurchaseAmountService

- 입력값으로 받은 구매금액을 처리하는 클래스입니다.

| 메서드 명 | 설명                                 |
|:------|:-----------------------------------|
| save  | 로또 구매금액 입력값을 받아 검증, 파싱, 저장을 수행합니다. |

### LotteryMachineModel

- 현실의 발매기와 대응되는 객체로서, 발매에 필요한 데이터들을 저장하고 조회합니다.

| 메서드 명                | 설명                                |
|:---------------------|:----------------------------------|
| insertPurchaseAmount | 구매금액을 저장합니다.(돈을 투입합니다.)           |
| settingWinnerNumber  | 당첨번호를 저장합니다.(새로운 회차의 당첨번호를 뽑습니다.) |

### WinnerNumberService

- 입력값으로 받은 당첨번호를 처리하는 클래스입니다.

| 메서드 명 | 설명                              |
|:------|:--------------------------------|
| save  | 당첨번호 입력값을 받아 검증, 파싱, 저장을 수행합니다. |