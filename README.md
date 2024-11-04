# java-lotto-precourse

> 로또

우테코 프리코스 3주차 미션

<br>

### 기능 목록

- 데이터 입력 기능
- 로또 발행 기능
- 당첨 통계 기능
- 수익률 계산 기능

<br>

---

<br>

## 클래스 설명

### Application
애플리케이션 실행기

- main():
 각 기능 실행

<br>

### Class InputHandler
사용자 입력 처리기

- inputData(String dataName):
 사용자에게 입력 요청
- checkValidate(String inputNumber):
 1부터 45 사이의 숫자들로 이루어진 문자열인지 확인

<br>

### Class LottoGenerator
로또 티켓 생성기

- 생성자:
 메소드 호출
 1. 로또 개수(티켓) 계산
 2. 로또 생성
 3. 로또 리스트 출력
- calculateTickets(int price):
 구매 금액에 따라 로또 개수(티켓) 계산
- printLottoList():
 생성된 로또들의 번호 출력 호출

<br>

### Class LottoAnalyzer
로또 결과 계산기

- calculateStatistics(List<Lotto> lottoList, int[] winningNumbers, int bonusNumber):
 상금 종류별 부합하는 로또 개수 계산
- calculateReturn(int purchaseAmount):
 총 수익률 계산
- printResults():
 결과 (통계 및 수익률) 출력

<br>

### Class Lotto
로또

- 생성자:
 랜덤 번호 생성
- printLotto():
 로또 안에 들어있는 번호 출력
- countMatchNumbers(int[] winningNumbers):
 당첨 번호와 일치하는 개수 계산
- containBonusNumber(int bonusNumber):
 보너스 번호가 포함되어 있는지 확인

<br>

### Enum Prize
로또 상금

- THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_BONUS, SIX_MATCH
