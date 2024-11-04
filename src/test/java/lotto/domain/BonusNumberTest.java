package lotto.domain;

import static lotto.constant.ErrorMessage.BONUS_NUMBER_DUPLICATE_MESSAGE;
import static lotto.constant.ErrorMessage.BONUS_NUMBER_RANGE_ERROR_MESSAGE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BonusNumberTest {
    private final List<Integer> ticket = List.of(1, 2, 3, 4, 5, 6);

    @ParameterizedTest
    @CsvSource(value = {"0", "46"})
    @DisplayName("보너스 번호가 1보다 작거나 45보다 크면 예외가 발생한다")
    void winningLottoInitErrorTest(String outOfRangeNumber) {
        assertThatThrownBy(() -> BonusNumber.of(Integer.parseInt(outOfRangeNumber), ticket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(String.format(BONUS_NUMBER_RANGE_ERROR_MESSAGE.getMessage(), 1, 45));
    }

    @Test
    @DisplayName("보너스 번호가 당첨로또 번호와 중복이 있다면 예외가 발생한다")
    void winningLottoDuplicateErrorTest() {
        assertThatThrownBy(() -> BonusNumber.of(1, ticket))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(BONUS_NUMBER_DUPLICATE_MESSAGE.getMessage());
    }

}