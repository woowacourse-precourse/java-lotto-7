# java-lotto-precourse

## 기능 요구 사항
간단한 로또 발매기를 구현한다.

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

## 입출력 요구 사항
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    "구입금액을 입력해 주세요."
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다
    "당첨 번호를 입력해 주세요."
- 보너스 번호를 입력 받는다.
    "보너스 번호를 입력해 주세요."
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
    8개를 구매했습니다.
    [8, 21, 23, 41, 42, 43]
    [3, 5, 11, 16, 32, 38]
    [7, 11, 16, 35, 36, 44]
    [1, 8, 11, 31, 41, 42]
    [13, 14, 16, 38, 42, 45]
    [7, 11, 30, 40, 42, 43]
    [2, 13, 22, 32, 38, 45]
    [1, 3, 5, 14, 22, 45]
- 당첨 내역을 출력한다.
    당첨 통계
    ---
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
- 수익률은 소수점 둘째 자리에서 반올림한다.
    총 수익률은 62.5%입니다.
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

## 프로그래밍 요구 사항
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다(switch/case도)
- 구현한 기능에 대한 단위 테스트를 작성
- 상수(static final) 사용
- 클래스는 상수, 멤버 변수, 생성자, 메서드 순으로 작성
- 변수 이름에 자료형, 자료 구조 등을 미포함

## 기능 리스트

- [ ] 로또 구매 금액 입력 받기
  - [ ] "구입금액을 입력해 주세요." 출력
  - [ ] 로또 금액 입력 받기
  - [ ] 1000원으로 나누어 떨어지지 않을 때 다시 로또 금액 입력 받기
  - 예외처리
    - [ ] 숫자가 아닌 입력 시(빈칸, 문자) "[ERROR] 숫자만 입력해주세요." 출력
    - [ ] 1000원으로 나누어 떨어지지 않을 때 "[ERROR] 금액이 1000원으로 떨어지지 않습니다.금액을 다시 입력해주세요" 출력
    - [ ] 금액 입력 제한 10만원
- [ ] 당첨 번호 입력 받기
  - [ ] "당첨 번호를 입력해 주세요." 출력
  - [ ] 쉼표(,)로 번호 구분
  - 예외처리
    - [ ] 숫자가 아닌 입력 시(빈칸, 문자) "[ERROR] 숫자만 입력해주세요." 출력
    - [ ] 당첨번호의 개수가 6개가 아닐 때 "[ERROR] 당첨번호의 개수가 6개가 아닙니다." 출력
    - [ ] 45 초과 입력 시 "[ERROR] 1 ~ 45 사이의 숫자만 입력해주세요." 출력
    - [ ] 음수, 0, 소수점 입력 시 "[ERROR] 1 ~ 45 사이의 숫자만 입력해주세요." 출력
- [ ] 보너스 번호 입력
  - [ ] "보너스 번호를 입력해 주세요." 출력
  - 예외처리
    - [ ] 숫자가 아닌 입력 시(빈칸, 문자) "[ERROR] 숫자만 입력해주세요." 출력
    - [ ] 45 초과 입력 시 "[ERROR] 45 이하의 숫자만 입력해주세요." 출력
    - [ ] 음수, 0, 소수점 입력 시 "[ERROR] 1 ~ 45 사이의 숫자만 입력해주세요." 출력
- [ ] 로또 번호 추첨하기
  - [ ] 1~45 중 중복되지 않은 숫자 6개 무작위로 뽑기
  - [ ] 1~45 중, 로또 번호 6개를 제외한 숫자 1개 무작위로 뽑기(보너스)
- [ ] 로또 수량 및 번호 출력
  - [ ] 로또 구매 수량 계산하기
  - [ ] "x개를 구매했습니다." 출력
  - [ ] 로또 구매수량에 맞추어 추첨 번호 출력
- [ ] 당첨 내역 계산하기
  - [ ] 몇개 맞추었는지 확인하기 
  - [ ] 맞춘 개수에 따라 당첨 금액 계산하기  
  - [ ] 수익률 소수점 둘째 자리에서 반올림하여 계산하기
- [ ] 당첨 내역 출력하기 
  - [ ] "당첨 통계 \n ---" 출력
  - [ ] 로또 구매 개수만큼 "x개 일치 (y원) - z개" 출력(0세개마다 쉼표 붙여주기)
  - [ ] "총 수익률은 ${백분율}입니다.%" 출력
