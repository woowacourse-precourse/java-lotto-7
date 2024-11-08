# java-lotto-precourse

## 아키텍처

**MVC (Model-View-Controller)** 패턴을 따릅니다.

> - **Model**: 이벤트를 처리하고, 변경된 데이터를 View에게 전달합니다.
>- **View**: Model로부터 받은 데이터를 이용해 화면을 구성합니다.
>- **Controller**: View로부터 발생한 이벤트를 Model에게 전달하고, Model로부터 받은 데이터를 View에게 반환합니다.

---

## Model

### LottoCreator
- [X] 금액을 입력받아 금액만큼 Lottos 생성

### Lottos
- [X] 로또 당첨 현황 계산

### Lotto
- [X] 로또 등수 반환 

### EarningCalculator
- [X] 수익률 계산

### WinNumber
- [X] 보너스와 번호가 일치하는것이 있는지
- [X] 정답과 번호가 일치하는 것이 몇개인지

### Money
- [X] 구매가능한 로또 개수 계산

## View
### InputView
- [X] 사용자의 입력

### OutputView
- [X] 요구사항에 맞도록 출력

## Controller

### LottoController
- [X] 로또 게임 실행