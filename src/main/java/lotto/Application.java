package lotto;

import java.util.List;
import lotto.controller.LottoController;
import lotto.view.InputView;

public class Application {
    public static void main(String[] args) {
        int lottoMoney = InputView.getLottoMoney();
        List<Integer> numbers = InputView.getWinningNumbers();
        int bonusNumber = InputView.getBousNumber();
        LottoController controller = new LottoController(lottoMoney);
        controller.startLotto();
    }
}
