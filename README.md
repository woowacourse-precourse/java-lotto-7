# java-lotto-precourse

- 개선점 - MainService의 분리, 좀 더 작은 단위로 분리, 테스트 코드 용이를 위해 Collection 미사용


- [x] Controller
  - [x] LottoController
  - [x] ExceptionController
- [x] LottoMainService
- [x] Model
  - [x] Lotto
    - [x] LottoDTO
    - [x] LottoDAO
  - [x] HitLotto
    - [x] HitLottoDTO
  - [x] StatisticsLotto
    - [x] StatisticsLottoDTO
    - [x] StatisticsLottoDAO
- [x] View
  - [x] inputView
  - [x] outputView
- [x] Enum
  - [x] LottoPrize


- 금액 입력 받기(readline)
- 금액 확인(errorcheck)
- 금액 나누기(/1000)
    - 입력된 금액을 파싱
    - 입력된 숫자 나누기 1000
    - 해당 값을 보내기
- 해당 값 만큼 로또 번호 뽑기
    - 값=i로 반복
    - 만들어진 값 리스트에 넣고 오름차순 정렬
    - 매 반복마다 Lotto 객체로 보내기
- 리스트 1차출력
    - Lotto 받아오기
    - view로 전달해주기
- 당첨 번호 입력 받기(readline),
- 에러 확인(errorcheck)
- 추가 번호 입력 받기(readline)
- 에러 확인(errorcheck)
- 당첨 번호 종합 리스트 만들기
    - 당첨 번호와 보너스 번호 합한 값 HitLotto 저장하기
- 일치 확인
    - 불러온 Lotto값이 HitLotto 리스트 내의 원소 중 일치하는지 확인
    - 몇개 일치했는지 확인 후 갱신하는 통계 객체로 보내기
- 수익 계산
    - cost와 통계 객체로부터 enum을 통해 수익 계산하기
- 통계수익 출력
    - 통계 객체에서 컨트롤러를 통해 view로 넘기기


- [ ] 예외처리
- [x] 구매 값이 공백인 경우
- [x] 구매 값이 빈값인 경우
- [x] 구매 값에 사이에 공백이 들어간 경우
- [x] 구매 값이 숫자가 아닌 경우
- [x] 구매 값이 1000단위가 아닌 경우
- [x] 구매 값이 long값을 넘어간 경우
- [x] 구매 값이 양수가 아닌 경우
- [x] 당첨 로또 값이 1~45 그리고 ,외에 다른것이 들어간 경우
- [x] 당첨 로또 값이 공백, 빈값, 사이 공백이 들어간 경우
- [x] 당첨 로또 값이 6개 초과로 입력된 경우
- [x] 당첨 로또 값이 숫자가 1~ 45가 아닌 경우
- [x] 당첨 로또 값이 중복된 값이 있는 경우
- [x] 보너스 번호 값이 1~45 외에 다른 것이 들어간 경우
- [x] 보너스 번호 값이 공백, 빈값, 사이 공백이 들어간 경우
- [x] 보너스 번호 값이 3자리 이상 입력된 경우
- [x] 보너스 번호 값이 당첨 로또에 들어간 번호 중 하나인 경우


