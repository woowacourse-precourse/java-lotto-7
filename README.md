# 프리코스 3주차 - 로또
---
## 디렉토리 구조
├── Application.java <br> 
├── Controller <br>
│    ├── MoneyController.java <br>
│    ├── LottoController.java <br>
│    └── Play.java <br>
├── Model <br>
│    ├── Lotto.java <br>
│    ├── Random.java <br>
│    ├── Rank.java <br>
│    ├── Statistics.java <br>
│    └── Rate.java <br>
├── Validation <br>
│    ├── LottoValidation.java <br>
│    ├── MoneyValidation.java <br>
│    └── BounusValidation.java <br>
└── View <br>
     ├── Input.java <br>
     └── Output.java <br>
     
---
## 구현 기능 목록
- [X] MVC 패턴으로 로직 분리 <br>
---
- [X] Application.java <br>
  - [X] lay로 연결 <br>
---
- [X] Controller <br>
  - [X] MoneyController.java <br>
    - [X] MoneyValidation에서 오류 확인 <br>
  - [X] LottoController.java <br>
    - [X] 입력 받은 당첨 번호 리스트로 변환 <br>
    - [X] LottoValidation에서 오류 확인 <br>
    - [X] BonusValidation에서 오류 확인 <br>
  - [X] Play.java <br>
    - [X] 게임 시작 <br>
    - [X] 결과 계산 <br>
    - [X] 수익률 계산 <br>

---
- [X] Model <br>
  - [X] Lotto.java <br>
    - [X] 당첨 번호 6개 아닐 시 예외 처리 <br>
  - [X] Random.java <br>
    - [X] 시행 횟수 만큼 Model(Lotto) 반복 <br>
    - [X] 랜덤한 번호 추출 <br>
  - [X] Rank.java <br>
    - [X] 당첨 등수 및 당첨 금액 통계 표시 <br>
  - [X] Statistics.java <br>
    - [X] 당첨 등수 및 당첨 금액 통계 계산 <br>
  - [X] Rate.java <br>
    - [X] 수익률 계산 <br>
---
- [X] Validation <br>
  - [X] LottoValidation.java <br>
    - [X] 공백 시 예외 처리 <br>
    - [X] 숫자 아닐 시 예외 처리 <br>
    - [X] 1 ~ 45 사이 아닐 시 예외 처리 <br>
    - [X] 중복 시 예외 처리 <br>
  - [X] MoneValidation.java <br>
    - [X] 공백 시 예외 처리 <br>
    - [X] 숫자 아닐 시 예외 처리 <br>
    - [X] 1000으로 나눠떨어지지 않으면 예외 처리 <br>
  - [X] BounusValidation.java <br>
    - [X] 공백 시 예외 처리 <br>
    - [X] 숫자 아닐 시 예외 처리 <br>
    - [X] 1 ~ 45 사이 아닐 시 예외 처리 <br>
    - [X] 당첨 번호와 중복 시 예외 처리 <br>
---
- [X] View <br>
  - [X] Input.java <br>
    - [X] 로또 구입 금액 입력 <br>
    - [X] 당첨 번호 입력 <br>
    - [X] 보너스 번호 입력 <br>
  - [X] Output.java <br>
    - [X] 당첨 통계와 수익률 출력 <br>
