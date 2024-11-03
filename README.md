# java-lotto-precourse

## 로또 기능 요구사항

### 입력과 출력

1. 로또 구입 금액(1장에 1,000원), 당첨 번호 6개 (컴마 기준), 보너스 번호 입력
    - 당첨 번호 입력 예시 (1,2,3,4,5,6)
2. 로또 구입 금액에 따른 로또 개수, 당첨 내역, 수익률 출력
    - 당첨 수익금은 int 범위를 넘어 갈 수 있음

### 비즈니스 로직

1. 로또 구입 금액에 따라 로또 생성(1장에 6개의 번호, 1~45까지의 번호, 중복 없음)
2. 당첨 번호와 로또 번호 비교, 보너스 번호를 포함하여 비교
3. 로또 수익률 계산
    - 수익률은 소수점 둘째 자리에서 반올림(첫째 자리 까지 출력)

### 입력에 대한 검증

1. 입력 받은 로또 구입 금액이 1,000원 단위인지
2. 입력 받은 당첨 번호와 보너스 번호가 1~45 사이의 숫자인지
3. 입력 받은 숫자가 6개가 넘어갈 경우, 중복된 숫자가 있는지

## 로또 정상적인 상황 & 예외 사항

- 잘못된 입력 값에 대해서는 `IllegalArgumentException`과 함께 [ERROR] 메시지 출력 후 잘못된 입력 부터 다시 입력 받기

[정상적인 상황]

1. 검증 된 입력 값에 대한 로또 구입 금액, 당첨 번호, 보너스 번호를 통해 로또 구입, 당첨, 수익률 계산 및 출력

[예외 상황]

[금액]

1. 입력 받은 금액이 1,000원 단위가 아닌 경우
2. 입력 받은 금액이 양의 정수가 아닌 경우
3. 입력 받은 금액이 1,000 원 미만인 경우
4. 입력 받은 금액이 1,000,000 원 초과인 경우

[로또 번호]

1. 로또 번호가 1~45 사이의 숫자가 아닌 경우
2. 로또 번호가 6개가 아닌 경우
3. 로또 번호가 중복된 경우
4. 로또 번호가 정렬되어 있지 않은 경우

[당첨 번호]

1. 입력 받은 당첨 번호가 없는 경우
2. 입력 받은 당첨 번호가 6개가 아닌 경우
3. 입력 받은 당첨 번호가 , 로 구분되지 않은 경우
4. 입력 받은 당첨 번호와 보너스 번호가 1~45 사이의 숫자가 아닌 경우
5. 입력 받은 당첨 번호가 중복된 경우

[보너스 번호]

1. 입력 받은 보너스 번호가 1개가 아닌 경우
2. 입력 받은 보너스 번호가 당첨 번호와 중복된 경우
3. 입력 받은 보너스 번호가 1~45 사이의 숫자가 아닌 경우
