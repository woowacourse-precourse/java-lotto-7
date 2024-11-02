package lotto;

import lotto.util.RandomLottoNumberGenerator;
import lotto.util.UserInputValidator;
import lotto.view.PrintOutputView;
import lotto.view.ReadUserInputView;

public class Application {
    public static void main(String[] args) {
        new LottoController(new ReadUserInputView(new UserInputValidator()), new PrintOutputView(),
                new LottoService(new RandomLottoNumberGenerator(), new LottoRepository())).startLotto();
    }
}
