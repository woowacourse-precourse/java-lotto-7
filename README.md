# java-lotto-precourse

간단한 로또 발매기를 구현한다.

# 학습 목표

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

# 프로그램의 흐름

1. 로또 구입 금액 입력
2. 구입 금액에 따른 로또 발행
3. 발행한 로또 개수와 로또 번호 출력
4. 당첨 번호 6개 입력
5. 보너스 번호 1개 입력
6. 당첨 계산
7. 당첨 통계 출력
8. 수익률 출력

# 기능 요구 사항

- [X] 로또 구입 금액 입력 기능
    - [X] 1000원 단위의 로또 구입 금액 입력 받기
    - [X] 1000원으로 나누어 떨어지지 않으면 예외
    - [X] 금액이 양수가 아니면 예외
    - [X] 금액이 1_000_000_000(10억)원 초과하면 예외 (최대 1_000_000장 이하)
    - [X] 잘못된 값을 입력할 경우 그 부분부터 입력을 다시 받기
- [X] 로또 발행 기능
    -  [X] 1000원당 1장의 로또를 발행
    -  [X] 로또 번호가 중복되면 예외
    -  [X] 로또 번호가 6개가 아니면 예외
    -  [X] 로또 번호는 1~45 사이의 숫자
- [X] 발행한 로또들 확인 기능
    - [X] 발행한 로또 개수 확인
    - [X] 발행한 로또를 오름차순으로 정렬하여 확인
- [X] 당첨 번호 입력 기능
    - [X] 중복되지 않는 숫자 6개 입력 받기
    - [X] 당첨 번호는 쉼표`,`를 기준으로 구분
    - [X] 숫자와 `,` 이외 값이 들어오면 예외
    - [X] `,`가 붙어 있거나 시작이나 끝에 있으면 예외
    - [X] 당첨 번호의 개수가 6개가 아니라면 예외
    - [X] 당첨 번호가 1~45사이의 숫자가 아니면 예외
    - [X] 당첨 번호가 중복되면 예외
    - [X] 잘못된 값을 입력할 경우 그 부분부터 입력을 다시 받기
- [X] 보너스 번호 입력 기능
    - [X] 당첨 번호와 중복되지 않는 보너스 번호 1개 입력 받기
    - [X] 보너스 번호가 숫자가 아니라면 예외
    - [X] 보너스 번호는 1~45 사이의 숫자가 아니면 예외
    - [X] 당첨 번호와 보너스 번호는 중복되면 예외
    - [X] 잘못된 값을 입력할 경우 그 부분부터 입력을 다시 받기
- [X] 당첨 결과 출력 기능
    - [X] 티켓 별 당첨 등수 확인 하기
    - [X] 당첨 금액 확인 하기
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원
    - [X] 당첨 통계 확인 하기 (등수와 해당 등수 당첨 개수)
- [X] 수익률 확인 기능
    - [X] 로또 구입 금액 대비 당첨 금액의 비율을 계산 하기
    - [X] 소수점 둘째 자리에서 반올림 (ex. 100.0%, 51.5%, 1,000,000.0%)

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

# 실행 결과 예시

```text
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

# 프로그래밍 요구 사항

- indent depth 2이하로 작성
- 3항 연산자 금지
- JUnit 5와 AssertJ를 사용하여 테스트 작성
- 메서드의 길이가 15라인을 넘어가지 않도록 구현
- else 예약어를 쓰지 않기
- Java Enum 적용
- 구현 기능에 대한 단위 테스트 작성
    - UI 로직은 제외(Sysout, Sysin, Scanner)