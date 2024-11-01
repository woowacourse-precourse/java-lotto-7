# 기능 요구 사항 정리

로또 번호를 추첨하여 당첨 내역과 수익률을 출력하는 간단한 로또 시스템을 구현한다.

## 주요 기능
 - 로또 번호는 1~45로 중복되지 않게 뽑고 오름차순으로 정렬한다.
 - 당첨 번호를 중복되지 않게 쉼표로 구분해 입력 받는다.
 - 또한, 보너스 번호를 따로 1개 입력 받는다.
 - 로또 금액은 장당 1천원으로 천의 배수로 금액을 입력받아 시도할 로또 횟수를 측정한다.
 - 당첨에 대한 금액과 기준은 다음과 같다.
    * 1등: 6개 일치 / 20억원
    * 2등: 5개 + 보너스 1개 일치 / 3000만원
    * 3등: 5개 일치 / 150만원
    * 4등: 4개 일치 / 5만원
    * 5등: 3개 일치 / 5천원
 - n번 시도에 대한 각 당첨 결과를 알려주고 사용금액 대비 수익률을 출력한다.
 - 수익률은 소수점 둘째 자리에서 반올림하여 출력한다.
 - 잘못된 입력은 예외처리하며 [ERROR]로 시작한 에러 문구를 출력한다.

## 검증 사항
 - 구입 금액에서 1000이상의 천의 배수로 입력되지 않은 모든 경우는 예외를 발생시킨다.
 - 당첨 번호 입력에서 띄어쓰기, 다른 구분자, 중복 숫자, 문자, 소수, 음수 등 다른 입력은 모두 예외처리한다.
 - 보너스 숫자는 양의 정수 하나만 가능하며 위와 같이 다른 문자가 입력되면 예외처리한다.
 - 모든 숫자 입력의 범위는 1부터 2^31-1까지이며 0도 허락하지 않는다.
 - 당첨 번호가 6개가 아닐 경우 예외를 발생시킨다.
 - 당첨 번호를 입력받고 그 6개는 보너스 번호로 입력되면 안된다.

## 프로그래밍 요구 사항 특수한 점
 - 모든 잘못된 값은 예외를 던지지 않고 처리하여 그 부분을 다시 입력 받는다.
 - 들여쓰기는 2까지만 허용된다(while 내부의 if 문이 존재하면 depth는 2다).
 - JUnit 5와 AssertJ를 이용해 기능이 정상작동하는지 테스트 한다.
 - 함수는 길이가 15를 넘지 않으며 한가지일만 하도록 최대한 맞춘다.
 - else와 switch는 사용하지 않는다.
 - Enum을 적용하여 구현한다.
 - 단위 테스를 작성한다.