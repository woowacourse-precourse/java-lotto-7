package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = Integer.parseInt(Console.readLine());

            int ticketCount = calculateTicketCount(purchaseAmount);
            System.out.println(ticketCount + "개를 구매했습니다.");

            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());

            LottoValidator.validateWinningNumbers(winningNumbers, bonusNumber);

            List<Lotto> userLottos = generateUserLottos(ticketCount);
            printLottoNumbers(userLottos);

            int[] matchCounts = LottoResultCalculator.calculateResults(userLottos, winningNumbers, bonusNumber);
            printResults(matchCounts);

            double profitRate = calculateProfitRate(matchCounts, purchaseAmount);
            System.out.printf("총 수익률은 %.2f%%입니다.%n", profitRate);

        } catch (NumberFormatException e) {
            System.out.println(ErrorMessages.INVALID_INPUT.getMessage());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static void printResults(int[] matchCounts) {
        System.out.println("당첨 통계\n---");
        for (LottoRank rank : LottoRank.values()) {
            if (rank != LottoRank.MISS) {
                System.out.printf("%d개 일치 (%d원) - %d개%n", rank.getMatchCount(), rank.getPrize(), matchCounts[rank.ordinal()]);
            }
        }
    }

    public static int calculateTicketCount(int purchaseAmount) {
        final int TICKET_PRICE = 1000;
        if (purchaseAmount % TICKET_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessages.INVALID_AMOUNT.getMessage());
        }
        return purchaseAmount / TICKET_PRICE;
    }

    private static List<Lotto> generateUserLottos(int ticketCount) {
        return java.util.stream.IntStream.range(0, ticketCount)
                .mapToObj(i -> Lotto.generateLotto())
                .collect(Collectors.toList());
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }

    public static double calculateProfitRate(int[] matchCounts, int purchaseAmount) {
        long totalPrize = 0;
        for (LottoRank rank : LottoRank.values()) {
            totalPrize += (long) matchCounts[rank.ordinal()] * rank.getPrize();
        }
        BigDecimal profitRate = BigDecimal.valueOf((double) totalPrize / purchaseAmount * 100);
        return profitRate.setScale(2, RoundingMode.HALF_UP).doubleValue();
    }
}
