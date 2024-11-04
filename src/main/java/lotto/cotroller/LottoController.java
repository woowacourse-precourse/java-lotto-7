package lotto.cotroller;

import lotto.domain.Lotto;
import lotto.domain.LottoRanking;
import lotto.domain.User;
import lotto.service.InputService;
import lotto.service.LottoCalculatorService;
import lotto.view.OutputView;

import java.util.Map;

public class LottoController {

    private final InputService inputService = new InputService();
    private final LottoCalculatorService lottoCalculatorService = new LottoCalculatorService();

    public void run() {
        User user = setUser();
        Lotto lotto = setWinningLotto();

        OutputView.printWinningHistory(getCalculateResult(user, lotto));
        OutputView.printProfitPercent(getProfitPercent(user));
    }

    private User setUser() {
        return inputService.inputUser();
    }

    private Lotto setWinningLotto() {
        return inputService.setWinningLotto();
    }

    private String getProfitPercent(User user) {
        return lottoCalculatorService.profitPercentCalculate(user);
    }

    private Map<LottoRanking, Integer> getCalculateResult(User user, Lotto lotto) {
        return lottoCalculatorService.calculateWinningResult(user, lotto);
    }
}
