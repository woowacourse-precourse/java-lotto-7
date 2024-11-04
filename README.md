# java-lotto-precourse
### 학습 목표

1. 이전 프리코스에서 제출했던 코드를 리펙토링 한다.
2. Java 의 System 라이브러리를 활용한다.
3. 멀티 태스킹과 멀티 스레드를 학습 후 적용한다.

---

멀티 스레드를 활용한 로또 결과 통계 반환

- [x] 스레드 풀을 만든다.
  - cpu core 의 수를 읽어온다.

IO bound Task
- [x] 입출력 시스템의 스레드를 적용한다.
  - 사용자의 입력과 시스템의 출력을 같은 메시지로 사용시 정상적으로 작동하지 않은 것을 확인했다.
  - 입력 시스템 inputTask 를 통한 사용자 요청 처리시
    - 로또 8장을 구매하는 테스트 케이스는 통과
    - 예외 테스트 케이스 1s 를 통과하지 못하는 상황이 발생


CPU bound Task
- [x] 로또 티켓 결과 계산시 스레드 풀을 활용한다.
  - 스레드 별로 로또의 결과를 계산한다.

----

### 예외 테스트 케이스 1s 를 통과하지 못하는 상황

```

문제의 테스트 

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("1000j");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

-> protected final void runException(final String... args) {
        try {
            run(args);
        } catch (final NoSuchElementException ignore) {
        }
    }



1. 정상적으로 코드를 통과 하는 경우

    private String readUserInput() {
        return Console.readLine(); // ignore NoSuchElementException at test
    }

    public Integer getMoney() {
        String given = readUserInput();
        try {
            int givenMoney = checkNumber(given);
            Money.checkMoney(givenMoney);
            return givenMoney;
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return getMoney();
        }
    }

2. 코드를 통과 x 하는 경우

     private String readUserInput() {
        try{
            return messageBlockingQueue.take().getContent(); // BlockingQueue<Message>
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public Integer getMoney() {
        String given = readUserInput();
        try {
            int givenMoney = checkNumber(given);
            Money.checkMoney(givenMoney);
            return givenMoney;
        } catch (IllegalArgumentException e) {
            outputView.showErrorMessage(e);
            return getMoney();
        }
    }
  
```

##### 원인


###### console.readline() 이 사용자 대기를 받는 상황에서 통과 되는 이유

Console.readLine() 의 경우 동기적으로 입력 가능.

Console.readLine()이 입력을 기다리며 대기, 테스트 환경에서는 타임아웃 전에 입력을 제공 받아서 예외 처리.

다시 입력을 받을 수 있는 상태라 테스트가 정상적으로 종료


###### BlockingQueue 이 사용자 대기를 받는 상황에서 통과 되지 못 하는 이유

BlockingQueue를 통해 입력을 받을 때는 큐가 비어 있으면 계속 블로킹 상태가 유지됨
다시 입력을 받을 수 없는 상태라 테스트가 비 정상적으로 종료

----

## 로또 게임 프로그램

로또 게임 기능을 구현한 프로그램이다.

로또 게임은 아래와 같은 규칙으로 진행된다.

```
- 로또 번호의 숫자 범위는 1~45까지이다.
- 1개의 로또를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- 당첨 번호 추첨 시 중복되지 않는 숫자 6개와 보너스 번호 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. 당첨 기준과 금액은 아래와 같다.
    - 1등: 6개 번호 일치 / 2,000,000,000원
    - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
    - 3등: 5개 번호 일치 / 1,500,000원
    - 4등: 4개 번호 일치 / 50,000원
    - 5등: 3개 번호 일치 / 5,000원
```

- 로또 구입 금액을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- 당첨 번호와 보너스 번호를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
    - Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.

---
### 로또 게임 실행 가이드

### 입출력

#### 입력

- 로또 구입 금액을 입력 받는다. 구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외가 출력이 된다.

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

#### 출력

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

- 예외 상황 시 에러 문구 "[ERROR]"로 시작 하는 메시지가 출력이 된다.

```
[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다.
```

#### 실행 결과 예시

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