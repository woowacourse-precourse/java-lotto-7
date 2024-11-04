package lotto.controller;

import lotto.domain.Lotto;
import lotto.domain.*;
import lotto.domain.LottoStore;
import lotto.message.ErrorMessage;
import lotto.message.ResultMessage;
import lotto.util.Validation;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoController {
    private static int price;
    public void play() {
        List<Lotto> lottos = getLottos();
        List<Integer> winningNumbers = getWinningNumber();
        int bonusNumber = getBonusNumber(winningNumbers);

        LottoCalculator calculator = new LottoCalculator(winningNumbers, bonusNumber);
        Map<ResultMessage, Integer> winningResults = calculator.calculateWinningResults(lottos);
        OutputView.printWinningResults(winningResults);
        OutputView.printProfitRate(calculator.calculateProfitRate(winningResults, price));
    }

    private int getBonusNumber(List<Integer> winningNumbers) {
        try {
            int bonusNumber = InputView.getBonusNumber();
            if (Validation.isDuplicate(bonusNumber, winningNumbers)) {
                throw new IllegalArgumentException(ErrorMessage.DUPLICATE_NUMBER_PRESENT.getErrorMessage());
            }
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getBonusNumber(winningNumbers);
        }
    }

    private List<Lotto> getLottos() {
        try {
            price = InputView.getPrice();
            List<Lotto> lottos = LottoStore.purchaseLotto(price);
            OutputView.printIssueResults(lottos);
            return lottos;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getLottos();
        }
    }

    private List<Integer> getWinningNumber() {
        try {
            return InputView.getWinningNumbers();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getWinningNumber();
        }
    }

}
