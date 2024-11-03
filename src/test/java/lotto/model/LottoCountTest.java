package lotto.model;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import lotto.util.InputValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoCountTest {

    private InputValidator inputValidator;

    @BeforeEach
    void setUp() {
        inputValidator = new InputValidator();
    }

    @ParameterizedTest
    @ValueSource(strings = {"10001", "1897", "6600"})
    void 구매_금액에_1000으로_나누어_떨어지지_않는_숫자를_입력하면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "10", "-2000", "999.9"})
    void 구매_금액에_1000미만의_숫자를_입력하면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"100001", "123457"})
    void 최대_구매_금액을_초과하는_숫자를_입력하면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"10,000", "이천원", "1000+1000"})
    void 구매_금액에_숫자만_입력하지_않으면_예외가_발생한다(String input) {
        예외_실행(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", "\n"})
    void 구매_금액을_입력할_때_비어있으면_예외가_발생한다(String input) {
        예외_실행(input);
    }


    void 예외_실행(String input) {
        assertThatThrownBy(() -> new LottoCount(input, inputValidator))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @CsvSource(value = {"1000,1", "3000,3"})
    void 구매_금액에_맞는_로또_개수_추출_테스트(String input, int expected) {
        LottoCount lottoCount = new LottoCount(input, inputValidator);
        int purchasedLottoCount = lottoCount.getLottoCount();

        assertEquals(purchasedLottoCount, expected);
    }


}