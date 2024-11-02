# java-lotto-precourse

---

## 개요
우테코 프리코스 3주차: "로또" 입니다.
사용자가 지불한 금액만큼 무작위 번호로 구성된 로또를 구매하고, 
당첨 번호와 보너스 번호를 추첨 및 비교하여 각 로또에 대한 당첨 내역과 수익률을 출력하는 프로그램입니다.

로또는 1장 당 1,000원입니다. 예를 들어 10,000원 지불 시 로또 10장을 구매합니다.
구매한 로또 번호는 1~45 중 6개의 무작위 숫자가 추첨되며 중복은 허용하지 않습니다.
당첨 번호는 쉼표(,)를 구분자로 하여 1~45 중 총 6개의 숫자를 중복 없이 입력해야 합니다.
추가로 보너스 번호를 입력받습니다.

사용자로부터 잘못된 입력값을 받은 경우 예외를 발생시키고 정상적인 입력값이 주어질 때까지 입력을 다시 받습니다.

---

## 기능 목록

### 1. Domain
#### 지불 금액(Money)

- [ ] 지불 금액 저장
- [ ] 입력값 타입에 대한 유효성 검증
- [ ] 지불한 금액 단위에 대한 유효성 검증
- [ ] 구매할 수 있는 로또 수 반환

#### 상금(Prize)

- [ ] 각 등수별 달성 조건(당첨 번호 수, 보너스 볼 일치) 및 상금 저장
- [ ] 조건 달성 여부에 따라 해당하는 인덱스 반환
- [ ] 인덱스 값에 대한 달성 조건, 상금 반환

#### 로또(Lotto)

- [ ] 당첨 번호 리스트 저장
- [ ] 입력된 당첨 번호에 대한 유효성 검증

#### 보너스 번호(BonusNumber)

- [ ] 보너스 번호 저장
- [ ] 보너스 번호에 대한 유효성 검증

### 2. Service
#### 유효성 검증(Validator)

- [ ] 공통 예외 처리
  - [ ] 아무것도 입력하지 않은 경우
  - [ ] 음수나 0이 입력된 경우
- [ ] 지불 금액에 대한 예외 처리
  - [ ] 지불 금액을 파싱할 수 없는 경우
  - [ ] 지불 금액 단위를 지키지 않은 경우
- [ ] 로또 당첨 번호, 보너스 번호에 대한 예외 처리
  - [ ] 숫자, 구분자 외 다른 문자가 삽입된 경우(로또 당첨 번호)
  - [ ] 숫자 외 다른 문자가 삽입된 경우(보너스 번호)
  - [ ] 구분자 사이에 아무것도 입력하지 않은 경우
  - [ ] 입력된 숫자가 6개가 아닌 경우
  - [ ] 1~45 외 다른 숫자가 입력된 경우

#### 입력 서비스(InputService)

- [ ] 지불 금액에 대한 입력값 반환
- [ ] 로또 당첨 번호에 대한 입력값 반환
- [ ] 로또 보너스 번호에 대한 입력값 반환

#### 출력 서비스(OutputService)

- [ ] 구매한 로또의 숫자 리스트 출력
- [ ] 당첨 통계 및 수익률 출력

#### 로또 번호 생성(GenerateLotto)

- [ ] 1~45 사이의 중복되지 않는 무작위 숫자 6개 추첨
- [ ] 로또 리스트 반환

#### 로또 번호 비교(CompareNumber)

- [ ] 당첨 번호와 구매한 로또 번호를 비교
- [ ] 일치하는 번호 개수 반환

### 3. Controller
#### 로또 컨트롤러(LottoController)

- [ ] 프로그램 진행