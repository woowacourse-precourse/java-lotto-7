package lotto;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class InputParserTest {

    @DisplayName("InputParser는_문자열을_정수로_변환할_수_있다")
    @Test
    public void parseInt() {
        //given
        String input = "23";

        //when
        int result = InputParser.parseInt(input);

        //then
        assertThat(result).isEqualTo(23);
    }

    @DisplayName("InputParser는_당첨번호_문자열을_분리하여_정수_리스트로_변환할_수_있다")
    @Test
    public void parseWinningNumber() {
        //given
        String input = "1,2,3,4,5";

        //when
        List<Integer> result = InputParser.parseWinningNumbers(input);

        //then
        assertThat(result).contains(1, 2, 3, 4, 5);
    }
}