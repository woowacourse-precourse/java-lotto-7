# java-lotto-precourse
> ⁜ **우아한테크코스 웹 백엔드 7기 프리코스 3주차 미션** (_Implemented by `yummygyudon(정동규)`_)

## [ 요구사항 ]
### ⚙️ 기능

---
- "**로또 발매기**" 구현
  - [x] 로또 자동 발급 기능
  - [x] "**당첨 번호**" & "**보너스 번호**" 입력 기능
  - [x] 당첨 내역 계산 및 출력 기능
  - [x] 수익률 계산 및 출력 기능 

<br/>

#### ※ Lotto (로또)
- [x] 로또 번호 숫자 범위 : 1 ~ 46
- [x] 1개 로또 발행 시, 중복되지 않는 6개 숫자 추첨
  - [x] 보너스 번호 1개 추가 추첨
- [x] 가격 : 1,000월
- [x] 당첨 : 1등 ~ 5등
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원

<br/>

#### ※ In/Out (입출력)
- [x] 잘못된 값 입력 시, `IllegalArgumentException` 발생
- [x] 잘못된 값 입력 시, 에러 메시지 출력

<br/>

- [x] 입력 : **구입 금액**
  - [x] 단위 : 1000원 단위
  - [x] 1000원으로 나누어 떨어지지 않을 경우, 예외 발생
    ```text
    구입금액을 입력해 주세요.
    8000
    ```
- [x] 입력 : **당첨 번호**(쉼표`,` 기준 구분)
  - [x] 1 ~ 46 범위에 벗어날 경우, 예외 발생
  - [x] 6개 초과할 경우, 예외 발생
    ```text
    당첨 번호를 입력해 주세요.
    1,2,3,4,5,6
    ```
- [x] 입력 : **보너스 번호**
  - [x] 1 ~ 46 범위에 벗어날 경우, 예외 발생
  - [x] 1개 초과할 경우, 예외 발생
    ```text
    보너스 번호를 입력해 주세요.
    7
    ```

<br/>

- [x] 출력 : 발행한 **로또 수량** 및 **번호**
  - [x] 로또 번호는 "**오름차순**"으로 출력 
  ```text
  8개를 구매했습니다.
  [8, 21, 23, 41, 42, 43]
  [3, 5, 11, 16, 32, 38]
  [7, 11, 16, 35, 36, 44]
  [1, 8, 11, 31, 41, 42]
  [13, 14, 16, 38, 42, 45]
  [7, 11, 30, 40, 42, 43]
  [2, 13, 22, 32, 38, 45]
  [1, 3, 5, 14, 22, 45]
  ```
- [x] 출력 : **당첨 내역**
  ```text
  당첨 통계
  ---
  3개 일치 (5,000원) - 1개
  4개 일치 (50,000원) - 0개
  5개 일치 (1,500,000원) - 0개
  5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
  6개 일치 (2,000,000,000원) - 0개
  ```
- [x] 출력 : **수익률**
  - [x] 수익률은 "**소수점 둘째 자리에서 반올림**"하여 출력
  ```text
  총 수익률은 62.5%입니다.
  ```

<br/>

#### ※ Exception (예외)

- [x] 예외 상황 시, 에러 문구 출력
  - [x] `[ERROR]` 시작 
- [x] 예외 상황 시, 에러 문구 출력 이후 "**그 부분부터 재입력**"



<br/>
<br/>

### 💻 프로그래밍

---
- [x] JDK 21 버전
- [x] 자바 코드 컨벤션([Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)) 준수
- [x] 별도 프로그래밍 요구 사항이 없을 경우, 파일/패키지 등의 이동 및 이름 변경 금지

<br/>

- [x] indent depth 2 제한
- [x] 3항 연선자 금지
- [x] 단일 함수 단일 기능
  - [x] 최대한 작게 구현

<br/>

- [x] 기능 **단위 테스트** 작성
  - [x] [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/) / [AssertJ User Guide](https://assertj.github.io/doc/) / [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion) / [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5) 참고
  - [x] UI(`System.out`, `System.in`, `Scanner`) 테스트 제외
- [x] Java **Enum** 적용
- [x] 함수/메서드 길이 15라인 길이 제한
- [x] `else` 예약어 금지
  - [x] `switch/case` 금지
  - [x] `if` 조건절 "Early Return" 활용

<br/>

- [Lotto 클래스](#-lotto-로또) 제한
  - [x] 제공된 `Lotto` 클래스 사용 구현
  - [x] `Lotto.numbers` 이외 필드(인스턴스 변수) 추가 금지
  - [x] `Lotto.numbers` 접근제어자 `private` 변경 금지
  - [x] `lotto/Lotto` 패키지 변경 금지

<br/>
<br/>

### 📝 과제

---
- [x] 기능 구현 전, `README.md` 기능 목록 정리
- [x] 커밋 메시지 [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 참고
