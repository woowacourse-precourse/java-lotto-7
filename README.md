## 1. 💰 java-lotto 소개 💰
---
```
로또 발매기 프로그램은 사용자에게 구입한 로또 개수만큼 로또 번호를 자동으로 발행해 주고,
당첨 번호 및 보너스 번호와 비교하여 당첨 결과 및 수익률을 제공합니다.
아래 기능 목록을 바탕으로 실제 로또처럼 번호를 추첨하고, 당첨 등수와 상금을 결정합니다.
```
## 2. 📝 java-lotto-precourse 기능 목록 📝
---

### ▪️ 입력 기능

- [] 잘못된 값을 입력 받은 경우 `IllegalArgumentException`을 발생시키고,
  "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력 다시 받기
- [x] 로또 구입 금액 메세지 출력 후 구입 금액 입력 받기
    - [x] 빈 값이 들어온 경우 예외 처리
    - [x] 숫자외 다른 형식의 문자열이 입력된 경우 예외 처리
- [x] 당첨 번호 입력 메세지 출력 후 당첨 번호 받기
    - [x] 빈 값이 들어온 경우 예외 처리
    - [x] 숫자외 다른 형식의 문자열이 입력된 경우 예외 처리
    - [] 번호는 쉼표 기준으로 구분
- [] 보너스 번호 입력 메세지 출력 후 보너스 번호 입력 받기
    - [] 빈 값이 들어온 경우 예외 처리
    - [] 숫자외 다른 형식의 문자열이 입력된 경우 예외 처리

### ▪️ 로또 핵심 기능

- [] 입력 받은 금액으로 총 몇 개의 로또를 구입할 수 있는지 계산하기(개당 1000원)
    - [] 입력 받은 금액이 1000원 단위가 아닐시 예외 처리
    - [] 입력 받은 금액이 100,000원 초과일시 예외 처리
- [] 구입한 로또 개수만큼 로또 발행하기
    - [] 로또 번호 숫자 범위 `1~45`로 제한
    - [] 로또 번호 중복되지 않는 6개의 숫자 랜덤 생성
    - [] 로또 오름차순 정렬
- [] 당첨 번호와 보너스 번호 검증
    - [] 6개 당첨 번호와 1개의 보너스 번호가 중복될 시 예외 처리
    - [] 당첨 번호와 보너스 번호가 `1~45`범위가 아닐시 예외 처리
- [] 당첨 내역 구하기
    - [] 사용자가 구매한 로또 개수만큼 로또 번호와 당첨 번호가 몇 개 일치하는지 비교 하기
- [] 당첨 내역에 따른 수익률 계산
    - [] 당첨된 금액 / 로또 구입 금액
    - [] 소수점 둘째 자리에서 반올림하기

### ▪️ 출력 기능

- [] 로또 수량 출력: `n개를 구매했습니다.`
- [] 구매한 개수만큼 발행한 로또 번호 출력 (번호 오름차순)
    ```
    [8, 21, 23, 41, 42, 43]\n  x구매한 개수만큼
    ```
- [] 당첨 내역(통계) 출력
    ```
    당첨 통계
    ---
    3개 일치 (5,000원) - n개
    4개 일치 (50,000원) - n개
    5개 일치 (1,500,000원) - n개
    5개 일치, 보너스 볼 일치 (30,000,000원) - n개
    6개 일치 (2,000,000,000원) - n개
    ```
- [] 수익률 출력(소수점 첫째 차리까지 출력): `총 수익률은 dd.d%입니다.`

## 3. ✅ 과제 제출 전 확인 사항 ✅
---

- [] Java Enum을 적용하여 구현하였는지 확인
- [] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않는지 확인
- [] indent depth 3 안 넘었는지 확인
- [] 함수가 단일 역할을 수행하는 작은 함수들로 이뤄져있는지 확인
- [] 3항 연산자를 쓰지 않았는지 확인
- [] 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하는지 확인
- [] 클래스를 상수, 멤버 변수, 생성자, 메서드 순으로 작성하였는지 확인
- [] else, switch/case 예약어를 사용하지 않았는지 확인.
- [] IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리하였는지 확인
- [] 예외 상황 에러 문구 "[ERROR]"로 시작하는지 확인
- [] `./gradlew clean test` 명령어로 테스트 모두 통과되는지 확인
- [] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현했는지 확인
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용
    - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용

## 4. 👊🏻 개인적인 구현 목표 👊🏻
---
- [] 도메인 객체간 협력 하기
- [] 클래스별 단위테스트 꼼꼼히 하기 