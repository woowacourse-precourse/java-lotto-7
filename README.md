# java-lotto-precourse
## 구현할 기능 목록

- [ ]  로또 구입금액 입력
    - [ ]  구입금액 유효성 검사
        - [ ]  빈 문자열 입력 -  ``
        - [ ]  숫자가 아닌 값 입력 - `천원`
        - [ ]  1000원 미만의 값 입력 - `0`
        - [ ]  입력값 1000원 단위 아님 - `1234`
- [ ]  구입금액에 따른 로또 구매 갯수 메세지 출력
- [ ]  구입한 로또 번호 갯수만큼 로또 생성
- [ ]  생성된 로또의 번호 출력
- [ ]  당첨 번호 입력
    - [ ]  당첨 번호 유효성 검사
        - [ ]  빈 문자열 입력 -  ``
        - [ ]  번호가 6개 초과 - `1,2,3,4,5,6,7`
        - [ ]  번호가 6개 미만 - `1,2,3,4,5`
        - [ ]  문자 입력 - `일,이,삼,사,오,육`
        - [ ]  번호가 중복됨 - `1,1,2,2,3,4`
        - [ ]  1 미만 또는 45 초과 번호 포함 - `-1,0,3,4,5,46`
- [ ]  보너스 번호 입력
    - [ ]  보너스 번호 유효성 검사
        - [ ]  빈 문자열 입력 -  ``
        - [ ]  문자 입력 - `일번`
        - [ ]  1 미만 번호 또는 45 초과 번호 입력 - `0` / `46`
        - [ ]  당첨 번호와 중복됨 - 당첨 번호 `1,2,3,4,5,6`  일때 `1`
- [ ]  각각의 로또 당첨 결과 확인
- [ ]  수익률 계산
- [ ]  당첨 통계
    - [ ]  당첨조건, 당첨금액, 당첨횟수 출력
    - [ ]  수익률 출력

---

## 객체

1. **로또 (Lotto)**
    - 로또 용지를 나타내며, 선택된 번호 6개의 리스트를 포함한다.
2. **로또 공 (LottoBall)**
    - 1부터 45까지의 번호를 가질 수 있는 로또 공 객체
    - 각 번호는 고유하며 무작위로 생성되어야 함.
3. **게임 (Game)**
    - 특정한 당첨 번호와 보너스 번호를 포함하는 게임 객체
    - 사용자가 선택한 로또 번호에 따라 당첨 결과 및 지급 금액을 반환하는 기능을 제공
4. **로또 시뮬레이터 (LottoSimulator)**
    - 로또 게임을 시뮬레이션하는 객체
5. **비용 계산기 (CostCalculator)**
    - 구입 금액과 당첨 금액을 포함하는 계산기 객체
    - 수익률을 반환하는 기능을 제공

---

## 예외 처리

- 구입금액 입력시 예외 처리
    - 빈 문자열 입력

        ```java
        input : 
        output : IllegalArgumentException - [ERROR] 구입금액은 빈 값이 들어올 수 없습니다.
        ```

    - 숫자가 아닌 값 입력

        ```java
        input : 천원
        output : IllegalArgumentException - [ERROR] 구입금액은 숫자로 입력되어야 합니다.
        ```

    - 1000원 미만의 값 입력

        ```java
        input : 0
        output : IllegalArgumentException - [ERROR] 구매금액은 1000원 이상이어야 합니다.
        ```

    - 입력값 1000원 단위 아님

        ```java
        input : 1234
        output : IllegalArgumentException - [ERROR] 1000원 단위의 금액을 입력해야 합니다.
        ```

- 당첨 번호 입력시 예외처리
    - 빈 문자열 입력

        ```java
        input : 
        output : IllegalArgumentException - [ERROR] 로또 번호는 빈 값이 들어올 수 없습니다.
        ```

    - 번호가 6개 초과

        ```java
        input : 1,2,3,4,5,6,7
        output : IllegalArgumentException - [ERROR] 로또 번호는 6개를 초과할 수 없습니다.
        ```

    - 번호가 6개 미만

        ```java
        input : 1,2,3,4,5
        output : IllegalArgumentException - [ERROR] 로또 번호는 6개 미만일 수 없습니다.
        ```

    - 문자 입력

        ```java
        input : 일,이,삼,사,오,육
        output : IllegalArgumentException - [ERROR] 로또 번호는 숫자로 입력되어야 합니다.
        ```

    - 번호가 중복됨

        ```java
        input : 1,1,2,2,3,4
        output : IllegalArgumentException - [ERROR] 로또 번호는 중복 없이 입력되어야 합니다.
        ```

    - 1 미만 번호 또는 45 초과 번호 포함

        ```java
        input : 1,2,3,4,0,46
        output : IllegalArgumentException - [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
        ```

- 보너스 번호 입력시 예외처리
    - 빈 문자열 입력

        ```java
        input : 
        output : IllegalArgumentException - [ERROR] 로또 번호는 빈 값이 들어올 수 없습니다.
        ```

    - 문자 입력

        ```java
        input : 이십
        output : IllegalArgumentException - [ERROR] 로또 번호는 숫자로 입력되어야 합니다.
        ```

    - 1 미만 번호 또는 45 초과 번호 입력

        ```java
        input : 0
        output : IllegalArgumentException - [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
        ```

    - 당첨 번호와 중복됨

        ```java
        input : 1 // 당첩 번호와 중복
        output : IllegalArgumentException - [ERROR] 보너스 번호는 당첨 번호와 중복 없이 입력되어야 합니다.
        ```