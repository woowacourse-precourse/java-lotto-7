package lotto;

import lotto.exception.InputValidation;
import lotto.exception.ValidateValues;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InputValidationTest {

    @DisplayName("입력값(금액, 당첨번호, 보너스번호)이 빈 칸이면 예외가 발생한다.")
    @Test
    void 입력값이_빈_칸인지_확인한다() {
        assertThat(InputValidation.NOT_BLANK.validate("")).isFalse();
    }

    @DisplayName("입력값(금액, 당첨번호, 보너스번호)이 숫자가 아니면 예외가 발생한다.")
    @Test
    void 입력값이_숫자인지_확인한다() {
        assertThat(InputValidation.NOT_NUMBER.validate("a")).isFalse();
    }

    @DisplayName("입력값(금액, 당첨번호, 보너스번호)이 정수가 아니면 예외가 발생한다.")
    @Test
    void 입력값이_정수가_아니면_예외가_발생한다() {
        assertThat(InputValidation.NOT_INTEGER.validate("1.1")).isFalse();
    }

    @DisplayName("로또 구입 금액이 1000으로 나누어떨어지지 않으면 예외가 발생한다.")
    @Test
    void 로또_구입_금액이_1000으로_나누어떨어지지_않으면_예외가_발생한다() {
        assertThat(InputValidation.NOT_DIVISIBLE_BY_1000.validate("100")).isFalse();
    }

    @Test
    void 당첨번호_또는_보너스번호를_검증하고_불린형으로_리턴한다() {
        boolean rangeCheck1 = ValidateValues.winningNumberOrBonusNumber("0");
        assertThat(rangeCheck1).isEqualTo(false);
        boolean rangeCheck2 = ValidateValues.winningNumberOrBonusNumber("1");
        assertThat(rangeCheck2).isEqualTo(true);

        boolean notNumberCheck1 = ValidateValues.winningNumberOrBonusNumber("a");
        assertThat(notNumberCheck1).isEqualTo(false);
        boolean notNumberCheck2 = ValidateValues.winningNumberOrBonusNumber("1");
        assertThat(notNumberCheck2).isEqualTo(true);

        boolean notIntegerCheck1 = ValidateValues.winningNumberOrBonusNumber("1.1");
        assertThat(notIntegerCheck1).isEqualTo(false);
        boolean notIntegerCheck2 = ValidateValues.winningNumberOrBonusNumber("1");
        assertThat(notIntegerCheck2).isEqualTo(true);
    }

}
