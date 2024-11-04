![header](
https://capsule-render.vercel.app/api?type=waving&color=auto&height=300&section=header&text=Java%20Lotto&fontSize=90
)

# 프로그램 설명

- 간단한 로또 발매기를 구현한다.
- 금액에 따라 복권수가 달라진다. (1장에 1000원)
- 로또 발매기는 1장에 6개의 번호를 발급한다.
- 당첨 번호와 보너스 번호를 입력 받는다.
- 당첨 내역을 출력한다.

```text
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43] 
[3, 5, 11, 16, 32, 38] 
[7, 11, 16, 35, 36, 44] 
[1, 8, 11, 31, 41, 42] 
[13, 14, 16, 38, 42, 45] 
[7, 11, 30, 40, 42, 43] 
[2, 13, 22, 32, 38, 45] 
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.
```

---

# 기능 요구사항 정리

이전 프로젝트와는 다르게 예외가 발생되더라도 프로그램이 종료되지 않고 사용자에게 다시 입력을 받도록 한다.

## 입출력 관련

### 입력

1. 구입 금액을 입력 받는다.
    - 구입 금액은 1000원 단위로 입력 받는다.
    - 1000원 단위가 아닌 금액을 입력 받으면 IllegalArgumentException을 발생시킨다.
2. 당첨 번호를 입력 받는다.
    - 쉼표(,)로 구분한다.
    - 1~45 사이의 숫자만 가능하다.
    - 6개의 숫자만 가능하다.
    - 중복된 숫자가 있으면 IllegalArgumentException을 발생시킨다.
3. 보너스 번호를 입력 받는다.
    - 1~45 사이의 숫자만 가능하다.

## 로또 관련

### 로또 구매

1. 구입 금액에 따라 로또를 발급한다.
    - 1000원 단위로 구매 가능하다.
    - 1000원 단위가 아닌 금액을 입력 받으면 IllegalArgumentException을 발생시킨다.
    - 1000원 단위로 구매한 로또의 개수를 구해야 한다.
2. 로또를 발급한다.
    - 1장에 6개의 번호를 발급한다.
    - 1~45 사이의 숫자만 가능하다.
    - 숫자는 중복되지 않는다.

### 당첨 번호 입력

1. 1~45 사이의 숫자만 가능하다.
2. 숫자 6개와 보너스 번호 1개를 입력 받는다.
3. 당첨 번호와 보너스 번호는 중복되지 않는다.

### 보너스 번호 입력

1. 1~45 사이의 숫자만 가능하다.
2. 당첨 번호와 중복되지 않는다.

### 당첨 통계 출력

- 1등: 6개 일치 / 2,000,000,000원
- 2등: 5개 일치, 보너스 번호 일치 / 30,000,000원
- 3등: 5개 일치 / 1,500,000원
- 4등: 4개 일치 / 50,000원
- 5등: 3개 일치 / 5,000원

1. 당첨 번호와 로또 번호를 비교하여 당첨 통계를 출력한다.
2. 당첨 통계는 1등부터 5등까지 출력한다.

### 수익률 출력

1. 구입 금액을 100%로 가정했을 때 수익률을 계산하여 출력한다.
2. 수익률은 소수점 둘째 자리에서 반올림한다.
3. 수익률은 0% 이상이어야 한다.

---

# 변경 가능성이 높은 부분

1. 로또의 가격의 변경.
2. 당첨 번호의 개수 및 형식의 변경
    - 숫자의 범위 변경
    - 중복 허용 여부 변경
    - 당첨 번호의 개수 변경
3. 당첨 기준 및 상금의 변경.
4. 수익률 계산 방식의 변경.

---

# 사용자 입력 예외 사항 기록

### 로또 구입 금액

1. 1000원 단위가 아닌 금액을 입력.
2. 숫자 외에 문자를 입력. ('-', '.', 등)
3. 0원을 입력.
4. 너무 큰 금액을 입력 했을때? 금액의 제한을 두자. 실제로 구입 가능한 최대 금액이 존재함.

### 당첨 번호

1. 1~45 사이의 숫자가 아닌 숫자를 입력.
2. 6개의 숫자가 아닌 숫자를 입력.
3. 중복된 숫자를 입력.
4. 숫자 외에 문자를 입력. ('-', '.', 등)

### 보너스 번호

1. 1~45 사이의 숫자가 아닌 숫자를 입력.
2. 숫자 외에 문자를 입력. ('-', '.', 등)
3. 당첨 번호와 중복된 숫자를 입력.

### 그 외

1. 티켓 금액이 0으로 설정되어 있을 때. (ArithmeticException 발생)
2. 수익의 합이 Integer 범위를 넘어설 수 있으니 Long 으로 변경.

---

# 프로젝트 구조

<table>
    <thead>
        <tr>
            <th>패키지</th>
            <th>클래스</th>
            <th>타입</th>
            <th>설명</th>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td rowspan="2">
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/config.svg?sanitize=true" />
                configuration</td>
            <td>Prize</td>
            <td>enum</td>
            <td>로또 당첨 등수와 상금을 정의하는 enum 클래스입니다. 각 등수에 대한 조건과 상금을 설정하여 비교 및 계산 시 사용됩니다.</td>
        </tr>
        <tr>
            <td>LottoConfiguration</td>
            <td>enum</td>
            <td>로또 애플리케이션의 전반적인 설정 값을 관리하는 클래스입니다. 로또 가격, 상수 등을 정의합니다.</td>
        </tr>
        <tr>
            <td rowspan="5">
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/db.svg?sanitize=true" />
                entity</td>
            <td>Lotto</td>
            <td>class</td>
            <td>로또 티켓을 나타내는 클래스입니다. 로또 번호를 관리하며, 생성 및 검증 로직을 포함합니다.</td>
        </tr>
        <tr>
            <td>PaymentAmount</td>
            <td>class</td>
            <td>사용자가 지불한 금액을 관리하는 클래스입니다. First class collection으로써 금액과 관련된 로직을 포함할 수 있습니다.</td>
        </tr>
        <tr>
            <td>WinningNumbers</td>
            <td>class</td>
            <td>우승 번호와 보너스 번호를 관리하는 클래스입니다. 로또 결과 계산에 사용됩니다.</td>
        </tr>
        <tr>
            <td>LottoMachine</td>
            <td>class</td>
            <td>로또 티켓 구매와 로직을 처리하는 클래스입니다. 랜덤 로또 생성 및 티켓 관리를 수행합니다.</td>
        </tr>
        <tr>
            <td>ProfitReport</td>
            <td>class</td>
            <td>구매한 로또들과 우승 번호를 비교하여 수익과 수익률을 계산하는 클래스입니다.</td>
        </tr>
        <tr>
            <td rowspan="3">
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/controllers.svg?sanitize=true" />
                controller</td>
            <td>LottoController</td>
            <td>class</td>
            <td>로또 애플리케이션의 흐름을 관리하는 컨트롤러 클래스입니다. 사용자 입력을 받고 서비스와 연결하여 로직을 처리합니다.</td>
        </tr>
        <tr>
            <td>InputParser</td>
            <td>class</td>
            <td>사용자 입력을 파싱하는 클래스입니다. 입력 데이터를 특정 형식으로 변환하고 검증하는 기능을 포함합니다.</td>
        </tr>
        <tr>
            <td>InputRetryUtil</td>
            <td>class</td>
            <td>입력 오류 시 재시도를 지원하는 유틸리티 클래스입니다. 사용자 입력을 반복해서 받을 때 사용됩니다.</td>
        </tr>
        <tr>
            <td>
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/api.svg?sanitize=true" />
                service</td>
            <td>LottoService</td>
            <td>class</td>
            <td>로또 로직을 수행하는 서비스 클래스입니다. 비즈니스 로직을 처리하며, 컨트롤러와 엔티티 간의 중재 역할을 합니다.</td>
        </tr>
         <tr>
            <td rowspan="3">
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/db.svg?sanitize=true" />
                dto
            <td>LottoControllerInputDto</td>
            <td>record</td>
            <td>사용자로부터 입력을 받는 클래스입니다. 콘솔을 통해 입력을 처리하고 반환합니다.</td>
        </tr>
         <tr>
            <td>PrizeCountEntry</td>
            <td>record</td>
            <td>사용자로부터 입력을 받는 클래스입니다. 콘솔을 통해 입력을 처리하고 반환합니다.</td>
        </tr>
         <tr>
            <td>ProfitStaticsDto</td>
            <td>record</td>
            <td>사용자로부터 입력을 받는 클래스입니다. 콘솔을 통해 입력을 처리하고 반환합니다.</td>
        </tr>
        <tr>
            <td rowspan="5">
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/views.svg?sanitize=true"/>
                view</td>
            <td>ConsoleInput</td>
            <td>class</td>
            <td>사용자로부터 입력을 받는 클래스입니다. 콘솔을 통해 입력을 처리하고 반환합니다.</td>
        </tr>
        <tr>
            <td>ConsoleOutput</td>
            <td>class</td>
            <td>콘솔에 출력을 담당하는 클래스입니다. 메시지를 출력하고 결과를 사용자에게 보여줍니다.</td>
        </tr>
        <tr>
            <td>ConsoleUtils</td>
            <td>class</td>
            <td>콘솔 출력을 지원하는 유틸리티 클래스입니다. 공통적인 출력 로직을 모아둔 클래스입니다.</td>
        </tr>
        <tr>
            <td>inputProvider.InputProvider</td>
            <td>interface</td>
            <td>입력 처리 인터페이스입니다. 다양한 입력 소스를 지원할 수 있는 구조를 제공합니다.</td>
        </tr>
        <tr>
            <td>inputProvider.ConsoleInputProvider</td>
            <td>class</td>
            <td>콘솔로부터 입력을 받는 구체적인 구현 클래스입니다. InputProvider를 구현하여 콘솔 입력을 처리합니다.</td>
        </tr>
        <tr>
            <td rowspan="5">
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/rules.svg?sanitize=true" />
                validator</td>
            <td>LottoValidator</td>
            <td>class</td>
            <td>로또 번호 검증을 수행하는 클래스입니다. 입력된 로또 번호의 유효성을 확인합니다.</td>
        </tr>
        <tr>
            <td>PaymentValidator</td>
            <td>class</td>
            <td>사용자의 지불 금액 검증을 수행하는 클래스입니다. 지불 금액의 유효성을 검사합니다.</td>
        </tr>
        <tr>
            <td>ProfitReportValidator</td>
            <td>class</td>
            <td>수익 보고서의 유효성을 검증하는 클래스입니다. 보고서 관련 입력의 유효성을 확인합니다.</td>
        </tr>
        <tr>
            <td>WinningNumbersValidator</td>
            <td>class</td>
            <td>우승 번호의 유효성을 검증하는 클래스입니다. 입력된 우승 번호와 보너스 번호의 유효성을 확인합니다.</td>
        </tr>
        <tr>
            <td>LottoMachineValidator</td>
            <td>class</td>
            <td>로또 머신에 대한 입력과 상태를 검증하는 클래스입니다. 로또 구매 시 입력의 유효성을 검사합니다.</td>
        </tr>
        <tr>
            <td rowspan="9">
                <img src="https://raw.githubusercontent.com/mallowigi/iconGenerator/master/assets/icons/folders/error.svg?sanitize=true" />
                exception</td>
            <td>ExceptionUtils</td>
            <td>class</td>
            <td>예외 처리를 돕는 유틸리티 클래스입니다. 예외 메시지와 관련된 기능을 제공합니다.</td>
        </tr>
        <tr>
            <td>ExceptionMessage</td>
            <td>interface</td>
            <td>예외 메시지를 관리하는 인터페이스입니다. 예외와 관련된 메시지를 일관성 있게 관리합니다.</td>
        </tr>
        <tr>
            <td>InputParserExceptionMessage</td>
            <td>enum</td>
            <td>입력 파싱과 관련된 예외 메시지를 정의하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>LottoConfigurationExceptionMessage</td>
            <td>enum</td>
            <td>로또 설정과 관련된 예외 메시지를 정의하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>LottoExceptionMessage</td>
            <td>enum</td>
            <td>로또 관련 예외 메시지를 정의하는 클래스입니다. 로또 로직과 관련된 예외 메시지를 관리합니다.</td>
        </tr>
        <tr>
            <td>ProfitReportExceptionMessage</td>
            <td>enum</td>
            <td>수익 보고서와 관련된 예외 메시지를 정의하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>PurchaseExceptionMessage</td>
            <td>enum</td>
            <td>구매와 관련된 예외 메시지를 정의하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>WinningNumbersExceptionMessage</td>
            <td>enum</td>
            <td>우승 번호 관련 예외 메시지를 정의하는 클래스입니다.</td>
        </tr>
        <tr>
            <td>DtoExceptionMessage</td>
            <td>enum</td>
            <td>DTO 에서 발생하는 예외 메시지를 정의하는 클래스입니다.</td>
        </tr>
    </tbody>
</table>
