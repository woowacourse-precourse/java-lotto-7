# java-lotto-precourse

## 예외 발생 상황 정의
### 1. 로또 구입 금액 입력 관련
- 입력받은 구입 금액이 1000원 미만이거나, **10만원을 초과하는 경우**
  - 입력받은 구입 금액이 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 구입 금액이 1000원으로 나누어 떨어지지 않는 경우
- 입력이 숫자 형태가 아니거나, 입력에 숫자 외의 문자가 포함되어 있는 경우

### 2. 당첨 번호 입력 관련
- 입력받은 당첨 번호가 6개가 아닌 경우
- 입력받은 당첨 번호 중 숫자 형태가 아니거나, 숫자 외의 문자가 포함되어 있는 것이 존재하는 경우
- 입력받은 당첨 번호 중 1 이상 45 이하의 정수 범위에 해당하지 않는 것이 존재하는 경우
  - 당첨 번호가 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 당첨 번호 중 중복된 수가 존재하는 경우

### 3. 보너스 번호 입력 관련
- 입력받은 보너스 번호가 숫자 형태가 아니거나, 숫자 외의 문자가 포함되어 있는 경우
- 입력받은 보너스 번호가 1 이상 45 이하의 정수 범위에 해당하지 않는 경우
  - 보너스 번호가 int 범위를 초과해 Integer.parseInt() 호출 시 오버 플로우 발생하는 상황에 대한 처리 추가적으로 필요
- 입력받은 보너스 번호가 당첨 번호 중 하나와 중복되는 경우

## 기능 목록
### LottoGame 클래스
int 구입 금액

List\<Lotto> 구매한 로또 번호

Lotto 당첨 번호

int 보너스 번호

- [ ]  public void process()
    - [ ]  buyLottos() 호출해 로또 구매
    - [ ]  setWinningNumbers() 호출해 당첨 번호와 보너스 번호 설정
    - [ ]  showResult() 호출해 당첨 결과 확인
- [ ]  private void buyLottos()
    - [ ]  LottoNumberController.issueLottos() 호출해 구매 액수만큼의 로또 발행
    - [ ]  boughtNumbers의 setter 호출해 발행한 로또 번호 정보 set
- [ ]  private void setWinningNumbers()

### Lotto 클래스
- [ ]  로또 번호를 정렬하는 기능
- [ ]  몇 등 당첨인지 확인하는 기능

### LottoNumberController
- [ ]  public List\<Lotto> issueLottos(int count)
    - [ ]  for (int i = 0; i < count; i++)
        - [ ]  getRandomLottoNumbers() 호출해 로또 번호 6개 추출
        - [ ]  Lotto 객체 생성 → 리스트에 추가
    - [ ]  OutputView.printIssuedLottos() 호출해 발행 결과 출력
    - [ ]  Lotto 객체가 저장된 리스트 반환
- [ ]  public Lotto getWinningNumbers()
    - [ ]  InputView.getWinningNumbers() 호출해 당첨 번호 입력받기
    - [ ]  입력받은 당첨 번호로 Lotto 객체 생성
    - [ ]  Lotto 객체 반환
- [ ]  public int getBonusNumber()
    - [ ]  InputView.getBonusNumbers() 호출해 보너스 번호 입력받기
    - [ ]  보너스 번호 반환

- [ ]  private List\<Integer> getRandomLottoNumbers()
    - [ ]  `camp.nextstep.edu.missionutils.Randoms`의 `pickUniqueNumbersInRange(1, 45, 6)` 호출한 결과 반환

### ResultController
- [ ]  당첨 통계 산정하는 기능
- [ ]  수익률 연산하는 기능

### Validation
- [ ]  구입 금액 검증
- [ ]  당첨 번호 검증
- [ ]  보너스 번호 검증

### enum WinningPrize
int standard

int amount

### InputView
- [ ]  구입 금액을 입력받는 기능
    - [ ]  `구입금액을 입력해 주세요.` 출력
    - [ ]  `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용해 사용자로부터 구입 금액 입력받기
- [ ]  당첨 번호를 입력받는 기능
    - [ ]  `당첨 번호를 입력해 주세요.` 출력
    - [ ]  `camp.nextstep.edu.missionutils.Console`의 `readLine()` 을 활용해 사용자로부터 당첨 번호 입력받기
- [ ]  보너스 번호를 입력받는 기능

### OutputView 클래스
- [ ]  구매한 로또 번호를 출력하는 기능
    - [ ]  `N개를 구매했습니다.` 출력
    - [ ]  로또 번호 생성 메소드 호출
    - [ ]  생성된 로또 번호 출력
- [ ]  당첨 통계를 출력하는 기능