# 🎟️️ 로또

---

## 📦 패키지 구조

```
project/
├── Application.java
├── Lotto
├── 📁 game
│   ├── Computer
│   ├── Constants
│   └── LottoController
├── 📁 util
│   ├── ErrorMessage
│   ├── InputValidator
│   ├── LottoMessage
│   └── Parser
└── 📁 view
    ├── InputView
    └── OutputView
```

---

## 📁 패키지 설명

- **game** :
    - ```Computer``` :
    - ```Constants``` :
    - ```LottoController``` : 로또 구매와 당첨 확인을 처리하는 컨트롤러


- **util** :
    - ```ErrorMessage``` : 예외 메시지 및 상수 관리
    - ```InputValidator``` : 사용자의 입력값 검증
    - ```LottoMessage``` : 입출력 안내 메시지 관리
    - ```Parser``` : 입력값을 변환 및 파싱


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
