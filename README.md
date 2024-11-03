
# java-lotto-precourse

# :sparkles: 목차
- [:tada: 프로젝트 설명](#tada-프로젝트-설명)
- [:books: 학습 목표](#books-학습-목표)
- [:round_pushpin: 기능 요구 사항](#round_pushpin-기능-요구-사항)
- [:bulb: 기능 목록](#bulb-기능-목록)
- [:keyboard: 입출력 요구 사항](#keyboard-입출력-요구-사항)
- [:bookmark_tabs: 프로그래밍 요구 사항 1](#bookmark_tabs-프로그래밍-요구-사항-1)
- [:bookmark_tabs: 프로그래밍 요구 사항 2](#bookmark_tabs-프로그래밍-요구-사항-2)
- [:bookmark_tabs: 프로그래밍 요구 사항 3](#bookmark_tabs-프로그래밍-요구-사항-3)

---  
# :tada: 프로젝트 설명
- 우아한테크코스 웹 백엔드 7기 프리코스 3주 차 과제
- 간단한 로또 발매기를 구현한다.
- 사용자로부터 `로또 구입 금액`, `로또 당첨 번호`, `로또 당첨 보너스 번호`를 입력받아, 로또 구입 금액만큼 랜덤으로 로또를 발행하여 당첨 내역 및 수익률을 출력하는 프로그램이다.

---  
# :books: 학습 목표
- 관련 함수를 묶어 클래스를 만들고, 객체들이 협력하여 하나의 큰 기능을 수행하도록 한다.
- 클래스와 함수에 대한 단위 테스트를 통해 의도한 대로 정확하게 작동하는 영역을 확보한다.

---  
# :round_pushpin: 기능 요구 사항
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - `Exception`이 아닌 `IllegalArgumentException`, `IllegalStateException` 등과 같은 명확한 유형을 처리한다.

---
# :bulb: 기능 목록
1. **로또 구입 금액을 입력받는다.**
   - 1,000원 단위의 숫자만 입력받는다.
   - 최소 1,000원부터 최대 100,000원까지 입력할 수 있다.
   - 입력에 있는 공백은 제거한다.
   - 입력이 비었으면 예외 처리한다.
   - 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외 처리한다.
   - 1000 ~ 100000의 사이의 정수가 아니면 예외 처리한다.
   - 입력이 숫자가 아니면 예외 처리한다.
2. **로또 구입 횟수만큼 로또를 발행한다.**
   - 로또 1장의 가격은 1,000원이다. 즉, 로또 구입 횟수는 로또 구입 금액을 1,000으로 나눈 숫자이다.
   - 각 로또마다 1~45에서 중복되지 않는 6개의 숫자를 랜덤으로 뽑는다.
   - 발행한 로또의 개수를 출력한다.
   - 발행한 로또들의 번호를 대괄호([])안에 쉼표(,)로 구분하여 오름차순으로 출력한다.
3. **당첨 번호를 입력받는다.**
   - 쉼표(,)로 구분한 1~45 사이의 중복되지 않은 6개의 숫자를 입력받는다.
   - 입력에 있는 공백은 제거한다.
   - 입력이 비었으면 예외 처리한다.
   - 쉼표(,)로 구분한 숫자가 6개가 아니면 예외 처리한다.
   - 쉼표(,) 사이에 숫자가 없으면 예외 처리한다.
   - 1~45 사이의 숫자가 아니면 예외 처리한다.
   - 숫자가 중복되면 예외 처리한다.
   - 입력이 정수가 아니면 예외 처리한다.
4. **보너스 번호를 입력받는다.**
   - 3번에서 입력한 당첨 번호에 있는 숫자와 중복되지 않는 1~45 사이의 1개의 숫자를 입력받는다.
   - 입력에 있는 공백은 제거한다. 단, 두 자리 숫자 사이에 공백을 입력하면 숫자 2개를 입력한 것으로 간주하여 예외 처리한다.
   - 입력이 비었으면 예외 처리한다.
   - 숫자가 1개가 아니면 예외 처리한다.
   - 1~45 사이의 숫자가 아니면 예외 처리한다.
   - 3번에서 입력한 당첨 번호와 중복되면 예외 처리한다.
   - 입력이 정수가 아니면 예외 처리한다.
5. **당첨 여부를 확인한다.**
   - 2번에서 발행한 각 로또마다 당첨 여부를 확인한다.
6. **당첨 내역 및 수익률을 출력한다.**
   - 5등부터 1등까지 각 등수별 당첨 개수를 출력한다.
   - 총 수익률을 소수점 둘째자리에서 반올림하여 출력한다.
7. **예외 상황 시 "[ERROR]"로 시작하는 에러 문구를 출력한 후 그 부분부터 입력을 다시 받는다.**

## 예외 처리 예시
사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.

### 구입 금액 예외 처리
- 입력이 비었으면 예외 처리한다.

**입력**
```

```
**출력**
```
[ERROR] 구입 금액을 입력해주세요. 구입 금액은 최소 1,000원에서 최대 100,000원입니다.
```
&nbsp;
- 1000 ~ 100000의 사이의 정수가 아니면 예외 처리한다.
 
**입력**
```
500
999999
```
**출력**
```
[ERROR] 구입 금액은 최소 1,000원에서 최대 100,000원입니다.
```
&nbsp;
- 구입 금액이 1,000원으로 나누어 떨어지지 않으면 예외 처리한다.
- 입력이 숫자가 아니면 예외 처리한다.

**입력**
```
1234
1000.0
1000원
```
**출력**
```
[ERROR] 1000으로 나누어떨어지는 정수만 입력해주세요.
```
&nbsp;
### 당첨 번호 예외 처리
- 입력이 비었으면 예외 처리한다.

**입력**
```

,
```
**출력**
```
[ERROR] 당첨 번호를 입력해주세요. 당첨 번호는 1부터 45 사이의 중복되지 않는 6개의 숫자입니다.
```
&nbsp;
- 쉼표(,)로 구분한 숫자가 6개가 아니면 예외 처리한다.
- 쉼표(,) 사이에 숫자가 없으면 예외 처리한다.

**입력**
```
1 2 3 4 5 6
1, 2, 3, 4, 5
,2,3,,9,15,22,45,
```
**출력**
```
[ERROR] 당첨 번호는 쉼표로 구분한 6개의 숫자여야 합니다. 올바른 형식으로 입력해주세요.
```
&nbsp;
- 1~45 사이의 숫자가 아니면 예외 처리한다.

**입력**
```
1,2,3,4,5,100
```
**출력**
```
[ERROR] 당첨 번호는 1부터 45 사이의 숫자여야 합니다.
```
&nbsp;
- 숫자가 중복되면 예외 처리한다.

**입력**
```
1,1,2,3,4,5
```
**출력**
```
[ERROR] 당첨 번호는 중복될 수 없습니다.
```
&nbsp;
- 입력이 정수가 아니면 예외 처리한다.

**입력**
```
1.0, 2.0, 3.0, 4.0, 5.0, 6.0
일,이,삼,사,오,육
1,2,3,4,5,6번
```
**출력**
```
[ERROR] 당첨 번호는 정수로 입력해주세요.
```
&nbsp;
### 보너스 번호 예외 처리
- 입력이 비었으면 예외 처리한다.

**입력**
```

```
**출력**
```
[ERROR] 보너스 번호를 입력해주세요. 보너스 번호는 당첨 번호와 중복되지 않는 1부터 45 사이의 숫자입니다.
```
&nbsp;
- 숫자가 1개가 아니면 예외 처리한다.

**입력**
```
3 9
10, 39
```
**출력**
```
[ERROR] 보너스 번호는 1개여야 합니다.
```
&nbsp;
- 1~45 사이의 숫자가 아니면 예외 처리한다.

**입력**
```
100
```
**출력**
```
[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다.
```
&nbsp;
- 당첨 번호와 중복되면 예외 처리한다.

**입력**
```
1
```
**출력**
```
[ERROR] 보너스 번호는 당첨 번호와 중복될 수 없습니다.
```
&nbsp;
- 입력이 정수가 아니면 예외 처리한다.

**입력**
```
40.0
사십
40번
```
**출력**
```
[ERROR] 보너스 번호는 정수로 입력해주세요.
```

---  
# :keyboard: 입출력 요구 사항
## 입력
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.
```  
14000  
```  
- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
```  
1,2,3,4,5,6  
```  
- 보너스 번호를 입력 받는다.
```  
7  
```  
## 출력
- 발행한 로또 수량 및 번호를 출력한다. 로또 번호는 오름차순으로 정렬하여 보여준다.
```  
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
```  
3개 일치 (5,000원) - 1개  
4개 일치 (50,000원) - 0개  
5개 일치 (1,500,000원) - 0개  
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개  
6개 일치 (2,000,000,000원) - 0개  
```  
- 수익률은 소수점 둘째 자리에서 반올림한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
```  
총 수익률은 62.5%입니다.  
```  
- 예외 상황 시 에러 문구를 출력해야 한다. 단, 에러 문구는 "[ERROR]"로 시작해야 한다.
```  
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.  
```  
## 실행 결과 예시
```  
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
# :bookmark_tabs: 프로그래밍 요구 사항 1
- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.

---  
# :bookmark_tabs: 프로그래밍 요구 사항 2
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.

---  
# :bookmark_tabs: 프로그래밍 요구 사항 3
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
    - 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- else 예약어를 쓰지 않는다.
    - switch/case도 허용하지 않는다.
    - 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
- Java Enum을 적용하여 프로그램을 구현한다.
- 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
    - 단위 테스트 작성이 익숙하지 않다면 `LottoTest`를 참고하여 학습한 후 테스트를 작성한다.

## 라이브러리
- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
### 사용 예시
- 1에서 45 사이의 중복되지 않은 정수 6개 반환
```  
Randoms.pickUniqueNumbersInRange(1, 45, 6);  
```  

## Lotto 클래스
- 제공된 `Lotto` 클래스를 사용하여 구현해야 한다.
- `Lotto`에 `numbers` 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- `numbers`의 접근 제어자인 `private`은 변경할 수 없다.
- `Lotto`의 패키지를 변경할 수 있다.
```  
public class Lotto {  
 private final List<Integer> numbers;  
 public Lotto(List<Integer> numbers) { validate(numbers); this.numbers = numbers; }  
 private void validate(List<Integer> numbers) { if (numbers.size() != 6) { throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");  
 } }  
 // TODO: 추가 기능 구현  
}  
```