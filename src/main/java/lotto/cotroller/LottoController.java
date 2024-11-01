package lotto.cotroller;

import lotto.domain.Lotto;
import lotto.domain.User;
import lotto.service.InputService;
import lotto.service.LottoCalculatorService;

public class LottoController {

    private final InputService inputService = new InputService();
    private final LottoCalculatorService lottoCalculatorService = new LottoCalculatorService();

    public void run() {
        try {
            User user = setUser();
            Lotto lotto = setWinningLotto();

            getCalculateResult(user, lotto);
            getProfit(user);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private void getProfit(User user) {
        lottoCalculatorService.profitCalculate(user);
    }

    private void getCalculateResult(User user, Lotto lotto) {
        lottoCalculatorService.calculateWinningResult(user, lotto);
    }

    private User setUser() {
        return inputService.inputUser();
    }

    private Lotto setWinningLotto() {
        return inputService.setWinningLotto();
    }
}
