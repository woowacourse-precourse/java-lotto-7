package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;

public class MainController {

    public void run() {
        int amount = runPurchaseAmount();
        List<Lotto> lottos = runSetLottos(amount);
        List<Integer> winnings = runWinningNumbers();
        int bonus = runBonusNumber(winnings);
    }

    public int runPurchaseAmount() {
        AmountController amountController = new AmountController();
        int amount = amountController.inputAmount();
        return amount;
    }

    public List<Lotto> runSetLottos(int amount) {
        LottoController lottoController = new LottoController();
        List<Lotto> lottos = lottoController.setLottos(amount);
        return lottos;
    }

    public List<Integer> runWinningNumbers() {
        WinBonusController winBonusController = new WinBonusController();
        List<Integer> winnings = winBonusController.inputWinning();
        return winnings;
    }

    public int runBonusNumber(List<Integer> winnings) {
        WinBonusController winBonusController = new WinBonusController();
        int bonus = winBonusController.inputBonus(winnings);
        return bonus;
    }

}
