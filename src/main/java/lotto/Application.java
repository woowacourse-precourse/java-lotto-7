package lotto;

import lotto.controller.InputController;
import lotto.model.LottoMachine;
import lotto.model.LottoMatcher;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int purchase = InputView.inputPurchase();
        List<List<Integer>> lottoLists = LottoMachine.generateLotto(purchase);
        OutputView.printLottoNumbers(lottoLists);

        List<Integer> winningNumbers = InputController.parseIntegerList(InputView.inputWinningNumbers());

        int bonusNumber = InputController.validateBonusNumber(InputView.inputBonusNumber());

        OutputView.printWinningComment();
        LottoMatcher.matchingLotto(purchase, lottoLists, winningNumbers, bonusNumber);
    }
}
