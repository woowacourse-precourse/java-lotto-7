package lotto.domain;

import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.error.ErrorCode;

public class LottoManager {

    private final List<Lotto> publishedLottos;
    private final WinnerLotto winningLotto;

    public LottoManager(List<Lotto> publishedLottos) {
        this.publishedLottos = publishedLottos;
        this.winningLotto = null;
    }

    public LottoManager(List<Lotto> publishedLottos, WinnerLotto winningLotto) {
        this.publishedLottos = publishedLottos;
        this.winningLotto = winningLotto;
    }

    public static LottoManager from(int purchaseAmount){
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> publishedLottos = LottoFactory.createLottos(lottoCount);
        return new LottoManager(publishedLottos);
    }

    public LottoManager withWinningLotto(WinnerLotto winningLotto){
        return new LottoManager(this.publishedLottos, winningLotto);
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

}
