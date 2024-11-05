# java-lotto-precourse
---------------------------------------------

## 기능 요구 사항
-------------------------
간단한 로또 발매기를 구현한다.

**비즈니스 로직**
* 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 1장의 가격은 1,000원이다.

인터페이스
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

## 입출력 요구 사항
---------------------------------
#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

```undefined
14000
```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.

```apache
1,2,3,4,5,6
```

- 보너스 번호를 입력 받는다.

```undefined
7
```

#### 출력

- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.

```prolog
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

- 당첨 내역을 출력한다.

```apache
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
```

- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)

```erlang-repl
총 수익률은 62.5%입니다.
```

- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.

```prolog
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

#### 실행 결과 예시

```prolog
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

## 프로그래밍 요구사항
--------------
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
	* 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* else 예약어를 쓰지 않는다.
    - else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 `LottoTest`를 참고하여 학습한 후 테스트를 작성한다.

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

- 1에서 45 사이의 중복되지 않은 정수 6개 반환

```java
Randoms.pickUniqueNumbersInRange(1, 45, 6);
```

### Lotto 클래스

- 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
- `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- `Lotto`의 패키지를 변경할 수 있다.

```java
public class Lotto {
    private final List<Integer> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers;
    }

    private void validate(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
        }
    }

    // TODO: 추가 기능 구현
}
```

## 기능 분석
-------------------
- [x] 구입 금액을 입력받는다.
	- [x] 입력한 금액에 대해 validation을 진행한다.
		- [x] 1000원 단위로 입력했는지 검증한다.
- [x] 구입한 금액에 맞는 로또 갯수를 계산한다.
- [x] 발행한 로또 수량을 출력한다.
- [x] 로또 개수 만큼 로또를 생성한다.
	- [x] 로또를 생성할 때 무작위로 6개의 숫자를 생성하여 저장한다.
		- [x] 기존에 존재하는 숫자와 중복되지 않는지 검사해야 한다.
- [x] 로또의 번호를 모두 출력한다.
	- [x] 오름차순으로 정렬하여 출력한다.
- [x] 당첨 번호를 입력받는다.
	- [x] 입력한 당첨 번호에 대해 validation을 진행한다.
		- [x] 입력한 로또의 개수가 6개가 맞는지 검증한다.
		- [x] 입력한 숫자의 범위가 1~45인지 확인한다.
- [x] 보너스 번호를 입력받는다
	- [x] 입력한 보너스 번호에 대해 validation을 진행한다.
		- [x] 입력한 숫자의 범위가 1~45인지 확인한다.
- [x] 당첨 내역을 출력한다.
	- [x] 3개 ~ 6개 일치하는 로또의 개수, 당첨 금액을 출력해준다.
- [x] 수익률을 출력한다.

## 도메인 분석
---------------------
### 로또
- 로또의 숫자가 주어진 범위 내에 있는지 관리해야 한다.
- 로또로 입력받은 수가 6개인지 확인해야 한다.
- 로또의 숫자를 오름차순으로 관리해야 한다.
- 로또에 포함되어 있는 숫자를 리스트로 반환할 수 있다.
### 당첨 번호
* 당첨번호로 입력받은 수가 6개인지 확인해야 한다.
* 숫자가 주어진 범위 내에 있는지 관리해야 한다.
* 어떤 숫자가 주어졌을 때 당첨 번호에 존재하는지 판단합니다.
### 보너스 번호
- 숫자가 주어진 범위 내에 있는지 관리해야 한다.
- 어떤 숫자가 주어졌을 때 보너스 번호와 일치하는지 판단합니다.
### 로또 랭크
- 당첨(Price) 정보를 리스트로 담고 있는 열거형입니다.
### 로또 생성기
- 무작위로 6개의 숫자를 생성합니다.
- 무작위로 생성된 로또 번호 리스트를 반환합니다.
------------------------
## DTO
------------
### LottoDto
- 사용자에게 무작위로 생성된 로또 번호를 전달하기 위한 Dto




----------
## Architecture
----------------------------------------------
### Service Layer
- 사용자가 입력한 금액이 올바른지 검사한다.
- 사용자가 입력한 금액에 맞게 로또 개수를 계산한다.
- 로또 개수만큼 로또 생성기에서 로또를 생성하고 받아와서 저장한다.
- 로또를 Dto로 변환하여 컨트롤러에 전달합니다.
- 당첨 번호를 저장합니다.
- 보너스 번호를 저장합니다.
- 각 로또별로 몇 개의 숫자가 일치하는지 파악합니다.
- 당첨 리스트 클래스에 당첨 정보를 알려주고, 통ㅑㅜ계 정보를 위한 DTO로 변환합니다.


### Controller Layer
- 사용자에게 금액을 입력받습니다.
	- 금액이 음수인지, 혹은 범위를 넘어서는지 체크합니다.
- 사용자에게 발행한 로또 수량을 출력합니다.
- 로또 번호를 모두 출력합니다.
- 사용자에게 당첨 번호를 입력받습니다.
- 사용자에게 보너스 번호를 입력받습니다.
- 당첨 통계를 출력합니다.
	- 일치하는 숫자 개수별로 금액과 로또 개수를 출력합니다.
	- 총 수익률을 출력합니다.

### Repository Layer - 로또
- 입력받은 로또를 저장합니다.
- 입력받은 로또를 조회합니다.
