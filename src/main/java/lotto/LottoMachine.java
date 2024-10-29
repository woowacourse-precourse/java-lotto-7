package lotto;

import java.util.*;

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
            Optional<LottoPrize> lottoPrize = lottoWinningEvaluator.calculatePrize(lotto, winningLotto, bonusNumber);
            lottoPrize.ifPresent(prize -> prizeResult.put(prize, prizeResult.getOrDefault(prize, 0) + 1));
        }

        buyingLottos.clear();
        return prizeResult;
    }

}
