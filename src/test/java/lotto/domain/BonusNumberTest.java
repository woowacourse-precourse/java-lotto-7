package lotto.domain;

import lotto.model.domain.BonusNumber;
import lotto.model.domain.WinningNumbers;
import lotto.util.parser.InputParser;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    private final WinningNumbers winningNumbers = new WinningNumbers(Arrays.asList(1, 2, 3, 4, 5, 6));

    @Test
    void 보너스번호가_당첨번호와_중복될_때_예외발생() {
        assertThatThrownBy(() -> new BonusNumber(1, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"A", "&!*"})
    void 보너스번호가_숫자가_아닐_때_예외발생(String invalidBonusNumber) {

        assertThatThrownBy(() -> new BonusNumber(InputParser.parseNumber(invalidBonusNumber), winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_유효할_때_예외발생하지않음() {
        BonusNumber bonusNumber = new BonusNumber(7, winningNumbers);
        assertThat(bonusNumber.getBonusNumber()).isEqualTo(7);
    }

    @Test
    void 보너스번호가_비어있을때_예외발생() {
        assertThatThrownBy(() -> new BonusNumber(InputParser.parseNumber(""), winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호가_범위를_벗어날때_예외발생() {

        assertThatThrownBy(() -> new BonusNumber(46, winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
