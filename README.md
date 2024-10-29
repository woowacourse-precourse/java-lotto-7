# java-lotto-precourse

## **구현 기능 목록**

### [] 기능 1: 로또 구입 금액 입력 및 검증
- 설명: 사용자가 로또 구입 금액을 입력하고, 입력값을 검증하여 올바른 값인 경우에만 처리한다.
  - 구입 금액은 1,000원 단위로 입력되어야 하며, 1,000원으로 나누어떨어지지 않으면 예외 처리 후 재입력 받는다.
  - 예외 발생 시 "[ERROR]"로 시작하는 에러 메시지를 출력한다.

### [] 기능 2: 로또 번호 발행
- 설명: 사용자의 구입 금액에 따라 필요한 수만큼 로또 번호를 발행한다.
  -로또 한 장은 중복되지 않는 1부터 45 사이의 6개의 숫자로 구성된다.
  - 발행된 번호는 오름차순으로 정렬하여 출력한다.
  - 고정된 값(예: 번호 범위)을 상수로 관리하여 유지보수를 용이하게 한다.

### [] 기능 3: 당첨 번호 및 보너스 번호 입력 및 검증
- 설명: 사용자가 당첨 번호와 보너스 번호를 입력하며, 이 값을 검증하여 정상적인 경우에만 처리한다.
  - 당첨 번호는 중복되지 않는 6개의 숫자, 보너스 번호는 1개의 숫자여야 한다.
  - 유효하지 않은 경우 예외를 발생시키고 다시 입력받는다.

### [] 기능 4: 당첨 내역 및 수익률 계산
- 설명: 로또 결과를 통해 당첨 내역과 수익률을 계산하고, 최종 결과를 출력한다.
  - 각 등수별 당첨 기준을 만족하는 경우에 따라 당첨 내역을 출력한다.
  - 수익률을 계산하여 소수점 둘째 자리에서 반올림하여 표시한다.

### [] 기능 5: 테스트 코드 작성
- 설명: JUnit 5와 AssertJ를 이용하여 각 기능이 정상적으로 작동하는지 확인하기 위한 테스트 코드를 작성하고 실행한다.
  - 정상 케이스뿐 아니라 예외 케이스도 포함하여 입력과 출력의 정확성을 검증한다.
  - 기능 구현 전 작은 단위로 테스트 코드를 작성하여 빠른 피드백을 받는다.

## 개선 및 스타일 규칙

### [] 코드 개선 사항
- 상수 관리: 고정된 값(예: 로또 번호 범위, 당첨 기준 등)을 상수로 정의하여 가독성을 높이고 유지보수를 용이하게 한다.
- 클래스 및 메서드 구현 순서: 클래스는 상수, 멤버 변수, 생성자, 메서드 순서로 작성하며, 변수 이름에는 자료형을 포함하지 않는다.

### [] 메서드 작성 규칙
- 단일 기능 원칙: 메서드는 한 가지 기능만 수행해야 하며, 길이가 15라인을 넘지 않도록 구현한다.
- 중복 코드 분리: 여러 메서드에서 중복되는 코드는 별도 메서드로 분리해 관리한다.
- 테스트 코드 작성 규칙: 테스트는 가능한 한 작은 단위로 작성하여 각 기능의 피드백을 신속하게 확인한다.
  - 예시: 무작위 값이 4 이상이면 자동차가 전진하는 단위 테스트, 3 이하일 때는 멈추는 단위 테스트 등.

### [] 테스트 코드 작성 이유
- 설명: 테스트 코드는 구현한 기능이 정상 작동하는지 검증하며, 코드의 정확성을 즉각적으로 확인할 수 있다. 테스트를 작성함으로써 발생 가능한 오류를 사전에 발견하고, 코드 구조와 의도를 명확히 이해할 수 있어 학습에 큰 도움이 된다.
