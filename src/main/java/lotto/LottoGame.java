package lotto;

import java.util.List;
import lotto.controller.LottoController;

public class LottoGame {
    public static void start() {
        LottoController lottoController = new LottoController();
        int lottoPrice = lottoController.createLottoPrice();
        List<List<Integer>> lottoTicket = lottoController.crateLottoTicket(lottoPrice);
        List<String> lottoWinningNumber = lottoController.createLottoWinningNumber();
        lottoController.createLottoWinners(lottoPrice, lottoTicket, lottoWinningNumber);
    }
}
