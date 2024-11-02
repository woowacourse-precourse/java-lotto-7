## 요구 사항 분석
<hr>

- 로또 번호 숫자 범위는 1~45까지다.
- 1개의 로또는 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호는 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.(보너스 번호는 2등을 뽑기위해서만 사용된다.)
  - 1등: 6개 일치(보너스 제외) / 2,000,000,000원
  - 2등: 5개 일치 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 일치(보너스 제외) / 1,500,000원
  - 4등: 4개 일치(보너스 제외) / 50,000원
  - 5등: 3개 일치(보너스 제외) / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행한다.
- 로또 1장은 1000원이다.
- 당첨번호와 보너스 번호를 입력받는다.
  - 당첨번호는 쉼표(,)로 구분한다. 
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 게임을 종료한다.
  - 수익률은 소숫점 둘째 자리에서 반올림한다.(ex. 100.0%, 51.5%, 1,000,000.0%)
  - 로또 번호는 오름차순으로 정렬하여 출력한다.
- 사용자가 잘못된 입력을 할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리


## 기능 구현 목록
<hr>

- [ ] 로또 추첨
    - [ ] 금액에 맞춰 로또 랜덤 생성 기능
    - [ ] 로또 번호(보너스 제외) 6개 추첨
    - [ ] 보너스 번호 추첨
- [ ] 당첨
  - [ ] 일치한 갯수 계산
  - [ ] 당첨금 계산
  - [ ] 당첨된 로또 수량 계산
  - [ ] 총 수익률 계산
- [ ] 입력
    - [ ] 구입 금액 입력
    - [ ] 당첨 번호 입력
      - [ ] 번호는 쉼표(,)로 구분
    - [ ] 보너스 번호 입력
- [ ] 출력
    - [ ] 실행 문구 출력
    - [ ] 금액에 맞춰 생성된 로또 번호 출력
    - [ ] 구매한 로또 갯수 출력
    - [ ] 당첨 번호 입력 요청 문구 출력
    - [ ] 보너스 번호 입력 요청 문구 출력
    - [ ] 당첨 문구 출력
    - [ ] 당첨 통계 출력
    - [ ] 수익률 출력
- [ ] 예외처리
  - [ ] 금액이 최소금액보다 적을 때
  - [ ] 금액에 음수가 입력됐을 때
  - [ ] 금액에 문자나 문자열이 입력됐을 때
  - [ ] 금액에 공백이 입력될 때
  - [ ] 금액이 1000원 단위로 나눠떨어지지 않을 때
  - [ ] 당첨 번호가 1~45 사이가 아닌 양수 값이 입력될 때
  - [ ] 당첨 번호가 음수 일 때
  - [ ] 당첨 번호가 소수가 입력될 때
  - [ ] 당첨 번호에 공백이 입력될 때
  - [ ] 당첨 번호에 문자나 문자열이 입력될 때
  - [ ] 보너스 번호가 1~45 사이가 아닌 양수 값이 입력될 때
  - [ ] 보너스 번호가 소수가 입력될 때
  - [ ] 보너스 번호에 공백이 입력될 때
  - [ ] 보너스 번호에 문자나 문자열이 입력될 때
  - [ ] 보너스 번호가 음수 일 때
  - [ ] 
- [ ] 테스트
  - [ ] 도메인
    - [x] Lotto
      - [x] 로또 번호 개수 검증
      - [x] 로또 번호 범위 검증
      - [x] 중복 번호 검증
    - [ ] Lotto Factory
      - [ ] 로또 번호 생성 검증