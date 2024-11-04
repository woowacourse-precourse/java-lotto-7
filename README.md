# java-lotto-precourse
Java Lotto Program
이 프로그램은 사용자가 로또를 구매하고 당첨 번호 및 보너스 번호를 입력하여 당첨 여부를 확인하고, 통계를 통해 수익률을 계산하는 기능을 제공합니다.

프로그램 흐름
구입 금액을 입력하여 발행할 로또 수량을 결정합니다.
로또 번호를 무작위로 생성하여 구입한 로또 티켓을 출력합니다.
당첨 번호 및 보너스 번호를 입력받아 당첨 결과를 계산합니다.
각 로또 티켓의 당첨 여부에 따른 당첨 통계와 수익률을 출력합니다.
---

## **기능 요구 사항**

1. **로또 번호 범위**: 1부터 45까지의 숫자를 사용합니다.
2. **로또 번호 발행**:
    - 한 장의 로또 티켓에는 중복되지 않는 6개의 숫자를 포함해야 합니다.
3. **당첨 번호 추첨**:
    - 중복되지 않는 6개의 당첨 번호와 1개의 보너스 번호를 사용합니다.
4. **당첨 기준 및 상금**:
    - 1등: 6개 번호 일치 - 상금 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 - 상금 30,000,000원
    - 3등: 5개 번호 일치 - 상금 1,500,000원
    - 4등: 4개 번호 일치 - 상금 50,000원
    - 5등: 3개 번호 일치 - 상금 5,000원
5. **로또 구매**:
    - 사용자가 입력한 금액에 맞추어 구매한 만큼의 로또를 발행합니다.
    - 한 장당 1,000원의 가격으로 판매합니다.
6. **당첨 번호 및 보너스 번호 입력**:
    - 사용자로부터 쉼표(,)로 구분된 6개의 당첨 번호와 1개의 보너스 번호를 입력받습니다.
7. **결과 출력**:
    - 발행한 로또 티켓 수량과 번호를 오름차순으로 정렬하여 출력합니다.
    - 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역을 출력합니다.
    - 최종 수익률을 계산하여 출력합니다.
8. **예외 처리**:
    - 올바르지 않은 입력 시 `IllegalArgumentException`을 발생시키고 "[ERROR]"로 시작하는 에러 메시지를 출력합니다.
    - 금액 입력 오류(예: 1,000원으로 나누어떨어지지 않는 경우), 로또 번호 범위 오류, 보너스 번호 오류, 중복 번호 오류 등을 처리합니다.

---

## **입출력 요구 사항**

### **입력**

1. **구입 금액 입력**: 구입 금액은 1,000원 단위로 입력받습니다.
2. **당첨 번호 입력**: 쉼표(,)로 구분된 6개의 당첨 번호를 입력받습니다.
3. **보너스 번호 입력**: 1개의 보너스 번호를 입력받습니다.

### **출력**

1. **발행된 로또 티켓 수량 및 번호**: 오름차순으로 정렬된 발행 로또 번호 리스트를 출력합니다.
2. **당첨 내역**: 당첨 기준별(3등 ~ 1등)로 일치한 개수와 해당 당첨금을 출력합니다.
3. **수익률 출력**: 총 수익률을 소수점 첫째 자리까지 계산하여 출력합니다.

---

## **클래스 설계**

Lotto 클래스를 제공받았으므로, 다른 클래스들은 Lotto와 협력하면서 기능을 담당하는 방식으로 설계해야 합니다.

src/main/java/lotto


├── Application.java          # 메인 애플리케이션 실행 클래스

├── Lotto.java                # 로또 티켓 객체, 로또 번호의 유효성 검사

├── LottoMachine.java         # 로또 게임의 메인 로직을 관리

├── LottoTicketGenerator.java # 로또 번호 생성기

├── PurchaseValidator.java    # 구입 금액 유효성 검사

├── WinStatistics.java        # 당첨 통계 계산 및 수익률 출력

└── WinningChecker.java       # 당첨 번호 및 보너스 번호와 매칭 여부 확인

## **클래스 설명**

Application.java

기능: LottoMachine을 통해 로또 프로그램을 실행합니다.

**Lotto.java**

기능: 단일 로또 티켓을 표현합니다.

제약: numbers 외의 필드를 추가할 수 없으며 numbers는 private로 설정되어 있어 외부에서 직접 접근할 수 없습니다.

구현사항: 로또 번호 6개의 유효성 검사를 수행합니다.

**LottoMachine.java**

기능: 로또 구입 금액 입력, 로또 티켓 구매, 당첨 번호와 보너스 번호 입력, 당첨 결과 출력까지 로또 게임의 메인 로직을 관리합니다.

추가된 기능: 당첨 번호 입력과 통계 결과 출력 로직이 추가되었습니다.

**LottoTicketGenerator.java**

기능: 사용자가 입력한 구입 금액에 따라 지정된 수량의 로또 티켓을 생성합니다.

**PurchaseValidator.java**

기능: 구입 금액이 1,000원 단위인지 확인하며, 유효하지 않은 경우 예외를 발생시킵니다.

**WinStatistics.java**

기능: 당첨 티켓 수를 기준으로 당첨 통계를 계산하고, 전체 수익률을 출력합니다.

**메서드**

calculateStatistics : 각 당첨 조건에 해당하는 티켓 수를 계산합니다.

calculateYield : 구입 금액 대비 수익률을 계산합니다.

printStatistics : 당첨 내역과 수익률을 출력합니다.

WinningChecker.java : 로또 티켓 번호와 당첨 번호 및 보너스 번호를 비교하여 당첨 여부를 확인합니다.

checkWinning: 각 로또 티켓의 번호를 당첨 번호와 비교하여 당첨 결과를 반환합니다.

---

## **예외 처리 규칙**

1. **잘못된 구입 금액**: 1,000원 단위로 나누어떨어지지 않는 경우 예외를 발생시킵니다.
    - `[ERROR] 구입 금액은 1,000원 단위로 입력해야 합니다.`
2. **로또 번호 범위 초과**: 1~45 사이의 번호가 아닌 경우 예외를 발생시킵니다.
    - `[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.`
3. **보너스 번호 범위 초과**: 보너스 번호가 1~45 범위를 벗어날 경우 예외를 발생시킵니다.
    - `[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.`
4. **중복 번호**: 로또 번호나 당첨 번호에 중복된 번호가 있을 경우 예외를 발생시킵니다.
    - `[ERROR] 로또 번호는 중복될 수 없습니다.`

---

## **실행 흐름 예시**

1. **구입금액을 입력해 주세요.**
    - 입력: `8000`
2. **발행된 로또**
    - 출력:
        
        ```
        8개를 구매했습니다.
        [8, 21, 23, 41, 42, 43]
        [3, 5, 11, 16, 32, 38]
        ...
        
        ```
        
3. **당첨 번호를 입력해 주세요.**
    - 입력: `1,2,3,4,5,6`
4. **보너스 번호를 입력해 주세요.**
    - 입력: `7`
5. **당첨 통계**
    - 출력:
        
        ```
        당첨 통계
        ---
        3개 일치 (5,000원) - 1개
        4개 일치 (50,000원) - 0개
        ...
        총 수익률은 62.5%입니다.
        
        ```
