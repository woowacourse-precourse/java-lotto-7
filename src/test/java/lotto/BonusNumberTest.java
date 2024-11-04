package lotto;

import lotto.exception.InputValidator;
import lotto.model.WinningNumbers;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BonusNumberTest {
    @Test
    void 보너스_번호에_숫자가_아닌_문자를_입력한_경우() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("a"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_로또_번호의_숫자_범위를_벗어나는_경우() {
        assertThatThrownBy(() -> InputValidator.validateBonusNumber("126"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되는_경우() {
        assertSimpleTest(() -> {
            int bounsNumber = 3;
            WinningNumbers winningNumbers = WinningNumbers.from(List.of(3, 10, 13, 16, 17, 43));

            assertThatThrownBy(() -> InputValidator.validateUniqueBonusNumber(bounsNumber, winningNumbers))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Test
    void 유효한_보너스_번호는_예외를_발생시키지_않는다() {
        assertSimpleTest(() ->
                assertThatCode(() -> InputValidator.validateBonusNumber("32")).doesNotThrowAnyException()
        );
    }
}
