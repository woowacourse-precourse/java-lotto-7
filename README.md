# java-lotto-precourse

# 미션 - 로또

## 🚀 기능 요구 목록
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
- Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다

## 🚀 파일 구조
- Model
    - InputService
    - Lotto
- Controller
    - LottoController
- View
    - InputView
    - OutputView
- Exception
    - InvalidDuplicateNumberException
    - InvalidDuplicateBonusNumberException
    - InvalidLottoNumberException
    - InvalidNumberCountException
    - InvalidPurchaseAmountException
    - InvalidProfitRateFormatException
    - InvalidBonusNumberException

## 🚀 기능 구현
- [x] 랜덤번호 6개 생성
- [x] 입력금액 / 1000 개만큼 랜덤번호 생성
- [x] 당첨번호와 랜덤번호 비교
- [x] enum으로 당첨순위 관리
- [x] 당첨번호에 따른 가격 수익률 계산

## 🚀 예외 처리
- 당첨 번호가 6개가 아닌 경우
    - IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.”);
- 번호가 숫자가 아닌 경우
    - InvalidNumericException("[ERROR] 잘못된 입력값입니다. 입력값은 숫자여야합니다."); 
- 당첨 번호가 1~45사이의 번호가 아닌 경우
    - InvalidLottoNumberException(“[ERROR] 로또 번호는 1~45사이의 숫자여야 합니다.”); 
- 당첨 번호가 중복된 경우
    - InvalidDuplicateNumberException("[ERROR] 로또 번호에 중복된 숫자가 있습니다."); 
- 보너스 번호가 1개가 아닌 경우
    - InvalidBonusValueException("[ERROR] 보너스 번호는 1개여야 합니다.”);
- 보너스 번호가 1~45사이의 번호가 아닌 경우
    - InvalidBonusNumberException(“[ERROR] 보너스 번호는 1~45사이의 숫자여야 합니다.”);
- 보너스 번호가 당첨 번호와 중복된 경우
    - InvalidDuplicateBonusNumberException("[ERROR] 당첨 번호가 중복될 수 없습니다.");
- 구입금액이 1000으로 나누어 떨어지지 않는 경우
    - InvalidPurchaseAmountException(“[ERROR] 구입금액은 1000으로 나누어 떨어져야 합니다.”);
- 수익률이 소수점 한자리까지가 아닌 경우
    - InvalidProfitRateFormatException(“[ERROR] 수익률은 소수점 한자리까지 출력되어야 합니다.”);
