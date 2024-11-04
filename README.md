# java-lotto-precourse
## 간단한 로또 발매기를 구현한다.  
  
### 학습 목표🤔

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- 2주 차 공통 피드백을 최대한 반영한다.  
  

### 기능 목록🎰

- [ ]  로또 구입 금액을 입력받는다.
- [ ]  로또를 발행한다.
    - 구입 금액에 해당하는 만큼  발행한다.
    - 로또 1장의 가격은 1,000원이다.
    - 1에서 45 사이의 중복되지 않은 정수 6개를 반환한다.
- [ ]  당첨 번호를 입력받는다.
    - 로또 번호의 숫자 범위는 1~45까지이다.
    - 중복되지 않는 숫자 6개를 입력한다.
    - 번호는 쉼표(,)를 기준으로 구분한다.
- [ ]  보너스 번호를 입력받는다.
    - 당첨 번호 6개와 중복되지 않는 보너스 번호 1개를 뽑는다.
- [ ]  사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 구한다.
- [ ]  당첨 내역을 출력한다.
    - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
- [ ]  수익률을 구한다.
    - 사용자가 구매한 로또 번호와 당첨 번호를 비교해야 한다.
- [ ]  수익률을 출력한다.
- [ ]  사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

### 예외 처리🔎

#### 구입금액

- [ ]  구입 금액이 1,000원으로 나누어 떨어지지 않는 경우

#### 로또 번호

- [ ]  로또 번호의 숫자 범위를 벗어난 경우
- [ ]  ,로 구분하지 않았을 경우

#### 당첨번호
- [ ]  당첨 번호에 있는 보너스 번호를 입력한 경우
