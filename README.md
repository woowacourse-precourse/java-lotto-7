# java-lotto-precourse

## 기능 요구 사항
간단한 로또 발매기를 구현한다.

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
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.  
  - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.  

### 입출력 요구 사항
_입력_
- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다  
```14000```

- 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.  
```1,2,3,4,5,6```

- 보너스 번호를 입력 받는다.  
```7```

_출력_
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
---
### 프로그래밍 요구 사항

1. indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.

2. 예를 들어 `while`문 안에 `if`문이 있으면 들여쓰기는 2이다.   
   힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.

3. 3항 연산자를 쓰지 않는다.

4. 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.

5. `JUnit 5`와 `AssertJ`를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.  
   테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.

6. 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.  
함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.

7. else 예약어를 쓰지 않는다.  
   else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.  
   힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.

8. Java Enum을 적용하여 프로그램을 구현한다.  
   구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.  
   단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.

---

### 주어진 클래스 

- 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- numbers의 접근 제어자인 private은 변경할 수 없다.
- Lotto의 패키지를 변경할 수 있다. 

```
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
---
### 커밋 메시지 규칙

`<type>(<scope>): <subject>`

`<type>`: 커밋의 종류

```
    - feat: 새로운 기능
    - fix: 버그 수정
    - docs: 문서 변경
    - style: 코드 형식 수정 (공백, 세미콜론 등)
    - refactor: 리팩토링 (기능 변경 없음)
    - test: 테스트 추가 또는 수정
    - chore: 기타 작업 (빌드, 도구 설정 등)
```

`<scope>`: 변경이 발생한 파일이나 기능의 범위

`<subject>`: 간결한 설명을 현재 시제로 작성, 첫 글자는 소문자로 시작하고, 끝에 점을 찍지 않는다.

---

## 기능 구현 목록

_Implementing functionality in a bottom-up approach_

0. [x] 입력 기능 모듈 구현 
   - [ ] 예외 처리 : 숫자가 아닌 문자를 입력한 경우   
   - [ ] 예외 처리 : Null 값인 경우   
1. [ ] 입력 검증 모듈 구현
   - [ ] 예외 처리 : 구입 금액이 1,000원 단위가 아닌 경우 
   - [ ] 예외 처리 : 당첨 번호가 6개가 아닌 경우 
   - [ ] 예외 처리 : 각 당첨 번호가 0~45가 아닌 경우 
   - [ ] 예외 처리 : 보너스 번호가 0~45가 아닌 경우 
   
2.[ ] 1개의 로또만 구매 가정 후 로또 번호 생성 모듈 구현 
3.[ ] 1개의 로또만 구매 가정 후 당첨 통계 모듈 구현
4.[ ] n개의 로또만 구매시, 로또 번호 생성 모듈 구현
5.[ ] n개의 로또만 구매시, 당첨 통계 모듈 구현
5. [ ] 
6. [ ]  
