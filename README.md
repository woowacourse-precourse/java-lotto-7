# 로또

### 🎯 기능 요구 사항
- 로또 번호의 숫자 범위는 1 ~ 45
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자 선택
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등
  - 1등: 6개 일치 / 2,000,000,000원
  - 2등: 5개 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 일치 / 1,500,000원
  - 4등: 4개 일치 / 50,000원
  - 5등: 3개 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행
  - 로또 1장의 가격은 1,000원
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### 🎯 프로그래밍 요구 사항
- indent depth를 최대 2까지
- 3항 연산자 금지
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게. 1개는 15라인을 넘지 않게
- else 쓰지 않기
- Enum 사용
- JUnit 5와 AssertJ를 이용한 단위 테스트 작성

<br><br>

### 🔧 구현할 기능
- [x] 로또 구입 금액 입력 받기
  - [x] 로또 구입 금액 입력받기
  - [x] 1000원 이상 100,000원 이하의 정수가 아니라면 예외
  - [x] 1,000원으로 나누어 떨어지지 않는다면 예외
- [x] 로또 발행
  - [x] 로또를 발행해야 하는 수 계산
  - [x] 로또 발행
  - [x] 로또 번호에 중복된 숫자가 없는지 검사
  - [x] 발행한 로또 번호 출력
- [x] 당첨 번호 입력 받기
  - [x] 쉼표를 기준으로 분리
  - [x] 쉼표 2개 이상이 연속으로 나온다면 무시
  - [x] 1부터 45 사이의 정수가 6개만 들어왔는지 검사
- [x] 보너스 번호 입력 받기
  - [x] 1부터 45 사이의 정수가 아니라면 예외
  - [x] 당첨 번호와 중복 여부 확인
- [x] 당첨 계산
  - [x] 당첨된 개수 세기
  - [x] 보너스 당첨 여부 검사
  - [x] 몇 등에 해당하는지 확인
- [x] 수익률 계산
- [ ] 당첨 통계 출력
