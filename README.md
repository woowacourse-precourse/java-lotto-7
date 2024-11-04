# 로또

---

## 구현할 기능 목록

### 입력

- [ ] `readLine()`을 이용하여 입력
    - [ ] 로또 구입 금액
    - [ ] 당첨 번호 **(번호는 쉼표로 구분)**
    - [ ] 보너스 번호

### 입력 예외 처리

- [ ] **[ERROR]로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받기**
- [ ] 아래의 경우 `IllegalArgumentException` 발생
    - [ ] 입력한 로또 구입 금액이 1000으로 나누어 떨어지지 않을 경우
    - [ ] 입력한 당첨 번호가 6개가 아닐 경우
    - [ ] 당첨 번호에 공백이 포함된 경우
    - [ ] 보너스 번호를 입력할 때 공백을 입력한 경우
    - [ ] 입력한 당첨 번호와 보너스 번호 값의 범위가 **1~45**가 아닐 경우

### 로또

- [ ] 로또 한 장의 금액은 1000원
- [ ] 입력한 로또 구입 금액으로 살 수 있는 복권 수 만큼 `pickUniqueNumbersInRange()` 실행
- [ ] `pickUniqueNumbersInRange()`의 실행 결과를 구매한 로또의 결과 목록으로 판단하여 출력
- [ ] 최종 우승자 (단독, 공동) 판정
- [ ] 당첨을 판단하는 기준과 당첨 금액
    ```JSON
    3개 일치 (5,000원)
    4개 일치 (50,000원)
    5개 일치 (1,500,000원)
    5개 일치, 보너스 볼 일치 (30,000,000원)
    6개 일치 (2,000,000,000원)
    ```

### 출력

- [ ] 발행한 로또 수량 및 번호 출력 **(로또 번호는 오름차순으로 출력)**
- [ ] 당첨내역 출력
- [ ] 수익률 출력 **(소수점 둘째 자리에서 반올림)**

### 프로그램 실행 순서

1. 구입 금액 입력
2. 구매 개수 및 구매한 로또의 결과 목록 출력
3. 당첨 번호 입력
4. 보너스 번호 입력
5. 당첨 통계 (당첨 내역 및 수익률) 출력
