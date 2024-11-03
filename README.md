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
│   ├── LottoMachine
│   ├── LottoService
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
    - ```Lotto``` : 
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

{ 보류 }

---

## 구현 기능 목록

### ✅ 사용자 입력
- 사용자는 구입 금액과 당첨 번호, 보너스 번호를 세 차례에 나누어 입력한다.
- 입력값은 ```camp.nextstep.edu.missionutils.Console```의 ```readLine()```  메서드를 사용하여 받는다.

### ✅ 구입 금액 필터링

### ✅ 랜덤 로또 생성 및 출력

### ✅ 당첨 번호 필터링

### ✅ 보너스 번호 필터링

### ✅ 당첨 복권 판별 및 출력

### ✅ 예외 처리 기능
- 상술한 예외들에 대해 ```IllegalArgumentException``` 을 발생시킨다.
