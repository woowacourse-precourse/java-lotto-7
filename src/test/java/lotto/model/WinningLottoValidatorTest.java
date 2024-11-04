package lotto.model;

import static lotto.common.ConstantsForTest.END_INCLUSIVE;
import static lotto.common.ConstantsForTest.START_INCLUSIVE;
import static lotto.common.ConstantsForTest.VALID_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import lotto.model.ErrorMessages.Lotto;
import lotto.model.lotto.WinningLottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningLottoValidatorTest {
    private List<Integer> validWinningNumbers;

    @BeforeEach
    void setUp() {
        validWinningNumbers = createValidWinningNumbers();
    }

    @Test
    @DisplayName("보너스 번호와 당첨 번호가 중복되는 경우 예외를 던진다.")
    void throwExceptionWhenBonusNumberAndWinningNumbersAreDuplicated() {
        // given
        int bonusNumber = validWinningNumbers.getFirst();

        // when & then
        assertThatThrownBy(() -> WinningLottoValidator.validate(validWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.DUPLICATED);
    }

    @Test
    @DisplayName("보너스 번호가 잘못된 범위의 숫자를 포함하는 경우 예외를 던진다.")
    void throwExceptionWhenRangeOfBonusNumberIsInvalid() {
        // given
        int bonusNumber = END_INCLUSIVE + 1;

        // when & then
        assertThatThrownBy(() -> WinningLottoValidator.validate(validWinningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Lotto.INVALID_RANGE);
    }


    private List<Integer> createValidWinningNumbers() {
        List<Integer> numbers = new ArrayList<>();
        for (int i = 0; i < VALID_SIZE; i++) {
            numbers.add(START_INCLUSIVE + i);
        }
        return numbers;
    }


}
