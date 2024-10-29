package lotto.controller;

import lotto.model.LottoCompany;
import lotto.model.LottoGenerator;
import lotto.model.LottoShop;
import lotto.view.InputHandler;

public class LottoController {
    private final InputHandler inputHandler;
    private final LottoShop lottoShop;
    private final LottoGenerator lottoGenerator;
    private final LottoCompany lottoCompany;

    public LottoController(InputHandler inputHandler, LottoShop lottoShop, LottoGenerator lottoGenerator,
                           LottoCompany lottoCompany) {
        this.inputHandler = inputHandler;
        this.lottoShop = lottoShop;
        this.lottoGenerator = lottoGenerator;
        this.lottoCompany = lottoCompany;
    }

    public void run() {
        String givenMoney = inputHandler.getInputForPurchaseMoney();
        // LottoShop 에게 money와 함께 로또 구매 요청
        String winningNumber = inputHandler.getInputForWinningNumber();
        // DrawingMachine에게 당첨 번호 주입
        // List<Lotto> 혹은 일급 객체 Lottos를 받고, DrawingMachine에게 넘기기
        // DrawingMachine은 당첨 여부 및 당첨금 판별
    }
}
