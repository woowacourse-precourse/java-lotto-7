# 학습 목표

> 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.

> 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다.
- 3항 연산자를 쓰지 않는다.
- <h4>🔥 함수(또는 메서드)가 `한 가지 일`만 하도록 최대한 작게 만들어라.</h4>
    - 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
    - else 예약어를 쓰지 않는다.
    - Java Enum을 적용하여 프로그램을 구현한다.
    - 구현한 기능에 대한 단위 테스트를 작성한다.
        - 단, UI(System.out, System.in, Scanner) 로직은 제외한다.

- 처음부터 큰 단위의 테스트를 만들지 않는다
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

---

# 개인 목표

- 함수 8줄 이내 작성. 메서드와 기능 1:1 매치가 되게 노력하자.

---

# java-lotto-precourse 기능 목록서

# 로또 발매기(LottoTicketMachine)

- 컨트롤러간의 흐름 제어를 한다.

## 📌 컨트롤러

### LottoTicketController (로또 티켓 컨트롤러)

- InputView - 구입금액을 입력해 주세요
- CreateLottoTicketUsecase - 로또티켓을 생성하라
- GetLottoTicketUsecase - 로또티켓을 조회하라
- OutputView - { }개를 구매했습니다.
- OutputView - {로또목록들}

```java
InputView-구입금액을 입력해 주세요

        Long ticketId=CreateLottoTicketUsecase.execute(ThousandWons money);
        TicketResult ticketResponse=GetLottoTicketUsecase.execute(Long ticketId);

        OutputView-{ticketResponse.getCount}개를 구매했습니다.
        OutputView-{ticketResponse.getAll}
```

### WinnerNumberController (당첨 번호 컨트롤러)

- InputView - 당첨 번호를 입력해 주세요.
- InputView - 보너스 번호를 입력해 주세요.
- CreateWinnerNumberUsecase - 당첨 번호를 생성하라.
- GetWinnerNumberUsecase - 당첨 번호를 조회하라.

```java
InputView-당첨 번호를 입력해 주세요.
        InputView-보너스 번호를 입력해 주세요.

        Long winNumId=CreateWinnerNumberUsecase.execute(
        List<Integer> winnerNumber,
        int bonus);

        WinnerNumber winnerNumber=GetWinnerNumberUsecase().execute(Long winNumId);
```

### WinnerStatisticsController (당첨 통계 컨트롤러)

- InputView - 당첨 통계
- InputView - ---
- CreateWinnerStatisticsUsecase - 당첨 통계를 생성하라
- GetWinnerStatisticsUsecase - 당첨 통계를 조회하라
- OutputView - {당첨 통계 결과}

```java
InputView-당첨 통계
        InputView- ---

        Long winnerStatisticsId=CreateWinnerStatisticsUsecase.execute(lottos,winnerNumber);
        WinnerStasticsResult winStatistics=GetWinnerStatisticsUsecase.execute(Long id);

        OutputView-{당첨 통계 결과}
```

---

## 📌 유스케이스

- CreateLottoTicketUsecase - 로또티켓을 생성하라(ThousandWons money)
- GetLottoTicketUsecase - 로또티켓을 조회하라(Long ticketId);


- CreateWinnerNumberUsecase - 당첨 번호를 생성하라.
- GetWinnerNumberUsecase - 당첨 번호를 조회하라.


- CreateWinnerStatisticsUsecase - 당첨 통계를 생성하라
- GetWinnerStatisticsUsecase - 당첨 통계를 조회하라

### CreateLottoTicketUsecase - 로또티켓을 생성하라(ThousandWons money)

- PaymentService - 로또 금액을 지불하라
- TicketService - 로또 티켓을 생성하라

```java
LottoCount lottoQuantity=PaymentService.pay(ThousandWons money);
        Long ticketId=TicketService.create(LottoCount lottoQuantity);
```

### GetLottoTicketUsecase - 로또티켓을 조회하라(Long ticketId);

- LottoTicketService - 로또 티켓을 조회하라

```java
LottoTicket lottoTicket=LottoTicketService.getById(Long ticketId);
```

### CreateWinnerNumberUsecase - 당첨 번호를 생성하라.

- WinnerNumberService - 당첨 번호를 생성하라

```java
Long winNumId=WinnerNumberService.generate(List<Integer> numbers,int bonus);
```

### GetWinnerNumberUsecase - 당첨 번호를 조회하라.

- WinnerNumberService - 당첨 번호를 조회하라

```java
WinnerNumber winnerNumber=WinnerNumber.getById(Long winNumId);
```

### CreateWinnerStatisticsUsecase - 당첨 통계를 생성하라

- WinnerStatisticsService - 당첨 통계를 내라

```java
Long winStatisticsId=WinnerStatistics.compile(LottoTicket lottoTicket,WinnerNumber winNum);
```

### GetWinnerStatisticsUsecase - 당첨 통계를 조회하라

- WinnerStatisticsService - 당첨 통계를 조회하라

```java
WinnerStatistics winStatistics=WinnerStatistics.getById(Long winStatisticsId);
```

---

# 📌 서비스

### PaymentService - 결제하라

- Payment - 지불하라
- PaymentRepositroy - 저장하라

```java
Payment payment=Payment.pay(ThousandWodns money);
        Long savedId=PaymentRepository.save(payment);
```

### TicketService - 생성하라

- Ticket - 생성하라
- TicketRepository - 저장하라
- Long LottoTicketService.pay(ThousandWons money);

```java
Ticket ticketResponse=Ticket.of(LottoCount lottoQuantity);
        Long savedId=TicketRepository.save(ticketResponse);
```

### TicketService - 조회하라

- TicketService - 조회하라

```java
Ticket ticketResponse=TicketRepository.getById(Long ticketId);
```

### WinnerNumberService - 생성하라

- WinnerNumber - 생성하라
- WinnerRepository - 저장하라

```java
Lotto winLotto=Lotto.of(List<Integer> numbers);
        WinnerNumber winNum=WinnerNumber.of(Lotto lotto,int bonus);
        Long savedId=WinnerRepository.save(winNum);
```

### WinnerNumberService - 조회하라

- WinnerNumberRepository - 조회하라

```java
WinnerNumber winNum=WinnerNumberRepository.getById(Long winNumId);
```

### WinnerStatisticsService - 당첨 통계를 생성하라

- WinnerStatistics - 컴파일 하라
- WinnerStatisticsRepository - 저장하라

```java
WinnerStatiscis winStatistics=WinnerStatistics.compile(LottoTicket lottoTicket,WinnerNumber winNum);
        Long savedId=WinnerStatisticsRepository.save(winStatistics);
```

### WinnerStatisticsService - 당첨 통계를 조회하라

- WinnerStatisticsRepository - 조회하라

```java
WinnerStatistics winStatistics=WinnerStatisticsRepository.getById(Long winStatisticsId);
```

---

# 📌 도메인

- 로또 가격
    - 1000원 단위가 아닐시 예외처리를한다.


- 로또 숫자
    - 로또 번호의 숫자 범위는 1~45까지이다.
    - 그 외 범위는 예외처리


- Payment - 지불하라
    - 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
    - 지불이 실패하면 예외처리


- Ticket - 생성하라
    - 로또들을 생성한다.


- WinnerNumber - 생성하라
    - 당첨 번호를 생성한다.
    - 중복되지 않는 숫자 6개와 보너스 번호 1개가 있다.


- WinnerStatistics - 컴파일하라
    - 당첨 등수 정의 (Enum)
        - FIRST(6, 2_000_000_000, "6개 일치")
        - SECOND(5, 30_000_000, "5개 일치, 보너스 볼 일치")
        - THIRD(5, 1_500_000, "5개 일치")
        - FOURTH(4, 50_000, "4개 일치")
        - FIFTH(3, 5_000, "3개 일치")
        - NONE(0, 0, "미당첨")

    - 당첨 결과 집계하기
        - 구매한 각 로또와 당첨번호를 비교
        - 일치하는 번호 개수 확인
        - 보너스 번호 일치 여부 확인
        - 당첨 등수별 개수 집계

    - 당첨금 계산하기
        - 등수별 당첨금액 계산
        - 총 당첨금액 계산

    - 수익률 계산하기
        - 구매 금액 대비 당첨금 비율 계산
        - 소수점 둘째자리에서 반올림

    - 통계 조회 결과 제공하기
        - 등수별 당첨 내역 포맷팅
        - 전체 통계 결과를 포맷에 맞게 조합
