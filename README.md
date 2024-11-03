# 🎰 우테코 프리코스 3주차 - 로또

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Gradle](https://img.shields.io/badge/Gradle-8.7-green.svg)
<hr>

## 구현 기능 목록

- 일치하는 개수에 따른 당첨 금액을 나타내는 enum 클래스 : model.Prize


- 6개의 수를 저장하는, 로또를 나타내는 객체 클래스, 유효하지 않은 로또 예외 처리 : model.Lotto


- 사용자가 구입한 로또를 저장하는 기능 : model.Lottos


- 사용자가 구입한 로또의 당첨 결과를 계산하는 기능 : model.Result


- 사용자의 입력을 받고, 결과를 처리하는 기능 : service.LottoService


- 사용자의 입력 관련 처리와 새로운 로또 생성 기능 : service.SetupService


- 사용자와의 상호작용, 입출력 기능 : view.InputView, view.OutputView


- 세부 controller와 view를 연결 : controller.MainController


- 사용자에게 받는 입력 및 입력 예외처리를 담당하는 controller : controller.InputController


- 사용자에게 받은 입력 처리를 담당하는 controller : LottoController


- 사용자에게 보여줄 출력을 담당하는 controller : controller.OutputController


- 수를 원하는 형식의 문자열로 변환하는 기능 : util.NumberToString


- 입력 예외처리와 유효한 입력을 받을 때까지 입력을 반복하는 기능 : util.LottoException, util.LottoUtils
