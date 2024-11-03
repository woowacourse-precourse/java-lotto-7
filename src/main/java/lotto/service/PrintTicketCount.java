package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintTicketCount {
    private final int lottoTicketCount;
    private final List<List<Integer>> tickets;

    public PrintTicketCount(int lottoTicketCount) {
        this.lottoTicketCount = lottoTicketCount;
        this.tickets = new ArrayList<>();
    }

    public void printCountAndTickets(List<List<Integer>> tickets) {

        printCount();
        repeatPrintTicket(tickets);

    }

    public List<List<Integer>> getLottoTickets() {
        for (int i = 0; i < lottoTicketCount; i++) {

            getLottoTicket();

        }

        return tickets;
    }

    private void getLottoTicket() {

        List<Integer> lottoTicket = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));

        Collections.sort(lottoTicket);
        tickets.add(lottoTicket);
    }

    private void printCount() {
        System.out.println(lottoTicketCount + "개를 구매했습니다.");
    }

    private void repeatPrintTicket(List<List<Integer>> tickets) {
        for (List<Integer> lottoTicket : tickets) {
            System.out.println(lottoTicket);
        }

        System.out.println();
    }
}
