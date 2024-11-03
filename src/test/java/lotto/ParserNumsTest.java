package lotto;
import lotto.util.ParserNums;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ParserNumsTest {

    @Test
    @DisplayName("당첨 번호가 빈 문자열로 입력된 경우 예외가 발생한다.")
    void emptyNumber() {
        // given
        ParserNums parserNums = new ParserNums();

        // when & then
        assertThatThrownBy(() -> parserNums.parsingWinningNums(""))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("쉼표(,)가 아닌 다른 문자가 포함된 경우")
    void containNotComma() {
        // given
        ParserNums parserNums = new ParserNums();

        // when & then
        assertThatThrownBy(() -> parserNums.parsingWinningNums("1,2,3,4,5!6"))
                .isInstanceOf(IllegalArgumentException.class);
    }

}