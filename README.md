# java-lotto-precourse

---
# 🎯 구현 기능 목록
<details>
<summary>
기능 목록
</summary>

- [x] 로또를 1~45중 중복되지 않는 6개의 숫자로 로또를 발행하는 기능
- [x] 오름차순으로 정렬하여 보여줄 것
- [x] 구입 금액을 입력받는 기능
- [x] 1000원으로 나누어 떨어지지 않는 경우는 예외처리하는 기능
- [x] 해당하는 만큼 1000원짜리 로또를 발행하는 기능
- [x] 발행한 로또 번호를 출력하는 기능
- [x] 당첨 번호 6개를 입력 받는 기능
- [x] 보너스 번호 1개를 입력 받는 기능
- [x] 당첨 내역을 계산하는 기능
- [x] 당첨 내역을 출력하는 기능
- [x] 수익률을 계산하는 기능
</details>


---
# 📚 클래스 구조
### MVC Pattern
- Application
- domain
  - Lotto

- service
  - LottoIssueService
  - LottoSortService
  - LottoRankService
  - LottoEarningService

- view
  - InputView
  - OutputView

- controller
  - LottoController

- util
  - LottoConstant
  - LottoError
  - LottoPrint
---
# 📄 클래스 명세
## 1. domain - Lotto

<details>
<summary>변수 설명</summary>

| 변수명      | 타입             | 설명          | 기본값 |
|-------------|------------------|-------------|---------|
| `numbers`   | `List<Integer>`  | 로또 번호 6개 | 없음      |

</details>

<details>
<summary>함수 설명</summary>

#### `Lotto(List<Integer> numbers)`

| 매개변수     | 타입             | 설명             | 기본값 |
|--------------|------------------|----------------|--------|
| `numbers`    | `List<Integer>`  | 로또 번호 6개 | 없음   |

- **반환값:** 없음
- **설명:** 6자리 숫자 리스트를 입력받아 검증을 거친 뒤 numbers 멤버에 주입

#### `validate(List<Integer> numbers)`

| 매개변수     | 타입             | 설명       | 기본값 |
|--------------|------------------|----------|--------|
| `numbers`    | `List<Integer>`  | 로또 번호 6개 | 없음   |

- **반환값:** 없음
- **설명:** 6자리 숫자 리스트를 입력받아 검증

#### `validateDuplicateNumber(List<Integer> numbers)`

| 매개변수     | 타입             | 설명        | 기본값 |
|--------------|------------------|-----------|--------|
| `numbers`    | `List<Integer>`  | 로또 번호 6개 | 없음   |

- **반환값:** 없음

#### `sortedNumbers()`

| 매개변수 | 타입 | 설명 | 기본값 |
|----------|------|------|--------|
| 없음     | -    |      |        |

- **반환값:** `List<Integer>` - 정렬된 번호 목록
- **설명:** 멤버 변수 numbers 를 정렬한 새 리스트를 반환

#### `countWinningNumbers(List<Integer> winningNumbers)`

| 매개변수          | 타입             | 설명       | 기본값 |
|-------------------|------------------|----------|--------|
| `winningNumbers`  | `List<Integer>`  | 당첨 번호 6개 | 없음   |

- **반환값:** `int` - 맞춘 숫자의 개수
- **설명:**

#### `checkRank(int countWin, int bonusNumber)`

| 매개변수       | 타입     | 설명     | 기본값 |
|----------------|----------|--------|--------|
| `countWin`     | `int`    | 맞춘 갯수  | 없음   |
| `bonusNumber`  | `int`    | 보너스 넘버 | 없음   |

- **반환값:** `int` - 로또 등수
- **설명:** 맞춘 갯수를 입력받아 등수를 반환

#### `toString()`

| 매개변수 | 타입 | 설명 | 기본값 |
|----------|------|------|--------|
| 없음     | -    |      |        |

- **반환값:** `String` - 로또 번호 문자열
- **설명:** 로또 출력 형식 오버라이딩

</details>

## 2. LottoController

<details>
<summary>변수 설명</summary>

| 변수명               | 타입                   | 설명              | 기본값 / 예시 |
|----------------------|------------------------|-----------------|---------------|
| `inputView`          | `InputView`            | 입력용 뷰 객체        |               |
| `outputView`         | `OutputView`           | 출력용 뷰 객체        |               |
| `lottoEarningService`| `LottoEarningService`  | 수익률 계산 서비스 객체   |               |
| `lottoIssueService`  | `LottoIssueService`    | 로또 발행 서비스 객체    |               |
| `lottoRankService`   | `LottoRankService`     | 로또 등수 계산 서비스 객체 |               |
| `lottoSortService`   | `LottoSortService`     | 로또 정렬 서비스 객체    |               |

</details>

<details>
<summary>함수 설명</summary>

#### `LottoController()`

| 매개변수 | 타입 | 설명 | 기본값 |
|----------|------|------|--------|
| 없음     | -    |      |        |

- **반환값:** 없음
- **설명:** 생성자 - 각 멤버 객체 생성

#### `tryLotto()`

| 매개변수 | 타입 | 설명 | 기본값 |
|----------|------|------|--------|
| 없음     | -    |      |        |

- **반환값:** 없음
- **설명:** 로또 기능 실행

</details>

## 3. service - LottoEarningService

<details>
<summary>함수 설명</summary>

#### `calculateEarningRate(int[] countRank)`

| 매개변수      | 타입     | 설명        | 기본값 |
|---------------|----------|-----------|--------|
| `countRank`   | `int[]`  | 등수별 당첨 갯수 | 없음   |

- **반환값:** `double` - 수익률
- **설명:** 등수별 당첨 갯수로 투자금과 당첨금을 계산해 수익률을 반환

#### `calculateCost(int[] countRank)`

| 매개변수      | 타입     | 설명        | 기본값 |
|---------------|----------|-----------|--------|
| `countRank`   | `int[]`  | 등수별 당첨 갯수 | 없음   |

- **반환값:** `int` - 총 비용
- **설명:** 총 투자 금액을 계산

#### `calculateProfit(int[] countRank)`

| 매개변수      | 타입     | 설명        | 기본값 |
|---------------|----------|-----------|--------|
| `countRank`   | `int[]`  | 등수별 당첨 갯수 | 없음   |

- **반환값:** `int` - 총 수익
- **설명:** 총 당첨금을 계산

</details>

## 4. service - LottoIssueService

<details>
<summary>함수 설명</summary>

#### `issueLottos(int issueNumber)`

| 매개변수        | 타입   | 설명    | 기본값 |
|-----------------|--------|-------|--------|
| `issueNumber`   | `int`  | 발행 갯수 | 없음   |

- **반환값:** `List<Lotto>` - 발행된 로또 목록
- **설명:** 발행 갯수만큼의 로또를 발행

#### `issueOneLotto()`

| 매개변수 | 타입 | 설명 | 기본값 |
|----------|------|------|--------|
| 없음     | -    |      |        |

- **반환값:** `Lotto` - 발행된 하나의 로또
- **설명:** 로또 한개를 발행

</details>

## 5. LottoRankService

<details>
<summary>함수 설명</summary>

#### `countRank(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber)`

| 매개변수           | 타입              | 설명        | 기본값 |
|--------------------|-------------------|-----------|--------|
| `lottos`           | `List<Lotto>`     | 발행된 로또 목록 | 없음   |
| `winningNumbers`   | `List<Integer>`   | 당첨 번호 6개  | 없음   |
| `bonusNumber`      | `int`             | 보너스 번호    | 없음   |

- **반환값:** `int[]` - 각 당첨 등수별 개수
- **설명:** 발행된 로또 목록과 당첨번호, 보너스 번호를 비교하여 당첨 등수별 갯수를 반환

</details>

## 6. LottoSortService

<details>
<summary>함수 설명</summary>

#### `sortLottos(List<Lotto> lottos)`

| 매개변수      | 타입              | 설명       | 기본값 |
|---------------|-------------------|----------|--------|
| `lottos`      | `List<Lotto>`     | 로또 번호 6개 | 없음   |

- **반환값:** `List<List<Integer>>` - 각 로또의 번호가 정렬된 리스트
- **설명:** 로또 번호를 오름차순으로 정렬하여 리스트를 반환

</details>

## 7. LottoConstant

<details>
<summary>상수 설명</summary>

| 상수명                       | 타입    | 설명                                   | 값                |
|------------------------------|---------|----------------------------------------|--------------------|
| `THE_NUMBER_OF_LOTTO_NUMBER` | `int`   | 한 로또 번호 조합의 숫자 개수          | `6`               |
| `lottoNumberRangeStart`      | `int`   | 로또 번호의 범위 시작                  | `1`               |
| `lottoNumberRangeEnd`        | `int`   | 로또 번호의 범위 끝                    | `45`              |
| `A_LOTTO_PRICE`              | `int`   | 로또 한 장의 가격                      | `1000`            |
| `PRIZE_1st`                  | `int`   | 1등 당첨 상금                           | `2000000000`      |
| `PRIZE_2nd`                  | `int`   | 2등 당첨 상금                           | `30000000`        |
| `PRIZE_3rd`                  | `int`   | 3등 당첨 상금                           | `1500000`         |
| `PRIZE_4th`                  | `int`   | 4등 당첨 상금                           | `50000`           |
| `PRIZE_5th`                  | `int`   | 5등 당첨 상금                           | `5000`            |

</details>

## 8. LottoError Enum

<details>
<summary>상수 설명</summary>

| 상수명                            | 설명               | 메시지                                            |
|-----------------------------------|--------------------|---------------------------------------------------|
| `NUMBER_COUNT_ERROR`              | 번호 개수 오류     | `[ERROR] 형식 오류 : 로또 번호는 6개 입니다.`      |
| `NUMBER_FORMAT_ERROR`             | 숫자 형식 오류     | `[ERROR] 형식 오류 : 숫자를 입력하세요.`           |
| `WINNING_NUMBER_INPUT_FORMAT_ERROR` | 당첨 번호 형식 오류 | `[ERROR] 형식 오류 : 양수 6개를 ,로 구분하여 입력하세요.` |
| `DIVIDE_1000_ERROR`               | 금액 형식 오류     | `[ERROR] 형식 오류 : 금액은 1000원 단위여야 합니다.` |
| `NUMBER_RANGE_ERROR`              | 번호 범위 오류     | `[ERROR] 범위 오류 : 번호는 1부터 45 사이의 숫자여야 합니다.` |
| `PAYMENT_RANGE_ERROR`             | 지불 금액 범위 오류 | `[ERROR] 범위 오류 : 지불 금액은 0보다 커야 합니다.` |
| `NUMBER_DUPLICATED_ERROR`         | 중복 번호 오류     | `[ERROR] 중복 오류 : 로또 번호는 중복될 수 없습니다.` |
| `BONUS_DUPLICATED_ERROR`          | 중복 보너스 번호 오류 | `[ERROR] 중복 오류 : 보너스 번호는 당첨 번호와 중복될 수 없습니다.` |

</details>

<details>
<summary>함수 설명</summary>

#### `getMessage()`

| 매개변수 | 타입 | 설명 | 기본값 |
|----------|------|------|--------|
| 없음     | -    |      |        |

- **반환값:** `String` - 에러 메시지
- **설명:** 에러문구를 출력

</details>

## 9. LottoPrint Enum

<details>
<summary>상수 설명</summary>

| 상수명                | 설명               | 메시지                                    |
|-----------------------|--------------------|-------------------------------------------|
| `ASK_PAYMENT`         | 구입금액 입력 요청 | `구입금액을 입력해 주세요.`               |
| `ALERT_BUYING_NUMBER` | 구매 개수 알림     | `개를 구매했습니다.`                       |
| `ASK_WINNING_NUMBERS` | 당첨 번호 입력 요청 | `당첨 번호를 입력해 주세요.`              |
| `ASK_BONUS_NUMBER`    | 보너스 번호 입력 요청 | `보너스 번호를 입력해 주세요.`            |
| `ALERT_START_STAT`    | 당첨 통계 시작 알림 | `당첨 통계\n---`                          |
| `STAT_PREFIX_1st`     | 1등 당첨 통계 메시지 | `6개 일치 (2,000,000,000원) - `           |
| `STAT_PREFIX_2nd`     | 2등 당첨 통계 메시지 | `5개 일치, 보너스 볼 일치 (30,000,000원) - ` |
| `STAT_PREFIX_3rd`     | 3등 당첨 통계 메시지 | `5개 일치 (1,500,000원) - `               |
| `STAT_PREFIX_4th`     | 4등 당첨 통계 메시지 | `4개 일치 (50,000원) - `                  |
| `STAT_PREFIX_5th`     | 5등 당첨 통계 메시지 | `3개 일치 (5,000원) - `                   |
| `STAT_SUFFIX`         | 통계 메시지 접미사  | `개`                                      |

</details>

<details>
<summary>함수 설명</summary>

#### `getMessage()`

| 매개변수 | 타입 | 설명 | 기본값 |
|----------|------|------|--------|
| 없음     | -    |      |        |

- **반환값:** `String` - 출력 메시지
- **설명:** 메시지를 출력

</details>


---
# 💻 사용 방법
### 1. 시작 
- 구입 금액 입력을 요구하는 안내 문구가 출력된다.
```
구입금액을 입력해 주세요.
```
### 2. 사용자 입력 - 구입 금액
- 로또 구입 금액을 입력한다.
- 로또 1장의 가격은 1000이다. 구입 금액만큼의 로또를 구입한다.
- 구입 금액은 양의 정수만 허용한다.
- 구입 금액은 1,000 단위만 허용한다.
```
8000
```
### 3. 발행한 로또 수량 및 번호 출력
- 발행한 로또 수량 및 번호가 출력된다.
```
8개를 구매했습니다.
[4, 5, 11, 20, 44, 45]
[1, 6, 10, 25, 29, 39]
[10, 28, 34, 37, 38, 40]
[2, 19, 24, 29, 33, 38]
[6, 8, 12, 26, 30, 43]
[3, 11, 18, 21, 24, 27]
[3, 5, 6, 7, 13, 25]
[22, 26, 30, 35, 42, 45]
```
### 4. 사용자 입력 - 당첨 번호
- 당첨 번호를 입력한다.
- 각 당첨 번호는 1부터 45사이의 양의 정수만 허용한다.
- 당첨 번호 입력은 ,를 기준으로 나누어진 6개의 양의 정수만 허용한다.
- 당첨 번호는 중복을 허용하지 않는다.
```
1,2,3,4,5,6
```
### 4. 사용자 입력 - 보너스 번호
- 보너스 번호를 입력한다.
- 보너스 번호는 1부터 45사이의 양의 정수만 허용한다.
- 보너스 번호는 당첨 번호와 중복을 허용하지 않는다.
```
7
```
### 5. 당첨 내역 출력
- 발행한 로또 번호와 당첨 번호 및 보너스 번호를 비교해 당첨 여부를 산출한다.
- 등수별 당첨 내역과 총 수익률이 출력된다.
- 수익률은 소수점 둘째 자리에서 반올림된다. (ex. 100.0%, 51.5%, 1,000,000.0%)
```
당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```
### 6. 종료
프로그램을 종료한다.
```
Process finished with exit code 0
```

---
# 🔧 예외 처리 테스트 케이스
1. view 
   <details>
      <summary>InputView</summary>
     
      - 지불액이 1000단위가 아닐 경우
      - 지불액이 음수인경우
      - 당첨 번호 형식
      - 당첨 번호 6개 초과
      - 당첨 번호 6개 미달
      - 당첨 번호 범위
      - 보너스 번호 형식
      - 보너스 번호 범위
      - 보너스 번호 당첨 번호와 중복
   </details>
2. domain
   <details>
      <summary>Lotto</summary>

      - 로또 번호가 중복되는 경우
      - 로또 번호 6개 초과
      - 로또 번호 6개 미달
        </details>
3. service
   1. LottoIssueService
      - 로또 발행 갯수
   2. LottoSortService
      - 로또 번호 정렬
   3. LottoRankService
      - 로또 등수 집계
   4. LottoEarningService
      - 수익률 집계
   
4. controller
   <details>
      <summary>LottoController</summary>
   
     - 로또 일반 기능 테스트
     - 당첨 테스트
     - 비당첨 테스트
      </details>

---
# ✅ 프로젝트 체크 사항

## 1. 공통 피드백
<details>
<summary>
1, 2주차 공통 피드백
</summary>

- [x] 요구 사항을 정확하게 준수한다.
- [x] 기본적인 Git 명령어를 숙지한다.
- [x] Git으로 관리할 자원을 고려한다.
- [x] 커밋 메시지를 의미 있게 작성한다.
- [x] 커밋 메시지에 이슈 또는 풀 리퀘스트 번호를 포함하지 않는다.
- [x] 풀 리퀘스트를 만든 후에는 닫지 말고 추가 커밋을 한다.
- [x] 오류를 찾을 때 출력 함수 대신 디버거를 사용한다.
- [x] 이름을 통해 의도를 드러낸다.
- [x] 변수, 클래스, 메서드 이름을 축약하지 않는다.
- [x] 공백을 의미 있게 사용하고, 스페이스와 탭을 혼용하지 않는다.
- [x] 의미 없는 주석을 달지 않는다.
- [x] 코드 포매팅을 사용한다.
- [x] Java에서 제공하는 API를 적극 활용한다.
- [x] 배열 대신 컬렉션을 사용한다.
- [x] README.md를 상세히 작성한다.
- [x] 기능 목록을 재검토하고 업데이트한다.
- [x] 값을 하드 코딩하지 않는다.
- [x] 구현 순서를 상수, 멤버 변수, 생성자, 메서드 순으로 한다.
- [x] 변수 이름에 자료형을 포함하지 않는다.
- [x] 한 메서드가 한 가지 기능만 담당하게 한다.
- [x] 메서드가 한 가지 기능을 하는지 확인하는 기준을 세운다.
- [x] 테스트를 작성하는 이유를 정리한다.
- [x] 처음부터 큰 단위의 테스트를 만들지 않는다.
</details>

## 2. 피어 리뷰 피드백

<details>
<summary>
README.me
</summary>

- [x] 입력값에 대한 상세한 조건을 추가적으로 기록하였는가?
- [x] 사용방법을 상세하게 명시하였는가?
- [x] 프로젝트의 전체적 구조를 명시하였는가?
- [x] 구체적인 테스트 케이스를 명시하였는가?
- [x] `<details>`, `<summary>` 를 통해 토글 형식을 사용하였는가?
- [x] 이모티콘을 사용해 이쁘게 꾸몄는가?
</details>

<details>
<summary>리팩토링(주석)</summary>

- [x] given/when/then 주석을 사용하였는가?
- [x] 불필요한 주석없이 함수명으로 기능을 알 수 있는가?

</details>

<details>
<summary>리팩토링(분류)</summary>

- [x] 메인 비즈니스 로직이 여러 개일 경우 service 모듈을 도입하였는가?
- [x] View도 Input, Output 구분하였는가?
    - [x] yes
- [x] 에러 메시지를 enum 또는 클래스로 관리하였는가?
    - [x] https://wellbell.tistory.com/23
- [x] 테스트 코드를 클래스를 나누어 관리하였는가?
- [x] 테스트 코드를 모듈별로 작성하였는가?

</details>

<details>
<summary>리팩토링(디테일)</summary>

- [x] 최대한 세밀하게 함수화 하였는가?
- [x] 안내문(print) 등을 상수로 표현하여 내부 enum으로 관리하였는가?
- [x] 매직넘버를 모두 상수화하였는가?

</details>

## 3. 2024 우아콘 피드백
<details>
<summary>BE 세션</summary>

- [x] 각 변수와 함수들의 스펙을 사전 형식으로 명시하였는가?
- [x] Getter Setter를 지양하였는가?
- [x] 개발 과정에서 패키지를 적절히 분할하였는가?

</details>

---