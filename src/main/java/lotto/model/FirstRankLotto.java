package lotto.model;

import java.util.List;
import lotto.validator.FirstRankLottoValidator;

public class FirstRankLotto extends Lotto {

    private static final FirstRankLottoValidator FIRST_RANK_LOTTO_VALIDATOR = new FirstRankLottoValidator();

    private final int bonusNumber;

    public FirstRankLotto(List<Integer> numbers, int bonusNumber) {
        super(numbers);
        FIRST_RANK_LOTTO_VALIDATOR.validateBonusNumber(numbers, bonusNumber);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
