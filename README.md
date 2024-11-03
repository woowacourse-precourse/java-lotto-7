# 프리코스 3주차 - 로또
---
## 디렉토리 구조
├── Application.java <br> 
├── Controller <br>
│    └── Play.java <br>
├── Model <br>
│    ├── Lotto.java <br>
│    ├── Random.java <br>
│    ├── Statistics.java <br>
│    └── Rate.java <br>
└── View <br>
     ├── Input.java <br>
     └── Output.java <br>
     
---
## 구현 기능 목록
- [ ] MVC 패턴으로 로직 분리 <br>
---
- [ ] Application.java <br>
  - [ ] Controller로 연결 <br>
---
- [ ] Controller <br>
  - [ ] Play.java <br>
    - [ ] 시행 횟수 만큼 Model(Lotto) 반복 <br>
---
- [ ] Model <br>
  - [ ] Lotto.java <br>
    - [X] 당첨 번호 6개 아닐 시 예외 처리 <br>
    - [ ] 당첨 번호 비교 <br>
  - [ ] Random.java <br>
    - [ ] 랜덤한 당첨 번호 추출 <br>
  - [ ] Statistics.java <br>
    - [ ] 당첨 등수 및 당첨 금액 통계 계산 <br>
  - [ ] Rate.java <br>
    - [ ] 수익률 계산 <br>
---
- [ ] View <br>
  - [X] Input.java <br>
    - [X] 로또 구입 금액 입력 <br>
      - [X] /1000 으로 시행 횟수 추출 <br>
      - [X] %1000 != 0 일시 예외 처리 <br>
    - [X] 당첨 번호 입력 <br> 
      - [X] 입력 받은 당첨 번호 리스트로 변환 <br>
      - [X] 1~45 사이의 숫자 아닐 시 예외 처리 (숫자 6개 아닐 경우 예외처리는 주어진 Model(Lotto)에서 진행) <br>
    - [X] 보너스 번호 입력 <br>
      - [X] 1~45 사이의 숫자 아닐 시 예외 처리 <br>
  - [ ] Output.java <br>
    - [ ] 당첨 통계와 수익률 출력 <br>
