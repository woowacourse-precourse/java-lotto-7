# java-lotto-precourse

## 📁 패키지 목록

```markdown
📦 lotto
┣ 📂 constants
┃ ┗ ⚡ ErrorMessage
┃
┣ 📂 controller
┃ ┗ 🔷 LottoController
┃
┣ 📂 domain
┃ ┣ 📂 number
┃ ┃ ┣ 🔷 BonusNumber
┃ ┃ ┣ 🔷 WinningLottoNumbers
┃ ┃ ┗ 🔷 WinningNumbers
┃ ┣ 📂 result
┃ ┃ ┣ 🔷 LottoResult
┃ ┃ ┗ 🔷 WinningStatistics
┃ ┣ 🔷 Lotto
┃ ┣ 📊 LottoRank
┃ ┗ 🔷 PurchaseAmount
┃
┣ 📂 generator
┃ ┣ 🛠 LottoNumberGenerator
┃ ┗ 🔷 RandomLottoGenerator
┃
┣ 📂 service
┃ ┗ 🔷 LottoService
┃
┣ 📂 view
┃ ┣ 📂 Input
┃ ┃ ┣ 🔄 InputProcessor
┃ ┃ ┗ 🔷 InputView
┃ ┗ 📂 Output
┃ ┗ 🔷 OutputView
┃
┗ 🔷 Application

```

## 🚀 기능 구현 목록

- [x] 구입 금액 입력 및 로또 구매
  - [x] 구입 금액 검증
    - [x] 숫자 형식 검증
    - [x] 0 또는 음수 검증
    - [x] 1000원 단위 검증
    - [x] 최대 구매 금액 검증 (int 범위)
  - [x] 구입 금액에 따른 로또 발급
  - [x] 발행된 로또 번호 출력 (오름차순)

- [x] 당첨 번호 입력 및 검증
  - [x] 당첨 번호 6개 입력
    - [x] 쉼표(,) 구분자 검증
    - [x] 숫자 형식 검증
    - [x] 번호 개수 검증 (6개)
    - [x] 번호 범위 검증 (1-45)
    - [x] 중복 번호 검증
  - [x] 보너스 번호 입력
    - [x] 숫자 형식 검증
    - [x] 번호 범위 검증 (1-45)
    - [x] 당첨 번호와 중복 검증

- [x] 당첨 결과 계산
  - [x] 당첨 번호 매칭 확인
  - [x] 보너스 번호 매칭 확인
  - [x] 당첨 등수 판정
    - [x] 1등: 6개 번호 일치
    - [x] 2등: 5개 번호 + 보너스 번호 일치
    - [x] 3등: 5개 번호 일치
    - [x] 4등: 4개 번호 일치
    - [x] 5등: 3개 번호 일치
  - [x] 당첨금 계산
  - [x] 수익률 계산 (소수점 둘째 자리 반올림)

- [x] 예외 처리
  - [x] 잘못된 입력에 대한 "[ERROR]" 메시지 출력
  - [x] 에러 발생 시 해당 부분부터 재입력

## 🎯 프로그래밍 요구사항

### 프로그래밍 제약사항

- JDK 21 사용
- Application의 main()에서 시작
- System.exit() 사용 금지
- build.gradle 파일 변경 금지
- 외부 라이브러리 사용 금지
- 파일/패키지 이름 변경 및 이동 제한

### 코드 작성 규칙

- indent depth 최대 2까지 허용
- 3항 연산자 사용 금지
- else 예약어 사용 금지 (switch/case 포함)
- 함수는 한 가지 기능만 수행
- 함수 길이 15라인 이내
- Java Enum 사용
- Java 코드 컨벤션 준수

### 사용할 라이브러리

1. 필수 라이브러리

- camp.nextstep.edu.missionutils.Randoms
- camp.nextstep.edu.missionutils.Console


2. 테스트 라이브러리

- JUnit 5
- AssertJ

## 📋 실행 결과 예시

```markdown
구입금액을 입력해 주세요.
4000
4개를 구매했습니다.
[7, 9, 22, 27, 35, 45]
[4, 13, 15, 24, 29, 32]
[3, 10, 23, 27, 29, 38]
[2, 4, 6, 9, 19, 29]
당첨 번호를 입력해 주세요.
2,3,6,9,29,38
보너스 번호를 입력해 주세요.
19

당첨 통계
---
6개 일치 (2,000,000,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
5개 일치 (1,500,000원) - 0개
4개 일치 (50,000원) - 1개
3개 일치 (5,000원) - 1개
총 수익률은 1375.0%입니다.
```