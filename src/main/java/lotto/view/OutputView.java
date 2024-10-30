package lotto.view;

import java.util.ArrayList;
import lotto.Lotto;

public class OutputView {

    public void printGeneratedLottoTickets(int lottoAmount, ArrayList<Lotto> lottoTickets) {
        System.out.println(lottoAmount + "개를 구매했습니다.");

        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }
}
