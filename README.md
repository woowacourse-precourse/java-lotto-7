# java-lotto-precourse

## ⭐ 미션 : 로또

### 📢 프로그램 소개

> 간단한 로또 발매기를 구현한 프로그램

### 📢 시나리오

1. 로또 번호의 숫자 범위는 1~45까지이다.
2. 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
3. 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
4. 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
5. 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
    - 로또 구입 금액은 1,000원 단위로 입력받고, 나누어 떨어지지 않으면 예외처리한다
6. 로또 1장의 가격은 1,000원이다.
7. 당첨 번호와 보너스 번호를 입력받는다.
    - 당첨 번호는 쉼표(,) 를 기준으로 구분한다.
    - 보너스 번호를 입력받는다
8. 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
    - 수익률은 소수점 둘째 자리에서 반올림한다.
9. 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

✅ 기능 구현 목록
---

### 사용자 입력받기

- [x] 로또 구입 금액 입력받기
- [x] 당첨 번호 입력받기
- [x] 보너스 번호 입력받기
- [x] 공통 예외 처리
    - ❗빈 문자열 입력한 경우 예외 처리하기

### 사용자 입력 값 유효성하기

- [x] <로또 구입 금액>의 유효성 검증하기
    - [x] 예외 처리
        - ❗로또 금액에 나누어 떨어지지 않은 경우 예외 처리하기
        - ❗올바른 정수형식이 아닌 경우 예외 처리하기(예: -0, 0212)
        - ❗0이하 값이 들어온 경우 예외 처리하기

- [x] <당첨 번호>의 유효성 검증하기
    - [x] 예외 처리
        - ❗번호가 6개 입력되어 있지 않은 경우 예외 처리하기
        - ❗번호가 1-45 사이의 수가 아닌 경우 예외 처리하기
        - ❗수와 쉼표(,)외의 문자가 들어온 경우 예외 처리하기
        - ❗번호 중에 중복된 수가 있으면 예외 처리하기

- [ ] <보너스 번호>의 유효성 검증하기
    - [ ] 예외 처리
        - ❗보너스 번호가 1-45 사이의 수가 아닌 경우 예외 처리하기
        - ❗ 당첨번호 중에 중복된 번호가 있으면 예외 처리하기

### 사용자 입력 값 정제하기

- [x] <로또 구입 금액>으로 <로또 수량> 계산하기
    - [x] 1장은 1,000원

- [x] <당첨 번호>에서 번호만 추출하기
    - [x] 쉼표(,) 기준으로 구분하여 번호 추출하기

### 로또 발급하기

- [ ] 로또 구입 금액에 따른 로또 수량 계산하기
- [ ] 로또 번호 자동 생성하기
    - [ ] `camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()` 를 사용하여
      1~45 사이의 중복되지 않은 정수 6개 만들기
- [ ] 로또 발급하기
    - [ ] 로또 수량 만큼 로또 번호 자동 생성하기

### 로또 당첨 내역 확인하기

- [ ] 당첨 번호와 발행한 로또 번호와 비교하기
    - [ ] 일치한 번호 개수에 따라 등수 설정하기
- [ ] 당첨 내역 확인하기
    - [ ] 각 로또 별로 당첨 번호와 로또 번호 비교하기
- [ ] 수익률 계산하기
    - [ ] 소수점 둘째 자리에서 반올림하기

### 결과 출력하기

- [x] 사용자 입력 안내 메시지 출력하기
    - [x] 구입금액 입력 메시지 출력하기('구입금액을 입력해 주세요.')
    - [x] 당첨번호 입력 메시지 출력하기('당첨 번호를 입력해 주세요.')
    - [x] 보너스 번호 입력 메시지 출력하기('보너스 번호를 입력해 주세요.')
- [ ] 발급된 <로또 수량> 출력하기
- [ ] 발급된 로또 번호 출력하기
- [ ] 당첨 통계 출력하기
    - [ ] 가로 구분선 출력하기
    - [ ] 각 등수별 당첨 갯수 출력하기
    - [ ] 총 수익률 출력하기

### 예외 처리 시 에러 문구 설정하기

- [x] 모든 예외 상황 시 에러 문구를 `[ERROR]` 로 시작되게 하기
- [x] 예외 발생 시 명확한 유형을 선언하여 처리하기

⭐ 개발 목표
---

#### 📍 이전 주차까지 제시된 프로그래밍 요구 사항 및 학습 목표를 지키면서 개발하기

- Java Style Guide 지키기
- Git Commit Convention 지키기 : 작은 단위로 자주 커밋하기
- 들여쓰기 깊이는 3이 넘지 않도록 하기
- 3항 연산자 쓰지 않기
- 함수가 한 가지 일만 하도록 작게 만들기
- JUnit5 & AssertJ 를 활용하여 테스트 코드로 확인하며 개발하기
- 배열 대신 컬렉션 사용하기
- Java 에서 제공하는 API 적극 활용하기
- 이름을 통해 의도 들어내기 & 축약하지 않기
- 의미없는 주석 달지 않기

#### 📍 공통 피드백 반영하여 개발하기

- README.md를 상세하게 작성하기
    - 어떤 프로젝트인지, 주요 기능이 무엇인지 소개하기
- 기능 목록 재 검토하기
    - 클레스, 메서드 설계와 구현과 관련된 내용은 포함하지 않기
    - 예외 상황도 함께 정리하기
- 구현 과정에서 기능 목록 지속 업데이트 하기
- 값을 하드 코딩하지 않기
    - 상수 static final 정의하고 이름 부여하기
- 클래스 선언
    - 상수, 멤버 변수, 생성자, 메서드 순으로 작성하기
- 변수이름에 자료형 사용하지 않기
    - 이전 주차의 carList 처럼 자료형, 자료구조 등을 포함하지 않기
- 한 메서드가 한가지 기능만 담당하게 하기
- 작은 단위의 테스트를 만들면서 피드백하기

#### 📍️ 3 주차 미션에 제시된 프로그래밍 요구 사항 및 학습 목표를 반영하여 개발하기

- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 하기
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보하기
- 함수의 길이 <= 15라인
- else 예약어 쓰지 않기
- Java Enum 을 적용하여 프로그램 구현하기
- 단위 테스트 진행하기(UI 로직은 제외)
- camp.nextstep.edu.missionutils에서 제공하는 Randoms 및 Console API를 사용하여 구현
    - Random 값 추출은 camp.nextstep.edu.missionutils.Randoms의 pickUniqueNumbersInRange()를 활용
      사용자가 입력하는 값은 camp.nextstep.edu.missionutils.Console의 readLine()을 활용
- 제공된 Lotto 클래스를 사용하여 구현하기
    - numbers 이외의 필드 추가 금지
    - numbers의 접근 제어자 변경 금지
    - package는 변경 가능