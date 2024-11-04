package lotto.validator;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoNumberValidatorTest {

    @Test
    void 유효하지_않은_정수_예외_발생() {
        List<String> invalidTokens = List.of("1", "abc", "45");

        assertThatThrownBy(() -> LottoNumberValidator.validateIntegers(invalidTokens))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }
    
    @Test
    void 유효하지_않은_범위_예외_발생() {
        int invalidLow = 0;
        int invalidHigh = 46;

        assertThatThrownBy(() -> LottoNumberValidator.validateNumberRange(invalidLow))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");

        assertThatThrownBy(() -> LottoNumberValidator.validateNumberRange(invalidHigh))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 보너스번호_당첨번호_중복_예외_발생() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int duplicatedBonusNumber = 5;

        assertThatThrownBy(() -> LottoNumberValidator.validateDuplicatedBonusNumber(winningNumbers, duplicatedBonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR]");
    }

    @Test
    void 유효_보너스_번호_정상() {
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 6);
        int validBonusNumber = 7;

        LottoNumberValidator.validateDuplicatedBonusNumber(winningNumbers, validBonusNumber);
    }
}