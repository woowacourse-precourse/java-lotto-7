package lotto.service;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_COUNT;
import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_RANGE_END;
import static lotto.config.EnvironmentVariables.LOTTO_NUMBER_RANGE_START;
import static lotto.config.EnvironmentVariables.LOTTO_UNIT_COST;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.dto.BonusLottoNumber;
import lotto.dto.BuyLottos;
import lotto.dto.LottoPurchaseCost;
import lotto.dto.MatchLottoResult;
import lotto.dto.RateOfReturn;
import lotto.dto.WinningLottoNumbers;
import lotto.enums.Rank;

public class LottoService {
    public BuyLottos buyLottos(LottoPurchaseCost lottoPurchaseCost) {
        int purchaseCount = lottoPurchaseCost.amount() / LOTTO_UNIT_COST;
        return BuyLottos.of(createLottos(purchaseCount));
    }

    private List<Lotto> createLottos(int purchaseCount) {
        return IntStream.range(0, purchaseCount)
                .mapToObj(i -> new Lotto(pickUniqueNumbersInRange(
                        LOTTO_NUMBER_RANGE_START, LOTTO_NUMBER_RANGE_END, LOTTO_NUMBER_COUNT)))
                .collect(Collectors.toList());
    }

    public MatchLottoResult matchLottoNumber(
            BuyLottos buyLottos, WinningLottoNumbers winningLottoNumbers, BonusLottoNumber bonusLottoNumber
    ) {
        LottoResult lottoResult = new LottoResult();

        for (Lotto lotto : buyLottos.numbers()) {
            int matchCount = lotto.countWinningMatches(winningLottoNumbers.numbers());
            boolean isBonusNumberMatch = lotto.hasBonusMatch(bonusLottoNumber.number());
            lottoResult.addResult(Rank.getRankByResult(matchCount, isBonusNumberMatch));
        }

        return MatchLottoResult.of(lottoResult.getRankResults());
    }

    public RateOfReturn calcRateOfReturn(LottoPurchaseCost lottoPurchaseCost, MatchLottoResult matchLottoResult) {
        long totalReword = 0L;

        for (Map.Entry<Rank, Integer> entry : matchLottoResult.result().entrySet()) {
            totalReword += ((long) entry.getKey().getReword() * entry.getValue());
        }

        return RateOfReturn.of(totalReword, lottoPurchaseCost.amount());
    }
}
