package lotto.view;

import java.util.List;

public class OutputView {

    public static void printPurchasedLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : lottoTickets) {
            ticket.sort(Integer::compareTo);
            System.out.println(ticket);
        }
    }
}
