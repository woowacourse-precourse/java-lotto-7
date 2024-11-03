package lotto.controller;

import camp.nextstep.edu.missionutils.Console;
import lotto.domain.Lotto;
import lotto.domain.LottoRank;
import lotto.domain.TicketCalculator;
import lotto.service.LottoResultCalculator;
import lotto.service.ProfitCalculator;
import lotto.util.ErrorMessages;
import lotto.util.LottoValidator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("구입금액을 입력해 주세요.");
            int purchaseAmount = Integer.parseInt(Console.readLine());

            int ticketCount = TicketCalculator.calculateTicketCount(purchaseAmount);
            System.out.println(ticketCount + "개를 구매했습니다.");

            List<Lotto> userLottos = generateUserLottos(ticketCount);
            printLottoNumbers(userLottos);

            System.out.println("당첨 번호를 입력해 주세요.");
            List<Integer> winningNumbers = Arrays.stream(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toList());

            System.out.println("보너스 번호를 입력해 주세요.");
            int bonusNumber = Integer.parseInt(Console.readLine());

            LottoValidator.validateWinningNumbers(winningNumbers, bonusNumber);

            int[] matchCounts = LottoResultCalculator.calculateResults(userLottos, winningNumbers, bonusNumber);
            printResults(matchCounts);

            double profitRate = ProfitCalculator.calculateProfitRate(matchCounts, purchaseAmount);
            System.out.printf("총 수익률은 %.1f%%입니다.%n", profitRate);

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
                if (rank == LottoRank.SECOND) { // 보너스 볼 일치 출력 추가
                    System.out.printf("%d개 일치, 보너스 볼 일치 (%s원) - %d개%n", rank.getMatchCount(), String.format("%,d", rank.getPrize()), matchCounts[rank.ordinal()]);
                } else {
                    System.out.printf("%d개 일치 (%s원) - %d개%n", rank.getMatchCount(), String.format("%,d", rank.getPrize()), matchCounts[rank.ordinal()]);
                }
            }
        }
    }

    private static List<Lotto> generateUserLottos(int ticketCount) {
        return java.util.stream.IntStream.range(0, ticketCount)
                .mapToObj(i -> Lotto.generateLotto())
                .collect(Collectors.toList());
    }

    private static void printLottoNumbers(List<Lotto> lottos) {
        lottos.forEach(lotto -> System.out.println(lotto.getNumbers()));
    }
}