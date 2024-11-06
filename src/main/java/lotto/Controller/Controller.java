package lotto.Controller;

import lotto.input.Loop;
import lotto.logic.Generate;
import lotto.logic.JudgeWinLotto;

import java.util.List;

public class Controller {

    public static void run() {

        int paper = Loop.getPurchaseAmount();
        List<List<Integer>> purchasedLottos = Generate.run(paper);

        List<Integer> winningNumbers = Loop.getWinningNumbers();
        int bonusNumber = Loop.getBonusNumber(winningNumbers);

        JudgeWinLotto.calculateResults(purchasedLottos, winningNumbers, bonusNumber, paper * 1000);

    }

}
