package lotto;

import camp.nextstep.edu.missionutils.Console;
import lotto.entity.Consumer;
import lotto.entity.LottoYieldCalculator;
import lotto.entity.Rank;
import lotto.entity.WinningLotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Application {
    public static void main(String[] args) {
        Consumer consumer = new Consumer();
        int totalCost = consumer.getTotalLottoCost();
        List<List<Integer>> userTickets = consumer.getLottoTickets();
        LottoYieldCalculator calculator = new LottoYieldCalculator(totalCost);

        Set<Integer> winningNumbers = getWinningNumbers();
        int bonusNumber = getBonusNumber();

        WinningLotto winningLotto = new WinningLotto(winningNumbers, bonusNumber);
        int[] matchCounts = calculateMatchCounts(userTickets, winningLotto, calculator);

        printStatistics(matchCounts);
        printYield(calculator);
    }

    private static Set<Integer> getWinningNumbers() {
        Set<Integer> winningNumbers = new HashSet<>();
        System.out.println("당첨 번호를 입력해 주세요.");
        String[] winningInput = Console.readLine().split(",");
        for (String number : winningInput) {
            winningNumbers.add(Integer.parseInt(number.trim()));
        }
        return winningNumbers;
    }

    private static int getBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요. ");
        return Integer.parseInt(Console.readLine().trim());
    }

    private static int[] calculateMatchCounts(List<List<Integer>> userTickets, WinningLotto winningLotto, LottoYieldCalculator calculator) {
        int[] matchCounts = new int[6]; // 0~5개 일치하는 경우 (6번째는 없음)

        for (List<Integer> userNumbers : userTickets) {
            Rank rank = winningLotto.getRank(new HashSet<>(userNumbers));
            matchCounts[rank.ordinal()]++;
            calculator.addPrize(rank.getPrize());
        }
        return matchCounts;
    }

    private static void printStatistics(int[] matchCounts) {
        System.out.println("당첨 통계");
        System.out.println("---");
        System.out.printf("3개 일치 (5,000원) - %d개\n", matchCounts[Rank.FIFTH.ordinal()]);
        System.out.printf("4개 일치 (50,000원) - %d개\n", matchCounts[Rank.FOURTH.ordinal()]);
        System.out.printf("5개 일치 (1,500,000원) - %d개\n", matchCounts[Rank.THIRD.ordinal()]);
        System.out.printf("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개\n", matchCounts[Rank.SECOND.ordinal()]);
        System.out.printf("6개 일치 (2,000,000,000원) - %d개\n", matchCounts[Rank.FIRST.ordinal()]);
    }

    private static void printYield(LottoYieldCalculator calculator) {
        System.out.printf("총 수익률은 %.0f%%입니다.\n", (double) Math.round(calculator.calculateYield()));
    }
}
