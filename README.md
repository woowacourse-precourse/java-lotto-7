## 🎰 java-lotto 🎰

---

## 📚  목차

1. 📔  [패키지 구조](#-패키지-구조)
2. 🗺 [프로그램 플로우 및 구현 기능](#-프로그램-플로우-및-구현-기능)
3. ❓  [테스트 목록](#-테스트-목록)
4. 🔍 [고민했던 요소](#-고민했던-요소)
5. ⭐ [설계 시 주요 포인트](#-설계-시-주요-포인트)


---

## 📔 패키지 구조

<div align="center">
<table>
<tr>
<th align="center">Package</th>
<th align="center">Class</th>
<th align="center">Description</th>
</tr>

<tr>
<td rowspan="3"><b>⚙️  config</b></td>
<td><b> AppConfig</b></td>
<td>  애플리케이션의 전반적인 설정과 의존성 주입을 관리하는 구성 클래스 </td>
</tr>

<tr>
<td><b> DtoMapperConfig</b></td>
<td> DTO 변환을 위한 매퍼 설정을 정의하는 구성 클래스 </td>
</tr>

<tr>
<td><b> ValidatorConfig</b></td>
<td>입력 검증 로직을 위한 유효성 검사기 설정을 제공하는 구성 클래스 </td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="2"><b> 🔢️  constants</b></td>
<td><b> LottoRank </b></td>
<td>  로또 당첨 조건, 당첨 금액 등의 상수를 보관하는 enum 클래스 </td>
</tr>

<tr>
<td><b> LottoTicket </b></td>
<td> 로또 번호의 범위, 하나의 로또 티켓의 번호 갯수 등 로또 티켓 하나의 정보를 가지는 enum 클래스  </td>
</tr>


<tr><td colspan="3"></td></tr>



<tr>
<td><b>🕹&nbsp;&nbsp;controller</b></td>
<td><b> LottoGameController </b></td>
<td> 로또 로직을 메인으로 동작하는 컨트롤러 클래스 </td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="10"><b>💻  domain</b></td>
<td><b> MatchResult</b></td>
<td> winningLotto와 로또 한 장을 비교한 결과를 저장하는 클래스</td>
</tr>

<tr>
<td><b> MatchResults</b></td>
<td> MatchResult 객체 리스트를 가지는 일급 컬렉션 </td>
</tr>

<tr>
<td><b> RankDecider </b></td>
<td> MatchResult를 보고 등수를 결정하는 기능의 클래스 </td>
</tr>

<tr>
<td><b> WinningLotto</b></td>
<td> 당첨 번호와 보너스 번호 정보 및 관련 메서드가 있는 클래스 </td>
</tr>

<tr>
<td><b> DefaultLottoFactory</b></td>
<td> LottoFactory의 구현체 </td>
</tr>

<tr>
<td><b> Lotto</b></td>
<td> 로또 한 장의 번호 정보를 가지고 있는 클래스  </td>
</tr>

<tr>
<td><b> LottoFactory</b></td>
<td> Lotto 객체 생성 Factory Interface </td>
</tr>

<tr>
<td><b> LottoNumbersGenerator</b></td>
<td> 임의의 로또 번호를 생성하는 NumberGenerator의 구현체 </td>
</tr>

<tr>
<td><b> Lottos</b></td>
<td> Lotto 객체 리스트를 갖는 일급 컬렉션 </td>
</tr>

<tr>
<td><b> NumberGenerator</b></td>
<td> 임의의 숫자를 생성하는 기능의 Interface </td>
</tr>


<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="5"><b>✉️&nbsp;&nbsp;dto</b></td>
<td><b> FinalResultsDto</b></td>
<td> 라운드 별 모든 자동차의 이름 및 위치 정보를 리턴하는 DTO 레코드 </td>
</tr>


<tr>
<td><b> LottoDto </b></td>
<td> 로또 한 장의 번호 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr>
<td><b> LottosDto</b></td>
<td> 로또들의 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr>
<td><b> ProfitDto</b></td>
<td> 수익과 수익률을 리턴하는 DTO 레코드 </td>
</tr>


<tr>
<td><b> RankResultsDto </b></td>
<td> 등수 관련 정보를 리턴하는 DTO 레코드</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="1"><b>🚫&nbsp;&nbsp;exception</b></td>
<td><b> ErrorMessage </b></td>
<td> 예외 발생 시 사용되는 에러 메세지 Enum 클래스</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="7"><b>💼&nbsp;&nbsp;service</b></td>
<td><b> DtoMapper  </b></td>
<td> DTO의 Mapper 담당 Interface</td>
</tr>

<tr>
<td><b> LottoDtoMapper  </b></td>
<td> LottoDto 생성  Mapper 클래서</td>
</tr>

<tr>
<td><b> LottosDtoMapper  </b></td>
<td> LottosDto 생성 Mapper 클래스 </td>
</tr>

<tr>
<td><b> LottoPurchaseService  </b></td>
<td> 발행한 로또와 당첨번호를 비교하여 결과값 산출하는 Interface </td>
</tr>


<tr>
<td><b> LottoPurchaseServiceImpl  </b></td>
<td> LottoPurchaseService의 구현체 </td>
</tr>

<tr>
<td><b> LottoResultService  </b></td>
<td> 입력값에 맞춰 로또를 발행하는 기능의 서비스 Interface</td>
</tr>

<tr>
<td><b> LottoResultServiceImpl  </b></td>
<td> LottoResultService의 구현체 </td>
</tr>


<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="11"><b>🌟&nbsp;&nbsp;utils</b></td>

<td><b> constants </b></td>
<td> 검증, 파싱 과정에서 사용되는 상수 보관 enum 클래스</td>
</tr>

<tr>
<td><b> BonusNumberValidator </b></td>
<td> 입력된 보너스 번호의 유효성 검증을 담당하는 클래스</td>
</tr>

<tr>
<td><b> ComparisonValidator </b></td>
<td> 입력값을 다른 값과 비교하여 유효성을 검증하는 Interface </td>
</tr>

<tr>
<td><b> InputValidator </b></td>
<td> 입력값을 검증하는 validator 클래스들의 Interface</td>
</tr>

<tr>
<td><b> LottoNumberValidator </b></td>
<td> 숫자가 로또 번호로 유효한 지 검증하는 클래스</td>
</tr>

<tr>
<td><b> PositiveIntValidator </b></td>
<td> 입력값의 양의 정수 여부 검증 클래스</td>
</tr>

<tr>
<td><b> PurchaseAmountValidator </b></td>
<td> 입력한 구매 금액의 유효성 검증 클래스 </td>
</tr>

<tr>
<td><b> WinningNumbersValidator </b></td>
<td> 입력한 당첨 번호들의 유효성 검증 클래스 </td>
</tr>

<tr>
<td><b> Parser </b></td>
<td> 각종 파싱 클래스의 Interface</td>
</tr>

<tr>
<td><b> StringToIntListParser </b></td>
<td> String -> Integer List 로의 변환 담당 클래스</td>
</tr>

<tr>
<td><b> StringToIntParser </b></td>
<td> String ->Int 로의 변환 담당 클래스</td>
</tr>

<tr><td colspan="3"></td></tr>

<tr>
<td rowspan="7"><b>💬&nbsp;&nbsp;view</b></td>
<td><b> InputMessages </b></td>
<td> 사용자 입력 관련 안내 메세지지를 저장하는 enum 클래스</td>
</tr>

<tr>
<td><b> NumberOutputFormat </b></td>
<td> 출력시 숫자 포맷 정보를 저장하는 enum 클래스</td>
</tr>


<tr>
<td><b> OutputMessages </b></td>
<td> 출력 메세지를 저장하는 enum클래스 </td>
</tr>

<tr>
<td><b> ConsoleInputView </b></td>

<td> 사용자에게 입력을 받는 기능을 담당하는 클래스 </td>
</tr>

<tr>
<td><b> InputView </b></td>

<td> Input 클래스 Interface </td>
</tr>


<tr>
<td><b> ConsoleOutputView </b></td>
<td> 사용자에게 응답을 출력하는 클래스</td>
</tr>




<tr>
<td><b> OutputView </b></td>

<td> Output 클래스 Interface </td>
</tr>




</table>
</div>




---

## 🗺️  프로그램 플로우 및 구현 기능

- ✅ ```ConsoleInputView``` **구입 금액 관련 안내 문구를 출력한다.**

- ✅ ```ConsoleInputView``` **로또 구입 금액을 입력받는다.** 
  - ☑️ ```PurchaseAmountValidator``` 유효하지 않은 값이 들어오면 예외처리 한다.
    - ✔️ 인풋이 비어있는 경우 예외처리 한다. 
    - ✔️숫자가 아닌 경우 예외처리 한다.
      -  공백이 포함되어 있는 경우 또한 동일하다.
    - ✔️ 숫자이지만 정수가 아니면 예외 처리 한다.
    - ✔️ 정수이지만 양수가 아니면 예외처리 한다.
    - ✔️ 정수이지만 1000원으로 나누어 떨어지지 않는 경우 예외처리 한다.
    - ✔️ 100000을 넘어가는 값을 입력받으면 예외처리 한다.
      - 현행 법 상 개인의 로또 구매는 10만원이 최대이기에 이렇게 기준을 잡았다.
  - ☑️ ```LottoGameController```  예외가 발생한 경우, 에러메세지 출력 후 다시 입력 받는다.

<br>

- ✅ ```LottoPurchaseServiceImpl``` **로또를 발행한다.** 
  - ☑️ ```DefaultLottoFactory``` 로또 구입 금액 1000원 당 1 개의 로또를 발행한다.
  - ☑️ ```LottoNumbersGenerator``` 1 개의 로또를 발생할 때는 중복되지 않는 6개의 숫자를 뽑는다.
    - ✔️ 이때 숫자는 반드시 1 이상 45 이하의 정수여야 한다.

<br>

- ✅ ```LottoGameController```  **발행관련 정보를 ```LottosDTO``` 를 통해 view에게 전달한다.**


- ✅ ```ConsoleOutputView``` **발행한 로또 수량을 출력한다.**

- ✅ ```ConsoleOutputView``` **발행한 로또들의 번호를 출력한다**
  - ☑️  이때 로또 번호는 오름차순으로 정렬하여 보여준다.

<br>

- ✅ ```ConsoleInputView```  **당첨 번호 입력 안내문을 출력한다**
- ✅ ```ConsoleInputView``` **당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.**
  - ☑️ ```WinningNumbersValidator```  사용자가 잘못된 값을 입력할 경우 예외처리 한다. 
    - ✔️ 입력값이 비어있는 경우 예외처리 한다.
    - ✔️ 쉼표를 기준으로 분리된 각각의 원소가 숫자가 아닌 경우 예외처리 한다.
    - ✔️ 쉼표로 구분된 숫자의 갯수가 6개가 아닌경우 예외처리 한다.
    - ✔️ 각각의 숫자가 1이상 45이하의 정수가 아닌 경우 예외처리 한다.

  - ☑️ ```LottoGameController``` 예외가 발생한 경우, 에러메세지 출력 후 다시 입력 받는다.

<br>

- ✅ ```ConsoleInputView``` **보너스 번호 입력 안내문을 출력한다**

- ✅ ```ConsoleInputView``` **보너스 번호를 입력받는다**
  - ☑️ ```BonusNumberValidator``` 이때도 당첨 번호 한 개 숫자에 했던 예외처리를 동일하게 진행한다.
    - ✔️ 입력값이 비어있는 경우 예외처리 한다.
    - ✔️ 입력값이 숫자가 아닌 경우 예외처리 한다.
    - ✔️ 숫자가 1이상 45이하의 정수가 아닌 경우 예외처리 한다.
  - ☑️ ```LottoGameController``` 예외가 발생한 경우, 에러메세지 출력 후 다시 입력 받는다.

<br>

- ✅  ```LottoResultService``` **내부 로직을 통해 당첨 결과를 확인한다**
  - ☑️ ```LottoResultService``` 각각의 로또에 대하여 아래 로직을 진행한다.
    - ✔️ ```WinningLotto``` 당첨 번호와 몇개나 일치하는 지, 보너스 볼은 일치하는 지 확인한다.
    - ✔️ ```RankDecider``` 확인 결과에 따라 몇 등인지 결정한다.
    - ✔️ ```MatchResults``` 결과를 저장한다.


<br>

- ✅  ```LottoResultService``` **수익률을 계산한다**
  - ☑️  ```LottoResultService``` 위에서 구한 전체 결과를 통해 얼마를 얻었는 지 계산한다.
  - ☑️  ```LottoResultService```  총수익을 구매금액으로 나눈다.



<br>




- ✅  ```LottoResultService``` **결과를 ```FinalResultsDto```로 변환한다**
- ✅  ```LottoGameContorller``` **결과를 ```FinalResultsDto```로 변환한다**


<br>

- ✅ ```ConsoleOutputView``` **당첨 내역을 출력한다.**
  - ☑️ ```ConsoleOutputView```  5등부터 한 줄 씩  "x개 일치 (x,xxx,xxx원) - x개" 꼴로 출력한다.
    - ✔️ 이때 숫자는 세개 마다 쉼표(,)를 넣는다.
  - ☑️ ```ConsoleOutputView```  2등의 경우 위 형태 중간에 ', 보너스 볼 일치'가 추가 된다.

<br>

- ✅ ```ConsoleOutputView```  **수익률을 출력한다.**
  - ☑️ ```ConsoleOutputView```  이전에 계산해 놓았던 수익률을 "총 수익률은 xx.x%입니다."형태로 출력한다.


---

## ❓ 테스트 목록
<div>
<p align="center">
  <img src="https://github.com/user-attachments/assets/39506f78-2af9-40cd-afdc-46b816256878" alt="첫 번째 이미지" width="45%" style="margin: 10px;" />
  <img src="https://github.com/user-attachments/assets/3e43c8f3-adb4-440d-a69e-8dd63f2098fe" alt="두 번째 이미지" width="45%" style="margin: 10px;" />
</p>

<p align="center">
  <img src="https://github.com/user-attachments/assets/6dc24fdd-d699-44d5-9550-953cbc4f463b" alt="첫 번째 이미지" width="45%" style="margin: 10px;" />
  <img src="https://github.com/user-attachments/assets/19ca5a05-f556-484f-806b-86db56c389e3" alt="두 번째 이미지" width="45%" style="margin: 10px;" />
</p>

</div>



----

## 🔍  고민했던 요소

### 📝 입력값의 검증은 어디에서?

view에서 입력값을 받아. controller를 통해 model로 넘겨져서 처리가 이루어지는 구조에서, 과연 어디에서 입력값에 대한 검증을 해야하나에 대해서 많은 고민을 하였습니다.

그 결과 view에는 최소한의 로직이 존재하고, 컨트롤러는 전체 로또 로직의 거대한 흐름을 다루는 것이 옳은 구조라고 생각했습니다. 그 결과 서비스 레이어에서 유효성 검증을 진행하였습니다.

도메인 내의 로직이 실행되기전에 서비스에서 일차적으로 입력값에 대한 검증을 끝내고, 주요한 클래스인 ```Lotto```의 경우에는 생성 시 한 번 더 입력값에 대한 검증을 하는 방식을 채택했습니다.

<br>


### 📝 입력 안내시 나오는 출력문은 Output? Input? 어디에서 관리?

이에 대해서 저번 주부터 많은 고민이 있었습니다. 일단은 출력이니까 Output? 아니면 그래도 입력과 관련된 요소이니까 Input? 이에 대해서 많은 사람들과 이야기하고, 코드리뷰를 하며 스스로 기준을 세워봤습니다.

제 결로은 Input이었습니다. InputView와 OutputView가 아닌 Reader와 Printer였다면 심플하게 무언가 값을 외부로부터 읽어 오는 것은 Reader에, 어떤 것이든 출력하는 것은 Printer에 위치시켰을 것입니다.

하지만 지금 제가 나눈 것은 Inputview와 OutputView입니다. 결국 "입력에 관련된" 사항은 InputView에 담겨 있고, 이 Input에 의해서 무언가 일종의 결과값으로 출력되는 행동에 대해선 "OutputView"에 담겨잇는 것이 맞다고 생각하여 지금과 같은 구조로 결정하였습니다.

<br>


### 📝 상수를 한 곳에서? 아니면 여러 곳? 

또다른 많은 고민이 있던 부분입니다. 이 프로그램에선 많은 부분에서 상수가 활용되고 있습니다.
어떤 상수냐에 따라서 하나의 파일에서만 활용되는 것도 있고, 하나의 패키지에서 활용되는 것도 있었으며, 전역에서 사용되는 것도 있었습니다. 이들을 하나의 거대한 파일에서 관리할 지, 아니면 개별의 파일에서 관리할 지 고민했습니다. 

제 결론은 개별의 파일입니다. 결국 상수를 한 곳에서 관리하는 경우, 큰 장점이 한 곳에서 관리하기 쉽다는 것입니다. 

그런데 이번 프로그램의 경우, 상수가 String , int, DecimalFormat 등등 다양한 자료형으로 존재하며, 그냥 상수 자체가 많습니다.

이러한 경우 오히려 한 곳에서 관리하는 것이 헷갈리게 할 것이라고 판단하여 사용처 별로 상수를 나누어서 위치시켰습니다.

이것이 오히려 위치에 따라 어디에서 쓰이는 지가 명료해지기 때문에 좋은 것 같습니다.

<br>

### 📝 DTO의 올바른 사용법

이는 아직도 고민인 부분입니다. 저는 이번 프로그램에서 컨트롤러를 통해 서비스 레이어로 넘어가는 데이터는 유효성 검증을 진행한 후 그대로 전달하였고, 서비스 레이어에서 특정 로직의 결과물로 나오는 데이터는 DTO를 활용하여 컨트롤러 레이어로 내보냈습니다.

하지만 이게 정말 최선의 방법인지에 대해 아직 불확실 합니다. View 레이어와 컨트롤러 레이어 사이에서는 DTO를 아예 사용하지 않는 지 등, 여러가지 부분에서 DTO관한 논쟁이 생기기에 이를 좀 더 고민해봐야겠습니다.

----


## ⭐ 설계 시 주요 포인트


### 🔔 MVC 패턴 준수 

- 뷰, 서비스, 유틸, 도메인, 컨트롤러 등의 역할을 명확히 분리하였습니다


### 🔔 DI & DIP

- AppConfig, Factory 클래스 등을 이용해서 스스로 의존성을 생성하는 것이 아닌 의존성을 주입받도록 하였습니다.
- 인터페이스를 적극 활용하여 상위 모듈은 하위 모듈에 종속되지 않도록 하였습니다.
    

### 🔔 하드 코딩 지양
- 적극적으로 enum을 사용하고, 포맷을 이용함으로써 하드코딩을 최소화 시켰습니다


### 🔔 YANGI & KISS 준수
- 지금 필요한 기능만 넣고, 불필요하게 다양한 로직을 넣거나 아직 일어나지 않은 부분에 대한 코딩을 제거하고 최소화하여 코드를 간략화하였습니다.


### 🔔 코드 순서도 컨벤션이다
- 단순하게 구현한 순서대로 코드를 적는 것이 아닌, 코드를 읽는 입장에서 의도를 파악할 수 있도록 배치시켰습니다.


### 🔔 else 지양
- If-else를 사용하기 보다는 If-return If-return 혹은 스트림을 이용한 코드를 짜서 Else 사용을 지양하였습니다.

### 🔔 하나의 메서드에 한 가지 기능
- 메서드 마다 딱 한 줄로 적을 수 있는 기능만을 탑재하여 메서드 하나의 크기를 최소화하였습니다. 
