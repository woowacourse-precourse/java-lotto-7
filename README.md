# java-lotto-precourse

### 구현해야 할 기능
- [ ] 사용자에게 입력을 받는다.
  - [x] 로또 구입 금액을 입력받는다.
    - [x] 구입 금액은 1,000원 단위로 입력 받는다.
    - [x] 1000원으로 나누어 떨어지지 않을 경우 예외 처리한다.
  
  - [ ] 당첨 번호를 입력 받는다.
    - [ ] 쉼표(,) 기준으로 구분한다.
    - [ ] 쉼표(,)로 구분된 문자는 숫자여야 하며 숫자가 아닐 시 예외 처리 한다.
    - [ ] 구분된 숫자의 개수는 6개여야 하며 6개가 아닐 시 예외 처리한다.
    - [ ] 각 숫자는 1~45 범위 이내여야 하며 범위를 넘어설 시 예외 처리한다.
  
  - [ ] 보너스 번호를 입력 받는다.
    - [ ] 입력이 1~45범위 이내를 넘어설 시 예외 처리한다.

- [ ] 로또를 생성한다.
  - [ ] 1~45 범위의 숫자 6개를 뽑고 오름차순으로 정렿한다. 
  - [ ] 뽑은 숫자로 Lotto 객체를 생성한다.
  - [ ] 입력 받은 금액 / 1000 만큼 반복한다.

- [ ] 당첨 내역을 생성한다.
  - [ ] 로또의 6개 숫자와, 당첨 번호를 대조한다.
  - [ ] 당첨 정보(몇개 일치, 당첨금)을 계산하여 저장한다.

- [ ] 당첨 통계를 출력한다.
  - [ ] 당첨 정보를 바탕으로 주어진 형식으로 출력한다.
  - [ ] 당첨 정보를 바탕으로 총 수익률을 계산하여 출력한다.


### 학습할 내용
- [ ] Enum에 대한 학습: 
- [ ] else 예약어를 사용하지 않은 방식 학습: 

### 구현 과정
- 링크: 