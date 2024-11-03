package lotto.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberParserTest {

    private InputValidator inputValidator;
    private LottoNumberParser lottoNumberParser;

    @BeforeEach
    void setUp() {
        inputValidator= new InputValidator();
        lottoNumberParser = new LottoNumberParser(inputValidator);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5,47", "0,2,3,4,5,7", "-1,2,3,4,5,7"})
    void 당첨_번호에_범위_외의_숫자가_있으면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1.5,2,3,4,5,7", "7.0,2,3,4,5,6", "22.98,2,3,4,5,7"})
    void 당첨_번호에_정수가_아닌_숫자가_있으면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1:2,3,4,5:7", "2 3 4 6 7 10"})
    void 당첨_번호를_입력할_때_쉼표_이외의_구분자가_있으면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,,2,3,4,5,7", ",2, 3, 4, 6, 7, 10", "1,2,3,4,5,7,"})
    void 당첨_번호를_입력할_때_쉼표가_숫자와_숫자_사이가_아니면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"일,이,삼,사,오,육", "1,000,2, 3, 4, 6, 7, 10", "^1,2,3,4,5,7,"})
    void 당첨_번호에_숫자만_입력되지_않으면_예외가_발생한다(String input) {
        예외_실행(input);
    }


    @ParameterizedTest
    @ValueSource(strings = {" ", "\n"})
    void 당첨_번호를_입력이_비어있으면_예외가_발생한다(String input) {
        예외_실행(input);
    }


    void 예외_실행(String input) {
        assertThatThrownBy(() -> lottoNumberParser.parse(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}