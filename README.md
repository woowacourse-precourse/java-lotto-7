# java-lotto-precourse
## 개요 
> 사용자에게 **로또 구입 금액**, **당첨 번호**, **보너스 번호**를 입력받고 로또 구입 금액만큼 로또를 발행한다.
> 발행한 **로또 수량**과 **로또 번호**, **당첨 내역** 및 **수익률**을 출력하고 로또 게임을 종료한다.
>
> ```
> 구입금액을 입력해 주세요.
> 8000
>
> 8개를 구매했습니다.
> [8, 21, 23, 41, 42, 43]
> [3, 5, 11, 16, 32, 38]
> [7, 11, 16, 35, 36, 44]
> [1, 8, 11, 31, 41, 42]
> [13, 14, 16, 38, 42, 45]
> [7, 11, 30, 40, 42, 43]
> [2, 13, 22, 32, 38, 45]
> [1, 3, 5, 14, 22, 45]
>
> 당첨 번호를 입력해 주세요.
> 1,2,3,4,5,6
>
> 보너스 번호를 입력해 주세요.
> 7
>
> 당첨 통계
> ---
> 3개 일치 (5,000원) - 1개
> 4개 일치 (50,000원) - 0개
> 5개 일치 (1,500,000원) - 0개
> 5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
> 6개 일치 (2,000,000,000원) - 0개
> 총 수익률은 62.5%입니다.
> ```

## 기능 목록

### 입력
- [x] 로또 구입 금액을 입력받는다.
- [x] 당첨 번호를 입력 받는다.
- [x] 보너스 번호를 입력 받는다.

### 로또 발행 준비
- [x] 입력한 구입 금액만큼 발행할 로또의 개수를 계산한다.
- [x] 입력한 당첨 번호를 구분자(,)를 이용해 구분한다. 

### 로또 발행
- [x] 1에서 45 사이 중복되지 않는 정수 6개를 반환한다.
  - [x] 로또의 개수만큼 반복한다.

### 당첨 통계 
- [x] 발행한 로또 번호와 당첨 번호를 비교한다.
  - [x] 일치 개수에 따라 등수를 가린다.
  - [x] 당첨 금액과 구입 금액을 통해 수익률을 계산한다.

### 출력
- [x] 발행한 로또 수량을 출력한다.
- [x] 발행한 로또 번호들을 출력한다.
  - [x] 로또 번호는 오름차순으로 출력한다. 
- [x] 당첨 내역을 출력한다.
- [x] 소수점 둘째자리에서 반올림한 수익률을 출력한다. 

### 예외 처리
  - [x] 유효하지 않은 입력: ```IllegalArgumentException```을 발생시킨다.
    - [x] 정수가 아닌 입력
    - [x] 양수가 아닌 입력
    - [x] 로또 번호의 크기 
    - [x] 로또 번호의 범위
    - [x] 로또 가격보다 적은 구매 금액
    - [x] 로또 번호의 중복 여부
    - [x] "[ERROR]"로 시작하는 에러 메세지를 출력한다.
    - [x] 잘못된 입력 부분부터 재입력 받는다.
  - [x] 유효하지 않은 객체: ```IllegalStateException```을 발생시킨다.

### 단위 테스트 
- [ ] 기능 별 테스트 구현


## 프로젝트 구조
```
|   Application.java
|
+---controllers
|       LottoController.java
|
+---models
|       Bonus.java
|       Lotto.java
|       LottoIssuer.java
|       Statistics.java
|       StatisticsCalculator.java
|       YieldCalculator.java
|
+---services
|       LottoService.java
|
+---utils
|       Constants.java
|       ErrorMessages.java
|       MessageFormatter.java
|       Messages.java
|       Prize.java
|
+---validation
|       InputValidator.java
|
\---views
        InputView.java
        LottoView.java
        OutputView.java
```
## 역할 분담 
### controllers
#### LottoController
- service, views와 상호작용
- 사용자 입출력 처리 및 서비스를 프로젝트 플로우에 맞게 호출한다.
### services
#### LottoService
- models, controllers와 상호작용
- 적절한 기능을 model에서 호출한다.
### models
#### LottoIssuer
- 구매 금액만큼 로또를 발행하고, 구매 금액, 발행 권수, 발행한 로또를 관리한다.
#### Lotto
- 당첨 번호를 관리한다.
#### Bonus
- 보너스 번호를 관리한다.
#### Statistics
- 로또 통계를 관리한다.
#### StatisticsCalculator
- 로또 통계를 계산한다.
#### YieldCalculator
- 수익률을 계산한다.
### validation
#### InputValidater
- 사용자 입력을 1차적으로 검증한다.
### views
#### LottoView
- 콘솔 입출력 메소드
#### InputView
- 사용자 입력을 담당한다.
#### OutputView
- 출력을 담당한다.
### utils
#### Messages
- 프롬프트를 저장한다.
#### ErrorMessages
- 에러 메세지를 저장한다.
#### MessageFormatter
- 메세지를 포맷팅한다.
#### Constatns
- 상수를 저장한다.
#### Prize
- 로또 상금에 대한 Enum
