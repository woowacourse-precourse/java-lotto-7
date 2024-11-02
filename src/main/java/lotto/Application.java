package lotto;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.WinningResult;

import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    static LottoService lottoService = new LottoService();

    public static void main(String[] args) {

        int price = InputView.getPrice();
        List<Lotto> lottos = lottoService.buy(price);
        OutputView.printLotto(lottos);

        List<Integer> winners = InputView.getWinnerNumbers();
        int bonus = InputView.getBonusNumber();
        WinningResult result = lottoService.getResult(winners, bonus);
        OutputView.printWinning(result);
    }
}