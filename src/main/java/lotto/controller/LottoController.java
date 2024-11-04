package lotto.controller;

import lotto.Service.LottoService;
import lotto.model.WinningNumbers;
import lotto.model.Lotto;

import java.util.List;

public class LottoController {
    private final LottoService lottoService;

    public LottoController(LottoService lottoService){
        this.lottoService = lottoService;
    }

    public void start(){
        int purchaseAmount = lottoService.inputPurchaseAmount();
        printLottoTickets(purchaseAmount);
        WinningNumbers winningNumbers = lottoService.inputWinningNumbers();
    }

    private void printLottoTickets(int amount){
        List<Lotto> lottoTickets = lottoService.generateLottoNumbers(amount);
        System.out.println(amount + "개를 구매했습니다.");
        for (Lotto lotto : lottoTickets){
            System.out.println(lotto);
        }
    }
}
