package lotto.controller;

import java.util.List;
import lotto.Winning;

public class MainController {
    private static ViewControllerImpl viewController = ViewControllerImpl.getInstance();
    private static LottoController lottoController = LottoController.getInstance();

    public static void run() {
        Integer lottoCount = viewController.getMoney();
        lottoController.buyLotto(lottoCount);
        viewController.showNumber(lottoCount);
        List<Integer> winningNumbers = viewController.getWinningNumber();
        lottoController.saveWinningNumber(winningNumbers);
        viewController.getBonus();
        List<Winning> winnings = lottoController.calWinning();
        viewController.printWinning(winnings);
        Double revenue = lottoController.revenue(lottoCount);
        viewController.printRevenue(revenue);
    }
}
