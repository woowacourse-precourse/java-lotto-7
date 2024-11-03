package lotto.view.input.parser;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.exception.LottoApplicationException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

@SuppressWarnings("NonAsciiCharacters")
class InputStringParserTest {

    InputStringParser inputStringParser = new InputStringParser();

    @Test
    void 문자를_숫자로_변환할_수_있다() {
        // given
        String input = "1000";

        // when
        int parsed = inputStringParser.toInt(input);

        // then
        assertThat(parsed).isEqualTo(1000);
    }

    @NullAndEmptySource
    @CsvSource("1000.0")
    @ParameterizedTest
    void 정수가_아닌_숫자를_변환하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> inputStringParser.toInt(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessage("[ERROR] 정수를 입력해주세요.");
    }

    @Test
    void 문자를_숫자_리스트로_변환할_수_있다() {
        // given
        String input = "1000,2000";

        // when
        List<Integer> parsed = inputStringParser.toIntegerList(input);

        // then
        assertThat(parsed).hasSize(2)
                .containsExactly(1000, 2000);
    }

    @EmptySource
    @CsvSource("""
            '1000,test'
            '1000,'
            ',1000'
            ',,'
            """)
    @ParameterizedTest
    void 유효하지_않은_형식을_리스트로_변환하면_예외가_발생한다(String input) {
        // when & then
        assertThatThrownBy(() -> inputStringParser.toIntegerList(input))
                .isInstanceOf(LottoApplicationException.class)
                .hasMessage("[ERROR] 정수를 입력해주세요.");
    }

}
