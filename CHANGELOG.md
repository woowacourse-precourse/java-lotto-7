#### 2024-11-03

##### Chores

* **$ cr:**  깃허브 자동 리뷰 (b05105c9)

##### Documentation Changes

* **$ README:**
  *  문서 업데이트 (e45e702a)
  *  문서 업데이트 (843d6c0c)
  *  문서 초안 작성 (db75b188)

##### New Features

* **$ Application:**  기능 실행 구현 (d5d1d0a2)
* **$ ResultMarginDTO:**  로또게임 결과, 이익 전달 객체추 가 (89207184)
* **$ PublishedLottoDTO:**  티켓과 랜덤로또 전달 객체 구현 (38207e86)
* **$ Constants:**
  *  상수 추가 (11d8e319)
  *  상수 추가 (85a89949)
  *  상수 추가 (2d0ea7e6)
* **$ LottoController:**  사용자 입력 로또 6자리 검증 수행 (541ccedc)
* **$ UnitConverter:**
  *  단위 표기 기능 구현 (57dee0f0)
  *  숫자 단위 추가 기능 테스트 (ad0f362b)
  *  숫자 단위 추가 기능 구현 (0e2b19f6)
* **$ MarginCalculator:**  이익 계산기 기능 구현 (c9e183a9)
* **$ Lotto:**
  *  정렬 기능 추가 (1717e70f)
  *  숫자 검증 기능 추가 (cb97ac4c)
  *  로또 비교 메서드 구현 (70ccab4a)
  *  숫자 포함 확인 기능 구현 (bd981c42)
  *  로또 클래스 구현 (c7803d04)
* **$ UserLotto:**
  *  보너스 숫자 검증 추가 (debe315a)
  *  getter 추가 (677962cf)
  *  사용자 입력 로또 구현 (6f931d42)
* **$ NumberValidator:**  숫자 검증 기능 구현 (4e1982bf)
* **$ LottoGameController:**  컨트롤러 초안 구현 (e1d9e352)
* **$ MargineCalculator:**  수익률 계산 클래스 구현 (205f5292)
* **$ UserLottoDTO:**  유저 로또, 보너스 넘버 전달 객체 구현 (b1b5ef71)
* **$ UserSixNumberDTO:**  유저 로또 전달 객체 구현 (87578856)
* **$ UserMoneyLottotDTO:**  유저 돈, 티켓 전달 객체 구현 (8ea8f554)
* **$ OutputView:**
  *  로또 출력 기능 수정 (5e1d17fe)
  *  출력 UI 구현 (8d361e14)
* **$ LottoComparator:**  로또 비교 기능 클래스 구현 (6b41e008)
* **$ Prizes:**
  *  상 추가 코멘트 구현 (40eb04fa)
  *  prizes의 보너스 기능 추가 (408d805a)
  *  로또 상 구현 (cff4fcb5)
* **$ LottoResult:**  로또 결과 클래스 구현 (fe894a9f)
* **$ LottoBowl:**  여러개의 랜덤 로또 발급 서비스 구현 (4e10d9fd)
* **$ Ticket:**  티켓 클래스 구현 (2e050946)
* **$ Lotties:**  Lotto 일급컬렉션 구현 (facfd6a5)
* **$ InputView:**  사용자 입력기능 구현 (1ce23e02)
* **$ StringSplitter:**  구분자 나누기 유틸 클래스 구현 (837f9fec)
* **$ MoneyTest:**  Money 테스트 (98cb8311)
* **$ Money:**  돈 객체 구현 (d27e31ad)
* **$ ErrorMessages:**
  *  에러 메시지 추가 (9b9ab261)
  *  에러 메시지 구현 (7949d0ca)
* **$ RandomNumberGenerator:**  랜덤 정수 반환 기능 구현 (71ed0f13)
* **$ OutputMessages:**  출력 메시지 구현 (c3c6ab48)
*  setup project (99b19647)

##### Refactors

* **$ LottoGameController:**  메서드 분리 (d35cdace)
* **$ LottoComparator:**  인스턴스 변수 자료형 수정 (94540e4a)
* **$ UserMoneyDTO:**  전달 객체 수정 (b17d6957)
* **$ LottoResult:**  메서드 기능 분리 (9fb5dc05)
* **$ ErrorMessages:**
  *  에러 문구 수정 (5fe6fd93)
  *  에러 메시지 수정 (35c98a8e)
  *  애매한 표현 수정 (9c15d6e1)
* **$ All:**  매직넘버 제거 (5a8db153)
* **$ Money:**  메서드명 변경 및 매직넘버 제거 (df755401)
* **$ NumberValidator:**  숫자 검증 추가 (a42b6cb0)
* **$ InputvView:**  사용자 검증 수정 (421da4a1)
* **$ OutputView:**  로또 정렬 기능 삭제 (0ec054ab)
* **$ Prizes:**  상 순서 변경 (458630df)
* **$ OutputMessages:**
  *  문구 수정 (6f5ef4d2)
  *  사용하지 않는 상수 제거 (8658d846)

##### Tests

* **$ UnitConverter:**  단위 표기 기능 테스트 (2ec34c66)
* **$ UserLottoTest:**
  *  보너스 숫자 검증 테스트 (4c41a06b)
  *  사용자 입력 로또 테스트 (67ab8bd8)
* **$ LottoTest:**
  *  숫자 검증 테스트 (c05cf51b)
  *  로또 비교 메서드 테스트 (3bc7fb8e)
  *  숫자 포함 확인 기능 테스트 (e2d7c0be)
* **$ NumberValidatorTest:**  숫자 검증 기능 테스트 (98c1fe59)
* **$ LottoResult:**  로또 결과 클래스 테스트 (8374c346)
* **$ TicketTest:**  티켓 클래스 테스트 (9b3d2709)
* **$ StringSplitterTest:**  구분자 나누기 유틸 클래스 테스트 (3cd4e5fb)
* **$ LottoTset:**  로또 클래스 테스트 (602aabfa)

