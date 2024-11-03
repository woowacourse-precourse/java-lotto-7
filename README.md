# java-lotto-precourse
## 로또 어플리케이션의 기능

- 로또의 구입 금액을 입력받아 금액만큼 로또를 발행하고 로또 번호를 출력한다.
- 추첨번호와 보너스 번호를 입력받아 구매한 로또의 당첨 결과 및 수익률을 출력한다.

## 로또 어플리케이션의 요구사항

- 로또 번호의 범위는 1이상 45이하의 정수이다.
- 하나의 로또는 중복되지 않는 6개의 로또 번호를 가진다.
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 개수의 로또를 발행한다.
- 로또 1장 가격은 1,000원이다.
- 당첨 번호 추첨 시 중복되지 않는 당첨 번호 6개와 보너스 번호를 입력 받는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 사용자로 부터 로또 번호, 가격, 추첨 번호 및 보너스 번호 등 범위, 단위, 형식에 벗어나는 입력을 받았을 때 `IllegalArgumentException`을 발생시키고 “[ERROR]”로 시작하는 에러 메시지를 출력 후 그 부분부터 다시 입력 받는다

## 구현할 기능 목록

## Front-end

### 사용자 입력 기능

- [ ]  로또 구입금액을 입력 받는다.
    - [ ]  “구입금액을 입력해 주세요.”을 출력한다.
    - [ ]  로또 구입금액을 입력 받는다.
    - [ ]  숫자가 입력되지 않으면 **`IllegalArgumentException`** 을 발생시켜 에러 메시지를 출력하고 다시 입력을 받는다.
- [ ]  당첨 번호를 입력 받는다.
    - [ ]  “당첨 번호를 입력해 주세요.”을 출력한다.
    - [ ]  쉼표로 구분된 당첨 번호를 입력 받는다.
    - [ ]  입력 형식에 맞지 않은 입력을 받으면 **`IllegalArgumentException`** 을 발생시켜 에러 메시지를 출력하고 다시 입력을 받는다.
- [ ]  보너스 번호를 입력 받는다.
    - [ ]  “보너스 번호를 입력해 주세요.”을 출력한다.
    - [ ]  보너스 번호를 입력 받는다.
    - [ ]  숫자가 입력되지 않으면 **`IllegalArgumentException`** 을 발생시켜 에러 메시지를 출력하고 다시 입력을 받는다.

### 사용자 출력 기능

- [ ]  구매한 로또를 출력한다.
    - [ ]  “%d개를 구매했습니다.”를 출력한다.
    - [ ]  구매한 로또 개수 만큼 **`^[\d+(,\d+)*]$`** 의 형식으로 출력한다.
- [ ]  당첨 통계를 출력한다
    - [ ]  “당첨 통계\n---”를 출력한다.
    - [ ]  당첨 현황을 출력한다.
        - [ ]  **`“%d개 일치, 보너스 볼 일치 (%s원) - %d”`**개 혹은**`“%d개 일치 (%s원) - %d”`** 개 형식으로 출력한다.
    - [ ]  **수익률을 출력한다.**
        - [ ]  **`"총 수익률은 %.1f%%입니다."`의 형식으로 출력한다.**

### Back-end

### 로또 발행 기능

- [x]  로또를 발행한다.
    - [x]  로또 구입 금액에 따라 로또 개수를 계산한다.
    - [x]  로또 하나당 1과 45 사이의 중복되지 않는 6개의 난수로 로또 번호를 생성한다.
        - [x]  그렇지 않으면 **`IllegalArgumentException`** 을 발생시켜 에러 메시지를 출력하고 다시 입력을 받는다.
    - [x]  로또 개수만큼 로또를 발행한다.
    - [x]  로또 번호들은 오름차순으로 정렬되어야 한다.
- [x]  로또 금액 가격을 위한 검증을 수행한다.
    - [x]  1,000원 단위가 아닐 때 **`IllegalArgumentException`** 을 발생시켜 에러 메시지를 출력하고 다시 입력을 받는다.

### 로또 번호 저장 기능

- [ ]  당첨 확인을 위해 사용자가 구매한 로또 번호를 저장한다.

### 당첨 번호 저장 기능

- [x]  당첨 번호를 검증한다
    - [x]  당첨 번호는 1과 45 사이의 중복되지 않는 6개의 정수여야 한다.
        - [x]  그렇지 않으면 **`IllegalArgumentException`** 을 발생시켜 에러 메시지를 출력하고 다시 입력을 받는다.
- [ ]  당첨 확인을 위해 사용자 추첨을 통한 당첨 번호를 저장한다.

### 보너스 번호 검증 기능

- [x] 보너스 번호는 1과 45 사이의 하나의 정수여야 한다.
  - [x] 그렇지 않으면 **`IllegalArgumentException`** 을 발생시켜 에러 메시지를 출력하고 다시 입력을 받는다.

### 당첨 확인 기능

- [x]  사용자로부터 입력받은 보너스 번호와 당첨 번호를 통해 당첨을 확인한다.
    - [x]  구매한 로또 번호들과 당첨 번호 및 보너스 번호와 일치하는 개수를 계산한다.
    - [x]  해당 개수에 해당하는 당첨 순위를 저장한다.
    - [x]  당첨 순위에 맞는 당첨 금액 및 일치 여부를 저장한다.
- [ ]  수익률을 계산한다.
    - [ ]  수익률 계산은 **`(총 당첨 금액 / 로또 구입 금액) x 100`** 으로 계산한다.