package lotto.controller;

import java.util.HashMap;
import java.util.List;
import lotto.info.LottoInfo;
import lotto.model.Computer;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        int money = InputView.getMoneyToBuy();
        int amount = money / LottoInfo.PRICE.getNumber();

        User user = makeUserToBuyLotto(amount);

        OutputView.printBlankLine();
        List<Integer> winningNumbers = InputView.getWinningNumbers();

        OutputView.printBlankLine();
        int bonusNumber = InputView.getBonusNumber();

        Computer computer = new Computer(winningNumbers, bonusNumber);
        computer.compareToWinningNumbers(user.getLotto());

        showResult(computer.getResult(), computer.getProfitRate(money));
    }

    private User makeUserToBuyLotto(int amount) {
        User user = new User(amount);

        OutputView.printBlankLine();
        OutputView.notifyAmount(amount);
        showLottoNumbers(user.getLotto());

        return user;
    }

    private void showLottoNumbers(List<Lotto> lotto) {
        for (Lotto oneLotto : lotto) {
            OutputView.printLottoNumbers(oneLotto.getNumbers());
        }
    }

    private void showResult(HashMap<Integer, Integer> result, double profitRate) {
        OutputView.printBlankLine();
        OutputView.printStatistics(result.get(5), result.get(4), result.get(3), result.get(2), result.get(1),
                profitRate);
    }
}
