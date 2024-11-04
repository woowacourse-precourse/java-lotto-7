package lotto;

import lotto.model.ErrorMessage;
import lotto.model.lottoprice.LottoPriceValidator;
import lotto.model.bonusnumber.BonusNumberValidator;
import lotto.model.winningnumbers.WinningNumbersValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ExecpttionTest {

    private final LottoPriceValidator lottoPriceValidator = new LottoPriceValidator();
    private final BonusNumberValidator bonusNumberValidator = new BonusNumberValidator();
    private final WinningNumbersValidator winningNumbersValidator = new WinningNumbersValidator();

    @DisplayName("금액을 입력 시 빈 입력을 받으면 빈 입력 오류 메시지가 반환된다.")
    @Test
    void 금액을_입력_시_빈_입력을_받으면_오류_메시지가_반환된다() {
        String result = lottoPriceValidator.validate("\n");
        assertThat(result).isEqualTo(ErrorMessage.EMPTY_INPUT.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("금액을 입력 시 음수를 입력 받으면 음수 오류 메시지가 반환된다.")
    @Test
    void 금액을_입력_시_음수_입력을_받으면_오류_메시지가_반환된다() {
        String result = lottoPriceValidator.validate("-1000");
        assertThat(result).isEqualTo(ErrorMessage.NEGATIVE_INPUT.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("금액을 입력 시 1000으로 나누어 떨어지지 않으면 나누기 오류 메시지가 반환된다.")
    @Test
    void 금액을_입력_시_1000으로_나누어_떨어지지_않으면_오류_메시지가_반환된다() {
        String result = lottoPriceValidator.validate("1500");
        assertThat(result).isEqualTo(ErrorMessage.MULTIPLE_INPUT.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("당첨 번호를 입력 시 빈 입력을 받으면 빈 입력 오류 메시지가 반환된다.")
    @Test
    void 당첨_번호를_입력_시_빈_입력을_받으면_오류_메시지가_반환된다() {
        String result = winningNumbersValidator.validate("");
        assertThat(result).isEqualTo(ErrorMessage.EMPTY_INPUT.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("당첨 번호를 입력 시 중복된 번호를 입력 받으면 중복 오류 메시지가 반환된다.")
    @Test
    void 당첨_번호를_입력_시_중복된_번호를_입력_받으면_오류_메시지가_반환된다() {
        String result = winningNumbersValidator.validate("1,2,3,4,5,5");
        assertThat(result).isEqualTo(ErrorMessage.DUPLICATE_WINNING_NUMBERS.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("당첨 번호를 입력 시 6개의 번호가 아닌 경우 개수 오류 메시지가 반환된다.")
    @Test
    void 당첨_번호를_입력_시_6개의_번호가_아니면_오류_메시지가_반환된다() {
        String result = winningNumbersValidator.validate("1,2,3,4,5");
        assertThat(result).isEqualTo(ErrorMessage.INVALID_COUNT.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("당첨 번호를 입력 시 1과 45 사이의 숫자가 아닐 때 범위 오류 메시지가 반환된다.")
    @Test
    void 당첨_번호를_입력_시_1과_45_사이의_번호가_아니면_오류_메시지가_반환된다() {
        String result = winningNumbersValidator.validate("1,2,3,4,5,46");
        assertThat(result).isEqualTo(ErrorMessage.INVALID_WINNING_NUMBER.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("보너스 번호를 입력 시 1과 45 사이의 숫자가 아닐 때 범위 오류 메시지가 반환된다.")
    @Test
    void 보너스_번호를_입력_시_1과_45사이의_번호가_아니면_오류_메시지가_반환된다() {
        String result = bonusNumberValidator.validate("50", List.of(1, 2, 3, 4, 5, 6));
        assertThat(result).isEqualTo(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }

    @DisplayName("보너스 번호를 입력 시 중복된 번호가 입력될 때 중복 오류 메시지가 반환된다.")
    @Test
    void 보너스_번호를_입력_시_중복된_번호가_입력될_때_오류_메시지가_반환된다() {
        String result = bonusNumberValidator.validate("3", List.of(1, 2, 3, 4, 5, 6));
        assertThat(result).isEqualTo(ErrorMessage.DUPLICATE_BONUS_NUMBER.getMessage());
        assertThat(result).startsWith("[ERROR]");
    }
}
