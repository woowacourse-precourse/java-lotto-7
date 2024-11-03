# java-lotto-precourse

## 목표: 로또 발행과 당첨 내역을 출력하는 시스템

## 필요한 기능 작성

전체 시스템은 크게 [로또 발행 서브 시스템], [당첨 통계 서브 시스템], [수익률 계산 서브 시스템] 세 가지로 나뉜다(패키지 분리)
전체 시스템은 세 서브 시스템을 제어한다.

[로또 발행 서브 시스템]과 [당첨 통계 서브 시스템]은 추출 유틸 인터페이스를 공용으로 사용한다.

예외 상황(=사용자가 잘못된 값을 입력할 경우) `IllegalArgumentException`을 발생시키고,   
"[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### 로또 발행 서브 시스템

목표: 구입 금액과 발행한 로또들 영수증으로 반환

- “구입급액을 입력해 주세요.”라는 문구와 함께 구입 금액을 입력 받기
- 문자열에서 숫자 추출하여 반환하기
    - 예외 상황
        - 나누어 떨어지지 않는 경우
        - 문자를 입력한 경우
        - null, 빈 문자열, 공백을 입력한 경우
        - 0을 입력한 경우
- 정수 6개를 전처리하여 로또로 만들기
    - 오름차순으로 만들기
- 숫자만큼 로또 발행하기
- 구매 내역과 발행된 로또 영수증 반환
- 로또 발행 서브 시스템의 실행 흐름 제어

### 당첨 통계 서브 시스템

목표: 당첨 내역과 총 상금을 당첨결과지로 반환

- “당첨 번호를 입력해 주세요.”라는 문구와 함께 당첨 번호를 입력 받기
- 문자열에서 쉼표(,) 기준으로 숫자를 6개를 얻기
    - 예외 상황
        - 문자를 입력한 경우
        - null, 공백을 입력한 경우
- 당첨 숫자 예외 상황 처리
    - 숫자가 6개가 아닌 경우
    - 1~45 이외의 숫자를 입력한 경우
    - 당첨 번호와 중복될 경우
- “보너스 번호를 입력해 주세요.”라는 문구와 함께 보너스 번호를 입력 받기
- 문자열에서 숫자 추출하기
    - 예외 상황
        - 문자를 입력한 경우
        - null, 공백을 입력한 경우
- 보너스 번호 예외 상황 처리
    - ~~숫자가 1개가 아닌 경우~~ -> 범위 밖 숫자나 숫자가 아닌 값으로 인식해서 자동으로 예외처리
    - 1~45 이외의 숫자를 입력한 경우
    - 당첨 번호로 입력한 숫자를 입력한 경우
- 숫자 배열을 받아 일치하는 숫자 개수 판단하기
- 일치 개수로 순위 당 당첨 내역 갱신하기(카운터)
- 당첨 내역 출력하기
- 전체 당첨 내역을 토대로 총 당첨 금액 계산하기

### 수익률 계산 서브 시스템

목표: 수익률을 계산해서 반환

- 당첨 금액과 구입 금액으로 수익률 계산하기
- 수익률 출력하기

### 추출 유틸

- 검증과 추출 인터페이스
    - 검증 디폴트 메서드
        - 문자를 입력한 경우
        - null, 공백, 빈문자열을 입력한 경우

### 전체 시스템

- 두 시스템 실행 제어

---

## 유스케이스

유스케이스명: 로또 구매하기

주요 액터: 사용자

주요 성공 시나리오:

1. 시스템은 “구입급액을 입력해 주세요.”라는 문구를 출력한다.
2. 사용자가 금액을 입력한다.
3. 시스템은 입력 받은 금액에서 최대로 구매할 수 있는 로또 수를 계산하고 사용자에게 출력한다.
4. 시스템은 구매 가능한 로또 수만큼 6개 숫자를 오름차순으로 출력한다

확장 시나리오:

3-1 구입 금액에 잘못된 숫자를 입력했다면 “[ERROR]”가 들어간 예외 메시지 출력하고 다시 입력 받는다. (ex. 1,000원으로 나누어 떨어지지 않거나 숫자가 아닐 때 등)

성공 시 보증: 로또 구매가 완료된다.

비즈니스 규칙: [구입 금액 입력 규칙], [로또 발행 규칙]

---

유스케이스명: 당첨 통계내기

주요 액터: 사용자

사전 조건: 로또를 이미 구매한 상태여야 한다.

주요 성공 시나리오:

1. 시스템은 “당첨 번호를 입력해 주세요.”라는 문구를 출력한다.
2. 사용자가 당첨 번호 6자리를 입력한다.
3. 시스템은 “보너스 번호를 입력해 주세요.”라는 문구를 출력한다.
4. 사용자가 보너스 번호 1자리를 입력한다.
5. 시스템은 로또 번호와 당첨 번호를 비교하여 당첨 내역을 출력한다.
6. 시스템은 당첨 내역과 구입 금액을 토대로 수익률을 계산해 출력한다.

확장 시나리오:

3-1 당첨 번호를 잘못 입력했다면 “[ERROR]”가 들어간 예외 메시지 출력하고 다시 입력 받는다(그 후 3번 수행)

5-1 보너스 번호를 잘못 입력했다면 “[ERROR]”가 들어간 예외 메시지 출력하고 다시 입력 받는다(그 후 5번 수행)

성공 시 보증: 당첨 내역과 수익률을 출력하고 프로그램을 종료한다.

비즈니스 규칙: [당첨 번호 입력 규칙], [보너스 번호 입력 규칙], [당첨 기준과 금액], [수익률 계산 규칙]

---

비즈니스 규칙 이름: 구입 금액 입력 규칙

내용:

- 오직 숫자만 입력 가능하다.
- null, 공백, 0은 입력할 수 없다.
- 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 금액을 다시 받는다.

---

비즈니스 규칙 이름: 로또 발행 규칙

내용:

- 당첨 번호 추첨 시 중복되지 않는 숫자 6개를 뽑는다
- 오름차순으로 출력한다.

---

비즈니스 규칙 이름: 당첨 번호 입력 규칙

내용:

- 번호는 쉼표(,)를 기준으로 구분하여 숫자 6개를 입력받는다.
- 구분자 쉼표를 제외하고 오직 숫자만 입력 가능하며 숫자는 1~45까지만 입력 가능하다.
- 숫자는 정확히 6개여야 한다.
- 숫자들은 중복될 수 없다.
- null, 공백은 입력할 수 없다.

---

비즈니스 규칙 이름: 보너스 번호 입력 규칙

내용:

- 오직 1~45의 숫자만 입력 가능하다.
- 숫자는 정확히 1개여야 한다.
- 당첨 번호로 입력한 숫자는 입력 불가하다.
- null, 공백은 입력할 수 없다.

---

비즈니스 규칙 이름: 당첨 기준과 금액 번호 입력 규칙

내용:

- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 현실 세계와 다르게 로또 한 개로 당첨을 판단한다(5개로 당첨 계산X)

---

비즈니스 규칙 이름: 수익률 계산 규칙

내용:

- ( 전체 당첨 금액 / 구입 금액 ) * 100 으로 계산한다.
- 수익률은 소수점 둘째 자리에서 반올림한다(= 소수점 첫째 자리까지 출력)
- 분모는 0이 될 수 없다(구입 금액에서 걸러질 예정)
