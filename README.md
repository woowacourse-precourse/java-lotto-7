# 기능 요구 사항
- 간단한 **로또 발매기**를 구현한다.
- **로또 번호**의 숫자 범위는 1~45까지이다.
- 1개의 **로또**를 발행할 때 중복되지 않는 6개의 숫자를 뽑는다.
- **당첨 번호** 추첨 시 **중복되지 않는 숫자** 6개와 **보너스 번호** 1개를 뽑는다.
- 당첨은 1등부터 5등까지 있다. **당첨 기준**과 **금액**은 아래와 같다.
  - 1등: 6개 번호 일치 / 2,000,000,000원
  - 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
  - 3등: 5개 번호 일치 / 1,500,000원
  - 4등: 4개 번호 일치 / 50,000원
  - 5등: 3개 번호 일치 / 5,000원
- **로또 구입 금액**을 입력하면 구입 금액에 해당하는 만큼 로또를 발행해야 한다.
- 로또 1장의 가격은 1,000원이다.
- **당첨 번호**와 **보너스 번호**를 입력받는다.
- 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 **당첨 내역** 및 **수익률**을 출력하고 로또 게임을 종료한다.
- 사용자가 잘못된 값을 입력할 경우 **IllegalArgumentException**을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- **Exception**이 아닌 **IllegalArgumentException**, **IllegalStateException** 등과 같은 명확한 유형을 처리한다.

# 구현할 기능 목록
### 입력
- [ ] 로또 구입 금액 입력
- [ ] 당첨 번호 입력
- [ ] 보너스 번호 입력

### 출력
- [ ] 구매한 로또의 번호 출력
- [ ] 당첨 통계 출력
  - [ ] 로또 번호를 오름차순으로 정렬하여 출력 
- [ ] 총 수익률 출력
  - [ ] 소수점 둘째 자리에서 반올림하여 출력 
- [ ] 예외 상황 시 "[ERROR]"로 시작하는 에러 문구를 출력

### 비지니스 로직
- [ ] 로또 번호 생성
- [ ] 당첨 통계 계산
- [ ] 수익률 계산

### 예외 처리(IllegalArgumentException)
- 로또 구입 금액 입력
  - [ ] 1,000원으로 나누어 떨어지지 않으면 예외 처리
  - [ ] 숫자가 아닌 문자가 왔을 때 예외 처리
  - [ ] 1000 이하의 정수 값 입력 시 예외 처리
  - [ ] 공백이 입력되었을 때 예외 처리
- 당첨 번호 입력
  - [ ] 쉼표로 구분되지 않으면 예외 처리
  - [ ] 숫자가 아닌 문자가 왔을 때 예외 처리
  - [ ] 공백이 입력되었을 때 예외 처리
  - [ ] 로또 번호 범위(1~45)에 해당되지 않는 숫자가 입력되었을 때 예외 처리
  - [ ] 중복된 로또 숫자가 입력 되었을 때 예외 처리
- 보너스 번호 입력
  - [ ] 숫자가 아닌 문자가 왔을 때 예외 처리
  - [ ] 공백이 입력되었을 때 예외 처리
  - [ ] 로또 번호 범위(1~45)에 해당되지 않는 숫자가 입력되었을 때 예외 처리
  - [ ] 당첨 번호와 중복된 숫자가 입력되었을 때 예외 처리 

# 프로그래밍 요구 사항
### main
- [ ] indent(인덴트, 들여쓰기) depth가 3이 넘지 않도록 구현
- [ ] 3항 연산자를 사용하지 않고 구현
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 구현
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘지 않도록 구현
- [ ] else 예약어를 쓰지 않고 구현
- [ ] Java Enum을 적용하여 구현

### test
- [ ] 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드 작성
- [ ] 구현된 기능에 대한 단위 테스트를 작성