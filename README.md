# 초기 생각 정리


## 1. 로또 구입 금액 입력받기


- 로또 구입 금액을 입력받는다.
- 로또 구입 금액은 1000원 단위로 입력받는다.


### 예외사항
- 로또 구입 금액이 1000원 단위가 아닐 경우 `IllegalArgumentException`을 발생시킨다.
- 로또 구입 금액이 숫자가 아닐 경우 `IllegalArgumentException`을 발생시킨다.
- 로또 구입 금액이 0원 이하일 경우 `IllegalArgumentException`을 발생시킨다.
- 로또 구입 금액이 INT의 범위를 넘길 수 있도록 한다.


## 2. 당첨 번호를 입력받는다.


- 당첨 번호를 입력받는다.
- 당첨 번호는 쉼표(,)로 구분되며, 각 번호는 1부터 45 사이의 숫자로 제한된다.
- 당첨 번호는 중복되지 않는다.
- 당첨 번호는 6개여야 한다.


### 예외 사항
- 당첨 번호가 6개가 아닐 경우 `IllegalArgumentException`을 발생시킨다.
- 당첨 번호가 중복될 경우 `IllegalArgumentException`을 발생시킨다.
- 당첨 번호가 1부터 45 사이의 숫자가 아닐 경우 `IllegalArgumentException`을 발생시킨다.
- 당첨 번호가 쉼표(,)로 구분되지 않을 경우 `IllegalArgumentException`을 발생시킨다.
- 당첨 번호가 숫자가 아닐 경우 `IllegalArgumentException`을 발생시킨다.


## 3. 보너스 번호를 입력받는다.


- 보너스 번호를 입력받는다.
- 보너스 번호는 1부터 45 사이의 숫자로 제한된다.
- 보너스 번호는 당첨 번호와 중복되지 않는다.


### 예외 사항
- 보너스 번호가 1부터 45 사이의 숫자가 아닐 경우 `IllegalArgumentException`을 발생시킨다.
- 보너스 번호가 당첨 번호와 중복될 경우 `IllegalArgumentException`을 발생시킨다.
- 보너스 번호가 숫자가 아닐 경우 `IllegalArgumentException`을 발생시킨다.


## 4. 구입 금액에 따른 로또 번호를 생성한다.


- 구입 금액에 따른 구매 개수를 계산한다.
- 구매 개수에 따른 로또 번호를 생성한다.


### 예외 사항
- 당장 생각 나는 것은 없음


## 5. 로또 번호와 당첨 번호를 비교하여 당첨 결과를 출력한다.


- 로또 번호와 당첨 번호를 비교하여 당첨 결과를 출력한다.


### 예외 사항
- 당장 생각 나는 것은 없음


## 6. 수익률을 계산한다.


- 구입 금액 대비 당첨 금액의 수익률을 계산한다.


### 예외 사항
- 소수점 둘째 자리에서 반올림한다.


# 공통 요구 사항


- 입력값이 예외사항을 만족하지 않을 경우 `IllegalArgumentException`을 발생시킨다.
- 이때, 에러 문구는 "[ERROR]"로 시작해야 한다.


- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.


- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
- else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
- 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.


- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
  - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용한다.
  - 사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용한다.


### 사용 예시
- 1에서 45 사이의 중복되지 않은 정수 6개 반환
  - `Randoms.pickUniqueNumbersInRange(1, 45, 6);`