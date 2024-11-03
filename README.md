# 🎟️️ 로또

---

## 📦 패키지 구조

```
project/
├── Application.java
├── 📁 controller
│   └── LottoController
├── 📁 domain
│   ├── Lotto
│   ├── UserMoney
│   └── WinningNumbers
├── 📁 service
│   ├── InputHandler
│   ├── LottoMachine
│   └── PrizeCalculator
├── 📁 util
│   ├── ErrorMessage
│   ├── Parser
│   └── Validator
└── 📁 view
    ├── InputView
    └── OutputView
```

---

## 📁 패키지 설명

- **controller** :
    - ```LottoController``` : 로또 구매와 당첨 확인을 처리하는 컨트롤러


- **domain** :
    - ```Lotto``` : 로또 티켓을 대표하는 모델
    - ```UserMoney``` : 구입 금액을 저장하는 모델 
    - ```WinningNumbers``` : 당첨 번호와 보너스 번호를 저장하는 모델


- **service** :
  - ```InputHandler``` : 사용자의 입력값을 검증하고 결과를 컨트롤러에게 반환
  - ```LottoMachine``` : 랜덤한 숫자로 로또를 발행
  - ```PrizeCalculator``` : 등수별 당첨 로또 장수를 계산


- **util** : 
  - ```ErrorMessage``` : 예외 메시지 및 상수 관리
  - ```Parser``` : 입력값을 변환 및 파싱
  - ```Validator``` : 사용자의 입력값 검증


- **view** : 입력과 출력을 담당하는 뷰 계층
  - ```InputView``` : 사용자로부터 입력을 받는 역할
  - ```OutputView``` : 사용자에게 결과를 출력하는 역할

---

## 💭 클래스 다이어그램

<img width="1097" alt="로또 클래스 다이어그램" src="https://github.com/user-attachments/assets/ebc49f03-68d0-4fa1-bc87-3bc8dad17ed8">

---

## 구현 기능 목록

### ✅ 사용자 입력 기능
- 사용자는 구입 금액과 당첨 번호, 보너스 번호를 세 차례에 나누어 입력한다.
- ```InputView``` 에서 담당한다.
- 입력값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```  메서드를 사용하여 받는다.

### ✅ 로또 발행 기능
- 구입 금액에 상당하는 양의 로또를 발행한다.
- 랜덤 숫자 생성은 ```camp.nextstep.edu.missionutils.Randoms```의 ```pickUniqueNumbersInRange()``` 를 활용한다.

### ✅ 검증 기능
- 사용자로부터 입력받은 구입 금액에 대한 검증 메서드를 구현한다.
  - Integer 타입으로 변환이 불가할 경우, 예외로 처리한다.
  - 양수(Positive)가 아닐 경우, 예외로 처리한다.
  - 1,000 원 단위가 아닐 경우, 예외로 처리한다.
- 사용자로부터 입력받은 당첨 번호에 대한 검증 메서드를 구현한다.
  - 쉼표로 구분된 각 요소가 숫자가 아닐 경우, 예외로 처리한다.
  - 리스트에 6개의 숫자가 담겨 있지 않을 경우, 예외로 처리한다.
  - 각 숫자가 1-45 사이의 수가 아닐 경우, 예외로 처리한다.
  - 한 장의 로또에 중복되는 숫자가 존재할 경우, 예외로 처리한다.
- 사용자로부터 입력받은 보너스 번호에 대한 검증 메서드를 구현한다.
  - 숫자가 아닐 경우, 예외로 처리한다.
  - 1-45 사이의 수가 아닐 경우, 예외로 처리한다.
  - 이미 당첨 번호에 존재하는 중복된 수일 경우, 예외로 처리한다.

### ✅ 등수별 당첨 로또 계산 기능
- 발행된 로또 리스트와, 당첨 번호 및 보너스 번호를 비교한다.
- 등수별 당첨 로또의 장수를 저장한다.

### ✅ 수익률 계산 기능
- 등수별 당첨 로또 장수를 기반으로 최종 상금을 계산한다.
- 구입 금액과 최종 상금을 비교하여 수익률을 계산한다.

### ✅ 출력 기능
- 발행된 로또, 등수별 당첨 로또 장수, 수익률을 사용자에게 안내한다.
- ```OutputView``` 에서 담당한다.

### ✅ 예외 처리 기능
- 상술한 예외들에 대해 사용자에게 예외 메시지를 반환하고, 재입력을 받는다.
