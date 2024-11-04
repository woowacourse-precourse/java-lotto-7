package lotto.model.service.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class NumberParserTest {

    @Test
    void 당첨번호_공백_제거_테스트() {
        // given
        String winningNumbers = " 1 ,  2 , 3 , 4 , 5 , 6 ";

        // when
        List<Integer> parsedNumbers = NumberParser.parseWinningNumbers(winningNumbers);

        // then
        assertThat(parsedNumbers).containsExactly(1, 2, 3, 4, 5, 6);
    }

    @Test
    void 잘못된_형식의_당첨번호_예외처리_테스트() {
        // given
        String winningNumbers = "1, 2, 3, abc, 5, 6";

        // when / then
        assertThatThrownBy(() -> NumberParser.parseWinningNumbers(winningNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 잘못된_형식의_보너스번호_예외처리_테스트() {
        // given
        String invalidBonusNumber = "abc";

        // when / then
        assertThatThrownBy(() -> NumberParser.parseBonusNumber(invalidBonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}