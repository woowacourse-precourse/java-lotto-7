# java-lotto-precourse

## 기능 목록

### [O] 로또 구매 금액 입력
- 사용자로부터 로또 구매 금액을 입력받습니다.
- 입력 금액은 1,000으로 나누어 떨어지는 int 타입의 정수이다.
- 로또를 몇장 구매할 지 return 한다(input/1000)
- 예외처리 : 
    - 1000으로 나누어 떨어지지 않는 입력
    - int 타입의 정수가 아닌 입력(상식적으로 20억 이상의 금액을 로또로 사지는 않기에 int타입 사용)
### [O] 로또 Class에서 번호 1개 발행
- 로또 번호 1개를 발행하는 함수이다. 
- 1개의 로또는 1~45 사이의 중복되지 않는 6개의 번호로 구성된다.
- 로또 번호는 오름차순 정렬 후 저장한다.

### [x] 구매한 로또를 저장하고 당첨 확인하는 class 
- [O] 사용자가 구매한 금액에 따라 필요한 만큼 로또 번호를 발행하여 배열로 저장한다.
- [O] Lotto 클래스 타입의 리스트를 만든다.
- [x] 구매한 로또 1개의 당첨 여부를 확인하는 함수 만들기
- [x] 당첨 등수를 저장하는 필드를 추가하고, 당첨 카운트 하기
- [x] 총 상금을 구하는 함수 만들기

### [O] 당첨 번호 및 보너스 번호 입력 -> IO.class
- [O] 사용자로부터 당첨 번호 6개와 보너스 번호 1개를 입력받는다.
- [O] 당첨 번호와 보너스 번호는 중복되지 않는 1~45 범위의 숫자여야 한다.
- [O] 당첨번호 중복검사와 타입 체킹을 수행한다.
- 예외 처리:
    - 당첨번호, 보너스번호에 중복이 발생
    - int타입이 아닌 입력 
    - 1~45의 범위 외의 입력

### [x] 당첨 확인
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 결과를 확인.
- 당첨 등수와 상금 기준:
  - **1등**: 6개 번호 일치 (2,000,000,000원)
  - **2등**: 5개 번호 일치 + 보너스 번호 일치 (30,000,000원)
  - **3등**: 5개 번호 일치 (1,500,000원)
  - **4등**: 4개 번호 일치 (50,000원)
  - **5등**: 3개 번호 일치 (5,000원)
- 배열로 당첨 정보를 저장한다.

### [x] 수익률 계산
- 당첨 결과를 바탕으로 수익률을 계산하고 %로 환산해 출력한다.

### [x] 당첨 내역 출력
- 당첨된 각 등수별로 몇 장의 로또가 있는지 출력합니다.

### [x] 예외 처리
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException` 또는 `IllegalStateException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 해당 부분부터 입력을 다시 받습니다.
