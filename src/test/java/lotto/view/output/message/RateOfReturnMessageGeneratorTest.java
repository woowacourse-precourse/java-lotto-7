package lotto.view.output.message;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@SuppressWarnings("NonAsciiCharacters")
class RateOfReturnMessageGeneratorTest {

    RateOfReturnMessageGenerator rateOfReturnMessageGenerator = new RateOfReturnMessageGenerator();

    @CsvSource(textBlock = """
            10.04, 총 수익률은 10.0%입니다.
            10.05, 총 수익률은 10.1%입니다.
            1000, '총 수익률은 1,000.0%입니다.'
            """)
    @ParameterizedTest
    void 수익률_메세지를_생성할_수_있다(double rateOfReturn, String expected) {
        // when
        String message = rateOfReturnMessageGenerator.getMessage(rateOfReturn);

        // then
        assertThat(message).isEqualTo(expected);
    }

}
