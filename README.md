# java-lotto-precourse

## 입력

- [x] 구입 금액 입력
- [x] 당첨 번호 입력
- [x] 보너스 번호 입력
- [x] 사용자가 잘못된 값을 입력할 경우, 그 부분부터 입력을 다시 받음

## 출력

- [x] 발행한 로또 수량 및 번호를 출력 (로또 번호는 오름차순으로 정렬)
- [x] 당첨 내역을 형식에 맞게 출력
    - [x] 보너스 볼 일치 여부 출력
- [x] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [x] 예외 상황 시 에러 문구를 출력 ("[ERROR]"로 시작)

## 핵심 기능

- [x] 로또 구입 금액에 따라 로또 발행
- [x] 당첨 번호 추첨
- [x] 보너스 번호 추첨
- [x] 당첨 통계 산출
- [x] 수익률 계산

## 테스트

- 입력된 구입 금액 검증
    - [ ] 정상
    - [x] 예외: 숫자 형식이 아닌 경우
    - [ ] 예외: 음수인 경우
    - [ ] 예외: 1,000원으로 나누어 떨어지지 않는 경우

- 발행된 로또 검증
    - [x] 정상
    - [x] 예외: 1부터 45 사이의 숫자가 아닌 경우
    - [x] 예외: 중복된 숫자가 있는 경우
    - [x] 예외: 숫자가 6개가 아닐 경우

- 입력된 당첨 번호 검증
    - [ ] 정상
    - [x] 예외: ,(comma) 기준으로 구분해 숫자 형식이 아닌 경우
    - [x] 예외: 1부터 45 사이의 숫자가 아닌 경우
    - [x] 예외: 중복된 숫자가 있는 경우
    - [x] 예외: 숫자가 6개가 아닐 경우

- 입력된 보너스 번호 검증
    - [ ] 정상
    - [x] 예외: 숫자 형식이 아닌 경우
    - [x] 예외: 1부터 45 사이의 숫자가 아닌 경우
    - [x] 예외: 당첨 번호와 중복된 숫자인 경우


