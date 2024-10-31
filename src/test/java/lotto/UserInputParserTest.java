package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class UserInputParserTest {
    @ParameterizedTest(name = "구매금액 입력 테스트 : {0} -> {1}")
    @CsvSource({
                "'1000', 1000",
                "'5000', 5000",
                "'32000', 32000",
                "'529132000', 529132000"
            })
    void 구매금액_파서_기능_테스트(String rawInput, int expected) {
        assertEquals(expected, UserInputParser.getPurchaseCost(rawInput));
    }
    
    @ParameterizedTest(name = "구매금액 입력 테스트(예외) : {0}")
    @ValueSource(strings = {
            "숫자아님", "", "1,",
            "1", "-1", "-1000", "-3000", "0",
            "1002", "1050", "400000120"})
    void 구매금액_파서_예외_테스트(String rawInput) {
        assertThatThrownBy(() -> {
            UserInputParser.getPurchaseCost(rawInput);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("[ERROR]");
    }
}
