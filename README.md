# java-lotto-precourse

## :skull: 구현할 기능 목록

### 입력 처리

- [x] 로또 구입 금액[^1] 처리
    - 자리 표시자(,)는 허용하지 않음
    - 양수 정수만 허용
    - 1000으로 나누어 떨어져야 함
    - 실패 시 입력 다시 받아야 함
- [x] 당첨 번호[^2] 처리
    - 구분자에 붙은 공백은 적절히 처리
    - 각 숫자에 대해 범위 유효성 확인
    - 6개의 정수가 반환되었는지 확인
    - 서로 다른 정수인지 확인
    - 실패 시 입력 다시 받아야 함
- [x] 보너스 번호[^3] 처리
    - 숫자에 대한 범위 유효성 확인
    - 1개의 정수가 반환되었는지 확인
    - 당첨 번호와 중복되는 번호는 허용하지 않음
    - 실패 시 입력 다시 받아야 함

[^1]: `1000`으로 나누어 떨어지는 양수 정수로, 로또를 발행하는 데에 투입할 금액을 의미
[^2]: 쉼표(,)로 구분된, `[1, 45]` 사이의 서로 다른 정수 6개를 의미
[^3]: *당첨 번호*에 속하지 않은`[1, 45]` 사이의 정수를 의미

### 출력 처리

| 완료  | 프롬프트                 | 설명            |
|-----|----------------------|---------------|
| :o: | `구입금액을 입력해 주세요.`     | 로또 구입 금액 입력 시 |
| :o: | -                    | 로또 구매 결과 출력   |
| :o: | `\n당첨 번호를 입력해 주세요`   | 당첨 번호 입력 시    |
| :o: | `\n보너스 번호를 입력해 주세요.` | 보너스 번호 입력 시   |
| :o: | -                    | 당첨 통계 출력      |

### 예외 처리

- [x] 접두사 `[ERROR] `
- [x] 로또 객체 null 체크
- [x] 로또 번호 개수(6) 준수 여부
- [x] 로또 번호 범위 `[1, 45]` 준수 여부
- [x] 로또 번호 내 중복 여부
- [x] 추가 예정

### 구매 결과 처리

- [x] 구입금액에 따라 발행 수를 계산
- [x] 발행 수만큼 API를 통해 1~45 사이의 랜덤한 6개의 서로 다른 정수를 추출
- [x] 발행한 로또 6개의 번호 내에서 오름차순 정렬 수행
    - 모든 발행 로또에 대해 수행

### 당첨 통계 처리

- [x] 일치 수에 따른 당첨금은 `Java Enum`을 이용하여 매핑
- [x] 다음 식을 이용하여 수익률 계산

```math
\text{총 수익률(%)} = \frac{\sum \text{당첨금}}{\text{구입금액}}
```

### 테스트 추가

> [!NOTE]
> **테스트**는 <b><프로그래밍 요구 사항></b>에서 요구된 사항으로,
> *JUnit 5와 AssertJ를 이용하여 구현한 테스트*를 의미합니다.
> 구현한 기능에 대한 *단위 테스트*를 포함합니다.

- [x] 추가 예정

### 추가 요구 사항 준수

**추가 요구 사항**은 <b><1주차 공통 피드백></b>, <b><프로그래밍 요구 사항></b>에 명시된,
*기능 외의 요구 사항* 을 의미합니다.

<details>

<summary>프로그래밍 요구 사항 관련</summary>

- **<프로그래밍 요구 사항>** 관련
    - [x] JDK 21 사용
    - [x] `System.exit()` 호출 금지
    - 요구 사항에서 명시하지 않은 파일 및 패키지 변경 금지
    - [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)
      준수
    - [x] indent depth는 2까지 허용
    - [x] 3항 연산자 금지
    - 함수 또는 메서드
        - [ ] 15라인을 초과하지 않아야 함
        - [x] 한 가지 일만 잘 하도록 구현
    - [x] `else`와 `switch` 사용 금지
    - [x] `Java Enum`을 프로그램에 적용하여 구현
    - [ ] UI 컴포넌트를 제외한 범위에서 구현 기능에 대한 단위 테스트 작성
    - `camp.nextstep.edu.missionutils`에서 제공하는 API를 사용하여 입력 및 랜덤 처리
        - [x] 입력은 `Console.readLine()` 사용
        - [x] 랜덤은 `Randoms.pickUniqueNumbersInRange()` 사용
    - `Lotto` 클래스
        - [x] 제공된 `Lotto` 클래스 사용
        - [x] `numbers` 이외의 필드(인스턴트 변수) 추가 금지
        - [x] `numbers`의 접근 제어자 `private` 유지
        - [x] `Lotto` 패키지 변경 **가능**

</details>

<details>

<summary>공통 피드백 관련</summary>

- **<1주차 공통 피드백>** 관련
    - Git 관련
        - 기본적인 Git 명령어 숙지
        - Git으로 관리할 자원 고려
        - 의미 있는 커밋 메시지
        - 커밋 메시지에 이슈 또는 PR 번호 포함 금지
        - PR 생성 후 닫지 않는다(닫을 필요가 없다)
    - 디버깅 시 `sout` 말고 디버거 사용
    - 코드 작성 관련
        - 이름을 통해 의도 드러내기
        - 축약 금지
        - 코딩 컨벤션의 올바른 공백 준수
        - 의미 있는 공백 라인
        - 스페이스와 탭 중 하나만 사용
        - 의미 없는 주석 금지
        - 코드 포매팅 사용
        - Java 기본 API 적극 활용
        - 배열 대신 컬렉션(`List`, `Set`, `Map`) 사용
- **<2주차 공통 피드백>** 관련
    - README.md 관련
        - 상세히 작성
        - 기능 목록 재검토
        - 기능 목록 지속적 갱신
    - 구현 관련
        - 값을 하드 코딩하지 않음
        - 구현 순서 컨벤션 엄수(상수/클래스변수 - 인스턴스 변수 - 생성자 - 메서드)
        - 변수 이름에 자료형 사용 금지
        - 한 메서드가 한 가지 기능만 담당
    - 테스트 작성 관련
        - 테스트 작성 이유를 본인의 경험 토대로 작성
        - 처음부터 큰 단위의 테스트 만들지 않음

</details>
