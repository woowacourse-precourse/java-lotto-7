# java-lotto-precourse

## 구현 기능 목록
| 분류      | 기능           | 기능 상세                            | 완료 여부               |
|---------|--------------|----------------------------------|---------------------|
| `입력`    | 구입 금액 입력     | 구입금액을 입력받는 기능                    | :white_large_square: |
| `입력`    | 당첨 번호 입력     | 당첨 번호 6개를 입력받는 기능                | :white_large_square: |
| `입력`    | 보너스 번호 입력    | 보너스 번호 1개를 입력받는 기능               | :white_large_square: |
| `출력`    | 구입금액 입력 안내   | 구입금액을 입력하도록 안내하는 문구 출력           | :white_large_square: |
| `출력`    | 구매한 로또 출력    | 구매한 로또 개수와 발급 결과를 출력하는 기능        | :white_large_square: |
| `출력`    | 당첨 번호 입력 안내  | 당첨 번호를 사용자가 입력하도록 안내하는 문구 출력     | :white_large_square: |
| `출력`    | 보너스 번호 입력 안내 | 보너스 번호를 사용자가 입력하도록 안내하는 문구 출력    | :white_large_square: |
| `출력`    | 개수별 당첨 통계 출력 | 일치하는 숫자의 개수별 당첨 결과를 출력           | :white_large_square: |
| `출력`    | 수익률 출력       | 총 수익률의 값을 소수점 둘째자리까지 출력          | :white_large_square: |
| `출력`    | 에러메시지 출력     | "[ERROR]"로 시작하는 에러 메시지를 출력       | :white_large_square: |
| `유효성검사` | 금액 숫자 확인     | 입력된 금액이 숫자인지 확인                  | :white_large_square: |
| `유효성검사` | 최소금액 확인      | 입력된 금액이 1000원 이상, 100000원 이하인지 확인 | :white_large_square: |
| `유효성검사` | 금액 단위 확인     | 입력된 금액이 1000원 단위인지 확인            | :white_large_square: |
| `유효성검사` | 개수 확인        | 입력된 값이 6개인지 확인                   | :white_large_square: |
| `유효성검사` | 숫자 확인        | 입력된 값이 모두 숫자인지 확인                | :white_large_square: |
| `유효성검사` |              | 값이 숫자인지 확인                       | :white_large_square: |
| `유효성검사` | 숫자 범위 확인     | 모든 숫자가 유효한 범위 내의 숫자인지 확인         | :white_large_square: |
| `유효성검사` |              | 1~45 범위 내의 숫자인지 확인               | :white_large_square: |
| `유효성검사` | 숫자 중복 확인     | 6개의 숫자가 서로 중복되지 않는지 확인           | :white_large_square: |
| `유효성검사` | 보너스 번호 중복 확인 | 보너스 번호가 6개의 당첨 번호와 중복되지 않는지 확인   | :white_large_square: |
| `로또생성`  | 로또 구매        | 입력된 금액에 맞는 로또 개수를 계산             | :white_large_square: |
| `로또생성`  | 로또 발급        | 구매한 로또 개수만큼 로또 발급(저장)            | :white_large_square: |
| `로또생성`  |              | 로또 한장 발급                         | :white_large_square: |
| `로또생성`  | 당첨번호 저장      | 입력된 당첨 번호를 저장                    | :white_large_square: |
| `로또생성`  | 보너스 번호 저장    | 입력된 보너스 번호를 저장                   | :white_large_square: |
| `당첨통계`  | 당첨 확인        | 로또 한장의 당첨 결과를 확인                 | :white_large_square: |
| `당첨통계`  |              | 발급된 모든 로또의 당첨 결과를 기록             | :white_large_square: |
| `당첨통계`  | 수익률 계산       | 총 수익률을 계산                   | :white_large_square: |
