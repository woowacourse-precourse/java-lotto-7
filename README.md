# java-lotto-precourse

## 기능 목록 정리

> ##### 요구사항을 바탕으로 기능 목록을 작성

#### 입력
- **로또 구입 금액을 입력 받는다.**
    - 로또 1장은 1,000원, `n`개의 로또를 발행
    - 입력값이 숫자가 아닌 경우 예외 발생
    - 0원을 입력받은 경우 예외 발생
    - 1,000원으로 나누어 떨어지지 않는 경우 예외 발생
- **당첨 번호 6개를 입력 받는다.**
    - 숫자 범위는 `1~45`
    - 번호는 쉼표(`,`)를 기준으로 구분
    - 중복되는 숫자가 있는 경우 예외 발생
- **보너스 번호 1개를 입력받는다.**
    - 당첨 번호와 중복되는 경우 예외 발생
- **예외 처리**
    - 예외 발생 시 `[ERROR]`로 시작하는 메시지 출력
    - 에러의 유형을 메시지에 같이 담아 출력
    - 잘못된 부분부터 다시 입력을 받음

#### 로또
- **로또 발매기에서 자동으로 로또를 발행한다.**
    - 랜덤으로 중복되지 않는 당첨 번호 6개와 보너스 번호 1개를 뽑음
- **당첨 여부를 판단한다.**
    - 당첨이면 해당 로또 등수의 카운트를 증가시킨다.
    - 기준
        - 1등: 6개 번호 일치 / 2,000,000,000원
        - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
        - 3등: 5개 번호 일치 / 1,500,000원
        - 4등: 4개 번호 일치 / 50,000원
        - 5등: 3개 번호 일치 / 5,000원


#### 수익률
- **총 수익률을 계산한다.**
    - 수익률 = (당첨금 / 구입금액) * 100
    - 소수점 둘째 자리에서 반올림
