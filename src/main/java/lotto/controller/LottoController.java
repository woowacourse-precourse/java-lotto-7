package lotto.controller;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Player;
import lotto.service.LottoService;
import lotto.service.StatsService;
import lotto.utils.Validator;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final StatsService statsService;

    public LottoController(LottoService lottoService, StatsService statsService) {
        this.lottoService = lottoService;
        this.statsService = statsService;
    }

    public void start() {
        int purchaseAmount = getValidPurchaseAmount();
        int purchaseCount = lottoService.getPurchaseCount(purchaseAmount);
        OutputView.purchaseCount(purchaseCount);

        List<Lotto> lottos = lottoService.makeLottos(purchaseCount);
        OutputView.lottoNumbers(lottos);

        Lotto winningLotto = getValidWinningLotto();
        int bonusNumber = getValidBonusNumber(winningLotto);
        Player player = new Player(winningLotto, bonusNumber);

        statsService.calculateStats(lottos, player);
        OutputView.stats(statsService.getStatsCount());

        double profitRate = statsService.calculateProfitRate(purchaseAmount);
        OutputView.profitRate(profitRate);
    }

    private int getValidPurchaseAmount() {
        while (true) {
            try {
                return InputView.purchaseAmount();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Lotto getValidWinningLotto() {
        while (true) {
            try {
                return InputView.winningLotto();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private int getValidBonusNumber(Lotto winningLotto) {
        while (true) {
            try {
                int bonusNumber = InputView.bonusNumber();
                validateBonusNumber(winningLotto, bonusNumber);
                
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBonusNumber(Lotto winningLotto, int bonusNumber) {
        Validator.numberInRange(bonusNumber);
        Validator.numberIsUnique(winningLotto.getNumbers(), bonusNumber);
    }
}
