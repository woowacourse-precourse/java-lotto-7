# java-lotto-precourse

## 요구 사항 분석

일반적인 로또랑 거의 비슷한거 같다

다만 약간의 차이가 있다면 당첨번호를 사용자에게 입력받고 실제 로또 발급은 랜덤으로만 가능하다


## 입력

1. 로또 금액 입력
	- 로또는 한장당 1000원이고 여러장 구매 가능하다
	- 천원 단위가 아니면 예외를 던진다

2. 당첨 번호 입력
	- 쉼표 단위로 당첨 금액을 입력받는다
	- 각 번호는 중복되지 않는다
	- 각 반호는 1~45 범위 내의 자연수다

3. 보너스 번호 입력
	- 보너스 번호 또한 당첨 번호와 동일한 수의 범위다
	- 다만 보너스 번호는 하나의 수만 입력받는다

## 출력

1. 발행한 로또 수량 및 번호를 출력
	- 로또 금액 만큼 구매한 수량을 출력한다
	- 해당 수량만큼의 로또를 발급한 결과를 출력한다
	- 발급 결과는 오름차순으로 정렬된다


2. 당첨 내역 출력
	- 발행한 로또 중 당첨 번호와 대조한 결과를 출력한다
	- 일치 수의 오름차순으로 결과를 출력한다
	- 일치 갯수를 출력한다

3. 총 수익률 출력
- $당첨금/투자금$을 소수점 둘째자리에서 반올림해 출력한다


### 출력 공통사항
- 모든 천단위 출력은 [미국식 숫자 구분 표현](https://docs.oracle.com/cd/E19683-01/816-3980/overview-48/index.html)을 사용한다
- 에러 발생시 에러 문구는 "[ERROR]"로 시작한다


## 구현 항목

Common
- String Parser: 문자열을 Wrapper 타입 또는 Wrapper를 활용한 컬랙션으로 파싱(Integer나 String)
- ApplicationConfigurer: 애플리케이션 초기화 및 설정을 관장
- CollectionValidator: 컬랙션 요소의 중복 검사 혹은 크기 검사
- Displayable: 출력 가능하도록 만드는 인터페이스
- RandomGenerator: 랜덤값을 출력
- SystemMessage: 시스템 메세지 열거체

Endpoint
Input
    - InputView: 입력기 인터페이스
    - ConsoleInputView: 콘솔창 입력을 받는 입력기
Output
    - OutputView: 출력 인터페이스
    - ConsoleOutputView: 콘솔창에 출력하는 출력기
- AbstractIOHandler: IO 객체들을 통합 처리
Domain
- Lotto(제공 되어있음): 로또 도메인 객체, 로또 번호를 가지고 있음
- LottoFactory: 로또 생성을 관장
- Lottos: Lotto 일급 컬렉션
- Rank: 로또 등수 열거체
- Result: 로또들의 결과를 담은 전달 객체
- Winning Lotto: Lotto와 보너스 번호를 가진 도메인 객체

Controller
- DrawController: 추첨 프로세스 컨트롤
- PurchaseController: 구매 프로세스 컨트롤

Service
- ApplicationRunner: 애플리케이션 프로세스 조합
