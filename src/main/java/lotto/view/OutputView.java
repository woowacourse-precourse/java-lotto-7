package lotto.view;

import lotto.model.LottoTicket;

public class OutputView {

    public static void printLottoCount(int count) {
        System.out.println(count + "개를 구매했습니다.");
    }

    public static void printLottoTicket(LottoTicket ticket) {
        System.out.println(ticket);
    }
}
