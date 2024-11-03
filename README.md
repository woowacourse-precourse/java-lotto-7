# java-lotto-precourse

### 1. 프로젝트 개요
간단한 로또 발매기를 구현한다.


### 2. 주요 기능
- 로또 구입 금액 입력 받기
  - 1,000원 단위로 입력 받기


- 발행한 로또 수량 및 번호 출력


- 당첨 번호 입력 받기
  - 번호 구분은 쉼표로


- 보너스 번호 입력 받기


- 당첨 내역 출력


- 수익률 출력
  - 수익률 소수점 둘째 자리에서 반올림


- 예외 상황시 에러 문구 출력

💡예외 처리

- 로또 구입 금액
  - 1,000원 단위 아닌 경우
  - 1,000원 이하인 경우

- 당첨 번호 입력시
  - 숫자 6개 초과일 경우
  - 숫자 범위가 1 ~ 45에 해당되지 않는 경우
  - 0,0,0,0,0,0 의 포맷이 아닐경우


- 보너스 번호
  - 보너스 번호 범위가 1 ~ 45가 아닌 경우
  - 보너스 번호가 당첨 번호와 중복 될 경우


### 3. 프로젝트 폴더 구조

```bash
•
├── Console
│   └── InputConsole
│   └── OutputConsole
├── enums
│   └── ErrorType
│   └── PrizeComment
│   └── WinningType
├──exception
│   └── CheckInput
├── Application
├── CheckWinning
├── Lotto
├── LottoList
└──  LottoProgress
```