# java-lotto-precourse
### 기능 목록
#### Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리
#### 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다. 에러 문구를 출력하고 에러가 난 지점부터 다시 시작한다.
>1. 구입금액을 입력받는 기능
>   - 예외처리할 부분
>      1. 1000의 배수가 아닌 수를 입력한 경우
>      2. 문자를 입력한 경우
>2. 금액만큼 로또를 구입하는 기능
>   - 세부 기능
>     1. Randoms.pickUniqueNumbersInRange(1, 45, 6);을 사용하여 번호를 뽑고 오름차순으로 정리하여 로또를 발행하는 기능
>     2. 구입한 로또를 저장하는 기능
>     3. 구입한 로또를 출력하는 기능
>3. 당첨번호 입력받는 기능
>   - 예외처리할 부분
>      1. 1~45의 자연수 이외의 숫자 또는 문자를 입력한 경우
>      2. 중복되는 번호를 입력한 경우
>4. 보너스 번호 입력받는 기능
>   - 예외처리 할 부분
>     1. 1~45의 자연수 이외의 숫자 또는 문자를 입력한 경우
>     2. 당첨번호와 중복되는 번호를 입력한 경우
>5. 당첨 기준에따라 당첨 내역을 확인하는 기능
>   1. 등수별로 당첨 결과를 확인하는 기능
>   2. 수익률을 계산하는 기능
>6. 당첨 내역을 출력하는 기능

로또 발매기능
로또 추첨, 당첨확인기능

vendingmachine패키지 - VendingMachineController.java
            - VendingMachineService.java
            - VendingMachineRepo.java

draw패키지 - DrawController.java
        - DrawService.java
        - WINNING.java(Enum)
