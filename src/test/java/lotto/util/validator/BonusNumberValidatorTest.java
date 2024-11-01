package lotto.util.validator;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberValidatorTest {
    private final List<Integer> winningNumbers = Arrays.asList(1, 2, 3, 4, 5, 6);

    @Test
    void 보너스번호가_당첨번호와_중복될_때_예외발생() {
        String duplicateBonusNumber = "1";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(duplicateBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_유효할_때_예외발생하지않음() {
        String validBonusNumber = "7";
        BonusNumberValidator.validateBonusNumber(validBonusNumber,winningNumbers);
    }

    @Test
    void 보너스번호가_비어있을때_예외발생() {
        String emptyBonusNumber = "";

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(emptyBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_범위를_벗어날때_예외발생() {
        String outOfRangeBonusNumber = "46"; // 범위를 벗어난 보너스 번호

        assertThatThrownBy(() -> BonusNumberValidator.validateBonusNumber(outOfRangeBonusNumber, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
