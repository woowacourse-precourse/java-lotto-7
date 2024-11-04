package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            int purchaseAmount = inputPurchaseAmount();
            List<Lotto> lottos = purchaseLottos(purchaseAmount);

            printLottos(lottos);

            List<Integer> winningNumbers = inputWinningNumbers();
            int bonusNumber = inputBonusNumber(winningNumbers);

            Map<Rank, Integer> result = calculateResults(lottos, winningNumbers, bonusNumber);

            printResult(result, purchaseAmount);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        String input = Console.readLine().trim();

        try {
            int amount = Integer.parseInt(input);
            Validator.validatePurchaseAmount(amount);
            return amount;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 유효한 금액을 입력해 주세요.");
        }
    }

    private static List<Lotto> purchaseLottos(int purchaseAmount) {
        int lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");

        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6)
                    .stream().sorted().collect(Collectors.toList());
            lottos.add(new Lotto(numbers));
        }
        return lottos;
    }

    private static void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    private static List<Integer> inputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        return Validator.validateWinningNumbers(input);
    }

    private static int inputBonusNumber(List<Integer> winningNumbers) {
        System.out.println("보너스 번호를 입력해 주세요.");
        String input = Console.readLine().trim();
        return Validator.validateBonusNumber(input, winningNumbers);
    }

    private static Map<Rank, Integer> calculateResults(
            List<Lotto> lottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<Rank, Integer> result = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottos) {
            int matchCount = (int) lotto.getNumbers().stream().filter(winningNumbers::contains).count();
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);
            Rank rank = Rank.valueOf(matchCount, bonusMatch);
            result.put(rank, result.getOrDefault(rank, 0) + 1);
        }
        return result;
    }

    private static void printResult(Map<Rank, Integer> result, int purcahseAmount) {
        System.out.println("당첨 통계\n---");
        double totalEarnings = 0;

        for (Rank rank : Rank.values()) {
            if (rank == Rank.NONE) {
                continue; // Rank.NONE은 출력하지 않음
            }
            int count = result.getOrDefault(rank, 0);
            System.out.println(rank.getMatchMessage() + " - " + count + "개");
            totalEarnings += rank.getPrize() * count;
        }

        double yield = (totalEarnings / purcahseAmount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", yield);
    }
}