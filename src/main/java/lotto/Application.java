package lotto;

import lotto.domain.LottoGenerator;
import lotto.domain.WinningNumbers;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        int amount = InputView.getAmount();
        OutputView.printLottoAmount(amount);

        LottoGenerator lottoGenerator = new LottoGenerator(amount);

        List<Integer> winningNumbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBonusNumber();

        WinningNumbers winningLotto = new WinningNumbers(winningNumbers, bonusNumber);
    }
}
