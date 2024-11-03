package lotto.model.win;

import static lotto.config.SystemConfig.DOMAIN_END;
import static lotto.config.SystemConfig.DOMAIN_START;

import java.util.List;
import lotto.config.ErrorMessage;
import lotto.config.PrizeCondition;
import lotto.exception.LottoException;
import lotto.model.Lotto;

public class WinningNumbers {

    private final Lotto lotto;
    private final int bonusNumber;

    public WinningNumbers(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
        validateBonus();
    }

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.lotto = new Lotto(numbers);
        this.bonusNumber = bonusNumber;
        validateBonus();
    }

    private boolean isOutOfDomain(int bonusNumber) {
        return bonusNumber < DOMAIN_START || bonusNumber > DOMAIN_END;
    }

    private void validateBonus() {
        if (isOutOfDomain(bonusNumber)) {
            throw new LottoException(ErrorMessage.DOMAIN);
        }

        if (lotto.contains(bonusNumber)) {
            throw new LottoException(ErrorMessage.DUPLICATE);
        }
    }

    public Prize compare(Lotto others) {
        Prize prize = switch (lotto.subtract(others)) {
            case PrizeCondition.FIFTH -> Prize.FIFTH;
            case PrizeCondition.FOURTH -> Prize.FOURTH;
            case PrizeCondition.SECOND -> Prize.THIRD;
            case PrizeCondition.WIN -> Prize.WIN;
            default -> Prize.NOTHING;
        };

        if (prize == Prize.THIRD && others.contains(bonusNumber)) {
            prize = Prize.SECOND;
        }

        return prize;
    }
}
