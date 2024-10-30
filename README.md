# 로또 발매기

***

## 입력

_**숫자 하나**의 앞 뒤에 존재하는 공백 문자는 제거한다_

- 로또 구입 금액을 입력 받는다
- 쉼표(`,`)로 구분되어지는 당첨 번호를 입력 받는다
- 보너스 번호를 입력 받는다
- 잘못된 입력을 받은 경우, 에러 메시지를 출력하고 재입력받는다

__입력 예외__

- 숫자가 아닌 값이 입력됨
- 정수 범위를 벗어남
- 쉼표(`,`)로 구분되어지지 않은 리스트가 입력됨

## 로또

- `로또 구입 금액 / 1000`만큼 로또를 발행한다
    - `1 ~ 45`사이의 중복되지 않는 6개의 숫자로 한 로또를 구성한다
    - 당첨은 1등부터 5등까지 존재한다.
        - 1등 - 6개 번호 일치 / 2,000,000,000원
        - 2등 - 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등 - 5개 번호 일치 / 1,500,000원
        - 4등 - 4개 번호 일치 / 50,000원
        - 5등 - 3개 번호 일치 / 5,000원
    - 구매된 로또로부터 당첨 통계를 구한다
        - 각 등수별 몇 개의 로또가 당첨됐는지 구한다
        - 총 당첨 금액을 구한다

__로또 예외__

- 구입 금액
    - `1000`단위 값이 아님
- 사용자 입력 당첨 번호와 보너스 번호
    - 6개 + 1개가 아님
    - `1 ~ 45` 범위 벗어남
    - 중복된 값 존재
- 추첨된 번호에 중복이 존재함

## 출력

_각 출력 항목은 **빈 줄**로 구분된다_

- 각 입력을 받기 전 '`입력 내용`을 입력해 주세요.\n' 출력한다
- 로또 개수와 구매한 로또를 출력한다
    - '`로또 개수`개를 구매했습니다.\n' 출력한다
    - '[`', '로 구분된 6개 당첨 번호`]\n'를 로또 개수만큼 출력한다
- 당첨과 보너스 번호를 입력 받으면 당첨 통계를 출력한다
    - '당첨 통계\n---' 출력한다
    - 5등 부터 1등 순으로
    - 출력 포맷은 '`일치하는 번호 개수` (`당첨금액`) - `당첨된 로또 수`개'다
    - 2등의 경우 '5개 일치, 보너스 볼 일치 (30,000,000원) - `당첨된 로또 수`개'이다
    - '총 수익률은 `수익률`입니다.\n' 출력한다
    - 수익률은 `당첨 금액 / 구입 금액 * 100`%다
    - 수익률은 소수점 둘째 자리에서 반올림하여 첫째 자리까지 출력한다