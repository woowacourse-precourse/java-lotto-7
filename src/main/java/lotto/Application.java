package lotto;

import java.util.List;
import lotto.controller.MoneyController;
import lotto.controller.UserLottoController;
import lotto.model.Lotto;
import lotto.model.UserLotto;
import lotto.service.LottoService;
import lotto.service.UserLottoService;

public class Application {

    public static void main(String[] args) {

        MoneyController moneyController = new MoneyController();
        UserLottoController userLottoController = new UserLottoController(new LottoService(),
            new UserLottoService());

        int lottoAmount = moneyController.inputMoney();
        List<Lotto> lottos = userLottoController.buyAndPrintLottos(lottoAmount);
        List<Integer> defaultLottoNumbers = userLottoController.defaultLottoNumbers();
        int bonus = userLottoController.bonusNumber();
        UserLotto userLotto = new UserLotto(lottos, defaultLottoNumbers, bonus);
        userLottoController.printWinningStatistics(userLotto);
    }
}
