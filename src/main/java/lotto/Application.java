package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.enums.ErrorMessage;
import lotto.enums.LottoConstants;
import lotto.enums.Rank;
import lotto.service.LottoGenerator;
import lotto.service.WinningNumberInput;
import lotto.service.WinningResultCalculator;
import lotto.util.ValidationUtil;

public class Application {
    public static void main(String[] args) {
        final int purchaseAmount = getPurchaseAmount();
        final int lottoCount = purchaseAmount / LottoConstants.LOTTO_PRICE.getValue();

        System.out.println(lottoCount+"개를 구매했습니다.");

        List<Lotto> lottoTickets = purchaseLottos(lottoCount);
        lottoTickets.forEach(lotto -> {
            List<Integer> sortedNumbers = new ArrayList<>(lotto.getNumbers());
            System.out.println(sortedNumbers);
        });
        System.out.println();

        List<Integer> winningNumbers = getWinningNumbers();
        System.out.println();

        int bonusNumber = getBonusNumber(winningNumbers);
        System.out.println();

        Map<Rank, Integer> statistics = calculateStatistics(lottoTickets, winningNumbers, bonusNumber);

        printStatistics(statistics);

        double yield = calculateYield(statistics, purchaseAmount);
        System.out.print("총 수익률은 " + yield + "%입니다.");
    }

    private static int getPurchaseAmount() {
        int amount;

        while (true) {
            System.out.println("구입금액을 입력해 주세요.");
            String input = Console.readLine();

            try {
                amount = ValidationUtil.validateAmount(input);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println();

        return amount;
    }

    private static List<Lotto> purchaseLottos(final int lottoCount) {
        List<Lotto> lottoTickets = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = Lotto.generateLottoNumber();
            lottoTickets.add(lotto);
        }
        return lottoTickets;
    }

    private static List<Integer> getWinningNumbers() {
        while (true) {
            System.out.println("당첨 번호를 입력해 주세요.");
            String input = Console.readLine().trim();

            try {
                return WinningNumberInput.getWinningNumbers(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private static int getBonusNumber(List<Integer> winningNumbers) {
        while (true) {
            System.out.println("보너스 번호를 입력해 주세요:");
            String input = Console.readLine().trim();

            try {
                return WinningNumberInput.getBonusNumber(input, winningNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    static Map<Rank, Integer> calculateStatistics(List<Lotto> lottoTickets, List<Integer> winningNumbers,
                                                  int bonusNumber) {
        Map<Rank, Integer> statistics = new EnumMap<>(Rank.class);

        for (Lotto lotto : lottoTickets) {
            Rank rank = WinningResultCalculator.calculateResult(lotto, winningNumbers, bonusNumber);
            statistics.put(rank, statistics.getOrDefault(rank, 0) + 1);
        }

        return statistics;
    }

    static double calculateYield(Map<Rank, Integer> statistics, int purchaseAmount) {
        int totalPrize = 0;
        for (Map.Entry<Rank, Integer> entry : statistics.entrySet()) {
            Rank rank = entry.getKey();
            int count = entry.getValue();
            totalPrize += rank.getPrize() * count;
        }
        double yield = (double) totalPrize / purchaseAmount * 100;

        return Math.round(yield * 10) / 10.0;
    }

    private static void printStatistics(Map<Rank, Integer> statistics) {
        System.out.println("당첨 통계\n---");

        List<Rank> sortedRanks = List.of(Rank.FIFTH, Rank.FOURTH, Rank.THIRD, Rank.SECOND, Rank.FIRST);
        for (Rank rank : sortedRanks) {
            int count = statistics.getOrDefault(rank, 0);
            if (!rank.getDisplayText().isEmpty()) {
                System.out.printf("%s - %d개\n", rank.getDisplayText(), count);
            }
        }
    }

}
