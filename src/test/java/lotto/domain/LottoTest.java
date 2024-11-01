package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.util.enums.ValidateMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
    static final List<Integer> MORE_THAN_SIX_SIZE_NUMBERS = List.of(1, 2, 3, 4, 5, 6, 7);
    static final List<Integer> DUPLICATE_NUMBERS = List.of(1, 2, 3, 4, 5, 5);
    static final List<Integer> MORE_THAN_FIFTY_FIVE_NUMBERS = List.of(1, 2, 3, 4, 5, 67);
    static final List<Integer> EQUAL_ZERO_NUMBERS = List.of(1, 2, 3, 4, 5, 0);
    static final List<Integer> LESS_THAN_ZERO_NUMBERS = List.of(1, 2, 3, 4, 5, -1);

    @Test
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    void lottoNumberSizeTest() {
        assertThatThrownBy(() -> new Lotto(MORE_THAN_SIX_SIZE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateMessage.NUMBER_SIZE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void lottoNumberDuplicateTest() {
        assertThatThrownBy(() -> new Lotto(DUPLICATE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateMessage.DUPLICATE_ERROR.getMessage());
    }

    @DisplayName("로또 번호 숫자가 45가 넘으면 예외가 발생한다.")
    @Test
    void lottoNumberOverFiftyFiveTest() {
        assertThatThrownBy(() -> new Lotto(MORE_THAN_FIFTY_FIVE_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateMessage.NUMBER_RANGE_ERROR.getMessage());
    }

    @DisplayName("로또 번호가 0이면 예외가 발생한다.")
    @Test
    void lottoNumberEqualZeroTest() {
        assertThatThrownBy(() -> new Lotto(EQUAL_ZERO_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateMessage.POSITIVE_NUMBER_ERROR.getMessage());
    }

    @DisplayName("로또 번호가 음수이면 예외가 발생한다.")
    @Test
    void lottoNumberLessThanZeroTest() {
        assertThatThrownBy(() -> new Lotto(LESS_THAN_ZERO_NUMBERS))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ValidateMessage.POSITIVE_NUMBER_ERROR.getMessage());
    }
}
