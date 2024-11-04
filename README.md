
# java-lotto-precourse

> [!NOTE]  
> 간단한 로또 발매기를 구현한다.  
> 로또 번호의 숫자 범위는 1~45까지이다.  
> 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.  
> 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.  
> 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.  
> 1등: 6개 번호 일치 / 2,000,000,000원  
> 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원  
> 3등: 5개 번호 일치 / 1,500,000원  
> 4등: 4개 번호 일치 / 50,000원  
> 5등: 3개 번호 일치 / 5,000원  
> 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.  
> 로또 1장의 가격은 1,000원이다.  
> 당첨 번호와 보너스 번호를 입력받는다.  
> 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.  
> 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.   
> Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

<br><br>

# 파일구조

```
.
src/
└── main/
    └── java/
        └── lotto/
            ├── controller/
            │   └── LottoController.java       # 전체 흐름 제어
            │
            ├── exception/
            │   └── RetryInputException.java   # 문답을 넘겨주기위한 예외
            │
            ├── model/
            │   ├── Lotto.java                 # 로또 모델 클래스
            │   └── LottoDomain.java           # 로또 도메인 관련 클래스
            │   └── LottoService.java          # 로또 관련 비즈니스 로직
            │
            ├── status/                        # 상태 및 상수 관리
            │   ├── ErrorMessage.java          # 오류 메시지 관리
            │   ├── LottoConstants.java        # 상수 인터페이스
            │   └── LottoPrize.java            # 순위와 상금 enum
            │
            ├── util/
            │   ├── inputUtils.java            # 예외 후 다시 입력
            │   └── RegexUtils.java            # 정규식 유틸리티
            │
            ├── validator/
            │   ├── Amout.java                 # 구매 금액 유효성 검사
            │   ├── BonusNumber.java           # 보너스 숫자 유효성 검사
            │   ├── LuckyNumbers.java          # 당첨 숫자 유효성 검사
            │   └── Validator.java             # 유효성 검사 공통 사용 추상클래스
            │
            └── view/
            │   ├── InputView.java             # 사용자 입력 및 요청
            │   └── OutputView.java            # 결과 출력
            │
            └── Application.java               # 메인 애플리케이션 실행

```

<br><br>

# 기능

### :point_right: 입력확인

- 예외 처리후 리퀘스트
- 금액 확인
- 금액 단위 확인
- 당첨번호 입력 패턴 확인
- 숫자 중복 확인
- 문자열 당첨번호 컬렉션 변환  
  <br>

### :point_right: 로또
  - 금액만큼 로또 발행하기
  - 발행한 로또 당첨번호와 일치하는지 확인하기
  - 당첨 순위 확인하기
  - 총 금액 구하기
- 수익률 구하기  
  <br>

### :point_right: 출력
  - 구매 개수 구하기
  - 구매한 로또 출력
  - 당첨된 로또 순위와 개수, 금액 출력
- 수익률 출력  
  <br>

### :point_right: status

- 로또에서 공통으로 사용되는 상수 모아두기 (interface)
- 로또 금액과 필요한 문자열 (enum)
- 에러메세지 만들기 (enum)   
  <br>

### :point_right: util

- 자주 쓰이는 정규식 만들기
- 예외처리 후 입력 재요청

<br><br>

# 이슈

### :star: 예외처리 후 요청을 다시 받아 올떄

#### :heavy_multiplication_x: ~~콘솔 바로 실행~~

#### :heavy_check_mark: 요구 문장을 다시 출력후 콘솔 실행
<br>

### :star: 구매 금액 얼마까지 가능하게 할까?

#### :heavy_multiplication_x: ~~엄청 많은 금액도 되게할까?~~

#### :heavy_check_mark: 실제 1인당 로또 구매 가능 비용으로 할까?
<br>

### :star: 로또 당첨번호 입력 콤마 처리는?

#### :heavy_multiplication_x: ~~콤마가 연속으로 여러개 들어오면 예외처리?~~

#### :heavy_check_mark: 콩마가 연속으로 들어와도 허용후 빈값은 제거




<br>
<br>
<br>
