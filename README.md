# java-lotto-precourse
## 기능 목록

### 입력
- [x] 로또 구입 금액을 입력 받는다.
- [x] 당첨 번호를 입력 받는다.
- [x] 보너스 번호를 입력 받는다.
- [x] 사용자가 잘못된 값을 입력한 경우, 에러 메세지 출력 후 그 부분부터 다시 받는다.

#### 예외처리
- 금액 입력
  - [x] 숫자를 입력하지 않으면 예외
  - [x] 1000원 단위로 입력하지 않으면 예외

- 당첨 번호 입력
  - [x] 1~45 사이의 숫자 6개, 쉼표로 구분된 형식 체크
  - [ ] 6자가 겹치게 되면 예외

- 보너스 번호 입력
  - [x] 숫자를 입력하지 않으면 예외
  - [x] 1~45 사이가 아니면 예외
  - [ ] 당첨번호와 겹치면 예외

### 출력
- [x] 발행한 로또 수량 및 번호를 출력한다.
- [x] 로또 번호는 오름차순으로 정렬하여 출력한다.
- [x] 당첨 내역을 출력한다.
- [x] 수익률은 소수점 둘째 자리에서 반올림하여 출력한다.

### 로또
> 로또 번호 6개를 가지고 있다.
- [x] 당첨번호와 보너스 번호가 얼마나 일치하는지 반환한다.

#### 예외처리
- [x] 중복되는 값이 들어오면 예외
- [x] 숫자는 6개가 들어오지 않으면 예외

### 로또 묶음
> 발행한 모든 로또를 가지고 있다.
- [x] 발행한 모든 로또를 문자열로 변환한다.

#### 예외처리


### 로또 발행기
> 입력받은 금액을 가지고 있다.
- [x] 입력받은 금액을 1000원당 1개의 로또를 뽑는다.
- [x] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

#### 예외처리
- [x] 음수인 값이 들어오면 안된다.
- [x] 1000으로 나누어 떨어지지 않는 값이 들어오면 안된다.

### 로또 결과
> 로또 묶음, 당첨번호, 보너스 번호를 가지고 있다.
- [x] 총 수익 금액을 계산한다.
- [x] 총 수익률을 계산한다.


## 리팩토링 목록
### 입력
- [x] 입력값이 재귀로 들어가게 되면 스택오버플로우가 생길 수 있음. 다른 방식으로 구현
- [x] 여기서 발생하는 에러는 사용자에 직접적으로 전달됨. 따라서 에러 메세지는 한국어로 작성
- [x] 여기서 사용자에게 보여주는 안내 메세지는 View로 이전, 함수 호출로 리팩토링.

### 로또 발행기
- [x] 금액을 가지고 있는것 보다, 금액을 입력 받으면 그 입력값에 맞는 로또를 생성해주는 방향으로 리팩토링.(금액을 들고 있을 이유, 그리고 역할과 책임이 없음)

### 로또 결과
- 로또 결과와 맞지 않게 역할이 너무 많음. 로또 결과라는 이름과 맞지 않음
- [x] 로또 결과를 산출하는 역할을 가진 클래스로 분리, LottoResult는 말 그대로 결과를 담는 VO 클래스로 분리
- [x] calculate 함수가 너무 김. 줄일 수 있는 방안 고려 

### 전역
- [x] 객체 생성 시점, 책임 검토
- [x] Application.main을 봤을 때 어떤 흐름으로 프로그램이 동작하는 지 알 수 있게 리팩토링
- [x] 에러 메세지 문자열을 전역적으로 관리할 수 있게 리팩토링
- [ ] 오류를 Input에서 검증하는 것이 아니라, 각 도메인에서 검증하도록 변경
- [ ] 각 도메인에서 객체 생성이 불가능 할 때, 다시 생성하도록 리팩토링
