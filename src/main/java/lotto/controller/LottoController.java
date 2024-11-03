package lotto.controller;

import java.util.List;
import lotto.service.LottoService;

public class LottoController {
    public List<List<Integer>> crateLottoTicket() {
        LottoService lottoService = new LottoService();
        int ticketQuantity = lottoService.purchaseTicket();
        return lottoService.generateLottoNumbers(ticketQuantity);
    }

    public List<String> createLottoWinningNumber() {
        LottoService lottoService = new LottoService();
        return lottoService.generateWinningNumber();
    }
}
