package lotto;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LottoMachine {
    private final List<Lotto> buyingLottos;
    private final LottoWinningEvaluator lottoWinningEvaluator;
    private final LottoFactory LottoFactory;


    public LottoMachine(LottoWinningEvaluator lottoWinningEvaluator, LottoFactory LottoFactory) {
        this.buyingLottos = new ArrayList<>();
        this.lottoWinningEvaluator = lottoWinningEvaluator;
        this.LottoFactory = LottoFactory;
    }

    public void buyLotto() {
        Lotto lotto = LottoFactory.createRandomLotto();
        buyingLottos.add(lotto);
    }

    public List<Lotto> getBuyingLottos() {
        return buyingLottos;
    }


    public Map<LottoPrize, Integer> calculatePrize(Lotto winningLotto, int bonusNumber) {
        Map<LottoPrize, Integer> prizeResult = new HashMap<>();
        for (Lotto lotto : buyingLottos) {
            LottoPrize lottoPrize = lottoWinningEvaluator.calculatePrize(lotto, winningLotto, bonusNumber);
            prizeResult.put(lottoPrize, prizeResult.getOrDefault(lottoPrize, 0) + 1);
        }

        buyingLottos.clear();
        return prizeResult;
    }

}
