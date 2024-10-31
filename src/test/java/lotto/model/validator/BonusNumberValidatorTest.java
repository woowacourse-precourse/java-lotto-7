package lotto.model.validator;

import static lotto.exception.InvalidLottoNumberException.OUT_OF_RANGE_BONUS_NUMBER;
import static lotto.util.LottoConstants.LOTTO_NUMBER_MAX;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import lotto.util.LottoConstants;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {
    @Test
    void 보너스_번호가_모두_유효한_범위에_있으면_예외가_발생하지_않는다() {
        List<Integer> winNumbers = List.of(2, 3, 4, 5, 6, 7);

        BonusNumberValidator validator = new BonusNumberValidator(LottoConstants.LOTTO_NUMBER_MIN, winNumbers);

        assertDoesNotThrow(validator::validate);
    }

    @Test
    void 보너스_번호가_유효한_범위를_벗어나면_예외가_발생한다() {
        int outOfRangeBonusNumber = LOTTO_NUMBER_MAX + 1;
        List<Integer> winNumbers = List.of(2, 3, 4, 5, 6, 7);

        BonusNumberValidator validator = new BonusNumberValidator(outOfRangeBonusNumber, winNumbers);

        assertThatThrownBy(validator::validate)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(OUT_OF_RANGE_BONUS_NUMBER);
    }
}