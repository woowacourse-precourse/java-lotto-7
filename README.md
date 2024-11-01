# 🎰🎱로또 미션
## 💡기능 목록 구현하기
## 1. 로또 구입 입력
- [x] 로또 구입 금액을 입력받는 문구 출력
    - `"구입금액을 입력해 주세요."` 문구 출력


- [x] 로또 구입 금액을 입력 받는다.
    - 📢 예외 처리
        - `정수`를 입력받아야한다.
        - 최소금액 : `1,000원` -> 로또 1장의 가격
        - `1,000원 단위`로 떨어져야한다.
---
## 2. 로또 수량 및 번호 출력
- [x] 발행한 로또 수량을 출력한다.
    - `"n개를 구매했습니다."` 형식으로 출력
    - 금액을 `로또 수량`으로 변환하여 출력한다.


- [x] 로또 수량만큼 로또 번호를 출력한다.
    - 예시 형식 : `[8, 21, 23, 41, 42, 43]`
        - 로또 번호는 `오름차순`으로 정렬하여 보여준다.
    - 로또 번호는 `1~45`까지이다.
    - 📢`중복되지 않는` 6개의 숫자를 뽑는다.
    - 컴퓨터가 로또 수량만큼 `랜덤 로또를 생성`한다.
---
## 3. 당첨 번호 입력
- [x] 당첨 번호를 입력하라는 문구 출력
    - `"당첨 번호를 입력해 주세요."` 문구 출력


- [x] 당첨 번호를 입력 받는다.
    - 예시 형식 : `1,2,3,4,5,6`
        - 번호는 `쉼표(,)`를 기준으로 구분한다.
    - 📢 예외 처리
        - `숫자`로 입력 받아야 한다.
        - `6개`의 숫자를 입력 받아야 한다.
        - `중복`이 있어서는 안된다
        - 숫자의 범위는 `1~45` 사이여야 한다.
        - `","`가 아닌 다른 기호가 있으면 안된다.
---
## 4. 보너스 번호 입력
- [x] 보너스 번호를 입력하라는 문구 출력
    - `보너스 번호를 입력해 주세요.` 문구 출력


- [x] 보너스 번호를 입력 받는다.
    - 예시 형식 : `7`
    - 📢 예외 처리
        - `숫자`로 입력 받아야 한다.
        - 당첨번호와 `중복`이 있어서는 안된다
        - 숫자의 범위는 `1~45` 사이여야 한다.
---
## 5. 최종 결과
- [ ] 당첨 통계 문구를 출력한다.
    - `"당첨 통계"`
    - `"---"`


- [ ] 최종 결과를 계산하고 출력한다.
    - 에시 형식 :
  ```
    3개 일치 (5,000원) - 1개
    4개 일치 (50,000원) - 0개
    5개 일치 (1,500,000원) - 0개
    5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
    6개 일치 (2,000,000,000원) - 0개
    총 수익률은 62.5%입니다.
  ```
    - 컴퓨터가 생성한 `랜덤 로또`와 사용자가 입력한 `로또`의 `일치하는 숫자 갯수`를 구한다
    - `보너스 번호`가 포함되었는지 여부를 구한다.
    - `일치하는 갯수`와 `보너스 포함` 조건에 일치하는 사용자의 `등수`를 확인한다
    - 사용자가 당첨된 `등수`의 총 갯수를 구한다.
    - `수익률`을 계산한다
        - ( 총 당첨된 금액 / 로또 구입 금액 ) * 100
        - 수익률은 `소수점 둘째 자리`에서 `반올림`한다
    - 에시 형식대로 출력하고 로또 게임 종료
---
# 📢 예외 처리
- [ ] 예외 상황시 에러 문구를 출력해야한다.
    - "[ERROR] ~"로 시작하며 문구 출력


- [ ] 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생
    - `[ERROR]`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리
