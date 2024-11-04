package lotto.controller;

import java.util.List;
import java.util.Map;
import lotto.model.Lotto;
import lotto.model.LottoGame;
import lotto.model.LottoMachine;
import lotto.model.Prize;
import lotto.util.RandomGenerator;
import lotto.view.OutputView;

public class LottoGameController {
    private final InputController inputController;

    public LottoGameController(InputController inputController) {
        this.inputController = inputController;
    }

    public void run() {
        LottoMachine lottoMachine;
        List<Integer> winningNumbers;
        Integer bonusNumber;
        RandomGenerator randomGenerator = new RandomGenerator();

        while (true) {
            try {
                Integer money = inputController.getMoney();
                lottoMachine = new LottoMachine(money, randomGenerator);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        List<Lotto> lottos = lottoMachine.makeLotto();
        OutputView.printLottoBuyHistory(lottos)
        ;
        winningNumbers = inputController.getWinningNumbers();
        bonusNumber = inputController.getBonusNumber(winningNumbers);

        LottoGame game = new LottoGame(lottos, winningNumbers, bonusNumber);

        Map<Prize, Integer> result = game.getResult();
        double profitRate = game.getProfitRate();

        OutputView.printResult(result, profitRate);
    }

}
