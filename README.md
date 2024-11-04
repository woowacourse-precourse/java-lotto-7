# java-lotto-precourse

## 기능 요구사항 분석

### 1. 입력 기능
1-1. **구입 금액 입력**
- 구입 금액을 입력받고 1,000원 단위인지 확인한다.
- 유효하지 않은 금액 입력 시 `IllegalArgumentException`을 발생시킨다.

1-2. **당첨 번호 입력**
- 사용자로부터 당첨 번호 6개를 입력받는다.
- 입력된 번호가 1~45 범위 내에 있고, 중복되지 않았는지 확인한다.
- 유효하지 않은 경우 `IllegalArgumentException`을 발생시킨다.

1-3. **보너스 번호 입력**
- 보너스 번호 1개를 입력받는다.
- 당첨 번호와 중복되지 않으며, 번호가 1~45 범위 내에 있는지 확인한다.
- 유효하지 않은 경우 `IllegalArgumentException`을 발생시킨다.

### 2. 로또 발행 기능
2-1. **구매한 로또 개수 계산 및 발행**
- 구입 금액에 따라 구매 가능한 로또 개수를 계산한다.
- 각 로또 번호는 중복 없이 6개의 숫자로 구성되며, 오름차순으로 정렬된다.
- 발행된 로또 번호를 출력한다.

### 3. 당첨 확인 기능
3-1. **당첨 번호와 비교하여 등수 계산**
- 각 로또 번호가 당첨 번호와 몇 개 일치하는지 확인한다.
- 일치하는 개수에 따라 1등 ~ 5등의 등수를 판별한다.
- 보너스 번호 일치 여부로 2등을 판별한다.

### 4. 수익률 계산 기능
4-1. **당첨 상금 합산 및 수익률 계산**
- 당첨 등수에 따른 상금을 합산하여 총 수익을 계산한다.
- 수익률 = (총 수익 / 구입 금액) * 100 으로 계산한다.
- 수익률은 소수 둘째 자리까지 표시한다.

### 5. 결과 출력 기능
5-1. **로또 발행 결과 출력**
- 발행된 로또 번호와 구매한 로또 수량을 출력한다.

5-2. **당첨 통계 출력**
- 각 등수별 당첨 수량과 상금을 출력한다.
- 전체 수익률을 출력한다.

---

## 기능 구현 목록

### 기능 구현 (MVC)

### 1. Model

- **Lotto**
  - 한 장의 6자리 로또 인스턴스 생성자
  - 유효성 검사 : 1~45 사이 숫자로 구성된 6개의 중복되지 않는 번호인지 검사
- **LottoGameState**
  - 사용자의 로또, 사용자의 보너스 번호, 구매한 N장의 랜덤 로또, 로또 매치 통계 데이터 보관
- **LottoMatchEnum**
  - 로또 매치 통계 데이터 Enum 자료화 클래스
- **LottoStatistic**
  - N장 로또의 당첨 통계를 관리하는 클래스

### 2. View

- **ErrorView**
  - 발생가능한 예외 출력 기능
- **InputView / OutputView**
  - 기본 로또게임 내 입출력 기능 수행

### 3. Controller

- **LottoController**
  - 사용자 입력, 시스템 출력, 유효성 검사, 로또 결과 로직 컨트롤러
- **LottoValidator**
  - 사용자 입력에 대한 유효성 검사 및 재입력 기능 수행

### 4. Services

- **LottoService**
  - Controller의 Model 데이터 관련 요청 처리 기능 수행
    - Model에 속한 클래스 객체 생성 및 반환
    - 객체 데이터 변경 메서드 호출 수행

### **5. Util**

- **LottoErrorMessages**
  - 에러 관련 문자열 보관
- **LottoPrintMessages**
  - 출력 관련 문자열 보관

### 6. Exceptions

- **LottoException**
  - 각 예외처리 경우에 따른 예외 클래스

--- 

## 기능 구현 로그

### 24.10.30.(수)
- **MVC 패턴 적용**
  - 명세한 기능 목록을 Model-View-Controller 패턴에 따라 설계합니다.
  - **Model**
    - 로또 게임 내 데이터 및 비즈니스 로직 처리를 담당하도록 설계합니다.
      - Lotto : 게임 내 로또 객체를 생성하고, 로또 번호 유효성을 검증하는 로직을 갖습니다.
      - LottoService : N개의 랜덤로또 번호를 생성하여 각각의 로또 객체로 반환하고, 사용자가 입력한 로또 번호와 일치하는지 검사하는 로직을 갖습니다.
      - LottoStatistics : 로또 게임의 통계 계산 로직을 갖습니다.
  - **ModelTest 단위테스트**
    - [x] LottoTest : 1~45 사이의 6개 정수 번호를 갖는 로또가 유효성 검증을 정상적으로 통과하는지 검증합니다.
    - [x] LottoServiceTest : N개 로또가 정상적으로 생성되는지 검사합니다. 또한 N개 로또에 대해 사용자의 로또 번호와 정상적으로 일치 여부를 반환하는지 검증합니다. 
    - LottoStatisticsTest : 사전 설정된 로또 일치 여부에 따라 정상적인 금액 통계를 반환하는지 검증합니다.

### 24.10.31 (목)
- **Controller 및 View 구현**
  - **View**
    - 사용자 입력 받기, 내용 출력하기, 에러내용 출력하기 에 대한 기능을 담당합니다.
  - **Controller**
    - View, Model 객체와의 상호작용을 통해 로또 게임을 제어합니다.
  - **ApplicationTest**
    - -[x] 기능_테스트() : 정상적인 입력 절차에 따라 예상되는 출력를 반환하는지 검증합니다.
- **Application.java Main() 구현**
  - View, Model 객체를 생성하여 Controller에 전달합니다.
  - Controller 내부 로직에 따라 View, Model 객체 제어를 통해 로또 게임을 수행합니다.

### 24.11.01.(금)
- **Model-View-Controller + Services**
  - **Model**
    -  한 장의 로또를 표현하는 Lotto 클래스, 로또 게임의 전체 로또 통계 데이터를 표현하는 LottoStatistics 클래스를 갖도록 수정합니다.
  - **View**
    - 기존 LottoStatistics 클래스에 구현된 통계 출력 메서드를 View로 분리하였습니다.
  - **Services**
    - Controller로부터 전달받은 데이터 작업 관련 요청을 처리합니다.
      - Model 객체 생성 요청 처리
      - LottoStatistics 객체의 통계데이터(Map) 및 수익률 (Yield) 데이터 갱신 작업을 수행합니다.
  - **Controller**
    - Controller 클래스에서는, Model,View,Services 객체에 대한 기능 동작 요청만 수행하도록 변경합니다.
    - Controller-Services 간 의존성 주입을 구현합니다.

### 24.11.01.(금).2
- **LottoStatistic**
  - **LottoStatistics Interface**
    - Service에서는 LottoStatistics 인터페이스의 `updateStatistics()`, `updateLottoYield()`만 호출하도록 변경합니다.
      - 정보 은닉 : 내부 데이터 처리 로직을 담당하는 private 메소드와 Service에서 호출할 public 데이터를 명확히 구분합니다.
      - 결합도 : Service에서 LottoStatistic 관련 요청 수행 시, 세부 구현 로직을 알 필요가 없도록 구현합니다.
  - **LottoStatisticDTO**
    - LottoStatistic-View 간 데이터 전송 시 데이터 직접참조 또는 getter/setter 없이 데이터를 참조할 수 있도록 합니다.
  - **LottoController**
    - LottoStatistic 인터페이스를 통해 LottoStatistics 객체에 대한 의존성을 주입하도록 변경합니다.

### 24.11.02.(토)
- **LottoValidator 추가**
  - 사용자 입력 데이터의 유효성을 검사하는 로직을 별도 Validator 클래스로 분리합니다.
- **Controller.start() 로직 분리**
  - 사용자 입력, 모델 객체 생성, 로또 결과 확인 세 단계를 각 단일 메서드로 분리하고, start()에서 `initLottoGame()`, `startLottoCheck()`만 호출하도록 변경합니다.
- **LottoStatistic 인스턴스 변수 추가**
  - 로또 구입 금액 purchaseAmount 및 로또 수량 quantity 필드를 추가하여, 통계 클래스에 필요한 데이터로 종속시킵니다.
  - 랜덤로또 N장 생성 시 로또 수량 데이터가 필요한 경우, statistics의 DTO 객체를 통해 불변값을 전달받도록 수정합니다.

### 24.11.02.(토).2
- **ErrorException 클래스 추가 및 Validator 수정**
  - 프로그램 내 예외 구문을 util.LottoErrorMessages에 상수로 정의합니다.
  - LottoException을 상속받아 각 예외처리 경우에 대한 예외발생 메서드를 정의합니다.
  - 각 클래스 내 예외발생 및 처리를 위한 중복 코드가 발생하지 않도록 수정되었습니다.
- **ErrorView, I/O View 분리**
  - 사용자 입력을 위한 View, 콘솔 출력을 위한 View, 에러 출력을 위한 View 의 세 가지 케이스로 View를 분리합니다.
  - 모든 View는 static으로 변경합니다.

### 24.11.02.(토).3
- **Statistics 자료구조 변경**
  - 당첨통계 관리 시 enum 클래스를 정의하여 Statistic 클래스 내 메서드 로직 가독성을 높일 수 있도록 수정합니다.

### 24.11.03.(일)
- **View 리팩토링**
  - InputView 클래스의 print 내 문자열 양식을 util.LottoPrintMessages 클래스 내 상수 멤버로 분리하여 유지보수성을 확보합니다.
  - OutputViewer 및 InputViewer 인터페이스를 추가하여 Controller에 Viewer에 대한 의존성을 주입합니다.
  
- **outputView 메서드 호출 파라미터 수정**
  - Controller에서 메서드 호출 시 DTO 객체를 전달하도록 수정하여 View 내에서 DTO 객체로 전환하는 불필요한 로직을 제거합니다.
  - 생성된 랜덤로또 N장을 출력하는 로직을 별도 메서드로 분리합니다.

### 24.11.04.(월)
- **Controller 수정**
  - 사용자 입력 유효성 검사 및 재입력 받는 while > try-catch 로직이 중복되지 않도록 별도 메서드로 분리합니다.
  - 외부로부터 주입받은 객체 이외에 변수 필드를 갖지 않도록, userLotto, randomLotteries, statistic 데이터를 보관하는 model 클래스를 정의합니다.
- **Validator 수정**
  - 각 입력 경우에 따른 조건식을 별도 메서드로 분리하여 코드 가독성 및 유지보수성을 높입니다.
  - 각 경우에 따라 올바른 예외클래스가 호출되도록 수정합니다.
- **오타 및 공백 수정**
  - 불필요한 주석 및 공백을 제거합니다.
  - **Lotto, LottoGameState를 class record로 변경합니다.

### 24.11.04.(월).2
- **예외처리 로직 수정**
  - 예외처리 문자열 전달 시 ERROR_FLAG 를 포함하지 않는 문제를 수정합니다.
  - 사용자 구입금액 입력 시 누락된 예외 케이스를 추가합니다.
- **테스트 케이스 복구**
  - 기존 로그에서 삭제된 테스트 케이스를 복구합니다.