package lotto;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LottoMachine {
    private final LottoTicketGenerator ticketGenerator = new LottoTicketGenerator();

    public void start() {
        System.out.println("구입 금액을 입력해 주세요.");
        int purchaseAmount = Integer.parseInt(Console.readLine());

        try {
            PurchaseValidator.validate(purchaseAmount);
            int ticketCount = purchaseAmount / 1000;
            List<Lotto> purchasedTickets = ticketGenerator.generateTickets(ticketCount);

            System.out.printf("%d개를 구매했습니다.\n", ticketCount);
            purchasedTickets.forEach(ticket -> System.out.println(ticket.getNumbers()));

            // 당첨 번호와 보너스 번호 입력
            System.out.println("당첨 번호를 입력해 주세요 (예: 1,2,3,4,5,6):");
            Set<Integer> winningNumbers = Stream.of(Console.readLine().split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toSet());

            System.out.println("보너스 번호를 입력해 주세요:");
            int bonusNumber = Integer.parseInt(Console.readLine());

            // 당첨 번호와 보너스 번호 검증
            WinningChecker winningChecker = new WinningChecker(winningNumbers, bonusNumber);
            WinStatistics statistics = new WinStatistics();

            // 당첨 결과 확인
            for (Lotto ticket : purchasedTickets) {
                int winCategory = winningChecker.checkWinning(ticket);
                statistics.recordResult(winCategory);
            }

            // 최종 결과 출력
            statistics.printStatistics();
            System.out.printf("총 수익률은 %.1f%%입니다.\n", statistics.calculateProfitRate(purchaseAmount));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
