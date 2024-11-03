# java-lotto-precourse

## 기능 요구 사항
간단한 로또 발매기를 구현한다.

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

## 기능 목록
### <Model (도메인)>
**Lotto**
- 로또 번호 생성 기능
- 로또 번호의 유효성 검사 (1 ~ 45 사이의 중복되지 않는 숫자 6개)
- 로또 번호 오름차순 정렬

**LottoTicket**
- 사용자가 구매한 로또 티켓 정보를 관리 (여러 장의 Lotto 인스턴스를 포함)
- 티켓 수량 계산 (구입 금액에 따른 로또 수량 결정)

**WinningNumbers**
- 당첨 번호 및 보너스 번호 관리
- 당첨 번호와 보너스 번호의 유효성 검사

**LottoResult**
- 사용자가 구매한 로또와 당첨 번호를 비교하여 등수 계산
- 당첨 내역 저장 (일치하는 숫자에 따른 당첨 횟수)
- 수익률 계산

### <View (뷰)>
**InputView**
- 구입 금액 입력받기 (1,000원 단위로 예외 처리)
- 당첨 번호 입력받기 (쉼표로 구분하여 6개 숫자)
- 보너스 번호 입력받기

**OutputView**
- 구매한 로또 수량 및 번호 출력 (각 번호는 오름차순)
- 당첨 내역 출력 (일치하는 개수와 금액에 따른 당첨 횟수)
- 수익률 출력 (소수점 둘째 자리 반올림)

### <Service (서비스)>
**LottoService**
- 로또 티켓 생성
- 당첨 결과 확인
- 수익률 계산

### <Controller (컨트롤러)>
**LottoController**
- 프로그램 실행의 흐름을 제어
  - 구입 금액 입력 처리 → 로또 티켓 생성
  - 당첨 번호 및 보너스 번호 입력 처리
  - 당첨 결과 계산 및 출력
- 예외 상황 처리
  - 잘못된 구입 금액 입력 시 재입력 요청
  - 잘못된 로또 번호 입력 시 재입력 요청
  - 오류 메시지 "[ERROR]"로 시작하도록 예외 처리

### <Validator (검증)>
**LottoValidator**
- validateNumberCount(List<Integer> numbers)
  - 로또 번호의 개수를 검증합니다.
  - 조건: 반드시 6개의 번호여야 합니다.
  - 예외: 6개가 아닌 경우 IllegalArgumentException 발생.


- validateNumberRange(List<Integer> numbers)
  - 로또 번호의 범위를 검증합니다.
  - 조건: 모든 번호는 1부터 45 사이여야 합니다.
  - 예외: 범위를 벗어난 경우 IllegalArgumentException 발생.


- validateUniqueNumbers(List<Integer> numbers)
  - 로또 번호의 중복 여부를 검증합니다. 
  - 조건: 모든 번호는 서로 다르게(unique)해야 합니다. 
  - 예외: 중복된 번호가 있는 경우 IllegalArgumentException 발생.


- validatePurchaseAmount(int amount)
  - 로또 구매 금액의 유효성을 검증합니다.
  - 조건: 금액은 1,000원 단위로 양수여야 합니다.
  - 예외: 조건을 만족하지 않는 경우 IllegalArgumentException 발생.

**BonusNumberValidator**
- validateBonusNumberRange(int number)
  - 보너스 번호가 1부터 45 사이의 숫자인지 검증합니다.
  - 조건: 보너스 번호는 1 이상 45 이하의 값이어야 합니다.
  - 예외: 조건을 만족하지 않는 경우 IllegalArgumentException 발생.


- validateBonusNumberNotDuplicate(int bonusNumber, List<Integer> winningNumbers)
  - 보너스 번호가 당첨 번호와 중복되지 않는지 검증합니다.
  - 조건: 보너스 번호는 당첨 번호 리스트에 포함되어서는 안 됩니다.
  - 예외: 조건을 만족하지 않는 경우 IllegalArgumentException 발생.


- validateBonusNumberIsNumeric(String input)
  - 입력된 문자열이 숫자인지 검증합니다.
  - 조건: 입력은 숫자로 변환 가능해야 합니다.
  - 예외: 숫자가 아닌 경우 IllegalArgumentException 발생.

  
### 세부 기능 구현 흐름
**1. 구입 금액 입력**
- InputView에서 구입 금액을 입력받고, 1,000원 단위인지 검증합니다.
- 금액에 따라 LottoTicket에서 로또 수량을 결정합니다.

**2. 로또 티켓 생성**
- LottoTicket에서 구입한 수만큼 Lotto 번호 생성합니다.
- 생성된 각 로또 번호는 중복 없이 1~45 범위에서 6개의 숫자로 구성됩니다.
- OutputView를 통해 생성된 로또 번호를 오름차순으로 출력합니다.

**3. 당첨 번호 및 보너스 번호 입력**
- InputView에서 당첨 번호(6개)와 보너스 번호(1개)를 입력받아 WinningNumbers에 저장합니다.
- 입력값이 유효한지 검증합니다.

**4. 당첨 결과 계산**
- LottoResult에서 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 일치 개수를 계산합니다.
- 일치하는 개수 및 보너스 번호 일치 여부에 따라 등수를 결정합니다.
- 당첨 횟수 및 금액 정보를 LottoResult에 저장합니다.

**5. 결과 출력**
- OutputView를 통해 당첨 내역을 출력합니다.
- 수익률을 계산하여 소수점 둘째 자리에서 반올림한 후 출력합니다.

### 예외 처리
- 잘못된 구입 금액: 금액이 1,000원 단위가 아닌 경우 [ERROR] 메시지 출력 후 재입력 요청
- 잘못된 로또 번호: 숫자가 1~45 범위 밖이거나 중복된 숫자가 있는 경우 [ERROR] 메시지 출력 후 재입력 요청
- 잘못된 보너스 번호: 보너스 번호가 1~45 범위 밖이거나 당첨 번호와 중복되는 경우 [ERROR] 메시지 출력 후 재입력 요청
