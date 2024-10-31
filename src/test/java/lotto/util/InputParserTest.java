package lotto.util;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputParserTest {

    @Test
    void 금액_파싱_테스트() {
        String money = "12300";

        assertThat(InputParser.parseMoney(money)).isEqualTo(12300);
    }

    @ParameterizedTest
    @ValueSource(strings = {"abcde"})
    void 금액_파싱_예외_테스트(String money) {
        assertThatThrownBy(() -> InputParser.parseMoney(money)).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,6", "1, 2, 3, 4, 5, 6"})
    void 당첨번호_파싱_테스트(String numbers) {
        assertThat(InputParser.parseNumbers(numbers)).isEqualTo(List.of(1, 2, 3, 4, 5, 6));
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,a", ",1,2,3,4,5,6", "1,2,3,4,5,6,"})
    void 당첨번호_파싱_예외_테스트(String numbers) {
        assertThatThrownBy(() -> InputParser.parseNumbers(numbers)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_파싱_테스트() {
        String bonusNumber = "7";

        assertThat(InputParser.parseBonusNumber(bonusNumber)).isEqualTo(7);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,", ",1", "a"})
    void 보너스번호_파싱_예외_테스트(String number) {
        assertThatThrownBy(() -> InputParser.parseBonusNumber(number)).isInstanceOf(IllegalArgumentException.class);
    }

}