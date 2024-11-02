# 로또

---
### 개요

사용자가 입력한 금액에 따라서 로또를 발매하고
사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하는 프로그램입니다.

---

### 기능 목록

- 구매 금액 입력 처리
    - 입력받은 금액에서 구매 가능한 로또 개수를 계산
    - 입력된 문자열에서 콤마(,)를 제거하는 기능
    - 입력된 문자열을 정수형으로 변환하는 기능
    - 예외 : 구매 금액은 1,000 이상이어야 하며, 1,000으로 나누어떨어지지 않는 경우 예외 발생

---

- 구매 개수만큼 로또 번호 중복 없이 발행
    - 로또 번호는 1 ~ 45 사이의 6개의 숫자
    - 발행한 로또 수량을 출력하고 로또 번호를 오름차순으로 정렬해서 출력

---

- 당첨 번호 및 보너스 번호 입력
    - 당첨 번호는 중복 없이 1 ~ 45 사이의 6개의 숫자 입력
    - 보너스 번호는 당첨 번호와 중복되지 않는 1 ~ 45 사이의 숫자 한 개 입력
    - 예외 : 중복된 번호 입력 시에 예외 처리

---

- 당첨 통계 출력
    - 당첨 내역 출력
    - 당첨금 합산 후 수익률 출력 (소수점 둘째 자리에서 반올림)