## 🎫 프로젝트명

로또

<hr>

## 🎫 기능 개요

- 로또 번호는 1~45 사이의 숫자 중 중복 없는 6개의 번호로 구성된다.
- 사용자는 6개의 기본 번호와 보너스 번호 1개를 입력하여 당첨 번호를 지정한다.
- 로또 한 장당 가격은 1,000원이며, 입력된 금액에 따라 해당하는 개수의 로또가 자동 발행된다.

<hr>

## 🎫 입력부 예외 처리

아래의 경우, IllegalArgumentException 을 발생시키고, [ERROR] 로 시작하는 메세지를 출력한 후, 해당 부분부터 다시 입력 받는다.

### [ 당첨 번호 6개 ]

- [x] 공백 입력인 경우
- [x] 입력된 숫자의 개수가 6개가 아닐 경우
- [x] 6개의 숫자 중 문자 또는 실수가 포함된 경우
- [x] 쉼표(,)가 아닌 구분자를 사용한 경우
- [x] 중복된 값이 입력된 경우
- [x] 1 미만 45 초과일 경우

### [ 보너스 번호 ]

- [x] 공백 입력인 경우
- [x] 문자 또는 실수일 경우
- [x] 1 미만 45 초과일 경우

### [ 구입 금액 ]

- [x] 공백 입력인 경우
- [x] 문자 또는 실수일 경우
- [x] 0 이하일 경우
- [x] 1000으로 나누어 떨어지지 않을 경우

<hr>

## 🎫 기능 목록

<table border="1" style="border-collapse: collapse; text-align: left;">
  <thead>
    <tr style="background-color: #5F5E5E;">
      <th style="padding: 10px;">구분</th>
      <th style="padding: 10px;">기능</th>
      <th style="padding: 10px;">상세 기능</th>
      <th style="padding: 10px;">작동 순서</th>
    </tr>
  </thead>
  <tbody>
    <tr>
      <td rowspan="3" style="padding: 10px;">입력<br>(Input)</td>
      <td style="padding: 10px;">구입 금액 입력<br>(moneyToTicket)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력값이 문자 또는 실수인 경우, 0 이하일 경우, 1000으로 나누어 떨어지지 않는 경우, 해당 부분 다시 입력</li>
            <li>구입 금액을 1000으로 나눈 몫 반환</li>
        </ul>
      </td><td style="padding: 10px;">
        <ol>
            <li>콘솔 입력 후 정수형으로 변환</li>
            <li>입력값이 문자 또는 실수인 경우, 0 이하일 경우, 1000으로 나누어 떨어지지 않을 경우에 ERROR 메세지 띄우고 해당 과정 다시 실행</li>
            <li>제대로 입력한 경우, 입력값을 1000으로 나눈 몫 반환</li>
        </ol>
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">당첨 번호 입력<br>(lottoNumber)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력된 숫자가 6개 아닌 경우, 입력값 중 문자 또는 실수가 포함된 경우, 쉼표(,)가 아닌 구분자를 사용한 경우, 중복된 값이 입력된 경우, 입력값 중 1미만 45초과인 값이 포함된 경우, 해당 부분 다시 입력</li>
            <li>입력된 값을 리스트 형태로 반환</li>        
</ul>
      </td><td style="padding: 10px;">
        <ol>
            <li>콘솔 입력 후, 쉼표(,)를 기준으로 분할</li>
            <li>입력된 숫자가 6개 아닌 경우, 입력값 중 문자 또는 실수가 포함된 경우, 쉼표(,)가 아닌 구분자를 사용한 경우, 중복된 값이 입력된 경우, 입력값 중 1미만 45초과인 값이 포함된 경우에 ERROR 메세지 띄우고 해당 과정 다시 실행</li>
            <li>제대로 입력한 경우, 배열을 리스트로 변환한 뒤 반환</li>
        </ol>
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">보너스 번호 입력<br>(bonusNumber)</td>
      <td style="padding: 10px;">
        <ul>
            <li>문자 또는 실수를 입력한 경우, 입력값이 1 미만 45 초과인 경우, 해당 부분 다시 입력</li>
            <li>정수형으로 변환된 입력값 반환</li>
        </ul>
      </td><td style="padding: 10px;">
        <ol>
            <li>콘솔 입력 후 정수형으로 변환</li>
            <li>문자 또는 실수를 입력한 경우, 입력값이 1 미만 45 초과인 경우에 ERROR 메세지 띄우고 해당 과정 다시 실행</li>
            <li>제대로 입력한 경우, 정수형으로 변환된 입력값 반환</li>
        </ol>
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="4" style="padding: 10px;">입력값 유효성 검증<br>(validation)</td>
      <td style="padding: 10px;">반복적으로 사용되는 검증 메서드 모음<br>(CommonValidation)</td>
      <td style="padding: 10px;">
        <ul>
            <li>공백 입력 시 에러 메세지 던지기</li>
            <li>압력값이 정수형으로 변환할 수 없는 값(문자, 실수)일 경우 에러 메세지 던지기</li>        
            <li>입력값이 1 미만 45 초과일 경우 에러 메세지 던지기</li>        
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">구매 금액 관련 검증 메서드 모음<br>(MoneyValidation)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력값이 0 이하인 경우 에러 메세지 던지기</li>
            <li>입력값이 1000으로 나누어 떨어지지 않는 경우 에러 메세지 던지기</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">당첨 번호 6개 관련 검증 메서드 모음<br>(WinningNumberValidation)</td>
      <td style="padding: 10px;">
        <ul>
            <li>입력된 배열의 요소 모두 정수로 변환 가능한 경우, 정수형 리스트로 변환하여 반환</li>
            <li>정수로 변환 불가능한 값이 섞여있을 경우, 에러 메세지 던지기</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">보너스 번호 관련 검증 메서드 모음<br>(BonusNumberValidation)</td>
      <td style="padding: 10px;">
        <ul>
            <li>정수형 리스트 요소 중 입력된 보너스 번호와 중복된 번호가 존재할 경우, 에러 메세지 던지기</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="1" style="padding: 10px;">데이터 자료형 변경<br>(ChangeDataType)</td>
      <td style="padding: 10px;">문자열 배열을 정수형 리스트로 변환<br>(stringArrayToIntegerList)</td>
      <td style="padding: 10px;">
        <ul>
            <li>문자열 배열을 입력받은 후, 정수형 리스트로 변환 후 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="3" style="padding: 10px;">출력<br>(Output)</td>
      <td style="padding: 10px;">티켓 수에 맞추어 랜덤으로 뽑은 로또 번호 출력<br>(printLottos)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">티켓 수 안내 문구 출력<br>(printTicketNumber)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">결과 문구 출력<br>(printResult)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="1" style="padding: 10px;">결과 출력 뷰<br>(View)</td>
      <td style="padding: 10px;">결과가 출력되는 클래스<br>(Result)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="3" style="padding: 10px;">데이터<br>(model)</td>
      <td style="padding: 10px;">구입 금액에 맞추어 구매한 로또 번호 저장<br>(Lotto)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">당첨 번호 및 보너스 번호 저장<br>(LottoWiningNumber)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">당첨 결과 저장<br>(LottoResult)</td>
      <td style="padding: 10px;">
        <ul>
            <li>Map을 이용해 당첨 금액과 개수 저장</li>
            <li>결과 안내 문구를 문자열로 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="4" style="padding: 10px;">enum 으로 관리<br>(enumValue)</td>
      <td style="padding: 10px;">반복적으로 사용되는 일반적인 문구를 enum 으로 저장<br>(CommonMessage)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">예외처리 관련 문구를 enum으로 저장<br>(ExceptionMessage)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">결과 안내와 관련된 문구를 enum으로 저장<br>(ResultMessage)</td>
      <td style="padding: 10px;">
        <ul>
            <li>Map을 이용해 당첨 금액과 개수 저장</li>
            <li>결과 안내 문구를 문자열로 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">숫자를 enum으로 저장<br>(Number)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="3" style="padding: 10px;">컨트롤러<br>(controller)</td>
      <td style="padding: 10px;">Application 컨트롤러<br>(ApplicationController)</td>
      <td style="padding: 10px;">
        <ul>
            <li>사용자 입력을 전달받아, 데이터 가공 후 서비스 객체로 전달</li>
            <li>서비스 객체를 이용해 당첨자 결과를 받은 후, Result View로 데이터 전달</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">데이터 컨트롤러<br>(DataController)</td>
      <td style="padding: 10px;">
        <ul>
            <li>서비스 객체로 사용자 입력 값을 전달</li>
            <li>서비스 객체를 이용해 입력 값 가공 후, 컨트롤러로 만들어진 객체 전달</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">당첨자 선정 컨트롤러<br>(ProcessController)</td>
      <td style="padding: 10px;">
        <ul>
            <li>서비스 객체에 데이터 객체 전달</li>
            <li>전달받은 결과 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr>
<!---------------------------------------- 대분류 ------------------------------------------------><tr>
      <td rowspan="3" style="padding: 10px;">서비스<br>(service + serviceImpl)</td>
      <td style="padding: 10px;">Application 서비스<br>(ApplicationService)</td>
      <td style="padding: 10px;">
        <ul>
            <li>데이터 컨트롤러를 통해, 랜덤으로 뽑은 값들을 객체로 저장해 반환</li>
            <li>데이터 컨트롤러를 통해, 당첨 번호 6개와 보너스 번호를 객체로 저장해 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">데이터 서비스<br>(DataService)</td>
      <td style="padding: 10px;">
        <ul>
            <li>당첨 번호 6개와 보너스 번호를 객체로 저장해 반환</li>
            <li>자료형이 Lotto인 리스트에 티켓수에 맞추어 뽑은 티켓을 저장해 반환</li>
            <li>당첨자 결과 객체에서 6개의 번호를 담은 리스트 반환</li>
            <li>당첨자 결과 객체에서 보너스 번호를 담은 값 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">당첨자 선정 서비스<br>(ProcessService)</td>
      <td style="padding: 10px;">
        <ul>
            <li>뽑은 로또 번호 리스트 요소 중 당첨 보너스 번호, 6개의 번호와 일치하는 값의 개수를 세어 반환 </li>
            <li>카운팅 결과를 일치하는 당첨 금액으로 변경해 반환</li>
            <li>당첨 결과를 담는 객체에 결과 저장 후, 결과(Map) 반환</li>
            <li>수익률 계산 후 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr>
  </tbody>
</table>