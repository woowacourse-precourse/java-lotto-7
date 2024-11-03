package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.PrizeType;

public class OutputView {
    public void printLottoTickets(int quantity, List<Lotto> tickets){
        System.out.println("\n"+quantity+"개를 구매했습니다.");
        for(Lotto ticket: tickets){
            System.out.println(ticket.getNumbers());
        }
    }

    public void printPrizeStates(Map<PrizeType, Integer> prizeStates){
        System.out.println("\n당첨 통계\n---");
        for (PrizeType prize : PrizeType.values()) {
            System.out.println(prize.getDescription() + " - " + prizeStates.get(prize) + "개");
        }
    }
    public void printTotalProfitRate(double totalProfitRate){
        System.out.printf("총 수익률은 %.1f%%입니다.\n", totalProfitRate);
    }
    public void printError(String message){
        System.out.println("[ERROR] "+message);
    }
}