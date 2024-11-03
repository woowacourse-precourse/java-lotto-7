![image](https://github.com/user-attachments/assets/f37f95a7-7a5f-43ef-b3c8-cd8d76e1b618)
> 7기 프리코스 3주차 미션 - 로또
> ====================== 
> java-calculator-precourse
<br>

# **학습 목표**

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.
- [2주 차 공통 피드백](https://docs.google.com/document/d/1QW_762N0WC6JvAiDHNBYXzLJ60y1Azex1d7tID0BggM/edit?usp=sharing)을 최대한 반영한다.

# **✏️ 프로그램의 흐름 정리**

<aside>

1. 사용자가 로또 구입 금액을 입력
2. 구입 장수 및 구입한 번호(랜덤) 출력
3. 당첨 번호를 입력
4. 보너스 번호를 입력
5. 당첨 통계 출력

**`잘못된 값`  정의**

- 로또 번호의 범위는 1~45 이다.

  → 0과 음수, 46 이상의 숫자와 문자는 잘못된 값.

  - 숫자가 아닌 경우 (문자) → **`NumberFormatException`**
  - 숫자이지만 범위에 벗어난 경우 (0, 음수, 46 이상) → **`IllegalArgumentException`**
- 당첨 로또의 번호를 입력할 때도 로또 번호의 범위와 중복에 대해서 처리해야 함.
  - 당첨 로또의 번호
    - 범위) 1~45
      - 범위에 벗어날 경우 → **`IllegalArgumentException`**
    - 중복) 허용안됨
      - 중복되는 숫자를 고른 경우 → **`DuplicateNumberException`**
    - 개수) 6개
      - 6개 이외의 숫자를 고른 경우 → **`IllegalArgumentException`**
  - 보너스 번호
    - 범위) 1~45
      - 범위에 벗어날 경우 → **`IllegalArgumentException`**
    - 중복) 허용안됨
      - 중복되는 숫자를 고른 경우 → **`DuplicateNumberException`**
    - 개수) 1개
      - 1개 이외의 숫자를 고른 경우 → **`IllegalArgumentException`**
- 로또 구입 금액은 1,000원 단위로 입력 받아야 한다.
  - 1,000원으로 나누어 떨어지지 않는 경우는 예외 처리를 한다.
    - 나누어 떨어지지 않는 경우 → **`ArithmeticException`**
    - 2,147,483,000원 이상 구매하려는 경우 → **`IllegalArgumentException`**
    - 0원 또는 음수일 경우 → **`IllegalArgumentException`**

</aside>  

## 그래서 무슨 예외 타입들을 사용할까?

| 예외 유형                     | 사용 시점                  | 설명                                               | 적용                                                                    |
|-------------------------------|----------------------------|----------------------------------------------------|--------------------------------------------------------------------------|
| **`IllegalArgumentException`** | 잘못된 인자 전달 시         | 범위 외 값(예: 음수, 0, 46 이상) 전달 시 사용          | 로또 번호 <br/>- (0, 음수, 46 이상) <br/>- 공백 <br/>- 빈 문자열(`\n`) <br/>로또 구입 금액 |
| **`NumberFormatException`**   | 숫자 변환 실패 시           | 숫자 아닌 문자열을 숫자로 변환할 때 사용              | 숫자가 아닌 문자                                                          |
| **`ArithmeticException`**     | 수학적 계산 오류 시         | 1,000원 단위로 나누어지지 않을 때 사용               | 금액이 1,000원 단위가 아닐 때                                              |
| **`NullPointerException`**    | null 값이 전달된 경우       | 입력값이 null인지 체크                              | 로또 번호가 null                                                          |
| **`DuplicateNumberException`**| 사용자 정의 예외, 중복 번호 처리 시 | 번호 중복 시 명확한 예외를 제공                     | 로또 번호 중복 (당첨 번호, 서비스 번호)                                       |



--- 

# **기능 구현 목록**

- [ ] **로또 구입 금액 입력 및 검증**
  - [ ] 로또 구입 금액을 입력받고 유효성 검사를 진행한다.
    - [ ] 1,000원 단위로 나누어 떨어지지 않는 경우 `ArithmeticException` 발생
    - [ ] `2,147,483,000`원 이상 입력 시 `IllegalArgumentException` 발생
    - [ ] 0원 또는 음수 입력 시 `IllegalArgumentException` 발생

- [ ] **로또 번호 생성**
  - [ ] 입력받은 구입 금액에 따라 랜덤하게 로또 번호를 생성한다.
  - [ ] 각 로또 번호는 중복되지 않는 1~45 사이의 숫자 6개로 구성된다.

- [ ] **로또 번호 출력**
  - [ ] 구매한 로또 번호를 오름차순으로 정렬하여 출력한다.
  - [ ] 예시 출력: `8개를 구매했습니다. [8, 21, 23, 41, 42, 43]` 등.

- [ ] **당첨 번호 입력 및 검증**
  - [ ] 당첨 번호 6개를 입력받고 유효성을 검증한다.
    - [ ] 1~45 범위 내에 있어야 하며, 중복이 없어야 한다.
    - [ ] 범위 벗어날 경우 `IllegalArgumentException` 발생
    - [ ] 중복 시 `DuplicateNumberException` 발생

- [ ] **보너스 번호 입력 및 검증**
  - [ ] 보너스 번호 1개를 입력받고 유효성을 검증한다.
    - [ ] 1~45 범위 내의 숫자여야 하고, 당첨 번호와 중복되지 않아야 한다.
    - [ ] 범위 벗어날 경우 `IllegalArgumentException` 발생
    - [ ] 중복 시 `DuplicateNumberException` 발생

- [ ] **당첨 결과 계산**
  - [ ] 구매한 로또 번호와 당첨 번호를 비교하여 일치하는 개수를 계산한다.
  - [ ] 각 등수별 당첨 여부를 판별하여 1등부터 5등까지 당첨 내역을 저장한다.

- [ ] **수익률 계산**
  - [ ] 총 상금과 구입 금액을 기준으로 수익률을 계산하여 소수점 둘째 자리에서 반올림하여 출력한다.
  - [ ] 예시 출력: `총 수익률은 62.5%입니다.`

- [ ] **당첨 결과 출력**
  - [ ] 당첨 결과에 따른 등수별 당첨 횟수와 상금을 출력한다.
  - [ ] 예시 출력: `3개 일치 (5,000원) - 1개`, `6개 일치 (2,000,000,000원) - 0개`

- [ ] **에러 처리**
  - [ ] 잘못된 입력에 대해 `[ERROR]`로 시작하는 메시지를 출력하고, 해당 입력을 다시 받는다.
    - [ ] 입력된 값이 유효 범위를 벗어나거나 형식이 잘못되었을 경우 적절한 예외 처리



# **프로젝트 구조**

- Controller
    - LottoGameController
- DTO
  - RandomLottoNumberDTO
  - PaymentPriceDTO
  - WinningNumberDTO
  - BonusNumberDTO
  - LottoStatisticsDTO
- Factory
    - LottoDomainFactory
- Domain
    - RandomLottoNumbersGenerator
    - PrizeMoneyCalculator
    - PurchasePriceCalculator
    - Lotto
    - Numbers
- Service
    - LottoService
- Util
    - Error
        - ErrorType
        - ErrorMessage
    - Constant
        - IOMessage
        - GeneralConstants
- Validation
    - WinNumbersValidator
    - BonusNumberValidator
    - PriceValidator
- View
    - InputView
    - OutputView

---

<aside>
💡

3주차 미션에서 내가 꼭 지켜야 할 사항들

1. 일급 컬렉션을 사용하자.
2. 내가 코딩할 때 고민하는 부분들을 블로그에 업로드 해보자.
3. 자바독 사용해보자.
4. 하나의 메서드는 하나의 일에 대해서만 책임져야 한다.
5. 메서드 길이가 15라인이 넘지 않도록 한다.
6. 메서드를 최소한의 단위로 분리하자.
7. `else` 예약어 사용하지 말자. `if` 문에서 `return` 사용하면 else와 비슷한 효과 가능.
8. `Enum`을 적극 활용하자.
9. **단위 테스트** 를 적극 활용해보자.
</aside>

