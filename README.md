# java-lotto-precourse

# 로또

## 기능목록
***
1. 로또 구입 금액을 입력 받는다 (input)   
    * 사용자로부터 1,000원 단위로 입력을 받는다   
    * 입력 받은 금액이 1,000원으로 나누어 떨어지지 않는 경우 예외 처리   
    * 입력을 받지 않았을 경우 예외 처리
***
2. 당첨 번호를 입력 받는다 (input)   
    * 사용자에게 로또 당첨 번호를 입력 받는다   
    * 입력을 받지 않았을 경우 예외 처리
***
3. 보너스 번호를 입력 받는다 (input)   
    * 사용자로부터 로또 보너스 번호를 입력 받는다   
    * 보너스 번호는 1개여야 한다   
    * 보너스 번호는 1번 부터 45번 사이에 있는 숫자이다   
    * 입력을 받지 않았을 경우 예외 처리   
    * 1번부터 45번 사이에 있는 숫자가 아닌 경우 예외 처리 (예시: 46, Y 등)
***
4. 입력 받은 당첨 번호 문자열을 숫자로 구분한다 (separator)   
    * 각 당첨 번호는 쉼표(,)를 기준으로 구분한다   
    * 당첨 번호가 6개가 아닌 경우 예외 처리   
    * 번호가 아닌 문자가 들어왔을 경우 예외 처리
***
5. 금액에 맞게 발행된 로또 번호를 추출한다 (lottoService)   
    * 구입 금액에 맞게 로또 개수를 발행한다   
    * 로또 번호는 1 ~ 45번 중 랜덤으로 6개의 값으로 지정한다   
    * 로또 번호는 오름차순으로 정렬하여 저장한다
    * 생성된 로또 번호를 가져온다
***
6. 발행한 로또 수량 및 번호를 출력한다 (output)   
    * 구입한 금액에 맞게 발행된 로또 수량 및 번호를 출력한다
***
7. 당첨 내역을 출력한다 (output)   
    * 1등~5등까지의 당첨 내역을 출력한다   
    * 각 등수마다의 결과를 한줄씩 출력한다   
    * 출력은 번호 일치 개수, 가격, 발행 개수 순서이다   
    * 0~2개 일치된 당첨 내역은 제외한다
***
8. 구입 금액으로부터 수익률을 출력한다 (output)   
    * 수익률은 소수점 둘째 자리에서 반올림한다
***
9. 기능 테스트를 작성한다   