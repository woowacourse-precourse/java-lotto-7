# java-lotto-precourse

1. Application.java - 전체적인 기능의 Controller 클래스로서 흐름을 담당


2. Generate.java - 입력받은 로또 구입금액을 바탕으로 lottoPaper List 를 생성  


3. Lottos.java - Lotto 객체의 First Class Collection


4. Lotto.java - 로또 한 줄(6자리 숫자)을 나타내는 클래스


5. Input.java - 로또 구입 금액, 당첨 번호, 보너스 번호를 입력받는 클래스


6. Output.java - 실행 결과의 출력 구문을 담당하는 클래스


```
├─main
│  └─java
│      └─lotto
│              Application.java
│              Generate.java
│              Input.java
│              Lotto.java
│              Lottos.java
│              Output.java
│
└─test
    └─java
        └─lotto
                ApplicationTest.java
                LottoTest.java
