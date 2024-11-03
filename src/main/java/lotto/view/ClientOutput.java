package lotto.view;

import java.util.List;

public class ClientOutput {
    public void lottoPurchaseMessageOutput(int quantity, List<List<Integer>> lottoTickets) {
        System.out.println("\n" + quantity + "개를 구매했습니다.");
        for (List<Integer> ticket : lottoTickets) {
            System.out.println(ticket);
        }
    }
}
