package lotto.view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    private static final String ERROR_NOT_DIVISIBLE_BY_1000 = "[ERROR] 구입 금액은 1,000으로 나누어 떨어져야 합니다.";
    private static final String ERROR_NOT_NEGATIVE_PURCHASE_NUMBER = "[ERROR] 구입 금액은 양수여야 합니다.";
    private static final String ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 총 6개 입력되어야 합니다.";
    private static final String ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE =
            "[ERROR] 당첨 번호는 중복되지 않은 서로 다른 6개의 숫자가 입력 되어야 합니다.";
    private static final String ERROR_OUT_OF_RANGE_BONUS_NUMBER_MESSAGE =
            "[ERROR] 보너스 번호는 1에서 45 사이의 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE =
            "[ERROR] 보너스 번호는 당첨 번호와 중복되지 않은 숫자가 입력 되어야 합니다.";

    @Test
    public void 구입_금액이_1000으로_나누어_떨어지지_않으면_예외_발생() {
        // given
        int input = 1200;

        // when & then
        Assertions.assertThatThrownBy(() -> Validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_DIVISIBLE_BY_1000);
    }

    @Test
    public void 구입_금액이_음수일_경우_예외_발생() {
        // given
        int input = -1;

        // when & then
        Assertions.assertThatThrownBy(() -> Validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NOT_NEGATIVE_PURCHASE_NUMBER);
    }

    @Test
    public void 당첨_번호의_총_개수가_6이_아니면_예외_발생() {
        // given
        List<Integer> input = List.of(1, 2, 3, 4, 5, 6, 7);

        // when & then
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_COUNT_IS_NOT_6_WINNING_NUMBER_MESSAGE);
    }

    @Test
    public void 당첨_번호가_1에서_45_사이의_숫자가_아니면_예외_발생() {
        // given
        List<Integer> input = List.of(1, 2, 3, 4, 5, 46);

        // when & then
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_OUT_OF_RANGE_WINNING_NUMBER_MESSAGE);
    }

    @Test
    public void 당첨_번호에_중복된_숫자가_존재하면_예외_발생() {
        // given
        List<Integer> input = List.of(1, 1, 3, 4, 5, 45);

        // when & then
        Assertions.assertThatThrownBy(() -> Validator.validateWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE_WINNING_NUMBER_MESSAGE);
    }

    @Test
    public void 보너스_번호가_1에서_45_사이의_숫자가_아니면_예외_발생() {
        // given
        int input = 46;

        // when & then
        Assertions.assertThatThrownBy(() -> Validator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_OUT_OF_RANGE_BONUS_NUMBER_MESSAGE);
    }

    @Test
    public void 당첨_번호와_보너스_번호에_중복된_숫자가_존재하면_예외_발생() {
        // given
        List<Integer> winningNumbers = List.of(1, 2, 3, 4, 5, 45);
        int bonusNumber = 1;

        // when & then
        Assertions.assertThatThrownBy(() -> Validator.validateDuplicateWith(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_DUPLICATE_WINNING_NUMBER_AND_BONUS_NUMBER_MESSAGE);
    }
}
