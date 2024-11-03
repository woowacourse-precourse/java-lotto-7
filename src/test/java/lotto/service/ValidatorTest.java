package lotto.service;

import lotto.util.ErrorCode;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    private final Validator validator = new Validator();

    @Test
    void 구입금액_검사() {
        // given
        String money = "1000";

        // when
        int result = validator.validateMoney(money);

        // then
        assertThat(result).isEqualTo(1000);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcd", "100001", "2001"})
    void 구입금액_검사_오류(String money) {
        // when & then
        assertThatThrownBy(() -> validator.validateMoney(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALD_PURCHASE_AMOUNT.getMessage());
    }

    @Test
    void 당첨_번호_검사() {
        // given
        String winningNumbers = "1,2,3,4,5,6";

        // when
        validator.validateWinningNumbers(winningNumbers);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2", "1,A,3,4,5,6", "1,2,3,4,5,5"})
    void 당첨_번호_검사_오류(String winningNumbers) {
        // when & then
        assertThatThrownBy(() -> validator.validateWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_WINNING_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호_검사() {
        // given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);
        String bonusNumber = "15";

        // when
        validator.validateBonusNumber(winningNumbers, bonusNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"46", "abcd"})
    void 보너스_번호_검사_오류(String bonusNumber) {
        // given
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThatThrownBy(() -> validator.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.INVALID_BONUS_NUMBER.getMessage());
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복() {
        // given
        String bonusNumber = "1";
        List<Integer> winningNumbers = List.of(1,2,3,4,5,6);

        // when & then
        assertThatThrownBy(() -> validator.validateBonusNumber(winningNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorCode.DUPLICATE_BONUS_NUMBER.getMessage());
    }

}