# 프로젝트 패키지 및 클래스 구조

---

## 프로젝트 패키지 구조

📂 controller  
│   └── LottoController  
├── 📂 domain  
│   ├── Lotto  
│   ├── BonusLotto  
│   ├── LottoRank  
│   └── Money  
├── 📂 service  
│   ├── LottoMachine  
│   ├── LottoGenerator  
│   ├── LottoNumberChecker  
│   └── ProfitCalculator  
├── 📂 util  
│   ├── Parser  
│   └── Validator  
├── 📂 view  
│   ├── InputView  
│   └── OutputView  
└── Application  


## 클래스 구조

### controller

**LottoController**

- 애플리케이션의 전체 로직을 관리하는 클래스
- 사용자 입력을 처리하고, 서비스 클래스와의 상호작용을 통해 로또 구매 및 결과 출력

### domain

**Lotto**

- 6개의 로또 번호를 저장하는 객체
- 로또 번호의 유효성을 검사하고, 이를 제공

**BonusLotto**:

- 보너스 번호 1자리를 저장하는 객체
- 보너스 번호의 유효성을 검사하고, 이를 제공

**LottoRank**:

- 당첨 번호와 사용자가 구매한 로또 번호를 비교하여 등수를 결정
- 당첨 결과를 처리하고, 각 등급에 대한 정보를 관리

**Money**:

- 로또 구매 금액을 저장하는 객체
- 금액의 유효성을 검사하고, 금액 관련 계산

### service

**LottoMachine**:

- 사용자가 입력한 금액에 따라 구매 가능한 로또 수를 계산하고 생성
- 로또 구매 과정을 관리

**LottoGenerator**:

- 랜덤으로 로또 번호와 보너스 번호를 생성
- 중복되지 않는 번호를 생성하여 로또를 생성

**LottoNumberChecker**:

- Lotto 객체의 로또 번호와 당첨 번호를 비교하여 일치 여부를 확인하고 결과를 계산

**ProfitCalculator**:

- 당첨 결과를 기반으로 총 수익과 수익률을 계산
- 수익 관련 정보를 관리하고 제공

### util

**Parser**:

- 사용자 입력값을 파싱하여 적절한 데이터 타입으로 변환

**Validator**:

- 로또 번호, 보너스 번호, 구매 금액 등의 유효성을 검증
- 잘못된 입력에 대한 예외 처리를 담당합니다.

### view

**InputView**:

- 사용자로부터 로또 구매 금액과 당첨 번호를 입력받음
- 입력값을 확인하고 필요한 경우 재입력을 요청

**OutputView**:

- 구입한 로또 번호와 당첨 결과, 수익률을 사용자에게 출력

### Application

**Application**:

- 애플리케이션 실행을 위한 메인 클래스
- LottoController를 초기화하고 프로그램의 흐름을 시작.