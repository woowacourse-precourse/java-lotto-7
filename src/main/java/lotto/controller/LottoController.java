package lotto.controller;

import java.util.List;
import lotto.service.LottoService;

public class LottoController {
    public int createLottoPrice() {
        LottoService lottoService = new LottoService();
        return lottoService.enterPrice();
    }

    public List<List<Integer>> crateLottoTicket(int lottoPrice) {
        LottoService lottoService = new LottoService();
        int ticketQuantity = lottoService.purchaseTicket(lottoPrice);
        return lottoService.generateLottoNumbers(ticketQuantity);
    }

    public List<String> createLottoWinningNumber() {
        LottoService lottoService = new LottoService();
        return lottoService.generateWinningNumber();
    }

    public void createLottoWinners(int lottoPrice, List<List<Integer>> lottoTicket, List<String> lottoWinningNumber) {
        LottoService lottoService = new LottoService();
        lottoService.generateLottoWinners(lottoPrice, lottoTicket, lottoWinningNumber);
    }
}
