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
<br>
## 5. LottoResult
### LottoResult enum 구현
```java
public enum LottoResult {
    THREE_MATCH(5000, "3개 일치"),
    FOUR_MATCH(50000, "4개 일치"),
    FIVE_MATCH(1500000, "5개 일치"),
    FIVE_BONUS_MATCH(30000000, "5개 + 보너스 일치"),
    SIX_MATCH(2000000000, "6개 일치");
}
```
각 결과와 해당하는 상금을 정의.
<br>
## 6. LottoStatistics
### LottoResult와 Integer를 맵으로 구성
### public LottoStatistics() 생성자
Integer의 초기값을 0으로 설정.
### recordWin(LottoResult result) 메서드
해당 결과의 카운트를 증가시키는 메서드.
### getStatistics()
외부에서 통계 값을 읽을 수 있도록 제공.
<br>
## 7. LottoService
### calculateStatistics 메서드
LottoStatistics 객체를 만들고, 각 로또 결과를 체크하여 당첨번호 및 보너스 번호와 비교.
### checkWinning / countMatchingNumbers 메서드
각 숫자를 비교하여 입력한 로또 번호가 당첨 번호에 포함되는지 확인하고, 포함되면 카운트를 늘림.
### determineResult 메서드
각 카운트 개수별로 비교하여 LottoResult 값을 대입.
5개일 경우 보너스 숫자 포함 여부 확인. 조건부 함수를 사용하지 않고 각 결과별로 핸들 메서드 생성.
