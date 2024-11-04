package lotto.domain;

import java.util.List;

public class LottoController {
    private final LottoApplicationService lottoApplicationService = new LottoApplicationService();

    public void createLotto(int money) {
        lottoApplicationService.createLotto(money);
    }

    public void lottoResult(List<Integer> winningNumbers, int bonusNumber) {
        lottoApplicationService.lottoResult(winningNumbers, bonusNumber);
    }

    public double profitRate(int purchaseMoney) {
        return lottoApplicationService.profitRate(purchaseMoney);
    }
}
