# java-lotto-precourse

## 기능 목록
- [ ] 입력 화면(InputView)
    - [x] 구매 금액 입력
    - [x] 구매 로또 개수 계산
    - [ ] 당첨번호 입력
    - [ ] 보너스 번호 입력
- [ ] 로또 생성(LottoUniqueGenerator)
    - [x] pickUniqueNumbersInRange()를 통해 생성
    - [x] 오름차순 정렬
- [ ] 전체 당첨 여부(MyLotto)
- [ ] 하나의 로또 당첨 여부(Lotto)
- [ ] 당첨 통계(LottoResultStatistic)
    - [ ] 당첨 통계
    - [ ] 수익률 계산
- [ ] 상금 당첨여부 반환(Prize)
  - [ ] 2, 3등 구분
- [ ] 당첨 화면(ResulView)

예외 처리
- [x] 구매 금액 1000원 미만
- [x] 로또 한장 내 중복 번호 있을 시
- [x] 로또 한장이 숫자가 6개가 아닐 경우
- [x] 당첨번호 입력 형식 
  - ex)
  - 1, 2, 3 ,4, 5,6
  - 1^2,3,4,5,6
  - -1,2,3,4,5,6
  - 1,2,3,4,5,46
  - 1,2,3,4,5,6,
