package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Result;
import lotto.dto.BonusLottoNumber;
import lotto.dto.LottoPurchaseAmount;
import lotto.dto.MatchLottoResult;
import lotto.dto.RateOfReturn;
import lotto.dto.WinningLottoNumbers;
import lotto.enums.Rank;

public class LottoService {
    public Lottos buyLottos(LottoPurchaseAmount lottoPurchaseAmount) {
        int range = lottoPurchaseAmount.lottoPurchaseAmount() / 1000;

        Lottos lottos = new Lottos();

        for (int i = 0; i < range; i++) {
            Lotto lotto = new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            lottos.addLotto(lotto);
        }

        return lottos;
    }

    public MatchLottoResult matchLottoNumber(
            Lottos lottos, WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber
    ) {
        Result result = new Result(Rank.values().length);

        for (Lotto lotto : lottos.getLottos()) {
            int matchingWinningLottoNumbersCount = countMatchingWinningLottoNumbers(lotto, winningLottoNumbers);
            boolean isBonusNumberMatch = countMatchingBonusLottoNumber(lotto, bonusLottoNumber);
            Rank rank = Rank.getRankByResult(matchingWinningLottoNumbersCount, isBonusNumberMatch);
            result.addResult(rank.getValue());
        }

        return MatchLottoResult.of(result);
    }

    public RateOfReturn calcRateOfReturn(LottoPurchaseAmount purchaseAmount, MatchLottoResult matchLottoResult) {
        long rate = 0L;

        for (Map.Entry<Integer, Integer> result : matchLottoResult.result().entrySet()) {
            rate += (long) Rank.getRankByValue(result.getKey()).getRewordValue() * result.getValue();
        }

        return new RateOfReturn((rate / purchaseAmount.lottoPurchaseAmount()) * 100);
    }

    private int countMatchingWinningLottoNumbers(Lotto lotto, WinningLottoNumbers winningLottoNumbers) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLottoNumbers.winningLottoNumber()::contains)
                .count();
    }

    private boolean countMatchingBonusLottoNumber(Lotto lotto, BonusLottoNumber bonusLottoNumber) {
        return lotto.getNumbers().contains(bonusLottoNumber.bonusLotto());
    }
}
