# 로또 생성기   

## 기능명세   
 - #### 로또 발행 기능
    - 1개의 로또는 중복되지 않는 6개의 숫자로 이루어진다.
        - 로또 번호의 숫자는 1에서 45사이 정수이다.   

- #### 당첨 번호를 입력받는 기능
    - 사용자로부터 문자열을 입력받는다.
    - 입력된 문자열을 쉼표(,)를 기준으로 6개의 숫자로 구분한다.
        - 쉼표(,)로 구분된 문자열이 숫자인지 검증한다.
    - 빈문자열이 입력되었는지 검증한다.
    - 당첨 번호가 6개인지 검증한다.
    - 구분된 숫자가 1에서 45사이의 정수인지 검증한다.
    - 구분된 6개의 숫자가 중복되지 않는지 검증한다.   
- #### 보너스 번호를 입력받는 기능
    - 보너스 번호는 숫자 1개를 입력받는다.
        - 입력된 문자열이 숫자인지 검증한다.
    - 숫자가 1에서 45사이의 정수인지 검증한다.
    - 보너스 번호가 당첨 번호와 중복되지 않는지 검증한다.

- #### 발행한 로또의 당첨 여부를 확인하는 기능
    - 로또 번호와 당첨 번호를 비교한다.
    - 5개의 번호만 일치하면 보너스 번호를 비교한다.
        - 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
            - 1등: 6개 번호 일치 / 2,000,000,000원
            - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
            - 3등: 5개 번호 일치 / 1,500,000원
            - 4등: 4개 번호 일치 / 50,000원
            - 5등: 3개 번호 일치 / 5,000원
        
- #### 로또 구입 금액을 입력받는 기능
    - 구입 금액은 1,000원 단위로 입력 받는다
        - 1000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
    
- #### 사용자가 값을 잘못 입력한 경우 예외를 발생시키고 에러메시지를 출력한 후 다시 입력받는다.

- #### 구입 금액에 해당하는 만큼 로또를 발행하는 기능
    - 로또 1장의 가격은 1,000원이다.

- #### 생성된 로또 번호를 출력하는 기능
    - 로또 번호는 오름차순으로 정렬하여 보여준다.

- #### 당첨 내역을 출력하는 기능

- #### 수익률을 출력하는 기능
    - 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
