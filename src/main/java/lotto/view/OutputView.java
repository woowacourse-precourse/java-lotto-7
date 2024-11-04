package lotto.view;

import java.util.ArrayList;
import lotto.domain.Lotto;

public class OutputView {
    public static void printTickets(ArrayList<Lotto> tickets, int amount) {
        int count = amount / 1000;

        System.out.println("\n" + count + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            ticket.printNumber();
        }
        System.out.println();
    }
}
