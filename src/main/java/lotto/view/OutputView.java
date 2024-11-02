package lotto.view;

import lotto.model.lotto.LottoTicket;

public class OutputView {
    public void printMessage(String message) {
        System.out.println(message);
    }

    public void printLottoTicket(LottoTicket lottoTicket, int lottoAmount) {
        println();
        String lottoAmountHeader = String.format("%s개를 구매했습니다.", lottoAmount);
        System.out.println(lottoAmountHeader);
        System.out.println(lottoTicket);
    }

    public void println() {
        System.out.println();
    }
}
