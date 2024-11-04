package lotto;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

import lotto.winning.model.WinningNumbers;

class WinningNumberTest {
    private WinningNumbers winningNumbers = new WinningNumbers();

    @DisplayName("문자와 공백 포함한 당첨번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, k, 4, 6", "4, 6,,\\,7,9, 10"})
    void 문자_공백_당첨번호(String inputWinningNumbers) {
        assertThatThrownBy(() -> winningNumbers.getWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("범위를 벗어난 당첨번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1, 5, 7, 34, 9, 0", "5, 46, 18, 3, 5, 6"})
    void 범위_벗어난_당첨번호(String inputWinningNumbers) {
        assertThatThrownBy(() -> winningNumbers.getWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("6개가 아닌 당첨번호 입력")
    @ParameterizedTest
    @ValueSource(strings = {"1, 5, 7, 34, 9, 10, 8", "45, 34, 17, 28, 9, 6, 21, 8", "4, 5, 6", "", "1, 6, 7, 34, 21"})
    void 개수가_맞지_앉는_당첨번호(String inputWinningNumbers) {
        assertThatThrownBy(() -> winningNumbers.getWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 입력 시 0을 표기")
    @ParameterizedTest
    @ValueSource(strings = {"001, 5, 7, 34, 9, 10"})
    void 영_맨앞인_숫자_입력(String inputWinningNumbers) {
        assertThatThrownBy(() -> winningNumbers.getWinningNumbers(inputWinningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
