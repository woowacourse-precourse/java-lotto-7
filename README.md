# java-lotto-precourse

## 기능목록

- [x]  로또 구입 금액을 **입력** (1000원 단위)
    - [x]  로또 발행(구입 금액에 맞춰) - 오름차순 정렬
    - [x]  발행한 로또 수량 및 번호를 **출력**
- [x]  당첨 번호를 **입력** (쉼표(,)를 기준으로 구분)
- [x]  보너스 번호를 **입력**
- [x]  당첨번호와 로또들 비교
- [x]  수익률 계산 (소수점 둘째 자리에서 반올림)
- [ ]  통계 **출력** [ 당첨내역(enum), 수익률 ]

## 예외 상황

⇒ `IllegalArgumentException`을 발생시키고, **"[ERROR]"로 시작**하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

🚨 에러 발생하면 종료하는 것이 아닌 메세지 출력 후 다시 입력

- [x]  로또 구입 금액
    - [x]  1,000원으로 나누어 떨어지지 않는 경우
    - [x]  숫자가 아닌 경우
- [x]  당첨 번호 (controller에서 처리)
    - [x]  숫자가 아닌경우
    - [x]  숫자 범위 1~45 넘는 경우
    - [x]  중복되는 숫자인 경우
    - [x]  6개 입력 안 함
    - [x]  ,로 구분하지 않은 경우
        - [x]  공백포함하면 에러
- [x]  보너스 번호
    - [x]  숫자가 아닌 경우
    - [x]  숫자 범위 1~45 넘는 경우
    - [x]  당첨번호와 중복된 숫자의 경우 (controller에서 처리)
---
### 프로그래밍 요구사항

- [ ]  indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ]  3항 연산자를 쓰지 않는다.
- [ ]  함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ]  JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
- [ ]  함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
- [ ]  else 예약어를 쓰지 않는다.
- [ ]  Java Enum을 적용하여 프로그램을 구현한다.
- [ ]  구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.  

### 개인적인 목표
- [ ]  API 제공하는 메서드 활용 - ex) clear()
- [ ]  객체를 객체답게 (static 남발 조심)
- [ ]  README 나만의 조건을 걸어 더욱 상세하게
- [ ]  에러 메세지 상수로 관리
- [ ]  구현 순서도 코딩 컨벤션이다 : 클래스는 **상수, 멤버 변수, 생성자, 메서드** 순
- [ ]  변수 이름에 자료형은 사용하지 않는다
- [ ]  메서드가 한 가지 기능을 하는지 확인
- [ ]  코드 포맷팅
- [ ]  네이밍 점검하기

➡️마지막에 점검하기

---
### 전체 구조
```
lotto
├── Application.java
├── Lotto.java
├── controller
│   ├── LottoController.java
│   └── LottoMachineController.java
├── model
│   └── Result.java
├── util
│   └── Calculator.java
├── validator
│   └── Validator.java
└── view
    └── InputView.java
    └── OutputView.java

```