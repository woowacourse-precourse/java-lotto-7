package lotto.view;

import lotto.dto.LottoMatchDTO;
import lotto.io.Output;
import lotto.model.Lotto;
import lotto.model.NumberMatchType;
import lotto.model.WinningStatistic;

public final class WinningStatisticView {
    public static void winningStatistic(LottoMatchDTO lottoMatchDTO) {
        getWinningStatistic(lottoMatchDTO);
        Output.printlnMessage(WinningStatistic.getWinningStatistics());
    }

    private static void getWinningStatistic(LottoMatchDTO lottoMatchDTO) {
        WinningStatistic.createStatistics();
        for (Lotto purchaseLotto : lottoMatchDTO.purchaseLottos().lottos) {
            int matchCount = lottoMatchDTO.winningNumber().winningLotto().matchLottoCount(purchaseLotto);
            boolean isBonusMatched = purchaseLotto.matchBonus(lottoMatchDTO.winningNumber().bonusNumber());
            NumberMatchType numberMatchType = determineMatchType(matchCount, isBonusMatched);
            WinningStatistic.incrementMatchCount(numberMatchType);
        }
    }

    private static NumberMatchType determineMatchType(int matchCount, boolean isBonusMatched) {
        for (NumberMatchType type : NumberMatchType.values()) {
            if (type.getMatchCount() == matchCount) {
                return type.matchBonus(isBonusMatched);
            }
        }
        return null;
    }
}