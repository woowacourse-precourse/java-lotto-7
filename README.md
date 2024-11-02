# 로또

## 기능 요구 사항

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

### 구현할 기능 목록

- [x] 로또 구입 금액, 당첨 번호, 보너스 번호 입력 받기 및 검증
    - [x] 로또 구입 금액 입력 받기
    - [x] 당첨 번호 입력 받기
    - [x] 보너스 번호 입력 받기
    - [x] 사용자의 입력 검증
        - [x] 사용자의 입력들이 숫자가 아니면 IllegalArgumentException을 발생시킨다
        - [x] 로또 구입 금액이 너무 크면 IllegalArgumentException을 발생시킨다
        - [x] 로또 구입 금액이 1000원 미만이면 IllegalArgumentException을 발생시킨다
        - [x] 로또 구입 금액이 1000원 단위가 아니면 IllegalArgumentException을 발생시킨다
        - [x] 입력된 당첨 번호의 갯수가 6개가 아니면 IllegalArgumentException을 발생시킨다
        - [x] 입력된 당첨 번호들이 로또 번호 숫자 범위 내에 없으면 IllegalArgumentException을 발생시킨다
        - [x] 보너스 번호가 로또 번호 숫자 범위 내에 없으면 IllegalArgumentException을 발생시킨다

- [x] 발행한 횟수 만큼 로또 발행 및 수량, 번호 출력
    - [x] 무작위 6개의 로또 번호 생성
    - [x] 당첨 번호, 로또 번호, 보너스 번호 저장 및 중복 확인
    - [x] 로또 발행 수 및 결과 오름차순 정렬 출력

- [ ] 결과 출력
    - [x] 당첨 번호와 로또 번호를 비교하여 당첨 내역 계산
    - [x] 수익률 계산
    - [x] 당첨 내역 및 수익률 출력

- [ ] 로또의 흐름 제어를 위한 Controller 구현

- [ ] AssertJ를 통한 기능 테스트
    - [ ] 검증 기능 테스트
    - [ ] 시도 결과 테스트
    - [ ] 로또 결과 테스트
