package lotto.domain.round;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lotto.config.validation.FieldValidation;
import lotto.config.validation.annotation.Length;
import lotto.domain.core.Lotto;
import lotto.domain.core.LottoRank;
import lotto.domain.input.BonusNumber;
import lotto.domain.input.WinningNumber;

public class LottoRound extends FieldValidation {

    @Length(min = 1)
    private final List<Lotto> round;

    public LottoRound(List<Lotto> round) {
        this.round = round;

        super.valid();
    }

    public int getLottoCount() {
        return round.size();
    }

    public List<LottoRank> getMatchResult(WinningNumber winningNumber, BonusNumber bonusNumber) {
        return round.stream()
                .map(lotto -> extractRank(lotto, winningNumber, bonusNumber))
                .collect(Collectors.toList());
    }

    private LottoRank extractRank(Lotto lotto, WinningNumber winningNumber, BonusNumber bonusNumber) {
        int matchCount = lotto.match(winningNumber.getNumbers());
        boolean hasBonus = lotto.match(bonusNumber) == 1;

        return findMatchedRank(matchCount, hasBonus).orElse(null);
    }

    private Optional<LottoRank> findMatchedRank(int matchCount, boolean hasBonus) {
        return Arrays.stream(LottoRank.values())
                .filter(it -> it.checkMatchCount(matchCount))
                .filter(it -> it.checkHasBonus(hasBonus))
                .findFirst();
    }

    @Override
    public String toString() {
        return round.stream()
                .map(Lotto::toString)
                .collect(Collectors.joining("\n"));
    }
}
