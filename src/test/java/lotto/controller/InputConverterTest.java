package lotto.controller;

import static lotto.validator.ValidatorUtils.BONUS_NUMBER_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.PRICE_ERROR_MESSAGE;
import static lotto.validator.ValidatorUtils.WINNING_NUMBER_ERROR_MESSAGE;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class InputConverterTest {

    private InputConverter inputConverter;

    @BeforeEach
    void setUp() {
        inputConverter = new InputConverter();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000", "3000", "4000"})
    void 구입금액_숫자_입력(String price) {
        assertThatCode(() -> inputConverter.convertPrice(price))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", "", "!@#$%", "   "})
    void 구입금액_숫자_외_입력(String price) {
        assertThatThrownBy(() -> inputConverter.convertPrice(price))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PRICE_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "7,8,9,10,11,12"})
    void 당첨번호_숫자_입력(String winningNumber) {
        assertThatCode(() -> inputConverter.convertWinningNumber(winningNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,hello,4,5,6", "1,2,!@#$%,4,5,6", "1,2,,4,5,6", "1,2,  ,4,5,6"})
    void 당첨번호_숫자_외_입력(String winningNumber) {
        assertThatThrownBy(() -> inputConverter.convertWinningNumber(winningNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBER_ERROR_MESSAGE);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "2", "3"})
    void 보너스번호_숫자_입력(String bonusNumber) {
        assertThatCode(() -> inputConverter.convertBonusNumber(bonusNumber))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings = {"hello", " ", "", "!@#"})
    void 보너스번호_숫자_외_입력(String bonusNumber) {
        assertThatThrownBy(() -> inputConverter.convertBonusNumber(bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_ERROR_MESSAGE);
    }
}
