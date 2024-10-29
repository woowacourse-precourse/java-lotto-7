package lotto.controller;

import java.util.ArrayList;
import java.util.List;

public class OutputController {

    public void printGeneratedLottoTickets(int lottoAmount, ArrayList<List<Integer>> lottoTickets) {
        System.out.println(lottoAmount + "개를 구매했습니다.");

        for (List<Integer> lottoTicket : lottoTickets) {
            System.out.println(lottoTicket.toString());
        }
    }
}
