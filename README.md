<aside>


**java-lotto-precourse**

## **❗️ 기능 요구 사항**

---

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
- 사용자가 잘못된 값을 입력할 경우`IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌`IllegalArgumentException`,`IllegalStateException`등과 같은 명확한 유형을 처리한다.

## **📚 구현 기능 목록**

**📌 로또 구입**

- [x] 구입 금액 입력 기능
- [x] 구입 금액에 해당하는 로또 발행 횟수 계산 기능

**📌 로또 발행**

- [x] 발행 횟수 만큼 중복되지 않는 번호 6개(1~45) 추첨 발행 하는 기능

**📌 당첨 번호 & 보너스 번호 생성**

- [ ] 당첨 번호 입력 기능
- [ ] 보너스 번호 입력 기능
- [x] 당첨 번호 저장 기능
- [x] 보너스 번호 저장 기능

**📌 당첨 통계**

- [x] 당첨 결과 계산 기능
    - [x] 당첨 번호 일치 계산 기능
    - [x] 당첨 번호가 5개일 경우, 보너스 번호 포함 확인 기능
        - 해당 기능의 경우, 2등의 개수를 증가 시켜준다.
- [x] 수익률 계산 해주는 기능
- [ ] 당첨 내역 출력 기능
- [ ] 수익률 출력 기능

## **🚫 예외 처리**

- [x] 잘못된 구입 금액 입력 시 예외
    - [x] 음수를 입력 했을 경우
    - [x] 1,000원으로 나누어 떨어지지 않은 수를 입력한 경우

- [x] 당첨 번호 입력 시 예외
    - [x] 중복 되는 수가 있을 경우
    - [x] 당첨 번호가 6개가 아닐 경우
    - [x] 1~45인 정수를 입력하지 않았을 경우

- [x] 보너스 번호 입력 시 예외
    - [x] 1~45인 정수를 입력하지 않았을 경우
    - [x] 당첨 번호에 있는 정수를 입력 했을 경우

</aside>