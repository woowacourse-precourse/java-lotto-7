package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    // 구매한 로또 출력 메소드
    public void purchaseTickets(List<Lotto> tickets) {
        System.out.println(tickets.size() + "개를 구매했습니다.");
        for (Lotto ticket : tickets) {
            System.out.println(ticket.getNumbers());
        }
    }

    // 당첨 결과 출력 메소드
}
