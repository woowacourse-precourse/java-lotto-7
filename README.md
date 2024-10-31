# java-lotto-precourse

# 🚀 기능 구현 목록

## 로또

- 생성 시 유효성 검사
    -  로또 번호가 6개가 아니라면 예외를 발생시킨다.
    -  중복된 숫자가 있다면 예외를 발생시킨다.
-  생성 시 로또 번호를 오름차순으로 정렬한다.
-  숫자를 전달받아 해당 숫자가 포함되어 있는지 여부를 반환한다.
-  당첨 로또를 전달받아 정답 개수를 반환한다.

## 로또 머신

-  생성 개수를 전달받아 개수만큼 로또를 생성한다.
-  로또 당첨 번호를 전달받아 당첨 로또를 생성한다.

## 로또 매니저

-  금액을 전달받아 금액에 맞게 로또 생성을 로또 머신에게 요청한다.
-  로또 당첨 번호를 전달받아 로또 머신에게 당첨 로또 생성을 요청한다.
-  당첨 로또와 보너스 번호를 전달받아 보너스 번호의 유효성을 검사한다.
    -  당첨 로또가 null인 경우 예외를 발생시킨다.
    -  당첨 로또 번호와 보너스 번호가 중복일 경우 예외를 발생시킨다.

## 로또 결과

-  생성 시 당첨 로또와 보너스 번호를 초기화 한다.
    -  당첨 로또 생성을 로또 매니저에게 요청한다.
    -  보너스 번호의 유효성 검사를 로또 매니저에게 요청한다.
-  로또를 전달받아 등수를 계산한다.

## 구매자

-  로또 매니저에게 로또를 구입한다.
-  당첨 내역을 계산한다.
-  수익률을 계산한다.

## 입력

-  금액을 입력 받는다.
    -  1000원 단위로 나누어 떨어지지 않으면 예외를 발생시킨다.
    -  Integer 자료형이 아니라면 예외를 발생시킨다.
-  당첨 번호를 입력받는다.
    -  쉼표(,)를 기준으로 구분한다.
    -  숫자가 아니라면 예외를 발생시킨다.
    -  입력 받은 번호가 1부터 45사이의 범위가 아니라면 예외를 발생시킨다.
-  보너스 번호를 입력 받는다.
    -  숫자가 아니라면 예외를 발생시킨다.
    -  입력 받은 번호가 1부터 45사이의 범위가 아니라면 예외를 발생시킨다.

## 출력

-  발행한 로또 수량 및 번호를 출력한다.
-  수익률은 소수점 둘째 자리에서 반올림한다.
-  당첨 내역을 출력한다.

--- 

## MVC 패턴 구조
### Main
- [ ] Application
### Model
- [x] Lotto 
- [x] LottoMachine
- [x] LottoManager
- [x] LottoResult
- [x] LottoBuyer
### View
- [x] InputView
- [ ] OutputView
### Controller
- [ ] LottoGameController
### Enum
- [x] LottoGrade
- [x] LottoNumberRange
### Util
- [x] LottoNumberGenerator
- [x] RandomNumberGenerator
- [x] Validator
  - [x] LottoPriceValidator
  - [x] LottoNumberValidator
  - [x] BonusNumberValidator
- [x] ExceptionMessage
### DTO
- [x] LottoDto
- [x] LottoResultDto
- [x] LottoNumberListDto
