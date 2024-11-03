package lotto.controller;

import java.util.List;
import lotto.info.LottoInfo;
import lotto.model.Lotto;
import lotto.model.User;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    public void start() {
        int money = InputView.getMoneyToBuy();
        int amount = money / LottoInfo.PRICE.getNumber();

        User user = new User(amount);

        OutputView.printBlankLine();
        OutputView.notifyAmount(amount);
        printLottoNumbers(user.getLotto());
    }

    private void printLottoNumbers(List<Lotto> lotto) {
        for (Lotto oneLotto : lotto) {
            OutputView.printLottoNumbers(oneLotto.getNumbers());
        }
    }
}
