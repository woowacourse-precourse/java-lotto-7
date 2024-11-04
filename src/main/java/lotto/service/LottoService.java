package lotto.service;

import lotto.model.Lotto;
import lotto.model.Lottos;
import lotto.model.Result;

public class LottoService {
    private LottoService() {
    }

    private static class SingletonHelper {
        private static final LottoService INSTANCE = new LottoService();
    }

    public static LottoService getInstance() {
        return SingletonHelper.INSTANCE;
    }

    public String lottosString(Lottos lottos) {
        return lottos.purchaseNumber() + "개를 구매했습니다.\n"
                + lottos;
    }

    public Result winningResult(Lottos lottos, Lotto targetLotto, int bonusNumber) {
        return lottos.getResult(targetLotto, bonusNumber);
    }

    public String resultString(Result result, int purchaseAmount) {
        return result.toString()
                + "\n총 수익률은 "
                + result.calculateProfitRate(purchaseAmount) + "%입니다.";
    }
}
