package lotto.service.domain.lottoresult;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.service.domain.lotto.Lotto;
import lotto.service.domain.lotto.LottoBuyer;
import lotto.service.domain.lotto.LottoReward;

public class LottoWinCalculator {

    public static List<LottoReward> calculateReward(LottoBuyer lottoBuyer, LottoWinNumber lottoWinNumber) {
        return lottoBuyer.getPurchasedLotto().stream()
                .map(lotto -> checkNumberMatched(lotto, lottoWinNumber))
                .collect(Collectors.toList());
    }

    private static LottoReward checkNumberMatched(Lotto lotto, LottoWinNumber lottoWinNumber) {
        long checkLottoMatchedCount = lotto.getLottoticket().stream()
                .filter(lottoWinNumber.getWinnerLotto().getLottoticket()::contains)
                .count();

        boolean checkBonusMatched = lotto.getLottoticket().contains(lottoWinNumber.getBonusNumber());

        return Arrays.stream(LottoReward.values())
                .filter(lottoReward -> lottoReward.getRequiredMatch() == checkLottoMatchedCount)
                .filter(lottoReward -> {
                    if(lottoReward.getRequiredBonusMatch() == null) {
                        return true;
                    }

                    return checkBonusMatched == lottoReward.getRequiredBonusMatch();
                })
                .findFirst()
                .orElse(LottoReward.FAIL);
    }
}
