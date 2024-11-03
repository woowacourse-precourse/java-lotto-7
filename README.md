# java-lotto-precourse
## 🎰 로또 발매기 🎰

---
## 요구 사항
- 함수의 길이가 15라인을 넘지 않도록 구현
- else 예약어를 쓰지 않는다
- Enum적용
- 단위테스트 작성

---
## 필요 기능

### 구입 금액
구입 금액은 1000원 단위
- 예외처리 : 1000원으로 나눠지지 않을 경우
- 예외처리 : 숫자가 아닌경우
- 14,000 -> 14000 (Numberformat사용)

### 로또 번호

- 번호 리스트 입력
- , 로 숫자 구분
- 예외처리 : 6자리를 입력해야함
- 예외처리 : 숫자만 들어와야함
- 예외처리 : 보너스 번호와 당첨 번호가 같을 경우
- 오름 차순 정렬(6,5,4,3,2,1 -> 1,2,3,4,5,6)

### 로또 번호 생성
- count 만큼 리스트 생성
- 오름차순

### 당첨 내역

- 입력 리스트와 생성리스트 비교
- 수익률 = 당첨금/구입금액 *100

### Domain
#### Lotto
- 로또 객체 생성
  - 로또는 6자리 리스트이다
  - 로또는 중복될 수 없다
  - 로또는 오름차순인 리스트이다

#### LottoNumber
- 로또 번호 객체
  - 로또 번호는 1~45의 번호를 가진다
#### LottoTicket
- 로또티켓 생성
  - 1장은 천원이다.
  - 1회 구입시 최대 10만원까지 구입가능하다.
- 금액을 받고 count를 반환
#### Rank
- 열거형(금액,맞춘 갯수, 보너스 유무)
  - 번호를 맞춘 갯수,보너스 유무로 등수 판정

### Service
#### LottoMachine
- Count를 받는다
  - 받은 count 만큼 랜덤으로 1,45의 숫자를 6개 리스트로 만들어준다
- 로또를 받는다
  - 받은 로또와 count만큼 생성된 로또들과 비교한 
- 랜덤으로 1,45의 숫자를 6개 리스트로 만들어준다
- 생성된 리스트를 로또 객체의 파라미터로 사용한다.
- 로또 객체리스트를 생성하여 count만큼의 로또를 반환하는 메소드가 필요하다.

#### RankingMachine
- lottos를 가져와서 Rank를 매긴다
  - rank별 횟수를 저장
- 수익률 계산

#### 로또 게임
- 