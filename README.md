# java-lotto-precourse

### 구매 금액 입력

- [x] 로또 구매 금액 입력 안내 메시지를 출력한다.
    - `구입금액을 입력해 주세요.`
- [x] 사용자로부터 로또 구매 금액을 입력받는다.
- [x] 사용자 입력을 검증한다.
    - [x] 양의 정수 범위인지 확인한다. 
    - [x] 1,000 단위의 정수인지 확인한다.

### 로또 발행

- [x] 발행할 로또의 개수를 구한다.
- [x] 로또 구매 개수 안내 메시지를 출력한다.
    - `%d개를 구매했습니다.`
- [x] 사용자가 구매요청한 개수만큼 로또를 발행한다.
    - [x] 로또 1개당, 1~45 범위의 중복되지 않는 6개의 숫자를 발행한다.
- [x] 발행한 로또 번호를 출력한다.
    - ```
      [%d, %d, %d, %d, %d, %d]
      [%d, %d, %d, %d, %d, %d]
      ...
      ```

### 당첨 번호 입력

- [x] 당첨 번호 입력 안내 메시지를 출력한다.
    - `당첨 번호를 입력해 주세요.`
- [x] 사용자로부터 로또 당첨 번호를 입력받는다.
- [ ] 사용자 입력을 검증한다.
    - [ ] 1~45 범위의 중복되지 않는 6개 숫자인지 확인한다.

### 보너스 번호 입력

- [x] 보너스 번호 입력 안내 메시지를 출력한다.
    - `보너스 번호를 입력해 주세요.`
- [x] 사용자로부터 보너스 번호를 입력받는다.
- [x] 사용자 입력을 검증한다.
    - [x] 1~45 범위의 정수인지 확인한다.
    - [x] 당첨 번호와 겹치지 않는 숫자인지 확인한다.

### 결과(당첨 내역, 수익률) 계산

- [x] 구매한 로또와 당첨 번호를 비교해 당첨 내역을 계산한다.
    - ```
      [당첨 기준과 금액]

      1등: 6개 번호 일치 / 2,000,000,000원
      2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
      3등: 5개 번호 일치 / 1,500,000원
      4등: 4개 번호 일치 / 50,000원
      5등: 3개 번호 일치 / 5,000원
      ```
- [ ] 사용자의 수익률을 계산한다.
- [ ] 결과 안내 메시지를 출력한다.
    - ```
      당첨 통계
      ---
      ```
- [ ] 등수별 당첨 내역을 출력한다.
    - ```
      3개 일치 (5,000원) - %d개
      4개 일치 (50,000원) - %d개
      5개 일치 (1,500,000원) - %d개
      5개 일치, 보너스 볼 일치 (30,000,000원) - %d개
      6개 일치 (2,000,000,000원) - %d개
      ```
- [ ] 총 수익률을 출력한다.
    - `총 수익률은 %d%입니다.`
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다. 