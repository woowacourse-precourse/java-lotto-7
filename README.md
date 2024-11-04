# java-lotto-precourse

<br>
# 프리코스 로또 과제

---

## MVC 패턴의 역할 분리

이번 과제는 MVC 패턴을 도입하여 역할을 분리 하였다.

- **`LottoController`**: 전체 로직의 흐름을 관리하고, 잘못된 입력이 발생하면 예외를 처리하고 재입력을 요청한다.
- **`View`**: 모든 입력과 출력을 처리한다.(에러 메세지 포함)
- **`Domain`**: 핵심 비즈니스 로직을 담당한다. 로또 번호의 유효성 검사, 당첨 기준 관리, 당첨 결과 집계 등의 핵심 기능을 포함.

---

## 🎯 에러 목록

### 1. **로또 구매 가격 입력 오류**: 올바른 형식과 단위가 아닌 경우 예외 발생
- 입력 구매 금액이 숫자가 아닐 때: `"[ERROR] 숫자만 입력해야 합니다!(로또 번호 입력의 경우 구분자는 쉼표)"` 메세지 출력
- 입력 구매 금액이 1000원으로 나눠떨어지지 않을 때 : `"[ERROR] 구매 금액은 1000원 단위 입니다!"` 메세지 출력
- 메세지 출력 0원 이하일 때 : `"[ERROR] 구매 금액은 0원을 초과해야 합니다!"` 메세지 출력

### 2. **당첨 번호 입력 오류**: 숫자 형식이 아니거나 범위 외 숫자가 입력될 경우 예외 발생
- 입력 로또 번호가 숫자가 아니거나 구분자가 쉼표가 아닐 때 : `"[ERROR] 숫자만 입력해야 합니다!(로또 번호 입력의 경우 구분자는 쉼표)"` 메세지 출력
- 입력 로또 번호가 중복될 때 : `"[ERROR] 로또의 번호는 중복되면 안됩니다!"` 메세지 출력
- 로또 번호의 범위가 1~45 사이의 정수가 아닐 때 : `"[ERROR] 로또의 번호는 1~45 사이의 정수입니다!"` 메세지 출력

### 2. **보너스 번호 입력 오류**: 보너스 번호가 범위 밖이거나 당첨 번호와 중복될 경우 예외 발생
- 입력 보너스 번호가 숫자가 아닐 때 : `"[ERROR] 숫자만 입력해야 합니다!(로또 번호 입력의 경우 구분자는 쉼표)"` 메세지 출력
- 입력 보너스 번호가 우승로또 번호와 중복될 때: `"[ERROR] 보너스 번호는 로또번호와 중복되면 안됩니다!"` 메세지 출력
- 보너스 번호의 범위가 1~45 사이의 정수가 아닐 때 : `"[ERROR] 로또의 번호는 1~45 사이의 정수입니다!"` 메세지 출력

<br>

---

## 📋 로또 프로그램 구현 기능 및 설명

### 1. 입력 로또 구매 가격의 유효성 검사 및 구매 로또 개수 산출
> `LottoAmount 클래스`에서 입력받은 구매 금액이 로또의 최소 가격(1000원)으로 나누어 떨어지는지, 그리고 양의 정수인지 검사한다.

**구현한 주요 메서드 (`LottoAmount 클래스`)**
- `validatePurchasePrice 메서드` : 입력 구매 가격을 정수로 변환(숫자가 아닌 문자 입력 시 `IllegalArgumentException` 발생)
- `validatePriceUnit 메서드` : 입력한 구매 가격이 1000원으로 안 나눠떨어 지는 경우 `IllegalArgumentException` 발생
- `validatePositivePrice 메서드` : 입력 구매 가격이 0 보다 작은 값일 때 `IllegalArgumentException` 발생

이 과정에서 잘못된 금액 입력 시 예외를 발생시키고, `LottoController`에서는 예외 발생 시 재입력을 요청한다.

<br>

---


### 2. 당첨 로또번호의 입력의 유효성 검사
> `Lotto 클래스`에서 입력 받은 당첨 로또의 각 번호가 유효 범위에 있는지, 중복이 없는지 확인한다.

**구현한 주요 메서드 (`Lotto 클래스`)**
- `validate 메서드` : 로또 번호 개수가 6 개가 아니면 `IllegalArgumentException` 발생
- `duplicateLottoNumbers 메서드` : 입력 로또 번호의 중복 검사, 중복 번호 존재 시 `IllegalArgumentException` 발생
- `checkLottoNumbersRange 메서드` : 입력 로또 번호의 범위 검사, 1 ~ 45 사이의 정수가 아니면 `IllegalArgumentException` 발생


사용자가 잘못된 입력을 하면 예외를 발생 시키고, `LottoController`에서 재입력을 요청한다.

<br>

---


### 3. 구매한 로또 개수 만큼 로또 번호 자동생성 
> `RandomLottoNumbers 클래스`에서 6자리의 랜덤 로또 번호 생성한다.

**구현한 주요 메서드 (`RandomLottoNumbers 클래스`)**
- `generateRandomLottoNumbers 메서드` : 중복없는 로또 번호 6개를 뽑는다.(오름차순 정렬)

`LottoController`의 `generateMyLottoList 메서드에서` 위의 `generateRandomLottoNumbers 메서드`를 호출하여 구매 로또 개수만큼 랜덤 로또 번호를 생성한다.

<br>

---

### 4. 보너스번호의 유효성 검사
> `LottoController`에서 입력한 보너스 번호에 대해 당첨번호와 중복이 없는지 올바른 범위인지 유효성 검사를 한다.

**구현한 주요 메서드 (`LottoController 클래스`, `Lotto 클래스`)**
- `bonusNumber 메서드` : 입력번호를 정수로 바꾸고 `validateBonusNumbers 메서드` 호출하여 중복이 있는지 체크한다 (`LottoController 클래스`)
- `validateBonusNumbers 메서드` : 입력한 보너스 번호가 우승 번호와 중복이 있으면 `IllegalArgumentException` 발생 (`Lotto 클래스`)


<br>

---

### 5. LottoPrize enum 타입으로 당첨기준과 상금 메세지 저장
> 각 당첨 기준을 상수로 정의하고, 각 상금 금액과 당첨 메시지를 `LottoPrize` Enum에 저장한다.

<br>

---


### 6. 당첨 현황 집계 및 수익률 계산
> `LottoResult클래스`에서 당첨 로또 번호와 보너스 번호를 기준으로 사용자의 로또 결과를 집계하고, 수익률을 계산한다.

`LottoPrize` Enum을 활용하여 등급과 상금을 매핑하여, 각 `LottoPrize` 상수에 대해 몇번 당첨되었는지에 대한 정보를 유지한다.


**구현한 주요 메서드 (`LottoResult 클래스`)**
- `calculateResults 메서드` : 매치된 로또 번호의 개수를 구한 뒤, 해당하는 `LottoPrize enum 타입` 을 리턴
- `calculateTotalProfit 메서드` : 구매 금액 대비 총 상금으로 수익률을 계산한다.

