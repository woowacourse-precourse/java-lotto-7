# java-lotto-precourse

## ✨ 작성자

> JGoo99

<br/>

## ✨ 과제 요구사항

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다. 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
- [ ] else 예약어를 쓰지 않는다.
- [ ] Enum을 적용하여 프로그램을 구현한다.
- [ ] UI(System.out, System.in, Scanner) 로직은 제외하고 단위테스트를 작성한다.
- [ ] 제공된 Lotto 클래스를 사용하여 구현해야 한다.
- [ ] Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다. 
- [ ] numbers의 접근 제어자인 private은 변경할 수 없다.
- [ ] Lotto의 패키지를 변경할 수 있다.

<br/>

## ✨ 기능 요구사항

### 역할

#### 사용자
- [ ] 로또 구입 금액을 입력한다. (1장당 1000원)

#### 시스템
- [ ] 1 부터 45 사이의 중복되지 않는 6개의 당첨 번호를 입력한다. (구분자: 쉼표)
- [ ] 1 부터 45 사이의 1개의 보너스 번호를 입력한다.

#### 로또 발매기
- [ ] 로또 구입 금액에 맞는 수량에 따라 랜덤 로또를 생성한다.
- [ ] 사용자가 발행한 로또 수량과 번호를 출력한다.
- [ ] 총 수익률을 계산한다.
- [ ] 당첨 내역을 출력한다.
- [ ] 총 수익률을 출력한다.

### 흐름도

1. 사용자가 로또 구입 금액을 입력한다. 
2. 금액에 맞는 수량대로 랜덤 로또를 생성하여 출력한다.
3. 시스템이 당첨 번호와 보너스 번호를 입력한다.
4. 랜덤 로또와 당첨 번호를 비교한다.
5. 당첨 내역을 출력한다.
6. 총 수익률을 출력한 후 게임을 종료한다.

### 기능 리스트

- [x] 로또 구입 금액을 입력받는다.
- [x] 1000 으로 나누어지지 않는 경우 예외 메시지를 출력한 후 다시 입력받는다.
- [ ] (이 외의 로또 구입 금액에 대한 예외 처리 업데이트 예정)
- [x] 구입 금액에 맞는 수량대로 랜덤 번호를 생성한다.
- [x] 로또 개수와 생성된 랜덤번호를 출력한다. (오름차순)
- [x] 당첨 번호를 입력받는다. (예외 처리 후 재입력)
- [ ] 보너스 번호를 입력받는다. (예외 처리 후 재입력)
- [ ] 겹치는 번호가 있는 경우 예외 메시지를 출력한 후 다시 입력받는다.
- [ ] (이 외의 당첨 번호에 대한 예외 처리 업데이트 예정)
- [ ] 당첨 번호와 랜덤 로또 번호의 일치 개수를 카운트한다.
- [ ] 5개 일치하는 경우 보너스 번호와 일치하는지 여부를 확인한다.
- [ ] 총 수익률을 계산한다.
- [ ] 당첨 내역을 출력한다.
- [ ] 총 수익률을 계산한다.

### 리펙토링

- [ ] 에러 처리 형식을 통일한다. ([ERROR] bla bla)
- [ ] Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.