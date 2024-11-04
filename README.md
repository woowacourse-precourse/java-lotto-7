# java-lotto-precourse

&nbsp;

### 1. 🔢로또 금액 입력 및 당첨번호, 보너스 번호 입력   
  - [x] **InputView 클래스:**
    - requestPurchaseAmount() : 구매 금액 입력
    - requestWinningNumbers() : 당첨 번호 입력
    - requestBonusNumber() : 보너스 번호 입력

&nbsp;

### 2. 🎰로또 번호 랜덤 생성 
  - [x] **Lotto 클래스:** 
    - List<Integer> numbers를 필드로 갖고 생성할 때 유효성 검사를 진행
  - [x] **LottoGenerator 클래스:**
    - generate() : 랜덤 로또 번호 생성
  - [x] **LottoValidator 클래스:**
    - 로또 번호 개수, 로또 번호 범위, 로도 번호 중복 여부 유효성 검사
    - 보너스 번호 범위, 보너스 번호 중복 여부 유효성 검사

&nbsp;
    
### 3. 💸당첨 결과 확인 및 수익률 계산
  - [x] **WinningLotto 클래스:**
    - Lotto타입 winningLotto와, int타입 bonusNumber를 필드로 갖고 생성할 때 유효성 검사 진행
    - 당첨 번호를 가지고 있음
  - [x] **LottoResult 클래스:**
    - userLottos, winningLotto를 비교하여 당첨 결과 계산
    - calculateResult() : 당첨 로또와 몇 개 일치하는지 계산 후 등수 확인
    - calculateTotalPrize() : 총 상금 계산
    - calculateProfitRate() : 수익률 계산
  - [x] **Rank Enum:**
    - matchCount, matchBonus를 기준으로 당첨 순위 계산
    - SORTED_RANKS : 당첨 순위 순서 정렬
    - getFormattedPrize() : 금액을 알맞은 포맷으로 변경

&nbsp;
  
### 4. 📝결과 출력
  - [x] **OutputView 클래스:**
    - printLottoPurchaseInfo() : 로또 구매 정보 출력
    - printWinningStatistics() : 당첨 결과 출력
    - printRateOfReturn() : 수익률 출력

&nbsp;

### 5. ❗️예외 처리
  - [x] **InputView 클래스:**
    - requestPurchaseAmount():
      - 숫자가 아닌 값 입력: IllegalArgumentException, "[ERROR] 금액은 숫자로 입력해야 합니다." 출력
      - 잘못된 단위 입력: IllegalArgumentException, "[ERROR] 구입 금액은 1,000원 단위여야 합니다." 출력
    - requestWinningNumbers():
      - 숫자가 아닌 값 입력: IllegalArgumentException, "[ERROR] 당첨 번호는 숫자로 입력해야 합니다." 출력
      - 6개 번호가 아닌 경우: IllegalArgumentException, "[ERROR] 당첨 번호는 6개의 숫자여야 합니다." 출력
      - 1~45 범위 벗어남: IllegalArgumentException, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." 출력
      - 중복된 번호: IllegalArgumentException, "[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다." 출력
    - requestBonusNumber():
      - 숫자가 아닌 값 입력: IllegalArgumentException, "[ERROR] 보너스 번호는 숫자로 입력해야 합니다." 출력
      - 1~45 범위 벗어남: IllegalArgumentException, "[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 합니다." 출력
      - 당첨 번호와 중복: IllegalArgumentException, "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않아야 합니다." 출력
  - [x] **Lotto 클래스:**
    - 번호 개수 유효성 검사:
      - 로또 번호 개수가 6개가 아닐 경우 IllegalArgumentException, "[ERROR] 로또 번호는 6개의 숫자여야 합니다." 출력
    - 번호 범위 검사:
      - 1~45 범위를 벗어나는 번호가 있을 경우 IllegalArgumentException, "[ERROR] 로또 번호는 1부터 45 사이의 숫자여야 합니다." 출력
    - 중복 검사:
      - 중복된 번호가 있을 경우 IllegalArgumentException, "[ERROR] 로또 번호에는 중복된 숫자가 없어야 합니다." 출력
  
&nbsp;

### 6. ✅테스트 코드 작성
  - [x] **ApplicationTest 클래스:**
    - 통합 테스트로 기능과 예외 상황을 검증
    - 구매 금액, 당첨 번호, 보너스 번호에 대해 잘못된 입력과 그로 인한 예외 메시지를 확인하는 테스트를 포함
    - 기능_테스트(), 예외_테스트_유효하지_않은_문자_입력(), 예외_테스트_잘못된_단위_입력(), 예외_테스트_잘못된_형식_당첨번호()
  - [x] **LottoTest 클래스:**
    - 로또 번호 생성 시 유효성 검사를 포함한 예외 사항을 검증
    - 로또 번호의 개수가 6개가 아닐 때, 중복된 숫자가 있을 때, 범위를 벗어나는 숫자가 있을 때 각 예외가 발생하는지 확인
    - 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다(), 로또_번호에_중복된_숫자가_있으면_예외가_발생한다(), 로또_번호_정상_생성(), 로또_번호_개수_예외(), 로또_번호_중복_예외(), 로또_번호_범위_예외(), 보너스번호_범위_예외(), 보너스번호_중복_예외()
