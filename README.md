# 3️⃣ 로또

## ✅ 기능 목록

### 1. 게임 시작

- [X] 로또 구입 금액을 입력 받는다.
    - [X] 구입 금액은 1,000원 단위로 입력 받는다.
    - [X] 입력 단위가 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    - [X] 잘못된 값을 입력한 경우 예외 처리한다.

### 2. 게임 진행

- [X] 로또 게임을 시작한다.
    - [X] 로또 번호의 숫자 범위는 1~45까지이다.
    - [X] 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.

- [ ] 발행한 로또 수량 및 번호를 출력한다.
    - [ ] 로또 번호는 오름차순으로 정렬하여 보여준다.

- [ ] 당첨 번호를 입력 받는다.
    - [ ] 당첨 번호를 입력 받는데 쉼표(`,`)를 기준으로 구분한다.
    - [ ] 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
    - [ ] 잘못된 값을 입력한 경우 예외 처리한다.

- [ ] 보너스 번호를 입력 받는다.
    - [ ] 잘못된 값을 입력한 경우 예외 처리한다.

### 3. 게임 종료

- [ ] 게임 종료 후 당첨 통계를 출력한다.

- [ ] 총 수익률을 출력한다.
    - [ ] 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

### 4. 예외

- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`를 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 **그 부분부터 입력을 다시 받는다.**
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.
    - 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
      (ex. [ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.)

### 5. 요구 사항 체크
- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다. ➡️ 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
- [ ] 3항 연산자를 쓰지 않는다. 
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라. 
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다. 
- [ ] 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다. 
- [ ] else 예약어를 쓰지 않는다.
  - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
  - if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다. 
- [ ] Java Enum을 적용하여 프로그램을 구현한다. 
- [ ] 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.