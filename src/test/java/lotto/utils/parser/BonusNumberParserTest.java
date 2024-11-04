package lotto.utils.parser;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatCode;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.constants.ErrorMessage;
import lotto.model.Lotto;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberParserTest {

    private static Lotto temporaryLottoNumbers;

    @BeforeAll
    static void setUp() {
        List<Integer> numbers = List.of(1, 2, 3, 4, 5, 45);
        temporaryLottoNumbers = new Lotto(numbers);
    }

    @DisplayName("1부터 45사이의 보너스 숫자가 입력된다면, 정상 작동한다.")
    @Test
    void Given_BonusNumberIsCorrect_When_ParseBonusNumber_Then_Success() {
        String bonusNumber = "6";

        assertThatCode(() -> BonusNumberParser.getBonusNumber(temporaryLottoNumbers, bonusNumber))
                .doesNotThrowAnyException();
    }

    @DisplayName("정수 범위가 아닌 보너스 숫자가 입력된다면, 예외가 발생한다.")
    @Test
    void Given_BonusNumberIsNotIntegerRange_When_ParseBonusNumber_Then_Error() {
        String bonusNumber = "2147483648";

        assertThatThrownBy(() -> BonusNumberParser.getBonusNumber(temporaryLottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ONLY_INTEGER_RANGE_BONUS_NUMBER_ALLOWED.getMessage());
    }

    @DisplayName("1부터 45사이가 아닌 보너스 숫자가 입력된다면, 예외가 발생한다.")
    @Test
    void Given_BonusNumberIsNotLottoRange_When_ParseBonusNumber_Then_Error() {
        String bonusNumber = "46";

        assertThatThrownBy(() -> BonusNumberParser.getBonusNumber(temporaryLottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INPUT_BONUS_NUMBER_OUT_OF_RANGE.getMessage());
    }

    @DisplayName("당첨 로또 번호와 중복된 보너스 숫자가 입력된다면, 예외가 발생한다.")
    @Test
    void Given_BonusNumberIsDuplicatedNumber_When_ParseBonusNumber_Then_Error() {
        String bonusNumber = "1";

        assertThatThrownBy(() -> BonusNumberParser.getBonusNumber(temporaryLottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.CANT_DUPLICATED_BONUS_NUMBER_WITH_WINNING_NUMBERS.getMessage());
    }
}