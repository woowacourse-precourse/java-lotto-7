package lotto.domain;

import java.util.Arrays;
import java.util.EnumMap;
import java.util.Map;

public class PrizeResult {
    private final Map<LottoRank, Integer> prizeResult;

    public PrizeResult() {
        prizeResult = new EnumMap<>(LottoRank.class);
        Arrays.stream(LottoRank.values())
                .forEach(prize -> prizeResult.put(prize, 0));
    }

    public void calculate(WinningLotto winningLotto, LottoTicket lottoTicket) {
        for (Lotto lotto : lottoTicket.getLottos()) {
            LottoRank lottoRank = determineLottoRank(lotto, winningLotto);
            updatePrizeCount(lottoRank);
        }
    }

    private LottoRank determineLottoRank(Lotto lotto, WinningLotto winningLotto) {
        int matchedCount = lotto.getMatchLottoNumber(winningLotto);
        boolean containsBonus = lotto.isContain(winningLotto.getBonusNumber());
        return LottoRank.valueOf(matchedCount, containsBonus);
    }

    private void updatePrizeCount(LottoRank lottoRank) {
        prizeResult.put(lottoRank, prizeResult.get(lottoRank) + 1);
    }

    public int getPrizeCount(LottoRank lottoRank) {
        return prizeResult.get(lottoRank);
    }
}
