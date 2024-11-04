package lotto.controller;

import lotto.service.LottoService;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService) {
        this.lottoService = lottoService;
    }

    public List<List<Integer>> createLottoTickets(int ticketCount) {
        return lottoService.generateLottoTickets(ticketCount);
    }

    public void displayLottoTickets(List<List<Integer>> lottoTickets) {
        System.out.println(lottoTickets.size() + "개를 구매했습니다.");
        for (List<Integer> ticket : lottoTickets) {
            System.out.print("[");
            for (int i = 0; i < ticket.size(); i++) {
                System.out.print(ticket.get(i));
                if (i < ticket.size() - 1) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }
}
