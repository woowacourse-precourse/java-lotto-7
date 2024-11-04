package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;

    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
            printLottos(purchasedLottos);
            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber(winningNumbers);
            displayResults(purchasedLottos, winningNumbers, bonusNumber);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 올바르지 않습니다.");
        }
    }

    private static void validatePurchaseAmount(int amount) {
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

    public static List<Lotto> generateLottos(int amount) {
        int numberOfLottos = amount / LOTTO_PRICE;
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < numberOfLottos; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottos;
    }

    public static void printLottos(List<Lotto> lottos) {
        System.out.println(lottos.size() + "개를 구매했습니다.");
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine();
        return parseWinningNumbers(input);
    }

    private static List<Integer> parseWinningNumbers(String input) {
        List<Integer> winningNumbers = parseNumbers(input);
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        return winningNumbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        validateBonusNumber(bonusNumber, winningNumbers);
        return bonusNumber;
    }

    private static void validateBonusNumber(int bonusNumber, List<Integer> winningNumbers) {
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며 당첨 번호와 중복되지 않아야 합니다.");
        }
    }

    public static List<Integer> parseNumbers(String input) {
        try {
            return List.of(input.split(","))
                    .stream()
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 번호는 숫자여야 합니다.");
        }
    }

    public static void displayResults(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = countMatchesForAllLottos(lottos, winningNumbers, bonusNumber);
        printResults(matchCounts, lottos.size());
    }

    private static int[] countMatchesForAllLottos(List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        int[] matchCounts = new int[Prize.values().length];
        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            Prize prize = Prize.getPrizeByMatch(matchCount, lotto.getNumbers().contains(bonusNumber));
            if (prize != null) {
                matchCounts[prize.ordinal()]++;
            }
        }
        return matchCounts;
    }

    public static int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream().filter(winningNumbers::contains).count();
    }

    public static void printResults(int[] matchCounts, int totalLottos) {
        System.out.println("당첨 통계\n---");
        for (Prize prize : Prize.values()) {
            if (matchCounts[prize.ordinal()] > 0) {
                System.out.printf(prize.getMessage(), matchCounts[prize.ordinal()]);
            }
        }
        double profitRate = calculateProfitRate(matchCounts, totalLottos);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public static double calculateProfitRate(int[] matchCounts, int totalLottos) {
        int totalPrize = 0;
        for (Prize prize : Prize.values()) {
            totalPrize += matchCounts[prize.ordinal()] * prize.getPrizeAmount();
        }
        return Math.round((totalPrize / (double) (totalLottos * LOTTO_PRICE)) * 1000) / 10.0;
    }
}

// 상금과 매칭 개수를 나타내는 Enum 정의
enum Prize {
    THREE_MATCHES(3, 5000, "3개 일치 (%,d원) - %d개\n"),
    FOUR_MATCHES(4, 50000, "4개 일치 (%,d원) - %d개\n"),
    FIVE_MATCHES(5, 1500000, "5개 일치 (%,d원) - %d개\n"),
    FIVE_MATCHES_WITH_BONUS(5, 30000000, "5개 일치, 보너스 볼 일치 (%,d원) - %d개\n", true),
    SIX_MATCHES(6, 2000000000, "6개 일치 (%,d원) - %d개\n");

    private final int matchCount;
    private final int prizeAmount;
    private final String message;
    private final boolean requiresBonus;

    Prize(int matchCount, int prizeAmount, String message) {
        this(matchCount, prizeAmount, message, false);
    }

    Prize(int matchCount, int prizeAmount, String message, boolean requiresBonus) {
        this.matchCount = matchCount;
        this.prizeAmount = prizeAmount;
        this.message = message;
        this.requiresBonus = requiresBonus;
    }

    public int getPrizeAmount() {
        return prizeAmount;
    }

    public String getMessage() {
        return message;
    }

    public static Prize getPrizeByMatch(int matchCount, boolean bonusMatch) {
        for (Prize prize : Prize.values()) {
            if (prize.matchCount == matchCount && (!prize.requiresBonus || bonusMatch)) {
                return prize;
            }
        }
        return null;
    }
}
