package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.error.ErrorCode;

public class LottoManager {

    private static final int LOTTO_PRICE = 1000;
    private static final int PERCENT = 100;
    private final int purchaseAmount;
    private final List<Lotto> publishedLottos;
    private final WinnerLotto winningLotto;

    public LottoManager(List<Lotto> publishedLottos) {
        this.purchaseAmount = publishedLottos.size() * LOTTO_PRICE;
        this.publishedLottos = publishedLottos;
        this.winningLotto = null;
    }

    public LottoManager(LottoManager lottoManager, WinnerLotto winningLotto) {
        this.purchaseAmount = lottoManager.purchaseAmount;
        this.publishedLottos = lottoManager.publishedLottos;
        this.winningLotto = winningLotto;
    }

    public static LottoManager from(int purchaseAmount){
        int lottoCount = purchaseAmount / LOTTO_PRICE;
        List<Lotto> publishedLottos = LottoFactory.createLottos(lottoCount);
        return new LottoManager(publishedLottos);
    }

    public LottoManager withWinningLotto(WinnerLotto winningLotto){
        return new LottoManager(this, winningLotto);
    }

    public List<Lotto> getPublishedLottos() {
        return Collections.unmodifiableList(publishedLottos);
    }

    public Map<Prize, Integer> getPrizeResult() {
        if(winningLotto == null){
            throw new IllegalArgumentException(ErrorCode.WINNING_LOTTO_NOT_EXIST.getMessage());
        }

        Map<Prize, Integer> prizeResult = new HashMap<>();
        for (Lotto lotto : publishedLottos) {
            Prize prize = winningLotto.cacluatePrize(lotto);
            if(prize == Prize.MISS){
                continue;
            }
            prizeResult.put(prize, prizeResult.getOrDefault(prize, 0) + 1);
        }
        return prizeResult;
    }

    public double getProfitRate() {
        Map<Prize, Integer> prizeResult = getPrizeResult();
        int totalWinningMoney = prizeResult.entrySet().stream()
                .filter(entry -> entry.getKey() != Prize.MISS)
                .map(entry -> entry.getKey().getPrizeAmount() * entry.getValue())
                .reduce(Integer::sum)
                .orElse(0);
        return (double) totalWinningMoney / purchaseAmount * PERCENT;
    }
}
