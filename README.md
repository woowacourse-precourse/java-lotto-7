# 로또 💰

_간단한 로또 발매기를 구현한다._

## **목표** 🎯

구입 금액, 당첨 번호, 보너스 번호를 입력받아 당첨 내역을 출력하는 프로그램

## 기능 목록 📋

```markdown
src/main/java/lotto/
├── 메인(Application)/        # 애플리케이션 메인
│   ├── 컨트롤러(Controller)/
│   │   └── 컨트롤러                 # 애플리케이션의 흐름을 관리
│   ├── 모델(Model)/
│   │   ├── 로또                    # 로또 번호를 나타내는 클래스
│   │   ├── 우승 로또                # 우승 로또 번호를 나타내는 클래스
│   │   └── 당첨 통계                # 로또 구매 통계를 나타내는 클래스
│   ├── 서비스(Service)/
│   │   ├── 로또 서비스              # 로또 생성 및 통계 계산 로직
│   │   └── 검증                    # 입력 검증 로직
│   └── 뷰(View)/
│           ├── 입력                # 사용자 입력 처리
│           └── 출력                # 결과 출력 처리
└── test/java/lotto/ 
            ├── ApplicationTest      # 통합 테스트
            └── LottoTest            # 단위 테스트
```

## 예외 처리 목록 ✅
* 구입 금액
    + 천원 단위
    + 천원 미만
    + 십만원 초과
* 당첨 번호
    + 1 ~ 45
    + 6 미만, 6 초과
    + 중복
* 보너스 번호
    + 1 ~ 45
    + 1 이상인지
    + 당첨 번호와 중복
* 문자 입력
* 빈 입력
* 중복 로또 번호

### 라이브러리 🦾
* 입력은 `camp.nextstep.edu.missionutils.Randoms`의 pickUniqueNumbersInRange()를 활용한다. 
* 난수는 `camp.nextstep.edu.missionutils.Console`의 readLine()을 활용한다.

### Lotto 클래스
+ 제공된 Lotto 클래스를 사용하여 구현해야 한다.
+ Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
+ numbers의 접근 제어자인 private은 변경할 수 없다.
+ Lotto의 패키지를 변경할 수 있다.

### 개인 목표(공통 피드백 및 요구 사항)
- 하드코딩하지 않기
- 명명에 자료형쓰지 않기
    * 메서드명도 포함인가..?
- API 와 컬렉션 활용하기
    * 구현하기 전에 찾아봐라..
- 한 메서드가 한 가지 기능만 담당하게 하기
    * 메서드당 15줄 이하로 작성해보자
- 테스트를 작성하고, 경험을 정리하기
- 작은 단위 테스트부터 진행하기
- Java Enum을 적용하여 구현하기
    * 에러 메시지나 당첨 금액에 적용하면 될 듯
