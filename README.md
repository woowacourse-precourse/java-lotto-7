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
- [ ] Application.java <br>
  - [ ] LottoPlay로 연결하여 프로그램 시작 <br>
---
- [ ] Controller <br>
  - [ ] MoneyController.java <br>
    - [ ] 입력 받은 로또 구매 금액 시행 횟수로 변환 <br>
    - [ ] MoneyValidation에서 오류 확인 <br>
  - [ ] LottoController.java <br>
    - [ ] 입력 받은 당첨 번호 리스트로 변환 <br>
    - [ ] LottoValidation에서 오류 확인 <br>
    - [ ] BonusValidation에서 오류 확인 <br>
  - [ ] Play.java <br>
    - [ ] 시행 횟수 만큼 Model(Lotto) 반복 <br>
---
- [ ] Model <br>
  - [ ] Lotto.java <br>
    - [X] 당첨 번호 6개 아닐 시 예외 처리 <br>
    - [ ] 랜덤한 번호 추출 <br>
  - [ ] Statistics.java <br>
    - [ ] 당첨 등수 및 당첨 금액 통계 계산 <br>
  - [ ] Rate.java <br>
    - [ ] 수익률 계산 <br>
---
- [ ] Validation <br>
  - [ ] LottoValidation.java <br>
    - [ ] 공백 시 예외 처리 <br>
    - [ ] 숫자 아닐 시 예외 처리 <br>
    - [ ] 1 ~ 45 사이 아닐 시 예외 처리 <br>
    - [ ] 중복 시 예외 처리 <br>
  - [ ] MoneValidation.java <br>
    - [ ] 공백 시 예외 처리 <br>
    - [ ] 숫자 아닐 시 예외 처리 <br>
    - [ ] 1000으로 나눠떨어지지 않으면 예외 처리 <br>
  - [ ] BounusValidation.java <br>
    - [ ] 공백 시 예외 처리 <br>
    - [ ] 숫자 아닐 시 예외 처리 <br>
    - [ ] 1 ~ 45 사이 아닐 시 예외 처리 <br>
    - [ ] 당첨 번호와 중복 시 예외 처리 <br>
---
- [ ] View <br>
  - [X] Input.java <br>
    - [X] 로또 구입 금액 입력 <br>
    - [X] 당첨 번호 입력 <br>
    - [X] 보너스 번호 입력 <br>
  - [ ] Output.java <br>
    - [ ] 당첨 통계와 수익률 출력 <br>
