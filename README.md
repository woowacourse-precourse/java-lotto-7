# java-lotto-precourse

### 1. Application.java
전체적인 기능의 Controller 클래스로서 흐름을 담당

### 2. Constant.java
클래스 내에서 사용되는 상수들을 정의

### 3. Generate.java
입력받은 로또 구입 금액(`cost`) 를 바탕으로 `Lotto<list>`를 반환

* `getLottoPaper` : 로또 구입 금액을 통해 몇 개 라인의 `subGame`을 수행 할 것인지 정한 뒤 해당 수 만큼의 `SubGame` 을 통합한 `List<Lotto>` 반환
* `getSubGame` : 한 줄의 로또를 생성한 뒤, 정렬해서 반환

### 4. Input.java
로또 구입 금액(`cost`), 당첨 번호(`winNumbers`), 보너스 번호(`bonusNumber`)를 입력받는 클래스. 잘못된 값이 입력되면 에러 메시지를 보내고 재입력 수행

* `InputParser` : 입력 `parser` 로직을 독립적으로 작성하기 위한 인터페이스
* `validateInput` : 반복문을 통해 정상적인 입력 값을 받아올 때까지 입력 반복
* `getCost` : 구입 금액(`cost`)을 입력받아 `parseCost`를 통해 parsing
* `getWinNumbers` : 당첨 번호(`winNumbers`)를 입력받아 `parseWinNumbers`를 통해 parsing
* `getBonusNumber` : 보너스 번호(`bonusNumber`)를 입력받아 `parseBonusNumber`를 통해 parsing
* `parseCost` : 입력받은 `String` 형식의 `cost`를 `Integer`으로 변환. 변환 과정에서 예외 처리 수행
* `parseWinNumbers` : 입력받은 `String` 형식의 `winNumbers`를 `List<Integer>`로 변환. 변환 과정에서 예외 처리 수행
* `parseBonusNumber` : 입력받은 `String` 형식의 `bonusNumber`를 `Integer`로 변환. 변환 과정에서 예외 처리 수행

### 5. Lotto.java
로또 한 줄(6자리 숫자)을 나타내는 클래스

* `validateSize` : 로또 번호가 6개의 숫자인지 확인
* `validateDuplicate` : 로또 번호에 중복이 있는지 확인
* `getNumbers` : 로또 번호 리스트를 반환
* `search` : 로또 번호 `6`개가 당첨번호와 몇개나 일치하는지, 보너스 번호와 일치하는지 찾고, 해당하는 등수의 `winnerCount`를 `1`만큼 증가

### 6. LottoEnum.java
로또 당첨자의 Rank 및 prize 정보를 저장 및 조회하기 위한 Enum 클래스
* `FIRST ~ NONE` : 당첨된 번호 개수(`matchCount`), 당첨 금액(`prize`) 그리고 당첨자수(`winnerCount`)를 저장
* `increaseWinnerCount` : `count`에 해당하는 당첨자수`winnerCount` 의 값을 `1` 증가
* `sum` : 당첨자들의 당첨 금액의 합계(`totalPrize`)를 계산

### 7. Lottos.java
Lotto 객체의 First Class Collection

* `searchAll` : n개의 SubGame 각각에서 `winNumber`(당첨번호)와 `bonus`(보너스번호)를 가지고 Search 수행

### 8. Output.java
실행 결과의 출력 구문을 담당하는 클래스

* `printLottoPaper` : 입력받은 로또 구입 금액(`cost`) 기준으로 생성된 `List<Lotto>` 출력
* `printWinningList` : forEach 문을 통한 `printLottoResult`을 호출. `수익률(수익 / 구입금액)`을 계산해서 출력
* `printLottoResult` : `matchCount`에 해당하는 당첨금액(`prize`)와 당첨자수(`winnerCount`)를 출력
* `formatDecimal` : 당첨금액(`prize`)와 수익률(`revenue`)의 출력 형식 변경

```
├─main
│  └─java
│      └─lotto
│              Application.java
│              Constant.java
│              Generate.java
│              Input.java
│              Lotto.java
│              LottoEnum.java
│              Lottos.java
│              Output.java
│
└─test
    └─java
        └─lotto
                ApplicationTest.java
                LottoTest.java
