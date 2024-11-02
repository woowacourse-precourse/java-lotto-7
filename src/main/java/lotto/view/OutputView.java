package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {
    public void printLottoTickets(int quantity, List<Lotto> tickets){
        System.out.println("\n"+quantity+"개를 구매했습니다.");
        for(Lotto ticket: tickets){
            System.out.println(ticket.getNumbers());
        }
    }
    public void printError(String message){
        System.out.println("[ERROR] "+message);
    }
}