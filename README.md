# 🎱 로또 게임

## 🎯 기능 요구사항

### 핵심 기능
- [x] 로또 구매
    - 구입 금액을 입력받아 로또 발행
    - 1장당 1,000원
    - 발행된 로또는 오름차순으로 정렬하여 표시
- [x] 당첨 번호 확인
    - 당첨 번호 6개와 보너스 번호 1개 입력
    - 구매한 로또와 비교하여 당첨 여부 확인
- [x] 당첨 통계 및 수익률 계산
    - 당첨 내역 출력 (1등~5등)
    - 총 수익률 계산 (소수점 둘째 자리에서 반올림)

### 예외 처리
- [x] 구입 금액 검증
    - 1,000원 단위로만 구매 가능
    - 숫자가 아닌 입력값 처리
- [x] 로또 번호 검증
    - 1~45 사이의 숫자만 허용
    - 중복된 숫자 불가
    - 정확히 6개의 숫자만 입력
- [x] 보너스 번호 검증
    - 1~45 사이의 숫자만 허용
    - 당첨 번호와 중복되지 않아야 함

## 🏗️ 프로그램 구조

### 패키지 구조
```
lotto
├── domain
│   ├── Lotto.java
│   ├── WinningLotto.java
│   └── PrizeRank.java
├── service
│   └── LottoService.java
├── controller
│   └── LottoController.java
├── view
│   ├── InputView.java
│   └── ResultView.java
└── util
    └── LottoNumberGenerator.java
```

### 클래스 설명
- **Domain**
    - `Lotto`: 로또 번호를 관리하는 도메인 객체
    - `WinningLotto`: 당첨 번호와 보너스 번호를 관리하는 객체
    - `PrizeRank`: 당첨 등수와 상금을 관리하는 Enum 클래스
- **Service**
    - `LottoService`: 로또 발행과 당첨 확인 로직을 처리
- **Controller**
    - `LottoController`: 사용자 입력과 비즈니스 로직을 연결
- **View**
    - `InputView`: 사용자 입력을 처리하고 검증
    - `ResultView`: 결과를 출력
- **Util**
    - `LottoNumberGenerator`: 로또 번호 생성 유틸리티

## 🎮 실행 예시
```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
...

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
...
총 수익률은 62.5%입니다.
```

## ✅ 프로그래밍 요구사항 준수
- 함수 길이 15라인 이내로 제한
- else 예약어 사용하지 않음
- Java Enum 적용
- 테스트 코드 작성 (JUnit 5, AssertJ)
- indent depth 2 이하 유지
- 3항 연산자 미사용

## 🧪 테스트 전략
- 작은 단위의 테스트부터 시작하여 점진적으로 확장
- 도메인 로직에 대한 단위 테스트 우선 구현
- UI 로직(System.out, System.in)은 테스트에서 제외