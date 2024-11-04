package lotto.view;

import java.util.List;
import java.util.Set;

public class OutputView {

    public void printLottoTicketCountAndNumbers(int ticketCount, Set<List<Integer>> ticketNumbers) {
        System.out.println(ticketCount + "개를 구매했습니다.");
        for (List<Integer> ticketNumber : ticketNumbers) {
            System.out.println(ticketNumber);
        }
    }

}
