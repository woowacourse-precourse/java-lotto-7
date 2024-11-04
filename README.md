# java-lotto-precourse

# Application Class

- main(String[] args): 애플리케이션의 진입점으로 run() 메서드를 호출하여 실행을 시작합니다.

- run(): 애플리케이션의 주요 흐름을 관리합니다. 구매 금액 입력, 로또 티켓 구매, 당첨 번호 입력, 결과 분석 및 출력이 이 순서대로 진행됩니다.

- getPurchaseCount(): 사용자가 입력한 구매 금액을 통해 로또 티켓 수량을 계산합니다. 예외 발생 시 [ERROR] 메시지를 출력하고 재입력을 요구합니다.

- purchaseLottos(int count): 입력된 수량만큼 로또 티켓을 생성하여 purchasedLottos 리스트에 저장합니다. 각 티켓은 랜덤하게 생성된 번호 6개로 구성됩니다.

- setWinningNumbers(): 당첨 번호와 보너스 번호를 사용자가 입력하도록 합니다. 입력된 당첨 번호는 winningNumbers 리스트에 저장되며, 보너스 번호는 bonusNumber로 저장됩니다.

- showResults(): 각 티켓의 당첨 결과와 수익률을 계산하고, 결과를 출력합니다. calculateRankCounts()와 calculateTotalPrize()를 통해 당첨 통계를 구하고, 이를 기반으로 수익률을 계산합니다.

- calculateRankCounts(): 각 티켓을 순회하며 당첨 등급을 계산하고, 각 등급별로 몇 개의 티켓이 당첨되었는지 카운트하여 맵으로 반환합니다.

- calculateTotalPrize(Map<Rank, Integer> rankCounts): 각 등급의 상금과 해당 등급에 당첨된 티켓 수를 곱하여 총 상금을 계산합니다.

# Lotto Class

- Lotto(List<Integer> numbers): 로또 티켓을 생성하는 생성자입니다. 번호가 6개인지, 중복된 번호가 없는지를 검증합니다. 조건을 만족하지 않으면 예외가 발생합니다.

- validate(List<Integer> numbers): 로또 번호의 유효성을 검사합니다. 6개의 번호가 중복 없이 존재해야 하며, 유효하지 않으면 예외가 발생합니다.

- hasDuplicates(List<Integer> numbers): 로또 번호 중 중복이 있는지를 확인합니다. 중복된 번호가 있는 경우 true를 반환하여 유효성 검사를 도와줍니다.

- countMatchingNumbers(List<Integer> winningNumbers): 로또 티켓의 번호와 당첨 번호를 비교하여 일치하는 번호 개수를 반환합니다.

- containsBonus(int bonusNumber): 로또 티켓에 보너스 번호가 포함되어 있는지를 확인합니다.

- generateRandomLotto(): 1~45 사이의 번호 중 중복 없이 랜덤하게 6개의 숫자를 선택하여 오름차순으로 정렬된 로또 티켓을 생성합니다.

# Rank Enum
> 당첨 등급과 각 등급의 상금을 정의한 Enum입니다.

- Enum 값: THREE_MATCH, FOUR_MATCH, FIVE_MATCH, FIVE_MATCH_BONUS, SIX_MATCH는 각각 일치하는 번호의 개수와 상금을 나타냅니다.

- getPrize(): Enum 값에 따라 상금을 반환합니다.

- getRank(int matchCount, boolean bonusMatch): 일치하는 번호 개수와 보너스 번호 일치 여부에 따라 당첨 등급을 판별하고, 해당 등급의 Enum 값을 반환합니다.

- toString(): 등급 이름과 상금을 사람이 읽기 쉬운 형식으로 반환하여 출력 시 사용합니다.