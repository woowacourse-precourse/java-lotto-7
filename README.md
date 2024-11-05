# java-lotto-precourse

## 1. 입력 기능 구현
### 구입 금액과 보너스 번호 입력
Console.readLine()으로 입력받은 문자열을 Integer.parseInt()를 사용하여 Integer로 변환.
### 당첨번호 입력
사용자가 입력한 문자열을 split() 메서드로 분리하고, 각 문자열을 Integer로 변환하여 리스트에 추가.
<br>
## 2. 입력 에러 처리 기능 구현
입력 에러 처리는 throw new IllegalArgumentException()을 사용하여 예외를 발생시키고, while문을 통해 사용자가 올바른 값을 입력할 때까지 반복적으로 입력이 가능하도록 구현.
### 로또 구입 금액의 경우
FindError 클래스의 moneyError 메서드 실행.
숫자가 아닌 경우, 0 이하인 경우, 1000원 단위가 아닌 경우 예외 처리.
### 당첨번호 리스트
Lotto 클래스의 validate 메서드 실행.
로또 번호의 개수가 6개가 아닌 경우, 번호가 1~45 사이가 아닌 경우, 중복된 번호에 대한 예외처리.
### 보너스 번호
FindError 클래스의 validateBounsnumber 메서드:
보너스 번호가 1~45 사이가 아닌 경우 및 당첨번호와 중복되는 경우 처리.
<br>
## 3. 발행한 로또 수량 및 번호 출력 기능
Lotto 클래스에 메서드 추가.
### start 메서드
생성된 Lotto 객체들을 리스트로 받고, Print 클래스의 printLottos 메서드를 호출하여 출력.
### generateLottos 메서드
구입 금액을 1000으로 나눈 만큼 로또 객체를 생성. Randoms.pickUniqueNumbersInRange(1, 45, 6)를 사용하여 무작위 숫자 6개를 선택하고, 리스트에 추가.
### toString() 메서드
로또 번호 리스트를 문자열로 반환하여 출력할 수 있도록 구현.
<br>
## 4. 출력 기능
Print 클래스의 출력 메소드 실행.
### printLottos
각 로또 객체를 받아 출력.
### printStatistics
로또 결과 및 숫자를 받아 당첨 통계를 출력.

## 5. LottoResult
LottoResult enum: 로또 당첨 결과와 해당 상금을 정의하는 기능.
## 6. LottoStatistics
통계 관리: 로또 통계 정보를 관리하는 기능 (당첨 횟수, 총 구매 비용 등).
수익률 계산: 총 비용과 당첨 금액을 기반으로 수익률을 계산하는 기능.
## 7. LottoService
로또 통계 계산: 로또 구매 비용을 추가하고, 당첨 여부를 확인하는 기능.
당첨 확인: 각 로또 객체의 당첨 여부를 판단하는 기능.

