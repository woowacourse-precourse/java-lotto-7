package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.service.RankService;

public class MainController {

    public void run() {
        int amount = runPurchaseAmount();
        List<Lotto> lottos = runSetLottos(amount);
        int tickets = runChangeTickets(amount);
        List<Integer> winnings = runWinningNumbers();
        int bonus = runBonusNumber(winnings);
        RankService ranking = runRanking(lottos, winnings, bonus);
    }

    private int runPurchaseAmount() {
        AmountController amountController = new AmountController();
        int amount = amountController.inputAmount();
        return amount;
    }

    private List<Lotto> runSetLottos(int amount) {
        LottoController lottoController = new LottoController();
        List<Lotto> lottos = lottoController.setLottos(amount);
        return lottos;
    }

    private int runChangeTickets(int amount) {
        LottoController lottoController = new LottoController();
        int tickets = lottoController.changeTickets(amount);
        return tickets;
    }

    private List<Integer> runWinningNumbers() {
        WinBonusController winBonusController = new WinBonusController();
        List<Integer> winnings = winBonusController.inputWinning();
        return winnings;
    }

    private int runBonusNumber(List<Integer> winnings) {
        WinBonusController winBonusController = new WinBonusController();
        int bonus = winBonusController.inputBonus(winnings);
        return bonus;
    }

    private RankService runRanking(List<Lotto> lottos, List<Integer> winnings, int bonus) {
        RankController rankController = new RankController();
        RankService ranking = rankController.rankingStatistics(lottos, winnings, bonus);
        return ranking;
    }

}
