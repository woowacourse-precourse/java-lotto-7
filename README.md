# java-lotto-precourse

### 1) 프로그램 메시지 출력 기능

- [x] `구입금액을 입력해 주세요.` 메시지를 출력
- [x] `n개를 구매했습니다.` 메시지 출력
  - [x] 추첨된 로또 번호 출력
- [x] `당첨 번호를 입력해 주세요.` 메시지 출력
- [x] `보너스 번호를 입력해 주세요.` 메시지 출력
- [x] `당첨 통계` 메시지 출력
  - [x] `---` 문구 출력
  - [x] 당첨 결과 및 수익률 출력

### 2) 사용자 문자열 입력 및 검증 기능

- [x] 구임 금액 입력
    - [x] 입력 값이 비어있는지 검증
      - [x] 예외인 경우 IllegalArgumentException 발생
- [x] 당첨 번호 입력
    - [x] 입력 값이 비어있는지 검증
        - [x] 예외인 경우 IllegalArgumentException 발생
    - [x] 올바른 구분자(,)를 포함하고 있는지 검증
      - [x] 예외인 경우 IllegalArgumentException 발생
    - [x] 숫자인지 검증
      - [x] 예외인 경우 IllegalArgumentException 발생
- [x] 보너스 번호 입력
    - [x] 입력 값이 비어있는지 검증
      - [x] 예외인 경우 IllegalArgumentException 발생
    - [x] 숫자인지 검증
      - [x] 예외인 경우 IllegalArgumentException 발생

### 3) 로또 생성

- [x] 구입 금액에 따른 로또 구입
    - [x] 숫자인지 검증
        - [x] 예외인 경우 IllegalArgumentException 발생
    - [x] 1000원 단위인지 검증
        - [x] 예외인 경우 IllegalArgumentException 발생
    - [x] 로또 생성
      - [x] 로또 6자리인지 검증
        - [x] 예외인 경우 IllegalArgumentException 발생
      - [x] 로또 숫자 중복 검증
        - [x] 예외인 경우 IllegalArgumentException 발생
      - [x] 로또 1~45 사이의 숫자인지 검증
        - [x] 예외인 경우 IllegalArgumentException 발생
      - [x] 로또 번호 오름차순 정렬

### 4) 당첨번호 및 보너스 번호 생성

- [x] 당첨 로또 생성
- [x] 보너스 번호 생성
    - [x] 숫자의 범위가 1~45 사이 숫자인지 검증
        - [x] 예외인 경우 IllegalArgumentException 발생
    - [x] 당첨 번호와 겹치는 숫자인지 검증
        - [x] 예외인 경우 IllegalArgumentException 발생

### 5) 당첨 확인 및 통계

- [x] 로또 별 당첨 확인
    - [x] 당첨 통계(등수) 기록
- [x] 수익률 계산

## 초기 구현 할 클래스 UML 설계

<p align="center">
  <img src="Initial Design UML.png" alt="Initial Design UML" width="500" height="300">
</p>

## 구현 완료된 클래스 UML

<p align="center">
  <img src="Implementation Complete UML.png" alt="Initial Design UML" width="400" height="800">
</p>