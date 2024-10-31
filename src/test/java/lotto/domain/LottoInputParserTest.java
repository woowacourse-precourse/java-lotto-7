package lotto.domain;

import lotto.ui.exception.InputException;
import lotto.ui.parser.InputParser;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoInputParserTest {

    private final InputParser inputParser = new InputParser();

    @Test
    void 입력받은_정답_숫자의_구분자가_쉼표가_아닌경우_에러처리() {
        // given
        final String winningNumberInput = "1.2.3.4.5.6";

        // when & then
        assertThatThrownBy(() -> {
            inputParser.inputToWinningNumbers(winningNumberInput);
        }).isInstanceOf(InputException.class);
    }

    @Test
    void 입력받은_정답_숫자의_구분자가_쉼표라면_성공() {
        // given
        final String winningNumberInput = "1,2,3,4,5,6";

        // when
        final List<Integer> winningNumbers = inputParser.inputToWinningNumbers(winningNumberInput);

        // then
        assertThat(winningNumbers.stream().mapToInt(Integer::intValue).sum()).isEqualTo(21);
    }
}