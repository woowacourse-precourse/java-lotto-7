package lotto.model.validator.lotto;

import static lotto.exception.InvalidLottoNumberException.DUPLICATE_BONUS_NUMBER;
import static lotto.exception.InvalidLottoNumberException.OUT_OF_RANGE_BONUS_NUMBER;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.model.validator.lotto.BonusNumberValidator;
import lotto.util.LottoConstants;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest extends ValidatorTestBase {
    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외가_발생한다() {
        int duplicateBonusNumber = 5;
        List<Integer> winNumbers = List.of(2, 3, 4, 5, 6, 7);
        BonusNumberValidator validator = new BonusNumberValidator(duplicateBonusNumber, winNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(DUPLICATE_BONUS_NUMBER);
    }

    @Override
    protected BaseNumberValidator createValidator(List<Integer> winNumbers, Integer bonusNumber) {
        return new BonusNumberValidator(bonusNumber, winNumbers);
    }
}