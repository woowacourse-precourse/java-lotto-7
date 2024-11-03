package lotto.controller;

import java.util.List;
import lotto.repository.LottoRepository;

public class MainController {
    private static ViewControllerImpl viewController = ViewControllerImpl.getInstance();
    private static LottoController lottoController = LottoController.getInstance();

    public static void run(){
        Integer lottoCount = viewController.getMoney();
        lottoController.buyLotto(lottoCount);
        viewController.showNumber(lottoCount);
        List<Integer> winningNumbers = viewController.getWinningNumber();
        lottoController.saveWinningNumber(winningNumbers);
        viewController.getBonus();
        lottoController.calWinning();
    }
}
