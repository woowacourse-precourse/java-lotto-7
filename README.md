# java-lotto-precourse

## 프로젝트 개요
- 사용자에게 로또 구입 금액을 입력받고, 구입 금액에 해당하는 무작위 번호의 로또를 생성하여 출력한다. 사용자에게 당첨 번호와 보너스 번호를 입력받아서, 당첨 결과와 수익률을 출력한다.

## 구현 기능

### CONFIG
- [X] bean 등록을 위한 project scan 기능
- [X] bean 등록 대상으로 지정하기 위한 annotation
- [X] IoC를 위한 DI 기능
  - 예외 상황: 순환 참조, bean이 존재하지 않는 경우, bean이 여러 개 존재하는 경우
- [X] project scan, bean container 관리 기능
- [X] FrontController과 백 애플리케이션 기반 기능
- [X] front와 back의 통신 기능

### INPUT
- [X] 로또 구입 금액 입력
- [X] 당첨 번호 입력
- [X] 보너스 번호 입력

### PARSING
- [X] 로또 구입 금액 파싱
  - 예외 상황: 숫자가 아닌 경우
- [X] 당첨 번호 파싱
  - 예외 상황: 숫자가 아닌 경우, `,`로 split했을 때 정상적으로 파싱되지 않는 경우
- [X] 보너스 볼 파싱
  - 예외 상황: 숫자가 아닌 경우

### VALIDATION
- [X] 로또 번호 범위 검증
- [X] 로또 번호 개수 검증
- [X] 로또 번호 중복 검증
- [X] 로또 구입 금액 검증
  - 예외 상황: 로또 가격으로 구입 금액이 나누어 떨어지지 않는 경우
- [X] 당첨 번호 검증
  - 예외 상황: 당첨 번호가 6개가 아닌 경우, 1~45 사이의 숫자가 아닌 경우, 중복되는 번호가 있는 경우
- [X] 보너스 번호 검증
  - 예외 상황: 1~45 사이의 숫자가 아닌 경우, 당첨 번호와 중복되는 경우

### SERVICE
- [X] 로또 구입
- [X] 당첨 번호 지정
- [X] 보너스 번호 지정 및 결과와 수익률 계산

### OUTPUT
- [X] 로또 구입 결과 출력
- [X] 당첨 결과 출력
- [X] 수익률 출력
- [X] 에러 시 에러 메시지 출력