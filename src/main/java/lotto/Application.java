package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;
import lotto.domain.exception.InvalidBonusNumberException;
import lotto.domain.exception.InvalidLottoNumberException;
import lotto.domain.exception.InvalidPriceException;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    static LottoService lottoService;

    public static void main(String[] args) {
        AppConfig config = new AppConfig();
        lottoService = config.lottoService();

        Loop.executeUntilSuccess(Application::step1);
        Loop.executeUntilSuccess(Application::step2);
        Loop.executeUntilSuccess(Application::step3);
        WinningResult result = lottoService.getResult();
        OutputView.printWinning(result);
    }

    static void step1() {
        int price = InputView.getPrice();
        OutputView.printLotto(lottoService.buy(price));
    }

    static void step2() {
        List<Integer> winners = InputView.getWinnerNumbers();
        lottoService.setWinningNumber(winners);
    }

    static void step3() {
        int bonus = InputView.getBonusNumber();
        lottoService.setBonusNumber(bonus);
    }
}
