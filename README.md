# java-lotto-precourse

## 기능 요구사항

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.


## 입출력 요구사항

입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
- 보너스 번호를 입력 받는다.

출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
- 당첨 내역을 출력한다.
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## 프로그래밍 요구 사항

1. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
2. Java Enum을 적용하여 프로그램을 구현한다.
3. 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.


----------------------

## 기능 목록

- [X] 구입 금액 입력 및 검증
  - [X] 구입 금액 입력 받기
  - [X] 구입 금액 예외 처리
    - [X] 1000원 단위로 나누어떨어지지 않을 경우 오류
    - [X] 숫자형태가 아닐 경우 오류
    - [X] 음수일 경우 오류
    - [X] 0일 경우 오류
    
- [ ] 당첨 번호 입력 및 검증
  - [X] 당첨 번호 입력 받기
  - [ ] 당첨 번호 입력값 예외 처리
    - [ ] 숫자는 1~45 범위
    - [ ] 입력값은 서로 중복되지 않음
    - [ ] 쉼표로 구분된 6개 숫자
    
- [ ] 보너스 번호 입력 및 검증
  - [ ] 보너스 번호 입력 받기
  - [ ] 보너스 번호 예외 처리
    - [ ] 숫자는 1~45 범위
    - [ ] 당첨 번호와 중복되지 않아야 함

- [ ] 로또 번호 발행
  - [ ] 구입 금액에 따라 로또 갯수 계산
  - [ ] 로또 번호 생성
    - [ ] 숫자 1~45 범위에서 난수 생성
    - [ ] 중복되지 않는 6개의 숫자 생성
    - [ ] 오름차순으로 정렬

- [ ] 결과 분석
  - [ ] 사용자가 구매한 로또 번호와 당첨 번호 비교
  - [ ] 당첨 내역 계산
    - [ ] 1~5등 구분
  - [ ] 수익률 계산
    - [ ] 소수점 둘째 자리에서 반올림

- [ ] 결과 출력
  - [ ] 구매한 로또 번호 출력 (오름차순 정렬)
  - [ ] 당첨 내역 출력
  - [ ] 수익률 출력

- [ ] 예외 상황 에러 문구 출력
  - [ ] 입력 오류 시 [ERROR] 메시지 출력
