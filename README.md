# java-lotto-precourse

## 개요
> 간단한 로또 발매기를 구현한다

## 🎯 학습 목표

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

## 🛠️ 구현 기능 목록

- [ ] 로또 구입 금액을 입력 받는다
  - [ ] 1000원 단위로 입력 받는다
  - [ ] 예외 처리 
    - [ ] 자연수가 아닐 경우
    - [ ] 1000원으로 나누어 떨어지지 않는 경우
  - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시킨다
    - [ ] 에러 메시지를 출력 후 입력을 다시 받는다


- [ ] 구입 금액을 통해 발행할 로또 수량을 구한다


- [ ] 로또 수량 만큼 각각의 로또 번호를 생성한다
  - [ ] 로또 번호의 숫자 범위는 1~45
  - [ ] 1개의 로또를 발행할 때 중복되지 않은 숫자 6개를 뽑는다


- [ ] 로또 수량 만큼 생성한 로또 번호를 출력한다
  - [ ] 로또 번호는 오름차순으로 정렬하여 출력한다


- [ ] 당첨 번호를 입력 받는다
  - [ ] 번호는 쉼표(`,`)를 기준으로 구분한다
  - [ ] 예외 처리
    - [ ] 구분된 부분이 숫자가 아닐 경우
    - [ ] 구분된 숫자의 개수가 6개가 아닐 경우
    - [ ] 구분된 부분의 수가 로또 숫자 범위 (1~45)를 벗어나는 경우
    - [ ] 구분된 부분의 수가 중복되는 경우
  - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시킨다
    - [ ] 에러 메시지를 출력 후 입력을 다시 받는다


- [ ] 보너스 번호를 입력 받는다
  - [ ] 예외 처리
    - [ ] 숫자가 아닐 경우
    - [ ] 로또 숫자 범위 (1~45)를 벗어나는 경우
    - [ ] 당첨 번호와 중복되는 경우
  - [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 발생시킨다
    - [ ] 에러 메시지를 출력 후 입력을 다시 받는다


- [ ] 구매한 로또의 당첨 결과를 확인한다
  - [ ] 각 등수에 해당하는 로또 개수를 업데이트한다


- [ ] 당첨 결과를 통해 수익률을 계산한다


- [ ] 당첨 통계를 출력한다
  - [ ] 당첨 내역을 출력한다
    - [ ] 각 등수에 해당하는 로또가 몇 개인지 모두 출력한다
  - [ ] 총 수익률을 출력한다
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다


## 🔎 프로그래밍 요구 사항

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다 (2까지만 허용)
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다
  - 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만든다
- else 예약어를 쓰지 않는다
- Java Enum을 적용하여 프로그램을 구현한다
- 구현한 기능에 대한 단위 테스트를 작성한다
  - 단, UI(System.out, System.in, Scanner) 로직은 제외한다

## 🌳 프로젝트 구조

```
📦 src
┣ 📂 main
┃ ┗ 📂 java
┃   ┗ 📂 lotto
┃     ┣ 📂 constant
┃     ┃ ┣ 📜 ErrorMessage.java
┃     ┃ ┗ 📜 LottoInfo.java
┃     ┣ 📂 controller
┃     ┃ ┗ 📜 LottoController.java
┃     ┣ 📂 domain
┃     ┃ ┣ 📜 BonusNumber.java
┃     ┃ ┣ 📜 Budget.java
┃     ┃ ┣ 📜 Lotto.java
┃     ┃ ┣ 📜 Purchaser.java
┃     ┃ ┣ 📜 WinningInfo.java
┃     ┃ ┣ 📜 WinningNumbers.java
┃     ┃ ┗ 📜 WinningStatistics.java
┃     ┣ 📂 util
┃     ┃ ┗ 📜 LottoNumbersGenerator.java
┃     ┣ 📂 view
┃     ┃ ┣ 📜 InputMessage.java
┃     ┃ ┣ 📜 InputView.java
┃     ┃ ┣ 📜 OutputMessage.java
┃     ┃ ┗ 📜 OutputView.java
┃     ┗ 📜 Application.java
┗ 📂 test
  ┗ 📂 java
    ┗ 📂 lotto
      ┣ 📂 domain
      ┃ ┣ 📜 BonusNumberTest.java
      ┃ ┣ 📜 BudgetTest.java
      ┃ ┣ 📜 LottoTest.java
      ┃ ┣ 📜 PurchaserTest.java
      ┃ ┣ 📜 WinningInfoTest.java
      ┃ ┣ 📜 WinningNumbersTest.java
      ┃ ┗ 📜 WinningStatisticsTest.java
      ┣ 📂 util
      ┃ ┗ 📜 LottoNumbersGeneratorTest.java
      ┣ 📂 view
      ┃ ┣ 📜 InputMessageTest.java
      ┃ ┗ 📜 OutputMessageTest.java
      ┗ 📜 ApplicationTest.java```