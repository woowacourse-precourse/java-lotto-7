package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;

public class OutputController {

    public void printGeneratedLottoTickets(int lottoAmount, ArrayList<Lotto> lottoTickets) {
        System.out.println(lottoAmount + "개를 구매했습니다.");

        for (Lotto lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }
}
