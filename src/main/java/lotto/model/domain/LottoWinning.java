package lotto.model.domain;

import static lotto.ui.error.LottoError.DUPLICATE_BONUS_NUMBER_ERR;

import java.util.List;
import java.util.Objects;
import java.util.Set;

public class LottoWinning extends Lotto {
    private final BonusNumber bonusNumber;

    public LottoWinning(List<Integer> numbers, BonusNumber bonusNumber) {
        super(numbers);
        validateDuplicateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoPrizes getLottoPrizes(Lottos lottos) {
        List<LottoPrize> prizes = lottos.get()
                .stream()
                .map(lotto -> getPrizeIfWinner(lotto))
                .filter(Objects::nonNull)
                .toList();
        return new LottoPrizes(prizes);
    }

    private LottoPrize getPrizeIfWinner(Lotto lotto) {
        Set<Integer> lottoNumberTempSet = lotto.getTempSet();

        boolean isBonusCorrect = lottoNumberTempSet.contains(bonusNumber.get());
        lottoNumberTempSet.retainAll(this.getTempSet());

        return LottoPrize.findBy(lottoNumberTempSet.size(), isBonusCorrect);
    }

    private void validateDuplicateBonusNumber(List<Integer> numbers, BonusNumber bonusNumber) {
        if (numbers.contains(bonusNumber.get())) {
            throw new IllegalArgumentException(DUPLICATE_BONUS_NUMBER_ERR);
        }
    }

}
