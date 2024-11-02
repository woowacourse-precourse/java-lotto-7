package lotto.utils;

import static lotto.utils.Error.BONUS_NUMBER_NOT_A_NUMBER;
import static lotto.utils.Error.PURCHASE_AMOUNT_NOT_A_NUMBER;
import static lotto.utils.Error.WINNING_NUMBERS_NOT_A_NUMBER;
import static lotto.utils.Parser.parseBonusNumber;
import static lotto.utils.Parser.parsePurchaseAmount;
import static lotto.utils.Parser.parseWinningNumbers;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ParserTest {

    @Test
    void 숫자_형식의_구매_금액_파싱_기능_테스트() {
        assertThat(parsePurchaseAmount("1000")).isEqualTo(1000);
    }

    @Test
    void 숫자_형식이_아닌_구매_금액_예외_테스트() {
        assertThatThrownBy(() -> parsePurchaseAmount("sumi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(PURCHASE_AMOUNT_NOT_A_NUMBER.getDescription());
    }

    @Test
    void 숫자_형식의_당첨_번호_파싱_기능_테스트() {
        assertThat(parseWinningNumbers("1,2,3,4,5,6")).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {",1,2,3,", "a,b,c,d,e,f", ",,1,2,3,"})
    void 숫자_형식이_아닌_당첨_번호_파싱_예외_테스트(String input) {
        assertThatThrownBy(() -> parseWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(WINNING_NUMBERS_NOT_A_NUMBER.getDescription());
    }

    @Test
    void 숫자_형식의_보너스_번호_파싱_기능_테스트() {
        assertThat(parseBonusNumber("10")).isEqualTo(10);
    }

    @Test
    void 숫자_형식이_아닌_보너스_번호_예외_테스트() {
        assertThatThrownBy(() -> parseBonusNumber("sumi"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_NOT_A_NUMBER.getDescription());
    }
}
