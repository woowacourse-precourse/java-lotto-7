## java-lotto-precourse <br>
## 로또

--- 

### 기능 개요

**기능 이름** : 로또 발급 및 당첨 확인

**기능 설명** :  사용자가 입력한 금액에 따라 로또 번호를 자동으로 생성하고, 사용자에게 당첨 번호와 보너스 번호를 입력받아 발급된 로또 번호와 비교한다. 그 결과로 당첨 등수를 판별하고, 전체 수익률을 계산해 사용자에게 제공하는 기능이다.

---

### 기능 요구 사항
- 로또 번호의 숫자 범위는 1~45까지이다. 
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다. 
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다. 
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다. 
  - 1등: 6개 번호 일치 / 2,000,000,000원 
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원 
  - 3등: 5개 번호 일치 / 1,500,000원 
  - 4등: 4개 번호 일치 / 50,000원 
  - 5등: 3개 번호 일치 / 5,000원 
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다. 
- 로또 1장의 가격은 1,000원이다. 
- 당첨 번호와 보너스 번호를 입력받는다. 
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다. 
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다. 
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

---

### 구현 기능 목록
#### 1. 구입 금액 입력 및 검증
- "구입 금액을 입력해 주세요."라는 안내 메시지와 함께 로또 구입 금액을 입력받는다.
- 입력 값이 공백이 아닌지, 숫자인지 확인하고, 0보다 큰 숫자인지 확인하고, 1000원 단위로 나눠지는지 검증한다. 
  - 잘못된 입력 시 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지 출력 후 로또 구입 금액을 다시 입력받는다.

#### 2. 로또 발행
- 입력된 금액에 맞춰 로또 장수를 계산하고, 각 장당 중복되지 않는 6개의 숫자를 1~45 범위 내에서 발행한다.
- 발행된 각 번호가 1~45 사이인지 검증한다.
  - 잘못된 번호 발행 시 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지 출력 후 로또를 재발급한다.

#### 3. 당첨 번호 입력 및 검증
- "당첨 번호를 입력해 주세요."라는 메시지를 출력하고 쉼표로 구분된 당첨 번호를 입력받는다.
- 쉼표 기준으로 분리 했을 때, 공백이 존재하지 않고, 1~45 사이의 중복되지 않는 숫자 6개로 구성되었는지 검증한다.
  - 잘못된 입력 시 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지 출력 후 당첨 번호를 다시 입력받는다.

#### 4. 보너스 번호 입력 및 검증
- "보너스 번호를 입력해 주세요."라는 메시지를 출력하고 1개의 보너스 번호를 입력받는다.
- 입력 값이 당첨 번호와 중복되지 않고, 1~45 사이의 한 개의 숫자인지 검증한다. 
  - 잘못된 입력 시 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지 출력 후 보너스 번호를 다시 입력받는다.

#### 5. 당첨 결과 처리
- 구매한 로또 번호와 입력된 당첨 번호를 비교하여 당첨 내역을 계산한다.
- 1등부터 5등까지의 당첨 기준에 맞춰 몇 장이 당첨되었는지와 총 당첨 금액을 산출한다.

#### 6. 수익률 계산 및 출력
- 총 당첨 금액을 기준으로 수익률을 계산한다.
- 수익률은 소수점 둘째 자리에서 반올림한다.
- 당첨 내역과 수익률을 출력하여 사용자에게 보여준다.

