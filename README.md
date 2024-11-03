## 🥅목표

이전 코드에서는 **디자인 패턴**을 중심으로 프로젝트를 설계해나가는 방식으로 구성하였습니다. 그렇게 진행하니, 코드 자체에 대한 복잡도가 증가하여 너무 많은 분리가 일어나는 문제점이 존재했습니다. 그래서 이번
주차의 목표는 **도메인** 클래스를 만들고, 딱 필요한 **기능 클래스**만을 만들기 위해서 노력했습니다.

## 도메인 명세서

| 번호 | 도메인 명                 | 설명                                                                                                                                                                                                | 수행 유무 |
|----|-----------------------|---------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|-------|
| 1  | Lotto                 | 6개의 로또 번호를 담고 있는 클래스<br/><br/>**[조건]**<br/>1. 로또 번호가 6자리여야함.<br/>2. 로또 번호에 중복이 없어야함.<br/>3. 로또 번호는 1~45까지의 숫자 중 하나로 구성되어야함.                                                                            | N     |
| 2  | LottoBuyer            | 로또를 구매하는 사람<br/><br/>**[조건]**<br/>1.로또를 구매할 때, money가 null이 아니여야함.                                                                                                                                       | N     |
| 3  | LottoTicket           | Lotto와 Money를 담고 있는 클래스<br/><br/>**[조건]**<br/>1. Lotto와 Money가 null이 아니여야함.                                                                                                                              | N     |
| 4  | LottoTickets          | LottoTicket 리스트와 총 금액을 담고 있는 클래스                                                                                                                                                                  | N     |
| 5  | Money                 | 로또를 사기 위한 돈을 담는 클래스<br/><br/>**[조건]**<br/>1. 금액이 1000원 단위로 끊어져야함.<br/>2. 금액이 0원 보다 커야함.                                                                                                                  | N     |
| 6  | ProfitRate            | 수익률을 담는 클래스(BigDecimal로 정확도 가져감)<br/><br/>**[조건]**<br/>1. ProfitRate를 만들 때, origin Money가 null이 아니여야함.                                                                                                   | N     |
| 7  | WinningAnalysisReport | 추첨 분석 결과에 대한 리포트를 보여주는 클래스<br/><br/>**[조건]**<br/> 1.WinningStatistics가 null이 아니여야함. 2. profitRate가 null이 아니여야함.                                                                                          | N     |
| 8  | WinningNumbers        | 추첨 번호를 담고 있는 클래스 (Lotto + bonusNumber)<br/><br/>**[조건]**<br/>1.mainNumbers가 null이 아니여야함.<br/>2.bonusNumber가 null이 아니여야함.<br/>3.mainNumber와 bonusNumber가 중복되지 않아야함.<br/>4. bonusNumber이 1~45사이의 숫자를 가져야함. | N     |
| 9  | WinningRule           | 추첨 결과에 대한 규칙이 들어있다. (상금과, 해당 상금을 받는 조건 포함)                                                                                                                                                        | N     |
| 10 | WinningStatistics     | 추첨 결과를 담고 있는 클래스 (수익률, 당첨유무 포함)  <br/><br/>**[조건]**<br/>1. TreeMap으로 구성하여 정렬된 상태로 구성되어야함.<br/>2. increment를 할 때 Rule이 null이 아니여야함.                                                                       | N     |

## 기타 기능 명세
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

위의 조건에 맞게 retry 로직을 구성하기 위해서 **함수형 인터페이스**로 SupplierWithException을 구성하고 retryOnError 메소드에서 이에 대한 처리를 해주고, 다른 입력 메소드에서 이를 사용하여 input에 대해서 공통적으로 에러 처리를 해준다.

이를 사용하게 되면, 무한정으로 retry로직을 보내는 것을 막기위해서 최대 횟수를 5회로 제한하여 구성했다.

