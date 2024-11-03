# 로또

## 기능 목록

### view package
- output class
    + [0] 로또 구매 개수를 출력하는 기능 - printPurchaseAmount
    + [0] 구매한 로또 번호를 출력하는 기능 - printLottoNumbers
    + [0] 당첨 통계를 출력하는 기능 - printWinningStatistics
    + [0] 수익률을 출력하는 기능 - printProfitRate
    + [0] 개행 문자 출력 기능 - printNewLine
    + [0] error 메시지 출력 기능 - printErrorMessage

- input class
    + [0] 구입 금액을 입력받는 기능 - getPurchaseAmount
    + [0] 당첨 번호를 입력받는 기능 - getWinningNumbers
    + [0] 보너스 번호를 입력받는 기능 - getBonusNumber

### model package
- LottoTransform class
    + [0] 입력된 당첨 번호를 List로 변환하는 기능 - inputToWinningNumbers
    + [0] 입력된 보너스 번호를 int로 변환하는 기능 - inputToBonusNumber
    + [0] 로또 구매 금액을 입력받아 로또 개수를 반환하는 기능 - getLottoCount
    + [0] 입력된 로또 반복 횟수 만큼 로또 생성 - createLotto
    + [0] 랜덤한 6개 숫자를 생성하는 기능 - createRandomNumbers


- LottoValidation class
    + [0] 로또 1개당 정답 로또와 동일한 숫자 판단 - isMatchWinningNumbers
    + [0] 로또 1개당 보너스 번호와 동일한 숫자 판단 - isMatchBonusNumber
    + [0] 로또 1개에 대한 당첨 결과 - validateWinningResult
    + [0] 로또 1개에 대한 당첨 결과 업데이트 - updateWinningResult
    + [0] 수익률을 계산하는 기능 - calculateProfitRate
    + [0] 전체 당첨금 계산 기능 - calculateTotalWinningAmount

### service package
- LottoMaker class : model 기능을 통해 로또 로직 구현, 자료구조 저장 위치
    + [0] 생성 로또, 당첨 번호 저장 공간
    + [0] 금액에 따라 구입 가능 로또 개수 반환 - getLottoCount
    + [0] 로또 구매 개수에 따라 로또 생성 - createLotto
    + [0] 생성된 로또 반환 - getLottoNumbers
    + [0] 당첨 번호 저장 - setWinningNumbers
    + [0] 보너스 번호 저장 - setBonusNumber
    + [0] 전체 로또에 대한 당첨 결과 생성 - createWinningResults
    + [0] 당첨 결과에 대한 수익률 반환 - getProfitRate

### controller package
- LottoManager class - 예외 발생시 재입력 위한 메서드 구현 필요
    + [0] 로또 진행 기능 - run
    + [0] 로또 구매 금액 정상 입출력 관리 - IoPurchaseAmount
    + [0] 구매한 로또 번호 출력 및 개행 - printLottoNumbers
    + [0] 당첨 번호 정상 입출력 관리 - IoWinningNumbers
    + [0] 보너스 번호 정상 입출력 관리 - IoBonusNumber
    + [0] 당첨 통계 및 수익률 출력 - printWinningResult

### utils package
- WinningLotto class
    + [0] 당첨금 관련 Enum 클래스 구현 
        + [0] 등수에 맞는 당첨금, 당첨 통계 출력 포멧 상수화
        + [0] Enum 원소 반환 기능 구현
      
- WinningResult class
  + [0] 당첨 통계 관련 Enum 클래스 구현
    + [0] 당첨 번호와 동일한 숫자 개수 연관 상수화
    + [0] 보너스 번호 일치 여부 상수화
    + [0] 각 당첨 등수와 당첨 통계 업데이트 위한 인덱스 상수화
    + [0] Enum 원소 반환 기능 구현


### exception package
- Lotto class : 생성된 로또 번호, 입력된 당첨 번호에 대한 검증 진행
    + [0] 입력한 로또 번호가 비어있즌지 검증 - emptyValidate
    + [0] 입력한 로또 번호가 6개가 맞는지 검증 - validate
    + [0] 입력한 로또 번호가 음수인지 검증 - negativeValidate
    + [0] 입력한 로또 번호가 중복인지 검증 - duplicateValidate
    + [0] 입력한 로또 번호가 범위 내에 있는지 검증 - rangeValidate
  
- PurchaseAmount class : 구매 금액에 대한 검증 진행
    + [0] 입력한 값이 비어있는지 검증 - emptyValidate
    + [0] 입력한 값이 숫자인지 검증 - numberValidate
    + [0] 입력한 구매 금액이 1000원 이상인지 검증 - rangeValidate
    + [0] 입력한 구매 금액이 1000원 단위인지 검증 - unitValidate

- BonusNumber class : 보너스 번호 입력에 대한 검증 진행
    + [0] 입력한 값이 비어있는지 검증 - emptyValidate
    + [0] 입력한 보너스 번호가 숫자인지 검증 - numberValidate
    + [0] 입력한 보너스 번호가 범위 내에 있는지 검증 - rangeValidate

## 구현 규칙
- 메서드 길이는 15라인 이내로 구성한다.
- indent(들여쓰기) depth를 2단계로 제한한다.
- 3항 연산자 사용 금지
- else 사용하지 않는다
- Enum을 적용한다.
- 하드 코딩 값을 상수화 한다
- 상수, 변수, 생성자, 메서드 순서로 구현한다.
- 변수명에 자료형은 제거한다
- 기능 단위테스트를 구현한다.
- 하나의 메서드는 하나의 일을 한다
