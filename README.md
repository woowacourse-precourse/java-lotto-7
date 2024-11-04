# java-lotto-precourse
해당 프로젝트는 간단한 로또 발매기 구현을 목적으로 한다.<br>
이 프로그램은 로또를 구매한 후, 당첨 번호 및 보너스 번호를 입력받아 당첨 통계를 출력하여야 한다.

<br>

## Commit Message Convention
[해당 문서 참고](./Docs/commit.md)

<br>

## Requirements
[해당 문서 참고](./Docs/requirement.md)

<br>

## 프로젝트 진행 목표
프로젝트를 진행하면서 다음과 같은 목표를 이루고자 한다.<br>
1. TDD 적용하기
2. SOLID 원칙 유의하며 개발하기
3. ~~Custom Exception 적용하기~~ Enum으로 대체
4. Enum 활용하기
5. 개발일지 작성하기

<br>

## 구현 기능 목록 및 설명
클래스 단위로 구현한 메서드와 메서드에 대한 설명을 작성하였다.

### Application Class

| Method Name | Parameters | return Type | description |
| --- | --- | --- | --- |
| [```executeUntilNoException```](./src/main/java/lotto/Application.java#L30) | ```Supplier<Void>``` | ```void``` | 메서드를 매개변수로 받아 해당 메서드가 예외를 반환하지 않을 때까지 반복수행합니다. |
| [```setLottos```](./src/main/java/lotto/Application.java#L41) | (none) | ```java.lang.Void``` | 사용자에게 구입 금액을 입력받은 후, 입력된 문자열을 매개변수로 ```issueLottos``` 메서드를 실행합니다. |
| [```issueLottos```](./src/main/java/lotto/Application.java#L47) | ```String``` | ```void``` | 입력받은 금액을 통해 로또를 발행합니다. |
| [```printIssueLottos```](./src/main/java/lotto/Application.java#L60) | (none) | ```void``` | 발행받은 로또의 개수와 각 로또의 번호를 출력합니다. |
| [```setWinningLotto```](./src/main/java/lotto/Application.java#L72) | (none) | ```java.lang.Void``` | 사용자에게 당첨 번호 문자열을 입력받습니다.<br>입력받은 문자열을 매개변수로 LottoService의 ```setWinningLotto```를 실행시킵니다. |
| [```setBonusNumber```](./src/main/java/lotto/Application.java#L78) | (none) | ```java.lang.Void``` | 보너스 번호를 입력받은 후, ```checkBonusNumber``` 메서드를 실행시킵니다.<br>이후, 보너스 번호를 세팅합니다. |
| [```checkBonusNumber```](./src/main/java/lotto/Application.java#L86) | ```String``` | ```void``` | 입력받은 보너스 번호 문자열이 유효한지 체크합니다.<br>유효하지 않은 경우 Exception을 발생시킵니다. |
| [```printLottoResult```](./src/main/java/lotto/Application.java#L100) | ```int[]```  | ```void``` | 당첨 결과를 int[]로 받아 로또의 당첨 결과를 출력합니다. |
| [```setResult```](./src/main/java/lotto/Application.java#L112) | ```int[]```<br>```StringBuilder``` | ```void``` | 당첨 결과를 int[]로 받아 로또 당첨 결과의 상세 정보를 매개변수인 StringBuilder에 append합니다. |
| [```setPrintLottoRanks```](./src/main/java/lotto/Application.java#L128) | (none) | ```List<LottoRank>``` | ```setResult```에서 활용하고자 LottoRank의 리스트를 역순한 결과를 반환합니다. |
| [```setPrizeString```](./src/main/java/lotto/Application.java#L135) | ```int```  | ```String``` | 입력받은 값에 수의 구분자를 추가한 결과 문자열을 반환합니다.<br>ex) 100000 → 100,000 |
| [```printIncomePercent```](./src/main/java/lotto/Application.java#L149) | ```int[]``` | ```void``` | 당첨 결과를 int[]로 받아 총 수익률의 결과를 화면에 출력합니다. |

<br><br>

### LottoService

| Method Name | Parameters | return Type | description |
| --- | --- | --- | --- |
| [```getLottoCost```](./src/main/java/lotto/service/LottoService.java#L19) | (none) | ```int``` | 로또의 구입 금액 단위를 반환합니다. |
| [```issueLottoCount```](./src/main/java/lotto/service/LottoService.java#L23) | ```int``` | ```int``` | 구입 금액을 입력 받아<br>발행 가능한 로또 개수를 반환합니다. |
| [```issueLotto```](./src/main/java/lotto/service/LottoService.java#L35) | ```int``` | ```List<Lotto>``` | 구입 금액을 입력 받아<br>발행 가능한 로또의 개수만큼 자동으로 로또를 발행합니다. |
| [```generateRandomLotto```](./src/main/java/lotto/service/LottoService.java#L46) | (none) | ```Lotto``` | 랜덤한 수 6개를 선정하여 로또를 발행합니다. |
| [```setWinningLotto```](./src/main/java/lotto/service/LottoService.java#L54) | ```String``` | ```Lotto``` | 사용자의 당첨 번호 문자열을 입력 받아 1등 로또를 반환합니다. |
| [```getNumbers```](./src/main/java/lotto/service/LottoService.java#L58) | ```String``` | ```List<Integer>``` | 사용자의 당첨 번호 문자열을 구분하여 리스트로 결과를 반환합니다. |
| [```convertStringToNumber```](./src/main/java/lotto/service/LottoService.java#L75) | ```String``` | ```int``` | 문자열을 수로 변환하여 로또 번호에 적합한 지를 판단한 후 수를 반환합니다. |
| [```getWinningCost```](./src/main/java/lotto/service/LottoService.java#L87) | ```int[]``` | ```long``` | 당첨 결과를 입력받아 총 상금을 반환합니다. |
| [```getWinningCount```](./src/main/java/lotto/service/LottoService.java#L96) | ```List<Lotto>```<br>```Lotto```<br>```int``` | ```int[]``` | 발행한 로또 리스트와 당첨 번호, 보너스 번호를 순으로 매개변수로 받습니다.<br>매개변수들을 활용하여 당첨 결과를 ```int[]```로 반환합니다. |
| [```getLottoRank```](./src/main/java/lotto/service/LottoService.java#L107) | ```Lotto```<br>```Lotto```<br>```int``` | ```LottoRank``` | 확인하고자 하는 로또, 당첨 번호, 보너스 번호를 순으로 매개변수를 받습니다.<br>일치하는 번호의 개수와 보너스 번호 일치 여부를 판단하여 ```getLottoRank(int matchCount, boolean existBonusNumber)```를 통해 결과를 반환합니다. |
| [```getLottoRank```](./src/main/java/lotto/service/LottoService.java#L113) | ```int```<br>```boolean``` | ```LottoRank``` | 일치하는 번호의 개수와 보너스 번호 일치 여부를 순으로 매개변수를 받습니다.<br>로또 결과를 반환합니다. |
