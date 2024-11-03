package lotto.validator;

import static lotto.validator.ValidatorUtils.WINNING_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WinningNumberValidatorTest {

    private WinningNumberValidator winningNumberValidator;

    @BeforeEach
    void setUp() {
        winningNumberValidator = new WinningNumberValidator();
    }

    @Test
    void 유효한_번호_검사() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 6);

        assertThatCode(() -> winningNumberValidator.validate(winningNumber))
                .doesNotThrowAnyException();
    }

    @Test
    void 유효하지_않은_번호_검사() {
        List<Integer> winningNumber = List.of(-1, 2, 3, 4, 5, 46);

        assertThatThrownBy(() -> winningNumberValidator.validate(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_번호_개수_검사() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5);
        assertThatThrownBy(() -> winningNumberValidator.validate(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_ERROR_MESSAGE);
    }

    @Test
    void 유효하지_않은_번호_범위_검사() {
        List<Integer> winningNumber = List.of(1, 2, 3, 4, 5, 46);
        assertThatThrownBy(() -> winningNumberValidator.validate(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_ERROR_MESSAGE);
    }
}
