# java-lotto-precourse

## 미션 소개

이 프로젝트는 우아한테크코스 프리코스 3주차 미션으로, 로또 발매기를 구현한다.

## 미션 목표

### 기본 요구사항

- indent의 depth를 3이 넘지 않도록 구현한다.
- 메서드가 한 가지 일만 하도록 최대한 작게 만든다.
- 3항 연산자를 쓰지 않는다.
- 메서드의 길이가 15 라인을 넘어가지 않도록 구현한다.
- else 예약어를 쓰지 않는다.
- Enum을 적용하여 구현한다.

### 개인적 목표에 따른 요구사항

- 객체 지향 프로그래밍 원칙을 적용한 로또 발매기를 구현한다.
- 기능별 커밋을 원칙으로 한다.
- TDD를 적용한다.
    - 각 기능별로 테스트 케이스를 작성한다.
    - 기능별로 해피 케이스, 예외 케이스를 나누어 작성한다.
    - 실패 테스트 작성 -> 테스트 통과 -> 리팩토링
- 클린 코드를 지향하며 의미 있는 변수명과 메서드명을 사용한다.

## 주요 클래스 설명

- `Application`: 프로그램의 진입점으로, LottoManager를 초기화하고 실행을 위임한다.
- `LottoManager`: 로또 발매 진행 로직을 관리한다.
- `Lotto`: 숫자 목록을 관리하고 값을 반환한다.
- `Lottos`: 로또들의 일급 컬렉션으로, 로또 목록을 관리하고 당첨 통계 기능을 제공한다.
- `IoHandler`: 입출력과 검증을 총괄한다.
    - `InputHandler`: Console을 통한 사용자 입력을 담당한다.
    - `OutputHandler`: 로또 발매 진행 상태와 결과 출력을 담당한다.
- `RandomNumberProvider`: 로또 번호 생성을 위한 랜덤 값 생성을 담당한다.
- `ValidatingParser`: 입력값의 파싱과 검증을 담당한다.
- `ValidationError`: 검증 관련 에러 메시지를 관리하는 enum

## 기능 목록

### 입력 기능 (InputHandler)

- [ ] 사용자가 적절한 값을 입력할때까지 Console.readLine()을 사용해 구입 금액을 입력받는다.
- [ ] 사용자가 적절한 값을 입력할때까지 Console.readLine()을 사용해 당첨 번호를 입력받는다.
- [ ] 사용자가 적절한 값을 입력할때까지 Console.readLine()을 사용해 보너스 번호를 입력받는다.

### 입력 검증 및 변환 기능 (ValidatingParser)

- [ ] 구입 금액이 숫자인지 검증한다.
- [ ] 구입 금액이 양의 정수인지 검증한다.
- [ ] 구입 금액이 1000으로 나누어 떨어지는지 검증한다.
- [ ] 쉼표(,)로 구분된 문자열을 당첨 번호 목록으로 분리한다.
- [ ] 각 당첨 번호가 숫자인지 검증한다.
- [ ] 각 당첨 번호가 빈 문자열인지 검증한다.
- [ ] 각 당첨 번호가 1~45 범위인지 검증한다.
- [ ] 보너스 번호가 숫자인지 검증한다.
- [ ] 보너스 번호가 양의 정수인지 검증한다.

### 로또 기능 (Lotto)

- [ ] 숫자 리스트로 Lotto 객체를 생성한다.
- [ ] Lotto 생성시 숫자 리스트의 사이즈가 6개인지 검증한다.
- [ ] Lotto 생성시 각 당첨 번호가 숫자인지 검증한다.
- [ ] Lotto 생성시 각 당첨 번호가 빈 문자열인지 검증한다.
- [ ] Lotto 생성시 각 당첨 번호가 1~45 범위인지 검증한다.
- [ ] 숫자들을 반환한다.

### 로또 목록 관리 기능 (Lottos)

- [ ] 로또 목록으로 Lottos를 생성한다.
- [ ] 당첨 번호와 보너스 번호에 대한 당첨 여부를 판단한다.
- [ ] 당첨된 번호의 개수를 계산한다.
- [ ] 보너스 번호 일치 여부를 확인한다.
- [ ] 총 수익율을 계산한다.

### 로또 발매 기능 (LottoManager)

- [ ] 구입 금액을 받아 Lottos를 생성한다.
- [ ] 당첨 번호를 받아 Lottos에게 통계를 요청하고 결과 출력을 요청한다.

### 출력 기능 (OutputHandler)

- [ ] 구입금액 안내 메시지를 출력한다.
- [ ] 구입 금액에 맞는 로또 구매 개수를 출력한다.
- [ ] 구입 금액에 맞는 로또 구매 목록를 출력한다.
- [ ] 당첨 번호 안내 메시지를 출력한다.
- [ ] 보너스 번호 안내 메시지를 출력한다.
- [ ] 당첨 통계를 출력한다.

### 랜덤값 생성 기능 (RandomNumberProvider)

- [ ] Randoms.pickUniqueNumbersInRange()를 사용해 1-45 사이의 중복되지 않은 정수를 6개를 생성한다.

## 테스트 목록

### Lotto 테스트

- [ ] Lotto 생성시 숫자 리스트의 사이즈가 6개가 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] Lotto 생성시 각 당첨 번호가 숫자가 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] Lotto 생성시 각 당첨 번호가 빈 문자열이 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] Lotto 생성시 각 당첨 번호가 1~45 범위에 없다면 IllegalArgumentException 예외가 발생한다.

### Lottos 테스트

- [ ] 로또 목록으로 Lottos 생성에 성공한다.
- [ ] 당첨 번호와 보너스 번호에 대한 당첨 여부를 판단한다.
- [ ] 당첨된 번호의 개수를 계산한다.
- [ ] 보너스 번호 일치 여부를 확인한다.
- [ ] 총 수익율을 계산한다.

### RandomNumberProvider 테스트

- [ ] 1~45 범위를 가진 6개의 숫자 랜덤 값을 반환한다.

### ValidatingParser 테스트

- [ ] 쉼표로 구분된 문자열을 분리하여 로또 숫자 목록을 반환한다.
- [ ] 구입 금액이 숫자가 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] 구입 금액이 양의 정수가 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] 구입 금액이 1000으로 나누어 떨어지는지 않으면 IllegalArgumentException 예외가 발생한다.
- [ ] 쉼표(,)로 구분된 문자열을 당첨 번호 목록으로 분리한다.
- [ ] 각 당첨 번호가 숫자가 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] 각 당첨 번호가 빈 문자열이면 IllegalArgumentException 예외가 발생한다.
- [ ] 각 당첨 번호가 1~45 범위가 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] 보너스 번호가 숫자가 아니면 IllegalArgumentException 예외가 발생한다.
- [ ] 보너스 번호가 양의 정수가 아니면 IllegalArgumentException 예외가 발생한다.

## 작성자

lvalentine6 (이승로)