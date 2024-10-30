# java-lotto-precourse

### 기능 요구 사항

간단한 로또 발매기를 구현한다.

- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, `"[ERROR]"`로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException`등과 같은 명확한 유형을 처리한다.

### 기능 목록

1. 사용자 입력 기능
    - 로또 구입 금액 입력 받기
    - 당첨 번호 입력 받기
    - 보너스 번호 입력 받기
2. 사용자 입력 처리
    - 입력값이 `null`인 경우 예외 처리
    - 로또 구입 금액
        - 예외 조건
            - 숫자가 아닌 경우 (예: `a`,`,`,`1a4000`)
            - 숫자 사이에 공백이 있는 경우 (예: `"1 4 0 0 0"`)
            - 구입 금액이 1000원~100000원 이 아닌 경우 (예: `0`, `-1000`, `200000`)
            - 1000원 단위로 나누어 떨어지지 않는 경우 (예: `14500`, `500`)
        - 정상 입력
            - 1000원 단위로 나누어 떨어지는 경우(예: `14000`)
    - 당첨 번호
        - 예외 조건
            - 숫자와 쉼표(,) 형식이 아닌 경우 (예: `a,b,c,d,e,f`, `1.2.3.4.5.6`)
            - 숫자와 쉼표 사이에 공백이 있는 경우 (예: `1, 2,3,4,5,6`)
            - 쉼표가 비정상적으로 있는 경우 (예: `,1,2,3,4,5,6,`, `1,,2,3,4,5,6`)
            - 숫자가 6개가 아닌 경우 (예: `1,2,3,4,5`)
            - 각 숫자가 1~45 범위가 아닌 경우 (예: `46,45,44,43,42,41`)
            - 중복 숫자가 있는 경우 (예: `1,1,2,3,4,5`)
        - 정상 입력
            - 쉼표로 구분된 1~45 범위의 숫자 6개 (예: `1,2,3,4,5,6`)
    - 보너스 번호
        - 예외 조건
            - 숫자가 아닌 경우 (예: `a`, `,`)
            - 1~45 범위가 아닌 경우 (예: `46`, `100`)
            - 당첨 번호와 중복인 경우 (예: 당첨 번호 `1,2,3,4,5,6` 보너스 번호 `1`)
        - 정상 입력
            - 당첨 번호와 중복되지 않는 1~45 범위의 숫자 (예: 당첨 번호 `1,2,3,4,5,6` 보너스 번호 `45`)
3. 로또 구현
    - 로또 발행
        - 로또 수량(구입 금액 / 1000) 출력
        - 각 로또는 1~45 범위 중 6개를 랜덤으로 생성
        - 각 로또 내 번호는 오름차순으로 정렬
        - 모든 로또 출력
    - 당첨 내역 확인
        - 발행된 로또 번호와 당첨 번호 비교
        - 당첨 등급에 따라 나누어 당첨 내역 출력
    - 수익률
        - 총 당첨금 계산
        - 수익률(총 당첨금 / 구입 금액 * 100) 계산 후 출력 (소수점 둘째 자리에서 반올림)
    - 예외 상황 발생 시 에러 문구 출력