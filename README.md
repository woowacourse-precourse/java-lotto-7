# java-lotto-precourse
## 디렉토리 구조
```bash
src
 ┣ main
 ┃ ┗ java
 ┃ ┃ ┗ lotto
 ┃ ┃ ┃ ┣ controller
 ┃ ┃ ┃ ┃ ┗ LottoGame.java
 ┃ ┃ ┃ ┣ exception
 ┃ ┃ ┃ ┃ ┗ ErrorMessage.java
 ┃ ┃ ┃ ┣ model
 ┃ ┃ ┃ ┃ ┣ Lotto.java
 ┃ ┃ ┃ ┃ ┣ Rank.java
 ┃ ┃ ┃ ┃ ┗ WinningLotto.java
 ┃ ┃ ┃ ┣ util
 ┃ ┃ ┃ ┃ ┗ InputValidator.java
 ┃ ┃ ┃ ┣ view
 ┃ ┃ ┃ ┃ ┣ InputView.java
 ┃ ┃ ┃ ┃ ┗ OutputView.java
 ┃ ┃ ┃ ┣ Application.java
 ┃ ┃ ┃ ┗ Constant.java
 ┗ test
 ┃ ┗ java
 ┃ ┃ ┗ lotto
 ┃ ┃ ┃ ┣ model
 ┃ ┃ ┃ ┃ ┗ LottoTest.java
 ┃ ┃ ┃ ┣ util
 ┃ ┃ ┃ ┃ ┗ InputValidatorTest.java
 ┃ ┃ ┃ ┗ ApplicationTest.java
```

## 기능 구현 목록
### 입력 기능 구현
- 로또 구입 금액 입력
- 당첨 번호 입력
- 보너스 번호 입력

### 비즈니스 로직 구현
- 로또 구입 금액 전달 받아서 유효성 검사
  - 공백, null 확인
  - 1000단위 숫자인지 체크
  - 예외가 생기면 다시 입력 받기
  
- 로또 구입 금액에 맞게 로또 생성
  - 1~45 중 중복되지 않은 숫자 6개 선택

- 당첨 번호 전달 받아서 유효성 검사
  - "," 단위로 나눴을 때 6개인지 체크
  - 각각 숫자인지 체크
  - 각 숫자가 범위 내에 있는지 체크
  - 숫자끼리 중복 체크
  - 예외가 생기면 다시 입력 받기

- 보너스 번호 입력 받아서 유효성 검사
  - 공백, null 확인
  - 기존 입력받는 당첨 번호랑 중복있는지 체크
  - 예외가 생기면 다시 입력 받기

- 생성된 로또 별로 채점하기
  - 각 로또별 일치여부 확인
  - 등수별 당첨된 로또 수 계산
  - 총 당첨금 계산
  - 수익률 계산

### 출력 기능 구현
- 로또 구입 메시지 출력
- 입력 금액에 맞는 로또 수 출력
- 개수에 맞게 생성된 로또 출력
- 당첨번호, 보너스 번호 메시지 출력
- 당첨 통계 출력
- 수익률 출력
- 입력 과정 중, 사용자가 잘못 입력하면 그에 맞는 에러 문구 출력
