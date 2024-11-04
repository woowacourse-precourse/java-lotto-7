## Program Documents


---

- [x] 사용자의 입출력을 보여준다.
- [x] 올바른 금액의 단위인지 확인한다. 
- [x] 수악률을 계산 한다.
- [x] 당첨 통계를 보여준다.

---

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



1. 정상적으로 코드를 통과 하는 경우

    private String readUserInput() {
        return Console.readLine();
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


