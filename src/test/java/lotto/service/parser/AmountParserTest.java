package lotto.service.parser;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class AmountParserTest {

    @DisplayName("기본 검증을 통과한 문자열을 넘겨주면 amount를 추출해 검증하여 반환합니다")
    @ParameterizedTest
    @CsvSource({
            "2000 ,2000",
            " 40000,40000",
            "8000,8000"
    })
    void 로또_구입_금액_추출(String input, int expected) {
        int amount = AmountParser.parseAmount(input);
        Assertions.assertThat(amount).isEqualTo(expected);
    }
}