package lotto;

import java.util.List;
import lotto.controller.LottoController;

public class LottoGame {
    public static void start() {
        LottoController lottoController = new LottoController();
        List<List<Integer>> lottoTicket = lottoController.crateLottoTicket();
        List<String> lottoWinningNumber = lottoController.createLottoWinningNumber();
    }
}
