package lotto.domain;

import java.util.List;

public class LottoApplicationService {
    private final LottoDomainService lottoDomainService = new LottoDomainService();
    private final LottoFactory lottoFactory = new LottoFactory();

    public void createLotto(int money) {
        int count = money / 1000;
        List<Lotto> lottos = lottoDomainService.purchaseLotto(count);
        showLotto(lottos);
    }

    private void showLotto(List<Lotto> lottos) {
        lottos.stream().forEach( lotto -> showLotto(lotto));
    }

    private void showLotto(Lotto lotto) {
        List<Integer> numbers = lotto.getNumbers();
        System.out.println(numbers.toString());
    }

    public void lottoResult(List<Integer> winningNumbers, int bonusNumber) {
        lottoDomainService.lottoResult(winningNumbers, bonusNumber);
    }

    public double profitRate(int purchaseMoney) {
        return lottoDomainService.profitRate(purchaseMoney);
    }
}
