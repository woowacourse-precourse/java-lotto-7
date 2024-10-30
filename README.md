# 🎰 우테코 프리코스 3주차 - 로또

![Java](https://img.shields.io/badge/Java-21-blue.svg)
![Gradle](https://img.shields.io/badge/Gradle-8.7-green.svg)
<hr>

## 구현 기능 목록

- 일치하는 개수에 따른 당첨 금액을 나타내는 enum 클래스 : model.Prize


- 6개의 수를 저장하는, 로또를 나타내는 객체 클래스, 유효하지 않은 로또 예외 처리 : model.Lotto


- 사용자가 구입한 로또를 저장하는 기능 : model.Lottos


- 사용자가 구입한 로또의 당첨 결과를 계산하는 기능 : model.Result


- 사용자의 입력 관련 처리와 새로운 로또 생성 기능 : service.setUpService


- 사용자의 입력을 받은 후, 결과를 처리하는 기능 : service.resultService


- 사용자와의 상호작용, 입출력 기능 : view.InputView, view.OutputView


- View와 Service/Model을 연결, 보너스 번호 예외처리 : controller.MainController, controller.InputController,
  controller.OutputController
