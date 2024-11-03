# java-lotto-precourse

# 로또 게임

## 개요
로또 게임은 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 확인하고, 수익률을 계산하는 간단한 콘솔 프로그램입니다. 로또 구매부터 당첨 확인, 수익률 계산까지의 흐름을 통해 자바 프로그래밍의 기본적인 예외 처리, 난수 생성, 리스트 관리 등의 기능을 학습할 수 있습니다.

---

## 기능 개요
- **로또 번호 생성**: 1부터 45 사이의 중복되지 않는 숫자 6개를 랜덤으로 생성하여 로또 번호로 사용합니다.
- **당첨 번호 입력**: 당첨 번호와 보너스 번호를 입력받아 사용자가 구매한 로또와 비교합니다.
- **당첨 결과 및 수익률 출력**: 당첨 결과와 당첨 등급별 개수, 그리고 최종 수익률을 소수점 둘째 자리에서 반올림하여 출력합니다.

---

## 입력
1. **로또 구입 금액 입력**
    - 로또 구입 금액을 양수인 1,000원 단위로 입력받으며, 0 이하이거나 1,000원으로 나누어 떨어지지 않는 경우`[ERROR]` 메시지를 출력하고 구입 금액 입력을 다시 받습니다.
    - 예시 입력: `8000`

2. **당첨 번호 입력**
    - 당첨 번호 6개를 쉼표(`,`)로 구분하여 입력받으며, 각 번호는 1에서 45 사이의 숫자여야 합니다. 번호가 중복되거나 6개가 아닌 경우 `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.` 메시지를 출력하고 당첨 번호 입력을 다시 받습니다.
    - 예시 입력: `1,2,3,4,5,6`

3. **보너스 번호 입력**
    - 보너스 번호를 하나 입력받습니다. 보너스 번호는 1에서 45 사이의 숫자여야 하며 당첨 번호와 중복되지 않아야 합니다. 중복되거나 범위를 벗어나면 `[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1에서 45 사이의 숫자여야 합니다.` 메시지를 출력하고 보너스 번호 입력을 다시 받습니다.
    - 예시 입력: `7`

---

## 출력
1. **구입한 로또 내역**
    - 구입한 로또 수량과 각 로또 번호를 오름차순으로 정렬하여 출력합니다.
    - 예시 출력:
      ```
      8개를 구매했습니다.
      [8, 21, 23, 41, 42, 43]
      [3, 5, 11, 16, 32, 38]
      [7, 11, 16, 35, 36, 44]
      ...
      ```

2. **당첨 통계**
    - 구매한 로또 번호와 당첨 번호를 비교하여 당첨 등급별 당첨 수량을 출력합니다.
    - 예시 출력:
      ```
      3개 일치 (5,000원) - 1개
      4개 일치 (50,000원) - 0개
      5개 일치 (1,500,000원) - 0개
      5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
      6개 일치 (2,000,000,000원) - 0개
      ```

3. **수익률**
    - 총 수익률을 소수점 둘째 자리에서 반올림하여 출력합니다.
    - 예시 출력: `총 수익률은 62.5%입니다.`

---

## 기능 목록
- **로또 발행**
    - [x] 사용자가 입력한 금액에 따라 로또를 발행하고, 각 로또 번호를 무작위로 생성합니다.
    - [x] 1에서 45 사이의 중복되지 않는 숫자 6개를 오름차순으로 정렬하여 로또 번호를 구성합니다.

- **당첨 번호 입력**
    - [ ] 사용자가 입력한 당첨 번호 6개와 보너스 번호를 저장하고 유효성을 검증합니다.

- **당첨 내역 계산**
    - [ ] 발행된 로또 번호와 당첨 번호를 비교하여 각 로또의 당첨 등급을 계산합니다.
    - [ ] 등급에 따라 당첨 수량을 저장하고, 각 등급별 당첨 금액을 계산합니다.

- **수익률 계산**
    - [ ] 총 당첨 금액과 구입 금액을 바탕으로 수익률을 계산합니다.

- **예외 처리 및 재입력**
    - [x] 로또 구입 금액이 0 이하인 경우 `[ERROR] 로또 구입 금액은 양수여야 합니다.` 메시지를 출력하고 구입 금액을 다시 받습니다.
    - [x] 로또 구입 금액이 1,000원 단위가 아닌 경우 `[ERROR] 로또 구입 금액은 1,000원 단위여야 합니다.` 메시지를 출력하고 구입 금액 입력을 다시 받습니다.
    - [x] 당첨 번호가 6개가 아닌 경우 또는 각 번호가 1에서 45 사이의 숫자가 아닌 경우 `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.` 메시지를 출력하고 당첨 번호 입력을 다시 받습니다.
    - [ ] 보너스 번호가 1에서 45 사이의 숫자가 아니거나 당첨 번호와 중복되는 경우 `[ERROR] 보너스 번호는 당첨 번호와 중복되지 않는 1에서 45 사이의 숫자여야 합니다.` 메시지를 출력하고 보너스 번호 입력을 다시 받습니다.