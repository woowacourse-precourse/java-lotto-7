# java-lotto-precourse

## 소개

로또 발매기를 구현하는 프로그램입니다. 구매 금액만큼 로또를 랜덤으로 발행할 수 있습니다. 당첨 번호와 보너스 번호를 입력할 수 있습니다.

로또 한 장의 가격은 1000원이며, 수량이 아닌 금액을 입력하여 구입 금액에 해당하는 만큼 로또를 자동으로 발행합니다.

사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료합니다.

## 기능 정의

1. 로또 발행

- 사용자는 **1,000원** 단위로 로또를 구입할 수 있다.
- 사용자는 **최대 10,000원 어치**의 로또를 구입할 수 있다.
- 로또 하나에는 **1~45 사이의 정수**가 중복되지 않게 **6개** 들어간다.
- 1,000원 단위로 나누어 떨어지지 않는다면 오류를 발생시키고 다시 입력한다.

2. 로또 번호 추첨

- 사용자는 `,`를 이용해서 6개의 당첨 로또 번호를 입력할 수 있다.
    - `,`를 제외한 문자 혹은 1~45 사이의 정수가 아닌 값을 입력 시 오류를 발생시키고 당첨 로또 번호를 다시 입력한다.
    - 당첨 로또 번호가 6개 미만일 시 오류를 발생시키고 당첨 로또 번호를 다시 입력한다.
    - 입력 번호가 중복될 시 오류를 발생시키고 당첨 로또 번호를 다시 입력한다.
- 사용자는 보너스 번호를 입력할 수 있다.
    - 문자 혹은 1~45 사이의 정수가 아닌 값을 입력 시 오류를 발생시키고 보너스 번호를 다시 입력한다.
    - 보너스 번호가 당첨 로또 번호와 중복될 시 오류를 발생시키고 보너스 번호를 다시 입력한다.

3. 로또 통계 및 수익률 출력

- 로또 번호 추첨이 끝나면 점수표의 종류를 순서대로 출력한다.
- 총 수익률을 출력한다.

4. 기타

- **공백**은 프로그램이 자동으로 없앤다. ex) `  1     0 , 5 ,...` -> `10,5,...`

## 구현 기능 목록

### 입력

- [ ] 로또 구입 금액을 입력받는다.
- [ ] 당첨 로또 번호를 입력받는다.
- [ ] 보너스 번호를 입력받는다.
    - [ ] (공통) 공백을 제거한다.

### 로또

- [x] 1~45 사이의 중복되지 않는 6개의 로또 번호를 결정한다.
  - [x] 로또 번호가 6개가 아니라면 오류를 출력한다.
  - [x] 로또 번호가 1~45 사이의 정수가 아니라면 오류를 출력한다.
  - [x] 중복되는 번호가 있다면 오류를 출력한다.

### 발행 로또

- [ ] 로또 구입 금액이 올바른지 확인한다.
    - [ ] 로또 구입 금액이 숫자가 아니라면 오류를 출력한다.
    - [ ] 로또 구입 금액이 1,000원 단위로 나뉘어 떨어지지 않으면 오류를 출력한다.
    - [ ] 로또 구입 금액이 10,000원을 넘으면 오류를 출력한다.
- [ ] 로또를 생성한다.
- [ ] 로또 목록을 반환한다.

### 당첨 로또

- [ ] 당첨 로또 번호가 올바른지 확인한다.
    - [ ] 로또 번호가 1~45 사이의 정수가 아니라면 오류를 출력한다.
    - [ ] 로또 번호가 6개가 아니라면 오류를 출력한다.
    - [ ] 로또 번호가 중복된다면 오류를 출력한다.
- [ ] 보너스 번호가 올바른지 확인한다.
    - [ ] 보너스 번호가 1~45 사이의 정수가 아니라면 오류를 출력한다.
    - [ ] 로또 번호가 당첨 로또 번호와 중복된다면 오류를 출력한다.

### 통계

- [ ] 당첨 통계 정보를 계산한다.
- [ ] 수익률을 계산한다.

### 출력

- [ ] 로또 구입 후 발행된 로또 목록을 출력한다.
- [ ] 번호 추첨 후 통계 및 수익률을 출력한다.

## 예외

- 미정

## 구조

- 미정