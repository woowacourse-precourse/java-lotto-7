# java-lotto-precourse

## 기능
- **입력 검증**: 입력된 당첨 번호가 적법한 범위인지 확인하여 다음을 걸러냅니다:
    - 숫자가 아닌 문자
    - 음수인 숫자
    - 0
    - 45를 초과하는 숫자
- **구매 처리**: 입력된 금액을 로또 티켓 구매 횟수로 변환합니다.
	- 입력된 금액이 1000원으로 나누어 떨어지지 않으면 예외가 발생하도록 합니다. 
- **랜덤 번호 생성**: 구매한 티켓 수만큼 로또 번호를 자동으로 생성합니다.
- **당첨 번호 입력**: 사용자가 당첨 번호를 입력할 수 있도록 합니다.
- **보너스 번호 입력**: 사용자가 보너스 번호를 입력할 수 있도록 합니다.
- **당첨 확인**: 자동으로 생성된 로또 번호가 당첨 번호와 일치하는지 확인합니다.
- **상금 등급 확인**: 일치하는 결과에 따라 당첨된 티켓의 등급을 결정합니다.
- **상금 출력**: 당첨된 티켓의 등급에 따른 상금을 출력합니다.
- **수익률 계산**: 구매 금액 대비 수익률을 계산하여 출력합니다.