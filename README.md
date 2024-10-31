# java-lotto-precourse

### 1) 프로그램 메시지 출력 기능

- [ ] `구입금액을 입력해 주세요.` 메시지를 출력
- [ ] `n개를 구매했습니다.` 메시지 출력
  - [ ] 추첨된 로또 번호 출력
- [ ] `당첨 번호를 입력해 주세요.` 메시지 출력
- [ ] `보너스 번호를 입력해 주세요.` 메시지 출력
- [ ] `당첨 통계` 메시지 출력
  - [ ] `---` 문구 출력
  - [ ] 당첨 결과 및 수익률 출력

### 2) 사용자 문자열 입력 및 검증 기능

- [ ] 구임 금액 입력
    - [ ] 입력 값이 비어있는지 검증
      - [ ] 예외인 경우 IllegalArgumentException 발생
- [ ] 당첨 번호 입력
    - [ ] 입력 값이 비어있는지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
    - [ ] 올바른 구분자(,)를 포함하고 있는지 검증
      - [ ] 예외인 경우 IllegalArgumentException 발생
- [ ] 보너스 번호 입력
    - [ ] 입력 값이 비어있는지 검증
      - [ ] 예외인 경우 IllegalArgumentException 발생

### 3) 로또 생성

- [ ] 구입 금액에 따른 로또 구입
    - [ ] 숫자인지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
    - [ ] 1000원 단위인지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
    - [ ] 로또 생성
      - [ ] 로또 번호 오름차순 정렬

### 4) 당첨번호 및 보너스 번호 생성

- [ ] 당첨 번호 생성
    - [ ] 숫자인지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
    - [ ] 6자리인지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
    - [ ] 중복되는 숫자가 있는지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
    - [ ] 숫자의 범위가 1~45 사이 숫자인지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
- [ ] 보너스 번호 생성
    - [ ] 숫자인지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생
    - [ ] 숫자의 범위가 1~45 사이 숫자인지 검증
        - [ ] 예외인 경우 IllegalArgumentException 발생

### 5) 당첨 확인 및 통계

- [ ] 로또 별 당첨 확인
    - [ ] 당첨 통계(등수) 기록
- [ ] 수익률 계산

## 초기 구현 할 클래스 UML 설계

<p align="center">
  <img src="Initial Design UML.png" alt="Initial Design UML" width="500" height="300">
</p>
