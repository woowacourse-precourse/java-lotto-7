package lotto.view;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ParserTest {

    private static final String ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE = "[ERROR] 당첨 번호는 숫자로 이루어져 있어야 합니다.";
    private static final String ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE = "[ERROR] 보너스 번호는 숫자로 이루어져 있어야 합니다.";

    @Test
    public void 구입_금액이_1000으로_나누어_떨어지면_정상() {
        // given
        String input = "1000";
        int result = 1000;

        // when
        int purchaseAmount = Parser.parsePurchaseAmount(input);

        // then
        Assertions.assertThat(purchaseAmount).isEqualTo(result);
    }

    @Test
    public void 당첨_번호가_숫자가_아니면_예외_발생() {
        // given
        String input = "문자,2,3,4,5,6";

        // when & then
        Assertions.assertThatThrownBy(() -> Parser.parseWinningNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NON_NUMERIC_WINNING_NUMBER_MESSAGE);
    }

    @Test
    public void 당첨_번호가_6개의_1에서_45_사이의_숫자라면_정상() {
        // given
        String input = "1,2,3,43,44,45";
        List<Integer> result = List.of(1, 2, 3, 43, 44, 45);

        // when
        List<Integer> integers = Parser.parseWinningNumber(input);

        // then
        Assertions.assertThat(integers).isEqualTo(result);
    }

    @Test
    public void 보너스_번호가_숫자가_아니면_예외_발생() {
        // given
        String input = "문자";

        // when & then
        Assertions.assertThatThrownBy(() -> Parser.parseBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_NON_NUMERIC_BONUS_NUMBER_MESSAGE);
    }
}
