# java-lotto-precourse

## 로또 프로젝트

---

### 목차

1. [프로젝트 설명](#프로젝트-설명)
2. [구현 기능 목록](#구현-기능-목록)
    - [Model](#1-model)
    - [View](#2-view)
    - [Controller](#3-controller)
    - [Service](#4-service)
    - [Util](#5-util)

---

## 프로젝트 설명

로또 게임을 구현하여 사용자로부터 구입 금액을 입력받고, 로또 번호를 생성 및 구매하여 당첨 여부를 판별하고 수익률을 계산합니다. 유효성 검사를 통해 사용자가 올바른 형식의 데이터를 입력할 수 있도록 안내합니다.

---

## 구현 기능 목록

### 1. Model

- **Lotto 클래스**
    - 로또 한 장의 번호 6개를 저장하고 관리합니다.
    - 주요 필드:
        - `numbers`: 추첨된 로또 번호들을 저장하는 리스트입니다.
    - 주요 메서드:
        - `validate()`: 번호가 6개인지 검사하는 유효성 검사 메서드입니다.
        - `sortNumbers()`: 로또 번호 6개를 오름차순으로 정렬합니다.

- **WinningLotto 클래스**
    - 로또 당첨 번호 6개와 보너스 번호 1개를 저장하고 관리합니다.
    - 주요 필드:
        - `winningNumbers`: 로또 당첨 번호 6개를 저장하는 리스트입니다.
        - `bonusNumber`: 보너스 번호를 저장하는 변수입니다.
    - 주요 메서드:
        - `validateBonusNumber()`: 보너스 번호가 당첨 번호와 중복되지 않는지 검사합니다.

- **Rank 클래스**
    - 로또의 당첨 등수를 정의하고 상금 정보를 관리합니다.
    - 주요 필드 및 메서드:
        - `getMatchCount()`: 각 Rank Enum의 일치하는 번호 개수를 반환합니다.
        - `getPrize()`: 각 Rank Enum의 상금을 반환합니다.
        - `valueOf()`: 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 적절한 Rank Enum 값을 반환합니다.

---

### 2. View

- **InputView 클래스**
    - 사용자로부터 **금액**과 **당첨 번호**를 입력받아 반환합니다.
    - 주요 메서드:
        - `inputMoney()`: 구입 금액을 입력받고, 유효성 검사를 수행합니다.
        - `inputWinningNumbers()`: 당첨 번호 6개를 입력받아 유효성 검사를 수행한 후 반환합니다.
        - `inputBonusNumber()`: 보너스 번호 1개를 입력받아 유효성 검사를 수행한 후 반환합니다.

- **OutputView 클래스**
    - **발행한 로또 수량 및 번호**, **당첨 내역**, **수익률**을 출력합니다.
    - 주요 메서드:
        - `printLottoTickets()`: 구매한 로또 갯수와 번호들을 출력합니다.
        - `printResults()`: 당첨 통계를 출력합니다.
        - `printYield()`: 수익률을 출력합니다.

- **InputHandler 클래스**
    - 사용자로부터 입력받은 데이터를 검증하고 파싱하여 사용할 수 있도록 처리합니다.
    - 주요 메서드:
        - `getValidMoney()`: 구입 금액이 1,000원 단위인지 검증하고 유효하지 않을 경우 에러 메시지를 출력합니다.
        - `getValidWinningNumbers()`: 사용자가 입력한 당첨 번호를 파싱하고, 각각의 번호가 유효한지 검증합니다.
        - `getValidBonusNumber()`: 보너스 번호가 로또 번호 범위에 속하고 당첨 번호와 중복되지 않도록 검증합니다.

---

### 3. Controller

- **LottoController 클래스**
    - 로또 발행과 당첨 선별 과정의 전반적인 흐름을 관리하고 사용자와의 상호작용을 담당합니다.
    - 주요 역할:
        - `InputView`에서 받은 입력을 바탕으로 `Lotto` 객체 리스트를 생성하고, 각 티켓의 당첨 여부를 판별합니다.
        - `OutputView`를 통해 결과와 수익률을 출력합니다.

---

### 4. Service

- **LottoService 클래스**
    - 로또 발행, 당첨 번호 설정, 결과 계산 및 수익률 계산을 수행합니다.
    - 주요 메서드:
        - `issueLottoTickets(int ticketCount)`: 구입 금액에 따라 로또 티켓을 생성합니다. 각 티켓은 중복 없는 6개의 번호로
          구성되며 `generateLottoNumbers()` 메서드를 통해 생성됩니다.
        - `generateLottoNumbers()`: 1~45 사이의 중복 없는 6개의 번호를 생성하여 오름차순으로 정렬 후 반환합니다.
        - `setWinningNumbers(List<Integer> winningNumbers, int bonusNumber)`: 당첨 번호와 보너스 번호를 설정합니다.
        - `calculateResults()`: 사용자가 구매한 로또 티켓들과 당첨 번호를 비교하여 각 티켓의 등수를 계산합니다.
        - `calculateYield(int moneySpent, List<Rank> results)`: 총 상금과 구입 금액을 바탕으로 수익률을 계산하여 퍼센트로 반환합니다.

---

### 5. Util

- **Validator 클래스**
    - 유효성 검사를 담당하는 유틸리티 클래스입니다.
    - 주요 메서드:
        - `validateLottoNumberCount()`: 로또 번호가 6개인지 검증합니다.
        - `validateLottoNumberRange()`: 로또 번호가 1~45 범위에 있는지 검증합니다.
        - `validateLottoNumberDuplication()`: 로또 번호에 중복이 없는지 검증합니다.
        - `validatePurchaseAmount()`: 구입 금액이 1,000원 단위인지 검증합니다.
        - `validateAndParseNumber()`: 입력값이 숫자 형식인지 확인 후 정수로 변환합니다.
        - `validateBonusNumberDuplication()`: 보너스 번호가 당첨 번호와 중복되지 않는지 검증합니다.

- **Config 클래스**
    - 상수 값을 저장하는 유틸리티 클래스입니다. 로또 번호 범위, 구입 금액 단위, 에러 메시지 등을 포함합니다.

