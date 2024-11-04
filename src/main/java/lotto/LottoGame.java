package lotto;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;

    public static int validatePurchaseAmount(String input) {
        int amount = Integer.parseInt(input);
        if (amount % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
        return amount;
    }

    public static List<Lotto> buyLottoTickets(int amount) {
        int ticketCount = amount / LOTTO_PRICE;
        List<Lotto> tickets = new ArrayList<>();
        for (int i = 0; i < ticketCount; i++) {
            List<Integer> numbers = Lotto.generateLottoNumbers();
            tickets.add(new Lotto(numbers));
        }
        return tickets;
    }

    public static List<Integer> getWinningNumbers(String input) {
        List<String> parts = Arrays.asList(input.split(","));
        List<Integer> winningNumbers = new ArrayList<>();
        for (String part : parts) {
            winningNumbers.add(Integer.parseInt(part.trim()));
        }
        return winningNumbers;
    }

    public static int getBonusNumber(String input) {
        return Integer.parseInt(input.trim());
    }

    public static Map<String, Integer> calculateWinnings(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        Map<String, Integer> statistics = new HashMap<>();
        for (Lotto lotto : purchasedLottos) {
            int matchCount = (int) lotto.getNumbers().stream()
                    .filter(winningNumbers::contains)
                    .count();
            String key = matchCount + "개 일치";
            if (matchCount == 5 && lotto.getNumbers().contains(bonusNumber)) {
                key = "5개 일치, 보너스 볼 일치";
            } else if (matchCount == 6) {
                key = "6개 일치";
            }
            statistics.put(key, statistics.getOrDefault(key, 0) + 1);
        }
        return statistics;
    }

    public static void printStatistics(Map<String, Integer> winnings, int amount) {
        Map<String, Integer> prizeMoney = Map.of(
                "3개 일치", 5000,
                "4개 일치", 50000,
                "5개 일치", 1500000,
                "5개 일치, 보너스 볼 일치", 30000000,
                "6개 일치", 2000000000
        );

        int totalWinnings = 0;
        NumberFormat currencyFormat = NumberFormat.getNumberInstance(Locale.KOREA);

        for (Map.Entry<String, Integer> entry : winnings.entrySet()) {
            String matchType = entry.getKey();
            int count = entry.getValue();
            int prize = prizeMoney.getOrDefault(matchType, 0);
            System.out.printf("%s (%s원) - %d개\n", matchType, currencyFormat.format(prize), count);
            totalWinnings += prize * count;
        }

        double profitRate = ((double) totalWinnings / amount) * 100;
        System.out.printf("총 수익률은 %.1f%%입니다.\n", profitRate);
    }
}
