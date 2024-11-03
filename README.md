# java-lotto-precourse



# 프로그램 요구사항
## 요구사항 1
- JDK 21 버전에서 실행 가능할 것
- 구글 자바 코드 컨벤션을 최대한 준수할 것
## 요구사항 2
- 들여쓰기 깊이는 2까지만 허용
- 3항 연산자 사용 불가능
- 메서드를 한 가지 일만 하도록 최대한 작게 구현
- JUnit5와 AssertJ를 이용하여 테스트 코드 작성
## 요구사항 3
- 메서드 길이가 15라인을 넘어가지 않도록 구현할 것(메서드 시작부터 끝 접근제어자부터 마지막 중괄호까지 15라인으로 작성해야겠다.)
- else 예약어 대신 if 안에서 return을 사용하는 방식으로 구현할 것
- Java Enum을 사용할 것
- UI 로직을 제외한 나머지에 대해서 단위 테스트 진행할 것
- 제공된 클래스를 변경하지 않고 추가 구현 활용을 통해 미션 진행할 것

# 구현할 기능 목록
### - 입력 -
- [x] 로또 구입 금액을 입력 받는다.(구입 금액은 1,000원 단위로 입력 받으며 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.)
- [x] 당첨 번호를 입력 받는다. 번호는 쉼표(,)를 기준으로 구분한다.
- [x] 보너스 번호를 입력 받는다.
- [x] 중복된 숫자 입력 시 예외를 발생시키고 "[ERROR]"로 시작하는 에러 문구를 출력한다.

### - 로또 번호 -
- [x] 로또 번호는 오름차순으로 정렬하여 생성한다.
- [x] 로또 구입 금액 입력에 따라 로또 구매 수량을 자동으로 결정하고 로또들이 담긴 리스트를 생성한다.(이때 각 로또 객체는 로또 번호 리스트를 가진다.)
- [x] 로또 구입 금액 입력에 따라 1,000원 단위만큼 로또 번호 생성한다, 이때 특정 범위에서 유니크한 숫자를 생성한다.

### - 로또 당첨 계산 -
- [ ] 로또 당첨 계산을 위한 기본 Map을 세팅한다.
- [ ] 수익률을 소수점 둘째 자리에서 반올림하여 계산한다. (ex. 100.0%, 51.5%, 1,000,000.0%)
- [ ] 생성되어 변수에 담긴 로또 번호를 반환한다.
- [ ] 일치하는 로또 번호 개수를 센다.

### - 출력 -
- [x] 당첨 내역을 출력한다.
- [x] 당첨 순위를 출력한다.



