package lotto.model.result;

import java.util.EnumMap;
import java.util.List;
import lotto.constant.LottoWinInfo;
import lotto.model.draw.DrawNumber;
import lotto.model.draw.LottoNumbers;
import lotto.model.purchase.Lotto;

public class LottoResult {
    private final EnumMap<LottoWinInfo, Integer> lottoWinCount = new EnumMap<>(LottoWinInfo.class);
    private final Profit lottoProfit;

    {
        for (LottoWinInfo lottoWinInfo : LottoWinInfo.values()) {
            lottoWinCount.put(lottoWinInfo, 0);
        }
    }

    public LottoResult(final DrawNumber drawNumber, final List<Lotto> lottoTickets, final Integer payment) {
        countWinningLottoTickets(drawNumber.getDrawNumbers(), drawNumber.getBonusNumber(), lottoTickets);
        lottoProfit = new Profit(lottoWinCount, payment);
    }

    private void countWinningLottoTickets(final LottoNumbers drawNumbers, final Integer bonusNumber,
                                          final List<Lotto> lottoTickets) {
        for (Lotto lotto : lottoTickets) {
            LottoWinInfo lottoWinInfo = getLottoWinInfo(drawNumbers, bonusNumber, lotto);
            if (lottoWinInfo != null) {
                lottoWinCount.put(lottoWinInfo, lottoWinCount.get(lottoWinInfo) + 1);
            }
        }
    }

    private LottoWinInfo getLottoWinInfo(final LottoNumbers drawNumbers, final Integer bonusNumber, final Lotto lotto) {
        int numberMatchCount = lotto.getNumberMatchCount(drawNumbers);
        boolean hasBonusNumber = lotto.hasBonusNumber(bonusNumber);
        return LottoWinInfo.getLottoWinInfo(numberMatchCount, hasBonusNumber).orElse(null);
    }

    public EnumMap<LottoWinInfo, Integer> getLottoWinCount() {
        return lottoWinCount;
    }

    public Profit getLottoProfit() {
        return lottoProfit;
    }
}
