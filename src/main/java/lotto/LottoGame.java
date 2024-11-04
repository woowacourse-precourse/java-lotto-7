package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.*;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final List<Lotto> lottos = new ArrayList<>();
    private Lotto winningLotto;
    private int bonusNumber;

    // 1. 구입 금액 입력 및 검증
    public int getPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine();
        return parseAndValidateAmount(input);
    }

    // 매개변수를 통해 금액을 입력받는 새로운 메서드 (테스트용)
    public int parseAndValidateAmount(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 숫자여야 합니다.");
        }

        int amount = Integer.parseInt(input);
        validateAmount(amount);
        return amount / LOTTO_PRICE;
    }

    private boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private void validateAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    // 2. 로또 발행 및 출력
    public void purchaseLottos(int quantity) {
        for (int i = 0; i < quantity; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            lottos.add(new Lotto(numbers));
        }
        System.out.printf("%d개를 구매했습니다.%n", quantity);
        printLottoNumbers();
        System.out.println();
    }

    private void printLottoNumbers() {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    // 3. 당첨 번호 및 보너스 번호 입력 및 검증
    public void inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        List<Integer> numbers = parseNumbers(Console.readLine());
        winningLotto = new Lotto(numbers);  // Lotto 생성 시 검증 포함
        System.out.println();
    }

    public void inputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber();
        System.out.println();
    }

    private List<Integer> parseNumbers(String input) {
        return Arrays.stream(input.split(","))
                .map(Integer::parseInt)
                .toList();
    }

    private void validateBonusNumber() {
        if (bonusNumber < 1 || bonusNumber > 45 || winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며, 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    // 4. 당첨 결과 계산 및 결과 출력
    public void calculateAndPrintResults() {
        Map<String, Integer> rankCount = initializeRankCount();
        int totalPrize = calculateTotalPrizeAndRankCount(rankCount);

        printResults(rankCount);
        printProfitRate(totalPrize);
    }

    private Map<String, Integer> initializeRankCount() {
        Map<String, Integer> rankCount = new HashMap<>();
        for (Rank rank : Rank.values()) {
            rankCount.put(rank.name(), 0);
        }
        return rankCount;
    }

    private int calculateTotalPrizeAndRankCount(Map<String, Integer> rankCount) {
        int totalPrize = 0;
        for (Lotto lotto : lottos) {
            int matchCount = getMatchCount(lotto.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            rankCount.put(rank.name(), rankCount.getOrDefault(rank.name(), 0) + 1);
            totalPrize += rank.getPrize();
        }
        return totalPrize;
    }

    private int getMatchCount(List<Integer> lottoNumbers) {
        return (int) lottoNumbers.stream().filter(winningLotto.getNumbers()::contains).count();
    }

    private void printResults(Map<String, Integer> rankCount) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개%n", rankCount.getOrDefault("FIFTH", 0));
        System.out.printf("4개 일치 (50,000원) - %d개%n", rankCount.getOrDefault("FOURTH", 0));
        System.out.printf("5개 일치 (1,500,000원) - %d개%n", rankCount.getOrDefault("THIRD", 0));
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개%n", rankCount.getOrDefault("SECOND", 0));
        System.out.printf("6개 일치 (2,000,000,000원) - %d개%n", rankCount.getOrDefault("FIRST", 0));
    }

    private void printProfitRate(int totalPrize) {
        int totalCost = lottos.size() * LOTTO_PRICE;
        double profitRate = (double) totalPrize / totalCost * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);
    }
}
