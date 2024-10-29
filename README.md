# java-lotto-precourse

# 로또 미션

Java로 구현하는 로또 프로젝트입니다. 이 프로젝트는 다양한 기능을 메서드 단위로 나누어 설계하며, 함수 분리와 테스트를 통해 코드 품질을 개선하는 것을 목표로 합니다.

## 프로젝트 목표
- 여러 역할을 수행하는 함수를 단일 역할을 수행하는 작은 함수로 분리하여 구현합니다.
- 테스트 코드 작성을 통해 프로그램의 정확성을 확인하고, 커밋 메시지와 README 파일을 통해 프로젝트를 문서화합니다.

## 메서드 단위 기능 목록

### 1. 사용자 입력 처리 메서드
- `getAmoutPaid()`
    - [ ] 콘솔에서 로또 구입 금액을 입력받는다.
    - [ ] 1000원단위로 나누어 떨어지지 않는 경우 예외처리한다.
    - [ ] 유효하지 않은 입력이 있을 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

- `getLottoNumber()`
    - [ ] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
    - [ ] 유효하지 않은 숫자 입력 시 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  
- `getBonusNumber()`
  - [ ] 보너스 번호를 입력 받는다.
  - [ ] 유효하지 않은 숫자 입력 시 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
  
### 2. 로또 준비 메서드
- `initializeLotto(Integer num)`
  - [ ]  입력받은 구입금액을 통해 각 로또 객체를 초기화한다.

### 3. 로또 번호를 생성하는 메서드
- `generateLottoNumbers()`
    - [ ]  중복되지 않는 1~45 범위의 랜덤한 숫자 6개 생성한다.
    - [ ]  오름차순 정렬하여 반환한다.

### 4. 당첨 여부 확인 메서드
- `checkWinningStatus(List<Lotto> purchasedLottos)`
    - [ ] 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 계산한다.

### 5. 보너스 당첨 여부 확인 메서드
- `checkBonusStatus(Integer bonus)`
  - [ ] 구매한 로또 번호와 보너스 번호를 비교하여 당첨 내역 계산한다.

### 6. 수익률 계산 메서드
- `calculateProfitRate(int totalPrizeMoney, int purchaseAmount)`
    - [ ] 수익률 계산 후 소수점 둘째 자리까지 반올림한다.

### 7. 당첨 결과 밑 수익률 출력 메서드
- `printStatistics()`
  - [ ] 당첨 결과를 바탕으로 등수별 당첨 개수 출력한다.
  - [ ] 수익률 계산 결과를 바탕으로 등수별 당첨 개수 출력한다.

### 8. 에러 처리 메서드
- `handleInputError(String errorMessage)`
    - [ ] "[ERROR]"로 시작하는 에러 메시지 출력한다.
