package lotto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
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
        assertEquals(expected, UserInputParser.getParsedInput(rawInput, UserInputType.PURCHASE_COST));
    }
    
    @ParameterizedTest(name = "구매금액 입력 테스트(예외) : {0}")
    @ValueSource(strings = {
            "숫자아님", "", "1,",
            "1", "-1", "-1000", "-3000", "0",
            "1002", "1050", "400000120"})
    void 구매금액_파서_예외_테스트(String rawInput) {
        assertThatThrownBy(() -> {
            UserInputParser.getParsedInput(rawInput, UserInputType.PURCHASE_COST);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("[ERROR]");
    }
    
    static Stream<Arguments> 당첨번호_테스트값_생성() {
        return Stream.of(
                    Arguments.of("1,2,3,4,5,6", List.of(1,2,3,4,5,6)),
                    Arguments.of("6,5,4,3,2,1", List.of(1,2,3,4,5,6)),
                    Arguments.of("45,12,41,24,17,6", List.of(6,12,17,24,41,45)),
                    Arguments.of("13,1,45,30,21,40", List.of(1,13,21,30,40,45))
                );
    }

    @ParameterizedTest(name = "당첨번호 입력 테스트 : {0} -> {1}")
    @MethodSource("당첨번호_테스트값_생성")
    void 당첨번호_파서_기능_테스트(String rawInput, List<Integer> expected) {
        assertThat((List<Integer>)UserInputParser.getParsedInput(rawInput, UserInputType.WINNING_NUMBERS))
                .containsExactlyElementsOf(expected);
    }
    
    @ParameterizedTest(name = "당첨번호 입력 테스트(예외) : {0}")
    @ValueSource(strings = {
                "",
                "12",
                "숫자아님",
                "1,2,3,숫자,5",
                "1,2,3,4,5",
                "-1,2,3,4,5,6",
                "46,1,2,3,4,5",
                "1,2,3,4,5,6,7",
                "1,1,1,1,1,1"
            })
    void 당첨번호_파서_예외_테스트(String rawInput) {
        assertThatThrownBy(() -> {
            UserInputParser.getParsedInput(rawInput, UserInputType.WINNING_NUMBERS);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("[ERROR]");
    }
    
    @ParameterizedTest(name = "보너스 번호 입력 테스트 : {0}")
    @CsvSource({
                "1, 1",
                "45, 45",
                "12, 12",
                "30, 30"
            })
    void 보너스번호_파서_기능_테스트(String rawInput, int expected) {
        assertEquals(expected, UserInputParser.getParsedInput(rawInput, UserInputType.BONUS_NUMBER));
    }

    @ParameterizedTest(name = "보너스 번호 입력 테스트(예외) : {0}")
    @ValueSource(strings = {
                "",
                "0",
                "46",
                "-12",
                "30, 30",
                "숫자"
            })
    void 보너스번호_파서_예외_테스트(String rawInput) {
        assertThatThrownBy(() -> {
            UserInputParser.getParsedInput(rawInput, UserInputType.BONUS_NUMBER);
        })
        .isInstanceOf(IllegalArgumentException.class)
        .hasMessageStartingWith("[ERROR]");
    }
}
