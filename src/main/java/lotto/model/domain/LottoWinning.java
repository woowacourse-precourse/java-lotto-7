package lotto.model.domain;

import static lotto.ui.error.LottoError.DUPLICATE_BONUS_NUMBER_ERR;

import java.util.List;
import java.util.Set;

public class LottoWinningNumbers extends Lotto {
    private final BonusNumber bonusNumber;

    public LottoWinningNumbers(List<Integer> numbers, BonusNumber bonusNumber) {
        super(numbers);
        validateDuplicateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public LottoPrizes getLottoPrizes(List<Lotto> lottos) {
        List<LottoPrize> prizes = lottos
                .stream()
                .map(lotto -> getPrizeIfWinner(lotto))
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
