package lotto.function.winning.checker.processor;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.WinningLotto;
import lotto.util.calculator.LottoMatchingCountCalculator;
import lotto.util.calculator.LottoWinningPlaceCalculator;
import lotto.value.Rank;

public class LottoWinningPlaceCalculateProcessor {

    private final LottoWinningPlaceCalculator lottoWinningPlaceCalculator;
    private final LottoMatchingCountCalculator lottoMatchingCountCalculator;

    public LottoWinningPlaceCalculateProcessor(
            LottoWinningPlaceCalculator lottoWinningPlaceCalculator,
            LottoMatchingCountCalculator lottoMatchingCountCalculator
    ) {
        this.lottoWinningPlaceCalculator = lottoWinningPlaceCalculator;
        this.lottoMatchingCountCalculator = lottoMatchingCountCalculator;
    }

    public Rank calculate(WinningLotto winningLotto, Lotto purchaseLotto) {
        int countMatching = lottoMatchingCountCalculator
                .countMatchingNumbers(winningLotto.getFirstPlaceLotto(), purchaseLotto);
        boolean isMatchingBonus = lottoMatchingCountCalculator
                .isMatchingNumber(winningLotto.getBonusLotto().getBonusNumber(), purchaseLotto);
        return lottoWinningPlaceCalculator.calculate(countMatching, isMatchingBonus);
    }

    public Map<Rank, Integer> calculateAll(WinningLotto winningLotto, List<Lotto> lottoList) {
        return lottoList.stream()
                .map(lotto -> calculate(winningLotto, lotto))
                .collect(Collectors.groupingBy(
                        rank -> rank,
                        Collectors.collectingAndThen(Collectors.counting(), Long::intValue)
                ));
    }
}
