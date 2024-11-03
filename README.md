# java-lotto-precourse

# Class

## Domain
- Lotto
- PurchaseLotto
- WinningLotto
- ResultLotto

## Controller
- 입력된 돈 도메인으로 변환
- 구입한 로또 번호 API로 리턴
- 입력된 당첨 번호 도메인으로 변환
- 입력된 보너스 번호 도메인으로 변환
- 로또 통계
- 당첨 통계 API로 리턴
- 수익율 API로 리턴

## Handler
- ViewHandler
  - 입력 부분 검증 및 재입력 시도
  - 결과 출력
- ApiHandler
  - 입력된 돈 API로 변환
  - 입력된 로또 당첨 번호 API로 변환
  - 입력된 보너스 번호 API로 변환

## Validate List
- 1 ~ 45 사이의 숫자인지 확인하는 코드
- ","로 구분하여 6개의 문자가 입력되었는지 확인하는 코드
- 1,000원 단위로 구입할 돈이 입력되었는지 확인하는 코드
- 숫자로 입력되었는지 확인하는 코드
- 로또 6자리 숫자 중 중복되는 것이 있는지 확인하는 코드
- 보너스 숫자가 당첨 번호와 중복되는지 확인하는 코드
- 숫자 입력 중 맨 앞에 스페이스가 있다면, 삭제해주는 코드

## View
- 로또 구입 돈 입력 받기 
- 구입한 로또 번호 보여주기
- 당첨 번호 입력 받기
- 보너스 번호 입력 받기
- 당첨된 통계 보여주기
- 수익율 보여주기

## Util
- 중복되는 Try-Catch 코드를 하나로 통일
- 중복되는 if(Object isInstance api.getData) 코드 하나로 통일

# 의존 관계
- UserRequest
  - Controller
    - Service
  - viewHandler
    - Input
    - Output
    - ApiHandler
      - ValidatorImpl
        - LottoNumberRangeValidator
        - LottoNumberSplit
        - LottoPurchaseUnitValidator
        - ParseInt
        - RemoveWhiteSpace
