package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    private static final int LOTTO_PRICE = 1000;
    private static final int[] PRIZE_AMOUNTS = {0, 0, 0, 5000, 50000, 1500000, 2000000000};

    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            List<Lotto> purchasedLottos = generateLottos(purchaseAmount);
            // 이후 기능 구현
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            int amount = Integer.parseInt(Console.readLine());
            if (amount % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
            }
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 입력 금액이 올바르지 않습니다.");
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
        List<Integer> winningNumbers = parseNumbers(input);
        if (winningNumbers.size() != 6) {
            throw new IllegalArgumentException("[ERROR] 당첨 번호는 6개여야 합니다.");
        }
        return winningNumbers;
    }

    public static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        int bonusNumber = Integer.parseInt(Console.readLine());
        if (bonusNumber < 1 || bonusNumber > 45 || winningNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1부터 45 사이의 숫자여야 하며 당첨 번호와 중복되지 않아야 합니다.");
        }
        return bonusNumber;
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
        int[] matchCounts = new int[7];
        for (Lotto lotto : lottos) {
            int matchCount = countMatches(lotto.getNumbers(), winningNumbers);
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                matchCounts[5]++;
            } else if (matchCount >= 3) {
                matchCounts[matchCount]++;
            }
        }
        printResult(matchCounts, lottos.size());
    }

    public static int countMatches(List<Integer> userNumbers, List<Integer> winningNumbers) {
        return (int) userNumbers.stream().filter(winningNumbers::contains).count();
    }

    public static void printResult(int[] matchCounts, int totalLottos) {
        System.out.println("당첨 통계\n---");
        System.out.printf("3개 일치 (%,d원) - %d개\n", PRIZE_AMOUNTS[3], matchCounts[3]);
        System.out.printf("4개 일치 (%,d원) - %d개\n", PRIZE_AMOUNTS[4], matchCounts[4]);
        System.out.printf("5개 일치 (%,d원) - %d개\n", PRIZE_AMOUNTS[5], matchCounts[5]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[5]);
        System.out.printf("6개 일치 (%,d원) - %d개\n", PRIZE_AMOUNTS[6], matchCounts[6]);

        double profitRate = calculateProfitRate(matchCounts, totalLottos);
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }

    public static double calculateProfitRate(int[] matchCounts, int totalLottos) {
        int totalPrize = matchCounts[3] * PRIZE_AMOUNTS[3] +
                matchCounts[4] * PRIZE_AMOUNTS[4] +
                matchCounts[5] * 30000000 +
                matchCounts[6] * PRIZE_AMOUNTS[6];
        double profitRate = (totalPrize / (double) (totalLottos * LOTTO_PRICE)) * 100;
        return Math.round(profitRate * 10) / 10.0;
    }
}