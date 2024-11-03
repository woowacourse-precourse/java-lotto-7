package lotto.view;

import lotto.domain.*;

import java.util.List;
import java.util.Map;

public class OutputView {

    public void showTicket(Machine machine) {
        showTicketCount(machine.getTicketCount());
        showTickets(machine.getTickets());
    }

    private void showTicketCount(int count) {
        System.out.println();
        System.out.println(+count + "개를 구매했습니다.");
    }

    private void showTickets(List<Lotto> tickets) {
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers().toString());
        }
    }

    public void showResult(Machine machine, WinningNumbers winningNumbers) {
        System.out.println();
        System.out.println("당첨 통계\n" + "---");
        Map<String, Integer> results = machine.getResult(winningNumbers);

        System.out.println("3개 일치 (5,000원) - " + results.getOrDefault(Match.THREE_MATCH.name(), 0) + "개");
        System.out.println("4개 일치 (50,000원) - " + results.getOrDefault(Match.FOUR_MATCH.name(), 0) + "개");
        System.out.println("5개 일치 (1,500,000원) - " + results.getOrDefault(Match.FIVE_MATCH_ONLY.name(), 0) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + results.getOrDefault(Match.FIVE_AND_BONUS_MATCH.name(), 0) + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + results.getOrDefault(Match.SIX_MATCH.name(), 0) + "개");

        double returnOfInvestment = machine.getReturnOfInvestment(results);
        System.out.println("총 수익률은 " + returnOfInvestment + "%입니다.");
    }
}
