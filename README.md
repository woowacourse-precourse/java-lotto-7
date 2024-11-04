# 로또 발매기

## 프로젝트 구조

```bash
main/java/lotto
├── Application.java                             # 메인 실행 파일
├── lottoMachine                                 # 로또 기계: 로또 번호 생성 및 처리 담당
│   ├── calculateManager                         # 계산 매니저: 계산 및 결과 처리
│   │   ├── LotteryResultManager.java            # 계산기: 로또 결과 계산 및 저장
│   │   ├── LottoPrizeManager.java               # 계산기: 총 상금 계산
│   │   ├── LottoQuantityManager.java            # 계산기: 로또 티켓 개수 계산
│   │   └── LottoTotalReturnManager.java         # 계산기: 총 수익률 계산
│   ├── lottoBonusNumber                         # 로또 보너스 숫자 관리
│   │   ├── LottoBonusNumberInputter.java        # 입력기: 보너스 번호 입력
│   │   ├── LottoBonusNumberValidator.java       # 검증기: 보너스 번호 유효성 검증
│   │   └── LottoBonusNumberManager.java         # 매니저: 보너스 번호 관리
│   ├── lottoPurchaseAmount                      # 로또 구입 금액 관리
│   │   ├── LottoPurchaseAmountInputter.java     # 입력기: 구입 금액 입력
│   │   ├── LottoPurchaseAmountValidator.java    # 검증기: 구입 금액 유효성 검증
│   │   └── LottoPurchaseAmountManager.java      # 매니저: 구입 금액 관리
│   ├── lottoTotalResult                         # 로또 총 결과 관리
│   │   ├── LottoTotalResultManager.java         # 매니저: 총 당첨 결과 관리
│   │   └── LottoTotalResultStatisticsPrinter.java # 출력기: 총 결과 통계 출력
│   ├── lottoWinningNumber                       # 로또 당첨 숫자 관리
│   │   ├── LottoWinningNumberDelimiter.java     # 구분기: 당첨 번호 구분
│   │   ├── LottoWinningNumberInputter.java      # 입력기: 당첨 번호 입력
│   │   ├── LottoWinningNumberValidator.java     # 검증기: 당첨 번호 유효성 검증
│   │   └── LottoWinningNumberManager.java       # 매니저: 당첨 번호 관리
│   ├── utils                                    # 유틸리티: 자주 쓰이는 메시지와 구조체
│   │   ├── LottoResultStructure.java            # 로또 결과 구조: 당첨 구조 관리
│   │   └── StaticFinalMessages.java             # 메시지 모음: 자주 쓰이는 메시지 static화
│   ├── LottoMachineManager.java                 # 로또 기계 매니저: 전체 로또 프로세스 관리
│   ├── LottoNumberGenerator.java                # 로또 번호 생성기: 랜덤 로또 번호 생성
│   └── LottoNumberPrinter.java                  # 로또 번호 프린터: 로또 번호 출력
├── Lotto.java                                   # 로또: 로또 객체 정의
├── Lotties.java                                 # 로또들: 로또 리스트 관리
├── LottoResult.java                             # 로또 결과: 개별 로또의 결과 저장
└── LottoResultStore.java                        # 로또 결과 집합체: 로또 결과를 저장하고 관리
```

```mermaid
flowchart TD
    A[Application] --> B[LottoMachineManager]
    B --> C(issueLottoTickets 실행)
    C --> D[LottoPurchaseAmount 구입금액 갖고오기 및 검증]
    D --> E[LottoQuantityManager 구입금액을 구입수량으로 변환]
    E --> F[LottoNumberGenerator (구입수량만큼 Lotto 생성)]
    F --> G[Lotties: List<Lotto>에 저장]
    G --> H[LottoNumberPrinter 로또 번호 출력]

    B --> I(issueLotteryResult 실행)
    I --> J[LottoWinningNumber 로또 당첨 숫자 검증]
    J --> K[LottoBonusNumber 보너스 숫자 및 중복 검증]
    K --> L[LotteryResultManager 일치하는 숫자 계산 및 저장]
    L --> M[LottoTotalResult 모든 로또 당첨 금액 합산 및 출력]
    M --> N[LottoTotalReturnManager 총 수익률 계산]
```

---

## 반드시 지켜야할 사항

제공된 Lotto 클래스를 사용하여 구현해야 한다.

Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.

numbers의 접근 제어자인 private은 변경할 수 없다.

Lotto의 패키지를 변경할 수 있다.

java Enum을 사용하여 구현하라.

else 예약어를 쓰지 않는다.

함수의 길이가 15를 넘어가지 않도록 한다.

구현한 기능에 대한 단위 테스트를 작성한다.

---

## 기능 목록

[x] 로또 구입 금액을 입력 받는 로또_구입_금액_입력기 구현

[x] 입력받은 로또 구입 금액이 주어진 조건에 맞는 번호인지 검증하는 로또_구입_금액_검증기 구현

[x] 구입 금액에 대해 발행하게 된 로또 수량을 계산하는 로또_수량_계산기 구현

[x] 6개의 번호들을 주어진 조건에 맞게 나열하는 로또_자동_번호_생성기 구현

[x] 로도 수량에 맞게 로또 번호들을 리스트화 시켜 모아놓는 로또들 구현

[x] 로또 번호 입력 받는 로또_당첨_번호_입력기 구현

[x] 입력 받은 로또 번호를 구분자로 나누는 로또_당첨_번호_구분기 구현

[x] 입력받은 로또 번호가 주어진 조건에 맞는 번호인지 검증하는 로또_당첨_번호_검증기 구현

[x] 당첨 번호를 입력 받는 당첨_번호_입력기 구현

[x] 입력받은 당첨 번호가 주어진 조건에 맞는 번호인지 검증하는 당첨_번호_검증기 구현

[x] 보너스 번호를 입력 받는 보너스_번호_입력기 구현

[x] 입력받은 보너스 번호가 당첨 번호와 겹치지 않고, 주어진 조건에 맞는 번호인지 검증하는 보너스_번호_검증기 구현

[x] 당첨 번호와 보너스 번호를 이용해 발급한 로또들의 번호와 비교하며 일치하는 로또 번호 개수 계산하는 일치_로또_번호_개수_계산기 구현

[x] 일치된 로또 번호 개수를 통해 enum인 로또 당첨 상금 관련 구조에 저장하는 로또 결과 저장 기능 구현

[x] 저장된 로또 결과를 토대로 총 상금 및 수익률을 계산하는 로또_결과_계산기 구현

---

## 테스트 목록

### 로또 구입 금액

#### 숫자 형식인가?

#### 숫자 범위가 50,000원 아래인가? (현실 로또 구입 금액 제한 반영)

#### 숫자 범위가 1,000원 위 인가?

#### 로또 구입 금액이 1,000원 단위인가?

### 로또 수량

#### 로또 구입 금액에 따른 티켓 수가 올바르게 동작하는가?

### 당첨 번호

#### 번호들이 숫자 형식인가?

#### 번호들의 개수가 6개인가?

#### 번호들 중 겹치는 것은 없는가?

#### 번호들의 범위가 1~45까지인가?

### 보너스 번호

#### 숫자 형식인가?

#### 범위가 1~45까지인가?

#### 전에 나왔던 6개의 번호들과 겹치지 않는가?

### 로또 번호

#### 로또 수량에 맞는 번호 묶음들이 나왔는가?

#### 1~45 사이 숫자들이 나왔는가?

#### 숫자들 중 겹치는 숫자가 있는가?

#### 총 6개의 숫자들이 나왔는가?

#### 로또 번호들을 오름차순으로 정렬하여 보여주는가?

#### 로또 번호와 보너스 번호를 당첨 번호와 비교하여 일치된 숫자의 개수를 반환하는가?

#### 로또 번호와 보너스 번호와 비교하여 일치하지 않으면 false를 반환하는가?

### 로또 번호 덩어리

#### 로또 티켓을 로또 덩어리에 추가할 수 있는가?

#### 추가된 로또 티켓을 로또 덩어리에서 조회할 수 있는가?

#### 로또 티켓을 조회할 때 불변의 리스트를 반환하는가? -> 값 변환하지 못하도록

### 로또 결과

#### 로또 결과 객체가 올바르게 생성되는가?

#### 당첨 번호와 로또 번호의 일치되는 개수를 정확히 반환하는가?

#### 보너스 번호가 정확히 반환되는가?

### 로또 총상금

#### 당첨 통계가 올바르게 저장되는가?

#### 총 상금이 올바르게 계산이 되는가?

### 로또 번호 출력기

#### 로또 번호가 주어진 조건에 맞게 출력되는가?

### 로또 총 수익률

#### 총 수익률이 올바르게 계산되고 출력되는가?

#### 총 수익률이 100% 이상이더라도 올바르게 계산되고 출력이 되는가?

#### 총 수익률이 0%일 때 올바르게 계산되고 출력되는가?