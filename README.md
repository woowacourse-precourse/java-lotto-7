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

- 공백 입력인 경우
- 입력된 숫자의 개수가 6개가 아닐 경우
- 6개의 숫자 중 문자 또는 실수가 포함된 경우
- 쉼표(,)가 아닌 구분자를 사용한 경우
- 중복된 값이 입력된 경우
- 1 미만 45 초과일 경우

### [ 보너스 번호 ]

- 공백 입력인 경우
- 문자 또는 실수일 경우
- 1 미만 45 초과일 경우

### [ 구입 금액 ]

- 공백 입력인 경우
- 문자 또는 실수일 경우
- 0 이하일 경우
- 1000으로 나누어 떨어지지 않을 경우

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
    <!-----------------------새로운 대분류----------------------------><tr>
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
    <!-----------------------새로운 대분류----------------------------><tr>
      <td rowspan="1" style="padding: 10px;">데이터 자료형 변경<br>(ChangeDataType)</td>
      <td style="padding: 10px;">문자열 배열을 정수형 리스트로 변환<br>(stringArrayToIntegerList)</td>
      <td style="padding: 10px;">
        <ul>
            <li>문자열 배열을 입력받은 후, 정수형 리스트로 변환 후 반환</li>
        </ul>
      </td><td style="padding: 10px;">
      </td>
    </tr>
    <!-----------------------새로운 대분류----------------------------><tr>
      <td rowspan="4" style="padding: 10px;">입력값 테스트<br>(InputTest)</td>
      <td style="padding: 10px;">반복적으로 사용되는 검증 메서드 모음 테스트<br>(CommonValidationTest)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">구매 금액 관련 검증 메서드 모음 테스트<br>(MoneyValidationTest)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">당첨 번호 6개 관련 검증 메서드 모음 테스트<br>(WinningNumberValidationTest)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr><!-------------------------------------------------><tr>
      <td style="padding: 10px;">보너스 번호 관련 검증 메서드 모음 테스트<br>(BonusNumberValidationTest)</td>
      <td style="padding: 10px;">
      </td><td style="padding: 10px;">
      </td>
    </tr>
  </tbody>
</table>