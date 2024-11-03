# 프리코스 3주차 과제

## ✏️ 구현 기능 목록

### ✔️ 정상 입력 처리

#### 입력

- 로또 구입 금액을 입력받는다.
    - 로또 구입 금액 양 끝에 공백이 포함된 경우, 공백을 제거한다.
    - 로또 구입 금액을 문자열에서 숫자로 변환한다.
    - 로또 구입 금액에 대한 유효성을 검증한다.
        - 로또 구입 금액은 음수일 수 없다.
        - 로또 구입 금액은 숫자여야 한다.
        - 로또 구입 금액은 1,000원 단위여야 한다.
        - 로또 구입 금액은 비어 있을 수 없다.
- 당첨 번호를 입력받는다.
    - 당첨 번호는 쉼표(,)로 구분한다.
    - 당첨 번호 양 끝에 공백이 포함된 경우, 공백을 제거한다.
    - 당첨 번호를 문자열에서 숫자로 변환한다.
    - 당첨 번호에 대한 유효성을 검증한다.
        - 당첨 번호는 숫자여야 한다.
        - 당첨 번호는 중복될 수 없다.
        - 당첨 번호는 6개여야 한다.
        - 당첨 번호는 비어 있을 수 없다.
        - 당첨 번호의 범위는 1~45로 제한된다.
- 보너스 번호를 입력받는다.
    - 보너스 번호 양 끝에 공백이 포함된 경우, 공백을 제거한다.
    - 보너스 번호를 문자열에서 숫자로 변환한다.
    - 보너스 번호에 대한 유효성을 검증한다.
        - 보너스 번호는 숫자여야 한다.
        - 보너스 번호는 당첨 번호와 중복될 수 없다.
        - 보너스 번호는 비어있을 수 없다.
        - 보너스 번호의 범위는 1~45로 제한된다.

#### 출력

- 발행된 로또 수량과 번호를 출력한다.
    - 로또 번호는 오름차순으로 정렬한다.
- 당첨 내역을 출력한다.
    - 로또 번호를 당첨 내역 형식에 맞게 포맷팅한다.
- 수익률을 출력한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다.
- 예외 상황 시 오류 메시지를 출력한다.
    - 오류 메시지는 "\[ERROR]"로 시작해야 한다.

#### 기능

- 구입 금액을 1,000원으로 나누어 구매한 로또 수량을 계산한다.
- 입력받은 당첨 번호를 통해 당첨 티켓을 생성한다.
- 로또 번호를 1~45 범위에서 중복되지 않는 숫자 6개로 랜덤 생성한다.
- 구매한 수량만큼 생성한 랜덤 번호로 로또 티켓 리스트를 만든다.
- 생성된 로또 티켓을 오름차순으로 정렬한다.
- 구매한 로또 번호와 당첨 번호 및 보너스 번호를 비교하여 당첨 등수를 판별한다.
- 발행한 로또 금액 대비 수익률을 계산한다.
- 수익률을 소수점 둘째 자리에서 반올림한다.

### ⚠️ 예외

IllegalArgumentException을 발생시키고, "\[ERROR]"로 시작하는 오류 메시지를 출력한다.

- 로또 구입 금액이 숫자가 아닐 경우
- 로또 구입 금액이 1,000원 단위가 아닐 경우
- 로또 구입 금액이 비어 있을 경우
- 당첨 번호가 숫자가 아닐 경우
- 당첨 번호가 중복될 경우
- 당첨 번호가 6개가 아닐 경우
- 당첨 번호가 비어있을 경우
- 당첨 번호의 범위가 1~45를 벗어나는 경우
- 보너스 번호가 숫자가 아닐 경우
- 보너스 번호가 당첨 번호와 중복될 경우
- 보너스 번호가 비어 있을 경우
- 보너스 번호의 범위가 1~45를 벗어나는 경우

<br>

## 📌 최종 기능 명세

| Package       | Class             | Method                           | Input                      | Output           | Description                             |
|---------------|-------------------|----------------------------------|----------------------------|------------------|-----------------------------------------|
| controller    | 	LottoController  | 	run()	                          | 	                          | 	                | 로또 구매 및 처리 실행                           |
| model.domain	 | Lotto	            | of()	                            | List\<Integer>	            | Lotto	           | 새로운 로또 티켓 인스턴스 생성                       |
|               |                   | getNumbers()	                    |                            | 	List\<Integer>	 | 로또 티켓에 포함된 번호 목록 반환                     |
|               |                   | getStringNumbers()	              | 	                          | List\<String>    | 	로또 번호 목록을 문자열로 반환                      |
|               | WinningLotto      | 	of()	                           | List\<Integer>, Integer	   | WinningLotto	    | 당첨 번호와 보너스 번호로 새로운 당첨 로또 인스턴스 생성        |
|               |                   | getNumbers()	                    |                            | 	List\<Integer>	 | 당첨 번호 목록 반환                             |
|               |                   | getBonusNumber()                 | 		                         | Integer	         | 보너스 번호 반환                               |
| model         | 	RankCounter	     | create()	                        |                            | 	RankCounter     | 	각 등수별 카운터를 초기화한 객체 생성                  |
|               |                   | getRankCount()                   | 	Rank	                     | Integer          | 	특정 등수의 당첨 개수 반환                        |
|               |                   | increaseRankCount()              | 	Rank                      | 	                | 	특정 등수의 당첨 개수 증가                        |
| service       | 	LottoService	    | calculateLottoCount()	           | Integer	                   | Integer	         | 구매 금액을 기반으로 구매할 로또 개수 계산                |
|               |                   | createWinningTicket()            | 	List\<Integer>, Integer   | 	WinningLotto	   | 당첨 번호와 보너스 번호로 당첨 로또 티켓 생성              |
|               |                   | createLottoTickets()             | 	Integer                   | 	List\<Lotto>	   | 주어진 개수만큼 로또 티켓 생성                       |
|               |                   | determineWinning()	              | WinningLotto, List\<Lotto> | 	RankCounter	    | 구매한 로또 티켓의 등수를 판별하여 결과 반환               |
|               |                   | calculateEarningRate()           | 	RankCounter, Integer      | 	double	         | 당첨 금액을 기반으로 수익률 계산                      |
| util          | 	Parser	          | parseInputToInt()                | 	String	                   | Integer          | 	문자열 입력을 정수로 변환하고 검증                    |
|               |                   | parseInputsToIntList()	          | String	                    | List\<Integer>	  | 쉼표로 구분된 문자열 입력을 정수 목록으로 변환              |
|               |                   | formatLottoTickets()             | List\<Lotto>, String	      | List\<String>    | 	로또 티켓을 출력 형식에 맞게 포맷팅                   |
| 	             | Validator	        | validateLottoPurchaseAmount()    | 	Integer                   | 		               | 로또 구입 금액 유효성 검증                         |
|               |                   | validateWinningTicket()	         | List\<Integer>	            | 	                | 당첨 번호 유효성 검증                            |
|               |                   | validateBonusNumber()            | 	List\<Integer>, Integer   | 		               | 보너스 번호 유효성 검증                           |
| util.random   | 	LottoRandomUtil	 | getLottoRandomUtil()             | 	                          | 	LottoRandomUtil | 	싱글톤 패턴을 사용하여 LottoRandomUtil의 인스턴스를 반환 |
|               |                   | issueLottoTicket()	              | Integer, Integer, Integer	 | List\<Integer>	  | 지정된 범위 내에서 중복되지 않는 숫자로 구성된 로또 번호를 발행    |
| view	         | InputView	        | getLottoPurchaseAmountInput()	   |                            | 	String	         | 로또 구입 금액 입력                             |
|               |                   | getWinningTicketInput()	         | 	                          | String	          | 당첨 번호 입력                                |
|               |                   | getBonusNumberInput()            | 	                          | 	String	         | 보너스 번호 입력                               |
| 	             | OutputView	       | printLottoPurchaseAmountInput()	 |                            | 	                | 	로또 구입 금액 입력 메시지 출력                     |
|               |                   | printWinningTicketInput()	       | 	                          | 	                | 당첨 번호 입력 메시지 출력                         |
|               |                   | printBonusNumberInput()          | 	                          | 	                | 	보너스 번호 입력 메시지 출력                       |
|               |                   | printLottoCount()	               | Integer	                   |                  | 	구입한 로또 개수 출력                           |
|               |                   | printLottoTicketsDetails()       | 	List\<String>             | 	                | 	로또 티켓의 상세 정보 출력                        |
|               |                   | printWinningStatistics()	        | RankCounter 	              | 	                | 당첨 통계와 각 등수의 횟수 출력                      |
|               |                   | printEarningsRate()              | 	double	                   |                  | 	로또 수익률 출력                              |
|               |                   | printErrorMessage()              | 	IllegalArgumentException  |                  | 	예외 메시지 출력                              |

<br>

## 💻 커밋 컨벤션

> [**AngularJS 커밋 컨벤션**](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고

| Type     | Description      |
|----------|------------------|
| feat     | 새로운 기능 추가        |
| fix      | 버그 수정            |
| docs     | 문서 변경            |
| style    | 코드 포맷 변경         |
| refactor | 코드 리팩토링          |
| test     | 테스트 추가 및 수정      |
| chore    | 빌드 작업 및 도구 관련 변경 |

<br>

## ✅ 체크 리스트

### 과제 진행 요구 사항

- [x] 로또 저장소를 포크하고 클론한다.
- [x] 기능을 구현하기 전에 README.md에 구현할 기능 목록을 정리해 추가한다.
- [x] Git의 커밋은 README.md에 정리된 기능 목록 단위로 나눈다. (AngularJS Git Commit Message Conventions 참고)

### 기능 요구 사항

- [x] 로또 번호의 범위는 1~45로 제한된다.
- [x] 로또 한 장에는 중복되지 않는 6개의 번호가 포함된다.
- [x] 당첨 번호는 중복되지 않는 6개의 번호와 1개의 보너스 번호로 구성된다.
- [x] 당첨 기준과 상금은 다음과 같다.
    - [x] 1등: 6개 번호 일치 / 2,000,000,000원
    - [x] 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - [x] 3등: 5개 번호 일치 / 1,500,000원
    - [x] 4등: 4개 번호 일치 / 50,000원
    - [x] 5등: 3개 번호 일치 / 5,000원
- [x] 로또 구입 금액을 입력하면 해당 금액만큼 로또를 발행한다.
- [x] 로또 한 장의 가격은 1,000원이다.
- [x] 당첨 번호와 보너스 번호를 입력받는다.
- [x] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 결과와 수익률을 계산하고, 이를 출력한 뒤 로또 게임을 종료한다.
- [x] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "\[ERROR]"로 시작하는 오류 메시지를 출력한다. 이후 해당 부분부터 다시 입력을 받는다.
    - [x] Exception 대신 IllegalArgumentException, IllegalStateException 등 보다 구체적인 예외 유형을 처리한다.

### 입출력 요구 사항

#### 입력

- [x] 로또 구입 금액 (1,000원 단위, 나누어떨어지지 않으면 예외 처리)
- [x] 당첨 번호 (쉼표(,)로 구분)
- [x] 보너스 번호

#### 출력

- [x] 발행된 로또 수량 및 번호 (번호는 오름차순 정렬)
- [x] 당첨 내역
- [x] 수익률 (소수점 둘째 자리에서 반올림)
- [x] 예외 상황 시 오류 메시지 출력 (오류 메시지는 "\[ERROR]"로 시작)

### 프로그래밍 요구 사항

- [x] JDK 21에서 실행 가능해야 한다.
- [x] 프로그램의 시작점은 Application의 main()이다.
- [x] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리만 사용해야 한다.
- [x] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [x] 별도의 지시가 없는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [x] 자바 코드 컨벤션을 준수하여 프로그래밍한다. 기본적으로 Google Java Style Guide를 따른다.
- [x] Indent(인덴트, 들여쓰기) depth는 최대 2까지만 허용한다. (메서드를 분리하는 것을 추천)
- [x] 3항 연산자를 사용하지 않는다.
- [x] 메서드는 한 가지 일만 하도록 최대한 작게 만든다.
- [x] JUnit 5와 AssertJ를 사용하여 테스트 코드를 작성한다.
- [x] 메서드 길이는 15라인을 초과하지 않는다.
- [x] else 예약어 및 switch-case 문 사용을 금지한다.
- [x] Enum을 사용하여 구현한다.
- [x] UI 로직((System.out, System.in, Scanner)을 제외한 구현 기능에 대해 단위 테스트를 작성한다.
- [x] camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현해야 한다.
    - [x] Randoms.pickUniqueNumbersInRange()를 사용하여 랜덤 값을 추출한다.
    - [x] Console.readLine()을 사용하여 사용자 입력을 처리한다.
- [x] 제공된 Lotto 클래스를 사용하여 구현한다.
    - [x] numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
    - [x] numbers의 접근 제어자 private는 변경할 수 없다.
    - [x] 패키지는 변경할 수 있다.