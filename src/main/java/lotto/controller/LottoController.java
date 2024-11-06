package lotto.controller;


import java.util.HashSet;
import java.util.Set;
import lotto.model.LottoGenerator;
import lotto.model.LottoTickets;

public class LottoController {
    LottoTickets lottoTickets;
    Set<Integer> winningNumbers = new HashSet<>();
    int purchaseAmount;
    int bonusNumber;

    public LottoController() {
        set();
        checkResult();
    }

    private void set() {
        purchaseAmount = IOController.setPurchaseAmount();
        lottoTickets = new LottoTickets(LottoGenerator.makeTickets(purchaseAmount));
        IOController.outputLottoTickets(purchaseAmount, lottoTickets);
        winningNumbers = IOController.setWinningNumber();
        bonusNumber = IOController.setBonusNumber(winningNumbers);
    }

    private void checkResult() {
        IOController.outputResult(lottoTickets, winningNumbers, bonusNumber, purchaseAmount);
    }

}
