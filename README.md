# java-lotto-precourse

간단한 로또 발매기 구현

# 도메인 정보

* 로또 번호의 숫자 범위는 1~45다.
* 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑느다.
* 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
* 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.

```
1등: 6개 번호 일치 / 2,000,000,000원
2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
3등: 5개 번호 일치 / 1,500,000원
4등: 4개 번호 일치 / 50,000원
5등: 3개 번호 일치 / 5,000원
```

* 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
* 로또 1장의 가격은 1,000원이다.

# 구현할 기능 목록

1. 로또 구입 금액을 입력 받는다.
    * 구입 금액은 1000 단위로 나누어 떨어져야 한다.
2. 발행한 로또 수량 및 번호를 출력한다.
    * 로또 번호는 오름차순으로 정렬하여 보여준다.
3. 당첨 번호를 입력 받는다.
    * 번호의 범위는 1~45여야 한다.
4. 보너스 번호를 입력 받는다.
    * 번호의 범위는 1~45여야 하고, 당첨 번호와 중복되지 않아야 한다.
5. 당첨 내역을 출력한다.
6. 수익률을 출력한다.
    * 수익률은 소수점 둘째 자리에서 반올림한다.

# 예외 발생 시

* 예외 상황 시 에러 문구를 출력해야 한다. 에러 문구는 `[ERROR]`로 시작해야 한다.

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

* 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    * Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
    * [+] 사용자 "입력"에 대한 예외 시에만 프로그램 실행을 유지한다. 도메인 로직 실행 중 발생하는 예외에 대해서는 요구사항에 따로 언급이 없으니 예외 메세지 출력 후 프로그램을 종료하도록 한다.

# 입출력 예시

## 예시1

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

## 예시2 (구입금액의 단위가 올바르지 않은 경우)

```
구입금액을 입력해 주세요.
50
[ERROR] 구입금액은 1000원 단위로 입력해주세요.
구입금액을 입력해 주세요.
```

-> `IllegalArgumentException` 예외 캐치 후 사용자에게 재입력 요청

## 예시3 (당첨번호 범위가 올바르지 않은 경우)

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
1,2,3,4,5,46
[ERROR] 로또 번호의 범위는 1~45여야 합니다.
당첨 번호를 입력해 주세요.

```

-> `IllegalArgumentException` 에러 캐치 후 사용자에게 재입력 요청

# 중요한 프로그래밍 요구 사항

* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
* 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* else 예약어를 쓰지 않는다.
    * else를 쓰지 말라고 하니 switch/case로 구현하는 경우가 있는데 switch/case도 허용하지 않는다.
    * 힌트: if 조건절에서 값을 return하는 방식으로 구현하면 else를 사용하지 않아도 된다.
* Java Enum을 적용하여 프로그램을 구현한다.
* 구현한 기능에 대한 단위 테스트를 작성한다. 단, UI(System.out, System.in, Scanner) 로직은 제외한다.
* 단위 테스트 작성이 익숙하지 않다면 LottoTest를 참고하여 학습한 후 테스트를 작성한다.