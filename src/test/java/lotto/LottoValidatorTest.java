package lotto;

import org.junit.jupiter.api.Test;

import java.util.List;

import static lotto.LottoValidator.validateBonusNumber;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @Test
    void 로또_번호와_보너스_번호가_중복되면_예외가_발생한다() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicateBonusNumber = 3;

        assertThatThrownBy(() -> validateBonusNumber(duplicateBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);

    }

}